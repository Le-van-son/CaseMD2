package main;

import model.DangNhap;
import model.Menu;
import model.SinhVien;
import filedocghi.FileDocGhi;
import quanlisinhvien.QuanLiDangNhap;
import quanlisinhvien.QuanLySinhVien;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        QuanLySinhVien ql = new QuanLySinhVien();
        QuanLiDangNhap dangNhapTaiKhoan = new QuanLiDangNhap();
        Pattern pattern = Pattern.compile("^[0-9]{2,}$");
        int luaChon= 0;
        do {
            System.out.println(ANSI_PURPLE_BACKGROUND + "------------------MÀN HÌNH ĐĂNG NHẬP----------------------" + ANSI_RESET);
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí");
            System.out.println("3.thoát");
            System.out.println("nhập lựa chọn");
            try{
                luaChon=sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng,nhập lại lựa chọn");
                luaChon = -1;
                sc.nextLine();
            }
            if (luaChon==1) {
                int luaChon1 = -1;
                System.out.println(ANSI_CYAN_BACKGROUND+"-------------------ĐĂNG NHẬP TÀI KHOẢN------------------"+ANSI_RESET);
                System.out.println("Nhập tài khoản: ");
                sc.nextLine();
                String ten = sc.nextLine();
                System.out.println("Nhập mật khẩu: ");
                String matKhau = sc.nextLine();
                if(dangNhapTaiKhoan.find(ten,matKhau)!=-1) {
                    System.out.println("Đăng nhập thành công");
                    int luaChon2=-1;
                    do {
                        System.out.println(ANSI_CYAN+"1.Vào trang quản lý : ");
                        System.out.println("                                     ");
                        System.out.println("2.Xem thông tin tài khoản : ");
                        System.out.println("                                     ");
                        System.out.println("3.Đăng xuất : ");
                        System.out.println("                                     ");
                        System.out.print("Nhập lựa chọn của bạn : "+ANSI_RESET);
                        System.out.println("                                     ");
                        try {
                            luaChon2 = sc.nextInt();
//      bắt ngoại lệ1
                        } catch (InputMismatchException a) {
                            System.err.println("nhập sai , trở lại menu");
                            sc.nextLine();
                        }
                        switch (luaChon2) {
                            case 1:
                                do {
                                    Menu.menu();
                                    try {
                                        System.out.println("Nhập vào lựa chọn");
                                        luaChon1 = sc.nextInt();
                                        sc.nextLine();
                                    } catch (Exception e) {
                                        System.out.println("Chỉ nhập số,mời nhập lại lựa chọn: ");
                                        sc.nextLine();
                                    }

                                    switch (luaChon1) {
                                        case 1:
                                            System.out.println("Nhập Họ Tên: ");
                                            String hoTen = sc.nextLine();
                                            System.out.println("Nhập Năm Sinh: ");
                                            int namSinh = sc.nextInt();
                                            System.out.println("Nhập Điểm Trung Bình: ");
                                            double diemTB = sc.nextDouble();
                                            SinhVien sv = new SinhVien(hoTen, namSinh, diemTB);
                                            ql.themSinhVien(sv);

                                            FileDocGhi.WriteToFile(ql.sinhVienList);
                                            break;
                                        case 2:
                                            System.out.println("Kiểm Tra ds Rỗng : " + ql.kiemTraRong());
                                            break;
                                        case 3:
                                            System.out.println("Sô Lượng sinh viên là: " + ql.laySoLuongSV());
                                        case 4:
                                            if (ql.kiemTraRong()) {
                                                System.out.println("Ko có sinh viên để hiển thị ");
                                            } else
                                                ql.hienThi();
                                            break;
                                        case 5:
                                            ql.lamRong();
                                            break;
                                        case 6:
                                            System.out.println("Nhập mã sv: ");
                                            int maSV = sc.nextInt();
                                            SinhVien sinhVien = new SinhVien(maSV);
                                            System.out.println("Ktra sinh vien có tồn tại: " + ql.kiemTraTonTai(sinhVien));
                                            break;
                                        case 7:
                                            System.out.println("Nhập Mã sinh viên cần xóa:");
                                            int maSV1 = sc.nextInt();
                                            SinhVien sinhVien1 = new SinhVien(maSV1);
                                            System.out.println("Đã xóa được sinh viên: " + ql.xoaSinhVien(sinhVien1));
                                            break;
                                        case 8:
                                            System.out.println("Nhập Mã Sinh Viên cần tìm: ");
                                            int maSV2 = sc.nextInt();
                                            ql.timSinhVien(maSV2);
                                            break;
                                        case 9:
                                            FileDocGhi.ReadFromFile(ql.sinhVienList);
                                            break;
                                        case 10:
                                            System.out.println("Nhập mã sinh viên cần sửa: ");
                                            int maSinhVienSua = sc.nextInt();
                                            System.out.println("Nhập mã sv:");
                                            int maSV3 = sc.nextInt();
                                            sc.nextLine();
                                            System.out.println("Nhập tên sinh viên:");
                                            String ten2 = sc.nextLine();
                                            System.out.println("Nhập năm sinh:");
                                            int namSinh2 = sc.nextInt();
                                            System.out.println("Nhập diem trung bình:");
                                            double diem2 = sc.nextDouble();
                                            SinhVien sinhVien2 = new SinhVien(ten2, namSinh2, diem2);
                                            ql.sua(maSinhVienSua, sinhVien2);
                                            break;
                                        case 11:
                                            ql.sapXepTheoDiemGiamDan();
                                            break;
                                        default:
                                            System.out.println("Lựa chọn bạn nằm ngoài dự đoán của chúng tôi,mời nhập lại lựa chọn");
                                    }

                                } while (luaChon1 != 12);
                                break;
                            case 2:
                                System.out.println("2.Xem thông tin tài khoản : ");
                                System.out.println();
                                dangNhapTaiKhoan.displayInfor(ten,matKhau);
                                break;

                            default:
                                System.out.println("Nhập ngoài khoảng của thần đèn, mời nhập lại");
                        }


                    }while (luaChon2!=3);
                    }else{
                        System.out.println("Sai tài khoản hoặc mật khẩu, mời bạn trở lại màn hình đăng nhập");
                    }
            }
            else if (luaChon==2){
                System.out.println("Đăng kí");
                System.out.println("Nhập tài khoản: ");
                sc.nextLine();
                String tenTaiKhoan = sc.nextLine();
                System.out.println("Nhập mật khẩu: ");
                String matKhau = sc.nextLine();
                DangNhap dangNhap = new DangNhap(tenTaiKhoan,matKhau);
                dangNhapTaiKhoan.themTaiKhoan(dangNhap);
            }else if (luaChon<1 || luaChon>3){
                System.out.println("Lựa chọn ngoài khả năng của thần đèn, mời đăng nhập lại");
            }
        } while (luaChon!=3);
    }
}


package main;

import filedocghi.FileDocGhiDangNhap;
import mode.DangNhap;
import mode.Menu;
import mode.SinhVien;
import filedocghi.FileDocGhi;
import quanlisinhvien.QuanLiDangNhap;
import quanlisinhvien.QuanLySinhVien;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        QuanLySinhVien ql = new QuanLySinhVien();
        QuanLiDangNhap dangNhapTaiKhoan = new QuanLiDangNhap();
        Pattern pattern = Pattern.compile("^[0-9]{2,}$");
        int luaChon= 0;
        do {
            System.out.println(ANSI_PURPLE_BACKGROUND + "---------------ĐĂNG NHẬP------------------" + ANSI_RESET);
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí");
            System.out.println("3.thoát");
            System.out.println("nhập lựa chọn");
            luaChon=sc.nextInt();
            if (luaChon==1) {
                int luaChon1 = -1;
                System.out.println("Đăng nhập");
                System.out.println("Nhập tài khoản: ");
                sc.nextLine();
                String ten = sc.nextLine();
                System.out.println("Nhập mật khẩu: ");
                String matKhau = sc.nextLine();
                if(dangNhapTaiKhoan.find(ten,matKhau)!=-1) {
                    System.out.println("Đăng nhập thành công");

                    do {
                        Menu.menu();
                        try {
                            System.out.println("Nhập vào lựa chọn");
                            luaChon1 = sc.nextInt();
                            sc.nextLine();
                            if (luaChon1 < 1 || luaChon1 > 12) {
                            }
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
                                Menu.menu();
                        }

                    } while (luaChon1!=12);
                }else {
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
            }
        } while (luaChon!=3);
    }
}


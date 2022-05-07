package quanlisinhvien;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        QuanLySinhVien ql = new QuanLySinhVien();
        Pattern p = Pattern.compile("^[a-zA-Z]*@[a-zA-Z]{1,10}$");
        do {
            System.out.println("---------------Đăng Nhập------------------");
            System.out.println("Nhập tài khoản: ");
            String tk = sc.nextLine();
            System.out.println("nhập mk: ");
            String mk = sc.nextLine();
            if (tk.equalsIgnoreCase("anhson") && mk.equals("123")) {
                int luaChon = 1;
                do {
                    System.out.println("--------------------Menu-------------------------");
                    System.out.println("1.Thêm Sinh Viên");
                    System.out.println("2.Kiểm Tra Rỗng");
                    System.out.println("3.Lấy Số Lượng Sinh Viên");
                    System.out.println("4.Hiển Thị");
                    System.out.println("5.Làm Rỗng Danh Sách");
                    System.out.println("6.Kiểm Tra Sinh Viên Có Tồn Tại:");
                    System.out.println("7.Xóa sinh viên:");
                    System.out.println("8.Tìm sinh viên theo mã sv:");
                    System.out.println("9.Đọc:");
                    System.out.println("10.Ghi File:");
                    System.out.println("11.Sửa:");
                    System.out.println("Mời nhập lựa chọn: ");
                    do {
                        try {
                            luaChon = sc.nextInt();
                            sc.nextLine();
                            if (luaChon < 1 || luaChon > 13) {
                                System.out.println("Mời nhập lại lựa chọn");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Chỉ nhập số: ");
                            sc.nextLine();
                            luaChon = -1;
                        }

                    } while (luaChon < 1 || luaChon > 13);

                    switch (luaChon) {

                        case 1:
                            System.out.println("Nhập Mã sv: ");
                            String ma = sc.nextLine();
                            System.out.println("Nhập Họ Tên: ");
                            String hoTen = sc.nextLine();
                            System.out.println("Nhập Năm Sinh: ");
                            int namSinh = sc.nextInt();
                            System.out.println("Nhập Điểm Trung Bình: ");
                            double diemTB = sc.nextDouble();
                            SinhVien sv = new SinhVien(ma, hoTen, namSinh, diemTB);
                            ql.themSinhVien(sv);
                            break;
                        case 2:
                            System.out.println("Kiểm Tra ds Rỗng : " + ql.kiemTraRong());
                            break;
                        case 3:
                            System.out.println("Sô Lượng SV: " + ql.laySoLuongSV());
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
                            String masv = sc.nextLine();
                            SinhVien sinhVien = new SinhVien(masv);
                            System.out.println("Ktra sinh vien có tồn tại: " + ql.kiemTraTonTai(sinhVien));
                            break;
                        case 7:
                            System.out.println("Nhập Mã sinh viên cần xóa:");
                            String masv1 = sc.nextLine();
                            SinhVien sinhVien1 = new SinhVien(masv1);
                            System.out.println("Đã xóa được sinh viên: " + ql.xoaSinhVien(sinhVien1));
                            break;
                        case 8:
                            System.out.println("Nhập Mã Sinh Viên cần tìm: ");
                            String maSV = sc.nextLine();
                            ql.timSinhVien(maSV);
                            break;
                case 9:
                    FileDocGhi.WriteToFile(ql.sinhVienList);
                    break;
                        case 10:
                            FileDocGhi.ReadFromFile(ql.sinhVienList);
                            break;
                        case 11:
                            System.out.println("Nhập mã sinh viên cần sửa: ");
                            String masvs = sc.nextLine();
                            System.out.println("Nhập mã sv:");
                            String masv2 = sc.nextLine();
                            System.out.println("Nhập tên sinh viên:");
                            String ten2 = sc.nextLine();
                            System.out.println("Nhập năm sinh:");
                            int nam2 = sc.nextInt();
                            System.out.println("Nhập diem trung bình:");
                            double diem2 = sc.nextDouble();
                            SinhVien sinhVien2 = new SinhVien(masv2, ten2, nam2, diem2);
                            ql.sua(masvs, sinhVien2);
                            break;
                        case 13:
                            System.exit(13);
                    }

                } while (luaChon != 0);
            } else {
                System.out.println("Sai tk hoặc mk !!");

            }
        }while (true);
    }
}


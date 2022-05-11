package quanlisinhvien;

import filedocghi.FileDocGhi;
import mode.Menu;
import mode.SinhVien;

import java.io.FileNotFoundException;
import java.util.*;

public class QuanLySinhVien {

    //    FileDocGhi fileDocGhi = new FileDocGhi();
    public List<SinhVien> sinhVienList = new ArrayList<>();

    public QuanLySinhVien() throws FileNotFoundException {
        FileDocGhi.ReadFromFile(sinhVienList);
    }

    public void themSinhVien(SinhVien sinhVien) {
        this.sinhVienList.add(sinhVien);

    }

    public boolean kiemTraRong() {
        return sinhVienList.isEmpty();
    }

    public int laySoLuongSV() {
        return sinhVienList.size();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void hienThi() {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        do {
            System.out.println("--------------------Menu-------------------------");
            System.out.println(ANSI_BLUE+"1.In tất cả sinh viên");
            System.out.println("2.In sinh viên giỏi");
            System.out.println("3.In sinh viên khá");
            System.out.println("4.In sinh viên trung bình");
            System.out.println("5.Quay lại menu"+ANSI_RESET);
            do {
                try {
                    luaChon = sc.nextInt();
                    sc.nextLine();
                    if (luaChon < 1 || luaChon > 5) {
                        System.out.println(ANSI_RED + "Mời nhập lại lựa chọn" + ANSI_RESET);
                    }
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Chỉ nhập số: " + ANSI_RESET);
                    sc.nextLine();
                    luaChon = -1;
                }

            } while (luaChon < 1 || luaChon > 5);

            switch (luaChon) {
                case 1:
                    for (SinhVien i : sinhVienList) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    int dem = 0;
                    for (int i = 0; i < sinhVienList.size(); i++) {
                        if (sinhVienList.get(i).getDiemTrungBinh() > 8.0 || sinhVienList.get(i).getDiemTrungBinh() == 8.0) {
                            dem++;
                            System.out.println(sinhVienList.get(i));
                        }
                    }
                    if (dem == 0) System.out.println("Không có Sinh viên nào giỏi");
                    break;
                case 3:
                    int dem1 = 0;
                    for (int i = 0; i < sinhVienList.size(); i++) {
                        if (sinhVienList.get(i).getDiemTrungBinh() > 6.4 && sinhVienList.get(i).getDiemTrungBinh() < 8.0) {
                            dem1++;
                            System.out.println(sinhVienList.get(i));
                        }
                    }
                    if (dem1 == 0) System.out.println("Không có Sinh viên khá nào ");
                    break;
                case 4:
                    int dem2 = 0;
                    for (int i = 0; i < sinhVienList.size(); i++) {
                        if (sinhVienList.get(i).getDiemTrungBinh() < 6.5) {
                            dem2++;
                            System.out.println(sinhVienList.get(i));
                        }
                    }
                    if (dem2 == 0) System.out.println("Không có Sinh viên khá nào ");
                    break;
                case 5:
                    Menu.menu();
                    break;
            }
        } while (luaChon != 5);
    }

//    public List<SinhVien> getSinhVienList() {
//        return sinhVienList;
//    }

    public void lamRong() {
        sinhVienList.removeAll(sinhVienList);
    }

    public boolean kiemTraTonTai(SinhVien sinhVien) {
        return sinhVienList.contains(sinhVien);
    }

    public boolean xoaSinhVien(SinhVien sinhVien) {
        if (sinhVienList.isEmpty()) {
            System.out.println("Không có sinh viên nào để xóa");
        } else sinhVienList.remove(sinhVien);
        return true;
    }

    public void timSinhVien(int ma) {
        if (sinhVienList.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách!");
        } else {
            int dem=0;
            for (SinhVien sinhVien : sinhVienList) {
                if (sinhVien.getMaSinhVien() == ma) {
                    System.out.println(sinhVien);
                    dem++;
                }
            }if (dem==0){
                System.out.println("Không tồn tại sinh viên này");
            }
        }
    }

    public void sua(int maSinhVien, SinhVien sinhVien) {
        for (int i = 0; i < sinhVienList.size(); i++) {
            if (sinhVienList.get(i).getMaSinhVien() == maSinhVien) {
                sinhVienList.set(i, sinhVien);
            }
        }

    }

    public void sapXepTheoDiemGiamDan() {
        Collections.sort(sinhVienList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh()) {
                    return 1;
                } else if (sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < sinhVienList.size(); i++) {
            System.out.println(sinhVienList.get(i));
        }
    }

    Scanner sc = new Scanner(System.in);

    public void batNGoaiLeNhapLuaChon() {
        int luaChon = 1;
        do {
            try {
                luaChon = sc.nextInt();
                sc.nextLine();
                if (luaChon < 1 || luaChon > 15) {
                    System.out.println("Xin hãy nhìn lại menu,mời nhập lại lựa chọn");
                }
            } catch (InputMismatchException e) {
                System.out.println("Chỉ nhập số,mời nhập lại lựa chọn: ");
                sc.nextLine();
                luaChon = -1;
            }

        } while (luaChon < 1 || luaChon > 15);
    }

    public void nhapThongTinSinhVien() {

    }


}


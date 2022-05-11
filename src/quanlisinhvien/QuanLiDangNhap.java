package quanlisinhvien;

import filedocghi.FileDocGhiDangNhap;
import model.DangNhap;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class QuanLiDangNhap<FileGhiDangNhap> {
    private FileDocGhiDangNhap fileDocGhiDangNhap;
    List<DangNhap>dangNhapList=new ArrayList<>();

    public QuanLiDangNhap(List<DangNhap> dangNhapList) {
        this.dangNhapList = dangNhapList;
    }

    public QuanLiDangNhap() throws FileNotFoundException {
        FileDocGhiDangNhap.readFromFileDangNhap(dangNhapList);
    }

    public void themTaiKhoan(DangNhap dangNhap) throws FileNotFoundException{
        dangNhapList.add(dangNhap);
        System.out.println("Đăng kí thành công");
        FileDocGhiDangNhap.WriteToFileDangNhap(dangNhapList);
    }
    public int find(String ten,String matkhau) {
        for (int i = 0; i < dangNhapList.size(); i++) {
            if (ten.equals(dangNhapList.get(i).getTen()) && (dangNhapList.get(i).getMatKhau().equals(matkhau))) {
                return i;
            }
        }
        return -1;
    }
    public String display(String name,String pass){
        String str = "name = ";
        for (DangNhap user : dangNhapList) {
            if (name.equals(user.getTen())&&(user.getMatKhau().equals(pass)))
                str += user.getTen();
        }
        return str;
    }
    public void displayInfor(String name,String pass){
        for (DangNhap user : dangNhapList) {
            if (name.equals(user.getTen())&&(user.getMatKhau().equals(pass)))
                System.out.println(user);;
        }
    }
    public void edit(String ten,String matKhau, DangNhap dangNhap) {
        int index = find(ten, matKhau);
        dangNhapList.set(index, dangNhap);
    }

}

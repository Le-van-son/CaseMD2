package quanlisinhvien;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.*;

public class QuanLySinhVien {
    List<SinhVien> sinhVienList = new ArrayList<>();
    public void themSinhVien(SinhVien sinhVien) {
        this.sinhVienList.add(sinhVien);
    }

    public boolean kiemTraRong() {
        return sinhVienList.isEmpty();
    }
    public int laySoLuongSV(){
        return sinhVienList.size();
    }
    public void hienThi(){
        for (SinhVien i: sinhVienList) {
            System.out.println(i);
        }
    }
    public void lamRong(){
        sinhVienList.removeAll(sinhVienList);
    }
    public boolean kiemTraTonTai(SinhVien sinhVien){
        return sinhVienList.contains(sinhVien);
    }
    public boolean xoaSinhVien(SinhVien sinhVien){
        return sinhVienList.remove(sinhVien);
    }
    public void timSinhVien(String ma){
        if (sinhVienList.isEmpty()){
            System.out.println("Không có sinh viên nào trong danh sách!");
        }else {
            for (SinhVien sinhVien : sinhVienList) {
                if (sinhVien.getMaSinhVien().equals(ma)) {
                    System.out.println(sinhVien);
                } else {
                    System.out.println("Không tồn tại sinh viên này");
                }
            }
        }
    }
    public void sua(String maSinhVien,SinhVien sinhVien){
        for (int i = 0; i < sinhVienList.size(); i++) {
            if(sinhVienList.get(i).getMaSinhVien().equals(maSinhVien)){
                sinhVienList.set(i,sinhVien);
            }
        }
    }

}


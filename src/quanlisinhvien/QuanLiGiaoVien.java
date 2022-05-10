package quanlisinhvien;

import mode.GiaoVien;

import java.util.ArrayList;
import java.util.List;

public class QuanLiGiaoVien {
    List<GiaoVien>giaoVienList = new ArrayList<>();
    public void them(GiaoVien giaoVien){
        giaoVienList.add(giaoVien);
    }
}

package mode;

import mode.SinhVien;

public class GiaoVien {
    private String tenGiaoVien;
    private int id;
    private String lopQuanLi;
    private SinhVien sinhVien;

    public GiaoVien() {
    }

    public GiaoVien(String tenGiaoVien, int id, String lopQuanLi, SinhVien sinhVien) {
        this.tenGiaoVien = tenGiaoVien;
        this.id = id;
        this.lopQuanLi = lopQuanLi;
        this.sinhVien = sinhVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLopQuanLi() {
        return lopQuanLi;
    }

    public void setLopQuanLi(String lopQuanLi) {
        this.lopQuanLi = lopQuanLi;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    @Override
    public String toString() {
        return "GiaoVien{" +
                "tenGiaoVien='" + tenGiaoVien + '\'' +
                ", id=" + id +
                ", lopQuanLi='" + lopQuanLi + '\'' +
                ", sinhVien=" + sinhVien +
                '}';
    }
}

package model;

import java.util.Objects;

public class SinhVien {

    private int maSinhVien;
    static int dem=0;
    private String hoTen;
    private int namSinh;
    private double diemTrungBinh;

    public SinhVien() {
    }
    public SinhVien(int maSinhVien){
        this.maSinhVien = maSinhVien;
    }

    public SinhVien(String hoTen, int namSinh, double diemTrungBinh) {
        this.maSinhVien = dem++;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public SinhVien(String s, String s1) {
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien='" + maSinhVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return  Objects.equals(maSinhVien, sinhVien.maSinhVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSinhVien, hoTen, namSinh, diemTrungBinh);
    }

//    @Override
//    public int compareTo(SinhVien sinhVien) {
//        return maSinhVien.compareTo(sinhVien.maSinhVien);
//    }

}


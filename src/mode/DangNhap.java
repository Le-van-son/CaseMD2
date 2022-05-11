package mode;

public class DangNhap {
    private String ten,matKhau;

    public DangNhap() {
    }

    public DangNhap(String ten, String matKhau) {
        this.ten = ten;
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return  ten + ',' + matKhau +"\n";
    }
}

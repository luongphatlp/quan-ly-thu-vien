import java.util.Scanner;

public class ChiTietPhieuNhapSach {
    private String maphieunhapsach;
    private String masach;
    private int soluong;
    private double dongia;
    private double thanhtien;

    public ChiTietPhieuNhapSach() {}

    public ChiTietPhieuNhapSach(String maphieunhapsach, String masach, int soluong, double dongia) {
        this.maphieunhapsach = maphieunhapsach;
        this.masach = masach;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = soluong * dongia;
    }

    public ChiTietPhieuNhapSach(ChiTietPhieuNhapSach ctpns) {
        this(ctpns.maphieunhapsach, ctpns.masach, ctpns.soluong, ctpns.dongia);
    }

    public String getMaPhieuNhapSach() { return maphieunhapsach; }
    public String getMaSach() { return masach; }
    public int getSoLuong() { return soluong; }
    public double getDonGia() { return dongia; }
    public double getThanhTien() { return thanhtien; }

    public void setMaPhieuNhapSach(String maphieunhapsach) { this.maphieunhapsach = maphieunhapsach; }
    public void setMaSach(String masach) { this.masach = masach; }
    public void setSoLuong(int soluong) {
        this.soluong = soluong;
        this.thanhtien = this.soluong * this.dongia;
    }
    public void setDonGia(double dongia) {
        this.dongia = dongia;
        this.thanhtien = this.soluong * this.dongia;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(String ma) {
        maphieunhapsach = ma;
        System.out.print("Nhap ma sach: ");
        masach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soluong = sc.nextInt();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextDouble();
        thanhtien = soluong * dongia;
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("| %-18s | %-15s | %-15d | %-15.2f | %-15.2f |\n", maphieunhapsach, masach, soluong, dongia, thanhtien);
    }

    @Override public String toString(){
        return maphieunhapsach+","+masach+","+soluong+","+dongia;
    }
}

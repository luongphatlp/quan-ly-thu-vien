import java.util.Scanner;
import java.time.LocalDate;

public class DocGia {
    private String madocgia;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh;
    private String sdt;

    Scanner sc = new Scanner(System.in);

    public DocGia() {
    }

    public DocGia(String madocgia, String ho, String ten, String gioitinh, String ngaysinh, String sdt) {
        this.madocgia = madocgia;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
    }

    public DocGia(DocGia dg) {
        this.madocgia = dg.madocgia;
        this.ho = dg.ho;
        this.ten = dg.ten;
        this.gioitinh = dg.gioitinh;
        this.ngaysinh = dg.ngaysinh;
        this.sdt = dg.sdt;
    }

    public String getMaDocGia() {
        return madocgia;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return gioitinh;
    }

    public String getNgaySinh() {
        return ngaysinh;
    }

    public String getSDT() {
        return sdt;
    }

    public void setMaDocGia(String madocgia) {
        this.madocgia = madocgia;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public void setNgaySinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void nhap() {
        System.out.println("Nhap ma doc gia: ");
        madocgia = sc.nextLine();
        System.out.println("Nhap ho: ");
        ho = sc.nextLine();
        System.out.println("Nhap ten: ");
        ten = sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap sdt: ");
        sdt = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("| %-10s | %-10s | %-12s | %-9s | %-12s | %-10s |\n", madocgia, ho, ten, gioitinh, sdt,ngaysinh);
    }

    public int tinhtuoi() {
        if (ngaysinh == null || ngaysinh.length() < 10)
        return -1;
        int namsinh = Integer.parseInt(ngaysinh.substring(6, 10));
        int namht = LocalDate.now().getYear();
        return namht-namsinh;
    }

}

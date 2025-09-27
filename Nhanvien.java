import java.util.Scanner;

public class Nhanvien {
    private String mnv;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh;
    private String sdt;

    public Nhanvien() {
    }

    public Nhanvien(String mnv, String ho, String ten, String gioitinh, String ngaysinh, String sdt) {
        this.mnv = mnv;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
    }

    public Nhanvien(Nhanvien nv) {
        this.mnv = nv.mnv;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.gioitinh = nv.gioitinh;
        this.ngaysinh = nv.ngaysinh;
        this.sdt = nv.sdt;
    }

    public String getMnv() {return mnv;}
    public String getHo() {return ho;}
    public String getTen() {return ten;}
    public String getGioitinh() {return gioitinh;}
    public String getNgaysinh() {return ngaysinh;}
    public String getSdt() {return sdt;}

    public void setMnv(String mnv){this.mnv=mnv;}
    public void setHo(String ho) {this.ho = ho;}
    public void setTen(String ten) {this.ten = ten;}
    public void setGioitinh(String gioitinh) {this.gioitinh = gioitinh;}
    public void setNgaysinh(String ngaysinh) {this.ngaysinh = ngaysinh;}
    public void setSdt(String sdt) {this.sdt = sdt;}

    Scanner sc = new Scanner(System.in);
    public void nhap() {
        System.out.print("Nhap ma nhan vien: ");
        mnv = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhap Sdt: ");
        sdt = sc.nextLine();
    }

    public void sua(){
        System.out.print("Nhap ho: ");
        ho=sc.nextLine();
        System.out.print("Nhap ten: ");
        ten=sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh=sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh=sc.nextLine();
        System.out.print("Nhap sdt: ");
        sdt=sc.nextLine();
    }
    @Override
    public String toString(){
        return mnv+","+ho+","+ten+","+gioitinh+","+ngaysinh+","+sdt;
    }
    public void xuat(){
        System.out.printf("| %-10s | %-10s | %-15s | %-9s | %-12s | %-15s |\n",mnv,ho,ten,gioitinh,ngaysinh,sdt);
    }
}

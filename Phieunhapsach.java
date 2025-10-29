import java.util.Scanner;

public class PhieuNhapSach {
    private String maphieunhapsach;
    private String manhanvien;
    private String manhacungcap;
    private String ngaynhap;
    private Double tongtien;
    private DanhSachChiTietPhieuNhapSach dsctpns;

    public PhieuNhapSach(){
        dsctpns=new DanhSachChiTietPhieuNhapSach(); 
    }
    public PhieuNhapSach(String maphieunhapsach,String manhanvien,String manhacungcap,String ngaynhap){
        this.maphieunhapsach=maphieunhapsach;
        this.manhanvien=manhanvien;
        this.manhacungcap=manhacungcap;
        this.ngaynhap=ngaynhap;
        this.tongtien=0.0;
        dsctpns=new DanhSachChiTietPhieuNhapSach();
    }
    public PhieuNhapSach(PhieuNhapSach p){
        this.maphieunhapsach=p.maphieunhapsach;
        this.manhanvien=p.manhanvien;
        this.manhacungcap=p.manhacungcap;
        this.ngaynhap=p.ngaynhap;
        this.tongtien=p.tongtien;
        if (p.dsctpns != null)
        this.dsctpns = new DanhSachChiTietPhieuNhapSach(p.dsctpns);
    else
        this.dsctpns = new DanhSachChiTietPhieuNhapSach();
    }
    public String getMaPhieuNhapSach(){return maphieunhapsach;}
    public String getMaNhanVien(){return manhanvien;}
    public String getMaNhaCungCap(){return manhacungcap;}
    public String getNgayNhap(){return ngaynhap;}
    public Double getTongTien(){return tongtien;}
    public DanhSachChiTietPhieuNhapSach getDSCTPNS(){return dsctpns;}
    public void setMaPhieuNhapSach(String maphieunhapsach){this.maphieunhapsach=maphieunhapsach;}
    public void setMaNhanVien(String manhanvien){this.manhanvien=manhanvien;}
    public void setMaNhaCungCap(String manhacungcap){this.manhacungcap=manhacungcap;}
    public void setNgayNhap(String ngaynhap){this.ngaynhap=ngaynhap;}
    public void setTongTien(Double tongtien){this.tongtien=tongtien;}
    Scanner sc=new Scanner(System.in);
    public Double tinhTongTien(){
        Double tongtien=0.0;
        for(ChiTietPhieuNhapSach ctpns:dsctpns.getDS())
            tongtien+=ctpns.getDonGia()*ctpns.getSoLuong();
        this.tongtien=tongtien;
        return tongtien;
    }
    public void nhap(){
        System.out.println("Nhap ma phieu nhap sach: ");
        maphieunhapsach=sc.nextLine();
        System.out.println("Nhap ma nhan vien: ");
        manhanvien=sc.nextLine();
        System.out.println("Nhap ma nha cung cap: ");
        manhacungcap=sc.nextLine();
        System.out.println("Nhap ngay nhap: ");
        ngaynhap=sc.nextLine();
        dsctpns.nhap(maphieunhapsach);
        tongtien=tinhTongTien();
    }
    public void xuat(){
        System.out.printf("| %-18s | %-15s | %-15s | %-15s | %-15.2f |\n",maphieunhapsach,manhanvien,manhacungcap,ngaynhap,tongtien);
    }
    @Override public String toString(){
        return maphieunhapsach+","+manhanvien+","+manhacungcap+","+ngaynhap;
    }
}

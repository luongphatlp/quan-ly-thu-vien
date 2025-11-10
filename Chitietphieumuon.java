import java.util.Scanner;
public class ChiTietPhieuMuon {
    private String maphieumuon;
    private String masach;
    private int soluong;
    
    public ChiTietPhieuMuon(){}
    public ChiTietPhieuMuon(String maphieumuon,String masach,int soluong){
        this.maphieumuon=maphieumuon;
        this.masach=masach;
        this.soluong=soluong;
    }
    
    public ChiTietPhieuMuon(ChiTietPhieuMuon ctpm){
        this.maphieumuon=ctpm.maphieumuon;
        this.masach=ctpm.masach;
        this.soluong=ctpm.soluong;
    }
    public String getMaPhieuMuon(){return maphieumuon;}
    public String getMaSach(){return masach;}
    public int getSolLuong(){return soluong;}
    public void setMaPhieuMuon(String maphieumuon){this.maphieumuon=maphieumuon;}
    public void setMaSach(String masach){this.masach=masach;}
    public void setSoLuong(int soluong){this.soluong=soluong;}

    Scanner sc= new Scanner(System.in);
    public void nhap(String ma,DanhSachSach dss){
        maphieumuon=ma;
        System.out.println("Nhap ma sach: ");
        masach=sc.nextLine();
        System.out.println("Nhap so luong: ");
        soluong=sc.nextInt();
        sc.nextLine();
    }
    public void xuat(){
        System.out.printf("| %-15s | %-15s | %-10d |\n",maphieumuon,masach,soluong);
    }
    @Override public String toString(){
        return maphieumuon+","+masach+","+soluong;
    }
}

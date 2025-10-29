import java.util.Scanner;

public class PhieuPhat {
    private String maphieuphat;
    private String madocgia;
    private String maphieumuon;
    private String maphat;
    private int tienphat;

    public PhieuPhat(){}
    public PhieuPhat(String maphieuphat,String madocgia,String maphieumuon,String maphat,int tienphat){
        this.maphieuphat=maphieuphat;
        this.madocgia=madocgia;
        this.maphieumuon=maphieumuon;
        this.maphat=maphat;
        this.tienphat=tienphat;
    }
    public PhieuPhat(PhieuPhat pp){
        this.maphieuphat=pp.maphieuphat;
        this.madocgia=pp.madocgia;
        this.maphieumuon=pp.maphieumuon;
        this.maphat=pp.maphat;
        this.tienphat=pp.tienphat;
    }
    public String getMaPhieuPhat(){return maphieuphat;}
    public String getMaDoGia(){return madocgia;}
    public String getMaPhieuMuon(){return maphieumuon;}
    public String getMaphat(){return maphat;}
    public int getTienPhat(){return tienphat;}
    public void setMaPhieuPhat(String maphieuphat){this.maphieuphat=maphieuphat;}
    public void setMaDocGia(String madocgia){this.madocgia=madocgia;}
    public void setMaPhieuMuon(String maphieumuon){this.maphieumuon=maphieumuon;}
    public void setMaPhat(String maphat){this.maphat=maphat;}
    public void setTienPhat(int tienphat){this.tienphat=tienphat;}

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma phieu phat: ");
        maphieuphat=sc.nextLine();
        System.out.println("Nhap ma doc gia: ");
        madocgia=sc.nextLine();
        System.out.println("Nhap ma phieu muon: ");
        maphieumuon=sc.nextLine();
        System.out.println("Nhap ma phat: ");
        maphat=sc.nextLine();
        tienphat=0;

    }
    public void xuat(){
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10d |\n",maphieuphat,madocgia,maphieumuon,maphat,tienphat);
    }
    @Override public String toString(){
        return maphieuphat+","+madocgia+","+maphieumuon+","+maphat;
    }
    public void capNhatTienPhat(DanhSachQuyDinhPhat dsqdp){
        for(QuyDinhPhat qd:dsqdp.getDS())
            if(maphat.equals(qd.getMaPhat())){
                tienphat=qd.getTienPhat();
                return;
            }
        tienphat=0;
    }
}    

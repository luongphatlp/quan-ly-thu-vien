public class PhieuPhat {
    private String maphieuphat;
    private String madocgia;
    private String maphieumuon;
    private String maphat;
    private int tienphat;

    public PhieuPhat(){}
    public PhieuPhat(String maphieuphat,String madocgia,String maphieumuon,String maphat, DanhSachQuyDinhPhat dsqdp){
        this.maphieuphat=maphieuphat;
        this.madocgia=madocgia;
        this.maphieumuon=maphieumuon;
        this.maphat=maphat;
        QuyDinhPhat qdp =dsqdp.layQuyDinhPhatTuMa(maphat);
        if(qdp != null){
            this.tienphat=qdp.getTienPhat();
        }else{
            this.tienphat=0;
            System.err.println("Canh bao ma phat'" + maphat + "' khong hop le, tien phat dat bang 0.");
        }
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

}    

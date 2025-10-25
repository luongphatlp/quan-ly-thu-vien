import java.util.Scanner;
public class QuyDinhPhat {
    private String maphat;
    private String noidung;
    private int tienphat;
    
    public QuyDinhPhat(){}
    public QuyDinhPhat(String maphat,String noidung,int tienphat){
        this.maphat=maphat;
        this.noidung=noidung;
        this.tienphat=tienphat;
    }
    public QuyDinhPhat(QuyDinhPhat qd){
        this.maphat=qd.maphat;
        this.noidung=qd.noidung;
        this.tienphat=qd.tienphat;
    }

    public String getMaPhat(){return maphat;}
    public String getNoiDung(){return noidung;}
    public int getTienPhat(){return tienphat;}
    public void setMaPhat(String maphat){this.maphat=maphat;}
    public void setNoiDung(String noidung){this.noidung=noidung;}
    public void setTienPhat(int tienphat){this.tienphat=tienphat;}

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma phat: ");
        maphat=sc.nextLine();
        System.out.println("Nhap noi dung: ");
        noidung=sc.nextLine();
        System.out.println("Nhap tien phat: ");
        tienphat=sc.nextInt();
    }
    @Override public String toString(){
        return maphat+","+noidung+","+tienphat;
    }
    public void xuat(){
        System.out.printf("| %-10s | %-50s | %-10s |\n",maphat,noidung,tienphat);
    }
}


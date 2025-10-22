import java.util.Scanner;

public class NhaXuatBan {
    private String manxb;
    private String tennxb;

    public NhaXuatBan(){}
    public NhaXuatBan(String manxb,String tennxb){
        this.manxb=manxb;
        this.tennxb=tennxb;
    }
    public NhaXuatBan(NhaXuatBan nxb){
        this.manxb=nxb.manxb;
        this.tennxb=nxb.tennxb;
    }
    public String getMaNXB(){return manxb;}
    public String getTenNXB(){return tennxb;}
    public void setMaNXB(String manxb){this.manxb=manxb;}
    public void setTenNXB(String tennxb){this.tennxb=tennxb;}

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma nha xuat ban: ");
        manxb=sc.nextLine();
        System.out.println("Nhap ten nha xuat ban: ");
        tennxb=sc.nextLine();
    }
    public void xuat(){
        System.out.printf("| %-15s | %-20s |",manxb,tennxb);
    }

    @Override public String toString(){
        return manxb+","+tennxb;
    }
}

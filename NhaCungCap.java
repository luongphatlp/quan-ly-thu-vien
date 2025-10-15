import java.util.Scanner;
public class NhaCungCap {
    private String mancc;
    private String tenncc;
    public NhaCungCap(){}
    public NhaCungCap(String mancc,String tenncc){
        this.mancc=mancc;
        this.tenncc=tenncc;
    }
    public NhaCungCap(NhaCungCap ncc){
        this.mancc=ncc.mancc;
        this.tenncc=ncc.tenncc;
    }
    public String getMaNCC(){return mancc;}
    public String getTenNCC(){return tenncc;}
    public void setTenNCC(String tenncc){this.tenncc=tenncc;}
    public void setMaNCC(String mancc){this.mancc=mancc;}

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma nha cung cap: ");
        mancc=sc.nextLine();
        System.out.println("Nhap ten nha cung cap: ");
        tenncc=sc.nextLine();
    }
    public void xuat(){
        System.out.printf("| %-15s | %-30s |\n",mancc,tenncc);
    }
    @Override public String toString(){
        return mancc+","+tenncc;
    }
}

import java.util.Scanner;

public class Tacgia {
    private String matacgia;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh;

    public Tacgia(){};
    public Tacgia(String matacgia,String ho,String ten,String gioitinh,String ngaysinh){
        this.matacgia=matacgia;
        this.ho=ho;
        this.ten=ten;
        this.gioitinh=gioitinh;
        this.ngaysinh=ngaysinh;
    }
    public Tacgia(Tacgia tg){
        this.matacgia=tg.matacgia;
        this.ho=tg.ho;
        this.ten=tg.ten;
        this.gioitinh=tg.gioitinh;
        this.ngaysinh=tg.ngaysinh;
    }
    public String getMaTacGia(){return matacgia;}
    public String getHo(){return ho;}
    public String getTen(){return ten;}
    public String getGioiTinh(){return gioitinh;}
    public String getNgaySinh(){return ngaysinh;}
    public void setMaTacGia(String matacgia){this.matacgia=matacgia;}
    public void setHo(String ho){this.ho=ho;}
    public void setTen(String ten){this.ten=ten;}
    public void setGioiTinh(String gioitinh){this.gioitinh=gioitinh;}
    public void setNgaySinh(String ngaysinh){this.ngaysinh=ngaysinh;}

    Scanner sc= new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma tac gia: ");
        matacgia=sc.nextLine();
        System.out.println("Nhap ho: ");
        ho=sc.nextLine();
        System.out.println("Nhap ten: ");
        ten=sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gioitinh=sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        ngaysinh=sc.nextLine();
    }
    @Override public String toString(){
        return matacgia+","+ho+","+ten+","+gioitinh+","+ngaysinh;
    }
    public void xuat(){
        System.out.printf("| %-10s | %-15s | %-10s | %-9s | %-12s |\n",matacgia, ho, ten, gioitinh, ngaysinh);
    }
}

import java.util.Scanner;
public class Sach {
    private String masach,tensach,matheloai,matacgia,manxb,namxuatban;
    public Sach(){}
    public Sach(String masach,String tensach,String matheloai,String matacgia,String manxb,String namxuatban){
        this.masach=masach;
        this.tensach=tensach;
        this.matheloai=matheloai;
        this.matacgia=matacgia;
        this.manxb=manxb;
        this.namxuatban=namxuatban;
    }
    public Sach(Sach s){
        this.masach=s.masach;
        this.tensach=s.tensach;
        this.matheloai=s.matheloai;
        this.matacgia=s.matacgia;
        this.manxb=s.manxb;
        this.namxuatban=s.namxuatban;
    }
    public String getMaSach(){return masach;}
    public String getTenSach(){return tensach;}
    public String getMaTheLoai(){return matheloai;}
    public String getMaTacGia(){return matacgia;}
    public String getMaNXB(){return manxb;}
    public String getNamXuatBan(){return namxuatban;}
    public void setMaSach(String masach){this.masach=masach;}
    public void setTenSach(String tensach){this.tensach=tensach;}
    public void setMaTheLoai(String matheloai){this.matheloai=matheloai;}
    public void setMaTacGia(String matacgia){this.matacgia=matacgia;}
    public void setMaNXB(String manxb){this.manxb=manxb;}
    public void setNamXuatBan(String namxuatban){this.namxuatban=namxuatban;}
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap ma sach: "); masach=sc.nextLine();
        System.out.println("Nhap ten sach" ); tensach=sc.nextLine();
        System.out.println("Nhap ma the loai"); matheloai=sc.nextLine();
        System.out.println("Nhap ma tac gia: "); matacgia=sc.nextLine();
        System.out.println("Nhap ma nha xuat ban: "); manxb=sc.nextLine();
        System.out.println("Nhap nam xuat ban: "); namxuatban=sc.nextLine();
    }
    @Override public String toString(){
        return masach+","+tensach+","+matheloai+","+matacgia+","+manxb+","+namxuatban;
    }
    public void xuat(){
        System.out.printf("| %-10s | %-20s | %-11s | %-10s | %-15s | %-15s |",masach, tensach, matheloai , matacgia ,manxb ,namxuatban);
    }
}

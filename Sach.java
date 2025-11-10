import java.util.Scanner;
abstract public class Sach {
    private String masach,tensach,matheloai,matacgia,manxb,namxuatban;
    private int soluong;
    public Sach(){}
    public Sach(String masach,String tensach,String matheloai,String matacgia,String manxb,String namxuatban,int soluong){
        this.masach=masach;
        this.tensach=tensach;
        this.matheloai=matheloai;
        this.matacgia=matacgia;
        this.manxb=manxb;
        this.namxuatban=namxuatban;
        this.soluong=soluong;
    }
    public Sach(Sach s){
        this.masach=s.masach;
        this.tensach=s.tensach;
        this.matheloai=s.matheloai;
        this.matacgia=s.matacgia;
        this.manxb=s.manxb;
        this.namxuatban=s.namxuatban;
        this.soluong=s.soluong;
    }
    public abstract String getLoaiSach();
    public String getMaSach(){return masach;}
    public String getTenSach(){return tensach;}
    public String getMaTheLoai(){return matheloai;}
    public String getMaTacGia(){return matacgia;}
    public String getMaNXB(){return manxb;}
    public String getNamXuatBan(){return namxuatban;}
    public int getSoLuong(){return soluong;}
    public void setMaSach(String masach){this.masach=masach;}
    public void setTenSach(String tensach){this.tensach=tensach;}
    public void setMaTheLoai(String matheloai){this.matheloai=matheloai;}
    public void setMaTacGia(String matacgia){this.matacgia=matacgia;}
    public void setMaNXB(String manxb){this.manxb=manxb;}
    public void setNamXuatBan(String namxuatban){this.namxuatban=namxuatban;}
    public void setSoLuong(int soluong){this.soluong=soluong;}
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.print("Nhap ma sach: "); masach=sc.nextLine();
        System.out.print("Nhap ten sach" ); tensach=sc.nextLine();
        System.out.print("Nhap ma the loai"); matheloai=sc.nextLine();
        System.out.print("Nhap ma tac gia: "); matacgia=sc.nextLine();
        System.out.print("Nhap ma nha xuat ban: "); manxb=sc.nextLine();
        System.out.print("Nhap nam xuat ban: "); namxuatban=sc.nextLine();
        System.out.print("Nhap so luong: "); soluong=sc.nextInt();
    }
    @Override public String toString(){
        return masach+","+tensach+","+matheloai+","+matacgia+","+manxb+","+namxuatban+","+soluong;
    }
    public void xuat(){
        System.out.printf("| %-10s | %-20s | %-12s | %-10s | %-10s | %-10s | %-10s |", masach, tensach, matheloai, matacgia, manxb, namxuatban,soluong);
    }
}

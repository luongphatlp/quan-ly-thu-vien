import java.util.Scanner;
public class TheLoai extends DanhMuc{
    private String matheloai;
    private String tentheloai;
    private String mota;

    public TheLoai(){}
    public TheLoai(String ma,String ten,String mota){
        this.matheloai=ma;
        this.tentheloai=ten;
        this.mota=mota;
    }
    public TheLoai(TheLoai tl){
        this.matheloai=tl.matheloai;
        this.tentheloai=tl.tentheloai;
        this.mota=tl.mota;
    }
    public String getMaTheLoai(){return matheloai;}
    public String getTenTheLoai(){return tentheloai;}
    public String getMoTa(){return mota;}
    public void setMaTheLoai(String m){this.matheloai=m;}
    public void setTenTheLoai(String t){this.tentheloai=t;}
    public void setMota(String mt){this.mota=mt;}
    Scanner sc=new Scanner(System.in);
    @Override public void nhap(){
        System.out.println("Nhap ma the loai: ");
        matheloai=sc.nextLine();
        System.out.println("Nhap ten the loai: ");
        tentheloai=sc.nextLine();
        System.out.println("Nhap mo ta: ");
        mota=sc.nextLine();
    }
    @Override public String toString() {
        return matheloai+","+tentheloai+","+mota;
    }
    @Override public void xuat(){
        System.out.printf("| %-11s | %-25s | %-50s |\n",matheloai,tentheloai,mota);
    }
}
import java.util.Scanner;
class SachThamKhao extends Sach{
    private String linhvuc,loaidocgia;
    public SachThamKhao(){}
    public SachThamKhao(String masach,String tensach,String matheloai,String madocgia,String manxb,String namxuatban,String linhvuc,String loaidocgia){
        super(masach,tensach,matheloai,madocgia,manxb,namxuatban);
        this.linhvuc=linhvuc;
        this.loaidocgia=loaidocgia;
    }
    public SachThamKhao(SachThamKhao s){
        super((Sach)s);
        this.linhvuc=s.linhvuc;
        this.loaidocgia=s.loaidocgia;
    }
    public String getLinhVuc(){return linhvuc;}
    public String getLoaiDocGia(){return loaidocgia;}
    public void setLinhVuc(String linhvuc){this.linhvuc=linhvuc;}
    public void setLoaiDocGia(String loaidocgia){this.loaidocgia=loaidocgia;}

    Scanner sc=new Scanner(System.in);
    @Override public void nhap(){
        super.nhap();
        System.out.println("nhap linh vuc: "); linhvuc=sc.nextLine();
        System.out.println("nhap loai doc gia: "); loaidocgia=sc.nextLine();
    }
    @Override public String toString(){
        return super.toString()+","+linhvuc+","+loaidocgia;
    }
    @Override public void xuat(){
        super.xuat();
        System.out.printf(" %-9s %-21s %-13s %-12s |\n","Linh vuc:",linhvuc,"Loai doc gia:",loaidocgia," ");
    }
}
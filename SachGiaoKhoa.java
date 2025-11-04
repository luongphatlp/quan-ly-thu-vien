import java.util.Scanner;
class SachGiaoKhoa extends Sach{
    private String mon,lop;
    public SachGiaoKhoa(){}
    public SachGiaoKhoa(String masach,String tensach,String matheloai,String tacgia,String manxb,String namxuatban,String mon,String lop){
        super(masach,tensach,matheloai,tacgia,manxb,namxuatban);
        this.mon=mon;
        this.lop=lop;
    }
    public SachGiaoKhoa(SachGiaoKhoa s){
        super((Sach)s);
        this.lop=s.lop;
        this.mon=s.mon;
    }
    public String getLoaiSach(){return "Sach giao khoa";}
    public String getMon(){return mon;}
    public String getLop(){return lop;}
    public void setMon(String mon){this.mon=mon;}
    public void setLop(String lop){this.lop=lop;}

    Scanner sc=new Scanner(System.in);
    @Override public void nhap(){
        super.nhap();
        System.out.println("nhap mon: "); mon=sc.nextLine();
        System.out.println("nhap lop: "); lop=sc.nextLine();
    }
    @Override public String toString(){
        return super.toString()+","+mon+","+lop;
    }
    @Override public void xuat(){
        super.xuat();
        System.out.printf(" %-4s %-26s %-4s %-3s %-18s|\n","Mon:",mon,"Lop:",lop," ");
    }
}
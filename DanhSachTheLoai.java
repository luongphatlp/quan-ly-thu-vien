import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachTheLoai {
    TheLoai[] ds=new TheLoai[0];
    public DanhSachTheLoai(){}
    public DanhSachTheLoai(TheLoai[] ds){
        this.ds=ds;
    }
    public DanhSachTheLoai(DanhSachTheLoai ds){
        this.ds=ds.ds;
    }
    Scanner sc=new Scanner(System.in);
    public boolean kiemTraMaDuyNhat(String ma){
        for(TheLoai tl:ds)
            if(ma.equals(tl.getMaTheLoai()))
                return false;
        return true;
    }
    public void nhap(){
        System.out.println("Nhap so luong the loai can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin cua the loai thu "+(i+1)+":");
            while(k>0 && !kt){
                TheLoai tl=new TheLoai();
                tl.nhap();
                if(them(tl))
                    kt=true;
                else{
                    System.out.println("Ma the loai da ton tai vui long nhap lai");
                    k--;
                }
            }
            if(!kt){
                System.out.println("Da nhap qua so lan quy dinh");
                return;
            }
        }
    }
    public void xuat(){
        xuatt();
        for(int i=0;i<ds.length;i++)
            System.out.printf("| %-11s | %-12s | %-50s |\n",ds[i].getMaTheLoai(),ds[i].getTenTheLoai(),ds[i].getMoTa());
        xuatd();
    }
    private void xuatt(){
        System.out.println("+-------------+--------------+----------------------------------------------------+");
        System.out.printf("| %-11s | %-12s | %-50s |\n","Ma the loai","Ten the loai","mo ta");
        System.out.println("|-------------|--------------|----------------------------------------------------|");
    }
    private void xuatd(){
        System.out.println("+-------------|--------------|----------------------------------------------------|");
    }
    public boolean them(TheLoai tl){
        if(kiemTraMaDuyNhat(tl.getMaTheLoai())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]= new TheLoai(tl);
            return true;
        }
        return false;
    }
    public void them(){
        int k=5;
            boolean kt=false;
            while(k>0 && !kt){
                TheLoai tl=new TheLoai();
                tl.nhap();
                if(them(tl))
                    kt=true;
                else{
                    System.out.println("Ma the loai da ton tai vui long nhap lai");
                    k--;
                }
            }
            if(!kt){
                System.out.println("Da nhap qua so lan quy dinh");
                return;
            }
    }
    public void sua(){
        System.out.println("Nhap ma the loai can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaTheLoai())){
                System.out.println("Nhap lua chon muon sua(1.ten the loai 2.mo ta)");
                while(sl>0){
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ten: ");
                        ds[i].setTenTheLoai(sc.nextLine());
                        kt=true;
                    }else if(c==2){
                        System.out.println("Nhap mo ta: ");
                        ds[i].setMota(sc.nextLine());
                        kt=true;
                    }else{
                        System.out.println("Nhap lua chon khong dung. Vui long nhap lai.");
                        sl--;
                    }
                    if(kt){
                        System.out.println("Sua thong tin thanh cong.");
                        return;
                    }
                }
            }
        }
        if(!kt)
            System.out.println("Khong tim thay the loai co ma: "+ma);
    }
    public void xoa(){
        System.out.println("Nhap ma the loai muon xoa: ");
        String ma=sc.nextLine();
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTheLoai())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ ma);
    }
    public void docFile(){
        File file=new File("Theloai.txt");
        try(Scanner f=new Scanner(file)){
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==5){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new TheLoai(parts[0],parts[1],parts[2]);
                }    
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tim duoc File");
        }
    }
    
    public void ghiFile(){
        File file=new File("Theloai.txt");
        try(PrintWriter pw=new PrintWriter(file)){
            for(TheLoai tl:ds){
                pw.println(tl.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tao duoc File");
        }
    }
    public void timKiemTheoMaTheLoai(){
        System.out.println("Nhap ma the loai muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTheLoai())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(kt) 
            xuatd();
        else
            System.out.println("Khong tim thay sach cua tac gia co ma: "+ma);  
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten the loai muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(TheLoai tl:ds)
            if(ten.contains(tl.getTenTheLoai())){
                if(!kt)xuatt();
                tl.xuat();
                kt=true;
            }
        if(kt)xuatd();
        if(!kt)    
            System.out.println("Khong tim thay the loai co ten: "+ten);
    }
    public int thongKeTongSoTheLoai(){
        System.out.println("Tong so the loai hien co: "+ds.length);
        return ds.length;
    }
    public int thongKeTheLoaiTheoTuKhoa(){
        System.out.println("Nhap tu khoa the loai can thong ke");
        String ten=sc.nextLine();
        int i=0;
        for(TheLoai tl:ds)
            if(ten.contains(tl.getTenTheLoai()))
                i++;
        System.out.println("So luong the loai co tu khoa "+ten+": "+i);
        return i;
    }

    public static void main(String[] args){
        DanhSachTheLoai ds=new DanhSachTheLoai();
        ds.nhap();
        //ds.them();
        //ds.sua();
        //ds.xoa();
        ds.ghiFile();
    }
}

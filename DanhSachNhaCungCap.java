import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class DanhSachNhaCungCap {
    NhaCungCap[] ds =new NhaCungCap[0];
    
    public DanhSachNhaCungCap(){}
    public DanhSachNhaCungCap(NhaCungCap[] ds){this.ds=Arrays.copyOf(ds,ds.length);}
    public DanhSachNhaCungCap(DanhSachNhaCungCap ds){this.ds=Arrays.copyOf(ds.ds,ds.ds.length);}

    Scanner sc=new Scanner(System.in);
    public boolean kiemTraMaDuyNhat(String ma){
        for(NhaCungCap ncc:ds)
            if(ma.equals(ncc.getMaNCC()))
                return false;
        return true;
    }
    public void nhap(){
        System.out.println("Nhap so luong nha cung cap can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin nha cung cap thu "+(i+1)+":");
            while(k>0 && !kt){
                NhaCungCap ncc=new NhaCungCap();
                ncc.nhap();
                if(them(ncc))
                    kt=true;
                else{
                    System.out.println("Ma nha cung cap da ton tai vui long nhap lai");
                    k--;
                } 
            }
            if(!kt){
                System.out.println("Nhap qua so lan quy dinh");
                return;
            } 
        }
    }
    public void xuatt(){
        System.out.println("+-----------------+--------------------------------+");
        System.out.printf("| %-15s | %-30s |\n","Ma nha cung cap","Ten nha cung cap");
        System.out.println("+-----------------+--------------------------------+");
    }
    public void xuatd(){
        System.out.println("+-----------------+--------------------------------+");
    }
    public void xuat(){
        xuatt();
        for(NhaCungCap ncc:ds)
            ncc.xuat();
        xuatd();
    }
    public void them(){
        int k=5;
        boolean kt=false;
        while(k>0 && !kt){
            NhaCungCap ncc=new NhaCungCap();
            ncc.nhap();
            if(them(ncc))
                kt=true;
            else{
                System.out.println("Ma nha cung cap da ton tai vui long nhap lai");
                k--;
            } 
        }
        if(!kt){
            System.out.println("Nhap qua so lan quy dinh");
            return;
        }
    }
    public boolean them(NhaCungCap ncc){
        if(kiemTraMaDuyNhat(ncc.getMaNCC())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=new NhaCungCap(ncc);
            return true;
        }
        return false;
    }
    public void sua(){
        System.out.println("Nhap ma nha cung cap can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaNCC())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Sua ten nha cung cap.");
                    System.out.println("Nhap lua chon cua ban: ");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ten nha cung cap moi: ");
                        ds[i].setTenNCC(sc.nextLine());
                        kt=true;
                        break;
                    }else {
                        System.out.println("Lua chon khong hop le.");
                        sl--;
                    }
                }
            }
            if(kt){
                System.out.println("Sua thong tin thanh cong.");
                return ;
            }
        }
        System.out.println("Khong tim thay ma nha cung cap can sua: "+ma);
    }
    public void xoa(){
        System.out.println("Nhap ma nha cung cap can xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public void xoa(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaNCC())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa nha cung cap thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma nha cung cap can xoa: "+ma);
    }
    public void docFile(){
        File file=new File("Nhacungcap.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==2){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new NhaCungCap(parts[0],parts[1]);
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter("Nhacungcap.txt")){
            for(NhaCungCap ncc:ds)
                w.println(ncc.toString());
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public void timKiemTheoMaNhaCungCap(){
        System.out.println("Nhap ma nha cung cap muon tim: ");
        String ma=sc.nextLine();
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaNCC())){
                xuatt();
                ds[i].xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay nha cung cap co ma: "+ma);  
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten nha cung cap muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(NhaCungCap p:ds)
            if(p.getTenNCC().contains(ten)){
                if(!kt)xuatt();
                p.xuat();
                kt=true;
            }
        if(kt)xuatd();
        if(!kt)    
            System.out.println("Khong tim thay nha cung cap co ten: "+ten);
    }
     public int thongKeSoLuongNhaCungCap(){
        System.out.println("So luong nha cung cap: "+ds.length);
        return ds.length;
    }
    public int thongKeTheoTuKhoa(){
        System.out.println("Nhap tu khoa nha cung cap can thong ke");
        String ten=sc.nextLine();
        int i=0;
        for(NhaCungCap ncc:ds)
            if(ncc.getTenNCC().contains(ten))
                i++;
        System.out.println("So luong nha cung cap co tu khoa "+ten+": "+i);
        return i;
    }
    public static void main(String[] args){
        DanhSachNhaCungCap dsncc=new DanhSachNhaCungCap();
        dsncc.docFile();
        dsncc.xuat();
        dsncc.nhap();
        dsncc.xuat();
        dsncc.sua();
        dsncc.xuat();
        dsncc.xoa();
        dsncc.xuat();
        dsncc.ghiFile();
    }
}

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class DanhSachNhaXuatBan {
    NhaXuatBan[] ds=new NhaXuatBan[0];

    public DanhSachNhaXuatBan(){}
    public DanhSachNhaXuatBan(NhaXuatBan[] ds1){
        ds=Arrays.copyOf(ds1,ds1.length);
    }
    public DanhSachNhaXuatBan(DanhSachNhaXuatBan ds1){
        ds=Arrays.copyOf(ds1.ds,ds1.ds.length);
    }

    Scanner sc=new Scanner(System.in);
    public boolean kiemTraMaDuyNhat(String ma){
        for(NhaXuatBan nxb:ds)
            if(ma.equals(nxb.getMaNXB()))
                return false;
        return true;
    }
    public void nhap(){
        System.out.println("Nhap so luong nha xuat ban can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin nha xuat ban thu "+(i+1)+":");
            while(k>0 && !kt){
                NhaXuatBan nxb=new NhaXuatBan();
                nxb.nhap();
                if(them(nxb))
                    kt=true;
                else{
                    System.out.println("Ma nha xuat ban da ton tai vui long nhap lai");
                    k--;
                } 
            }
            if(!kt){
                System.out.println("Nhap qua so lan quy dinh");
                return;
            } 
        }
    }
    public void xuat(){
        xuatt();
        for(NhaXuatBan nxb:ds)
            nxb.xuat();
        xuatd();
    }
    private void xuatt(){
        System.out.println("+-----------------+------------------+");
        System.out.printf("| %-15s | %-16s |\n","Ma nha xuat ban","Ten nha xuat ban");
        System.out.println("|-----------------|------------------|");
    }
    private void xuatd(){
        System.out.println("+-----------------+------------------+");
    }
    public void them(){
        int k=5;
            boolean kt=false;
            while(k>0 && !kt){
                NhaXuatBan nxb=new NhaXuatBan();
                nxb.nhap();
                if(them(nxb))
                    kt=true;
                else{
                    System.out.println("Ma nha xuat ban da ton tai vui long nhap lai");
                    k--;
                } 
            }
            if(!kt){
                System.out.println("Nhap qua so lan quy dinh");
                return;
            }
    }
    public boolean them(NhaXuatBan nxb){
        if(kiemTraMaDuyNhat(nxb.getMaNXB())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=new NhaXuatBan(nxb);
            return true;
        }
        return false;
    }
    public void sua(){
        String ma;
        System.out.println("Nhap ma nha xuat ban can sua: ");
        ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        for(NhaXuatBan nxb:ds){
            if(ma.equals(nxb.getMaNXB())){
                System.out.println("Nhap ten nha xuat ban: ");
                nxb.setTenNXB(sc.nextLine());
                break;
            }
        }
    }
    public void xoa(){
        System.out.println("Nhap ma nha xuat ban moun xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public int timkiem(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaNXB())){
                return i;
            }
        }
        return -1;
    }
    public void xoa(String ma){
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay nha xuat ban co ma: "+ma);
            return ;
        }
        for(int i=k;i<ds.length-1;i++)
            ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds,ds.length-1);
    }
    public void docFile(){
        File file=new File("Nhaxuatban.txt");
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
                    ds[ds.length-1]=new NhaXuatBan(parts[0],parts[1]);
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter("Nhaxuatban.txt")){
            for(NhaXuatBan nxb:ds)
                w.println(nxb.toString());
            System.out.println("Ghi file thanh cong.");
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public void timKiemTheoMaNhaXuatBan(){
        System.out.println("Nhap ma tac gia muon tim: ");
        String ma=sc.nextLine();
        for(NhaXuatBan nxb:ds)
            if(ma.equals(nxb.getMaNXB())){
                xuatt();
                nxb.xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ma);       
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten nha xuat ban muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(NhaXuatBan nxb:ds)
            if(ten.contains(nxb.getTenNXB())){
                if(!kt)xuatt();
                nxb.xuat();
                kt=true;
            }
        if(kt)xuatd();
        if(!kt)    
            System.out.println("Khong tim thay tac gia co ten: "+ten);
    }
    public int thongKeTongSoNhaXuatBan(){
        System.out.println("Tong so nha xuat ban hien co: "+ds.length);
        return ds.length;
    }
    public int thongKeTheLoaiTheoTuKhoa(){
        System.out.println("Nhap tu khoa nha xuat ban can thong ke");
        String ten=sc.nextLine();
        int i=0;
        for(NhaXuatBan tl:ds)
            if(ten.contains(tl.getTenNXB()))
                i++;
        System.out.println("So nha xuat ban co tu khoa "+ten+": "+i);
        return i;
    }
}

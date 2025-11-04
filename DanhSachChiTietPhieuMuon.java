import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
public class DanhSachChiTietPhieuMuon {
    private ChiTietPhieuMuon[] ds=new ChiTietPhieuMuon[0];
    public DanhSachChiTietPhieuMuon(){}
    public DanhSachChiTietPhieuMuon(ChiTietPhieuMuon[] ds2){
        ds=Arrays.copyOf(ds2,ds2.length);
    }
    public DanhSachChiTietPhieuMuon(DanhSachChiTietPhieuMuon ds2){
        ds=Arrays.copyOf(ds2.ds,ds2.ds.length);
    }
    public ChiTietPhieuMuon[] getDS(){return ds;}
    Scanner sc=new Scanner(System.in);
    public boolean kiemTraMaDuyNhat(String ma){
        for(ChiTietPhieuMuon ctpm:ds)
            if(ma.equals(ctpm.getMaSach()))
                return false;
        return true;
    }
    public void nhap(String ma){
        System.out.println("Nhap so luong chi tiet phieu muon can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin cua chi tiet phieu muon thu "+(i+1)+":");
            while(k>0 && !kt){
                ChiTietPhieuMuon ctpm=new ChiTietPhieuMuon();
                ctpm.nhap(ma);
                if(them(ctpm))
                    kt=true;
                else{
                    System.out.println("Ma sach da ton tai vui long nhap lai");
                    k--;
                }
            }
            if(!kt){
                System.out.println("Da nhap qua so lan quy dinh");
                return;
            }
        }
    }
    public void xuatt(){
        System.out.printf("+-----------------+-----------------+------------+\n");
        System.out.printf("| %-15s | %-15s | %-10s |\n","Ma phieu muon","Ma sach","So luong");
        System.out.printf("|-----------------|-----------------|------------|\n");
    }
    public void xuatd(){
        System.out.printf("+-----------------+-----------------+------------+\n");
    }
    public void xuat(){
        xuatt();
        for(ChiTietPhieuMuon ctpm:ds)
            ctpm.xuat();
        xuatd();
    }
    public boolean them(ChiTietPhieuMuon ctpm){
        if(kiemTraMaDuyNhat(ctpm.getMaSach())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]= new ChiTietPhieuMuon(ctpm);
            return true;
        }
        return false;
    }
    public void them(String ma){
        int k=5;
            boolean kt=false;
            while(k>0 && !kt){
                ChiTietPhieuMuon ctpm=new ChiTietPhieuMuon();
                ctpm.nhap(ma);
                if(them(ctpm))
                    kt=true;
                else{
                    System.out.println("Ma sach da ton tai vui long nhap lai");
                    k--;
                }
            }
            if(!kt){
                System.out.println("Da nhap qua so lan quy dinh");
                return;
            }
    }
    public void sua(){
        System.out.println("Nhap ma sach muon sua: ");
        String mas=sc.nextLine();
        sua(mas);
    }
    public void sua(String mas){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(mas.equals(ds[i].getMaSach())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1.Ma sach");
                    System.out.println("2.So luong");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ma sach moi: ");
                        ds[i].setMaSach(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==2){
                        System.out.println("Nhap so luong moi: ");
                        ds[i].setSoLuong(sc.nextInt());
                        sc.nextLine();
                        kt=true;
                        break;
                    }else{
                        System.out.println("Lua chon khong hop le.");
                        sl--;
                    }
                    if(kt){
                        System.out.println("Sua thanh cong.");
                        return;
                    }
                }
            }
        }
        System.out.println("Khong tim thay chi tiet phieu muon co ma sach: "+mas);  
    }
    public void xoa(){
        System.out.println("Nhap ma sach muon xoa: ");
        String mas=sc.nextLine();
        xoa(mas);
    }
    public void xoa(String mas){
        for(int i=0;i<ds.length;i++){
            if(mas.equals(ds[i].getMaSach())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa nha cung cap thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet phieu co ma sach: "+mas);
    }
    public void docFile(String ma){
        File file=new File("Chitietphieumuon.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==3 && ma.equals(parts[0])){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new ChiTietPhieuMuon(parts[0],parts[1],Integer.parseInt(parts[2]));
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter(new FileWriter("Chitietphieumuon.txt",true))){
            for(ChiTietPhieuMuon ctpm:ds)
                w.println(ctpm.toString());
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public void timKiemTheoSoLuong(){
        System.out.println("Nhap ma phieu muon cua chi tiet phieu muon muon tim: ");
        int sl=sc.nextInt();
        timKiemTheoSoLuong(sl);
    }
    public void timKiemTheoSoLuong(int sl){
        boolean kt=false;
        for (ChiTietPhieuMuon ctpm : ds)
            if (sl==ctpm.getSolLuong()){
                if(!kt) xuatt();
                ctpm.xuat();
                kt=true;
            }
        if(kt) xuatd();
        else System.out.println("Khong tim thay chi tiet phieu muon nao!");
    }
    public void timKiemTheoMaSach(){
        System.out.println("Nhap ma sach cua chi tiet phieu muon muon tim: ");
        String mas=sc.nextLine();
        timKiemTheoMaSach(mas);
    }
    public void timKiemTheoMaSach(String mas){
        for (ChiTietPhieuMuon ctpm : ds)
            if (mas.equals(ctpm.getMaSach())){
                xuatt();
                ctpm.xuat();
                xuatd();
                return ;
            }
        System.out.println("Khong tim thay chi tiet phieu muon nao!");
    }
    public int thongKeSoPhieu(){
        System.out.println("Tong so phieu chi tiet: "+ds.length);
        return ds.length;
    }
    public Map<Integer,Integer> thongKeTheoSoLuong(){
        Map<Integer,Integer> count=new HashMap<>();
        for(ChiTietPhieuMuon ctpm:ds)
            count.put(ctpm.getSolLuong(),count.getOrDefault(ctpm.getSolLuong(),0)+1);
        for(Map.Entry<Integer,Integer> entry :count.entrySet())
            System.out.println("So luong phieu muon duoc tao boi nhan vien co ma "+entry.getKey()+": "+entry.getValue());
        return count;
    }
    public int soLuongSachDocGiaMuon(String ma){
        int sl=0;
        for(ChiTietPhieuMuon p:ds)
            if(ma.equals(p.getMaPhieuMuon()))
                sl+=p.getSolLuong();
        return sl;
    }
    public static void main(String[] args){
        DanhSachChiTietPhieuMuon ds=new DanhSachChiTietPhieuMuon();
        ds.xuat();
        ds.ghiFile();
    }
}   
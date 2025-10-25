import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
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
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong chi tiet phieu muon: ");
        int bd=ds.length;
        int k=sc.nextInt();
        ds=Arrays.copyOf(ds,ds.length+k);
        sc.nextLine();
        for(int i=bd;i<ds.length;i++){
            ds[i]=new ChiTietPhieuMuon();
            ds[i].nhap();
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
    public void them(ChiTietPhieuMuon ctpm){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1] = new ChiTietPhieuMuon(ctpm);
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1] = new ChiTietPhieuMuon();
        System.out.println("Nhap thong tin chi tiet phieu muon them: ");
        ds[ds.length-1].nhap();
    }
    public void sua(){
        System.out.println("Nhap ma phieu muon va ma sach cua chi tiet phieu muon muon sua: ");
        System.out.println("Ma phieu muon: ");String mapm=sc.nextLine();
        System.out.println("Ma sach: ");String mas=sc.nextLine();
        sua(mapm,mas);
    }
    public void sua(String mapm,String mas){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(mapm.equals(ds[i].getMaPhieuMuon()) && mas.equals(ds[i].getMaSach())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1.ma sach");
                    System.out.println("2.so luong");
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
        System.out.println("Khong tim thay ma chi tiet phieu muon can sua: "+mapm+","+mas);  
    }
    public void xoa(){
        System.out.println("Nhap ma phieu muon va ma sach cua chi tiet phieu muon muon xoa: ");
        System.out.println("Ma phieu muon: ");String mapm=sc.nextLine();
        System.out.println("Ma sach: ");String mas=sc.nextLine();
        xoa(mapm,mas);
    }
    public void xoa(String mapm,String mas){
        for(int i=0;i<ds.length;i++){
            if(mapm.equals(ds[i].getMaPhieuMuon()) && mas.equals(ds[i].getMaSach())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa nha cung cap thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma chi tiet phieu muon can xoa: "+mapm+","+mas);
    }
    public void docFile(){
        File file=new File("Chitietphieumuon.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==3){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new ChiTietPhieuMuon(parts[0],parts[1],Integer.parseInt(parts[2]));
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter("Chitietphieumuon.txt")){
            for(ChiTietPhieuMuon ctpm:ds)
                w.println(ctpm.toString());
            System.out.println("Ghi file thanh cong.");
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public void timKiemTheoMaPhieuMuon(){
        System.out.println("Nhap ma phieu muon cua chi tiet phieu muon muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoMaPhieuMuon(ma);
    }
    public void timKiemTheoMaPhieuMuon(String ma){
        boolean kt=false;
        for (ChiTietPhieuMuon ctpm : ds)
            if (ma.equals(ctpm.getMaPhieuMuon())){
                if(!kt) xuatt();
                ctpm.xuat();
                kt=true;
            }
        if(kt) xuatd();
        else System.out.println("Khong tim thay chi tiet phieu muon nao!");
    }
    public void timKiemTheoMaPhieuMuonVaMaSach(){
        System.out.println("Nhap ma phieu muon cua chi tiet phieu muon muon tim: ");
        String maph=sc.nextLine();
        System.out.println("Nhap ma sach cua chi tiet phieu muon muon tim: ");
        String mas=sc.nextLine();
        timKiemTheoMaPhieuMuonVaMaSach(maph,mas);
    }
    public void timKiemTheoMaPhieuMuonVaMaSach(String maph,String mas){
        for (ChiTietPhieuMuon ctpm : ds)
            if (maph.equals(ctpm.getMaPhieuMuon()) && mas.equals(ctpm.getMaSach())){
                xuatt();
                ctpm.xuat();
                xuatd();
                return ;
            }
        System.out.println("Khong tim thay chi tiet phieu muon nao!");
    }
    public void thongKeTheoMaSach(){
        Map<String,Integer> count=new HashMap<>();
        for(ChiTietPhieuMuon ctpm:ds)
            count.put(ctpm.getMaSach(),count.getOrDefault(ctpm.getMaSach(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong chi tiet phieu muon cua sach co ma "+entry.getKey()+": "+entry.getValue());
    }
    public void thongKeTheoSoLuong(){
        Map<Integer,Integer> count=new HashMap<>();
        for(ChiTietPhieuMuon ctpm:ds)
            count.put(ctpm.getSolLuong(),count.getOrDefault(ctpm.getSolLuong(),0)+1);
        for(Map.Entry<Integer,Integer> entry :count.entrySet())
            System.out.println("So luong phieu muon duoc tao boi nhan vien co ma "+entry.getKey()+": "+entry.getValue());
    }
    public static void main(String[] args){
        DanhSachChiTietPhieuMuon ds=new DanhSachChiTietPhieuMuon();
        ds.docFile();
        ds.xuat();
        ds.nhap();
        ds.ghiFile();
    }
}

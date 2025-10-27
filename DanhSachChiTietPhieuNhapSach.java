import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DanhSachChiTietPhieuNhapSach {
    private ChiTietPhieuNhapSach[] ds = new ChiTietPhieuNhapSach[0];

    public DanhSachChiTietPhieuNhapSach() {}
    public DanhSachChiTietPhieuNhapSach(ChiTietPhieuNhapSach[] ds) {
        this.ds = ds;
    }
    public DanhSachChiTietPhieuNhapSach(DanhSachChiTietPhieuNhapSach other) {
        this.ds = Arrays.copyOf(other.ds, other.ds.length);
    }

    public ChiTietPhieuNhapSach[] getDS() { return ds; }
    public DanhSachChiTietPhieuNhapSach traVeDanhSachChiTietPhieuNhapSachTheoMa(String ma){
        DanhSachChiTietPhieuNhapSach kq=new DanhSachChiTietPhieuNhapSach();
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaPhieuNhapSach().equals(ma)){
                kq.ds=Arrays.copyOf(kq.ds,kq.ds.length+1);
                kq.ds[kq.ds.length-1]=new ChiTietPhieuNhapSach(ds[i]);
            }
        }
        return kq;
    }
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong chi tiet phieu nhap sach can them: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds=Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new ChiTietPhieuNhapSach();
            ds[i].nhap();
        }
    }
    public void them(ChiTietPhieuNhapSach p){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new ChiTietPhieuNhapSach(p);
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new ChiTietPhieuNhapSach();
        System.out.println("Nhap thong tin chi tiet phieu nhap sach muon them.");
        ds[ds.length-1].nhap();
    }
    public void sua(){
        System.out.println("Nhap ma phieu nhap sach can sua: ");
        String maph=sc.nextLine();
        System.out.println("Nhap ma sach cua chi tiet phieu nhap sach can sua: ");
        String mas=sc.nextLine();
        sua(maph,mas);
    }
    public void sua(String maph,String mas){
        int c=0,sl=5;
        boolean kt=false;
        for(ChiTietPhieuNhapSach p:ds){
            if(maph.equals(p.getMaPhieuNhapSach()) && mas.equals(p.getMaSach())){
                kt=true;
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Ma sach.");
                    System.out.println("2. So luong.");
                    System.out.println("3. Don gia.");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ma sach moi: ");
                        String masach=sc.nextLine();
                        p.setMaSach(masach);
                    }else if(c==2){
                        System.out.println("Nhap so luong: ");
                        int soluong=sc.nextInt();
                        sc.nextLine();
                        p.setSoLuong(soluong);
                    }else if(c==3){
                        System.out.println("Nhap don gia: ");
                        Double dongia=sc.nextDouble();
                        p.setDonGia(dongia);
                    }else{
                        System.out.println("Lua chon khong hop le.");
                        sl--;
                    }
                    if(kt){
                        System.out.println("Sua thong tin thanh cong.");
                        return;
                    }
                }       
            }
        }
        System.out.println("Khong tim thay chi tiet phieu nhap sach co ma phieu nhap sach: "+maph+" - ma sach: "+mas);        
    }
    public void xoa(){
        System.out.println("Nhap ma phieu nhap sach cua chi tiet phieu nhap sach can xoa: ");
        String maph=sc.nextLine();
        System.out.println("Nhap ma sach cua chi tiet phieu nhap sach can xoa: ");
        String mas=sc.nextLine();
        xoa(maph,mas);
    }
    public void xoa(String maph,String mas){
        for(int i=0;i<ds.length;i++){
            if(maph.equals(ds[i].getMaPhieuNhapSach()) && mas.equals(ds[i].getMaSach())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa chi tiet phieu nhap sach thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma chi tiet phieu nhap sach can xoa co ma phieu: "+maph+" va ma sach: "+mas);
    }
    public void docFile() {
        File file = new File("Chitietphieunhapsach.txt");
        if (!file.exists()) {
            System.out.println("File doc khong ton tai.");
            return;
        }
        try (Scanner f = new Scanner(file)) {
            while (f.hasNextLine()) {
                String line = f.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = new ChiTietPhieuNhapSach(parts[0], parts[1],Integer.parseInt(parts[2]),Double.parseDouble(parts[3]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file.");
        }
    }

    public void xuatt(){
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-18s | %-15s | %-15s | %-15s | %-15s |\n","Ma phieu nhap sach","Ma sach","So luong","Don gia","Thanh tien");
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
    }
    public void xuatd(){
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
    }
    public void xuat() {
        xuatt();
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
        xuatd();
    }
    public void timKiemTheoMaPhieuNhapSach(){
        System.out.println("Nhap ma phieu nhap sach muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(ChiTietPhieuNhapSach pns:ds)
            if(ma.equals(pns.getMaPhieuNhapSach())){
                if(!kt) xuatt();
                pns.xuat();
                kt =true;
                return;
            }
        if(kt) xuatd();
        else System.out.println("Khong tim thay chi tiet phieu nhap co ma phieu nhap: "+ma); 
    }
    public void timKiemTheoMaPhieuNhapSachVaMaSach(){
        System.out.println("Nhap ma phieu nhap sach cua chi tiet phieu nhap sach muon tim: ");
        String maph=sc.nextLine();
        System.out.println("Nhap ma sach cua chi tiet phieu nhap sach muon tim: ");
        String mas=sc.nextLine();
        for(ChiTietPhieuNhapSach pns:ds)
            if(maph.equals(pns.getMaPhieuNhapSach()) && mas.equals(pns.getMaSach())){
                xuatt();
                pns.xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay chi tiet phieu nhap co ma phieu nhap: "+maph+" va ma sach: "+mas);
    }
    public void thongKeTheoMaSach(){
        Map<String,Integer> count=new HashMap<>();
        for(ChiTietPhieuNhapSach pns:ds)
            count.put(pns.getMaSach(),count.getOrDefault(pns.getMaSach(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong chi tiet phieu nhap sach cua sach co ma "+entry.getKey()+": "+entry.getValue());
    }
    public int thongKeSoLuong(){
        System.out.println("So luong chi tiet phieu nhap: "+ds.length);
        return ds.length;
    }
}

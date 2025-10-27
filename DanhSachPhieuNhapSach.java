import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachPhieuNhapSach {
    private PhieuNhapSach[] ds=new PhieuNhapSach[0];
    private DanhSachChiTietPhieuNhapSach dsctpns;

    public DanhSachPhieuNhapSach(){}
    public DanhSachPhieuNhapSach(DanhSachChiTietPhieuNhapSach dsctpns){
        this.dsctpns=dsctpns;
    }
    public DanhSachPhieuNhapSach(PhieuNhapSach[] ds,DanhSachChiTietPhieuNhapSach dsctpns){
        this.ds=Arrays.copyOf(ds,ds.length);
        this.dsctpns=dsctpns;
    }
    public DanhSachPhieuNhapSach(DanhSachPhieuNhapSach other){
        this.ds = Arrays.copyOf(other.ds, other.ds.length);
        this.dsctpns=other.dsctpns;
    }
    Scanner sc=new Scanner(System.in);

    public void them(PhieuNhapSach p){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuNhapSach(p);
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuNhapSach();
        System.out.println("Nhap thong tin phieu nhap sach muon them.");
        ds[ds.length-1].nhap();
    }
    private double tinhTongTien(String ma){
        double tongtien=0.0;
        for(ChiTietPhieuNhapSach ct:dsctpns.getDS()){
            if(ma.equals(ct.getMaPhieuNhapSach()))
            tongtien+=ct.getThanhTien();
        }
        return tongtien;
    }
    public void nhap(){
        System.out.println("Nhap so luong phieu nhap sach can them: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds=Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new PhieuNhapSach();
            ds[i].nhap();
            ds[i].setTongTien(tinhTongTien(ds[i].getMaPhieuNhapSach()));
        }
    }
    private void xuatt(){
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n","Ma phieu nhap sach","Ma nhan vien","Ma nha cung cap","Ngay nhap","Tong tien");
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
    }
    private void xuatd(){
        System.out.println("+--------------------+-----------------+-----------------+-----------------+-----------------+");
    }
    public void xuat(){
        xuatt();
        for(int i=0;i<ds.length;i++){
            ds[i].xuat();
        }
        xuatd();
    }
    public void docFile(){
        File file=new File("Phieunhapsach.txt");
        if(!file.exists()){
            System.out.println("File doc khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==4){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new PhieuNhapSach(parts[0],parts[1],parts[2],parts[3],tinhTongTien(parts[0]));
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghifile(){
        try(PrintWriter pw=new PrintWriter("Phieunhapsach.txt")){
            for(PhieuNhapSach p:ds){
                pw.println(p.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Loi ghi file.");
        }
    }
    public void sua(){
        System.out.println("Nhap ma phieu nhap sach can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(PhieuNhapSach p:ds){
            if(ma.equals(p.getMaPhieuNhapSach())){
                kt=true;
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Ma nhan vien.");
                    System.out.println("2. Ma nha cung cap.");
                    System.out.println("3. Ngay nhap.");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ma nhan vien moi: ");
                        String manhanvien=sc.nextLine();
                        p.setMaNhanVien(manhanvien);
                    }else if(c==2){
                        System.out.println("Nhap ma nha cung cap moi: ");
                        String manhacungcap=sc.nextLine();
                        p.setMaNhaCungCap(manhacungcap);
                    }else if(c==3){
                        System.out.println("Nhap ngay nhap moi: ");
                        String ngaynhap=sc.nextLine();
                        p.setNgayNhap(ngaynhap);
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
        if(!kt)
            System.out.println("Khong tim thay ma phieu nhap sach can sua: "+ma);        
    }
    public void xoa(){
        System.out.println("Nhap ma phieu nhap sach can xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public void xoa(String ma){
        for(int i=0;i<ds.length;i++){
            
            if(ma.equals(ds[i].getMaPhieuNhapSach())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa phieu nhap sach thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma phieu nhap sach can xoa: "+ma);
    }
    public void timKiemTheoMaPhieuNhapSach(){
        System.out.println("Nhap ma tac gia muon tim: ");
        String ma=sc.nextLine();
        for(PhieuNhapSach pns:ds)
            if(ma.equals(pns.getMaPhieuNhapSach())){
                xuatt();
                pns.xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ma);       
    }
    public void timKiemTheoNgayNhapSach(){
        System.out.println("Nhap ngay nhap phieu muon tim(yyyy-mm-dd): ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(PhieuNhapSach pms:ds)
            if(ten.contains(pms.getNgayNhap())){
                if(!kt)xuatt();
                pms.xuat();
                kt=true;
            }
        if(kt) xuatd();
        else   
            System.out.println("Khong tim thay tac gia co ten: "+ten);
    }
    public void thongKeTheoMaNhanVien(){
        Map<String,Integer> count=new HashMap<>();
        for(PhieuNhapSach pns:ds)
            count.put(pns.getMaNhanVien(),count.getOrDefault(pns.getMaNhanVien(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong phieu nhap sach cua nhan vien co ma "+entry.getKey()+": "+entry.getValue());
    }
    public void thongKeTheoNhaCungCap(){
        Map<String,Integer> count=new HashMap<>();
        for(PhieuNhapSach pns:ds)
            count.put(pns.getMaNhaCungCap(),count.getOrDefault(pns.getMaNhaCungCap(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong phieu nhap sach cua nha cung cap co ma "+entry.getKey()+": "+entry.getValue());
    }
    public static void main(String[] args) {
        DanhSachChiTietPhieuNhapSach dsctpns=new DanhSachChiTietPhieuNhapSach();
        dsctpns.docFile();
        DanhSachPhieuNhapSach dspns=new DanhSachPhieuNhapSach(dsctpns);
        dspns.docFile();
        dspns.sua();
        dspns.them();
        dspns.sua();
        dspns.ghifile();   
        dspns.xuat();
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
public class DanhSachPhieuMuon {
    private PhieuMuon[] ds=new PhieuMuon[0];

    Scanner sc=new Scanner(System.in);
    public DanhSachPhieuMuon(){}
    public DanhSachPhieuMuon(PhieuMuon[] ds2){
        this.ds=Arrays.copyOf(ds2,ds2.length);
    }
    public DanhSachPhieuMuon(DanhSachPhieuMuon other){
        this.ds=Arrays.copyOf(other.ds,other.ds.length);
    }
    public PhieuMuon[] getDS(){return ds;}
    public void nhap(){
        System.out.println("Nhap so luong phieu muon can nhap: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds=Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new PhieuMuon();
            ds[i].nhap();
        }
    }
    private void xuatt(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+------------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-16s |\n","Ma phieu muon","Ma doc gia","Ma nhan vien","Ngay lap phieu","Ngay tra","Ngay tra thuc te");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+------------------+");
    }
    private void xuatd(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+------------------+");
    }
    public void xuat(){
        xuatt();
        for(PhieuMuon pm:ds){
            pm.xuat();
        }
        xuatd();
    }
    public void them(PhieuMuon pm){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuMuon(pm);
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuMuon();
        System.out.println("Nhap thong tin phieu muon can them.");
        ds[ds.length-1].nhap();
    }
    public PhieuMuon sua(){
        System.out.println("Nhap ma phieu muon can sua: ");
        String ma=sc.nextLine();
        return sua(ma);
    }
    
    public PhieuMuon sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhieuMuon())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Sua ma phieu muon.");
                    System.out.println("2. Sua ma doc gia.");
                    System.out.println("3. Sua ma nhan vien.");
                    System.out.println("4. Sua ngay lap phieu.");
                    System.out.println("5. Sua ngay tra.");
                    System.out.println("6. Sua ngay tra thuc te.");
                    System.out.println("Nhap lua chon cua ban: ");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ma phieu muon moi: ");
                        ds[i].setMaPhieuMuon(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==2){
                        System.out.println("Nhap ma doc gia moi: ");
                        ds[i].setMaDocGia(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==3){
                        System.out.println("Nhap ma nhan vien moi: ");
                        ds[i].setMaNhanVien(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==4){
                        System.out.println("Nhap ngay lap phieu moi: ");
                        ds[i].setNgayLapPhieu(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==5){
                        System.out.println("Nhap ngay tra moi: ");
                        ds[i].setNgayTra(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==6){
                        System.out.println("Nhap ngay tra thuc te moi: ");
                        ds[i].setNgayTraThucTe(sc.nextLine());
                        kt=true;
                        break;
                    }else{
                        System.out.println("Lua chon khong hop le.");
                        sl--;
                    }
                }if(kt){
                    System.out.println("Sua thong tin thanh cong.");
                    return ds[i];
                }else{
                    System.out.println("Sua thong tin that bai.");
                    return null;
                }
            }
        }
        if(!kt)
            System.out.println("Khong tim thay ma phieu muon can sua: "+ma);
        return null;       
    }
    public void xoa(){
        System.out.println("Nhap ma phieu muon can xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public void xoa(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhieuMuon())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa phieu muon thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma phieu muon can xoa: "+ma);
    }
    public void docFile(){
        File file=new File("Phieumuon.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==6){
                    PhieuMuon p=new PhieuMuon(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                    p.getDS().docFile(parts[0]);
                    them(p);
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file: ");
        }
    }
    public void ghifile(){
        try(PrintWriter pw=new PrintWriter("Phieumuon.txt")){
            for(PhieuMuon pm:ds){
                pw.println(pm.toString());
                pm.getDS().ghiFile();
            }
        }catch(Exception e){
            System.out.println("Loi ghi file: "+e);
        }
    }
    public void timKiemTheoMaPhieuMuon(){
        System.out.println("Nhap ma phieu muon muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoMaPhieuMuon(ma);
    }
    public void timKiemTheoMaPhieuMuon(String keyword) {
        for (PhieuMuon pm : ds)
            if (keyword.equals(pm.getMaPhieuMuon())){
                pm.xuat();
                return;
            }
        System.out.println("Khong tim thay phieu muon nao!");
    }
    public void timKiemTheoNgayLapPhieu(){
        System.out.println("Nhap ngay lap phieu cua phieu muon muon tim(yyyy-mm-dd): ");
        String ma=sc.nextLine();
        timKiemTheoMaDocGia(ma);
    }
    public void timKiemTheoMaDocGia(String ma){
        boolean kt=false;
        for (PhieuMuon pm : ds)
            if (ma.equals(pm.getNgayLapPhieu())){
                if(!kt) xuatt();
                pm.xuat();
                kt=true;
            }
        if(kt) xuatd();
        else System.out.println("Khong tim thay phieu muon nao!");
    }
    public void thongKeTheoDocGia(){
        Map<String,Integer> count=new HashMap<>();
        for(PhieuMuon pm:ds)
            count.put(pm.getMaDocGia(),count.getOrDefault(pm.getMaDocGia(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong phieu muon cua doc gia co ma "+entry.getKey()+": "+entry.getValue());
    }
    public void thongKeTheoMaNhanVien(){
        Map<String,Integer> count=new HashMap<>();
        for(PhieuMuon pm:ds)
            count.put(pm.getMaNhanVien(),count.getOrDefault(pm.getMaNhanVien(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong phieu muon duoc tao boi nhan vien co ma "+entry.getKey()+": "+entry.getValue());
    }
    
    public PhieuMuon getPhieuByMa(String ma){
        for(PhieuMuon p:ds)
            if(ma.equals(p.getMaPhieuMuon()))
                return p;
        return null;
    }
    public static void main(String[] args){
        DanhSachPhieuMuon ds=new DanhSachPhieuMuon();
        ds.docFile();
        ds.xuat();
    }
}


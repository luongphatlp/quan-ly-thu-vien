import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class DanhSachPhieuPhat {
    private PhieuPhat[] ds=new PhieuPhat[0];
    private DanhSachQuyDinhPhat qd=new DanhSachQuyDinhPhat();
    
    public DanhSachPhieuPhat(){}
    public DanhSachPhieuPhat(DanhSachQuyDinhPhat qd){
        this.qd=qd;
    }
    public DanhSachPhieuPhat(PhieuPhat[] ds,DanhSachQuyDinhPhat qd){
        this.ds=Arrays.copyOf(ds,ds.length);
        this.qd=qd;
    }
    public DanhSachPhieuPhat(DanhSachPhieuPhat ds){
        this.ds=Arrays.copyOf(ds.ds,ds.ds.length);
        this.qd=ds.qd;
    }
    public PhieuPhat[] getDS(){return ds;}
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong can them: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds=Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new PhieuPhat();
            ds[i].nhap();
            QuyDinhPhat q=layQuyDinhPhatTheoMa(ds[i].getMaphat());
            if(q!=null)
                ds[i].setTienPhat(q.getTienPhat());
        }
    }
    public void xuat(){
        xuatt();
        for(PhieuPhat p:ds)
            p.xuat();
        xuatd();
    }
    private void xuatt(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s |\n","Ma phieu phat","Ma doc gia","Ma phieu muon","Ma phat","Tien phat");
        System.out.println("|-----------------|-----------------|-----------------|-----------------|------------|");
    }
    private void xuatd(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+------------+");
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuPhat();
        System.out.println("Nhap thong tin phieu phat muon them.");
        ds[ds.length-1].nhap();
    }
    public void them(PhieuPhat pp){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new PhieuPhat(pp);
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
            if(ma.equals(ds[i].getMaPhieuPhat())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Sua ma doc gia");
                    System.out.println("2. Sua ma phieu muon");
                    System.out.println("3. Sua ma phat");
                    System.out.println("Nhap lua chon cua ban: ");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ma doc gia: ");
                        ds[i].setMaDocGia(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==2){
                        System.out.println("Nhap ma phieu muon: ");
                        ds[i].setMaPhieuMuon(sc.nextLine());
                        kt=true;
                    }else if(c==3){
                        System.out.println("Nhap ma phat: ");
                        ds[i].setMaPhat(sc.nextLine());
                        kt=true;
                    }
                    else {
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
        System.out.println("Khong tim thay phieu phat can sua co ma: "+ma);
    }
    public void xoa(){
        System.out.println("Nhap ma phat can xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public void xoa(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhieuPhat())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa phieu phat thanh cong.");
                return;
            }
        }
        System.out.println("hong tim thay phieu phat can xoa co ma: "+ma);
    }
    public void docFile(){
        File file=new File("Phieuphat.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==4){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    QuyDinhPhat q =layQuyDinhPhatTheoMa(parts[3]);
                    if(q!=null)
                        ds[ds.length-1]=new PhieuPhat(parts[0],parts[1],parts[2],parts[3],q.getTienPhat());
                    else
                        ds[ds.length-1]=new PhieuPhat(parts[0],parts[1],parts[2],parts[3],0);
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter("Phieuphat.txt")){
            for(PhieuPhat pp:ds)
                w.println(pp.toString());
            System.out.println("Ghi file thanh cong.");
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public QuyDinhPhat layQuyDinhPhatTheoMa(String ma){
        for(QuyDinhPhat q: qd.getDS()){
            if(ma.equals(q.getMaPhat()))
                return q;
        }
        return null;
    }
    public QuyDinhPhat layQuyDinhPhatTheoChiSo(int i){
        return qd.getDS()[i];
    }
    //quan trong!! câp nhap khi quy dinh thay doi
    public void timKiemTheoMaPhieuPhat(){
        System.out.println("Nhap ma phieu phat muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoMaPhieuPhat(ma);
    }
    public void timKiemTheoMaPhieuPhat(String keyword) {
        for (PhieuPhat pp : ds)
            if (keyword.equals(pp.getMaPhieuPhat())){
                pp.xuat();
                return;
            }
        System.out.println("Khong tim thay phieu phat nao!");
    }
    public void timKiemTheoMaDocGia(){
        System.out.println("Nhap ma doc gia cua phieu phat muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoMaDocGia(ma);
    }
    public void timKiemTheoMaDocGia(String ma){
        boolean kt=false;
        for (PhieuPhat pp : ds)
            if (ma.equals(pp.getMaPhieuPhat())){
                if(!kt) xuatt();
                pp.xuat();
                kt=true;
            }
        if(kt) xuatd();
        else System.out.println("Khong tim thay phieu phat nao!");
    }
    public void thongKeTheoTienPhat(){
        Map<Integer,Integer> count=new HashMap<>();
        for(PhieuPhat pp:ds)
            count.put(pp.getTienPhat(),count.getOrDefault(pp.getTienPhat(),0)+1);
        for(Map.Entry<Integer,Integer> entry :count.entrySet())
            System.out.println("So luong phieu phat co tien phat "+entry.getKey()+": "+entry.getValue());
    }
    public void thongKeTheoDocGia(){
        Map<String,Integer> count=new HashMap<>();
        for(PhieuPhat pp:ds)
            count.put(pp.getMaDoGia(),count.getOrDefault(pp.getMaDoGia(),0)+1);
        for(Map.Entry<String,Integer> entry :count.entrySet())
            System.out.println("So luong phieu phat cua doc gia co ma "+entry.getKey()+": "+entry.getValue());
    }
    public int getSoLuong() {
        return ds.length;
    }
    
}


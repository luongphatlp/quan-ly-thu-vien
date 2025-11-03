import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachDocGia {
    DocGia[] ds=new DocGia[0];
    
    Scanner sc=new Scanner(System.in);
    public boolean kiemTraMaDuyNhat(String ma){
        for(DocGia dg:ds)
            if(ma.equals(dg.getMaDocGia()))
                return false;
        return true;
    }
    public void nhap(){
        System.out.println("Nhap so luong doc gia can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin doc gia thu "+(i+1)+":");
            while(k>0 && !kt){
                DocGia qd=new DocGia();
                qd.nhap();
                if(them(qd))
                    kt=true;
                else{
                    System.out.println("Ma doc gia da ton tai vui long nhap lai");
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
        System.out.println("+------------+----------------------+------------+-----------+------------+------------+");
        System.out.printf("| %-10s | %-20s | %-10s | %-9s | %-10s | %-10s |\n","Ma doc gia","Ho","Ten","Gioi tinh","Ngay sinh","SDT");
        System.out.println("|------------|----------------------|------------|-----------|------------|------------|");
    }
    public void xuatd(){
        System.out.println("+------------+----------------------+------------+-----------+------------+------------+");
    }
    public void xuat(){
        xuatt();
        for(DocGia dg:ds)
            dg.xuat();
        xuatd();
    }
    public boolean them(DocGia dg){
        if(kiemTraMaDuyNhat(dg.getMaDocGia())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=new DocGia(dg);
            return true;
        }
        return false;
    }
    public void them(){
        int k=5;
            boolean kt=false;
            while(k>0 && !kt){
                DocGia qd=new DocGia();
                qd.nhap();
                if(them(qd))
                    kt=true;
                else{
                    System.out.println("Ma doc gia da ton tai vui long nhap lai");
                    k--;
                } 
            }
            if(!kt){
                System.out.println("Nhap qua so lan quy dinh");
                return;
            }
    }
    public void sua(){
        System.out.println("Nhap ma doc gia can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaDocGia())){
                while(sl>0){
                    System.out.println("Ban muon sua thong tin gi?");
                    System.out.println("1. Sua ho.");
                    System.out.println("2. Sua ten.");
                    System.out.println("3. Sua gioi tinh.");
                    System.out.println("4. Sua ngay sinh.");
                    System.out.println("5. Sua so dien thoai.");
                    System.out.println("Nhap lua chon cua ban: ");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ho doc gia moi: ");
                        ds[i].setHo(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==2){
                        System.out.println("Nhap ten doc gia moi: ");
                        ds[i].setTen(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==3){
                        System.out.println("Nhap gioi tinh doc gia moi: ");
                        ds[i].setGioiTinh(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==4){
                        System.out.println("Nhap ngay sinh doc gia moi(yyyy-mm-dd): ");
                        ds[i].setNgaySinh(sc.nextLine());
                        kt=true;
                        break;
                    }else if(c==5){
                        System.out.println("Nhap so dien thoai doc gia moi: ");
                        ds[i].setSDT(sc.nextLine());
                        kt=true;
                        break;
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
        System.out.println("Khong tim thay ma nha cung cap can sua: "+ma);
    }
    public void xoa(){
        System.out.println("Nhap ma doc gia muon xoa: ");
        String ma=sc.nextLine();
        xoa(ma);
    }
    public void xoa(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaDocGia())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa doc gia thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay ma nha cung cap can xoa: "+ma);
    }
    public void docFile(){
        File file=new File("Docgia.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai.");
            return;
        }
        try(Scanner f=new Scanner(file)){    
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==6){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new DocGia(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
                }
            }
        }catch(Exception e){
            System.out.println("Loi doc file.");
        }
    }
    public void ghiFile(){
        try(PrintWriter w=new PrintWriter("Docgia.txt")){
            for(DocGia dg:ds)
                w.println(dg.toString());
        }catch(Exception e){
            System.out.println("Loi ghi file.");
        }
    }
    public void timKiemTheoMaDocGia(){
        System.out.println("Nhap ma doc gia muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoMaDocGia(ma);
    }
    public void timKiemTheoMaDocGia(String ma){
        for(DocGia dg:ds)
            if(ma.equals(dg.getMaDocGia())){
                xuatt();
                dg.xuat();
                xuatd();
                return ;
            }
        System.out.println("Khong tim thay doc gia co ma: "+ma);
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten doc gia muon tim: ");
        String ma=sc.nextLine();
        timKiemTheoTen(ma);
    }
    public void timKiemTheoTen(String ten){
        boolean kt=false;
        for(DocGia dg:ds)
            if(dg.getTen().contains(ten)){
                if(!kt)xuatt();
                dg.xuat();
                kt=true;
            }
        if(kt) xuatd();
        System.out.println("Khong tim thay doc gia co ten: "+ten);
    }
    public int[] thongKeTheoGioiTinh(){
        int nam=0,nu=0;
        for(DocGia dg:ds){
            if(dg.getGioiTinh().contains("Nam")) nam++;
            else nu++;
        }
        System.out.println("So luong doc gia nam: "+nam);
        System.out.println("So luong doc gia nu: "+nu);
        return new int[]{nam,nu};
    }
    public int tinhTuoi(DocGia dg){
        LocalDate date1=LocalDate.parse(dg.getNgaySinh());
        LocalDate date2=LocalDate.now();
        Period tuoi=Period.between(date1, date2);
        return tuoi.getYears();
    }
    public int[] thongKeTheoDoTuoi(){
        int tren20=0,ngay20=0,duoi20=0;
        for(DocGia dg:ds){
            if(tinhTuoi(dg)>20) tren20++;
            else if(tinhTuoi(dg)==20) ngay20++;
            else duoi20++;
        }
        System.out.println("So luong doc gia tren 20 tuoi: "+tren20);
        System.out.println("So luong doc gia ngay 20 tuoi: "+ngay20);
        System.out.println("So luong doc gia duoi 20 tuoi: "+duoi20);
        return new int[]{tren20,ngay20,duoi20};
    }
    public DocGia traVeDocGiaTheoMa(String ma){
        for(DocGia dg:ds)
            if(ma.equals(dg.getMaDocGia()))
                return dg;
        return null;
    }
    public static void main(String[] arg){
        DanhSachDocGia ds=new DanhSachDocGia();
        ds.docFile();
        ds.xuat();
        ds.thongKeTheoDoTuoi();
    }
}

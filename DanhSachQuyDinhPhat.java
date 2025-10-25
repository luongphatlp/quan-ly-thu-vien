import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class DanhSachQuyDinhPhat {
    private QuyDinhPhat[] ds =new QuyDinhPhat[0];
    public DanhSachQuyDinhPhat(){}
    public DanhSachQuyDinhPhat(QuyDinhPhat[] ds){this.ds=Arrays.copyOf(ds,ds.length);}
    public DanhSachQuyDinhPhat(DanhSachQuyDinhPhat ds){this.ds=Arrays.copyOf(ds.ds,ds.ds.length);}

    public QuyDinhPhat[] getDS(){return ds;}
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong quy dinh can nhap: ");
        int bd=ds.length;
        int sl=sc.nextInt();
        sc.nextLine();
        ds=Arrays.copyOf(ds,ds.length+sl);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new QuyDinhPhat(); ds[i].nhap();
        }
    }
    public int getLength(){
        return ds.length;
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new QuyDinhPhat();
        ds[ds.length-1].nhap();
        System.out.println("Them thanh cong.");
    }
    public void them(QuyDinhPhat qd){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new QuyDinhPhat(qd);
        System.out.println("Them thanh cong.");
    }
    public int sua(){
        System.out.println("Nhap ma quy dinh phat can sua: ");
        String ma=sc.nextLine();
        return sua(ma);
    }
    public int sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhat())){
                System.out.println("Nhap lua chon(1.Noi dung 2.Tien phat): ");
                while(sl>0){
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap noi dung: ");
                        ds[i].setNoiDung(sc.nextLine());
                        kt=true;
                    }else if(c==2){
                        System.out.println("Nhap so tien: ");
                        ds[i].setTienPhat(sc.nextInt());
                        sc.nextLine();
                        kt=true;
                    }else{
                        System.out.println("Nhap lua chon khong dung. Vui long nhap lai.");
                        sl--;
                    }
                    if(kt){
                        System.out.println("Sua thong tin thanh cong.");return i;
                    }
                }
            }
        }
        if(!kt)
            System.out.println("Khong tim thay quy dinh phat co ma: "+ma);
        return -1;
    }
    public int timkiem(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhat()))
                return i;
        }
        return -1;
    }
    public void xoa(){
        System.out.println("Nhap ma quy dinh phat can xoa: ");
        String ma=sc.nextLine();
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay quy dinh phat co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++){
            ds[i]=ds[i+1];
        }
        ds=Arrays.copyOf(ds,ds.length-1);
        System.out.println("Xoa thanh cong.");
    }
    public void xoa(String ma){
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay quy dinh phat co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++){
            ds[i]=ds[i+1];
        }
        ds=Arrays.copyOf(ds,ds.length-1);
        System.out.println("Xoa thanh cong.");
    }
    public void xuat(){
        xuatt();
        for(QuyDinhPhat qd:ds)
            qd.xuat();
        xuatd();
    }
    private void xuatt(){
        System.out.println("+------------+----------------------------------------------------+------------+");
        System.out.printf("| %-10s | %-50s | %-10s |\n","Ma phat","Noi dung","Tien phat");
        System.out.println("|------------|----------------------------------------------------|------------|");
    }
    private void xuatd(){
        System.out.println("+------------+----------------------------------------------------+------------+"); 
    }
    public void docFile(){
        File file=new File("Quydinhphat.txt");
        if(!file.exists()){
            System.out.println("Khong ton tai file.");
            return;
        }
        try(Scanner f=new Scanner(file)){
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==3){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new QuyDinhPhat(parts[0],parts[1],Integer.parseInt(parts[2]));
                }
            }
        }catch(FileNotFoundException e){
                System.out.println("Khong the doc file."+e.getMessage());
        }
    }
    public void ghiFile(){
        File file=new File("Quydinhphat.txt");
        try(PrintWriter pw =new PrintWriter(file)){
            for(QuyDinhPhat qd:ds){
                pw.println(qd.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Loi ghi file"+ e.getLocalizedMessage());
        }
    }
    public QuyDinhPhat layQuyDinhPhatTuMa(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhat()))
                return ds[i];
        }
        return null;
    }
    public void timKiemTheoMaQuyDinh(){
        System.out.println("Nhap ma phat muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaPhat())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(kt) 
            xuatd();
        else
            System.out.println("Khong tim thay quy dinh co ma: "+ma);  
    }
    public void timKiemTheoMoTa(){
        System.out.println("Nhap ten the loai muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(QuyDinhPhat p:ds)
            if(ten.contains(p.getNoiDung())){
                if(!kt)xuatt();
                p.xuat();
                kt=true;
            }
        if(kt)xuatd();
        if(!kt)    
            System.out.println("Khong tim thay quy dinh co noi dung: "+ten);
    }
    public void thongKeTheoTienPhat(){
        Map<Integer,Integer> countmap =new HashMap<>();
        for(QuyDinhPhat p:ds)
            countmap.put(p.getTienPhat(),countmap.getOrDefault(p.getTienPhat(), 0)+1);   
        for(Map.Entry<Integer,Integer> entry : countmap.entrySet())
            System.out.println("So luong quy dinh co tien phat "+entry.getKey()+": "+entry.getValue());
    }
    public int thongKeSoLuongQuyDinh(){
        System.out.println("So luong quy dinh phat: "+ds.length);
        return ds.length;
    }
    public static void main(String[] args){
        DanhSachQuyDinhPhat ds =new DanhSachQuyDinhPhat();
        ds.docFile();
        ds.them();
        //ds.nhap();
        //ds.sua();
        //ds.xoa();
        //ds.xuat();
        ds.ghiFile();
    }
}

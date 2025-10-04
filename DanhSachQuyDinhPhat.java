import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachQuyDinhPhat {
    QuyDinhPhat[] ds =new QuyDinhPhat[0];
    public DanhSachQuyDinhPhat(){}
    public DanhSachQuyDinhPhat(QuyDinhPhat[] ds){this.ds=ds;}
    public DanhSachQuyDinhPhat(DanhSachQuyDinhPhat ds){this.ds=ds.ds;}

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong quy dinh can nhap: ");
        int bd=ds.length;
        int sl=sc.nextInt();
        sc.nextLine();
        ds=Arrays.copyOf(ds,ds.length+sl);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new QuyDinhPhat();
            ds[i].nhap();
        }
    }
    public int length(){
        return ds.length;
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new QuyDinhPhat();
        ds[ds.length-1].nhap();
    }
    public void them(QuyDinhPhat qd){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new QuyDinhPhat(qd);
    }
    public void sua(){
        System.out.println("Nhap ma quy dinh phat can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
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
                        System.out.println("Sua thong tin thanh cong.");return;
                    }
                }
            }
        }
        if(!kt){
            System.out.println("Khong tim thay quy dinh phat co ma: "+ma);
        }
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
    public void xuat(){
        System.out.println("+------------+----------------------------------------------------+------------+");
        System.out.printf("| %-10s | %-50s | %-10s |\n","Ma phat","Noi dung","Tien phat");
        System.out.println("|------------|----------------------------------------------------|------------|");
        for(QuyDinhPhat qd:ds)
            qd.xuat();
        System.out.println("+------------+----------------------------------------------------+------------+");    
    }
    public void docfile(){
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
    public void ghifile(){
        File file=new File("Quydinhphat.txt");
        if(!file.exists()){
            System.out.println("Khong ton tai file.");
            return;
        }
        try(PrintWriter pw =new PrintWriter(file)){
            for(QuyDinhPhat qd:ds){
                pw.println(qd.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Loi ghi file"+ e.getLocalizedMessage());
        }
    }
    public QuyDinhPhat layquydinhphattuma(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaPhat()))
                return ds[i];
        }
        return null;
    }
    public static void main(String[] args){
        DanhSachQuyDinhPhat ds =new DanhSachQuyDinhPhat();
        ds.docfile();
        ds.them();
        //ds.nhap();
        //ds.sua();
        //ds.xoa();
        //ds.xuat();
        ds.ghifile();
    }
}

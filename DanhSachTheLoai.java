import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachTheLoai {
    TheLoai[] ds=new TheLoai[0];
    public DanhSachTheLoai(){}
    public DanhSachTheLoai(TheLoai[] ds){
        this.ds=ds;
    }
    public DanhSachTheLoai(DanhSachTheLoai ds){
        this.ds=ds.ds;
    }
    Scanner sc=new Scanner(System.in);
    public void nhap(){
        System.out.println("Nhap so luong sinh vien can nhap them: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds = Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new TheLoai();
            ds[i].nhap();
        }
    }
    public void xuat(){
        System.out.println("+-------------+--------------+----------------------------------------------------+");
        System.out.printf("| %-11s | %-12s | %-50s |\n","Ma the loai","Ten the loai","mo ta");
        for(int i=0;i<ds.length;i++){        
            System.out.printf("| %-11s | %-12s | %-50s |\n",ds[i].getMaTheLoai(),ds[i].getTenTheLoai(),ds[i].getMoTa());
            System.out.println("+-------------+--------------+----------------------------------------------------+");
        }    
    }
    public void them(TheLoai tl){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new TheLoai(tl);
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new TheLoai();
        System.out.println("Nhap thong tin the loai muon them.");
        ds[ds.length-1].nhap();
    }
    public void sua(){
        System.out.println("Nhap ma the loai can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaTheLoai())){
                System.out.println("Nhap lua chon muon sua(1.ten the loai 2.mo ta)");
                while(sl>0){
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ten: ");
                        ds[i].setTenTheLoai(sc.nextLine());
                        kt=true;
                    }else if(c==2){
                        System.out.println("Nhap mo ta: ");
                        ds[i].setMota(sc.nextLine());
                        kt=true;
                    }else{
                        System.out.println("Nhap lua chon khong dung. Vui long nhap lai.");
                    }
                    sl--;
                    if(kt){
                        System.out.println("Sua thong tin thanh cong.");
                        return;
                    }
                }
            }
        }
        if(!kt)
            System.out.println("Khong tim thay the loai co ma: "+ma);
    }
    public void xoa(){
        System.out.println("Nhap ma the loai muon xoa: ");
        String ma=sc.nextLine();
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTheLoai())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ ma);
    }
    public void docfile(){
        File file=new File("Theloai.txt");
        try(Scanner f=new Scanner(file)){
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==5){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new TheLoai(parts[0],parts[1],parts[2]);
                }    
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tim duoc File");
        }
    }
    
    public void ghifile(){
        File file=new File("Theloai.txt");
        try(PrintWriter pw=new PrintWriter(file)){
            for(TheLoai tl:ds){
                pw.println(tl.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tao duoc File");
        }
    }
    public static void main(String[] args){
        DanhSachTheLoai ds=new DanhSachTheLoai();
        ds.nhap();
        //ds.them();
        //ds.sua();
        //ds.xoa();
        ds.ghifile();
    }
}

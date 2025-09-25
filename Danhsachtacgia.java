import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Danhsachtacgia {
    Tacgia[] ds=new Tacgia[0];
    Scanner sc = new Scanner(System.in);
    public Danhsachtacgia(){}
    public Danhsachtacgia(Tacgia[] ds){
        this.ds=ds;
    }
    public Danhsachtacgia(Danhsachtacgia ds){
        this.ds=ds.ds;
    }
    public void nhap(){
        System.out.println("Nhap so luong sinh vien can nhap them: ");
        int k=sc.nextInt();
        int bd=ds.length;
        ds = Arrays.copyOf(ds,ds.length+k);
        int tt=0;
        for(int i=bd;i<ds.length;i++){
            System.out.println("Nhap thong tin tac gia thu "+tt+" :");
            ds[i]=new Tacgia();
            ds[i].nhap();
        }
    }
    public void sua(){
        System.out.println("Nhap ma tac gia can sua: ");
        String matg=sc.nextLine();
        for(Tacgia tg: ds)
            if(matg.equals(tg.getMaTacGia()))
                tg.sua();
        System.out.println("Khong tim thay tac gia co ma: "+matg);
    }
    public void xuat(){
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
        System.out.printf("| %-10s | %-15s | %-10s | %-9s | %-12s |\n", "Ma tac gia", "Ho", "Ten", "Gioi tinh", "Ngay sinh");
        System.out.println("|------------|-----------------|------------|-----------|--------------|");
        for(Tacgia tg:ds)
            tg.xuat();
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
    }
    private void xuatd(){
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
        System.out.printf("| %-10s | %-15s | %-10s | %-9s | %-12s |\n", "Ma tac gia", "Ho", "Ten", "Gioi tinh", "Ngay sinh");
    }
    private void xuatc(){
        System.out.println("|------------|-----------------|------------|-----------|--------------|");
    }
    public void xoa(){
        System.out.println("Nhap ma tac gia muon xoa: ");
        String ma=sc.nextLine();
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTacGia())){
                for(int j=i;j<ds.length-1;j++)
                    ds[j]=ds[j+1];
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ ma);
    }
    public void timkiem(){
        System.out.println("Nhap ma tac gia muon tim: ");
        String ma=sc.nextLine();
        for(Tacgia tg:ds)
            if(ma.equals(tg.getMaTacGia())){
                xuatd();
                tg.xuat();
                xuatc();
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ma);       
    }
    public void timkiemtheoten(){
        System.out.println("Nhap ma tac gia muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(Tacgia tg:ds)
            if(ten.equals(tg.getTen())){
                xuatd();
                tg.xuat();
                xuatc();
                kt=true;
            }
        if(!kt)    
            System.out.println("Khong tim thay tac gia co ten: "+ten);
    }
    public void docfile(){ 
        File file = new File("Tacgia.txt");
        try{       
            Scanner f = new Scanner(file);
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==5){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new Tacgia(parts[0],parts[1],parts[2],parts[3],parts[4]);
                }    
                
            }
            f.close();
        }catch(FileNotFoundException e){
            System.out.println("Khong tim duoc file!");
        }   
    }
    public void ghifile(){
        File file = new File("Tacgia.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            for(Tacgia tg:ds)
                pw.println(tg.toString());
            System.out.println("Ghi file thành công!");
            pw.close();
        } catch (FileNotFoundException e){
            System.out.println("Không tạo được file!");
        }             
    }
    public void sapxeptheoma(){
        Arrays.sort(ds,Comparator.comparing(tg -> tg.getMaTacGia()));
    } 
    public void sapxeptheoten(){
        Arrays.sort(ds,Comparator.comparing(Tacgia::getTen).thenComparing(Tacgia::getHo));
    }
    public static void main(String[] agrs){
        Danhsachtacgia ds=new Danhsachtacgia();
        ds.docfile();
        //ds.nhap();
        //ds.sua();
        //ds.xoa();
        //ds.timkiem();
        //ds.timkiemtheoten();
        //ds.sapxeptheoma();
        //ds.sapxeptheoten();
        //ds.ghifile();
        ds.xuat();
    }
}

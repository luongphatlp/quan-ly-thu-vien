import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachTacGia {
    private Tacgia[] ds=new Tacgia[0];
    Scanner sc = new Scanner(System.in);
    public DanhSachTacGia(){}
    public DanhSachTacGia(Tacgia[] ds2){
        this.ds=Arrays.copyOf(ds2,ds2.length);
    }
    public DanhSachTacGia(DanhSachTacGia ds2){
        this.ds=Arrays.copyOf(ds2.ds,ds2.ds.length);
    }
    public int getLength(){return ds.length;}
    public void nhap(){
        System.out.println("Nhap so luong sinh vien can nhap them: ");
        int k=sc.nextInt();
        sc.nextLine();
        int bd=ds.length;
        ds = Arrays.copyOf(ds,ds.length+k);
        int tt=1;
        for(int i=bd;i<ds.length;i++){
            System.out.println("Nhap thong tin tac gia thu "+tt+" :");tt++;
            ds[i]=new Tacgia();
            ds[i].nhap();
        }
    }
    private boolean kiemTraMaTacGiaDuyNhat(String ma){
        int i=0;
        for(Tacgia tg:ds)
            if(ma.equals(tg.getMaTacGia()))
                i++;
        if(i>1) return false;
        return true;
    }
    public void them(){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new Tacgia();
        System.out.println("Nhap thong tin tac gia can them");
        ds[ds.length-1].nhap();
    }
    public void them(Tacgia tg){
        ds=Arrays.copyOf(ds,ds.length+1);
        if(kiemTraMaTacGiaDuyNhat(tg.getMaTacGia()))
            System.out.println("Trung ma tac gia.");
        else    
        ds[ds.length-1]=new Tacgia(tg);
    }
    public void sua(){
        System.out.println("Nhap ma tac gia can sua: ");
        String ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        int c=0,sl=5;
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaTacGia())){
                
                while(sl>0){
                    System.out.println("Nhap lua chon sua 1.ho ten 2.gioi tinh 3.ngay sinh");
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ho tac gia: ");
                        ds[i].setHo(sc.nextLine());
                        System.out.println("Nhap ten tac gia: ");
                        ds[i].setTen(sc.nextLine());
                        kt=true;
                    }else if(c==2){
                        System.out.println("Nhap gioi tinh tac gia: ");
                        ds[i].setGioiTinh(sc.nextLine());
                        kt=true;
                    }else if(c==3){
                        System.out.println("Nhap ngay sinh tac gia: ");
                        ds[i].setNgaySinh(sc.nextLine());
                        kt=true; 
                    }else{
                        System.out.println("Nhap lua chon khong dung. Vui long chon lai.");
                        sl--;
                    }
                    if(kt){
                        System.out.println("Sua thong tin thanh cong.");return;
                    }
                }   
            }
        }
        if(!kt)
            System.out.println("Khong tim thay tac gia co ma: "+ma);
    }
    public void xuat(){
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
        System.out.printf("| %-10s | %-15s | %-10s | %-9s | %-12s |\n", "Ma tac gia", "Ho", "Ten", "Gioi tinh", "Ngay sinh");
        System.out.println("|------------|-----------------|------------|-----------|--------------|");
        for(Tacgia tg:ds)
            tg.xuat();
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
    }
    private void xuatt(){
        System.out.printf("+------------+-----------------+------------+-----------+--------------+\n");
        System.out.printf("| %-10s | %-15s | %-10s | %-9s | %-12s |\n", "Ma tac gia", "Ho", "Ten", "Gioi tinh", "Ngay sinh");
        System.out.println("|------------|-----------------|------------|-----------|--------------|");
    }
    private void xuatd(){
        System.out.println("+------------+-----------------+------------+-----------+--------------+");
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
                xuatt();
                tg.xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ma);       
    }
    public void timkiemtheoten(){
        System.out.println("Nhap ten tac gia muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(Tacgia tg:ds)
            if(ten.equals(tg.getTen())){
                xuatt();
                tg.xuat();
                xuatd();
                kt=true;
            }
        if(!kt)    
            System.out.println("Khong tim thay tac gia co ten: "+ten);
    }
    public void docfile(){ 
        File file = new File("Tacgia.txt");
        if(!file.exists()){
            System.out.println("File khong ton tai!");
            return;
        }
        try(Scanner f = new Scanner(file)){       
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==5){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    ds[ds.length-1]=new Tacgia(parts[0],parts[1],parts[2],parts[3],parts[4]);
                }    
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tim duoc file!");
        }   
    }
    public void ghifile(){
        File file = new File("Tacgia.txt");
        try(PrintWriter pw = new PrintWriter(file)){
            for(Tacgia tg:ds)
                pw.println(tg.toString());
            System.out.println("Ghi file thành công!");
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
        DanhSachTacGia ds=new DanhSachTacGia();
        //ds.docfile();
        ds.nhap();
        ds.them();
        ds.sua();
        ds.xoa();
        ds.timkiem();
        //ds.timkiemtheoten();
        //ds.sapxeptheoma();
        //ds.sapxeptheoten();
        //ds.ghifile();
        ds.xuat();
    }
}

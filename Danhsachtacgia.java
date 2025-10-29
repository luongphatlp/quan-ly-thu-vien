import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
public class DanhSachTacGia {
    private TacGia[] ds=new TacGia[0];
    Scanner sc = new Scanner(System.in);
    public DanhSachTacGia(){}
    public DanhSachTacGia(TacGia[] ds2){
        this.ds=Arrays.copyOf(ds2,ds2.length);
    }
    public DanhSachTacGia(DanhSachTacGia ds2){
        this.ds=Arrays.copyOf(ds2.ds,ds2.ds.length);
    }
    public int getLength(){return ds.length;}
    public void nhap(){
        System.out.println("Nhap so luong tac gia can nhap them: ");
        int sl=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<sl;i++){
            int k=5;
            boolean kt=false;
            System.out.println("Nhap thong tin tac gia thu "+(i+1)+":");
            while(k>0 && !kt){
                TacGia tg=new TacGia();
                tg.nhap();
                if(them(tg))
                    kt=true;
                else{
                    System.out.println("Ma tac gia da ton tai vui long nhap lai");
                    k--;
                } 
            }
            if(!kt){
                System.out.println("Nhap qua so lan quy dinh");
                return;
            } 
        }
    }
    private boolean kiemTraMaTacGiaDuyNhat(String ma){
        for(TacGia tg:ds)
            if(ma.equals(tg.getMaTacGia()))
                return false;
        return true;
    }
    public void them(){
        int k=5;
        boolean kt=false;
        System.out.println("Nhap thong tin tac gia can them");
        while(k>0 && !kt){
          TacGia tg=new TacGia();
            tg.nhap();
            if(them(tg))
                kt=true;      
            else{
                System.out.println("Ma tac gia da ton tai vui long nhap lai");
                k--;
            }
        }
    }
    public boolean them(TacGia tg){
        if(kiemTraMaTacGiaDuyNhat(tg.getMaTacGia())){
            ds=Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=new TacGia(tg);
            return true;
        }
        return false;
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
                        System.out.println("Sua thong tin thanh cong.");
                        return;
                    }
                }
            }
        }
        if(!kt)
            System.out.println("Khong tim thay tac gia co ma: "+ma);
    }
    public void xuat(){
        xuatt();
        for(TacGia tg:ds)
            tg.xuat();
        xuatd();
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
    public void timKiemTheoMaTacGia(){
        System.out.println("Nhap ma tac gia muon tim: ");
        String ma=sc.nextLine();
        for(TacGia tg:ds)
            if(ma.equals(tg.getMaTacGia())){
                xuatt();
                tg.xuat();
                xuatd();
                return;
            }
        System.out.println("Khong tim thay tac gia co ma: "+ma);       
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten tac gia muon tim: ");
        String ten=sc.nextLine();
        Boolean kt=false;
        for(TacGia tg:ds)
            if(ten.contains(tg.getTen())){
                if(!kt)xuatt();
                tg.xuat();
                kt=true;
            }
        if(kt)xuatd();
        if(!kt)    
            System.out.println("Khong tim thay tac gia co ten: "+ten);
    }
    public void docFile(){ 
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
                    ds[ds.length-1]=new TacGia(parts[0],parts[1],parts[2],parts[3],parts[4]);
                }    
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tim duoc file!");
        }   
    }
    public void ghiFile(){
        File file = new File("Tacgia.txt");
        try(PrintWriter pw = new PrintWriter(file)){
            for(TacGia tg:ds)
                pw.println(tg.toString());
            System.out.println("Ghi file thành công!");
        } catch (FileNotFoundException e){
            System.out.println("Không tạo được file!");
        }             
    }
    public void thongKeTheoGioiTinh(){
        int nam=0,nu=0;
        for(TacGia tg:ds){
            if("Nam".equalsIgnoreCase(tg.getGioiTinh()))
                nam++;
            else 
                nu++;
        }
        System.out.println("So luong tac gia co gioi tinh nam: "+nam);
        System.out.println("So luong tac gia co gioi tinh nu: "+nu);
    }
    private int tinhTuoi( TacGia tg){
        LocalDate date1=LocalDate.parse(tg.getNgaySinh());
        LocalDate date2=LocalDate.now();
        Period tuoi=Period.between(date1,date2);
        return tuoi.getYears();
    }
    public void thongKeTheoTuoi(){
        int duoi30=0,ngay30=0,tren30=0;
        for(TacGia tg:ds){
            if(tinhTuoi(tg) < 30) duoi30++;
            else if(tinhTuoi(tg)>30) tren30++;
            else ngay30++;
        }
        System.out.println("So luong tac gia tren 30 tuoi: "+tren30);
        System.out.println("So luong tac gia 30 tuoi: "+ngay30);
        System.out.println("So luong tac gia duoi 30 tuoi: "+duoi30);
    }
    public static void main(String[] agrs){
        DanhSachTacGia ds=new DanhSachTacGia();
        ds.docFile();
        ds.xuat();
        ds.timKiemTheoMaTacGia();
        ds.timKiemTheoTen();
        //ds.timkiemtheoten();
        //ds.sapxeptheoma();
        //ds.sapxeptheoten();
        //ds.ghifile();
         ds.xuat();
    }
}

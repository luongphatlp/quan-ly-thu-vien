import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class DanhSachSach {
    Sach[] ds=new Sach[0];
    public DanhSachSach (){}
    public DanhSachSach(Sach[] ds){this.ds=ds;}
    public DanhSachSach(DanhSachSach ds){this.ds=ds.ds;}
    
    Scanner sc=new Scanner(System.in);
    public void them(){
        System.out.println("nhap lua chon (1.sach giao khoa 2.sach tham khao)");
        int c=0;
        ds=Arrays.copyOf(ds,ds.length+1);
        while(true){
            c=sc.nextInt();
            if(c==1){
                ds[ds.length-1]=new SachGiaoKhoa();ds[ds.length-1].nhap();
                break;
            }else if(c==2){
                ds[ds.length-1]=new SachThamKhao();ds[ds.length-1].nhap();
                break;
            }else{
                System.out.println("Lua chon khong dung.Vui long chon lai.");
            }
        }
    }
    public void them(Sach s){
        if(s instanceof SachGiaoKhoa){
            ds[ds.length-1]=new SachGiaoKhoa((SachGiaoKhoa)s);
        }else{
            ds[ds.length-1]=new SachThamKhao((SachThamKhao)s);
        }
    }
    public void nhap(){
        System.out.println("Nhap so luong sach muon nhap: ");
        int bd=ds.length;
        int sl=sc.nextInt();
        ds=Arrays.copyOf(ds,ds.length+sl);
        int c=0,k=5;
        for(int i=bd;i<ds.length;i++){
            System.out.println("Nhap lua chon loai sach (1.Sach giao khoa 2.Sach tham khao)");
            while(k>0){
                c=sc.nextInt();
                sc.nextLine();
                if(c==1){
                    ds[i]=new SachGiaoKhoa();ds[i].nhap();
                    break;
                }else if(c==2){
                    ds[i]=new SachThamKhao();ds[i].nhap();
                    break;
                }else{
                    System.out.println("Lua chon khong dung.Vui long chon lai.");
                }
                k--;
            }
        }
    }
    public void xuat(){
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-11s | %-10s | %-15s | %-15s | %-58s |", "Ma sach", "Ten sach", "Ma the loai", "Ma tac gia", "Ma nha xuat ban","Nam xuat ban","Thong tin bo sung");
        System.out.printf("\n|------------|----------------------|-------------|------------|-----------------|-----------------|------------------------------------------------------------|\n");
        for(int i=0;i<ds.length;i++){
            ds[i].xuat();
        }
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+\n");
    }
    private void xuatt(){
        System.out.printf("+------------+----------------------+-------------+------------+------------+-----------------+------------------------------------------------------------+\n");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s | %-15s |", "Ma sach", "Ten sach", "Ma the loai", "Ma tac gia", "Ma nha xuat ban","Nam xuat ban");
    }
    private void xuatd(){
        System.out.println("|------------|----------------------|-------------|------------|------------|-----------------|------------------------------------------------------------|");
    }
    public int timkiem(String ma){
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaSach()))
                return i;
        return -1;        
    }
    public void xoa(){
        System.out.println("Nhap ma sach can xoa: ");
        String ma=sc.nextLine();
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay sach co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++){
            ds[i]=ds[i+1];
        }
        ds=Arrays.copyOf(ds,ds.length-1);
    }
    public void xoa(String ma){
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay sach co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++){
            ds[i]=ds[i+1];
        }
        ds=Arrays.copyOf(ds,ds.length-1);
    }
    public void sua(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaSach())){
                if(ds[i] instanceof SachGiaoKhoa)
                    suagiaokhoa((SachGiaoKhoa)ds[i]);
                else 
                    suathamkhao((SachThamKhao)ds[i]);
            }
        }    
    }
    public void sua(){
        System.out.println("Nhap ma sach can sua: ");
        String ma=sc.nextLine();
        sua(ma);   
    }
    private void suagiaokhoa(SachGiaoKhoa s){
        int c=0,sl=5;
        System.out.println("Nhap lua chon muon sua (1.ten 2.ma the loai 3.ma tac gia 4.ma nha xuat ban 5.nam xuat ban 6.mon 7.lop): ");
        c=sc.nextInt();
        sc.nextLine();
        while(sl>=0){
            c=sc.nextInt();
            sc.nextLine();
            if(c==1){
                System.out.println("Nhap ten sach: ");
                s.setTenSach(sc.nextLine());
                break;
            }else if(c==2){
                System.out.println("Nhap ma the loai: ");
                s.setMaTheLoai(sc.nextLine());
                break;
            }else if(c==3){
                System.out.println("Nhap ma tac gia: ");
                s.setMaTacGia(sc.nextLine());
                break;
            }else if(c==4){
                System.out.println("Nhap ma nha xuat ban: ");
                s.setMaNXB(sc.nextLine());    
                break;
            }else if(c==5){
                System.out.println("Nhap nam xuat ban: ");    
                s.setNamXuatBan(sc.nextLine());
                break;
            }else if(c==6){
                System.out.println("Nhap mon: ");
                s.setMon(sc.nextLine());
                break;
            }else if(c==7){
                System.out.println("Nhap lop: ");
                s.setLop(sc.nextLine());
                break;    
            }else{
                System.out.println("Nhap lua chon khong dung.Vui long chon lai.");
            }
            sl--;
        }
    }
    private void suathamkhao(SachThamKhao s){
        int c=0,sl=5;
        System.out.println("Nhap lua chon muon sua (1.ten 2.ma the loai 3.ma tac gia 4.ma nha xuat ban 5.nam xuat ban 6.linh vuc 7.loai doc gia): ");
        c=sc.nextInt();
        sc.nextLine();
        while(sl>=0){
            c=sc.nextInt();
            sc.nextLine();
            if(c==1){
                System.out.println("Nhap ten sach: ");
                s.setTenSach(sc.nextLine());
                break;
            }else if(c==2){
                System.out.println("Nhap ma the loai: ");
                s.setMaTheLoai(sc.nextLine());
                break;
            }else if(c==3){
                System.out.println("Nhap ma tac gia: ");
                s.setMaTacGia(sc.nextLine());
                break;
            }else if(c==4){
                System.out.println("Nhap ma nha xuat ban: ");
                s.setMaNXB(sc.nextLine());    
                break;
            }else if(c==5){
                System.out.println("Nhap nam xuat ban: ");    
                s.setNamXuatBan(sc.nextLine());
                break;
            }else if(c==6){
                System.out.println("Nhap linh vuc: ");
                s.setLinhVuc(sc.nextLine());
                break;
            }else if(c==7){
                System.out.println("Nhap loai doc gia: ");
                s.setLoaiDocGia(sc.nextLine());
                break;    
            }else{
                System.out.println("Nhap lua chon khong dung.Vui long chon lai.");
            }
            sl--;
        }
    }
    public void docfile(){
        File file=new File("Sach.txt");
        try(Scanner f=new Scanner(file)){
            while(f.hasNextLine()){
                String line=f.nextLine();
                String[] parts=line.split(",");
                if(parts.length==9){
                    ds=Arrays.copyOf(ds,ds.length+1);
                    if("GK".equals(parts[0]))
                        ds[ds.length-1]=new SachGiaoKhoa(parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
                    else if("TK".equals(parts[0]))
                        ds[ds.length-1]=new SachThamKhao(parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
                }    
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong doc duoc file");
        }
    }
    public void ghifile(){
        File file=new File("Sach.txt");
        try(PrintWriter pw =new PrintWriter(file)){
            for(int i=0;i<ds.length;i++){
                if(ds[i] instanceof SachGiaoKhoa)
                    pw.println("GK,"+ds[i].toString());
                else if(ds[i] instanceof SachThamKhao)
                    pw.println("TK,"+ds[i].toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Khong tao duoc file");
        }
    }
    public static void main(String[] args){
        DanhSachSach ds=new DanhSachSach();
        ds.docfile();
        ds.xuat();
    }
}

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
    public void them(Sach s){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=s;
    }
    public void them(){
        System.out.println("nhap lua chon (1.sach giao khoa 2.sach tham khao 3.con lai)");
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
    public void nhap(){
        System.out.println("Nhap so luong sach muon nhap: ");
        int sl=sc.nextInt();
        int bd=ds.length;
        int c=0;
        ds=Arrays.copyOf(ds,ds.length+sl);
        for(int i=bd;i<ds.length;i++){
            while(true){
                c=sc.nextInt();
                if(c==1){
                    ds[i]=new SachGiaoKhoa();ds[i].nhap();
                    break;
                }else if(c==2){
                    ds[i]=new SachThamKhao();ds[i].nhap();
                    break;
                }else{
                    System.out.println("Lua chon khong dung.Vui long chon lai.");
                }
            }
        }
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
    public void sua(){
        int c=0,sl=5;
        System.out.println("Nhap ma sach can sua: ");
        String ma=sc.nextLine();
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaSach())){
                while(sl>=0){
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ten sach: ");
                        ds[i].setTenSach(sc.nextLine());
                    }else if(c==2){
                        System.out.println("Nhap ma the loai: ");
                        ds[i].setMaTheLoai(sc.nextLine());
                    }else if(c==3){
                        System.out.println("Nhap ma tac gia: ");
                        ds[i].setMaTacGia(sc.nextLine());
                    }else if(c==4){
                        System.out.println("Nhap ma nha xuat ban: ");
                        ds[i].setMaNXB(sc.nextLine());    
                    }else if(c==5){
                        System.out.println("Nhap nam xuat ban: ");    
                        ds[i].setNamXuatBan(sc.nextLine());
                    }else{
                        System.out.println("Nhap lua chon khong dung.Vui long chon lai.");
                    }
                    sl--;
                }
            }    
        } 
    }
    public void sua(String ma){
        int c=0,sl=5;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaSach())){
                while(sl>=0){
                    c=sc.nextInt();
                    sc.nextLine();
                    if(c==1){
                        System.out.println("Nhap ten sach: ");
                        ds[i].setTenSach(sc.nextLine());
                    }else if(c==2){
                        System.out.println("Nhap ma the loai: ");
                        ds[i].setMaTheLoai(sc.nextLine());
                    }else if(c==3){
                        System.out.println("Nhap ma tac gia: ");
                        ds[i].setMaTacGia(sc.nextLine());
                    }else if(c==4){
                        System.out.println("Nhap ma nha xuat ban: ");
                        ds[i].setMaNXB(sc.nextLine());    
                    }else if(c==5){
                        System.out.println("Nhap nam xuat ban: ");    
                        ds[i].setNamXuatBan(sc.nextLine());
                    }else{
                        System.out.println("Nhap lua chon khong dung.Vui long chon lai.");
                    }
                    sl--;
                }
            }    
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
}

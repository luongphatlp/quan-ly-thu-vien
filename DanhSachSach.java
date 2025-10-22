import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class DanhSachSach {
    private Sach[] ds=new Sach[0];
    public DanhSachSach (){}
    public DanhSachSach(Sach[] ds2){this.ds=Arrays.copyOf(ds2,ds2.length);}
    public DanhSachSach(DanhSachSach ds2){this.ds=Arrays.copyOf(ds2.ds,ds2.ds.length);}
    
    Scanner sc=new Scanner(System.in);
    public int getLength(){return ds.length;}
    public void them(){
        int c=0,sl=5;
        boolean kt=false;
        ds=Arrays.copyOf(ds,ds.length+1);
        while(sl>0){
            System.out.println("nhap lua chon (1.sach giao khoa 2.sach tham khao)");
            c=sc.nextInt();
            sc.nextLine();
            if(c==1){
                ds[ds.length-1]=new SachGiaoKhoa();ds[ds.length-1].nhap();
                kt=true;
                break;
            }else if(c==2){
                ds[ds.length-1]=new SachThamKhao();ds[ds.length-1].nhap();
                kt=true;
                break;
            }else{
                System.out.println("Lua chon khong dung.Vui long chon lai.");
                sl--;
            }
        }
        if(!kt)
            System.out.println("Them thanh cong.");
        else
            System.out.println("Them khong thanh cong.");
    }
    public void them(Sach s){
        if(s instanceof SachGiaoKhoa){
            ds[ds.length-1]=new SachGiaoKhoa((SachGiaoKhoa)s);
        }else{
            ds[ds.length-1]=new SachThamKhao((SachThamKhao)s);
        }
    }
    public void nhap(){
        System.out.println("Nhap so luong sach muon them: ");
        int bd=ds.length;
        int sl=sc.nextInt();
        ds=Arrays.copyOf(ds,ds.length+sl);
        int c=0,k=5;
        boolean kt=false;
        for(int i=bd;i<ds.length;i++){
            System.out.println("Nhap lua chon loai sach (1.Sach giao khoa 2.Sach tham khao)");
            while(k>0){
                c=sc.nextInt();
                sc.nextLine();
                if(c==1){
                    ds[i]=new SachGiaoKhoa();ds[i].nhap();
                    kt=true;
                    break;
                }else if(c==2){
                    ds[i]=new SachThamKhao();ds[i].nhap();
                    kt=true;
                    break;
                }else{
                    System.out.println("Lua chon khong dung.Vui long chon lai.");
                    k--;
                }
            }
        }
        if(kt)
            System.out.println("Them thanh cong.");
        else 
            System.out.println("Them khong thanh cong.");
    }
    public void xuat(){
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-11s | %-10s | %-15s | %-15s | %-58s |\n", "Ma sach", "Ten sach", "Ma the loai", "Ma tac gia", "Ma nha xuat ban","Nam xuat ban","Thong tin bo sung");
        System.out.println("|------------|----------------------|-------------|------------|-----------------|-----------------|------------------------------------------------------------|");
        for(int i=0;i<ds.length;i++){
            ds[i].xuat();
        }
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+\n");
    }
    private void xuatt(){
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+");
        System.out.printf("| %-10s | %-20s | %-11s | %-10s | %-15s | %-15s | %-58s |\n", "Ma sach", "Ten sach", "Ma the loai", "Ma tac gia", "Ma nha xuat ban","Nam xuat ban","Thong tin bo sung");
        System.out.println("|------------|----------------------|-------------|------------|-----------------|-----------------|------------------------------------------------------------|");
    }
    private void xuatd(){
        System.out.println("+------------+----------------------+-------------+------------+-----------------+-----------------+------------------------------------------------------------+");
    }
    public int timKiem(String ma){
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaSach()))
                return i;
        return -1;        
    }
    public void xoa(){
        System.out.println("Nhap ma sach can xoa: ");
        String ma=sc.nextLine();
        int k=timKiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay sach co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++)
            ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds,ds.length-1);
        System.out.println("Xoa thanh cong.");
    }
    public void xoa(String ma){
        int k=timKiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay sach co ma: "+ma);
            return;
        }
        for(int i=k;i<ds.length-1;i++)
            ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds,ds.length-1);
        System.out.println("Xoa thanh cong.");
    }
    public void sua(){
        System.out.println("Nhap ma sach can sua: ");
        String ma=sc.nextLine();
        sua(ma);   
    }
    public void sua(String ma){
        boolean kt=false;
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getMaSach())){
                if(ds[i] instanceof SachGiaoKhoa){
                    suaGiaoKhoa((SachGiaoKhoa)ds[i]);
                    kt=true;
                    break;
                }else{
                    suaThamKhao((SachThamKhao)ds[i]);
                    kt=true;
                    break;
                } 
            }
        }    
        if(!kt) 
            System.out.println("Khong tim that sach co ma: "+ma);
        else 
            System.out.println("sua thanh cong");
    }
    private void suaGiaoKhoa(SachGiaoKhoa s){
        int c=0,sl=5;
        System.out.println("Nhap lua chon muon sua (1.ten sach 2.ma the loai 3.ma tac gia 4.ma nha xuat ban 5.nam xuat ban 6.mon 7.lop): ");
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
                sl--;
            }
        }
    }
    private void suaThamKhao(SachThamKhao s){
        int c=0,sl=5;
        System.out.println("Nhap lua chon muon sua (1.ten sach 2.ma the loai 3.ma tac gia 4.ma nha xuat ban 5.nam xuat ban 6.linh vuc 7.loai doc gia): ");
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
                sl--;
            }
        }
    }
    public void docFile(){
        File file=new File("Sach.txt");
        if(!file.exists()){
            System.out.println("Khong tiem thay file.");
            return;
        }
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
    public void ghiFile(){
        File file=new File("Sach.txt");
        try(PrintWriter pw =new PrintWriter(file)){
            for(int i=0;i<ds.length;i++)
                if(ds[i] instanceof SachGiaoKhoa)
                    pw.println("GK,"+ds[i].toString());
                else if(ds[i] instanceof SachThamKhao)
                    pw.println("TK,"+ds[i].toString());
        }catch(FileNotFoundException e){
            System.out.println("Khong tao duoc file");
        }
    }
    //tim kiem
    public void timKiemTheoMaSach(){
        System.out.println("Nhap ma sach muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaSach())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(!kt){
            System.out.println("Khong tim thay sach co ma: "+ma);
        }    
        xuatd();           
    }
    public void timKiemTheoTen(){
        System.out.println("Nhap ten sach muon tim: ");
        String ten=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ten.equals(ds[i].getTenSach())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(!kt){
            System.out.println("Khong tim thay sach co ten: "+ten);
            return;
        }    
        xuatd();                  
    }
    public void timKiemTheoNamXuaBban(){
        System.out.println("Nhap nam xuat ban sach muon tim: ");
        String nam=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(nam.equals(ds[i].getNamXuatBan())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(!kt){
            System.out.println("Khong tim thay sach co ten: "+nam);
            return;
        }
        xuatd();           
    }
    public void timKiemTheoMaTacGia(){
        System.out.println("Nhap ma tac gia cua sach muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTacGia())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        xuatd();
        if(!kt)
        System.out.println("Khong tim thay sach cua tac gia co ma: "+ma);       
    }
    public void timKiemTheoMaTheLoai(){
        System.out.println("Nhap ma the loai cua sach muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaTheLoai())){
                if(!kt) xuatt();
                ds[i].xuat();
                
                kt=true;
            }
        if(!kt){
            System.out.println("Khong tim thay sach co the loai co ma: "+ma);    
        }
        xuatd();   
    }
    public void timKiemTheoMaNhaXuatBan(){
        System.out.println("Nhap ma nha xuat ban sach muon tim: ");
        String ma=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ma.equals(ds[i].getMaNXB())){
                if(!kt) xuatt();
                ds[i].xuat();
                kt=true;
            }
        if(!kt){
            System.out.println("Khong tim thay sach co nha xuat ban co ma: "+ma);
            return;
        }
        xuatd();   
    }
    public void timKiemTheoMon(){
        System.out.println("Nhap mon cua sach giao khoa muon tim: ");
        String mon=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ds[i] instanceof SachGiaoKhoa){
                SachGiaoKhoa s=new SachGiaoKhoa((SachGiaoKhoa)ds[i]);
                if(mon.equals(s.getMon())){
                    if(!kt) xuatt();
                    s.xuat();
                    kt=true;
                }
            }    
        if(!kt){
            System.out.println("Khong tim thay sach giao khoa co mon: "+mon);
            return;
        }
        xuatd();           
    }
    public void timKiemTheoLop(){
        System.out.println("Nhap lop cua sach giao khoa muon tim: ");
        String lop=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ds[i] instanceof SachGiaoKhoa){
                SachGiaoKhoa s=new SachGiaoKhoa((SachGiaoKhoa)ds[i]);
                if(lop.equals(s.getLop())){
                    if(!kt) xuatt();
                    s.xuat();
                    kt=true;
                }
            }    
        if(!kt){
            System.out.println("Khong tim thay sach giao khoa co lop:"+lop);
        }
        xuatd();           
    }
    public void timKiemTheoLinhVuc(){
        System.out.println("Nhap linh vuc cua sach tham khao muon tim: ");
        String lv=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ds[i] instanceof SachThamKhao){
                SachThamKhao s=new SachThamKhao((SachThamKhao)ds[i]);
                if(lv.equals(s.getLinhVuc())){
                    if(!kt) xuatt();
                    s.xuat();
                    kt=true;
                }
            }    
        if(!kt){
            System.out.println("Khong tim thay sach tham khao co linh vuc: "+lv);
            return;
        }
        xuatd();           
    }
    public void timKiemTheoLoaiDocGia(){
        System.out.println("Nhap loai doc gia cua sach tham khao muon tim: ");
        String ldg=sc.nextLine();
        boolean kt=false;
        for(int i=0;i<ds.length;i++)
            if(ds[i] instanceof SachThamKhao){
                SachThamKhao s=new SachThamKhao((SachThamKhao)ds[i]);
                if(ldg.equals(s.getLoaiDocGia())){
                    if(!kt) xuatt();
                    s.xuat();
                    kt=true;
                }
            }    
        if(!kt){
            System.out.println("Khong tim thay sach tham khao co loai doc gia: "+ldg);
            return;
        }
        xuatd();           
    }
    public Sach laySachTuMa(String ma){
        for(Sach s:ds)
            if(ma.equals(s.getMaSach()))
                return s;
        return null;
    }
    public String thongKeTheoLoai(){
        int sgk=0,stk=0;
        for(Sach s:ds)
            if(s instanceof SachGiaoKhoa)
                sgk++;
            else 
                stk++;
        System.out.println("So sach giao khoa: "+sgk);
        System.out.println("So sach tham khao: "+stk);
        return sgk+" "+stk;
    }
    public void thongKeTheoNXB(){
        Map<String,Integer> thongke= new HashMap();
        for(Sach s:ds){
            String nxb=s.getMaNXB();
            thongke.put(nxb, thongke.getOrDefault(nxb, 0)+1);
        }
        System.out.println("Thong ke theo NXB");
            for(Map.Entry<String,Integer> entry: thongke.entrySet())
                System.out.println("Nha xuat ban: "+ entry.getKey() +" - So luong sach: "+entry.getValue());
    }
    public static void main(String[] args){
        DanhSachSach ds=new DanhSachSach();
        ds.docFile();
        //ds.them();
        //ds.xoa();
        //ds.sua();
        //ds.timkiemtheomasach();
        //ds.timkiemtheoten();
        //ds.timkiemtheonamxuatban();
        //ds.timkiemtheomatacgia();
        //ds.timkiemtheomatheloai();
        //ds.timkiemtheomanhaxuatban();
        //ds.timkiemtheolop();
        //ds.timkiemtheomon();
        //ds.timkiemtheolinhvuc();
        //ds.timkiemtheoloaidocgia();
        //ds.xuat();
    }
}

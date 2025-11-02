import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class DanhSachNhanVien {
        private int n;
        NhanVien[] ds=new NhanVien[0];
        Scanner sc = new Scanner(System.in);
        
        public DanhSachNhanVien() {}
        public DanhSachNhanVien(NhanVien[] ds,int n){
              this.n=n;
                this.ds=new NhanVien[this.n];
                for(int i=0;i<this.n;i++){
                        ds[i]=new NhanVien(ds[i]);
                }
        }
        public DanhSachNhanVien(DanhSachNhanVien other ){
                this.n=other.n;
                this.ds=new NhanVien[this.n];
                for(int i=0;i<this.n;i++){
                        ds[i]=new NhanVien(other.ds[i]);
                }
        }
        public boolean kiemTraMaDuyNhat(String ma){
                for(NhanVien nv:ds)
                        if(ma.equals(nv.getManhanvien()))
                                return false;
                return true;
        }
        public void them(){
                int k=5;
                boolean kt=false;
                while(k>0 && !kt){
                        NhanVien nv=new NhanVien();
                        nv.nhap();
                        if(them(nv))
                                kt=true;
                        else{
                                System.out.println("Ma nhan vien da ton tai vui long nhap lai.");
                                k--;
                        }        
                }
                if(!kt){
                        System.out.println("Nhap qua so lan quy dinh.");
                        return;
                }
        }
        public boolean them(NhanVien nv){
                if(kiemTraMaDuyNhat(nv.getManhanvien())){
                        ds=Arrays.copyOf(ds,ds.length-1);
                        ds[ds.length-1]=new NhanVien(nv);
                        return true;
                }
               return false;
        }
        public void nhap() {
                System.out.print("Nhap so luong nhan vien: ");
                n=sc.nextInt();
                sc.nextLine();
                for(int i=0;i<n;i++){
                        int k=5;
                        boolean kt=false;
                        while(k>0 && !kt){
                                System.out.println("Nhap thong tin nhan vien thu "+(i+1)+":");
                                NhanVien nv=new NhanVien();
                                nv.nhap();
                                if(them(nv)){
                                        kt=true;
                                }else{
                                        System.out.println("Ma nhan vien da ton tai vui long nhap lai.");
                                        k--;
                                }        
                        }
                        if(!kt){
                                System.out.println("Nhap qua so lan quy dinh.");
                                return;
                        }
                } 
        } 

        public void xuat(){
                if(n==0){
                        System.out.println("Danh sach rong!");
                        return;
                }
                xuatd();
                for(NhanVien nv: ds)
                   nv.xuat();
                xuatc();
        }

        public void xuatd(){
                 System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n");
                 System.out.printf("| %-10s | %-10s | %-15s | %-9s | %-12s | %-15s |\n","Ma Nv", "Ho", "Ten", "Gioi tinh", "Ngay sinh", "SDT");
                 System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n");
        }

        public void xuatc(){
                 System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n"); 
        }

        public void sua() {
                System.out.print("Nhap ma nhan vien can sua: ");
                String ma = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < n; i++) {
                        if (ds[i].getManhanvien().equalsIgnoreCase(ma)) {
                                System.out.println("Thong tin sinh vien: ");
                                xuatd();
                                ds[i].xuat();
                                found = true;
                                while (true) {
                                        System.out.println("Ban muon sua thong tin gi?");
                                        System.out.println("1.Sua ho");
                                        System.out.println("2.Sua ten");
                                        System.out.println("3.Sua gioi tinh");
                                        System.out.println("4.Sua ngay sinh");
                                        System.out.println("5.Sua sdt");
                                        System.out.println("6.Thoat");
                                        System.out.print("Chon: ");
                                        int chon = sc.nextInt();
                                        sc.nextLine();
                                        switch (chon) {
                                                case 1:
                                                        System.out.print("Nhap ho moi: ");
                                                        String homoi = sc.nextLine();
                                                        ds[i].setHo(homoi);
                                                        break;
                                                case 2:
                                                        System.out.print("Nhap ten moi: ");
                                                        String tenmoi = sc.nextLine();
                                                        ds[i].setTen(tenmoi);
                                                        break;
                                                case 3:
                                                        System.out.print("Nhap gioi tinh moi: ");
                                                        String gtmoi = sc.nextLine();
                                                        ds[i].setGioitinh(gtmoi);
                                                        break;
                                                case 4:
                                                        System.out.print("Nhap ngay sinh moi: ");
                                                        String nsmoi = sc.nextLine();
                                                        ds[i].setNgaysinh(nsmoi);
                                                        break;
                                                case 5:
                                                        System.out.print("Nhap sdt moi: ");
                                                        String sdtmoi = sc.nextLine();
                                                        ds[i].setSdt(sdtmoi);
                                                        break;
                                                case 6:
                                                        System.out.println("\tThong tin sau cap nhat");
                                                        xuatd();
                                                        ds[i].xuat();
                                                        xuatc();
                                                        return;
                                                default:
                                                        System.out.println("Lua chon k hop le");
                                        }
                                }
                        }
                }
                if (!found) {
                        System.out.println("Khong tim thay ma");
                }
        }

        public void timKiemTheoMaNhanVien() {
                System.out.print("Nhap ma nhan vien can tim: ");
                String ma = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < n; i++) {
                        if (ds[i].getManhanvien().equalsIgnoreCase(ma)) {
                                xuatd();
                                ds[i].xuat();
                                xuatc();
                                found = true;
                                break;
                        }
                }
                if (!found) {
                        System.out.println("Khong tim thay ma nhan vien");
                }
        
        }
        public void timKiemTheoTen(){
                System.out.println("Nhap ten nhan vien can tim: ");
                String ten=sc.nextLine();
                Boolean kt=false;
                for(NhanVien nv:ds)
                if(ten.contains(nv.getTen())){
                        if(!kt) xuatd();
                        nv.xuat();
                        xuatc();
                        kt=true;
                }
                if(kt)xuatc();
                if(!kt)    
                System.out.println("Khong tim thay tac gia co ten: "+ten);
        }
        public int[] thongKeTheoGioiTinh() {
                int demnam = 0, demnu = 0;
                for (int i = 0; i < n; i++) {
                        if (ds[i].getGioitinh().equalsIgnoreCase("nam"))
                                demnam++;
                        else if (ds[i].getGioitinh().equalsIgnoreCase("nu"))
                                demnu++;
                }
                System.out.println("So luong nhan vien nam: " + demnam);
                System.out.println("So luong nhan vien nu: " + demnu);
                return new int[] { demnam, demnu };
        }
        public void thongKeTheoTuoi() {
                int dem1 = 0, dem2 = 0, dem3 = 0;
                for (int i = 0; i < n; i++) {
                        int tuoi = ds[i].tinhtuoi();
                        if (tuoi >= 18 && tuoi <= 23)
                                dem1++;
                        else if (tuoi >= 24 && tuoi < 28)
                                dem2++;
                        else if (tuoi >= 28)
                                dem3++;
                }
                System.out.println("So luong tuoi tu 18-23: " + dem1);
                System.out.println("So luong tuoi tu 24-27: " + dem2);
                System.out.println("So luong tuoi tu 28 tro len: " + dem3);
        }

       public void xoa() {
                System.out.print("Nhap ma nhan vien can xoa: ");
                String ma = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < n; i++) {
                        if (ds[i].getManhanvien().equalsIgnoreCase(ma)) {
                                for (int j = i; j < n - 1; j++) {
                                        ds[j] = ds[j + 1];
                                }
                                n--;
                                ds = Arrays.copyOf(ds, n);
                                found = true;
                                break;
                        }
                }
                if (!found) {
                        System.out.println("Khong tim thay ma nhan vien");
                }
        }
                
        public void ghiFile(){
                File file=new File("Nhanvien.txt");
                try(PrintWriter pw=new PrintWriter(file)){
                        for(NhanVien nv:ds){
                                pw.println(nv.toString());
                        }
                } catch(FileNotFoundException e){
                        System.out.println("Loi ghi file!");

                }

        }

        public void docFile(){
                File file=new File("Nhanvien.txt");
                if(!file.exists()){
                        System.out.println("File khong ton tai!");
                        return;
                }
                try(Scanner f=new Scanner(file)){
                        n=0;
                        ds=new NhanVien[0];
                        while(f.hasNextLine()){
                                String line=f.nextLine();
                                String[] parts=line.split(",");
                                if(parts.length==6){
                                        NhanVien nv=new NhanVien(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]); 
                                        ds=Arrays.copyOf(ds,n+1);
                                        ds[n]=nv;
                                        n++;
                                }
                        }
                }catch(FileNotFoundException e){
                        System.out.println("Loi doc file!");
                }
        }
        public NhanVien traVeNhanVienTheoMa(String ma){
                for(NhanVien nv:ds)
                        if(ma.equals(nv.getManhanvien()))
                                return nv;
                return null;
        }
        public static void main(String[] args) {
                DanhSachNhanVien ds=new DanhSachNhanVien();
                ds.docFile();
                // ds.nhap();
                // ds.them();
                // ds.sua();
                // ds.xoa();
                // ds.timKiemTheoMaNhanVien();
                //ds.timKiemTheoTen();
                //ds.sapxepten();
                //ds.sapxepma();
                //ds.ghiFile();
                }
        }

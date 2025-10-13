import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.io.*;
public class DanhSachNhanVien {
        private int n;
        NhanVien[] ds=new NhanVien[0];
        Scanner sc = new Scanner(System.in);
        
        public DanhSachNhanVien() {}
        public DanhSachNhanVien(NhanVien[] ds,int n){
              this.ds=ds;
              this.n=n;  
        }
        public DanhSachNhanVien(DanhSachNhanVien ds ){
                this.ds=ds.ds;
                }

        public void nhap() {
                System.out.print("Nhap so luong nhan vien: ");
                n=sc.nextInt();
                sc.nextLine();
                ds=Arrays.copyOf(ds,n);
                for(int i=0;i<n;i++){
                        System.out.println("Nhap thong tin nhan vien thu "+(i+1)+":");
                        NhanVien nv=new NhanVien();
                        nv.nhap();
                        ds[i]=nv;
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

        public void sua(){
                System.out.print("Nhap ma nhan vien can sua: ");
                String ma=sc.nextLine();
                int index=-1;
                for(int i=0;i<n;i++){
                        if(ds[i].getMnv().compareTo(ma)==0){
                                index=i;
                                break;
                        }      
                }
                if(index==-1){
                        System.out.println("Khong tim thay sinh vien co ma "+ma);
                        return;
                }
                while(true){
                        System.out.println("Thong tin sinh vien: ");
                        xuatd();
                        ds[index].xuat();
                        System.out.println("1.Sua ho");
                        System.out.println("2.Sua ten");
                        System.out.println("3.Sua gioi tinh");
                        System.out.println("4.Sua ngay sinh");
                        System.out.println("5.Sua sdt");
                        System.out.println("6.Thoat");
                        System.out.print("Chon: ");
                        int chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                                case 1:
                                System.out.print("Nhap ho moi: ");
                                String homoi=sc.nextLine();
                                ds[index].setHo(homoi);
                                break;
                                case 2: 
                                System.out.print("Nhap ten moi: ");
                                String tenmoi=sc.nextLine();
                                ds[index].setTen(tenmoi);
                                break;
                                case 3:
                                System.out.print("Nhap gioi tinh moi: ");
                                String gtmoi=sc.nextLine();
                                ds[index].setGioitinh(gtmoi);
                                break;
                                case 4:
                                System.out.print("Nhap ngay sinh moi: ");
                                String nsmoi=sc.nextLine();
                                ds[index].setNgaysinh(nsmoi);
                                break;
                                case 5:
                                System.out.print("Nhap sdt moi: ");
                                String sdtmoi=sc.nextLine();
                                ds[index].setSdt(sdtmoi);
                                break;
                                case 6: 
                                return;
                                default:
                                System.out.println("Lua chon k hop le");
                        }
                }
        }

        public void timkiem() {
                System.out.print("Nhap ma nhan vien can tim: ");
                String ma=sc.nextLine();
                int index=-1;
                for (int i=0;i<n;i++) {
                        if (ds[i].getMnv().compareTo(ma)==0) {
                                index=1;
                                break;
                        }
                } if(index==-1){
                System.out.println("Khong tim thay nhan vien co ma: "+ma);
                return;
                }
                System.out.println("\t Thong tin sinh vien");
                xuatd();
                ds[index].xuat();
                xuatc();
        }
        public void them(){
                while(true){
                        NhanVien nv=new NhanVien();
                        System.out.println("\tNhap thong tin nhan vien moi");
                        nv.nhap();
                        ds=Arrays.copyOf(ds,n+1);
                        ds[n]=nv;
                        n++;
                        System.out.println("Co muon them tiep k (y/n): ");
                        String tiep=sc.nextLine();
                        if(tiep.compareToIgnoreCase("y")==0) continue;
                        else break;
                }
        }

        public void xoa() {
                System.out.print("Nhap ma nhan vien can xoa: ");
                String ma=sc.nextLine();
                int index=-1;
                for (int i = 0; i < n; i++) {
                        if (ds[i].getMnv().compareTo(ma)==0) {
                                index=1;
                                break;
                        }
                }
                if(index==-1){
                        System.out.println("Khong tim sinh vien co ma "+ma);
                        return;
                }
                for(int i=index;i<n-1;i++){
                        ds[i]=ds[i+1];
                }
                n--;
                ds=Arrays.copyOf(ds,n);
        }
                
                

        public void ghifile(){
                File file=new File("Nhanvien.txt");
                try(PrintWriter pw=new PrintWriter(file)){
                        for(NhanVien nv:ds){
                                pw.println(nv.toString());
                        }
                System.out.println("Da ghi vao file Nhanvien.txt");
                } catch(FileNotFoundException e){
                        System.out.println("Loi ghi file!"+e.getMessage());

                }

        }

        public void docfile(){
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
                        System.out.println("Da doc file Nhanvien.txt");
                }catch(FileNotFoundException e){
                        System.out.println("Loi doc file!"+e.getMessage());
                }
        }

        public void sapxepma(){
                Arrays.sort(ds,0,n,Comparator.comparing(NhanVien::getMnv));
        }
        public void sapxepten(){
                Arrays.sort(ds,0,n,Comparator.comparing(NhanVien::getTen));
        }
        public static void main(String[] args) {
                DanhSachNhanVien ds=new DanhSachNhanVien();
                ds.docfile();
                // ds.nhap();
                // ds.them();
                // ds.sua();
                // ds.xoa();
                // ds.timkiem();
                //ds.sapxepten();
                //ds.sapxepma();
                ds.ghifile();
                ds.xuat();
                }

}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.io.*;
public class DanhSachNhanVien {
        private boolean maTontai(String ma){
                for(Nhanvien nv:ds){
                        if(nv.getMnv().equals(ma)) return true;
                }
                return false;
        }
        private ArrayList<Nhanvien> ds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        public DanhSachNhanVien() {}
        public DanhSachNhanVien(ArrayList<Nhanvien> list){
                ds=new ArrayList<>(list);
        }
        public DanhSachNhanVien(DanhSachNhanVien other){
                ds=new ArrayList<>();
                for(Nhanvien nv:other.ds){
                        ds.add(new Nhanvien(nv));
                }
        }

        public void nhapds() {
                System.out.print("Nhap so luong nhan vien: ");
                int n=sc.nextInt();
                sc.nextLine();
                for(int i=0;i<n;i++){
                        System.out.println("Nhap thong tin nhan vien thu "+(i+1)+":");
                        Nhanvien nv=new Nhanvien();
                        nv.nhap();
                        if(maTontai(nv.getMnv())){
                                System.out.println("Ma nhan vien da ton tai!");
                                i--;
                        }else ds.add(nv);
                } 
        } 

        public void xuat(){
                if(ds.isEmpty()){
                        System.out.println("Danh sach rong!");
                        return;
                }
                System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n");
                System.out.printf("| %-10s | %-10s | %-15s | %-9s | %-12s | %-15s |\n", "Ma Nv", "Ho", "Ten", "Gioi tinh", "Ngay sinh", "SDT");
                System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n");
                for(Nhanvien nv: ds) nv.xuat();
                System.out.printf("+------------+------------+-----------------+-----------+--------------+-----------------+\n");
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
                for(Nhanvien nv:ds){
                        if(nv.getMnv().equals(ma))
                                nv.sua();
                                return;
                }
                System.out.println("Khong tim thay nhan vien co ma: "+ma);
        }

        public void timkiem() {
                System.out.print("Nhap ma nhan vien can tim: ");
                String ma=sc.nextLine();
                for (Nhanvien nv : ds) {
                        if (nv.getMnv().equals(ma)) {
                                xuatd();
                                nv.xuat();
                                xuatc();
                                return;
                        }
                }
                System.out.println("Khong tim thay nhan vien co ma: "+ma);
        }

        public void xoa() {
                System.out.print("Nhap ma nhan vien can xoa: ");
                String ma=sc.nextLine();
                for (int i = 0; i < ds.size(); i++) {
                        if (ds.get(i).getMnv().equals(ma)) {
                                ds.remove(i);
                                System.out.println("Da xoa nhan vien co ma: "+ma);
                                return;
                        }
                }
                System.out.println("Khong tim thay nhan vien co ma: "+ma);
        }

        public void ghifile(){  
                File file=new File("Nhanvien.txt");
                try(PrintWriter pw=new PrintWriter(file)){
                        for(Nhanvien nv:ds){
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
                        ds.clear();
                        while(f.hasNextLine()){
                                String line=f.nextLine();
                                String[] parts=line.split(",");
                                if(parts.length==6){
                                        ds.add(new Nhanvien (parts[0],parts[1],parts[2],parts[3],parts[4],parts[5])); 
                                }
                        }
                        System.out.println("Da doc file Nhanvien.txt");
                }catch(FileNotFoundException e){
                        System.out.println("Loi doc file!"+e.getMessage());
                }
        }

        public void sapxepma(){
                ds.sort(Comparator.comparing(Nhanvien::getMnv));
        }
        public void sapxepten(){
                ds.sort(Comparator.comparing(Nhanvien::getTen));
        }
        public static void main(String[] args) {
                DanhSachNhanVien ds=new DanhSachNhanVien();
                ds.docfile();
                //ds.nhapds();
                //ds.sua();
                //ds.xoa();
                //ds.timkiem();
                //ds.sapxepten();
                //ds.sapxepma();
                ds.ghifile();
                ds.xuat();
                }

}

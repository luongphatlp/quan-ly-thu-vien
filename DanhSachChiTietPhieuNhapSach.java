import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class DanhSachChiTietPhieuNhapSach {
    private ChiTietPhieuNhapSach[] ds = new ChiTietPhieuNhapSach[0];

    public DanhSachChiTietPhieuNhapSach() {}
    public DanhSachChiTietPhieuNhapSach(ChiTietPhieuNhapSach[] ds) {
        this.ds = ds;
    }
    public DanhSachChiTietPhieuNhapSach(DanhSachChiTietPhieuNhapSach other) {
        this.ds = Arrays.copyOf(other.ds, other.ds.length);
    }

    public ChiTietPhieuNhapSach[] getDS() { return ds; }
    public DanhSachChiTietPhieuNhapSach traVeDanhSachChiTietPhieuNhapSachTheoMa(String ma){
        DanhSachChiTietPhieuNhapSach kq=new DanhSachChiTietPhieuNhapSach();
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaPhieuNhapSach().equals(ma)){
                kq.ds=Arrays.copyOf(kq.ds,kq.ds.length+1);
                kq.ds[kq.ds.length-1]=new ChiTietPhieuNhapSach(ds[i]);
            }
        }
        return kq;
    }
    public void docFile() {
        File file = new File("Chitietphieunhapsach.txt");
        if (!file.exists()) {
            System.out.println("File doc khong ton tai.");
            return;
        }
        try (Scanner f = new Scanner(file)) {
            while (f.hasNextLine()) {
                String line = f.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = new ChiTietPhieuNhapSach(parts[0], parts[1],Integer.parseInt(parts[2]),Double.parseDouble(parts[3]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file.");
        }
    }

    public void xuatt(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n","Ma phieu nhap sach","Ma sach","So luong","Don gia","Thanh tien");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }
    public void xuatd(){
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }
    public void xuat() {
        xuatt();
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
        xuatd();
    }
}

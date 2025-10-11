import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class DanhSachChiTietPhieuNhapSach {
    ChiTietPhieuNhapSach[] ds = new ChiTietPhieuNhapSach[0];

    public DanhSachChiTietPhieuNhapSach() {}
    public DanhSachChiTietPhieuNhapSach(ChiTietPhieuNhapSach[] ds) {
        this.ds = ds;
    }
    public DanhSachChiTietPhieuNhapSach(DanhSachChiTietPhieuNhapSach other) {
        this.ds = Arrays.copyOf(other.ds, other.ds.length);
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

    public 
    public void xuat() {
        for (ChiTietPhieuNhapSach ctp : ds) {
            ctp.xuat();
            System.out.println("----------------------------");
        }
    }
}

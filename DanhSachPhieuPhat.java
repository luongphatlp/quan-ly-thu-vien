import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachPhieuPhat {
    
    public static class PhieuPhat {
        private String maPhieuPhat;
        private String maDocGia;
        private String ngayPhat;
        private double tongTienPhat;
        
        public PhieuPhat() {}
        
        public PhieuPhat(String maPhieuPhat, String maDocGia, String ngayPhat, double tongTienPhat) {
            this.maPhieuPhat = maPhieuPhat;
            this.maDocGia = maDocGia;
            this.ngayPhat = ngayPhat;
            this.tongTienPhat = tongTienPhat;
        }
        
        public PhieuPhat(PhieuPhat pp) {
            this(pp.maPhieuPhat, pp.maDocGia, pp.ngayPhat, pp.tongTienPhat);
        }
        
        public String getMaPhieuPhat() { return maPhieuPhat; }
        public String getMaDocGia() { return maDocGia; }
        public String getNgayPhat() { return ngayPhat; }
        public double getTongTienPhat() { return tongTienPhat; }
        
        public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }
        public void setNgayPhat(String ngayPhat) { this.ngayPhat = ngayPhat; }
        public void setTongTienPhat(double tongTienPhat) { this.tongTienPhat = tongTienPhat; }
        
        public void nhap(Scanner sc) {
            System.out.print("Nhap ma phieu phat: ");
            maPhieuPhat = sc.nextLine();
            System.out.print("Nhap ma doc gia: ");
            maDocGia = sc.nextLine();
            System.out.print("Nhap ngay phat: ");
            ngayPhat = sc.nextLine();
            System.out.print("Nhap tong tien phat: ");
            tongTienPhat = sc.nextDouble();
            sc.nextLine();
        }
        
        public void xuat() {
            System.out.println("Ma phieu phat: " + maPhieuPhat);
            System.out.println("Ma doc gia: " + maDocGia);
            System.out.println("Ngay phat: " + ngayPhat);
            System.out.println("Tong tien phat: " + tongTienPhat);
        }
        
        @Override
        public String toString() {
            return "PhieuPhat{" +
                    "maPhieuPhat='" + maPhieuPhat + '\'' +
                    ", maDocGia='" + maDocGia + '\'' +
                    ", ngayPhat='" + ngayPhat + '\'' +
                    ", tongTienPhat=" + tongTienPhat +
                    '}';
        }
    }
    
    private List<PhieuPhat> danhSachPP;
    
    public DanhSachPhieuPhat() {
        this.danhSachPP = new ArrayList<>();
    }
    
    public void themPhieuPhat(PhieuPhat pp) {
        if (!tonTai(pp.getMaPhieuPhat())) {
            danhSachPP.add(pp);
            System.out.println("Da them phieu phat: " + pp.getMaPhieuPhat());
        } else {
            System.out.println("Ma phieu phat da ton tai!");
        }
    }
    
    public boolean xoaPhieuPhat(String maPhieuPhat) {
        for (int i = 0; i < danhSachPP.size(); i++) {
            if (danhSachPP.get(i).getMaPhieuPhat().equals(maPhieuPhat)) {
                System.out.println("Da xoa phieu phat: " + danhSachPP.get(i).getMaPhieuPhat());
                danhSachPP.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay phieu phat voi ma: " + maPhieuPhat);
        return false;
    }
    
    public void hienThiTatCa() {
        if (danhSachPP.isEmpty()) {
            System.out.println("Danh sach phieu phat trong!");
            return;
        }
        System.out.println("=== DANH SACH PHIEU PHAT ===");
        for (PhieuPhat pp : danhSachPP) {
            pp.xuat();
            System.out.println();
        }
    }
    
    public void timKiem(String keyword) {
        boolean found = false;
        System.out.println("Ket qua tim kiem cho: " + keyword);
        for (PhieuPhat pp : danhSachPP) {
            if (pp.getMaPhieuPhat().contains(keyword) || pp.getMaDocGia().contains(keyword)) {
                pp.xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay phieu phat nao!");
        }
    }
    
    private boolean tonTai(String maPhieuPhat) {
        for (PhieuPhat pp : danhSachPP) {
            if (pp.getMaPhieuPhat().equals(maPhieuPhat)) {
                return true;
            }
        }
        return false;
    }
    
    public int getSoLuong() {
        return danhSachPP.size();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachPhieuPhat ds = new DanhSachPhieuPhat();
        
        PhieuPhat pp1 = new PhieuPhat("PP001", "DG001", "2023-10-01", 50000);
        PhieuPhat pp2 = new PhieuPhat("PP002", "DG002", "2023-10-02", 75000);
        ds.themPhieuPhat(pp1);
        ds.themPhieuPhat(pp2);
        
        ds.hienThiTatCa();
        
        ds.timKiem("DG001");
        
        ds.xoaPhieuPhat("PP001");
        
        ds.hienThiTatCa();
        
        sc.close();
    }
}
```

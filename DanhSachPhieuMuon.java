import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachPhieuMuon {
    
    public static class PhieuMuon {
        private String maPhieuMuon;
        private String maDocGia;
        private String maSach;
        private String ngayMuon;
        private String ngayHanTra;
        
        public PhieuMuon() {}
        
        public PhieuMuon(String maPhieuMuon, String maDocGia, String maSach, String ngayMuon, String ngayHanTra) {
            this.maPhieuMuon = maPhieuMuon;
            this.maDocGia = maDocGia;
            this.maSach = maSach;
            this.ngayMuon = ngayMuon;
            this.ngayHanTra = ngayHanTra;
        }
        
        public PhieuMuon(PhieuMuon pm) {
            this(pm.maPhieuMuon, pm.maDocGia, pm.maSach, pm.ngayMuon, pm.ngayHanTra);
        }
        
        public String getMaPhieuMuon() { return maPhieuMuon; }
        public String getMaDocGia() { return maDocGia; }
        public String getMaSach() { return maSach; }
        public String getNgayMuon() { return ngayMuon; }
        public String getNgayHanTra() { return ngayHanTra; }
        
        public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }
        public void setMaSach(String maSach) { this.maSach = maSach; }
        public void setNgayMuon(String ngayMuon) { this.ngayMuon = ngayMuon; }
        public void setNgayHanTra(String ngayHanTra) { this.ngayHanTra = ngayHanTra; }
        
        public void nhap(Scanner sc) {
            System.out.print("Nhap ma phieu muon: ");
            maPhieuMuon = sc.nextLine();
            System.out.print("Nhap ma doc gia: ");
            maDocGia = sc.nextLine();
            System.out.print("Nhap ma sach: ");
            maSach = sc.nextLine();
            System.out.print("Nhap ngay muon: ");
            ngayMuon = sc.nextLine();
            System.out.print("Nhap ngay han tra: ");
            ngayHanTra = sc.nextLine();
        }
        
        public void xuat() {
            System.out.println("Ma phieu muon: " + maPhieuMuon);
            System.out.println("Ma doc gia: " + maDocGia);
            System.out.println("Ma sach: " + maSach);
            System.out.println("Ngay muon: " + ngayMuon);
            System.out.println("Ngay han tra: " + ngayHanTra);
        }
        
        @Override
        public String toString() {
            return "PhieuMuon{" +
                    "maPhieuMuon='" + maPhieuMuon + '\'' +
                    ", maDocGia='" + maDocGia + '\'' +
                    ", maSach='" + maSach + '\'' +
                    ", ngayMuon='" + ngayMuon + '\'' +
                    ", ngayHanTra='" + ngayHanTra + '\'' +
                    '}';
        }
    }
    
    private List<PhieuMuon> danhSachPM;
    
    public DanhSachPhieuMuon() {
        this.danhSachPM = new ArrayList<>();
    }
    
    public void themPhieuMuon(PhieuMuon pm) {
        if (!tonTai(pm.getMaPhieuMuon())) {
            danhSachPM.add(pm);
            System.out.println("Da them phieu muon: " + pm.getMaPhieuMuon());
        } else {
            System.out.println("Ma phieu muon da ton tai!");
        }
    }
    
    public boolean xoaPhieuMuon(String maPhieuMuon) {
        for (int i = 0; i < danhSachPM.size(); i++) {
            if (danhSachPM.get(i).getMaPhieuMuon().equals(maPhieuMuon)) {
                System.out.println("Da xoa phieu muon: " + danhSachPM.get(i).getMaPhieuMuon());
                danhSachPM.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay phieu muon voi ma: " + maPhieuMuon);
        return false;
    }
    
    public void hienThiTatCa() {
        if (danhSachPM.isEmpty()) {
            System.out.println("Danh sach phieu muon trong!");
            return;
        }
        System.out.println("=== DANH SACH PHIEU MUON ===");
        for (PhieuMuon pm : danhSachPM) {
            pm.xuat();
            System.out.println();
        }
    }
    
    public void timKiem(String keyword) {
        boolean found = false;
        System.out.println("Ket qua tim kiem cho: " + keyword);
        for (PhieuMuon pm : danhSachPM) {
            if (pm.getMaPhieuMuon().contains(keyword) || pm.getMaDocGia().contains(keyword) || pm.getMaSach().contains(keyword)) {
                pm.xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay phieu muon nao!");
        }
    }
    
    private boolean tonTai(String maPhieuMuon) {
        for (PhieuMuon pm : danhSachPM) {
            if (pm.getMaPhieuMuon().equals(maPhieuMuon)) {
                return true;
            }
        }
        return false;
    }
    
    public int getSoLuong() {
        return danhSachPM.size();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachPhieuMuon ds = new DanhSachPhieuMuon();
        
        PhieuMuon pm1 = new PhieuMuon("PM001", "DG001", "S001", "2023-10-01", "2023-10-15");
        PhieuMuon pm2 = new PhieuMuon("PM002", "DG002", "S002", "2023-10-02", "2023-10-16");
        ds.themPhieuMuon(pm1);
        ds.themPhieuMuon(pm2);
        
        ds.hienThiTatCa();
        
        ds.timKiem("DG001");
        
        ds.xoaPhieuMuon("PM001");
        
        ds.hienThiTatCa();
        
        sc.close();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachDocGia {

    private List<Docgia> danhSachDG;
    
    public static class DocGia {
        private String maDocGia;
        private String tenDocGia;
        private String diaChi;
        private String dienThoai;
        
        public DocGia() {}
        
        public DocGia(String maDocGia, String tenDocGia, String diaChi, String dienThoai) {
            this.maDocGia = maDocGia;
            this.tenDocGia = tenDocGia;
            this.diaChi = diaChi;
            this.dienThoai = dienThoai;
        }
        
        public DocGia(DocGia dg) {
            this(dg.maDocGia, dg.tenDocGia, dg.diaChi, dg.dienThoai);
        }
        
        public String getMaDocGia() { return maDocGia; }
        public String getTenDocGia() { return tenDocGia; }
        public String getDiaChi() { return diaChi; }
        public String getDienThoai() { return dienThoai; }
        
        public void setTenDocGia(String tenDocGia) { this.tenDocGia = tenDocGia; }
        public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
        public void setDienThoai(String dienThoai) { this.dienThoai = dienThoai; }
        
        public void nhap(Scanner sc) {
            System.out.print("Nhap ma doc gia: ");
            maDocGia = sc.nextLine();
            System.out.print("Nhap ten doc gia: ");
            tenDocGia = sc.nextLine();
            System.out.print("Nhap dia chi: ");
            diaChi = sc.nextLine();
            System.out.print("Nhap dien thoai: ");
            dienThoai = sc.nextLine();
        }
        
        public void xuat() {
            System.out.println("Ma doc gia: " + maDocGia);
            System.out.println("Ten doc gia: " + tenDocGia);
            System.out.println("Dia chi: " + diaChi);
            System.out.println("Dien thoai: " + dienThoai);
        }
        
        @Override
        public String toString() {
            return "DocGia{" +
                    "maDocGia='" + maDocGia + '\'' +
                    ", tenDocGia='" + tenDocGia + '\'' +
                    ", diaChi='" + diaChi + '\'' +
                    ", dienThoai='" + dienThoai + '\'' +
                    '}';
        }
    }
    
    private List<DocGia> danhSachDG;
    
    public DanhSachDocGia() {
        this.danhSachDG = new ArrayList<>();
    }
    
    public void themDocGia(DocGia dg) {
        if (!tonTai(dg.getMaDocGia())) {
            danhSachDG.add(dg);
            System.out.println("Da them doc gia: " + dg.getTenDocGia());
        } else {
            System.out.println("Ma doc gia da ton tai!");
        }
    }
    
    public boolean xoaDocGia(String maDocGia) {
        for (int i = 0; i < danhSachDG.size(); i++) {
            if (danhSachDG.get(i).getMaDocGia().equals(maDocGia)) {
                System.out.println("Da xoa doc gia: " + danhSachDG.get(i).getTenDocGia());
                danhSachDG.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay doc gia voi ma: " + maDocGia);
        return false;
    }
    
    public void hienThiTatCa() {
        if (danhSachDG.isEmpty()) {
            System.out.println("Danh sach doc gia trong!");
            return;
        }
        System.out.println("=== DANH SACH DOC GIA ===");
        for (DocGia dg : danhSachDG) {
            dg.xuat();
            System.out.println();
        }
    }
    
    public void timKiem(String keyword) {
        boolean found = false;
        System.out.println("Ket qua tim kiem cho: " + keyword);
        for (DocGia dg : danhSachDG) {
            if (dg.getMaDocGia().contains(keyword) || dg.getTenDocGia().contains(keyword)) {
                dg.xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay doc gia nao!");
        }
    }
    
    private boolean tonTai(String maDocGia) {
        for (DocGia dg : danhSachDG) {
            if (dg.getMaDocGia().equals(maDocGia)) {
                return true;
            }
        }
        return false;
    }
    
    public int getSoLuong() {
        return danhSachDG.size();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachDocGia ds = new DanhSachDocGia();
        
        DocGia dg1 = new DocGia("DG001", "Nguyen Van A", "Ha Noi", "0123456789");
        DocGia dg2 = new DocGia("DG002", "Tran Thi B", "TP.HCM", "0987654321");
        ds.themDocGia(dg1);
        ds.themDocGia(dg2);
        
        ds.hienThiTatCa();
        
        ds.timKiem("A");
        
        ds.xoaDocGia("DG001");
        
        ds.hienThiTatCa();
        
        sc.close();
    }
}

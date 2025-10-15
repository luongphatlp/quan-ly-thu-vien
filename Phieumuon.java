import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class PhieuMuon {
    private String maphieumuon;
    
    private String madocgia;
    private String manhanvien;
    private String ngaylapphieu;
    private String ngaytra;
    private String ngaytrathucte;

    public PhieuMuon() {}
    public PhieuMuon(String maphieumuon, String madocgia, String manhanvien, String ngaylapphieu, String ngaytra, String ngaytrathucte) {
        this.maphieumuon = maphieumuon;
        this.madocgia = madocgia;
        this.manhanvien = manhanvien;
        this.ngaylapphieu = ngaylapphieu;
        this.ngaytra = ngaytra;
        this.ngaytrathucte = ngaytrathucte;
    }
    public PhieuMuon(PhieuMuon pm) {
        this.maphieumuon = pm.maphieumuon;
        this.madocgia = pm.madocgia;
        this.manhanvien = pm.manhanvien;
        this.ngaylapphieu = pm.ngaylapphieu;
        this.ngaytra = pm.ngaytra;
        this.ngaytrathucte = pm.ngaytrathucte;
    }
    public String getMaPhieuMuon() {return maphieumuon;}
    public String getMaDocGia() {return madocgia;}
    public String getMaNhanVien() {return manhanvien;}
    public String getNgayLapPhieu() {return ngaylapphieu;}
    public String getNgayTra() {return ngaytra;}
    public String getNgayTraThucTe() {return ngaytrathucte;}
    public void setMaPhieuMuon(String maphieumuon) {this.maphieumuon = maphieumuon;}
    public void setMaDocGia(String madocgia) {this.madocgia = madocgia;}
    public void setMaNhanVien(String manhanvien) {this.manhanvien = manhanvien;}
    public void setNgayLapPhieu(String ngaylapphieu) {this.ngaylapphieu = ngaylapphieu;}
    public void setNgayTra(String ngaytra) {this.ngaytra = ngaytra;}
    public void setNgayTraThucTe(String ngaytrathucte) {this.ngaytrathucte = ngaytrathucte;}

   /*private boolean tinhtrang(){
        if(ngaytrathucte==null) return true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(ngaytra, formatter);
        LocalDate date2 = LocalDate.parse(ngaytrathucte, formatter);
        if(date2.isAfter(date1)) return false;
        return true;
    }
    public String getTinhTrang(){
        if(tinhtrang()) return "Chua tra hoac Tra dung han";
        return "Tra tre";
    }*/
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        
        System.out.println("Nhap ma phieu muon: ");
        maphieumuon=sc.nextLine();
        System.out.println("Nhap ma doc gia: ");
        madocgia=sc.nextLine();
        System.out.println("Nhap ma nhan vien: ");
        manhanvien=sc.nextLine();
        System.out.println("Nhap ngay lap phieu (dd/MM/yyyy): ");
        ngaylapphieu=sc.nextLine();
        System.out.println("Nhap ngay tra (dd/MM/yyyy): ");
        ngaytra=sc.nextLine();
        System.out.println("Nhap ngay tra thuc te (dd/MM/yyyy) (Neu chua tra thi de trong): ");
        ngaytrathucte=sc.nextLine();   
        if(ngaytrathucte.isEmpty()) ngaytrathucte="null";
    }
    public void xuat(){
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-16s |\n",maphieumuon,madocgia,manhanvien,ngaylapphieu,ngaytra,ngaytrathucte);
    }
    public String toString(){
        return maphieumuon+","+madocgia+","+manhanvien+","+ngaylapphieu+","+ngaytra+","+ngaytrathucte; 
    }
}

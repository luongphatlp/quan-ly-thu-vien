import java.util.Arrays;
import java.util.Scanner;
public class QuanLyThuVien {
    private DanhSachSach dss=new DanhSachSach();
    private DanhSachTacGia dstg=new DanhSachTacGia();
    private DanhSachTheLoai dstl=new DanhSachTheLoai();
    private DanhSachChiTietPhieuNhapSach dsctpns=new DanhSachChiTietPhieuNhapSach();
    private DanhSachPhieuNhapSach dspns=new DanhSachPhieuNhapSach(dsctpns);
    private DanhSachPhieuMuon dsphieumuon=new DanhSachPhieuMuon();
    private DanhSachChiTietPhieuMuon dschitietphieumuon=new DanhSachChiTietPhieuMuon();
    private DanhSachDocGia dsdg=new DanhSachDocGia();
    private DanhSachNhanVien dsnv=new DanhSachNhanVien();
    private DanhSachNhaCungCap dsncc=new DanhSachNhaCungCap();
    private DanhSachPhieuPhat dsphieuphat=new DanhSachPhieuPhat();
    private DanhSachQuyDinhPhat dsquydinhphat=new DanhSachQuyDinhPhat();
    private DanhSachNhaXuatBan dsnxb=new DanhSachNhaXuatBan();
    Scanner sc=new Scanner(System.in);
    public QuanLyThuVien() {}
    public QuanLyThuVien(DanhSachSach dss, DanhSachTacGia dstg, DanhSachTheLoai dstl, DanhSachPhieuNhapSach dspns, DanhSachChiTietPhieuNhapSach dsctpns, DanhSachPhieuMuon dsphieumuon, DanhSachChiTietPhieuMuon dschitietphieumuon, DanhSachDocGia dsdg, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc, DanhSachPhieuPhat dsphieuphat, DanhSachQuyDinhPhat dsquydinhphat, DanhSachNhaXuatBan dsnxb) {
        this.dss = dss;
        this.dstg = dstg;
        this.dstl = dstl;
        this.dspns = dspns;
        this.dsctpns = dsctpns;
        this.dsphieumuon = dsphieumuon;
        this.dschitietphieumuon = dschitietphieumuon;
        this.dsdg = dsdg;
        this.dsnv = dsnv;
        this.dsncc = dsncc;
        this.dsphieuphat = dsphieuphat;
        this.dsquydinhphat = dsquydinhphat;
        this.dsnxb = dsnxb;
    }
    public QuanLyThuVien(QuanLyThuVien qltv) {
        this.dss = qltv.dss;
        this.dstg = qltv.dstg;
        this.dstl = qltv.dstl;
        this.dspns = qltv.dspns;
        this.dsctpns = qltv.dsctpns;
        this.dsphieumuon = qltv.dsphieumuon;
        this.dschitietphieumuon = qltv.dschitietphieumuon;
        this.dsdg = qltv.dsdg;
        this.dsnv = qltv.dsnv;
        this.dsncc = qltv.dsncc;
        this.dsphieuphat = qltv.dsphieuphat;
        this.dsquydinhphat = qltv.dsquydinhphat;
        this.dsnxb = qltv.dsnxb;
    }
    public DanhSachSach getDss() {return dss;}
    public DanhSachTacGia getDstg() {return dstg;}
    public DanhSachTheLoai getDstl() {return dstl;}
    public DanhSachPhieuNhapSach getDspns() {return dspns;}
    public DanhSachChiTietPhieuNhapSach getDsctpns() {return dsctpns;}
    public DanhSachPhieuMuon getDsphieumuon() {return dsphieumuon;}
    public DanhSachChiTietPhieuMuon getDschitietphieumuon() {return dschitietphieumuon;}
    public DanhSachDocGia getDsdg() {return dsdg;}
    public DanhSachNhanVien getDsnv() {return dsnv;}
    public DanhSachNhaCungCap getDsncc() {return dsncc;}
    public DanhSachPhieuPhat getDsphieuphat() {return dsphieuphat;}
    public DanhSachQuyDinhPhat getDsquydinhphat() {return dsquydinhphat;}
    public DanhSachNhaXuatBan getDsnxb() {return dsnxb;}

    public void setDss(DanhSachSach dss) {this.dss = dss;}
    public void setDstg(DanhSachTacGia dstg) {this.dstg = dstg;}
    public void setDstl(DanhSachTheLoai dstl) {this.dstl = dstl;}
    public void setDspns(DanhSachPhieuNhapSach dspns) {this.dspns = dspns;}
    public void setDsctpns(DanhSachChiTietPhieuNhapSach dsctpns) {this.dsctpns = dsctpns;}
    public void setDsphieumuon(DanhSachPhieuMuon dsphieumuon) {this.dsphieumuon = dsphieumuon;}
    public void setDschitietphieumuon(DanhSachChiTietPhieuMuon dschitietphieumuon) {this.dschitietphieumuon = dschitietphieumuon;}
    public void setDsdg(DanhSachDocGia dsdg) {this.dsdg = dsdg;}
    public void setDsnv(DanhSachNhanVien dsnv) {this.dsnv = dsnv;}
    public void setDsncc(DanhSachNhaCungCap dsncc) {this.dsncc = dsncc;}
    public void setDsphieuphat(DanhSachPhieuPhat dsphieuphat) {this.dsphieuphat = dsphieuphat;}
    public void setDsquydinhphat(DanhSachQuyDinhPhat dsquydinhphat) {this.dsquydinhphat = dsquydinhphat;}
    public void setDsnxb(DanhSachNhaXuatBan dsnxb) {this.dsnxb = dsnxb;}

    public void docTatCaFile(){
        dss.docFile();
        dstg.docFile();
        dstl.docFile();
        dspns.docFile();
        dsctpns.docFile();
        dsphieumuon.docFile();
        dschitietphieumuon.docFile();
        //dsdg.docFile();
        dsnv.docFile();
        dsncc.docFile();
        //dsphieuphat.docFile();
        dsquydinhphat.docFile();
        //dsnxb.docFile();
    }
    public void menu(){
        int chon;
        do{
            System.out.println("1.Quan ly sach");
            System.out.println("2.Quan ly tac gia");
            System.out.println("3.Quan ly nhan vien");
            System.out.println("4.Quan ly nha cung cap");
            System.out.println("5.Quan ly phieu nhap sach");
            System.out.println("6.Quan ly phieu muon");
            System.out.println("14.Thoat");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            switch(chon){
                case 1:
                    menuSach();
                    break;
                case 2:
                    menuTacGia();
                    break;
                case 3:
                    menuNhanVien();
                    break;
                case 4:
                    //menuNhaCungCap();
                    break;
                case 5:
                    //menuPhieuNhapSach();
                    break;
                case 6:
                    //menuPhieuMuon();
                    break;
                case 7:
                    //menuChiTietPhieuMuon();
                    break;
                case 8:
                    //menuTacGia();
                    break;
                case 9:
                    //menuChiTietPhieuNhapSach();
                    break;
                case 10:
                    //menuNhanVien();
                    break;
                case 11:
                    //menuTheLoai();
                    break;
                case 12:
                    //menuPhieuPhat();
                    break;
                case 13:
                    //menuQuyDinhPhat();
                    break;
                case 14:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Nhap sai!Vui long nhap lai!");
            }
        }while(chon!=14);
    }
    public void menuSach(){
        int chon;
        do{
            System.out.println("-------Menu Sach-------");
            System.out.println("1.Them sach");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua sach");
            System.out.println("4.Xoa sach");
            System.out.println("5.Tim sach");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dss.nhap();
                    break;
                case 2:
                    dss.xuat();
                    break;
                case 3:
                    dss.sua();
                    break;
                case 4:
                    dss.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim sach theo ma sach");
                        System.out.println("2.Tim sach theo ten sach");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dss.timKiemTheoMaSach();
                                break;
                            case 2:
                                dss.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo loai");
                        System.out.println("2.Thong ke theo NXB");
                        System.out.println("3.Quay lai menu chinh");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dss.thongKeTheoLoai();
                                break;
                            case 2:
                                dss.thongKeTheoNXB();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
        
    }
    /*
     public void menuDocGia(){
        int chon;
        do{
            System.out.println("-------Menu Doc Gia-------");
            System.out.println("1.Them doc gia");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua doc gia");
            System.out.println("4.Xoa doc gia");
            System.out.println("5.Tim doc gia");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsdg.nhap();
                    break;
                case 2:
                    dsdg.xuat();
                    break;
                case 3:
                    dsdg.sua();
                    break;
                case 4:
                    dsdg.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim doc gia theo ma doc gia");
                        System.out.println("2.Tim doc gia theo ten doc gia");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsdg.timKiemTheoMaDocGia();
                                break;
                            case 2:
                                dsdg.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo gioi tinh");
                        System.out.println("2.Thong ke theo tuoi");
                        System.out.println("3.Quay lai menu chinh");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsdg.thongKeTheoGioiTinh();
                                break;
                            case 2:
                                dsdg.thongKeTheoTuoi();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
        
    } 
    */
    
    public void menuTacGia(){
        int chon;
        do{
            System.out.println("-------Menu Tac Gia-------");
            System.out.println("1.Them tac gia");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua tac gia");
            System.out.println("4.Xoa tac gia");
            System.out.println("5.Tim tac gia");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dstg.nhap();
                    break;
                case 2:
                    dstg.xuat();
                    break;
                case 3:
                    dstg.sua();
                    break;
                case 4:
                    dstg.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim tac gia theo ma tac gia");
                        System.out.println("2.Tim tac gia theo ten tac gia");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dstg.timKiemTheoMaTacGia();
                                break;
                            case 2:
                                dstg.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo gioi tinh");
                        System.out.println("2.Thong ke theo tuoi");
                        System.out.println("3.Quay lai menu chinh");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dstg.thongKeTheoGioiTinh();
                                break;
                            case 2:
                                dstg.thongKeTheoTuoi();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
        
    }
    
    public void menuNhanVien(){
        int chon;
        do{
            System.out.println("-------Menu Nhan Vien-------");
            System.out.println("1.Them nhan vien");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua nhan vien");
            System.out.println("4.Xoa nhan vien");
            System.out.println("5.Tim nhan vien");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsnv.nhap();
                    break;
                case 2:
                    dsnv.xuat();
                    break;
                case 3:
                    dsnv.sua();
                    break;
                case 4:
                    dsnv.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim nhan vien theo ma nhan vien");
                        System.out.println("2.Tim nhan vien theo ten nhan vien");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsnv.timKiemTheoMaNhanVien();
                                break;
                            case 2:
                                dsnv.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo gioi tinh");
                        System.out.println("2.Thong ke theo tuoi");
                        System.out.println("3.Quay lai menu chinh");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsnv.thongKeTheoGioiTinh();
                                break;
                            case 2:
                                dsnv.thongKeTheoTuoi();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
        
    }
    public static void main(String[] args){
        QuanLyThuVien ql =new QuanLyThuVien();
        ql.docTatCaFile();
        ql.menu();
    }
}

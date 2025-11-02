
import java.time.LocalDate;
import java.util.*;
public class QuanLyThuVien {
    private DanhSachSach dss=new DanhSachSach();
    private DanhSachTacGia dstg=new DanhSachTacGia();
    private DanhSachTheLoai dstl=new DanhSachTheLoai();
    private DanhSachPhieuNhapSach dspns=new DanhSachPhieuNhapSach();
    private DanhSachDocGia dsdg=new DanhSachDocGia();
    private DanhSachNhanVien dsnv=new DanhSachNhanVien();
    private DanhSachNhaCungCap dsncc=new DanhSachNhaCungCap();
    private DanhSachQuyDinhPhat dsquydinhphat=new DanhSachQuyDinhPhat();
    private DanhSachPhieuPhat dsphieuphat=new DanhSachPhieuPhat(dsquydinhphat);
    private DanhSachPhieuMuon dsphieumuon=new DanhSachPhieuMuon();
    private DanhSachNhaXuatBan dsnxb=new DanhSachNhaXuatBan();
    Scanner sc=new Scanner(System.in);
    public QuanLyThuVien() {}
    public QuanLyThuVien(DanhSachSach dss, DanhSachTacGia dstg, DanhSachTheLoai dstl, DanhSachPhieuNhapSach dspns, DanhSachPhieuMuon dsphieumuon, DanhSachDocGia dsdg, DanhSachNhanVien dsnv, DanhSachNhaCungCap dsncc, DanhSachPhieuPhat dsphieuphat, DanhSachQuyDinhPhat dsquydinhphat, DanhSachNhaXuatBan dsnxb) {
        this.dss = dss;
        this.dstg = dstg;
        this.dstl = dstl;
        this.dspns = dspns;
        this.dsphieumuon = dsphieumuon;
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
        this.dsphieumuon = qltv.dsphieumuon;
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
    public DanhSachPhieuMuon getDsphieumuon() {return dsphieumuon;}
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
    public void setDsphieumuon(DanhSachPhieuMuon dsphieumuon) {this.dsphieumuon = dsphieumuon;}
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
        dsdg.docFile();
        dsnv.docFile();
        dsncc.docFile();
        dsquydinhphat.docFile();
        dspns.docFile();
        dsphieuphat.docFile();
        dsphieumuon.docFile();
        dsnxb.docFile();
    }
    public void ghiTatCaFile(){
        dss.ghiFile();
        dstg.ghiFile();
        dstl.ghiFile();
        dspns.ghiFile();
        dsphieumuon.ghiFile();
        dsdg.ghiFile();
        dsnv.ghiFile();
        dsncc.ghiFile();
        dsphieuphat.ghiFile();
        dsquydinhphat.ghiFile();
        dsnxb.ghiFile();
    }
    public void menu(){
        int chon;
        do{
            System.out.println("1.Quan ly sach");
            System.out.println("2.Quan ly tac gia");
            System.out.println("3.Quan ly nhan vien");
            System.out.println("4.Quan ly doc gia");
            System.out.println("5.Quan ly the loai");
            System.out.println("6.Quan ly phieu muon");
            System.out.println("7.Quan ly nha xuat ban");
            System.out.println("8.Quan ly phieu phat");
            System.out.println("9.Quan ly quy dinh");
            System.out.println("10.Quan ly phieu nhap sach");
            System.out.println("11.Quan ly nha cung cap");
            System.out.println("12.Thoat");
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
                    menuDocGia();
                    break;
                case 5:
                    menuTheLoai();
                    break;
                case 6:
                    menuPhieuMuon();
                    break;
                case 7:
                    menuNhaXuatBan();
                    break;
                case 8:
                    menuPhieuPhat();
                    break;
                case 9:
                    menuQuyDinh();
                    break;
                case 10:
                    menuPhieuNhapSach();
                    break;
                case 11:
                    menuNhaCungCap();
                    break;
                case 12:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Nhap sai!Vui long nhap lai!");
            }
        }while(chon!=12);
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
                        System.out.println("1.Tim sach theo ma");
                        System.out.println("2.Tim sach theo ten");
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
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
        
    }
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
                        System.out.println("1.Tim doc gia theo ma");
                        System.out.println("2.Tim doc gia theo ten");
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
                                dsdg.thongKeTheoDoTuoi();
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
                        System.out.println("1.Tim tac gia theo ma");
                        System.out.println("2.Tim tac gia theo ten");
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
                        System.out.println("3.Quay lai");
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
                        System.out.println("1.Tim nhan vien theo ma");
                        System.out.println("2.Tim nhan vien theo ten");
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
                        System.out.println("3.Quay lai");
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
    public void menuTheLoai(){
        int chon;
        do{
            System.out.println("-------Menu The Loai-------");
            System.out.println("1.Them the loai");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua the loai");
            System.out.println("4.Xoa the loai");
            System.out.println("5.Tim the loai");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dstl.nhap();
                    break;
                case 2:
                    dstl.xuat();
                    break;
                case 3:
                    dstl.sua();
                    break;
                case 4:
                    dstl.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim the loai theo ma");
                        System.out.println("2.Tim the loai theo ten");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dstl.timKiemTheoMaTheLoai();
                                break;
                            case 2:
                                dstl.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo gioi tinh");
                        System.out.println("2.Thong ke theo tuoi");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dstl.thongKeTongSoTheLoai();
                                break;
                            case 2:
                                dstl.thongKeTheLoaiTheoTuKhoa();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    public void menuNhaXuatBan(){
        int chon;
        do{
            System.out.println("-------Menu Nha Xuat Ban-------");
            System.out.println("1.Them nha xuat ban");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua nha xuat ban");
            System.out.println("4.Xoa nha xuat ban");
            System.out.println("5.Tim nha xuat ban");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsnxb.nhap();
                    break;
                case 2:
                    dsnxb.xuat();
                    break;
                case 3:
                    dsnxb.sua();
                    break;
                case 4:
                    dsnxb.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim nha xuat ban theo ma");
                        System.out.println("2.Tim nha xuat ban theo ten");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsnxb.timKiemTheoMaNhaXuatBan();
                                break;
                            case 2:
                                dsnxb.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke so luong nha xuat ban");
                        System.out.println("2.Thong ke theo tu khoa");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsnxb.thongKeTongSoNhaXuatBan();
                                break;
                            case 2:
                                dsnxb.thongKeTheLoaiTheoTuKhoa();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    private void capNhatPhieuPhat(int i){
        if(i==-1) return;
        QuyDinhPhat q=dsphieuphat.layQuyDinhPhatTheoChiSo(i);
        for(PhieuPhat p:dsphieuphat.getDS())
            if(q.getMaPhat().equals(p.getMaphat()))
                p.setTienPhat(q.getTienPhat());
    }
    public void menuQuyDinh(){
        int chon;
        do{
            System.out.println("-------Menu Quy Dinh-------");
            System.out.println("1.Them quy dinh");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua quy dinh");
            System.out.println("4.Xoa quy dinh");
            System.out.println("5.Tim quy dinh");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsquydinhphat.nhap();
                    break;
                case 2:
                    dsquydinhphat.xuat();
                    break;
                case 3:
                    int i=dsquydinhphat.sua();
                    capNhatPhieuPhat(i);
                    break;
                case 4:
                    dsquydinhphat.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim quy dinh theo ma");
                        System.out.println("2.Tim quy dinh theo mo ta");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsquydinhphat.timKiemTheoMaQuyDinh();
                                break;
                            case 2:
                                dsquydinhphat.timKiemTheoMoTa();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke so luong quy dinh");
                        System.out.println("2.Thong ke theo so tien phat");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsquydinhphat.thongKeSoLuongQuyDinh();
                                break;
                            case 2:
                                dsquydinhphat.thongKeTheoTienPhat();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    public void menuNhaCungCap(){
        int chon;
        do{
            System.out.println("-------Menu Nha Cung Cap-------");
            System.out.println("1.Them nha cung cap");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua nha cung cap");
            System.out.println("4.Xoa nha cung cap");
            System.out.println("5.Tim nha cung cap");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsncc.nhap();
                    break;
                case 2:
                    dsncc.xuat();
                    break;
                case 3:
                    dsncc.sua();
                    break;
                case 4:
                    dsncc.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim nha cung cap theo ma");
                        System.out.println("2.Tim nha cung cap theo ten");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsncc.timKiemTheoMaNhaCungCap();
                                break;
                            case 2:
                                dsncc.timKiemTheoTen();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke so luong nha cung cap");
                        System.out.println("2.Thong ke theo tu khoa");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsncc.thongKeSoLuongNhaCungCap();
                                break;
                            case 2:
                                dsncc.thongKeTheoTuKhoa();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    public void menuPhieuPhat(){
        int chon;
        do{
            System.out.println("-------Menu Phieu Phat-------");
            System.out.println("1.Them phieu phat");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua phieu phat");
            System.out.println("4.Xoa phieu phat");
            System.out.println("5.Tim phieu phat");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsphieuphat.nhap(dsquydinhphat);
                    break;
                case 2:
                    dsphieuphat.xuat();
                    break;
                case 3:
                    dsphieuphat.sua();
                    break;
                case 4:
                    dsphieuphat.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim phieu phat theo ma phieu phat");
                        System.out.println("2.Tim phieu phat theo ma doc gia");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsphieuphat.timKiemTheoMaPhieuPhat();
                                break;
                            case 2:
                                dsphieuphat.timKiemTheoMaDocGia();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo tien phat");
                        System.out.println("2.Thong ke theo ma doc gia");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsphieuphat.thongKeTheoTienPhat();
                                break;
                            case 2:
                                dsphieuphat.thongKeTheoDocGia();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    public void menuChiTietPhieuMuon(PhieuMuon p){
        int chon;
        do{
            System.out.println("-------Menu Chi Tiet Phieu Muon-------");
            System.out.println("1.Them chi tiet phieu muon");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua chi tiet phieu muon");
            System.out.println("4.Xoa chi tiet phieu muon");
            System.out.println("5.Tim chi tiet phieu muon");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    p.getDS().nhap(p.getMaPhieuMuon());
                    break;
                case 2:
                    p.getDS().xuat();
                    break;
                case 3:
                    p.getDS().sua();
                    break;
                case 4:
                    p.getDS().xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim chi tiet phieu muon theo ma sach");
                        System.out.println("2.Tim chi tiet phieu muon theo so luong sach");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                p.getDS().timKiemTheoMaSach();
                                break;
                            case 2:
                                p.getDS().timKiemTheoSoLuong();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo ma sach");
                        System.out.println("2.Thong ke theo so luong");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                p.getDS().thongKeTheoMaSach();
                                break;
                            case 2:
                                p.getDS().thongKeTheoSoLuong();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    private boolean kiemTraNgayTraThucTe(PhieuMuon pm){
        LocalDate ngayTra = LocalDate.parse(pm.getNgayTra());
        LocalDate ngayTraThucTe = LocalDate.parse(pm.getNgayTraThucTe());
        return ngayTra.isBefore(ngayTraThucTe);
    }
    private void capNhatPhieuPhatTheoPhieuMuon(PhieuMuon pm){
        String maphieuphatmoi;
        if(kiemTraNgayTraThucTe(pm)){
            if(dsphieuphat.getDS().length==0 )
                maphieuphatmoi="1";
            else{
                String last =dsphieuphat.getDS()[dsphieuphat.getSoLuong()-1].getMaPhieuPhat();
                String ma=last.substring(2);
                int so= Integer.parseInt(ma) + 1;
                maphieuphatmoi="PP" + Integer.toString(so);
            }
            PhieuPhat pp =new PhieuPhat(maphieuphatmoi,pm.getMaDocGia(),pm.getMaPhieuMuon(),"1",100);//chua thong nhat ma phat va tien phat nen de so 1 va 100
            dsphieuphat.them(pp);
            System.out.println("Doc gia "+pm.getMaDocGia()+" bi phat do tra qua thoi han");
            return;
        }
    }
    public void menuPhieuMuon(){
        int chon;
        do{
            System.out.println("-------Menu Phieu Muon-------");
            System.out.println("1.Them phieu muon");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua phieu muon");
            System.out.println("4.Xoa phieu muon");
            System.out.println("5.Tim phieu muon");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quan ly chi tiet phieu muon");
            System.out.println("8.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsphieumuon.nhap();
                    break;
                case 2:
                    dsphieumuon.xuat();
                    break;
                case 3:
                    PhieuMuon p=dsphieumuon.sua();
                    if(p!=null) capNhatPhieuPhatTheoPhieuMuon(p);
                    break;
                case 4:
                    dsphieumuon.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim phieu muon theo ma phieu muon");
                        System.out.println("2.Tim phieu muon theo ngay lap phieu");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dsphieumuon.timKiemTheoMaPhieuMuon();
                                break;
                            case 2:
                                dsphieumuon.timKiemTheoNgayLapPhieu();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo ma doc gia");
                        System.out.println("2.Thong ke theo ma nhan vien");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                thongKeSoLuongSachDocGiaMuon();
                                break;
                            case 2:
                                dsphieumuon.thongKeTheoMaNhanVien();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Nhap ma phieu muon can quan ly chi tiet: ");
                    String maPM = sc.nextLine();
                    PhieuMuon pm = dsphieumuon.getPhieuByMa(maPM);
                    if(pm!=null) menuChiTietPhieuMuon(pm);
                    else System.out.println("Khong tim thay phieu muon co ma: "+maPM);
                    break;
                case 8:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=8);
    }
    public void menuPhieuNhapSach(){
        int chon;
        do{
            System.out.println("-------Menu Phieu Nhap Sach-------");
            System.out.println("1.Them phieu nhap sach");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua phieu nhap sach");
            System.out.println("4.Xoa phieu nhap sach");
            System.out.println("5.Tim phieu nhap sach");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quan ly chi tiet phieu nhap sach");
            System.out.println("8.Quay lai menu chinh");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dspns.nhap();
                    break;
                case 2:
                    dspns.xuat();
                    break;
                case 3:
                    dspns.sua();
                    break;
                case 4:
                    dspns.xoa();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim phieu nhap sach theo ma phieu nhap sach");
                        System.out.println("2.Tim phieu nhap sach theo ngay nhap sach");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                dspns.timKiemTheoMaPhieuNhapSach();
                                break;
                            case 2:
                                dspns.timKiemTheoNgayNhapSach();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo ma nhan vien");
                        System.out.println("2.Thong ke theo ma nha cung cap");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                thongKeTheoMaNhanVien();
                                break;
                            case 2:
                                dspns.thongKeTheoNhaCungCap();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Nhap ma phieu nhap sach muon quan ly chi tiet: ");
                    String maPNS = sc.nextLine();
                    PhieuNhapSach p = dspns.getPhieuByMa(maPNS);
                    if(p!=null) menuChiTietPhieuNhapSach(p);
                    break;
                case 8:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=8);
    }
    public void menuChiTietPhieuNhapSach(PhieuNhapSach p){
        int chon;
        do{
            System.out.println("-------Menu Chi Tiet Phieu Nhap Sach-------");
            System.out.println("1.Them chi tiet phieu nhap sach");
            System.out.println("2.Xuat danh sach");
            System.out.println("3.Sua chi tiet phieu nhap sach");
            System.out.println("4.Xoa chi tiet phieu nhap sach");
            System.out.println("5.Tim chi tiet phieu nhap sach");
            System.out.println("6.Thong ke"); 
            System.out.println("7.Quay lai menu phieu nhap sach");
            System.out.print("Ban chon: ");
            chon=sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    p.getDSCTPNS().nhap(p.getMaPhieuNhapSach());
                    p.tinhTongTien();
                    break;
                case 2:
                    p.getDSCTPNS().xuat();
                    break;
                case 3:
                    p.getDSCTPNS().sua();
                    p.tinhTongTien();
                    break;
                case 4:
                    p.getDSCTPNS().xoa();
                    p.tinhTongTien();
                    break;
                case 5:
                    do{
                        System.out.println("-------Menu Tim Kiem-------");
                        System.out.println("1.Tim chi tiet phieu nhap sach theo ma sach");
                        System.out.println("2.Tim chi tiet phieu nhap sach theo so luong");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                p.getDSCTPNS().timKiemTheoMaSach();
                                break;
                            case 2:
                                p.getDSCTPNS().timKiemTheoSoLuong();
                                break;
                            case 3:
                                System.out.println("Thoat tim kiem");
                                break;
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 6:
                    do{
                        System.out.println("-------Menu Thong Ke-------");
                        System.out.println("1.Thong ke theo ma sach");
                        System.out.println("2.Thong ke so luong");
                        System.out.println("3.Quay lai");
                        System.out.print("Ban chon: ");
                        chon=sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                p.getDSCTPNS().thongKeTheoMaSach();
                                
                                break;
                            case 2:
                                p.getDSCTPNS().thongKeSoLuong();
                                break;
                            case 3:
                                System.out.println("Thoat thong ke");
                            default:
                                System.out.println("Nhap sai vui long nhap lai");
                        }
                    }while(chon!=3);
                    break;
                case 7:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }while(chon!=7);
    }
    public void thongKeSoLuongSachDocGiaMuon(){
        Map<String,Integer> count=new HashMap<>();
        count=dsphieumuon.thongKeTheoDocGia();
        boolean kt=false;
        for(Map.Entry<String,Integer> t: count.entrySet()){
            DocGia dg=dsdg.traVeDocGiaTheoMa(t.getKey());
            if(dg==null) continue;
            if(!kt){
                System.out.println("+------------+----------------------+------------+-----------------------+");
                System.out.printf("| %-10s | %-20s | %-10s | %-21s |\n","Ma doc gia","Ho","Ten","So luong sach da muon");
                System.out.println("|------------|----------------------|------------|-----------------------|");
                kt=true;
            } 
            System.out.printf("| %-10s | %-20s | %-10s | %-21s |\n",t.getKey(),dg.getHo(),dg.getTen(),t.getValue());
        }
        if(kt) System.out.println("+------------+----------------------+------------+-----------------------+");
    }
    public void thongKeTheoMaNhanVien(){
        Map<String,Double> count=new HashMap<>();
        for(PhieuNhapSach pns:dspns.getDS())
            count.put(pns.getMaNhanVien(),count.getOrDefault(pns.getMaNhanVien(),0.0)+pns.getTongTien());
            boolean kt=false;
        for(Map.Entry<String,Double> entry :count.entrySet()){
            NhanVien nv=dsnv.traVeNhanVienTheoMa(entry.getKey());
            if(!kt){
                System.out.println("+---------------+----------------------+------------+-----------+");
                System.out.printf("| %-13s | %-20s | %-10s | %-9s |\n","Ma nhan vien","Ho","Ten","Tong tien");
                System.out.println("|---------------|----------------------|------------|-----------|");
            }
            kt=true;
            System.out.printf("| %-13s | %-20s | %-10s | %-9s |",nv.getManhanvien(),nv.getHo(),nv.getTen(),entry.getValue());
        }
    }
    public static void main(String[] args){
        QuanLyThuVien ql =new QuanLyThuVien();
        ql.docTatCaFile();
        ql.menu();
        ql.ghiTatCaFile();
    }
}

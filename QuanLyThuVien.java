import java.util.Arrays;
import java.util.Scanner;
public class QuanLyThuVien {
    private DanhSachSach dss=new DanhSachSach();
    private DanhSachTacGia dstg=new DanhSachTacGia();
    private DanhSachTheLoai dstl=new DanhSachTheLoai();
    private DanhSachPhieuNhapSach dspns=new DanhSachPhieuNhapSach();
    private DanhSachChiTietPhieuNhapSach dsctpns=new DanhSachChiTietPhieuNhapSach();
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
        dsdg.docFile();
        dsnv.docFile();
        dsncc.docFile();
        dsphieuphat.docFile();
        dsquydinhphat.docFile();
        dsnxb.docFile();
    }
}

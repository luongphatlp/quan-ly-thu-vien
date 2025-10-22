import java.util.Scanner;

public class menu {
    QuanLyThuVien ql=new QuanLyThuVien();
    Scanner sc=new Scanner(System.in);
    public void mainmenu(){
        int chon;
        ql.docTatCaFile();
        do{
            System.out.println("1.Quan ly sach");
            System.out.println("2.Quan ly doc gia");
            System.out.println("3.Quan ly nha xuat ban");
            System.out.println("4.Quan ly nha cung cap");
            System.out.println("5.Quan ly phieu nhap sach");
            System.out.println("6.Quan ly phieu muon");
            System.out.println("7.Thoat");
            System.out.print("Ban chon: ");
            chon=ql.sc.nextInt();
            switch(chon){
                case 1:
                    menuSach();
                    break;
                case 2:
                    ql.menuDocGia();
                    break;
                case 3:
                    ql.menuNhaXuatBan();
                    break;
                case 4:
                    ql.menuNhaCungCap();
                    break;
                case 5:
                    ql.menuPhieuNhapSach();
                    break;
                case 6:
                    ql.menuPhieuMuon();
                    break;
                case 7:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Nhap sai!Vui long nhap lai!");
            }
        }while(chon!=7);
    }
    public void menusach(){
        DanhSachSach dss=ql.getDss();
        do{
            System.out.println("1.Them sach");
            System.out.println("2.Xoa sach");
            System.out.println("3.Sua sach");
            System.out.println("4.Tim kiem sach");
            System.out.println("5.Hien thi danh sach sach");
            System.out.println("6.Quay lai");
            System.out.print("Ban chon: ");
            int chon=sc.nextInt();
            switch(chon){
                case 1:
                    dss.them();
                    break;
                case 2:
                    ql.getDss().xoaSach();
                    break;
                case 3:
                    ql.getDss().suaSach();
                    break;
                case 4:
                    ql.getDss().timKiemSach();
                    break;
                case 5:
                    ql.getDss().hienThiDanhSachSach();
                    break;
                case 6:
                    System.out.println("Quay lai menu chinh!");
                    break;
                default:
                    System.out.println("Nhap sai!Vui long nhap lai!");
            }
    }
}

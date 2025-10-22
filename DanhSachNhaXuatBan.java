import java.util.Arrays;
import java.util.Scanner;
public class DanhSachNhaXuatBan {
    NhaXuatBan[] ds=new NhaXuatBan[0];

    public DanhSachNhaXuatBan(){}
    public DanhSachNhaXuatBan(NhaXuatBan[] ds1){
        ds=Arrays.copyOf(ds1,ds1.length);
    }
    public DanhSachNhaXuatBan(DanhSachNhaXuatBan ds1){
        ds=Arrays.copyOf(ds1.ds,ds1.ds.length);
    }

    Scanner sc=new Scanner(System.in);
    public void nhap(){
        int bd=ds.length;
        System.out.println("Nhap so luong can nhap: ");
        int k=sc.nextInt();
        sc.nextLine();
        ds=Arrays.copyOf(ds,ds.length+k);
        for(int i=bd;i<ds.length;i++){
            ds[i]=new NhaXuatBan();
            ds[i].nhap();
        }
    }
    public void them(){
        System.out.println("Nhap thong tin nha xuat ban can them.");
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new NhaXuatBan();
        ds[ds.length-1].nhap();
    }
    public void them(NhaXuatBan nxb){
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=new NhaXuatBan();
        ds[ds.length-1]=nxb;
    }
    public void sua(){
        String ma;
        System.out.println("Nhap ma nha xuat ban can sua: ");
        ma=sc.nextLine();
        sua(ma);
    }
    public void sua(String ma){
        for(NhaXuatBan nxb:ds){
            if(ma.equals(nxb.getMaNXB())){
                System.out.println("Nhap ten nha xuat ban: ");
                nxb.setTenNXB(sc.nextLine());
                break;
            }
        }
    }
    public int timkiem(String ma){
        for(int i=0;i<ds.length;i++){
            if(ma.equals(ds[i].getTenNXB())){
                return i;
            }
        }
        return -1;
    }
    public void xoa(String ma){
        int k=timkiem(ma);
        if(k==-1){
            System.out.println("Khong tim thay nha xuat ban co ma: "+ma);
            return ;
        }
        for(int i=k;i<ds.length-1;i++)
            ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds,ds.length-1);
    }
}

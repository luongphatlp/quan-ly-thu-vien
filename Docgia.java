import java.util.Scanner;
public class DocGia {
    private String madocgia;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh ;
    private String sdt;

    public DocGia(){}
    public DocGia(String madocgia,String ho,String ten,String gioitinh,String ngaysinh,String sdt){
        this.madocgia=madocgia;
        this.ho=ho;
        this.ten=ten;
        this.gioitinh=gioitinh;
        this.ngaysinh=ngaysinh;
        this.sdt=sdt;
    }
    public DocGia(DocGia dg){
        this.madocgia=dg.madocgia;
        this.ho=dg.ho;
        this.ten=dg.ten;
        this.gioitinh=dg.gioitinh;
        this.ngaysinh=dg.ngaysinh;
        this.sdt=dg.sdt;
    }
    public String getMaDocGia(){return madocgia;}
    public String getHo(){return ho;}
    public String getTen(){return ten;}
    public String getGioiTinh(){return gioitinh;}
    public String getNgaySinh(){return ngaysinh;}
    public String getSDT(){return sdt;}
    public void setMaDocGia(String madocgia){this.madocgia=madocgia;}
    public void setHo(String ho){this.ho=ho;}
    public void setTen(String ten){this.ten=ten;}
    public void setGioiTinh(String gioitinh){this.gioitinh=gioitinh;}
    public void setSDT(String sdt){this.sdt=sdt;}
    public void setNgaySinh(String ngaysinh){this.ngaysinh=ngaysinh;}

}

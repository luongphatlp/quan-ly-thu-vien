import java.util.Scanner;

public class NhaXuatBan {
    private String manxb;
    private String tennxb;

    public NhaXuatBan(){}
    public NhaXuatBan(String manxb,String tennxb){
        this.manxb=manxb;
        this.tennxb=tennxb;
    }
    public NhaXuatBan(NhaXuatBan nxb){
        this.manxb=nxb.manxb;
        this.tennxb=nxb.tennxb;
    }
    public String getMaNXB(){return manxb;}
    public String getTenNXB(){return tennxb;}
    public void setMaNXB(String manxb){this.manxb=manxb;}
    public void setTenNXB(String tennxb){this.tennxb=tennxb;}
}

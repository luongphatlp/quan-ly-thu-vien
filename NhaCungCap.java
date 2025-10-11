public class NhaCungCap {
    private String mancc;
    private String tenncc;
    public NhaCungCap(){}
    public NhaCungCap(String mancc,String tenncc){
        this.mancc=mancc;
        this.tenncc=tenncc;
    }
    public NhaCungCap(NhaCungCap ncc){
        this.mancc=ncc.mancc;
        this.tenncc=ncc.tenncc;
    }
    public String getMaNCC(){return mancc;}
    public String getTenNCC(){return tenncc;}
    public void setTenNCC(String tenncc){this.tenncc=tenncc;}
    public void setMaNCC(String mancc){this.mancc=mancc;}
}

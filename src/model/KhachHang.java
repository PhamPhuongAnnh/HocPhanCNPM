package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Đổi kiểu dữ liệu của maKhachHang, diaChi thành String
    Thêm hàm inputKH => phục vụ cho việc thêm khách hàng

 */
public class KhachHang {

    private String maKhachHang;
    private String ten;
    private String ho;
    private Date ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private String soDienThoai;
    private String diaChi;

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public KhachHang(String maKhachHang, String ten, String ho, Date ngaySinh, String gioiTinh, String cmnd,
                  String soDienThoai, String diaChi) {
        super();
        this.maKhachHang = maKhachHang;
        this.ten = ten;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public KhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "KhachHang [maKhachHang=" + maKhachHang + ", ten=" + ten + ", ho=" + ho + ", ngaySinh=" + ngaySinh
                      + ", gioiTinh=" + gioiTinh + ", cmnd=" + cmnd + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi
                      + "]";
    }

    public void inputKH() {
        Scanner s = new Scanner(System.in);
        System.out.print("\n Nhập mã Khách hàng: ");
        this.setMaKhachHang((s.nextLine()));
        System.out.print("\n Nhập tên: ");
        this.setTen(s.nextLine());
        System.out.print("\n Nhập họ: ");
        this.setHo(s.nextLine());

        //SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        System.out.print("\n Nhập ngày sinh: ");
        String d = s.nextLine();
        this.setNgaySinh(Date.valueOf(d));
        //try {

//            Date date = (Date) df.parse(s.nextLine());
//            this.setNgaySinh(date);

//        } catch (ParseException ex) {
//            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
//        }

        System.out.print("\n Nhập giới tính: ");
        this.setGioiTinh(s.nextLine());
        System.out.print("\n Nhập cmnd: ");
        this.setCmnd(s.nextLine());
        System.out.print("\n Nhập số điện thoại: ");
        this.setSoDienThoai(s.nextLine());
        System.out.print("\n Nhập địa chỉ: ");
        this.setDiaChi(s.nextLine());

    }

    public Vector<Object> toVector() {
        Vector<Object> v = new Vector<>();
        v.add("");
        v.add(maKhachHang);
        v.add(ho);
        v.add(ten);
        v.add(ngaySinh);
        v.add(gioiTinh);
        v.add(cmnd);
        v.add(soDienThoai);

        v.add(diaChi);
        return v;
    }

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        System.out.print("\n Nhập ngày sinh: ");
        try {

            Date date;
            date = (Date) df.parse(new Scanner(System.in).nextLine());

        } catch (ParseException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

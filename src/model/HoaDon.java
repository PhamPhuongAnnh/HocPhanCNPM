/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDon {
    private String ma;
    private Date ngayLap;
    private double tongTien;
    private String maNhanVien;
    private String maKhachHang;

    public HoaDon() {
    }

    public HoaDon(String ma, Date ngayLap, double tongTien, String maNhanVien, String maKhachHang) {
        this.ma = ma;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "ma=" + ma + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang + '}';
    }
    
}

package model;

import java.sql.Date;
import java.util.Vector;

public class KhachHang {
	private String maKhachHang;
        private String ho;
	private String ten;
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
	
	public String  getDiaChi() {
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
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contronler;

import static contronler.docghiFile.PATH_FILE_KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.Thuoc;

/**
 *
 * @author PC
 */
public class LapHoaDon {
    static List<KhachHang> listKhachHang = new ArrayList();
    static List<Thuoc> listThuoc = new ArrayList();
    static List<NhanVien> listNhanVien = new ArrayList();
    static List<HoaDon> listHoaDon = new ArrayList();
    public static void main(String[] args) {
        String ch;
        do {          
            System.out.println("-------------<MENU>------------");
            System.out.println("a.Thêm Khách hàng");
            System.out.println("b.Tìm mã khách hàng theo số điện thoại");
            System.out.println("c.Lấy hóa đơn loại kê đơn");
            System.out.println("d.Sửa tên thuốc trong hóa đơn");
            System.out.println("e.Xóa tên thuốc trong hóa đơn");
            System.out.println("f.Tìm kiếm thông tin thuốc theo tên thuốc");
            System.out.println("g.Tìm mã nhân viên khi biết tên đăng nhập");
            System.out.println("h.Tìm mã thuốc khi biết tên thuốc");
            System.out.println("i.Tìm mã tên nhân viên khi biết tên tài khoản");
            System.out.println("k.Tìm mã hóa đơn khi biết mã nhân viên");
            System.out.println("l.Tìm số lượng thuốc đã bán theo mã thuốc");
            System.out.println("m.Tìm số lượng thuốc nhập theo mã thuốc");
            System.out.println("m.Tìm mã thuốc theo tên và theo đơn vị tính");
            ch = new Scanner(System.in).nextLine();
            switch(ch){
                case "a": 
                    System.out.println(PATH_FILE_KhachHang);
                    System.out.println("a.Thêm Khách hàng");
                    ThemKH(listKhachHang);
                    break;
                    
                case "b": 
                    System.out.println("b.Tìm mã khách hàng theo số điện thoại");
                    System.out.println("Mã Khách hàng cần tìm là: " + TimMKH(listKhachHang));
                    break;
                    
                case "c": 
                    System.out.println("c.Lấy hóa đơn loại kê đơn");
                    break;
                    
                case "d":
                    System.out.println("d.Sửa tên thuốc trong hóa đơn");
                    break;
                    
                case "e":
                    System.out.println("e.Xóa tên thuốc trong hóa đơn");
                    break;
                    
                case "f":
                    System.out.println("f.Tìm kiếm thông tin thuốc theo tên thuốc");
                    System.out.println("Thông tin thuốc là: \n " + TimKiemThuoc(listThuoc));
                    break;
                    
                case "g":
                    System.out.println("g.Tìm mã nhân viên khi biết tên đăng nhập");
                    TimMaNV(listNhanVien);
                    break;
                    
                case "h": 
                    System.out.println("h.Tìm mã thuốc khi biết tên thuốc");
                    TimMaThuoc(listThuoc);
                    break;
                    
                case "i":
                    System.out.println("i.Tìm mã tên nhân viên khi biết tên tài khoản");
                    System.out.println("Mã nhân viên cần tìm là: " + TimTenNV(listNhanVien));
                    break;
                    
                case "k":
                    System.out.println("k.Tìm mã hóa đơn khi biết mã nhân viên");
                    System.out.println("Mã hóa đơn cần tìm là: " + TimMaHD(listHoaDon));
                    break;
                    
                case "l":
                    System.out.println("l.Tìm số lượng thuốc đã bán theo mã thuốc");
                    break;
                    
                case "m":
                    System.out.println("m.Tìm số lượng thuốc nhập theo mã thuốc");
                    System.out.println("Số lượng thuốc nhập là: " + TimSTN(listThuoc));
                    break;
                    
                case "n":
                    System.out.println("m.Tìm mã thuốc theo tên và theo đơn vị tính");
                    System.out.println("Mã thuốc là: " + TimMT(listThuoc));
                    break;
            }
            
        } while (true);
    }
    //thêm mã khách hàng
    public static void ThemKH(List<KhachHang> listKhachHang){
        KhachHang kh = new KhachHang();
        kh.inputKH();
        listKhachHang.add(kh);System.out.println("okkk");
        //docghiFile doc = new docghiFile();
        docghiFile.ghiFileKhachHang(listKhachHang);       
    }
    //thêm địa chỉ
    // tìm kiếm mã khách hàng theo số điện thoại 
    public static String TimMKH(List<KhachHang> listKhachHang ){       
        KhachHang kh;
        System.out.print("Nhập số điện thoại: ");
        String sdt = new Scanner(System.in).nextLine();
        for (Object o : listKhachHang) {
            kh = (KhachHang)o;
            if(kh.getSoDienThoai().equalsIgnoreCase(sdt))
                return kh.getMaKhachHang();
        }
        return "Không tồn tại";
    }
   //lấy hóa đơn loại kê đơn
   //update tên thuốc
   // xóa thuốc trong hóa đơn
    
    //tìm kiếm theo tên thuốc
    public static String TimKiemThuoc(List<Thuoc> listThuoc){
        System.out.print("Nhập tên thuốc: ");
        String tenThuoc = new Scanner(System.in).nextLine();
        Thuoc t;
        for(Object o : listThuoc){
            t = (Thuoc)o;
            if(t.getTenThuoc().equalsIgnoreCase(tenThuoc))
                return t.toString();
        }
        return "Không tồn tại";
    }
    //Lấy mã nhân viên khi biết tên DN
    public static String TimMaNV(List<NhanVien> listNhanVien){
        System.out.print("Nhập tên đăng nhập: ");
        String tenDN = new Scanner(System.in).nextLine();
        NhanVien nv;
        for(Object o : listNhanVien){
            nv = (NhanVien)o;
            if(nv.getTaiKhoan().equalsIgnoreCase(tenDN))
                return nv.getMaNhanVien();
        }
        return "Không tồn tại";
    }
    //lấy mã thuốc khi biết tên thuốc
    public static int TimMaThuoc(List<Thuoc> listThuoc){
        System.out.println("Nhập tên thuốc: ");
        String tenThuoc = new Scanner(System.in).nextLine();
        Thuoc t;
        for (Object o : listThuoc) {
            t = (Thuoc)o;
            if(t.getTenThuoc().equalsIgnoreCase(tenThuoc))
                return t.getMaThuoc();
        }
        return 0;
    }
    // lấy tên nhân viên khi biết tên tài khoản
    public static String TimTenNV(List<NhanVien> listNhanVien){
        System.out.print("Nhập tên tài khoản: ");
        String tenTK = new Scanner(System.in).nextLine();
        NhanVien nv;
        for (Object o : listNhanVien) {
            nv = (NhanVien)o;
            if(nv.getTaiKhoan().equalsIgnoreCase(tenTK))
                return nv.getMaNhanVien();
        }
        return "Không tồn tại";
    }
    // lấy mã hóa đơn khi biết mã nhân viên
    public static String TimMaHD(List<HoaDon> listHoaDon){
        System.out.print("Nhập mã nhân viên: ");
        String maNV = new Scanner(System.in).nextLine();
        HoaDon hd;
        for(Object o : listHoaDon){
            hd = (HoaDon)o;
            if(hd.getMaNhanVien().equalsIgnoreCase(maNV));
            return hd.getMa();
        }
        return "Không tồn tại";
    }
    //lấy số lượng thuốc đã bán theo mã thuốc
    
    // lấy số lượng thuốc nhập theo mã thuốc
    public static int TimSTN(List<Thuoc> listThuoc){
        System.out.println("Nhập mã thuốc: ");
        int mat = Integer.parseInt(new Scanner(System.in).nextLine());
        Thuoc t;
        for (Object o : listThuoc) {
            t = (Thuoc)o;
            if(t.getMaThuoc() == mat)
                return t.getSoLuongNhap();
        }
        return 0;
    }
    //mã thuốc theo tên và theo đơn vị tính
    public static int TimMT(List<Thuoc> listThuoc){
        System.out.print("Nhập tên thuốc: ");
        String tenT = new Scanner(System.in).nextLine();
        System.out.print("Nhập đơn vị tính: ");
        String donVT = new Scanner(System.in).nextLine();
        Thuoc t;
        for (Object o : listThuoc) {
            t = (Thuoc)o;
            if(t.getTenThuoc().equalsIgnoreCase(tenT) && t.getDonViTinh().equalsIgnoreCase(donVT))
                return t.getMaThuoc();
        }
        return 0;
    }             
}

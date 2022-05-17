package contronler;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.KhachHang;
import model.NhaCungCap;
import model.NhanVien;
import model.TaiKhoan;
import model.Thuoc;

/*
    T đã làm xong phần đọc ghi file của những phần còn lại rồi
    

*/


//NOTE: ghi file thì ghi vào dạng String nên các kiểu dữ liệu khác phải chuyển về String nhé
public class docghiFile {

    // lấy đường dẫn  thư mục hiện tại 
    private static final String curentDir = System.getProperty("user.dir");

    // khai báo cái dấu // này để có thể đường đẫn đến nơi ghi file 
    private static final String separator = File.separator;

    // ví dụ đường dẫn đến cái khách hàng.csv là    đường dẫn đến thưc mục hiện tại+//+ data (forder data)+// (khachHang.csv)tenfile
     static final String PATH_FILE_KhachHang = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static final String PATH_FILE_CSV_NhanVien = curentDir + separator + "data" + separator + "NhanVien.csv";
    private static final String PATH_FILE_CSV_NhaCungCap = curentDir + separator + "data" + separator + "NhaCungCap.csv";
    private static final String PATH_FILE_CSV_HoaDon = curentDir + separator + "data" + separator + "HoaDon.csv";
    private static final String PATH_FILE_CSV_TaiKhoan = curentDir + separator + "data" + separator + "TaiKhoan.csv";
    private static final String PATH_FILE_CSV_TaiThuoc = curentDir + separator + "data" + separator + "Thuoc.csv";

    // hàm ghi file khách hàng với tham số truyền vào là một list khách hàng
    public static void ghiFileKhachHang(List<KhachHang> listKhachHang) {
        FileWriter fw = null; // dùng để ghi file 

        // dùng để format cái ngày tháng nhập vào
        //SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // new file truyền vào đường dẫn của file khách hàng
            File f = new File(PATH_FILE_KhachHang);

            // kiểm tra xem file có tồn tại không nếu tồn tại thì
            if (!f.exists()) {
                fw = new FileWriter(f, true); // try catch cho dòng này vì có xảy ra các ngoại lệ 

                // vì csv không có sẵn nên phải thêm thư viện của nó mới dùng được CSVWriter 
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                // mảng để lưu cái tiêu đề 
                String[] header = {"Ma KH", "Ho", "Ten", "Ngay Sinh", "Gioi Tinh", "CCCD", "SĐT", "Dia Chi"};

                // ghi vào file cái dòng đầu 
                csvWrite.writeNext(header);
                fw.append("\n");
                //csvWrite.writeNext("\n");

                // duyệt danh sách khách hàng
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaKhachHang()), item.getHo(), item.getTen(), String.valueOf(item.getNgaySinh()), item.getGioiTinh(), item.getCmnd(), item.getDiaChi()});
                }
            } // th file không trống (đã có dữ liệu trong file )
            else {
                fw = new FileWriter(f, true); // try catch cho dòng này vì có xảy ra các ngoại lệ 

                // vì csv không có sẵn nên phải thêm thư viện của nó mới dùng được CSVWriter 
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                // duyệt danh sách khách hàng
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaKhachHang()), item.getHo(), item.getTen(), String.valueOf(item.getNgaySinh()), item.getGioiTinh(), item.getCmnd(), item.getDiaChi()});
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fw != null) { // dùng để đóng file khi ghi xong 
                try {
                    fw.close();

                } catch (IOException ex) {
                    Logger.getLogger(docghiFile.class
                                  .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // hàm ghi file nhân viên 
    public static void ghiFileNhanVien(List<NhanVien> listNhanVien) {
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
            File f = new File(PATH_FILE_CSV_NhanVien);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_NhanVien, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma NV", "Ca lam viec", "Ho", "Ten", "Ngay Sinh", "Gioi Tinh", "CMND",
                    "SDT", "Dia Chi", "Tai Khoan", "Loai Nhan Vien", "Trang Thai"};
                csvWrite.writeNext(header);
                for (NhanVien nv : listNhanVien) {
                    csvWrite.writeNext(new String[]{nv.getMaNhanVien(), nv.getCaLamViec(), nv.getHo(), nv.getTen(), df.format(nv.getNgaySinh()), nv.getGioiTinh(), nv.getCmnd(),
                        nv.getSoDienThoai(), nv.getDiaChi(), String.valueOf(nv.getTaiKhoan()), nv.getLoaiNhanVien(), nv.getTrangThai()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_NhanVien, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (NhanVien nv : listNhanVien) {
                    csvWrite.writeNext(new String[]{nv.getMaNhanVien(), nv.getCaLamViec(), nv.getHo(), nv.getTen(), df.format(nv.getNgaySinh()), nv.getGioiTinh(), nv.getCmnd(),
                        nv.getSoDienThoai(), nv.getDiaChi(), String.valueOf(nv.getTaiKhoan()), nv.getLoaiNhanVien(), nv.getTrangThai()});
                }
            }
        } catch (IOException e) {
        } finally {
            if (fw != null)
                try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // hàm ghi file nhà cung cấp 
    public static void ghiFileNhaCungCap(List<NhaCungCap> listNhaCungCap) {
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV_NhaCungCap);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_NhaCungCap, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma NCC", "Ten NCC", "SDT", "Gmail", "Dia chi"};
                csvWrite.writeNext(header);
                for (NhaCungCap ncc : listNhaCungCap) {
                    csvWrite.writeNext(new String[]{String.valueOf(ncc.getMaNCC()), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getGmail(), ncc.getDiaChi()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_NhaCungCap, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (NhaCungCap ncc : listNhaCungCap) {
                    csvWrite.writeNext(new String[]{String.valueOf(ncc.getMaNCC()), ncc.getTenNCC(), ncc.getSoDienThoai(), ncc.getGmail(), ncc.getDiaChi()});

                }
            }
        } catch (Exception e) {
        } finally {
            if (fw != null)
                try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // hàm ghi file Thuốc 
    public static void ghiFileThuoc(List<Thuoc> listThuoc) {
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            File f = new File(PATH_FILE_CSV_TaiThuoc);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_TaiThuoc, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma Thuoc", "So ĐK", "Ten thuoc", "Nhom thuoc", "Phan loai", "Hoat chat", "Ham luong",
                    "Dang bao che", "Quy cach", "Tieu chuan", "Ma NCC", "Ngay SX", "Han su dung",
                    "Don vi tinh", "Gia nhap", "Don gia", "So luong nhap", "Hinh anh", "Trang thai"};
                csvWrite.writeNext(header);
                for (Thuoc t : listThuoc) {
                    csvWrite.writeNext(new String[]{String.valueOf(t.getMaThuoc()), t.getSoDangky(), t.getTenThuoc(), t.getNhomThuoc(),
                        t.getPhanLoai(), t.getHoatChat(), t.getHamLuong(), t.getDangBaoChe(), t.getQuyCach(),
                        t.getTieuChuan(), String.valueOf(t.getMaNCC()), df.format(t.getNgaySanXuat()), df.format(t.getHanSuDung()),
                        t.getDonViTinh(), String.valueOf(t.getGiaNhap()), String.valueOf(t.getDonGia()), String.valueOf(t.getSoLuongNhap()), String.valueOf(t.getHinhAnh()), t.getTrangThai()
                    });
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_TaiThuoc, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (Thuoc t : listThuoc) {
                    csvWrite.writeNext(new String[]{String.valueOf(t.getMaThuoc()), t.getSoDangky(), t.getTenThuoc(), t.getNhomThuoc(),
                        t.getPhanLoai(), t.getHoatChat(), t.getHamLuong(), t.getDangBaoChe(), t.getQuyCach(),
                        t.getTieuChuan(), String.valueOf(t.getMaNCC()), df.format(t.getNgaySanXuat()), df.format(t.getHanSuDung()),
                        t.getDonViTinh(), String.valueOf(t.getGiaNhap()), String.valueOf(t.getDonGia()), String.valueOf(t.getSoLuongNhap()), String.valueOf(t.getHinhAnh()), t.getTrangThai()
                    });
                }
            }
        } catch (Exception e) {
        } finally {
            if (fw != null)
                try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

// hàm ghi file hóa đơn 
    public static void ghiFileHoaDon(List<HoaDon> listHoaDon) {
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            File f = new File(PATH_FILE_CSV_HoaDon);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_TaiThuoc, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ma", "Ngay lap", "Tong tien", "Nhan vien", "Khach hang"};
                csvWrite.writeNext(header);
                for (HoaDon hd : listHoaDon) {
                    csvWrite.writeNext(new String[]{hd.getMa(), df.format(hd.getNgayLap()), String.valueOf(hd.getTongTien()), hd.getMaNhanVien(), hd.getMaKhachHang()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_TaiThuoc, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (HoaDon hd : listHoaDon) {
                    csvWrite.writeNext(new String[]{hd.getMa(), df.format(hd.getNgayLap()), String.valueOf(hd.getTongTien()), hd.getMaNhanVien(), hd.getMaKhachHang()});
                }
            }

        } catch (Exception e) {
        } finally {
            if (fw != null)
                try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // hàm ghi file tai khoan 
    public static void ghiFileTaiKhoan(List<TaiKhoan> listtaiKhoan) {
        FileWriter fw = null;
        try {
            File f = new File(PATH_FILE_CSV_TaiKhoan);
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_CSV_TaiKhoan, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                String[] header = {"Ten TK", "Ma khau", "Loai TK"};
                csvWrite.writeNext(header);
                for (TaiKhoan tk : listtaiKhoan) {
                    csvWrite.writeNext(new String[]{tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getLoaiTaiKhoan()});
                }
            } else {
                fw = new FileWriter(PATH_FILE_CSV_TaiKhoan, true);
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
                for (TaiKhoan tk : listtaiKhoan) {
                    csvWrite.writeNext(new String[]{tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getLoaiTaiKhoan()});
                }
            }
        } catch (Exception e) {
        } finally {
            if (fw != null)
                try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // hàm đọc file lấy dữ liệu
    public static List<KhachHang> docFileKhachHang() throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        // khai báo một list để trả về
        List<KhachHang> listKH = new ArrayList<>();

        // cái này để đọc file
        FileReader fr = null;

        try {
            // khai báo một cái để có thể lấy dữ liệu từ đường dẫn file khách hàng
            fr = new FileReader(PATH_FILE_KhachHang);
            CSVReader csvReader = new CSVReader(fr);

            // đọc file sẽ đọc từng dòng 1 nhé
            String[] line; // khai báo 1 mảng dùng để chứa 1 dòng đọc ra
            line = csvReader.readNext(); // đọc 1 dòng 
            while ((line = csvReader.readNext()) != null) { // nếu như mà chưa đọc đến dòng cuối cùng thì đọc tiếp
                //      0       1     2       3           4           5       6       7
                // {"Ma KH", "Ho", "Ten", "Ngay Sinh", "Gioi Tinh", "CCCD", "SĐT", "Dia Chi"};
                Date ngays = df.parse(line[3]);

                // khai báo một kh
                KhachHang kh = new KhachHang(line[0], line[1], line[2], (java.sql.Date) ngays, line[4], line[5], line[6], line[7]);

                // add vào list khach hang
                listKH.add(kh);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class
                          .getName()).log(Level.SEVERE, null, ex);

        } catch (CsvValidationException ex) {
            Logger.getLogger(docghiFile.class
                          .getName()).log(Level.SEVERE, null, ex);

        } catch (ParseException ex) {
            Logger.getLogger(docghiFile.class
                          .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fr != null) { // th để đóng file
                try {
                    fr.close();

                } catch (IOException ex) {
                    Logger.getLogger(docghiFile.class
                                  .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return listKH;
    }

    public static List<NhanVien> docFileNhanVien() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        // khai báo một list để trả về
        List<NhanVien> listNhanVien = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(PATH_FILE_CSV_NhanVien);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                Date ngay = df.parse(line[4]);
                NhanVien nv = new NhanVien(line[0], line[1], line[2], line[3], ngay, line[5], line[6], line[7],
                              line[8], line[9], line[10], line[11]);
                listNhanVien.add(nv);
                //  0           1           2       3       4           5           6
                //{"Ma NV", "Ca lam viec", "Ho", "Ten", "Ngay Sinh", "Gioi Tinh", "CMND",
                //  7           8       9               10              11
                // "SDT", "Dia Chi", "Tai Khoan", "Loai Nhan Vien", "Trang Thai"};

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException | ParseException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fr != null)
                try {
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listNhanVien;
    }

    public static List<NhaCungCap> docFileNhaCungCap() {
        // khai báo một list để trả về
        List<NhaCungCap> listNhaCungCap = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(PATH_FILE_CSV_NhaCungCap);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();        
            
            while ((line = csvReader.readNext()) != null){
                int ma = Integer.parseInt(line[0]);
                NhaCungCap ncc = new NhaCungCap(ma, line[1], line[2], line[3], line[4]);
                listNhaCungCap.add(ncc);
        //        0       1       2       3           4
        //"Ma NCC", "Ten NCC", "SDT", "Gmail", "Dia chi"        
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listNhaCungCap;
    }

    public static List<Thuoc> docFileThuoc() {
        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        // khai báo một list để trả về
        List<Thuoc> listThuoc = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(PATH_FILE_CSV_TaiThuoc);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null){
                int mt = Integer.parseInt(line[0]);
                int mncc = Integer.parseInt(line[10]);
                Date nsx = df.parse(line[11]);
                Date hsd = df.parse(line[12]);
                Float gn = Float.parseFloat(line[14]);
                Float dg = Float.parseFloat(line[14]);
                int sl = Integer.parseInt(line[16]);
                Byte ha = Byte.parseByte(line[17]);
                Thuoc t = new Thuoc(mt, line[1],line[2], line[3], line[4], line[5], line[6]
                                    , line[7], line[8], line[9], mncc, nsx, hsd, line[13], gn
                                    , dg, sl, ha, line[18] );
                listThuoc.add(t);
//        0        1           2               3           4           5           6 
//// "Ma Thuoc", "So ĐK", "Ten thuoc", "Nhom thuoc", "Phan loai", "Hoat chat", "Ham luong",
//        7               8           9           10          11          12
////  "Dang bao che", "Quy cach", "Tieu chuan", "Ma NCC", "Ngay SX", "Han su dung",
//            13          14          15          16          17              18
////  "Don vi tinh", "Gia nhap", "Don gia", "So luong nhap", "Hinh anh", "Trang thai"        
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fr != null)
                try {
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listThuoc;
    }

    public static List<HoaDon> docFileHoaDon() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        // khai báo một list để trả về
        List<HoaDon> listHoaDon = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(PATH_FILE_CSV_HoaDon);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            
            while ((line = csvReader.readNext()) != null){
                Date nl = df.parse(line[1]);
                Double tt = Double.parseDouble(line[2]);
                
                HoaDon hd = new HoaDon(line[0], nl, tt, line[3], line[4]);
                listHoaDon.add(hd);
                
//                  0       1             2           3           4
//                "Ma", "Ngay lap", "Tong tien", "Nhan vien", "Khach hang",
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(fr != null)
                try {
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listHoaDon;
    }

    public static List<TaiKhoan> docFileTaiKhoan() {
        // khai báo một list để trả về
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(PATH_FILE_CSV_TaiKhoan);
            CSVReader csvReader = new CSVReader(fr);
            String[] line;
            line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null){
                TaiKhoan tk = new TaiKhoan(line[0], line[1], line[2]);
                listTaiKhoan.add(tk);
//                    0           1       2
//                "Ten TK", "Ma khau", "Loai TK"
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fr != null)
                try {
                    fr.close();
            } catch (IOException ex) {
                Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listTaiKhoan;
    }

}

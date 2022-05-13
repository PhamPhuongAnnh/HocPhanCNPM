
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

//NOTE: ghi file thì ghi vào dạng String nên các kiểu dữ liệu khác phải chuyển về String nhé
public class docghiFile {

    // lấy đường dẫn  thư mục hiện tại 
    private static final String curentDir = System.getProperty("user.dir");

    // khai báo cái dấu // này để có thể đường đẫn đến nơi ghi file 
    private static final String separator = File.separator;

    // ví dụ đường dẫn đến cái khách hàng.csv là    đường dẫn đến thưc mục hiện tại+//+ data (forder data)+// (khachHang.csv)tenfile
    private static final String PATH_FILE_KhachHang = curentDir + separator + "data" + separator + "KhachHang.csv";
    private static final String PATH_FILE_CSV_NhanVien = curentDir + separator + "data" + separator + "NhanVien.csv";
    private static final String PATH_FILE_CSV_NhaCungCap = curentDir + separator + "data" + separator + "NhaCungCap.csv";
    private static final String PATH_FILE_CSV_HoaDon = curentDir + separator + "data" + separator + "HoaDon.csv";
    private static final String PATH_FILE_CSV_TaiKhoan = curentDir + separator + "data" + separator + "TaiKhoan.csv";
    private static final String PATH_FILE_CSV_TaiThuoc = curentDir + separator + "data" + separator + "Thuoc.csv";

    // hàm ghi file khách hàng với tham số truyền vào là một list khách hàng
    public void ghiFileKhachHang(List<KhachHang> listKhachHang) {
        FileWriter fw = null; // dùng để ghi file 

        // dùng để format cái ngày tháng nhập vào
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // new file truyền vào đường dẫn của file khách hàng
            File f = new File(PATH_FILE_KhachHang);

            // kiểm tra xem file có tồn tại không nếu tồn tại thì
            if (!f.exists()) {
                fw = new FileWriter(PATH_FILE_KhachHang, true); // try catch cho dòng này vì có xảy ra các ngoại lệ 

                // vì csv không có sẵn nên phải thêm thư viện của nó mới dùng được CSVWriter 
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                // mảng để lưu cái tiêu đề 
                String[] header = {"Ma KH", "Ho", "Ten", "Ngay Sinh", "Gioi Tinh", "CCCD", "SĐT", "Dia Chi"};

                // ghi vào file cái dòng đầu 
                csvWrite.writeNext(header);

                // duyệt danh sách khách hàng
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaKhachHang()), item.getHo(), item.getTen(), df.format(item.getNgaySinh()), item.getGioiTinh(), item.getCmnd(), item.getDiaChi()});
                }
            } // th file không trống (đã có dữ liệu trong file )
            else {
                fw = new FileWriter(PATH_FILE_KhachHang, true); // try catch cho dòng này vì có xảy ra các ngoại lệ 

                // vì csv không có sẵn nên phải thêm thư viện của nó mới dùng được CSVWriter 
                CSVWriter csvWrite = new CSVWriter(fw, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                // duyệt danh sách khách hàng
                for (KhachHang item : listKhachHang) {
                    csvWrite.writeNext(new String[]{String.valueOf(item.getMaKhachHang()), item.getHo(), item.getTen(), df.format(item.getNgaySinh()), item.getGioiTinh(), item.getCmnd(), item.getDiaChi()});
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
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
    
    // hàm ghi file nhan viên 
    public void ghiFileNhanVien(List<NhanVien> listNhanVien){
        
    }
    
    // hàm ghi file nhà cung cấp 
    public void ghiFileNhaCungCap(List<NhaCungCap> listNhaCungCap){
        
    }
    
    // hàm ghi file Thuốc 
    public void ghiFileThuoc(List<Thuoc> listThuoc){
        
    }
    
    // hàm ghi file hóa đơn 
    public void ghiFileHoaDon(List<HoaDon> listHoaDon){
        
    }
    
    // hàm ghi file tai khoan 
    public void ghiFileTaiKhoan(List<TaiKhoan> taiKhoan){
        
    }
    
    // hàm đọc file lấy dữ liệu
    public List<KhachHang> docFileKhachHang() throws IOException{
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
                Date ngays= df.parse(line[3]);
                
                // khai báo một kh
                KhachHang kh = new KhachHang(line[0],line[1], line[2], (java.sql.Date) ngays, line[4], line[5], line[6], line[7] );
                
                // add vào list khach hang
                listKH.add(kh);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(docghiFile.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    
    
    public List<NhanVien> docFileNhanVien(){
        // khai báo một list để trả về
        List<NhanVien> listNhanVien = new ArrayList<>(); 
        
        
        return  listNhanVien;
    }
    
    public List<NhaCungCap> docFileNhaCungCap(){
        // khai báo một list để trả về
        List<NhaCungCap> listNhaCungCap = new ArrayList<>(); 
        
        
        return  listNhaCungCap;
    }
    
    public List<Thuoc> docFileThuoc(){
        // khai báo một list để trả về
        List<Thuoc> listThuoc = new ArrayList<>(); 
        
        
        return  listThuoc;
    }
    
    public List<HoaDon> docFileHoaDon(){
        // khai báo một list để trả về
        List<HoaDon> listHoaDon = new ArrayList<>(); 
        
        
        return  listHoaDon;
    }
    
    public List<TaiKhoan> docFileTaiKhoan(){
        // khai báo một list để trả về
        List<TaiKhoan> listTaiKhoan = new ArrayList<>(); 
        
        
        return  listTaiKhoan;
    }
    
}

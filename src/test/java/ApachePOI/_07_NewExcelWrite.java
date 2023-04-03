package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class _07_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // hafızada workbook ve sheet ini oluşturucam
        XSSFWorkbook workbook=new XSSFWorkbook();  // hafızada bir workbook oluşturuldu
        XSSFSheet sheet=workbook.createSheet("Sayfa1"); // içinde sheet oluşturdum

        // Hafızada işlemlere devam ediyorum
        Row yeniSatir=sheet.createRow(0);
        Cell yeniHucre=yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba Dünya");

        // path i verip yazdırma işlemi SAVE işlemi
        String path="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("işlemler tamamlandı.");
    }
}

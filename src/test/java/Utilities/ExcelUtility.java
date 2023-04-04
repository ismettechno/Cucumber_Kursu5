package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int colCnt){
        ArrayList< ArrayList<String> > tablo=new ArrayList<>();

        Sheet sheet =null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName); // getSheet(testCitizen)  getSheetAt(0,1,2,3)
        }
        catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // zoo.length
            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < colCnt; j++) {   // zoo[i].length
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satir);
        }

        return tablo;
    }

    public static void writeExcel(String path, Scenario senaryo, String browserName) {
        // burada her bir senaryonun sonucu excel yazılacak
        File file=new File(path);
        // eğer dosya yok ise aşağıdaki bölüm çalışşsın
        if (!file.exists()){ // dosya yok ise
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("campusTest");

            Row yeniSatir = sheet.createRow(0);

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString()); // fail veya pass

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            //file save
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }
        }
        else{// eğer dosya var ise

            Sheet sheet=null;
            Workbook workbook =null;
            FileInputStream inputStream=null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet("campusTest");
            }catch(Exception e){
            }

            Row yeniSatir = sheet.createRow( sheet.getPhysicalNumberOfRows() );  // en alt boş satırı aç

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString()); // fail veya pass

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            //file save
            try {
                inputStream.close(); // okuma modu kapatıldı
                FileOutputStream outputStream = new FileOutputStream(path); // yazma moduna geçildi
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }

        }


    }



}

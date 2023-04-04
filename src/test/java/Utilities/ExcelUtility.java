package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
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

}

package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kullanıcıdan istediği kolon sayısını aldıktan sonra
 * aşağıdaki excelin 2.Sheet inden istediği kadar kolon miktarını alarak
 * bir fonksyonda ArrayListe çevirerek mainden yazdırınız.
 * src/test/java/ApachePOI/resources/ApacheExcel2.xlsx
 */
public class _09_Tasks {
    public static void main(String[] args) {
        System.out.print("İstediğiniz sütun sayısı=");
        Scanner oku=new Scanner(System.in);
        int columnCnt=oku.nextInt();

        ArrayList< ArrayList<String> > donenSonuc=getData(columnCnt);  // String[][]
        System.out.println("donenSonuc = " + donenSonuc);
    }


    public static ArrayList< ArrayList<String> > getData(int colCnt){
        ArrayList< ArrayList<String> > tablo=new ArrayList<>();

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        Sheet sheet =null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(1);
        }
        catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < colCnt; j++) {
                  satir.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satir);
        }

        return tablo;
    }




}








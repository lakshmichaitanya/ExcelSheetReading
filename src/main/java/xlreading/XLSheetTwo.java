package xlreading;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSheetTwo extends XLReadImpl {

    private File xlFile = null;

    private XLSheetTwo() {
    }

    public XLSheetTwo(File xlsfile) {
        xlFile = xlsfile;
    }

   // @Override
    void fetchAllData() {
        try {
            FileInputStream fis = new FileInputStream(xlFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator ite = sheet.rowIterator();
            int i = 0;
            System.out.println(sheet.getSheetName() + " Data is  :");
            while (ite.hasNext()) {
                Row row = (Row) ite.next();
                Iterator<Cell> cite = row.cellIterator();
                while (cite.hasNext()) {
                    Cell c = cite.next();
                    System.out.print(c.toString() + "  ");
                }
                if (i == 0) {
                    i++;
                    System.out.print("\n-------------------------------");
                }
                System.out.println();
            }

            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //@Override
    HashMap fetchDataFrom(String id) {
        HashMap dataMap = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(xlFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(1); // Get Your Sheet.
            Row firstRow = sheet.getRow(0);
            Iterator<Row> ite = sheet.rowIterator();
            while (ite.hasNext()) {
                Row row = (Row) ite.next();
                Cell cell = row.getCell(0); // Get the Cell at the Index / Colum you want.
                if (cell.toString().equalsIgnoreCase(id)) {
                    Iterator<Cell> cite = row.cellIterator();
                    int i = 0;
                    while (cite.hasNext()) {
                        dataMap.put(firstRow.getCell(i).toString(), cite.next().toString());
                        i++;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;

    }
}

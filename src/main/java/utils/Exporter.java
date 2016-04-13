package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Responsible for patients export as XLS file
 */
public class Exporter {

    private static final int AMOUNT_OF_COLUMNS = 6;
    private HSSFWorkbook workbook;

    public Exporter() {
        this.workbook = new HSSFWorkbook();
    }

    public Exporter createXlsFileFromList(ArrayList<Patient> patientList) {

        HSSFSheet sheet = workbook.createSheet("Database Export");
        for (int i = 0; i < patientList.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < AMOUNT_OF_COLUMNS; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(patientList.get(i).getEvidencialNumber());
            }
        }
        return this;
    }

    public boolean exportFile() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(new File("TestXls.xls"));
            workbook.write(fos);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

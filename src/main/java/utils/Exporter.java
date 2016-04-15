package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Responsible for patients export as XLS file
 */
public class Exporter {

    private static final String SHEET_NAME = "Database Export";
    private static final String[] HEADERS = {"Nr. ewidencyjny", "Data", "Wiek", "ASA", "Uwagi", "Technika", "Nadzór"};
    private HSSFWorkbook workbook;
    HSSFSheet sheet;

    public Exporter() {
        this.workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(SHEET_NAME);
        makeHeaderRow(sheet);
    }

    public Exporter createXlsFileFromList(ArrayList<Patient> patientList) {

        for ( int i = 0; i < patientList.size(); i++ ) {
            HSSFRow row = sheet.createRow(i);
            String[] patientDetails = patientList.get(i).getPatientInfoArray();
            for ( int j = 0; j < Patient.AMOUNT_OF_DATA; j++ ) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(patientDetails[j]);
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
        } catch ( IOException e ) {
            e.printStackTrace();
            return false;
        }
    }

    private void makeHeaderRow(HSSFSheet sheet) {
        for ( int rown = 0; rown < HEADERS.length; rown++ ) {
            HSSFRow headerRow = sheet.createRow(rown);
            headerRow.createCell(0).setCellValue(HEADERS[rown]);
        }
    }
}

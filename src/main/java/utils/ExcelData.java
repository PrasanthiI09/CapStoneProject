package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum(); // Number of rows excluding the header
            int colCount = sheet.getRow(0).getLastCellNum(); // Number of columns in the header row

            data = new Object[rowCount][colCount];
            DataFormatter formatter = new DataFormatter(); // Formatter to fetch cell value as String

            for (int i = 1; i <= rowCount; i++) { // Start from row 1 to skip the header
                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {
                    if (row != null && row.getCell(j) != null) {
                        // Use DataFormatter to get the cell value as a String without ".0"
                        data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                        //System.out.println(formatter.formatCellValue(row.getCell(j)));
                    } else {
                        data[i - 1][j] = ""; // Assign an empty string if the cell is null
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + filePath, e);
        }

        return data;
    }
}


package tutorial;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zss.model.Book;
import org.zkoss.zss.model.Exporter;
import org.zkoss.zss.model.Exporters;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Button;

public class WriteToExcel {

private static String dest = "C:\\test.xls";
private static HSSFWorkbook myWorkBook = new HSSFWorkbook();
private static HSSFSheet mySheet = myWorkBook.createSheet();

private static void excelLog(int row, int col, String value) {
    HSSFRow myRow = mySheet.getRow(row);

    if (myRow == null)
        myRow = mySheet.createRow(row);

    HSSFCell myCell = myRow.createCell(col);
    myCell.setCellValue(value);
}

public static void main(String[] args) {
    int numCol = 10; // assume 10 cols
    Spreadsheet spreadsheet=null;
    Button exportBtn;
    Book wb = spreadsheet.getBook();
    Exporter c = Exporters.getExporter("excel");
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    c.export(wb, baos);
    Filedownload.save(baos.toByteArray(), "application/file",
                    wb.getBookName());
    
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < numCol; j++) {
            excelLog(i, j, "Row : " + i + ", Cell : " + j);
        }
    }

    try {
        FileOutputStream out = new FileOutputStream(dest);
        myWorkBook.write(out);
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
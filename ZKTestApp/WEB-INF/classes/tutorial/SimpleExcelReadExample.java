package tutorial;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class SimpleExcelReadExample {
	static Connection con1 = null;
	static Connection con3 = null;
	static PreparedStatement preparedstatement = null;
	static ResultSet resultset = null;
	int j = 0;

	public static void main(String[] args) {
		SimpleExcelReadExample ex= new SimpleExcelReadExample();
		String fileName = "C://test.xls";
		//Cleartables.table_daily_report();
		 ex.read(fileName);
	
	}

	public void read(String fileName) {
		
		int i=0 ,j=0;
		try {
			Class.forName ("org.postgresql.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres",
                        "root");
            PreparedStatement sql_statement = null;
            String jdbc_insert_sql = "INSERT INTO ssinformation values(?,?,?,?)";
            sql_statement = conn.prepareStatement(jdbc_insert_sql);
            
			FileInputStream myInput = new FileInputStream(fileName);
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
			HSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				i++;
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				j=0;
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					System.out.println("Row :[ "+ myRow.getRowNum()+"],Column:["+ myCell.getCellType()+ "] Value:"+myCell);
					sql_statement.setInt(1, i);
					sql_statement.setInt(2, myRow.getRowNum());
					sql_statement.setInt(3, myCell.getCellType());
					sql_statement.setString(4, myCell.toString());
					 sql_statement.executeUpdate();	
				}
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
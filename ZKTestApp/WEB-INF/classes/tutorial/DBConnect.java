package tutorial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.zkoss.poi.xssf.usermodel.XSSFCell;
import org.zkoss.poi.xssf.usermodel.XSSFRow;
import org.zkoss.poi.xssf.usermodel.XSSFSheet;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zss.app.zul.ctrl.DesktopWorkbenchContext;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class DBConnect extends SelectorComposer<Window> {

	/**
	 * @throws Exception
	 */

	@Listen("onClick=button#saveDb")
	public void saveDb() throws Exception {
		System.out.println("DB Process Started.....");
		Messagebox.show("Success");
		Connection conn = null;
		PreparedStatement sql_statement = null;
		InputStream path = DBConnect.class
				.getResourceAsStream("filename.properties");
		Properties prop = new Properties();
		prop.load(path);
		String driver = prop.getProperty("driver");
		System.out.println("Driver" + driver);

		int i = 0, j = 0;
		try {

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/openbravo1", "postgres",
					"root");
			FileInputStream myInput = new FileInputStream(
					"D:/Tomcat/webapps/ZKTestApp/xls/CostBreakup_LUCKNOW.xlsx");
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);

			for (i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
				XSSFSheet mySheet = myWorkBook.getSheetAt(i);
				System.out.println("Sheet Name"+mySheet.getSheetName());
				String jdbc_insert_sql = "INSERT INTO ssinformation values(?,?,?,?)";
				sql_statement = conn.prepareStatement(jdbc_insert_sql);
				Iterator rowIter = mySheet.rowIterator();
				while (rowIter.hasNext()) {
					XSSFRow myRow = (XSSFRow) rowIter.next();
					Iterator cellIter = myRow.cellIterator();
					Vector cellStoreVector = new Vector();

					while (cellIter.hasNext()) {
						XSSFCell myCell = (XSSFCell) cellIter.next();

						// System.out.println("Row :[ "+
						// myRow.getRowNum()+"],Column:["+ myCell.getCellNum()+
						// "] Value:"+myCell);
						sql_statement.setString(1,mySheet.getSheetName());
						sql_statement.setInt(2, myRow.getRowNum());
						sql_statement.setInt(3, myCell.getColumnIndex());
						sql_statement.setString(4, myCell.toString());
						sql_statement.executeUpdate();
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();

		}
	}

	/*
	 * @Listen("onClick=button#saveDb") public void saveDb() throws Exception {
	 * System.out.println("DB Process Started.....");
	 * Messagebox.show("Success"); Connection conn=null; PreparedStatement
	 * sql_statement = null; InputStream path =
	 * DBConnect.class.getResourceAsStream("filename.properties"); Properties
	 * prop = new Properties(); prop.load(path); String
	 * driver=prop.getProperty("driver"); System.out.println("Driver"+driver);
	 * 
	 * int i = 0, j = 0; try {
	 * 
	 * Class.forName("org.postgresql.Driver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:postgresql://localhost:5432/openbravo1","postgres","root");
	 * FileInputStream myInput = new
	 * FileInputStream("D:/Tomcat/webapps/ZKTestApp/xls/CostBreakup_LUCKNOW.xlsx"
	 * ); XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput); XSSFSheet mySheet
	 * = myWorkBook.getSheetAt(0); XSSFRow myrow = mySheet.getRow(2); XSSFCell
	 * mycell = myrow.getCell(3); System.out.println("Row Info ::"+
	 * mycell.getStringCellValue().toString()); String CorderId =
	 * "select c_project_id from c_project where name='"+ mycell + "'";
	 * Statement sql_deleteall = null; Statement getrowID = null; Statement
	 * statement = null; statement = conn.createStatement(); sql_deleteall =
	 * conn.createStatement(); getrowID = conn.createStatement(); ResultSet rs =
	 * statement.executeQuery(CorderId); rs.next();
	 * System.out.println("order id" + rs.getString(1));
	 * System.out.println("project order id" + CorderId); String deleteall =
	 * "delete from dtzk_ssinformation where dtzk_ssinformation_id='" +
	 * rs.getString(1) + "'"; sql_deleteall.executeUpdate(deleteall); String
	 * jdbc_insert_sql = "INSERT INTO dtzk_ssinformation values(?,?,?,?)";
	 * sql_statement = conn.prepareStatement(jdbc_insert_sql); Iterator rowIter
	 * = mySheet.rowIterator(); while (rowIter.hasNext()) { XSSFRow myRow =
	 * (XSSFRow) rowIter.next();
	 * 
	 * i++; sql_statement.setString(1, rs.getString(1)); Iterator cellIter =
	 * myRow.cellIterator(); Vector cellStoreVector = new Vector(); j = 0; while
	 * (cellIter.hasNext()) { XSSFCell myCell = (XSSFCell) cellIter.next(); //
	 * System.out.println("Row :[ "+ // myRow.getRowNum()+"],Column:["+
	 * myCell.getCellNum()+ // "] Value:"+myCell);
	 * 
	 * sql_statement.setInt(2, myRow.getRowNum()); sql_statement.setInt(3,
	 * myCell.getColumnIndex()); sql_statement.setString(4, myCell.toString());
	 * sql_statement.executeUpdate(); }
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally{ if(conn!=null)
	 * conn.close();
	 * 
	 * } }
	 */

}
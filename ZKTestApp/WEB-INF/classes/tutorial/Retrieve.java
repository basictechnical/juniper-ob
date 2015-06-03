package tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.zkoss.poi.hpsf.HPSFException;
import org.zkoss.poi.xssf.usermodel.XSSFCell;
import org.zkoss.poi.xssf.usermodel.XSSFRow;
import org.zkoss.poi.xssf.usermodel.XSSFSheet;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.zkoss.zss.app.zul.ctrl.DesktopWorkbenchContext;
import org.zkoss.zss.app.zul.ctrl.WorkbookCtrl;

public class Retrieve extends SelectorComposer<Window> {

	/*
	 * @Listen("onClick=button#retrieve") public void retrieve() throws
	 * IOException, InvalidFormatException {
	 * 
	 * File file123 = new File( "D:/Tomcat/webapps/ZKTestApp/xls/empty.xls");
	 * 
	 * Messagebox.show("Refresh your browser to see the changes");
	 * FileInputStream myInput = new FileInputStream(
	 * "D:/Tomcat/webapps/ZKTestApp/xls/empty.xls");
	 * System.out.println("test....");
	 * 
	 * POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput); XSSFWorkbook
	 * myWorkBook = new XSSFWorkbook(myInput); XSSFSheet mySheet =
	 * myWorkBook.getSheetAt(0); XSSFRow myrow = mySheet.getRow(2); XSSFCell
	 * mycell = myrow.getCell(3);
	 * System.out.println("project name Info ::"+mycell
	 * .getStringCellValue().toString());
	 * 
	 * 
	 * String Currentprojectid =
	 * "select dtzk_ssinformation_id from dtzk_ssinformation where rowid='2' and columnid='3' and data='"
	 * +mycell.getStringCellValue().toString()+"'";
	 * System.out.println("current project id" + Currentprojectid); String
	 * jdbc_insert_sql = "select *  from dtzk_ssinformation"; try {
	 * Class.forName("org.postgresql.Driver"); Connection conn =
	 * DriverManager.getConnection(
	 * "jdbc:postgresql://localhost:5432/openbravo1", "postgres", "root");
	 * Statement statement = null; statement = conn.createStatement(); ResultSet
	 * rs = statement.executeQuery(jdbc_insert_sql); exportToExcel(rs, file123);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	/*
	 * @Listen("onClick=button#retrieve") public void saveAndRetrieve() throws
	 * IOException, SQLException, ClassNotFoundException {
	 * 
	 * Class.forName("org.postgresql.Driver"); Connection conn =
	 * DriverManager.getConnection(
	 * "jdbc:postgresql://localhost:5432/openbravo1", "postgres", "root");
	 * Statement sql_statement = null; File file123 = new
	 * File("D:/Tomcat/webapps/ZKTestApp/xls/empty.xlsx");
	 * 
	 * Messagebox.show("Refresh your browser to see the changes");
	 * FileInputStream myInput = new FileInputStream(
	 * "D:/Tomcat/webapps/ZKTestApp/xls/Cost_Breakup_HAMPI.xlsx");
	 * POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput); XSSFWorkbook
	 * myWorkBook = new XSSFWorkbook(myInput); XSSFSheet mySheet =
	 * myWorkBook.getSheetAt(0);
	 * System.out.println("NO.of cell styles"+myWorkBook.getNumCellStyles());
	 * XSSFRow myrow = mySheet.getRow(2); XSSFCell mycell = myrow.getCell(3);
	 * String project_name= mycell.getStringCellValue().toString(); String
	 * Currentprojectid =
	 * "select dtzk_ssinformation_id from dtzk_ssinformation where  data='HAMPI'"
	 * ; sql_statement=conn.createStatement(); ResultSet
	 * rs=sql_statement.executeQuery(Currentprojectid); rs.next();
	 * System.out.println("project name at that cell"+project_name);
	 * System.out.println("current project id" + Currentprojectid);
	 * 
	 * 
	 * String jdbc_insert_sql =
	 * "select *  from dtzk_ssinformation where dtzk_ssinformation_id='"
	 * +rs.getString(1)+"'";
	 * System.out.println("Insert SQL : :: :"+jdbc_insert_sql); try {
	 * Class.forName("org.postgresql.Driver"); Connection conn1 =
	 * DriverManager.getConnection(
	 * "jdbc:postgresql://localhost:5432/openbravo1", "postgres", "root");
	 * Statement statement = null; statement = conn.createStatement(); ResultSet
	 * rst = statement.executeQuery(jdbc_insert_sql); exportToExcel(rst,
	 * file123);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	@Listen("onClick=button#retrieve")
	public void saveAndRetrieve() throws Exception {
		
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/openbravo1", "postgres","root");
		ResultSet rs_sheetname = null;
		Statement sql_statement = null;
		String get_sheets="select distinct sheetname from ssinformation";
		System.out.println("get sheets sql"+get_sheets);
		sql_statement=conn.createStatement();
		rs_sheetname=sql_statement.executeQuery(get_sheets);
		String output_file = "D:/Tomcat/webapps/ZKTestApp/xls/empty.xlsx";
	
		ArrayList al= new ArrayList(); 		
			
		while(rs_sheetname.next()){
			
			al.add(rs_sheetname.getString(1));
			String jdbc_insert_sql = "select *  from ssinformation where sheetname='"+ 	rs_sheetname.getString(1)+"' order by sheetname,rowid  ";
			
			System.out.println("Insert SQL : :: :" + jdbc_insert_sql);
			try {
				Class.forName("org.postgresql.Driver");
				Connection conn1 = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/openbravo1", "postgres",
					"root");
				Statement statement = null;
				statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(jdbc_insert_sql);
				exportToExcel(rs, output_file,al,rs_sheetname.getString(1));

			} catch (Exception e) {

			e.printStackTrace();
			}
		}
		
		Messagebox.show("retrieved");

	}

	public static void exportToExcel(ResultSet rs, String outputFile,ArrayList al,String sheetname)
			throws HPSFException, Exception {
		int prev = 0, curr = 0;
		XSSFSheet sheet=null;
		XSSFRow row =null;
		XSSFCell cell = null;
		String str=null;
		FileInputStream myInput = new FileInputStream(new File(outputFile));
		XSSFWorkbook hwb = new XSSFWorkbook(myInput);
		if(al.size()==hwb.getNumberOfSheets()){
			System.out.println("In IF....!");
			sheet=hwb.createSheet(sheetname);
			row =sheet.createRow(0);
			while (rs.next()) {
				curr=rs.getInt(2);
				System.out.println(rs.getInt(2) + "," + rs.getInt(3) + ","+ rs.getString(4));
				if(prev!=curr){
					row = sheet.createRow(rs.getInt(2));
					prev=rs.getInt(2);
				}
				row.createCell(rs.getInt(3)).setCellValue(rs.getString(4));
			}
		try {
			FileOutputStream fileOut = new FileOutputStream(outputFile);
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");
						
		} catch (Exception ex) {
			System.out.println(ex);
			}
		
		}
		else{
			System.out.println("IN ElSe");
			System.out.println("Sheet Names...!"+sheetname);
				sheet=hwb.getSheet(sheetname);
				row =sheet.createRow(0);
				while (rs.next()) {
					curr=rs.getInt(2);
					System.out.println(rs.getInt(2) + "," + rs.getInt(3) + ","+ rs.getString(4));
					if(prev!=curr){
						row = sheet.createRow(rs.getInt(2));
						prev=rs.getInt(2);
					}
					row.createCell(rs.getInt(3)).setCellValue(rs.getString(4));
				}
				try {
					FileOutputStream fileOut = new FileOutputStream(outputFile);
					hwb.write(fileOut);
					fileOut.close();
					System.out.println("Your excel file has been generated!");
					hwb.removeSheetAt(0);
				} catch (Exception ex) {
					System.out.println(ex);
				}
				
			}
	
	}
}
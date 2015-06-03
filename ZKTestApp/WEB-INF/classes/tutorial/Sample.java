package tutorial;

import org.zkoss.poi.ss.usermodel.Sheet;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Window;
import org.zkoss.zul.Messagebox;


public class Sample extends SelectorComposer<Window>{

	@Listen("onClick=button#submit")
	public void submit() throws Exception{ 
		
		Messagebox.show("saved");
				
		/*
		File file123 = new File("D:/Tomcat/webapps/ZKTestApp/WEB-INF/xls/Book.xls");

		String jdbc_insert_sql = "select *  from ssinformation order by rowid";
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:postgresql://127.0.0.1:5432/test",
							"postgres", "root");
			Statement statement = null;
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(jdbc_insert_sql);
			exportToExcel(rs, file123);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void exportToExcel(ResultSet rs, File outputFile)
			throws HPSFException, Exception {
		int prev = 0, curr = 0;
		Set<Integer> set=new TreeSet<Integer>();
		FileInputStream myInput = new FileInputStream(outputFile);
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet("new sheet");
		HSSFRow row = sheet.createRow(0);
		HSSFRow row1;
		while (rs.next()) {
			curr = rs.getInt(2);
			System.out.println(rs.getInt(2) + "," + rs.getInt(3) + ","
					+ rs.getString(4));
			if (prev != curr) {
				row = sheet.createRow(curr);
				prev = rs.getInt(2);
				
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

		}*/

	}

}
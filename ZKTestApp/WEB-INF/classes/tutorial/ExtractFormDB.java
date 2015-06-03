package tutorial;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExtractFormDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ExtractFormDB db= new ExtractFormDB();
		db.showInfo();
		// TODO Auto-
		}
	public void showInfo() throws Exception{
		FileOutputStream fout= new FileOutputStream("C://test.xls") ;
		String jdbc_insert_sql = "select *  from ssinformation";
		Class.forName ("org.postgresql.Driver"); 
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres",
                    "root");
        Statement statement = null;
        statement = conn.createStatement();        
        ResultSet rs= statement.executeQuery(jdbc_insert_sql);
        
               
        while(rs.next()){
        	System.out.println(rs.getInt(1)+rs.getInt(2)+rs.getInt(3)+rs.getString(4));
        }
        
        	
	}

}

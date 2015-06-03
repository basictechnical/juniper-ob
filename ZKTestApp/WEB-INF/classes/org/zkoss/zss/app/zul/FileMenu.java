
package org.zkoss.zss.app.zul;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Vector;

import org.zkoss.poi.ss.usermodel.DateUtil;
import org.zkoss.poi.ss.usermodel.Row;
import org.zkoss.poi.xssf.usermodel.XSSFCell;
import org.zkoss.poi.xssf.usermodel.XSSFFont;
import org.zkoss.poi.xssf.usermodel.XSSFRow;
import org.zkoss.poi.xssf.usermodel.XSSFSheet;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zss.app.Consts;
import org.zkoss.zss.app.file.FileHelper;
import org.zkoss.zss.app.zul.ctrl.DesktopWorkbenchContext;
import org.zkoss.zss.app.zul.ctrl.WorkbookCtrl;
import org.zkoss.zss.app.zul.ctrl.WorkspaceContext;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Messagebox;
import tutorial.MyProperties;

/**
 * 
 * @author sam
 * 
 */
public class FileMenu extends Menu implements IdSpace {

	private Menupopup fileMenupopup;
	private Menuitem newFile;
	private Menuitem openFile;

	private Menuitem saveFile;
	private Menuitem saveFileAndClose;
	// TODO: permission control
	private Menuitem deleteFile;
	private Menuitem importFile;
	private Menuitem exportPdf;
	private boolean _exportToPdfDisabled; /* default false */

	private Menuitem exportHtml;
	private boolean _exportToHtmlDisabled; /* default false */

	private Menuitem exportExcel;
	private boolean _exportToExcelDisabled;
	public String myfile_name = null;

	// TODO: handle exception

	public FileMenu() throws IOException {

		Executions.createComponents(Consts._FileMenu_zul, this, null);
		Components.wireVariables(this, this, '$', true, true);
		Components.addForwards(this, this, '$');

		importFile.setDisabled(!FileHelper.hasImportPermission());

		boolean saveDisabled = !FileHelper.hasSavePermission();
		saveFile.setDisabled(saveDisabled);
		saveFileAndClose.setDisabled(saveDisabled);
	}

	public void setSaveFileDisabled(boolean disabled) {
		saveFile.setDisabled(true);
	}

	public void setSaveFileAndCloseDisabled(boolean disabled) {
		saveFileAndClose.setDisabled(disabled);
	}

	public void setDeleteFileDisabled(boolean disabled) {
		deleteFile.setDisabled(disabled);
	}

	public void setExportPdfDisabled(boolean disabled) {
		_exportToPdfDisabled = disabled;
		exportPdf.setDisabled(disabled);
	}

	public void setExportHtmlDisabled(boolean disabled) {
		_exportToHtmlDisabled = disabled;
		exportHtml.setDisabled(disabled);
	}

	public void setExportExcelDisabled(boolean disabled) {
		_exportToExcelDisabled = disabled;
		exportExcel.setDisabled(disabled);
	}

	public void onClick$newFile() {
		getDesktopWorkbenchContext().getWorkbookCtrl().newBook();
		getDesktopWorkbenchContext().fireWorkbookChanged();
	}

	public void onClick$openFile() {
		getDesktopWorkbenchContext().getWorkbenchCtrl().openOpenFileDialog();
	}

	public void onClick$saveFileAs() {
		throw new UiException("save is not implement yet");
	}

	public void onClick$saveFileAndClose() {
		// TODO: refactor duplicate save logic
		DesktopWorkbenchContext workbench = getDesktopWorkbenchContext();
		if (workbench.getWorkbookCtrl().hasFileExtentionName()) {
			workbench.getWorkbookCtrl().save();
			workbench.getWorkbookCtrl().close();
			workbench.fireWorkbookSaved();
			workbench.fireWorkbookChanged();
		} else
			workbench.getWorkbenchCtrl().openSaveFileDialog();
	}

	public void onClick$deleteFile() {
		DesktopWorkbenchContext workbench = getDesktopWorkbenchContext();
		if (!workbench.getWorkbookCtrl().hasFileExtentionName()) {
			workbench.getWorkbookCtrl().close();
			workbench.fireWorkbookChanged();
			return;
		}

		WorkspaceContext.getInstance(Executions.getCurrent().getDesktop()).delete(workbench.getWorkbookCtrl().getSrc());
		workbench.getWorkbookCtrl().close();
		workbench.fireWorkbookChanged();
	}

	public void onClick$importFile() {
		getDesktopWorkbenchContext().getWorkbenchCtrl().openImportFileDialog();
	}

	public void onClick$exportPdf() {
		getDesktopWorkbenchContext().getWorkbenchCtrl().openExportPdfDialog(null);
	}

	public void onClick$exportHtml() {
		getDesktopWorkbenchContext().getWorkbenchCtrl().openExportHtmlDialog(null);
	}

	public void onClick$exportExcel() {
		WorkbookCtrl bookCtrl = getDesktopWorkbenchContext().getWorkbookCtrl();
		ByteArrayOutputStream out = bookCtrl.exportToExcel();
		System.out.println(" onClick$exportExcel method calling...."+bookCtrl.exportToExcel());
		Filedownload.save(out.toByteArray(), "application/file", bookCtrl.getBookName());
	}

	public void onClick$fileReversion() {
		throw new UiException("reversion not implement yet");
	}

	public void onClick$print() {
		throw new UiException("print not implement yet");
	}

	public void onOpen$fileMenupopup() {
		getDesktopWorkbenchContext().getWorkbookCtrl().reGainFocus();
	}

	protected DesktopWorkbenchContext getDesktopWorkbenchContext() {
		return Zssapp.getDesktopWorkbenchContext(this);
	}

	/*
	 * public void onCreate() { final DesktopWorkbenchContext workbenchCtrl =
	 * getDesktopWorkbenchContext();
	 * getDesktopWorkbenchContext().addEventListener(
	 * Consts.ON_WORKBOOK_CHANGED, new EventListener() { public void
	 * onEvent(Event event) throws Exception { boolean isOpen =
	 * workbenchCtrl.getWorkbookCtrl() .hasBook(); boolean savePermission =
	 * FileHelper.hasSavePermission();
	 * 
	 * if (isOpen) { boolean isPE = WebApps.getFeature("pe");
	 * deleteFile.setDisabled(false); exportPdf.setDisabled(_exportToPdfDisabled
	 * | !isPE | false); exportHtml.setDisabled(_exportToHtmlDisabled | !isPE |
	 * false); exportExcel.setDisabled(_exportToExcelDisabled | !isPE | false);
	 * saveFile.setDisabled(!savePermission);
	 * saveFileAndClose.setDisabled(!savePermission); } else {
	 * deleteFile.setDisabled(true); exportPdf.setDisabled(true);
	 * exportHtml.setDisabled(true); exportExcel.setDisabled(true);
	 * saveFile.setDisabled(true); saveFileAndClose.setDisabled(true); } } }); }
	 */

	public void onClick$saveFile() {
		// TODO: refactor duplicate save logic
		DesktopWorkbenchContext workbench = getDesktopWorkbenchContext();
		if (workbench.getWorkbookCtrl().hasFileExtentionName()) {
			workbench.getWorkbookCtrl().save();
			workbench.fireWorkbookSaved();
		} else
			workbench.getWorkbenchCtrl().openSaveFileDialog();
	}

	public void onClick$saveDb() throws Exception, NullPointerException {

		System.out.println("DB Process Started.....");

		DesktopWorkbenchContext workbench = getDesktopWorkbenchContext();
		String myfile_name = workbench.getWorkbookCtrl().getBookName();

		System.out.println("MyFile Name" + myfile_name);
		MyProperties prop = new MyProperties();
		String driver = prop.driver;
		String url = prop.url;
		String username = prop.username;
		String password = prop.password;
		String myInput_file = prop.myInput.concat(myfile_name);

		Connection conn = null;
		PreparedStatement sql_statement = null;
		String CorderId = null;
		String projectid = null;
		Statement sql_deleteall = null;
		Statement firstLevelBudget = null;
		Statement secondLevelBudget = null;
		Statement thirdLevelBudget = null;
		Statement fourthLevelBudget = null;
		Statement getrowID = null;
		Statement statement = null;
		Statement sqlstatement = null;
		ResultSet rs = null;
		System.out.println("MyFile Name" + myInput_file);

		
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			FileInputStream myInput = new FileInputStream(myInput_file);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			
			XSSFRow myrow = mySheet.getRow(2);
			XSSFCell mycell = myrow.getCell(3);
			String row_info = mycell.getStringCellValue().toString();
			System.out.println("Row Info ::" + row_info);
			CorderId = "select c_project_id from c_project where name='" + mycell.getStringCellValue().toString() + "'";
			statement = conn.createStatement();
			sql_deleteall = conn.createStatement();
			getrowID = conn.createStatement();
			rs = statement.executeQuery(CorderId);
			rs.next();
			System.out.println("order id" + rs.getString(1));
			projectid = rs.getString(1);
			System.out.println("project order id" + CorderId);
			String deleteall = "delete from dtzk_ssinformation where dtzk_ssinformation_id='" + rs.getString(1) + "'";
			sql_deleteall.executeUpdate(deleteall);
			firstLevelBudget = conn.createStatement();
			secondLevelBudget = conn.createStatement();
			thirdLevelBudget = conn.createStatement();
			fourthLevelBudget = conn.createStatement();
            String deleteFirstLevelBudget = "delete from epb_firstlevelbudget where c_project_id = '" + rs.getString(1) + "'";
            String deleteSecondLevelBudget = "delete from epb_secondlevelbudget where c_project_id = '" + rs.getString(1) + "'";
            String deleteThirdLevelBudget = "delete from epb_thirdlevelbudget where c_project_id = '" + rs.getString(1) + "'";
            String deleteFourthLevelBudget = "delete from epb_fourthlevelbgt where c_project_id = '" + rs.getString(1) + "'";
            firstLevelBudget.executeUpdate(deleteFirstLevelBudget);
            secondLevelBudget.executeUpdate(deleteSecondLevelBudget);
            thirdLevelBudget.executeUpdate(deleteThirdLevelBudget);
            fourthLevelBudget.executeUpdate(deleteFourthLevelBudget);
			String jdbc_insert_sql = "INSERT INTO dtzk_ssinformation values(?,?,?,?)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			Iterator rowIter = mySheet.rowIterator();
			String strItemCode =null;
			String target_amt = null;
			String changeCostSqft = null;
			String changeWorkDone = null;
			long potentialAmount = 0L;
			long uncommitedCost = 0l;
			long forecastAmount = 0L;
			long originalVal = 0L ;
			long originalSqftVal = 0L ;
			long originalWorkDoneVal = 0L ;
			Double dvalue = 0.0000;
			String strtarget_amt = null;
			String costSqft = null;
			String workDone = null;
			String originalPotential = null;
			String originalUnCommitted = null;
			String originalForecast = null;
			DecimalFormat formatter = new DecimalFormat("##0.00###");
			
			while (rowIter.hasNext()== true) {
				
                System.out.println("Row Loop Started....");
				XSSFRow myRow = (XSSFRow) rowIter.next();
				
				boolean emptyRow = isRowEmpty(myRow);
			//	System.out.println("emprtyRow "+emptyRow);
				if(emptyRow == false){
				//System.out.println("row not null");	
				sql_statement.setString(1, rs.getString(1));
				Iterator cellIter = myRow.cellIterator();
				/*Vector cellStoreVector = new Vector();*/
				
				while (cellIter.hasNext()!= false) {
					
					System.out.println("Cell Iterator Loop Started.....");
					XSSFCell myCell = (XSSFCell) cellIter.next();
					sql_statement.setInt(2, myRow.getRowNum());
					sql_statement.setInt(3, myCell.getColumnIndex());
					//sql_statement.setString(4, myCell.toString());
					System.out.println("ID :"+rs.getString(1)+"  Row Number : "+myRow.getRowNum()+"   Column Number :"+myCell.getColumnIndex()+"  Value :"+myCell.toString()+"\n");
					//sql_statement.executeUpdate();
					
					if (myCell.getColumnIndex() ==0 && myRow.getRowNum() >= 17) {
						//if(!(myCell.toString().isEmpty())){
						strItemCode=myCell.toString();
						System.out.println("strItemCode :"+strItemCode);
						//}
						sql_statement.setString(4, myCell.toString());
						sql_statement.executeUpdate();
					}else if (myCell.getColumnIndex() ==3 && myRow.getRowNum() >= 17){
						//if(!(myCell.toString().isEmpty())){
						   // target_amt=String.valueOf(myCell.getRawValue());//myCell.getNumericCellValue();
						System.out.println("myCell 3:"+myCell.toString());	
						strtarget_amt = myCell.toString();
							Double d = new Double(strtarget_amt);
							double dd = d.doubleValue();
							
							System.out.println("formated value :"+formatter.format(dd)); 
							target_amt = formatter.format(dd);
							//dvalue = formatter.format(dd);
							//System.out.println("dvalue :"+dvalue);
							BigDecimal bd = new BigDecimal(target_amt);
							originalVal = bd.longValue();
						System.out.println("target_amt :"+target_amt+"originalVal :"+originalVal);
						//}
						sql_statement.setString(4, target_amt);
						sql_statement.executeUpdate();
						//sqlstatement.executeQuery("select dtzk_dataimport('" + projectid + "','"+strItemCode+"','"+target_amt+"') from dual");
					}
					//new change here
					
					else if (myCell.getColumnIndex() ==4 && myRow.getRowNum() >= 17){
						
							System.out.println("my cell 4 :"+myCell.toString());
							costSqft = myCell.getRawValue();
							Double d = new Double(costSqft);
							double dd = d.doubleValue();
							
							System.out.println("formated value :"+formatter.format(dd)); 
							changeCostSqft = formatter.format(dd);
							//dvalue = formatter.format(dd);
							//System.out.println("dvalue :"+dvalue);
							BigDecimal bd = new BigDecimal(changeCostSqft);
							originalSqftVal = bd.longValue();
						System.out.println("changeCostSqft :"+changeCostSqft+"originalSqftVal :"+originalSqftVal);
						//}
					sql_statement.setString(4, changeCostSqft);
						sql_statement.executeUpdate();
							
						//sqlstatement.executeQuery("select dtzk_dataimport('" + projectid + "','"+strItemCode+"','"+target_amt+"') from dual");
					}
					//change complete
					else if (myCell.getColumnIndex() ==9 && myRow.getRowNum() >= 17){
						//if(!(myCell.toString().isEmpty()) ){//&& !(myCell.toString().equals("0.00")) &&  !(myCell.toString().equals("0.0"))){
							//System.out.println("potentialAmount :");	
						//potentialAmount = String.valueOf(myCell.getNumericCellValue());
						String strPotential = myCell.toString();
						Double d = new Double(strPotential);
						double dd = d.doubleValue();
						originalPotential = formatter.format(dd);
						BigDecimal bd = new BigDecimal(strPotential);
						potentialAmount = bd.longValue();
						//potentialAmount = myCell.toString();
						System.out.println("potentialAmount :"+potentialAmount+"originalPotential :"+originalPotential);
						//}
						sql_statement.setString(4, originalPotential);
						sql_statement.executeUpdate();
					}else if (myCell.getColumnIndex() ==10 && myRow.getRowNum() >= 17){
						//if(!(myCell.toString().isEmpty())){// && !(myCell.toString().equals("0.00")) && !(myCell.toString().equals("0.0"))){
							//System.out.println("uncommitedCost :");	
						//uncommitedCost = String.valueOf(myCell.getNumericCellValue());
						String strUnCommited = myCell.toString();
						Double d = new Double(strUnCommited);
						double dd = d.doubleValue();
						originalUnCommitted = formatter.format(dd);
						BigDecimal bd = new BigDecimal(strUnCommited);
						uncommitedCost = bd.longValue();
						//uncommitedCost = myCell.toString();
						System.out.println("uncommitedCost :"+uncommitedCost+"originalUnCommitted"+originalUnCommitted);
						//}
						sql_statement.setString(4, formatter.format(dd));
						sql_statement.executeUpdate();
					}else if (myCell.getColumnIndex() ==12 && myRow.getRowNum() >= 17){
						
					//change completeelse if (myCell.getColumnIndex() ==12 && myRow.getRowNum() >= 17){
						//if(!(myCell.toString().isEmpty())){// && !(myCell.toString().equals("0.00")) && !(myCell.toString().equals("0.0"))){
							//System.out.println("forecastAmount :");	
						//forecastAmount = String.valueOf(myCell.getNumericCellValue());
						//forecastAmount = myCell.toString();
						String strForeCast = myCell.toString();
						Double d = new Double(strForeCast);
						double dd = d.doubleValue();
						originalForecast = formatter.format(dd);
						BigDecimal bd = new BigDecimal(strForeCast);
						forecastAmount = bd.longValue();
						System.out.println("forecastAmount :"+forecastAmount+"originalForecast"+originalForecast);
						//}
						sql_statement.setString(4, originalForecast);
						sql_statement.executeUpdate();
						//sqlstatement.executeQuery("select dtzk_dataimportbudgetamt('" + projectid + "','"+strItemCode+"','"+target_amt+"','"+originalPotential+"','"+originalUnCommitted+"','"+originalForecast+"') from dual");
					}//new change here
					
					else if (myCell.getColumnIndex() ==13 && myRow.getRowNum() >= 17){
						
							System.out.println("my cell 13 :"+myCell.toString());
							workDone = myCell.getRawValue();
							Double d = new Double(workDone);
							double dd = d.doubleValue();
							
							System.out.println("formated value :"+formatter.format(dd)); 
							changeWorkDone = formatter.format(dd);
							//dvalue = formatter.format(dd);
							//System.out.println("dvalue :"+dvalue);
							BigDecimal bd = new BigDecimal(changeWorkDone);
							originalWorkDoneVal = bd.longValue();
						System.out.println("changeWorkDone :"+changeWorkDone+"originalWorkDoneVal :"+originalWorkDoneVal);
						//}
					sql_statement.setString(4, changeWorkDone);
						sql_statement.executeUpdate();
					sqlstatement.executeQuery("select dtzk_dataimportbudgetamt('" + projectid + "','"+strItemCode+"','"+target_amt+"','"+originalPotential+"','"+originalUnCommitted+"','"+originalForecast+"','"+changeCostSqft+"','"+changeWorkDone+"') from dual");
	
					}
						else {
							System.out.println("Test Value :"+myCell.toString());
						sql_statement.setString(4, myCell.toString());
						sql_statement.executeUpdate();

					}
				}
			//	System.out.println("strItemCode"+strItemCode+"target_amt"+target_amt+"potentialAmount"+originalPotential+"uncommitedCost"+originalUnCommitted+"forecastAmount"+originalForecast+"changeCostSqft"+changeCostSqft);
				System.out.println("Let this print" + projectid);
				sqlstatement = conn.createStatement();

				
				//sqlstatement.executeQuery("select dtzk_dataimport('" + projectid + "','"+strItemCode+"','"+target_amt+"') from dual");

			}
			}
			
			Messagebox.show("Imported Successfully");
		} catch (NullPointerException e) {
		
			Messagebox.show("NO Such Project exists in ERP");
			e.printStackTrace();
		} finally {
			rs.close();
			statement.close();
			sql_deleteall.close();
			firstLevelBudget.close();
			secondLevelBudget.close();
			thirdLevelBudget.close();
			fourthLevelBudget.close();
			sql_statement.close();
			
			conn.close();
		}

	}
	private boolean isRowEmpty(XSSFRow row) {
		//System.out.println("isRowEmpty method calling");
	    for (int c = row.getFirstCellNum(); c <= 20; c++) {
	        XSSFCell cell = (XSSFCell) row.getCell(c);
	        if (cell != null && cell.getCellType() != XSSFCell.CELL_TYPE_BLANK)
	            return false;
	     }
	    return true;
	}

	public static void exportToExcel(ResultSet rs, File outputFile) throws Exception {
		int prev = 0, curr = 0;
		FileInputStream myInput = new FileInputStream(outputFile);
System.out.println("exportToExcel :"+outputFile);
		XSSFWorkbook hwb = new XSSFWorkbook();
		XSSFSheet sheet = hwb.createSheet("new sheet");
		XSSFRow row = sheet.createRow(0);

		while (rs.next()) {
			curr = rs.getInt(2);
			/*
			 * System.out.println(rs.getInt(2) + "," + rs.getInt(3) + "," +
			 * rs.getString(4));
			 */
			if (prev != curr) {
				row = sheet.createRow(rs.getInt(2));
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

		}

	}

	public void onClick$master() throws Exception {

		MyProperties prop = new MyProperties();
		String driver = prop.driver;
		String url = prop.url;
		String username = prop.username;
		String password = prop.password;
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement sql_statement = null;
		sql_statement = conn.createStatement();

		System.out.println("Lets this print");

		sql_statement.executeQuery("select dtzk_dataimport() from dual");

	}

	
	//new code for retrieve data
	
	public void onClick$selectedProjectData() throws Exception, NullPointerException {

		System.out.println("selectedProjectData Process Started.....");
		DesktopWorkbenchContext workbench = getDesktopWorkbenchContext();
		String myfile_name = workbench.getWorkbookCtrl().getBookName();

		System.out.println("MyFile Name" + myfile_name);
		MyProperties prop = new MyProperties();
		String driver = prop.driver;
		String url = prop.url;
		String username = prop.username;
		String password = prop.password;
		String myInput_file = prop.myInput.concat(myfile_name);

		Connection conn = null;
		PreparedStatement sql_statement = null;
		String projectID = null;
		String projectid = null;
		Statement sql_deleteall = null;
		Statement getrowID = null;
		Statement statement = null;
		Statement sqlstatement = null;
		ResultSet rs = null;
		ResultSet rst = null;
		System.out.println("MyFile Name" + myInput_file);


		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			FileInputStream myInput = new FileInputStream(myInput_file);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			
			XSSFRow myrow = mySheet.getRow(2);
			XSSFCell mycell = myrow.getCell(3);
			String row_info = mycell.getStringCellValue().toString();
			System.out.println("Row Info ::" + row_info);
			projectID = "select c_project_id,em_dtzk_filename from c_project where name='" + mycell.getStringCellValue().toString() + "'";
			statement = conn.createStatement();
			sql_deleteall = conn.createStatement();
			//getrowID = conn.createStatement();
			rs = statement.executeQuery(projectID);
			rs.next();
			System.out.println("Project  id" + rs.getString(1));
			projectid = rs.getString(1);
			String fileName =  rs.getString(2);
			File output_file = new File(prop.out_file+fileName);
			System.out.println("project order id" + projectid);
			
			String jdbc_insert_sql = "select *  from dtzk_ssinformation where dtzk_ssinformation_id='"+projectid+ "' order by rowid,columnid ";
		
            rst = statement.executeQuery(jdbc_insert_sql);
			
			if(rst.next()==false){		
				Messagebox.show("No Project is Associated");
				System.out.println("In the IF...");
				//System.out.println("EMPTY FILE"+empty_file);
				System.out.println("Your excel file has been generated...!");
				Executions.sendRedirect("/empty_template.zul");
			}
			else{
				System.out.println("In the Else...");
				exportToExcelSheet(rst, output_file);				
				Executions.sendRedirect("/dbconnect.zul?filename="+output_file);
			}
		}catch (NullPointerException e) {
			Messagebox.show("NO Such Project exists in ERP");
			e.printStackTrace();
		} finally {
			rs.close();
			statement.close();
			sql_deleteall.close();
			
			conn.close();
		}


	}
	
	public static void exportToExcelSheet(ResultSet rs, File outputFile) throws Exception {
		int prev = 0, curr = 0;
		FileInputStream myInput = new FileInputStream(outputFile);
		XSSFWorkbook hwb = new XSSFWorkbook(myInput);
		XSSFSheet sheet =hwb.getSheetAt(0);
		
		XSSFCell cell = null;

			while (rs.next()) {

					cell=sheet.getRow(rs.getInt(2)).getCell(rs.getInt(3));
						System.out.println(" cell information" +cell);
                        
                        switch (cell.getCellType()) {
                
                        case org.zkoss.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                        System.out.println("cell type string and cell no :!"+sheet.getRow(rs.getInt(2)).getCell(rs.getInt(3)));
                                cell.setCellValue(rs.getString(4));
                                
                        System.out.println("after String data assigned");        
                                break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
								System.out.println("cell type numeric and Cell no :!"+sheet.getRow(rs.getInt(2)).getCell(rs.getInt(3)));
							
                                cell.setCellValue(rs.getInt(4));
                                
							System.out.println("after numeric  data assigned!");
                                break;
                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK:
                        System.out.println("blank case executed and Cell no :!"+sheet.getRow(rs.getInt(2)).getCell(rs.getInt(3)));
                        if(rs.getString(4)!=null){
                           System.out.println("blank cell data string");
                           cell.setCellValue(rs.getString(4));
                           
                           }
						   else{
						      System.out.println("blank cell data Int");
						      cell.setCellValue(rs.getInt(4));	
						      
						      }                                            
                        default:
                        System.out.println("default!");
                        System.out.println();
                        }
                      
                
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
	
}
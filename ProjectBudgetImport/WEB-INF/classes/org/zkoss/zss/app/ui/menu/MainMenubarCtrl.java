/* 
	Purpose:
		
	Description:
		
	History:
		2013/7/10, Created by dennis

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

 */
package org.zkoss.zss.app.ui.menu;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import org.zkoss.poi.xssf.usermodel.XSSFCell;
import org.zkoss.poi.xssf.usermodel.XSSFRow;
import org.zkoss.poi.xssf.usermodel.XSSFSheet;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;





import org.zkoss.zss.app.ui.AppEvts;
import org.zkoss.zss.app.ui.CtrlBase;
import org.zkoss.zss.app.ui.UiUtil;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zss.ui.Version;
import org.zkoss.zss.ui.sys.UndoableActionManager;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menubar;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zss.api.model.Sheet;

import tutorial.MyProperties;



/**
 * 
 * @author dennis
 * 
 */
public class MainMenubarCtrl extends CtrlBase<Menubar> {

	public MainMenubarCtrl() {
		super(true);
	}

	@Wire
	Menuitem newFile;
	@Wire
	Menuitem openManageFile;
	@Wire
	Menuitem saveFile;
	@Wire
	Menuitem saveFileAs;
	@Wire
	Menuitem saveFileAndClose;
	@Wire
	Menuitem closeFile;
	@Wire
	Menuitem exportFile;
	@Wire
	Menuitem exportPdf;

	@Wire
	Menuitem undo;
	@Wire
	Menuitem redo;

	@Wire
	Menuitem toggleFormulaBar;
	@Wire
	Menuitem freezePanel;
	@Wire
	Menuitem unfreezePanel;
	@Wire
	Menu freezeRows;
	@Wire
	Menu freezeCols;

	@Wire
	Menuitem saveDb;

	String bookname;

	protected void onAppEvent(String event, Object data) {
		if (AppEvts.ON_CHANGED_SPREADSHEET.equals(event)) {
			doUpdateMenu((Spreadsheet) data);
		} else if (AppEvts.ON_UPDATE_UNDO_REDO.equals(event)) {
			doUpdateMenu((Spreadsheet) data);
		}

	}

	private void doUpdateMenu(Spreadsheet sparedsheet) {

		boolean hasBook = sparedsheet.getBook() != null;
		bookname = sparedsheet.getBook().getBookName();
		System.out.println("bookname" + bookname);
		boolean isEE = "EE".equals(Version.getEdition());
		// new and open are always on
		newFile.setDisabled(false);
		openManageFile.setDisabled(false);
		boolean readonly = UiUtil.isRepositoryReadonly();
		boolean disabled = !hasBook;
		saveFile.setDisabled(disabled || readonly);
		saveFileAs.setDisabled(disabled || readonly);
		saveFileAndClose.setDisabled(disabled || readonly);
		closeFile.setDisabled(disabled);
		exportFile.setDisabled(disabled);
		exportPdf.setDisabled(!isEE || disabled);

		UndoableActionManager uam = sparedsheet.getUndoableActionManager();

		String label = Labels.getLabel("zssapp.mainMenu.edit.undo");
		if (isEE && uam.isUndoable()) {
			undo.setDisabled(false);
			label = label + ":" + uam.getUndoLabel();
		} else {
			undo.setDisabled(true);
		}
		undo.setLabel(label);

		label = Labels.getLabel("zssapp.mainMenu.edit.redo");
		if (isEE && uam.isRedoable()) {
			redo.setDisabled(false);
			label = label + ":" + uam.getRedoLabel();
		} else {
			redo.setDisabled(true);
		}
		redo.setLabel(label);

		// toggleFormulaBar.setDisabled(disabled); //don't need to care the book
		// load or not.
		toggleFormulaBar.setChecked(sparedsheet.isShowFormulabar());

		freezePanel.setDisabled(!isEE || disabled);
		Sheet sheet = sparedsheet.getSelectedSheet();
		unfreezePanel.setDisabled(!isEE || disabled || !(sheet.getRowFreeze() > 0 || sheet.getColumnFreeze() > 0));

		for (Component comp : Selectors.find(freezeRows, "menuitem")) {
			((Menuitem) comp).setDisabled(!isEE || disabled);
		}
		for (Component comp : Selectors.find(freezeCols, "menuitem")) {
			((Menuitem) comp).setDisabled(!isEE || disabled);
		}
	}

	@Listen("onClick=#newFile")
	public void onNew() {
		pushAppEvent(AppEvts.ON_NEW_BOOK);
	}

	@Listen("onClick=#openManageFile")
	public void onOpen() {
		pushAppEvent(AppEvts.ON_OPEN_MANAGE_BOOK);
	}

	@Listen("onClick=#saveFile")
	public void onSave() {
		pushAppEvent(AppEvts.ON_SAVE_BOOK);
	}

	@Listen("onClick=#saveFileAs")
	public void onSaveAs() {
		pushAppEvent(AppEvts.ON_SAVE_BOOK_AS);
	}

	@Listen("onClick=#saveFileAndClose")
	public void onSaveClose() {
		pushAppEvent(AppEvts.ON_SAVE_CLOSE_BOOK);
	}

	@Listen("onClick=#closeFile")
	public void onClose() {
		pushAppEvent(AppEvts.ON_CLOSE_BOOK);
	}

	@Listen("onClick=#exportFile")
	public void onExport() {
		pushAppEvent(AppEvts.ON_EXPORT_BOOK);
	}

	@Listen("onClick=#exportPdf")
	public void onExportPdf() {
		pushAppEvent(AppEvts.ON_EXPORT_BOOK_PDF);
	}

	@Listen("onToggleFormulaBar=#mainMenubar")
	public void onToggleFormulaBar() {
		pushAppEvent(AppEvts.ON_TOGGLE_FORMULA_BAR);
	}

	@Listen("onFreezePanel=#mainMenubar")
	public void onFreezePanel() {
		pushAppEvent(AppEvts.ON_FREEZE_PNAEL);
	}

	@Listen("onUnfreezePanel=#mainMenubar")
	public void onUnfreezePanel() {
		pushAppEvent(AppEvts.ON_UNFREEZE_PANEL);
	}

	@Listen("onViewFreezeRows=#mainMenubar")
	public void onViewFreezeRows(ForwardEvent event) {
		int index = Integer.parseInt((String) event.getData());
		pushAppEvent(AppEvts.ON_FREEZE_ROW, index);
	}

	@Listen("onViewFreezeCols=#mainMenubar")
	public void onViewFreezeCols(ForwardEvent event) {
		int index = Integer.parseInt((String) event.getData());
		pushAppEvent(AppEvts.ON_FREEZE_COLUMN, index);
	}

	@Listen("onUndo=#mainMenubar")
	public void onUndo(ForwardEvent event) {
		pushAppEvent(AppEvts.ON_UNDO);
	}

	@Listen("onRedo=#mainMenubar")
	public void onRedo(ForwardEvent event) {
		pushAppEvent(AppEvts.ON_REDO);
	}

	@Listen("onClick=#saveDb")
	public void saveDb() throws Exception {

		System.out.println("DB Process Started.....");

		System.out.println("MyFile Name" + bookname);
		MyProperties prop = new MyProperties();
		String driver = "org.postgresql.Driver";
		System.out.println(driver);
		String url = prop.url;
		System.out.println(url);
		String username = prop.username;
		System.out.println(username);
		String password = prop.password;
		System.out.println(password);
		String myInput_file = prop.myInput.concat(bookname);
		System.out.println("my input file" + myInput_file);

		Connection conn = null;
		PreparedStatement sql_statement = null;
		String active_boq_file_Id = null;
		String projectid = null;
		Statement sql_deleteall = null;
		Statement getrowID = null;
		Statement statement = null;
		Statement windowrefstatement = null;
		ResultSet rs = null;
		String importtype = null;
		String update_contractamt = null;
		String contractID = null;
		ResultSet value_returned = null;
		Statement masterImport = null;
		System.out.println("MyFile Name" + myInput_file);
		String window_reference = null;
		String windowId = null;
		String CprojectId = null;
		String product_name = null;
		String tasks = null;
		String subsection = null;
		String mainsection = null;
		String itemcode = null;
		String maincode = null;
		String mainhead = null	;
		String subhead = null;
		String costcode = null;
		String itemhead = null;
		String itemdes = null;
		int i = 0;
		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			FileInputStream myInput = new FileInputStream(myInput_file);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			/*XSSFRow myrow = mySheet.getRow(2);
			XSSFCell mycell = myrow.getCell(3);*/
			/*String row_info= mycell.getStringCellValue().toString();
			System.out.println("Row Info ::"+row_info);*/
			/*CprojectId = "select c_project_id from c_project where name='"+ mycell.getStringCellValue().toString() + "'";
			statement = conn.createStatement();
			sql_deleteall = conn.createStatement();
			getrowID = conn.createStatement();
			rs = statement.executeQuery(CprojectId);
			rs.next();
				System.out.println("order id" + rs.getString(1));
				projectid=rs.getString(1);
				System.out.println("project order id" + CprojectId);*/
				
				masterImport = conn.createStatement();
				Iterator rowIter = mySheet.rowIterator();

				while (rowIter.hasNext()) {
					XSSFRow myRow = (XSSFRow) rowIter.next();
					// HSSFRow myRow = (HSSFRow) rowIter.next();
					if (myRow.getRowNum() > 3) {
					Iterator cellIter = myRow.cellIterator();
					while (cellIter.hasNext()){
						XSSFCell myCell = (XSSFCell) cellIter.next();
						if (myCell.getColumnIndex() == 0) {		
							itemcode = myCell.toString();
                            System.out.println("itemcode :"+itemcode);
					    }else if (myCell.getColumnIndex() == 1) {
					    	maincode = myCell.toString();
						    System.out.println("maincode :"+maincode);
					    }else if (myCell.getColumnIndex() == 2) {
					    	mainhead = myCell.toString();
						    System.out.println("mainhead :"+mainhead);
					    }else if (myCell.getColumnIndex() == 3) {
					    	subhead = myCell.toString();
						    System.out.println("subhead :"+subhead);
					    }else if (myCell.getColumnIndex() == 4) {
					    	costcode = myCell.toString();
						    System.out.println("costcode :"+costcode);
					    }else if (myCell.getColumnIndex() == 5) {
					    	itemhead = myCell.toString();
						    System.out.println("itemhead :"+itemhead);
					    }else if (myCell.getColumnIndex() == 6) {
					    	itemdes = myCell.toString();
						    System.out.println("itemdes :"+itemdes);
					    }
					}
					
					System.out.println("itemcode :" + itemcode+"  maincode :"+maincode+" mainhead :"+mainhead+
							" subhead :"+subhead+" costcode :"+costcode+" itemhead :"+itemhead+" itemDes :"+itemdes);

					value_returned = masterImport.executeQuery("select dtzk_dataimport_costcode('" + itemcode + "','" + maincode + "','"+mainhead+"','"+subhead+"','"+costcode+"','"+itemhead+"','"+itemdes+"') from dual;");
					value_returned.next();
					System.out.println("ResultSet value" + value_returned.getString(1));
					}
				}
				Integer value = value_returned.getInt(1);
					if (value == 1) {
						Messagebox.show("Cost Code Master Data Imported Successfully "+bookname);
					}
					
					
				
	 
		} catch (NullPointerException e) {
			e.printStackTrace();

		}

		

	}
}

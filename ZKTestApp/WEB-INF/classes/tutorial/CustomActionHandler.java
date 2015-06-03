package tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zss.model.Exporter;
import org.zkoss.zss.model.Exporters;
import org.zkoss.zss.ui.Rect;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zss.ui.sys.ActionHandler;
import org.zkoss.zul.Messagebox;

public class CustomActionHandler extends ActionHandler {

	@Override
	public void doSaveBook() {
		Spreadsheet spreadsheet = getSpreadsheet();
		if (spreadsheet.getBook() != null) {
			final String filePath = Executions.getCurrent().getDesktop()
					.getWebApp().getRealPath(spreadsheet.getSrc());

			Exporter exporter = Exporters.getExporter("excel");
			FileOutputStream outputStream = null;
			try {
				outputStream = new FileOutputStream(new File(filePath));
				exporter.export(spreadsheet.getBook(), outputStream);
				try {
					Messagebox.show("Saved");
				} catch (Exception e) {
				}
			} catch (FileNotFoundException e) {
				try {
					Messagebox.show("Save excel failed");
				} catch (Exception e1) {
				}
			} finally {
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}

	@Override
	public void doColumnWidth(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doCustomSort(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doExportPDF(Rect selection) {

	}

	@Override
	public void doFormatCell(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doHyperlink(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doInsertFunction(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doNewBook() {
		// TODO Auto-generated method stub
		Messagebox.show("New file");
		getSpreadsheet().setSrc("/WEB-INF/empty.xls");

	}

	@Override
	public void doPasteSpecial(Rect arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doRowHeight(Rect arg0) {
		// TODO Auto-generated method stub

	}

}

/*package org.zkoss.zss.app.zul;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Messagebox;

public class FileName extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;
    @Wire
	static Spreadsheet spreadsheet;

    @Listen("onClick=#saveDb")
    public void FileName() {
        getCurrentFileName();
    }

    public void getCurrentFileName() {
    	 Messagebox.show("HI");
    	
        String book_name = spreadsheet.getBook().getBookName();
       
        return book_name;
    }
}*/
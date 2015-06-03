package tutorial;

import javax.servlet.http.HttpServletRequest;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class TestComposer extends Window {

	public TestComposer(){
		HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();
		String prjid=request.getParameter("prjId"); 
		System.out.println(":" + request.getParameter("prjId") + ":");		
		
		
	}
	
	/*public String getProjectId(){
		
	}*/
	

}

/*package tutorial;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Messagebox;

public class FileName extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;
    @Wire
    Spreadsheet spreadsheet;

    @Listen("onClick=#test")
    public void test() {
        getCurrentFileName();
    }

    public void getCurrentFileName() {
        String book_name = spreadsheet.getBook().getBookName();
        Messagebox.show(book_name);
    }
}*/


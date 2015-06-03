package org.openbravo.datatreis.erpReports;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;

public class Movement_Data extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strmMovementId = vars.getSessionValue("Movement_Data.inpmMovementId_R");
      if (strmMovementId.equals(""))
        strmMovementId = vars.getSessionValue("Movement_Data.inpmMovementId");
      if (log4j.isDebugEnabled())
        log4j.debug("+***********************: " + strmMovementId);
      printPagePartePDF(response, vars, strmMovementId);
    } else
      pageError(response);
  }

  private void printPagePartePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strmMovementId) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: pdf");
    String strBaseDesign = getBaseDesignPath(vars.getLanguage());

    HashMap<String, Object> parameters = new HashMap<String, Object>();
    JasperReport jasperReportLines;
    try {
      JasperDesign jasperDesignLines = JRXmlLoader.load(strBaseDesign
          + "/org/openbravo/datatreis/erpReports/GoodsMovements.jrxml");
      jasperReportLines = JasperCompileManager.compileReport(jasperDesignLines);
    } catch (JRException e) {
      e.printStackTrace();
      throw new ServletException(e.getMessage());
    }
    System.out.println("testing" + strBaseDesign);
    parameters.put("SR_LINES", jasperReportLines);
    parameters.put("Movement_Id", strmMovementId);
    renderJR(vars, response, null, "pdf", parameters, null, null);
  }

  public String getServletInfo() {
    return "Servlet that presents the RptMRequisitions seeker";
  } // End of getServletInfo() method

}


package org.openbravo.erpCommon.ad_actionButton;


import org.openbravo.erpCommon.utility.*;
import org.openbravo.erpCommon.reference.*;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.obps.ActivationKey;
import org.openbravo.erpCommon.obps.ActivationKey.FeatureRestriction;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.ui.Process;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ActionButton_Responser extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  protected static final String windowId = "ActionButtonResponser";
  
  public void init (ServletConfig config) {
    super.init(config);
    boolHist = false;
  }
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);

    // set process type and id for audit
    SessionInfo.setProcessType("P");
    SessionInfo.setProcessId(strProcessId);
    SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
    SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
    SessionInfo.setQueryProfile("manualProcess");

    try {
      OBContext.setAdminMode();
      Process process = OBDal.getInstance().get(Process.class, strProcessId);
      if (process != null) {
        SessionInfo.setModuleId(process.getModule().getId());
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    super.service(request, response);
  }

  private String getProcessId(VariablesSecureApp vars) throws ServletException {
    String command = vars.getCommand();
    if (command.equals("DEFAULT")) {
      return vars.getRequiredStringParameter("inpadProcessId");
    } else if (command.startsWith("BUTTON")) {
      return command.substring("BUTTON".length());
    } else if (command.startsWith("FRAMES")) {
      return command.substring("FRAMES".length());
    } else if (command.startsWith("SAVE_BUTTONActionButton")) {
      return command.substring("SAVE_BUTTONActionButton".length());
    }
    return null;
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);

    if (vars.getCommand().startsWith("FRAMES")) {
      printPageFrames(response, vars, strProcessId);
    }
    
    if (!vars.commandIn("DEFAULT")) {
      //Check access
      FeatureRestriction featureRestriction = ActivationKey.getInstance().hasLicenseAccess("P",
          strProcessId);
      if (featureRestriction != FeatureRestriction.NO_RESTRICTION) {
        licenseError("P", strProcessId, featureRestriction, response, request, vars, true);
      }
      if (!hasGeneralAccess(vars, "P", strProcessId)) {
        bdErrorGeneralPopUp(request, response,
            Utility.messageBD(this, "Error", vars.getLanguage()), Utility.messageBD(this,
                "AccessTableNoView", vars.getLanguage()));
      }
    }
    
      
    if (vars.commandIn("DEFAULT")) {
      printPageDefault(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON172")) {
        
        printPageButton172(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800087")) {
        
        printPageButton800087(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800075")) {
        
        printPageButton800075(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON119")) {
        
        printPageButton119(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON193")) {
        
        printPageButton193(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON185")) {
        
        printPageButton185(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON175")) {
        
        printPageButton175(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800130")) {
        
        printPageButton800130(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800151")) {
        
        printPageButton800151(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800109")) {
        
        printPageButton800109(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800085")) {
        
        printPageButton800085(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF0F5462686134E0089DAF07AF5EB0660")) {
        
        printPageButtonF0F5462686134E0089DAF07AF5EB0660(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4B0CEC0B3AFE49CC893E73D7D6CC1B91")) {
        
        printPageButton4B0CEC0B3AFE49CC893E73D7D6CC1B91(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON683D8B2A24EF412C96E4DBEF34F1BD01")) {
        
        printPageButton683D8B2A24EF412C96E4DBEF34F1BD01(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9D695C033D554981AEE5C345932905A1")) {
        
        printPageButton9D695C033D554981AEE5C345932905A1(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB7C897C397F14600B2202D37963B80DA")) {
        
        printPageButtonB7C897C397F14600B2202D37963B80DA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCE1A567B76834CC18B87B9849C4EC8FF")) {
        
        printPageButtonCE1A567B76834CC18B87B9849C4EC8FF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND14396E80E28430BB958039C9E7CA381")) {
        
        printPageButtonD14396E80E28430BB958039C9E7CA381(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800171")) {
        
        printPageButton800171(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND234AE084F7040DCB66E281A4237FF99")) {
        
        printPageButtonD234AE084F7040DCB66E281A4237FF99(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON61E0B54EB8F74C92A3A93D524DF41338")) {
        
        printPageButton61E0B54EB8F74C92A3A93D524DF41338(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8096BB8256F047E082CF105C6F8F4F49")) {
        
        printPageButton8096BB8256F047E082CF105C6F8F4F49(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4561647C081B4F208419ACC01EDA7048")) {
        
        printPageButton4561647C081B4F208419ACC01EDA7048(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1432E46D163D4D72A2165462E4533092")) {
        
        printPageButton1432E46D163D4D72A2165462E4533092(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8F77212363EC46BD898B9451D450879A")) {
        
        printPageButton8F77212363EC46BD898B9451D450879A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND1E3CC3D6D884402B04FFDD2C55FCE6E")) {
        
        printPageButtonD1E3CC3D6D884402B04FFDD2C55FCE6E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE54AB04AA5844DAE955537B41633F655")) {
        
        printPageButtonE54AB04AA5844DAE955537B41633F655(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON101E10B4677243799D7EF6AFDE185A7D")) {
        
        printPageButton101E10B4677243799D7EF6AFDE185A7D(response, vars, strProcessId);

    } else if (vars.commandIn("SAVE_BUTTONActionButton172")) {
       process172(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800087")) {
       process800087(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800075")) {
       process800075(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton119")) {
       process119(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton193")) {
       process193(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton185")) {
       process185(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton175")) {
       process175(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800130")) {
       process800130(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800151")) {
       process800151(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800109")) {
       process800109(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800085")) {
       process800085(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF0F5462686134E0089DAF07AF5EB0660")) {
       processF0F5462686134E0089DAF07AF5EB0660(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton4B0CEC0B3AFE49CC893E73D7D6CC1B91")) {
       process4B0CEC0B3AFE49CC893E73D7D6CC1B91(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton683D8B2A24EF412C96E4DBEF34F1BD01")) {
       process683D8B2A24EF412C96E4DBEF34F1BD01(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton9D695C033D554981AEE5C345932905A1")) {
       process9D695C033D554981AEE5C345932905A1(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB7C897C397F14600B2202D37963B80DA")) {
       processB7C897C397F14600B2202D37963B80DA(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCE1A567B76834CC18B87B9849C4EC8FF")) {
       processCE1A567B76834CC18B87B9849C4EC8FF(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD14396E80E28430BB958039C9E7CA381")) {
       processD14396E80E28430BB958039C9E7CA381(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton800171")) {
       process800171(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD234AE084F7040DCB66E281A4237FF99")) {
       processD234AE084F7040DCB66E281A4237FF99(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton61E0B54EB8F74C92A3A93D524DF41338")) {
       process61E0B54EB8F74C92A3A93D524DF41338(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton8096BB8256F047E082CF105C6F8F4F49")) {
       process8096BB8256F047E082CF105C6F8F4F49(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton4561647C081B4F208419ACC01EDA7048")) {
       process4561647C081B4F208419ACC01EDA7048(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton1432E46D163D4D72A2165462E4533092")) {
       process1432E46D163D4D72A2165462E4533092(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton8F77212363EC46BD898B9451D450879A")) {
       process8F77212363EC46BD898B9451D450879A(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD1E3CC3D6D884402B04FFDD2C55FCE6E")) {
       processD1E3CC3D6D884402B04FFDD2C55FCE6E(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE54AB04AA5844DAE955537B41633F655")) {
       processE54AB04AA5844DAE955537B41633F655(vars, request, response);    
    } else if (vars.commandIn("SAVE_BUTTONActionButton101E10B4677243799D7EF6AFDE185A7D")) {
       process101E10B4677243799D7EF6AFDE185A7D(vars, request, response);    

    } else pageErrorPopUp(response);
  }

  void printPageDefault(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefault").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
	xmlDocument.setParameter("trlFormType", "PROCESS");
	xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }
  
  void printPageFrames(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

    void printPageButton172(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 172");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton172", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("172");
        vars.removeMessage("172");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800087(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800087");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800087", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800087");
        vars.removeMessage("800087");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800075(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800075");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800075", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800075");
        vars.removeMessage("800075");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DateFrom", "");
    xmlDocument.setParameter("DateFrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("DateTo", "");
    xmlDocument.setParameter("DateTo_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("M_Warehouse_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "M_Warehouse_ID", "197", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_BPartner_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_BPartner_ID", "192", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_BPartner_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("ReferenceNo", "");
    xmlDocument.setParameter("DateInvoiced", "");
    xmlDocument.setParameter("DateInvoiced_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton119(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 119");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton119", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("119");
        vars.removeMessage("119");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DateInvoiced", "");
    xmlDocument.setParameter("DateInvoiced_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("AD_Org_ID", Utility.getContext(this, vars, "#AD_Org_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "130", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "#AD_Org_ID", windowId));
    xmlDocument.setData("reportAD_Org_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "134", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_BPartner_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_BPartner_ID", "", "135", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_BPartner_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("InvoiceToDate", "");
    xmlDocument.setParameter("InvoiceToDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton193(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 193");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton193", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("193");
        vars.removeMessage("193");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DateOrdered", "");
    xmlDocument.setParameter("DateOrdered_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("C_BPartner_ID", "");
    xmlDocument.setParameter("C_BPartner_IDR", "");
    xmlDocument.setParameter("Vendor_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "Vendor_ID", "192", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportVendor_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    xmlDocument.setParameter("C_Order_IDR", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton185(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 185");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton185", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("185");
        vars.removeMessage("185");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton175(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 175");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton175", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("175");
        vars.removeMessage("175");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("AD_Client_ID", Utility.getContext(this, vars, "AD_Client_ID", ""));
    comboTableData = new ComboTableData(vars, this, "19", "AD_Client_ID", "", "103", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "AD_Client_ID", ""));
    xmlDocument.setData("reportAD_Client_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("AD_Table_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAD_Table_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800130(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800130");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800130", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800130");
        vars.removeMessage("800130");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Initdate", DateTimeData.today(this));
    xmlDocument.setParameter("Initdate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("EndDate", "");
    xmlDocument.setParameter("EndDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800151(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800151");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800151", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800151");
        vars.removeMessage("800151");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800109(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800109");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800109", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800109");
        vars.removeMessage("800109");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Budget_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Budget_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Budget_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("MA_Processplan_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "MA_Processplan_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportMA_Processplan_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("CalcDate", "");
    xmlDocument.setParameter("CalcDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800085(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800085");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800085", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800085");
        vars.removeMessage("800085");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("IsIncremental", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF0F5462686134E0089DAF07AF5EB0660(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F0F5462686134E0089DAF07AF5EB0660");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF0F5462686134E0089DAF07AF5EB0660", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F0F5462686134E0089DAF07AF5EB0660");
        vars.removeMessage("F0F5462686134E0089DAF07AF5EB0660");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Project_ID", "");
    xmlDocument.setParameter("C_Project_IDR", "");
    xmlDocument.setParameter("outputType", "");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton4B0CEC0B3AFE49CC893E73D7D6CC1B91(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4B0CEC0B3AFE49CC893E73D7D6CC1B91");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4B0CEC0B3AFE49CC893E73D7D6CC1B91", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4B0CEC0B3AFE49CC893E73D7D6CC1B91");
        vars.removeMessage("4B0CEC0B3AFE49CC893E73D7D6CC1B91");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton683D8B2A24EF412C96E4DBEF34F1BD01(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 683D8B2A24EF412C96E4DBEF34F1BD01");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton683D8B2A24EF412C96E4DBEF34F1BD01", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("683D8B2A24EF412C96E4DBEF34F1BD01");
        vars.removeMessage("683D8B2A24EF412C96E4DBEF34F1BD01");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Project_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Project_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Project_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "Excel");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "Excel");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9D695C033D554981AEE5C345932905A1(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9D695C033D554981AEE5C345932905A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9D695C033D554981AEE5C345932905A1", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9D695C033D554981AEE5C345932905A1");
        vars.removeMessage("9D695C033D554981AEE5C345932905A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Project_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Project_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Project_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonB7C897C397F14600B2202D37963B80DA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B7C897C397F14600B2202D37963B80DA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB7C897C397F14600B2202D37963B80DA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B7C897C397F14600B2202D37963B80DA");
        vars.removeMessage("B7C897C397F14600B2202D37963B80DA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCE1A567B76834CC18B87B9849C4EC8FF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CE1A567B76834CC18B87B9849C4EC8FF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCE1A567B76834CC18B87B9849C4EC8FF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CE1A567B76834CC18B87B9849C4EC8FF");
        vars.removeMessage("CE1A567B76834CC18B87B9849C4EC8FF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD14396E80E28430BB958039C9E7CA381(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D14396E80E28430BB958039C9E7CA381");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD14396E80E28430BB958039C9E7CA381", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D14396E80E28430BB958039C9E7CA381");
        vars.removeMessage("D14396E80E28430BB958039C9E7CA381");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton800171(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800171");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton800171", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("800171");
        vars.removeMessage("800171");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_BPartner_ID", "");
    xmlDocument.setParameter("C_BPartner_IDR", "");
    xmlDocument.setParameter("C_Currency_ID", Utility.getContext(this, vars, "C_Currency_ID", "") );
    comboTableData = new ComboTableData(vars, this, "19", "C_Currency_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "C_Currency_ID", "") );
    xmlDocument.setData("reportC_Currency_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("DateFrom", DateTimeData.today(this));
    xmlDocument.setParameter("DateFrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("DateTo", "");
    xmlDocument.setParameter("DateTo_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("C_Project_ID", "");
    xmlDocument.setParameter("C_Project_IDR", "");
    xmlDocument.setParameter("M_Warehouse_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD234AE084F7040DCB66E281A4237FF99(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D234AE084F7040DCB66E281A4237FF99");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD234AE084F7040DCB66E281A4237FF99", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D234AE084F7040DCB66E281A4237FF99");
        vars.removeMessage("D234AE084F7040DCB66E281A4237FF99");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("reportType", "cus");
    comboTableData = new ComboTableData(vars, this, "17", "reportType", "B82C3C28E51F4AA6B87D98E7ABBF92F0", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "cus");
    xmlDocument.setData("reportreportType", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("AD_Org_ID", Utility.getContext(this, vars, "AD_Org_ID", ""));
    comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "0C754881EAD94243A161111916E9B9C6", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "AD_Org_ID", ""));
    xmlDocument.setData("reportAD_Org_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_AcctSchema_ID", Utility.getContext(this, vars, "C_AcctSchema_ID", ""));
    comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "C_AcctSchema_ID", ""));
    xmlDocument.setData("reportC_AcctSchema_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_BPartner_ID", Utility.getContext(this, vars, "C_BPartner_ID", ""));
    xmlDocument.setParameter("C_BPartner_IDR", "");
    xmlDocument.setParameter("DateFrom", "");
    xmlDocument.setParameter("DateFrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("DateTo", "");
    xmlDocument.setParameter("DateTo_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton61E0B54EB8F74C92A3A93D524DF41338(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 61E0B54EB8F74C92A3A93D524DF41338");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton61E0B54EB8F74C92A3A93D524DF41338", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("61E0B54EB8F74C92A3A93D524DF41338");
        vars.removeMessage("61E0B54EB8F74C92A3A93D524DF41338");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_order_ID", "", "DC2172CF86214CBBB21D4988FB9BC7DB", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Product_ID", "", "98F3F6DB107E45619D30767103396DC6", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Product_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Dtpo_Pocop_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Dtpo_Pocop_ID", "", "BD84936EB158429CB587331D42BFCC5F", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportDtpo_Pocop_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8096BB8256F047E082CF105C6F8F4F49(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8096BB8256F047E082CF105C6F8F4F49");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8096BB8256F047E082CF105C6F8F4F49", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8096BB8256F047E082CF105C6F8F4F49");
        vars.removeMessage("8096BB8256F047E082CF105C6F8F4F49");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Project_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Project_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Project_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_Product_IDR", "");
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton4561647C081B4F208419ACC01EDA7048(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4561647C081B4F208419ACC01EDA7048");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4561647C081B4F208419ACC01EDA7048", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4561647C081B4F208419ACC01EDA7048");
        vars.removeMessage("4561647C081B4F208419ACC01EDA7048");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1432E46D163D4D72A2165462E4533092(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1432E46D163D4D72A2165462E4533092");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1432E46D163D4D72A2165462E4533092", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1432E46D163D4D72A2165462E4533092");
        vars.removeMessage("1432E46D163D4D72A2165462E4533092");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("DateFrom", "");
    xmlDocument.setParameter("DateFrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("DateTo", "");
    xmlDocument.setParameter("DateTo_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("outputType", "");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_Product_IDR", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8F77212363EC46BD898B9451D450879A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8F77212363EC46BD898B9451D450879A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8F77212363EC46BD898B9451D450879A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8F77212363EC46BD898B9451D450879A");
        vars.removeMessage("8F77212363EC46BD898B9451D450879A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "Excel");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "Excel");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD1E3CC3D6D884402B04FFDD2C55FCE6E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D1E3CC3D6D884402B04FFDD2C55FCE6E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD1E3CC3D6D884402B04FFDD2C55FCE6E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D1E3CC3D6D884402B04FFDD2C55FCE6E");
        vars.removeMessage("D1E3CC3D6D884402B04FFDD2C55FCE6E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Project_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Project_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Project_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonE54AB04AA5844DAE955537B41633F655(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E54AB04AA5844DAE955537B41633F655");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonE54AB04AA5844DAE955537B41633F655", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("E54AB04AA5844DAE955537B41633F655");
        vars.removeMessage("E54AB04AA5844DAE955537B41633F655");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_order_ID", "", "DC2172CF86214CBBB21D4988FB9BC7DB", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Product_ID", "", "98F3F6DB107E45619D30767103396DC6", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Product_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton101E10B4677243799D7EF6AFDE185A7D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 101E10B4677243799D7EF6AFDE185A7D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton101E10B4677243799D7EF6AFDE185A7D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButton_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("101E10B4677243799D7EF6AFDE185A7D");
        vars.removeMessage("101E10B4677243799D7EF6AFDE185A7D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Order_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Order_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Order_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputType", "pdf");
    comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "pdf");
    xmlDocument.setData("reportoutputType", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }



    private void process172(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "172", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800087(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800087", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800075(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800075", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strreferenceno = vars.getStringParameter("inpreferenceno");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "ReferenceNo", strreferenceno, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateinvoiced = vars.getStringParameter("inpdateinvoiced");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "60", "DateInvoiced", strdateinvoiced, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process119(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "119", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdateinvoiced = vars.getStringParameter("inpdateinvoiced");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "DateInvoiced", strdateinvoiced, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "15", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strinvoicetodate = vars.getStringParameter("inpinvoicetodate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "InvoiceToDate", strinvoicetodate, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process193(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "193", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdateordered = vars.getStringParameter("inpdateordered");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "DateOrdered", strdateordered, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strvendorId = vars.getStringParameter("inpvendorId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "Vendor_ID", strvendorId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process185(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "185", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process175(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "175", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradClientId = vars.getStringParameter("inpadClientId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Client_ID", stradClientId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradTableId = vars.getStringParameter("inpadTableId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "AD_Table_ID", stradTableId, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800130(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800130", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strinitdate = vars.getStringParameter("inpinitdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "Initdate", strinitdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strenddate = vars.getStringParameter("inpenddate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "EndDate", strenddate, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800151(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800151", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800109(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800109", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcBudgetId = vars.getStringParameter("inpcBudgetId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Budget_ID", strcBudgetId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmaProcessplanId = vars.getStringParameter("inpmaProcessplanId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "MA_Processplan_ID", strmaProcessplanId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcalcdate = vars.getStringParameter("inpcalcdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "CalcDate", strcalcdate, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800085(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800085", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strisincremental = vars.getStringParameter("inpisincremental", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "IsIncremental", strisincremental, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processF0F5462686134E0089DAF07AF5EB0660(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "F0F5462686134E0089DAF07AF5EB0660", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process4B0CEC0B3AFE49CC893E73D7D6CC1B91(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "4B0CEC0B3AFE49CC893E73D7D6CC1B91", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process683D8B2A24EF412C96E4DBEF34F1BD01(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "683D8B2A24EF412C96E4DBEF34F1BD01", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process9D695C033D554981AEE5C345932905A1(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "9D695C033D554981AEE5C345932905A1", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processB7C897C397F14600B2202D37963B80DA(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "B7C897C397F14600B2202D37963B80DA", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processCE1A567B76834CC18B87B9849C4EC8FF(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "CE1A567B76834CC18B87B9849C4EC8FF", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processD14396E80E28430BB958039C9E7CA381(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "D14396E80E28430BB958039C9E7CA381", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process800171(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800171", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcCurrencyId = vars.getStringParameter("inpcCurrencyId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "15", "C_Currency_ID", strcCurrencyId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "70", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processD234AE084F7040DCB66E281A4237FF99(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "D234AE084F7040DCB66E281A4237FF99", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strreporttype = vars.getStringParameter("inpreporttype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "reportType", strreporttype, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcAcctschemaId = vars.getStringParameter("inpcAcctschemaId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "C_AcctSchema_ID", strcAcctschemaId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "50", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "60", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "70", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process61E0B54EB8F74C92A3A93D524DF41338(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "61E0B54EB8F74C92A3A93D524DF41338", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "M_Product_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdtpoPocopId = vars.getStringParameter("inpdtpoPocopId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "Dtpo_Pocop_ID", strdtpoPocopId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process8096BB8256F047E082CF105C6F8F4F49(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "8096BB8256F047E082CF105C6F8F4F49", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "M_Product_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process4561647C081B4F208419ACC01EDA7048(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "4561647C081B4F208419ACC01EDA7048", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process1432E46D163D4D72A2165462E4533092(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "1432E46D163D4D72A2165462E4533092", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());
String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "M_Product_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process8F77212363EC46BD898B9451D450879A(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "8F77212363EC46BD898B9451D450879A", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processD1E3CC3D6D884402B04FFDD2C55FCE6E(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "D1E3CC3D6D884402B04FFDD2C55FCE6E", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void processE54AB04AA5844DAE955537B41633F655(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "E54AB04AA5844DAE955537B41633F655", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "M_Product_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }
    private void process101E10B4677243799D7EF6AFDE185A7D(VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException{
         
        String strProcessing = vars.getStringParameter("inpprocessing");
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "101E10B4677243799D7EF6AFDE185A7D", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);    
  }


  public String getServletInfo() {
    return "Servlet ActionButton_Responser. This Servlet was made by Wad constructor";
  } // end of the getServletInfo() method

  private void processButtonHelper(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, String pinstance) 
     throws ServletException, IOException {
      OBError myMessage;
      try {
        PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
      myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
      } catch (Exception e) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
          e.printStackTrace();
          log4j.warn("Error");
      }
      advisePopUp(request, response, myMessage.getType(), myMessage.getTitle(), myMessage.getMessage());
  }
}

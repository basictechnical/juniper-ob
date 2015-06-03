
package org.openbravo.erpWindows.PurchaseOrder;


import org.openbravo.erpCommon.reference.*;



import org.codehaus.jettison.json.JSONObject;
import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import org.openbravo.database.SessionInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Arrays;

public class SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.class);
  
  private static final String windowId = "181";
  private static final String tabId = "59AE7877F4B74AB5A44646C2B60A4B39";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 3;
  private static final String moduleId = "7B984714AD4D42B6B410D20BEFDB154F";
  
  @Override
  public void init(ServletConfig config) {
    setClassInfo("W", tabId, moduleId);
    super.init(config);
  }
  
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String command = vars.getCommand();
    
    boolean securedProcess = false;
    if (command.contains("BUTTON")) {
     List<String> explicitAccess = Arrays.asList( "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      if (command.contains("C55E968E76974358AEB1160CF39EDC03")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C55E968E76974358AEB1160CF39EDC03");
        SessionInfo.setModuleId("7B984714AD4D42B6B410D20BEFDB154F");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("F35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F35C861132FB4CCE9B7EB55F4C9DCCBF");
        SessionInfo.setModuleId("7B984714AD4D42B6B410D20BEFDB154F");
        if (securedProcess || explicitAccess.contains("F35C861132FB4CCE9B7EB55F4C9DCCBF")) {
          classInfo.type = "P";
          classInfo.id = "F35C861132FB4CCE9B7EB55F4C9DCCBF";
        }
      }
     
      if (command.contains("CBCD75188BB3489C9CE5A88608097076")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CBCD75188BB3489C9CE5A88608097076");
        SessionInfo.setModuleId("7B984714AD4D42B6B410D20BEFDB154F");
        if (securedProcess || explicitAccess.contains("CBCD75188BB3489C9CE5A88608097076")) {
          classInfo.type = "P";
          classInfo.id = "CBCD75188BB3489C9CE5A88608097076";
        }
      }
     

     
      if (explicitAccess.contains("C55E968E76974358AEB1160CF39EDC03") || (securedProcess && command.contains("C55E968E76974358AEB1160CF39EDC03"))) {
        classInfo.type = "P";
        classInfo.id = "C55E968E76974358AEB1160CF39EDC03";
      }
     
    }
    if (!securedProcess) {
      setClassInfo("W", tabId, moduleId);
    }
    super.service(request, response);
  }
  

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strdtpoPocopfileId = request.getParameter("inpdtpoPocopfileId");
         String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strdtpoPocopfileId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Order_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Order_ID);
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");

      String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
            if (strPC_Order_ID.equals("")) {
        strPC_Order_ID = getParentID(vars, strDtpo_Pocopfile_ID);
        if (strPC_Order_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Order_ID");
        vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);

        refreshParentSession(vars, strPC_Order_ID);
      }


      String strView = vars.getSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strDtpo_Pocopfile_ID.equals("")) strDtpo_Pocopfile_ID = firstElement(vars, tableSQL);
          if (strDtpo_Pocopfile_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strDtpo_Pocopfile_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("DIRECT")) {
      String strDtpo_Pocopfile_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strDtpo_Pocopfile_ID.equals("")) strDtpo_Pocopfile_ID = vars.getRequiredGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      else vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strDtpo_Pocopfile_ID);
      
      
      String strPC_Order_ID = getParentID(vars, strDtpo_Pocopfile_ID);
      
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.setSessionValue("294|Header.view", "EDIT");

      refreshParentSession(vars, strPC_Order_ID);

      vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view", "EDIT");

      printPageEdit(response, request, vars, false, strDtpo_Pocopfile_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("TAB")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Dtpo_Pocopfile_ID");
      refreshParentSession(vars, strPC_Order_ID);


      String strView = vars.getSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view");
      String strDtpo_Pocopfile_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strDtpo_Pocopfile_ID = firstElement(vars, tableSQL);
          if (strDtpo_Pocopfile_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strDtpo_Pocopfile_ID.equals("")) strDtpo_Pocopfile_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strDtpo_Pocopfile_ID, strPC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Order_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamCopno", tabId + "|paramCopno");
vars.getRequestGlobalVariable("inpParamCopamount", tabId + "|paramCopamount");
vars.getRequestGlobalVariable("inpParamCopamount_f", tabId + "|paramCopamount_f");

        vars.getRequestGlobalVariable("inpParamUpdated", tabId + "|paramUpdated");
        vars.getRequestGlobalVariable("inpParamUpdatedBy", tabId + "|paramUpdatedBy");
        vars.getRequestGlobalVariable("inpParamCreated", tabId + "|paramCreated");
        vars.getRequestGlobalVariable("inpparamCreatedBy", tabId + "|paramCreatedBy");
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      
      vars.removeSessionValue(windowId + "|Dtpo_Pocopfile_ID");
      String strDtpo_Pocopfile_ID="";

      String strView = vars.getSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strDtpo_Pocopfile_ID = firstElement(vars, tableSQL);
        if (strDtpo_Pocopfile_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strDtpo_Pocopfile_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      

      String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
      vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Order_ID, strDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


      printPageEdit(response, request, vars, true, "", strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
      vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strDtpo_Pocopfile_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strDtpo_Pocopfile_ID = vars.getRequiredStringParameter("inpdtpoPocopfileId");
      
      String strNext = nextElement(vars, strDtpo_Pocopfile_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strDtpo_Pocopfile_ID = vars.getRequiredStringParameter("inpdtpoPocopfileId");
      
      String strPrevious = previousElement(vars, strDtpo_Pocopfile_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Dtpo_Pocopfile_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Dtpo_Pocopfile_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Order_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Order_ID);      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strDtpo_Pocopfile_ID = vars.getRequiredGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Order_ID);      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strDtpo_Pocopfile_ID, tableSQL);
          vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("DELETE")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strDtpo_Pocopfile_ID = vars.getRequiredStringParameter("inpdtpoPocopfileId");
      //SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data data = getEditVariables(vars, strPC_Order_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasNotDeleteAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.delete(this, strDtpo_Pocopfile_ID, strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|dtpoPocopfileId");
        vars.setSessionValue(tabId + "|SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONCopapproveF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strcopapprove", vars.getStringParameter("inpcopapprove"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F35C861132FB4CCE9B7EB55F4C9DCCBF", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
        String strcopapprove = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strcopapprove");
        String strProcessing = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strProcessing");
        String strOrg = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strOrg");
        String strClient = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCopapproveF35C861132FB4CCE9B7EB55F4C9DCCBF(response, vars, strDtpo_Pocopfile_ID, strcopapprove, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCoprejectCBCD75188BB3489C9CE5A88608097076")) {
        vars.setSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strcopreject", vars.getStringParameter("inpcopreject"));
        vars.setSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCBCD75188BB3489C9CE5A88608097076.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CBCD75188BB3489C9CE5A88608097076", request.getServletPath());    
     } else if (vars.commandIn("BUTTONCBCD75188BB3489C9CE5A88608097076")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
        String strcopreject = vars.getSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strcopreject");
        String strProcessing = vars.getSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strProcessing");
        String strOrg = vars.getSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strOrg");
        String strClient = vars.getSessionValue("buttonCBCD75188BB3489C9CE5A88608097076.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCoprejectCBCD75188BB3489C9CE5A88608097076(response, vars, strDtpo_Pocopfile_ID, strcopreject, strProcessing);
        }

    } else if (vars.commandIn("BUTTONCreatecopC55E968E76974358AEB1160CF39EDC03")) {
        vars.setSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strcreatecop", vars.getStringParameter("inpcreatecop"));
        vars.setSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC55E968E76974358AEB1160CF39EDC03.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C55E968E76974358AEB1160CF39EDC03", request.getServletPath());
      } else if (vars.commandIn("BUTTONC55E968E76974358AEB1160CF39EDC03")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");
        String strcreatecop = vars.getSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strcreatecop");
        String strProcessing = vars.getSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strProcessing");
        String strOrg = vars.getSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strOrg");
        String strClient = vars.getSessionValue("buttonC55E968E76974358AEB1160CF39EDC03.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatecopC55E968E76974358AEB1160CF39EDC03(response, vars, strDtpo_Pocopfile_ID, strcreatecop, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONCopapproveF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpKey", windowId + "|Dtpo_Pocopfile_ID", "");
        @SuppressWarnings("unused")
        String strcopapprove = vars.getStringParameter("inpcopapprove");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F35C861132FB4CCE9B7EB55F4C9DCCBF", (("Dtpo_Pocopfile_ID".equalsIgnoreCase("AD_Language"))?"0":strDtpo_Pocopfile_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONCoprejectCBCD75188BB3489C9CE5A88608097076")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpKey", windowId + "|Dtpo_Pocopfile_ID", "");
        @SuppressWarnings("unused")
        String strcopreject = vars.getStringParameter("inpcopreject");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "CBCD75188BB3489C9CE5A88608097076", (("Dtpo_Pocopfile_ID".equalsIgnoreCase("AD_Language"))?"0":strDtpo_Pocopfile_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);

    } else if (vars.commandIn("SAVE_BUTTONCreatecopC55E968E76974358AEB1160CF39EDC03")) {
        String strDtpo_Pocopfile_ID = vars.getGlobalVariable("inpKey", windowId + "|Dtpo_Pocopfile_ID", "");
        
        ProcessBundle pb = new ProcessBundle("C55E968E76974358AEB1160CF39EDC03", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Dtpo_Pocopfile_ID", strDtpo_Pocopfile_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);





    } else if (vars.commandIn("SAVE_XHR")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();
      JSONObject result = new JSONObject();
      String commandType = vars.getStringParameter("inpCommandType");
      char saveType = "NEW".equals(commandType) ? 'I' : 'U';
      try {
        int total = saveRecord(vars, myError, saveType, strPC_Order_ID);
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          myError.setType("Success");
        }
        result.put("oberror", myError.toMap());
        result.put("tabid", vars.getStringParameter("tabID"));
        result.put("redirect", strDireccion + request.getServletPath() + "?Command=" + commandType);
      } catch (Exception e) {
        log4j.error("Error saving record (XHR request): " + e.getMessage(), e);
        myError.setType("Error");
        myError.setMessage(e.getMessage());
      }

      response.setContentType("application/json");
      PrintWriter out = response.getWriter();
      out.print(result.toString());
      out.flush();
      out.close();
    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
  private SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
    SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data data = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequiredGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.filename = vars.getStringParameter("inpfilename");     data.associateboq = vars.getStringParameter("inpassociateboq");     data.description = vars.getStringParameter("inpdescription");     data.boqimport = vars.getStringParameter("inpboqimport", "N");     data.importfiletype = vars.getStringParameter("inpimportfiletype");     data.orderline = vars.getStringParameter("inporderline");     data.fileView = vars.getStringParameter("inpfileView");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.copno = vars.getStringParameter("inpcopno");    try {   data.copamount = vars.getNumericParameter("inpcopamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.copstatus = vars.getStringParameter("inpcopstatus");     data.copapprove = vars.getStringParameter("inpcopapprove");     data.copreject = vars.getStringParameter("inpcopreject");     data.copsentapprove = vars.getStringParameter("inpcopsentapprove");     data.filetype = vars.getStringParameter("inpfiletype");     data.filetyper = vars.getStringParameter("inpfiletype_R");     data.paymenttype = vars.getStringParameter("inppaymenttype");     data.paymenttyper = vars.getStringParameter("inppaymenttype_R");     data.advancetype = vars.getStringParameter("inpadvancetype");     data.advancetyper = vars.getStringParameter("inpadvancetype_R");     data.createcop = vars.getStringParameter("inpcreatecop");    try {   data.usdamt = vars.getNumericParameter("inpusdamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.conversionrate = vars.getNumericParameter("inpconversionrate");  } catch (ServletException paramEx) { ex = paramEx; }     data.emJcmDolsInvoice = vars.getStringParameter("inpemJcmDolsInvoice");    try {   data.emJcmClaimedInvoiceamt = vars.getNumericParameter("inpemJcmClaimedInvoiceamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.emJcmDorbInvoice = vars.getStringParameter("inpemJcmDorbInvoice");    try {   data.emJcmAdvancetotal = vars.getNumericParameter("inpemJcmAdvancetotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.emJcmNettotal = vars.getNumericParameter("inpemJcmNettotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.emJcmRecoverytotal = vars.getNumericParameter("inpemJcmRecoverytotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.dtpoPocopfileId = vars.getRequestGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");     data.adClientId = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cOrderId = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }


  private void refreshParentSession(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|DatePromised", data[0].datepromised);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|DocStatus", data[0].docstatus);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|EM_Epb_Mainsection_ID", data[0].emEpbMainsectionId);    vars.setSessionValue(windowId + "|EM_Dtpo_C_Tax_ID", data[0].emDtpoCTaxId);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);    vars.setSessionValue(windowId + "|Posted", data[0].posted);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|Processed", data[0].processed);
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|ORDERTYPE", HeaderData.selectAux8(this, strPC_Order_ID));
      
      vars.setSessionValue(windowId + "|DOCBASETYPE", HeaderData.selectAux17F5DEA4A5254BDDA77560A7D67667B6(this, Utility.getContext(this, vars, "c_doctypetarget_id", "181")));
      
  }
  
  
  private String getParentID(VariablesSecureApp vars, String strDtpo_Pocopfile_ID) throws ServletException {
    String strPC_Order_ID = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectParentID(this, strDtpo_Pocopfile_ID);
    if (strPC_Order_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strDtpo_Pocopfile_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Order_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", data[0].getField("dtpoPocopfileId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] data = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, vars.getStringParameter("inpdtpoPocopfileId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Order_ID, String strDtpo_Pocopfile_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamCopno = vars.getSessionValue(tabId + "|paramCopno");
String strParamCopamount = vars.getSessionValue(tabId + "|paramCopamount");
String strParamCopamount_f = vars.getSessionValue(tabId + "|paramCopamount_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamCopno) && ("").equals(strParamCopamount) && ("").equals(strParamCopamount_f)) || !(("").equals(strParamCopno) || ("%").equals(strParamCopno))  || !(("").equals(strParamCopamount) || ("%").equals(strParamCopamount))  || !(("").equals(strParamCopamount_f) || ("%").equals(strParamCopamount_f)) ;
    String strOffset = vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strDtpo_Pocopfile_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strDtpo_Pocopfile_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Relation", discard).createXmlDocument();

    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    ToolBar toolbar = new ToolBar(this, true, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39", false, "document.frmMain.inpdtpoPocopfileId", "grid", "..", "".equals("Y"), "PurchaseOrder", strReplaceWith, false, false, false, false, !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    
    toolbar.setDeleteable(true && !hasReadOnlyAccess);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Order_ID);
    xmlDocument.setParameter("parentFieldName", Utility.getFieldName("909E0BDD5C2540BBB0C84641A0197E42", vars.getLanguage()));


    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "dtpoPocopfileId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Relation.html", "PurchaseOrder", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"));
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectParent(this, strPC_Order_ID));
    else xmlDocument.setParameter("parent", SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectParentTrl(this, strPC_Order_ID));

    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strDtpo_Pocopfile_ID, String strPC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamCopno = vars.getSessionValue(tabId + "|paramCopno");
String strParamCopamount = vars.getSessionValue(tabId + "|paramCopamount");
String strParamCopamount_f = vars.getSessionValue(tabId + "|paramCopamount_f");

    boolean hasSearchCondition=false;
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamCopno) && ("").equals(strParamCopamount) && ("").equals(strParamCopamount_f)) || !(("").equals(strParamCopno) || ("%").equals(strParamCopno))  || !(("").equals(strParamCopamount) || ("%").equals(strParamCopamount))  || !(("").equals(strParamCopamount_f) || ("%").equals(strParamCopamount_f)) ;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, strDtpo_Pocopfile_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strDtpo_Pocopfile_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("dtpoPocopfileId") == null || dataField.getField("dtpoPocopfileId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPC_Order_ID);
        data = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.set(strPC_Order_ID, Utility.getDefault(this, vars, "EM_Jcm_Nettotal", "", "181", "", dataField), Utility.getDefault(this, vars, "Copstatus", "DR", "181", "", dataField), Utility.getDefault(this, vars, "Copamount", "", "181", "", dataField), Utility.getDefault(this, vars, "Filename", "", "181", "", dataField), Utility.getDefault(this, vars, "File_View", "", "181", "", dataField), Utility.getDefault(this, vars, "Copreject", "", "181", "N", dataField), Utility.getDefault(this, vars, "Paymenttype", "", "181", "", dataField), Utility.getDefault(this, vars, "Advancetype", "", "181", "", dataField), Utility.getDefault(this, vars, "Importfiletype", "", "181", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "181", "", dataField), SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectDef426601B5F4A14310ADD8C542B6159675_0(this, Utility.getDefault(this, vars, "Createdby", "", "181", "", dataField)), Utility.getDefault(this, vars, "EM_Jcm_Claimed_Invoiceamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Copno", "", "181", "", dataField), Utility.getDefault(this, vars, "Createcop", "", "181", "N", dataField), "", Utility.getDefault(this, vars, "Boqimport", "", "181", "N", dataField), Utility.getDefault(this, vars, "Copapprove", "", "181", "N", dataField), Utility.getDefault(this, vars, "EM_Jcm_Dorb_Invoice", "", "181", "", dataField), Utility.getDefault(this, vars, "Associateboq", "", "181", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "181", "", dataField), Utility.getDefault(this, vars, "EM_Jcm_Dols_Invoice", "", "181", "", dataField), "Y", Utility.getDefault(this, vars, "Updatedby", "", "181", "", dataField), SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectDefA2E2FD14B85643F5B6BDF7F0DEC12E44_1(this, Utility.getDefault(this, vars, "Updatedby", "", "181", "", dataField)), Utility.getDefault(this, vars, "EM_Jcm_Recoverytotal", "", "181", "", dataField), Utility.getDefault(this, vars, "Description", "", "181", "", dataField), Utility.getDefault(this, vars, "Orderline", "", "181", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "181", "", dataField), Utility.getDefault(this, vars, "EM_Jcm_Advancetotal", "", "181", "", dataField), Utility.getDefault(this, vars, "Filetype", "", "181", "", dataField), Utility.getDefault(this, vars, "Usdamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Conversionrate", "", "181", "", dataField), Utility.getDefault(this, vars, "Copsentapprove", "", "181", "N", dataField));
        
      }
     }
      
    String currentPOrg=HeaderData.selectOrg(this, strPC_Order_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    boolean editableTab = (!hasReadOnlyAccess && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (editableTab)
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Edition",discard).createXmlDocument();
    else
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_NonEditable",discard).createXmlDocument();

    xmlDocument.setParameter("tabId", tabId);
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpdtpoPocopfileId", "", "..", "".equals("Y"), "PurchaseOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strDtpo_Pocopfile_ID), !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    toolbar.setDeleteable(true);
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    // set updated timestamp to manage locking mechanism
    if (!boolNew) {
      xmlDocument.setParameter("updatedTimestamp", (dataField != null ? dataField
          .getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp")));
    }
    
    boolean concurrentSave = vars.getSessionValue(tabId + "|concurrentSave").equals("true");
    if (concurrentSave) {
      //after concurrent save error, force autosave
      xmlDocument.setParameter("autosave", "Y");
    } else {
      xmlDocument.setParameter("autosave", "N");
    }
    vars.removeSessionValue(tabId + "|concurrentSave");

    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      // if (!strDtpo_Pocopfile_ID.equals("")) xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  // else xmlDocument.setParameter("childTabContainer", tabs.childTabs(true));
	  xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Relation.html", "PurchaseOrder", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"), !concurrentSave);
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.editionTemplate(strCommand.equals("NEW")));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
		
    
    xmlDocument.setParameter("parentOrg", currentPOrg);
    xmlDocument.setParameter("commandType", strCommand);
    xmlDocument.setParameter("buscador",buscador);
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("changed", "");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    final String strMappingName = Utility.getTabURL(tabId, "E", false);
    xmlDocument.setParameter("mappingName", strMappingName);
    xmlDocument.setParameter("confirmOnChanges", Utility.getJSConfirmOnChanges(vars, windowId));
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));

    xmlDocument.setParameter("paramSessionDate", strParamSessionDate);

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    OBError myMessage = vars.getMessage(tabId);
    vars.removeMessage(tabId);
    if (myMessage!=null) {
      xmlDocument.setParameter("messageType", myMessage.getType());
      xmlDocument.setParameter("messageTitle", myMessage.getTitle());
      xmlDocument.setParameter("messageMessage", myMessage.getMessage());
    }
    xmlDocument.setParameter("displayLogic", getDisplayLogicContext(vars, boolNew));
    
    
     if (dataField==null) {
      xmlDocument.setData("structure1",data);
      
    } else {
      
        FieldProvider[] dataAux = new FieldProvider[1];
        dataAux[0] = dataField;
        
        xmlDocument.setData("structure1",dataAux);
      
    }
    
      
   
    try {
      ComboTableData comboTableData = null;
String userOrgList = "";
if (editableTab) 
  userOrgList= Utility.getReferenceableOrg(this, vars, currentPOrg, windowId, accesslevel); //referenceable from parent org, only the writeable orgs
else 
  userOrgList=currentOrg;
comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", userOrgList, Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("adOrgId"):dataField.getField("adOrgId")));
xmlDocument.setData("reportAD_Org_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("buttonCopamount", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("Copapprove_BTNname", Utility.getButtonName(this, vars, "4EBBE17C78424636B1B1E2D8D7DBC45D", "Copapprove_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalCopapprove = org.openbravo.erpCommon.utility.Utility.isModalProcess("F35C861132FB4CCE9B7EB55F4C9DCCBF"); 
xmlDocument.setParameter("Copapprove_Modal", modalCopapprove?"true":"false");
xmlDocument.setParameter("Copreject_BTNname", Utility.getButtonName(this, vars, "73B4FDA71946468DA62B89BFB5157A46", "Copreject_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalCopreject = org.openbravo.erpCommon.utility.Utility.isModalProcess("CBCD75188BB3489C9CE5A88608097076"); 
xmlDocument.setParameter("Copreject_Modal", modalCopreject?"true":"false");
comboTableData = new ComboTableData(vars, this, "17", "Filetype", "DFD16360C7334C978D1762D663D69983", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("filetype"):dataField.getField("filetype")));
xmlDocument.setData("reportFiletype","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "17", "Paymenttype", "8F67BB07A9514E018722466A10D77451", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("paymenttype"):dataField.getField("paymenttype")));
xmlDocument.setData("reportPaymenttype","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "17", "Advancetype", "916DE3645158498590BAD49ED98F2EE2", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("advancetype"):dataField.getField("advancetype")));
xmlDocument.setData("reportAdvancetype","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("Createcop_BTNname", Utility.getButtonName(this, vars, "EB2F1864246C450093AAB1E6AB2F4C9A", "Createcop_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalCreatecop = org.openbravo.erpCommon.utility.Utility.isModalProcess("C55E968E76974358AEB1160CF39EDC03"); 
xmlDocument.setParameter("Createcop_Modal", modalCreatecop?"true":"false");
xmlDocument.setParameter("buttonConversionrate", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("EM_Jcm_Dols_Invoice_Format", vars.getSessionValue("#AD_SqlDateFormat"));
xmlDocument.setParameter("buttonEM_Jcm_Claimed_Invoiceamt", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("EM_Jcm_Dorb_Invoice_Format", vars.getSessionValue("#AD_SqlDateFormat"));
xmlDocument.setParameter("buttonEM_Jcm_Advancetotal", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("buttonEM_Jcm_Nettotal", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("buttonEM_Jcm_Recoverytotal", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("Created_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Created_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
xmlDocument.setParameter("Updated_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Updated_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new ServletException(ex);
    }

    xmlDocument.setParameter("scriptOnLoad", getShortcutScript(usedButtonShortCuts, reservedButtonShortCuts));
    
    final String refererURL = vars.getSessionValue(tabId + "|requestURL");
    vars.removeSessionValue(tabId + "|requestURL");
    if(!refererURL.equals("")) {
    	final Boolean failedAutosave = (Boolean) vars.getSessionObject(tabId + "|failedAutosave");
		vars.removeSessionValue(tabId + "|failedAutosave");
    	if(failedAutosave != null && failedAutosave) {
    		final String jsFunction = "continueUserAction('"+refererURL+"');";
    		xmlDocument.setParameter("failedAutosave", jsFunction);
    	}
    }

    if (strCommand.equalsIgnoreCase("NEW")) {
      vars.removeSessionValue(tabId + "|failedAutosave");
      vars.removeSessionValue(strMappingName + "|hash");
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }

    private void printPageButtonCopapproveF35C861132FB4CCE9B7EB55F4C9DCCBF(HttpServletResponse response, VariablesSecureApp vars, String strDtpo_Pocopfile_ID, String strcopapprove, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F35C861132FB4CCE9B7EB55F4C9DCCBF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CopapproveF35C861132FB4CCE9B7EB55F4C9DCCBF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strDtpo_Pocopfile_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F35C861132FB4CCE9B7EB55F4C9DCCBF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F35C861132FB4CCE9B7EB55F4C9DCCBF");
        vars.removeMessage("F35C861132FB4CCE9B7EB55F4C9DCCBF");
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
    private void printPageButtonCoprejectCBCD75188BB3489C9CE5A88608097076(HttpServletResponse response, VariablesSecureApp vars, String strDtpo_Pocopfile_ID, String strcopreject, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CBCD75188BB3489C9CE5A88608097076");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CoprejectCBCD75188BB3489C9CE5A88608097076", discard).createXmlDocument();
      xmlDocument.setParameter("key", strDtpo_Pocopfile_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CBCD75188BB3489C9CE5A88608097076");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CBCD75188BB3489C9CE5A88608097076");
        vars.removeMessage("CBCD75188BB3489C9CE5A88608097076");
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


    void printPageButtonCreatecopC55E968E76974358AEB1160CF39EDC03(HttpServletResponse response, VariablesSecureApp vars, String strDtpo_Pocopfile_ID, String strcreatecop, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C55E968E76974358AEB1160CF39EDC03");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreatecopC55E968E76974358AEB1160CF39EDC03", discard).createXmlDocument();
      xmlDocument.setParameter("key", strDtpo_Pocopfile_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C55E968E76974358AEB1160CF39EDC03");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C55E968E76974358AEB1160CF39EDC03");
        vars.removeMessage("C55E968E76974358AEB1160CF39EDC03");
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


    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Order_ID) throws IOException, ServletException {
    SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars, strPC_Order_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.dtpoPocopfileId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.getCurrentDBTimestamp(this, data.dtpoPocopfileId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.dtpoPocopfileId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", data.dtpoPocopfileId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}

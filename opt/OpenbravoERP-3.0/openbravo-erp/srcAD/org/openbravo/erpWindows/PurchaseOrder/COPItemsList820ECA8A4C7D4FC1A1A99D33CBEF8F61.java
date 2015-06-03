
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

public class COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.class);
  
  private static final String windowId = "181";
  private static final String tabId = "820ECA8A4C7D4FC1A1A99D33CBEF8F61";
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
        String strdtpoItemcopId = request.getParameter("inpdtpoItemcopId");
         String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strdtpoItemcopId.equals(""))
              total = saveRecord(vars, myError, 'U', strPDtpo_Pocopfile_ID);
          else
              total = saveRecord(vars, myError, 'I', strPDtpo_Pocopfile_ID);
          
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
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", "");

      String strDtpo_Itemcop_ID = vars.getGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID", "");
            if (strPDtpo_Pocopfile_ID.equals("")) {
        strPDtpo_Pocopfile_ID = getParentID(vars, strDtpo_Itemcop_ID);
        if (strPDtpo_Pocopfile_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Dtpo_Pocopfile_ID");
        vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strPDtpo_Pocopfile_ID);
      vars.removeSessionValue(windowId + "|C_Order_ID");
        refreshParentSession(vars, strPDtpo_Pocopfile_ID);
      }


      String strView = vars.getSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strDtpo_Itemcop_ID.equals("")) strDtpo_Itemcop_ID = firstElement(vars, tableSQL);
          if (strDtpo_Itemcop_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, tableSQL);

      else printPageDataSheet(response, vars, strPDtpo_Pocopfile_ID, strDtpo_Itemcop_ID, tableSQL);
    } else if (vars.commandIn("DIRECT")) {
      String strDtpo_Itemcop_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strDtpo_Itemcop_ID.equals("")) strDtpo_Itemcop_ID = vars.getRequiredGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID");
      else vars.setSessionValue(windowId + "|Dtpo_Itemcop_ID", strDtpo_Itemcop_ID);
      
      
      String strPDtpo_Pocopfile_ID = getParentID(vars, strDtpo_Itemcop_ID);
      
      vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strPDtpo_Pocopfile_ID);
      vars.setSessionValue("59AE7877F4B74AB5A44646C2B60A4B39|Spreadsheet Attachement.view", "EDIT");
      vars.removeSessionValue(windowId + "|C_Order_ID");
      refreshParentSession(vars, strPDtpo_Pocopfile_ID);

      vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view", "EDIT");

      printPageEdit(response, request, vars, false, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, tableSQL);

    } else if (vars.commandIn("TAB")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Dtpo_Itemcop_ID");
      refreshParentSession(vars, strPDtpo_Pocopfile_ID);


      String strView = vars.getSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view");
      String strDtpo_Itemcop_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strDtpo_Itemcop_ID = firstElement(vars, tableSQL);
          if (strDtpo_Itemcop_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strDtpo_Itemcop_ID.equals("")) strDtpo_Itemcop_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPDtpo_Pocopfile_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamCopamt", tabId + "|paramCopamt");
vars.getRequestGlobalVariable("inpParamSearchkey", tabId + "|paramSearchkey");
vars.getRequestGlobalVariable("inpParamCopamt_f", tabId + "|paramCopamt_f");

        vars.getRequestGlobalVariable("inpParamUpdated", tabId + "|paramUpdated");
        vars.getRequestGlobalVariable("inpParamUpdatedBy", tabId + "|paramUpdatedBy");
        vars.getRequestGlobalVariable("inpParamCreated", tabId + "|paramCreated");
        vars.getRequestGlobalVariable("inpparamCreatedBy", tabId + "|paramCreatedBy");
            String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      
      vars.removeSessionValue(windowId + "|Dtpo_Itemcop_ID");
      String strDtpo_Itemcop_ID="";

      String strView = vars.getSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strDtpo_Itemcop_ID = firstElement(vars, tableSQL);
        if (strDtpo_Itemcop_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, tableSQL);

      else printPageDataSheet(response, vars, strPDtpo_Pocopfile_ID, strDtpo_Itemcop_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      

      String strDtpo_Itemcop_ID = vars.getGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID", "");
      vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view", "RELATION");
      printPageDataSheet(response, vars, strPDtpo_Pocopfile_ID, strDtpo_Itemcop_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");


      printPageEdit(response, request, vars, true, "", strPDtpo_Pocopfile_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strDtpo_Itemcop_ID = vars.getGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID", "");
      vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      String strDtpo_Itemcop_ID = vars.getRequiredStringParameter("inpdtpoItemcopId");
      
      String strNext = nextElement(vars, strDtpo_Itemcop_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      String strDtpo_Itemcop_ID = vars.getRequiredStringParameter("inpdtpoItemcopId");
      
      String strPrevious = previousElement(vars, strDtpo_Itemcop_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Dtpo_Itemcop_ID");
      vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strPDtpo_Pocopfile_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Dtpo_Itemcop_ID");
      vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strPDtpo_Pocopfile_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPDtpo_Pocopfile_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPDtpo_Pocopfile_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPDtpo_Pocopfile_ID);      
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
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      String strDtpo_Itemcop_ID = vars.getRequiredGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPDtpo_Pocopfile_ID);      
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
          String strNext = nextElement(vars, strDtpo_Itemcop_ID, tableSQL);
          vars.setSessionValue(windowId + "|Dtpo_Itemcop_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("DELETE")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");

      String strDtpo_Itemcop_ID = vars.getRequiredStringParameter("inpdtpoItemcopId");
      //COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data data = getEditVariables(vars, strPDtpo_Pocopfile_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasNotDeleteAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.delete(this, strDtpo_Itemcop_ID, strPDtpo_Pocopfile_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|dtpoItemcopId");
        vars.setSessionValue(tabId + "|COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONApprovecopF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strapprovecop", vars.getStringParameter("inpapprovecop"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F35C861132FB4CCE9B7EB55F4C9DCCBF", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        String strDtpo_Itemcop_ID = vars.getGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID", "");
        String strapprovecop = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strapprovecop");
        String strProcessing = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strProcessing");
        String strOrg = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strOrg");
        String strClient = vars.getSessionValue("buttonF35C861132FB4CCE9B7EB55F4C9DCCBF.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonApprovecopF35C861132FB4CCE9B7EB55F4C9DCCBF(response, vars, strDtpo_Itemcop_ID, strapprovecop, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONApprovecopF35C861132FB4CCE9B7EB55F4C9DCCBF")) {
        String strDtpo_Itemcop_ID = vars.getGlobalVariable("inpKey", windowId + "|Dtpo_Itemcop_ID", "");
        @SuppressWarnings("unused")
        String strapprovecop = vars.getStringParameter("inpapprovecop");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F35C861132FB4CCE9B7EB55F4C9DCCBF", (("Dtpo_Itemcop_ID".equalsIgnoreCase("AD_Language"))?"0":strDtpo_Itemcop_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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






    } else if (vars.commandIn("SAVE_XHR")) {
      String strPDtpo_Pocopfile_ID = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");
      OBError myError = new OBError();
      JSONObject result = new JSONObject();
      String commandType = vars.getStringParameter("inpCommandType");
      char saveType = "NEW".equals(commandType) ? 'I' : 'U';
      try {
        int total = saveRecord(vars, myError, saveType, strPDtpo_Pocopfile_ID);
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
  private COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data getEditVariables(Connection con, VariablesSecureApp vars, String strPDtpo_Pocopfile_ID) throws IOException,ServletException {
    COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data data = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequiredGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.dtpoPocopfileId = vars.getRequiredStringParameter("inpdtpoPocopfileId");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.productname = vars.getStringParameter("inpproductname");    try {   data.productqty = vars.getNumericParameter("inpproductqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copamt = vars.getNumericParameter("inpcopamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.damagedReturned = vars.getNumericParameter("inpdamagedReturned");  } catch (ServletException paramEx) { ex = paramEx; }     data.searchkey = vars.getStringParameter("inpsearchkey");     data.cOrderlineId = vars.getRequestGlobalVariable("inpcOrderlineId", windowId + "|C_Orderline_ID");     data.attributename = vars.getStringParameter("inpattributename");    try {   data.grnquantity = vars.getNumericParameter("inpgrnquantity");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalquantity = vars.getNumericParameter("inptotalquantity");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.certfdcopamt = vars.getNumericParameter("inpcertfdcopamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totallineamt = vars.getNumericParameter("inptotallineamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.balancecopamt = vars.getNumericParameter("inpbalancecopamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.coppercentage = vars.getNumericParameter("inpcoppercentage");  } catch (ServletException paramEx) { ex = paramEx; }     data.approvecop = vars.getStringParameter("inpapprovecop");    try {   data.copbasic = vars.getNumericParameter("inpcopbasic");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copinsurance = vars.getNumericParameter("inpcopinsurance");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copfreight = vars.getNumericParameter("inpcopfreight");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copothers = vars.getNumericParameter("inpcopothers");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.coppkgFwdg = vars.getNumericParameter("inpcoppkgFwdg");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copexcise = vars.getNumericParameter("inpcopexcise");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copsubtotal = vars.getNumericParameter("inpcopsubtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copvatCst = vars.getNumericParameter("inpcopvatCst");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.copoctroiLbt = vars.getNumericParameter("inpcopoctroiLbt");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.dtpoItemcopId = vars.getRequestGlobalVariable("inpdtpoItemcopId", windowId + "|Dtpo_Itemcop_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.dtpoPocopfileId = vars.getGlobalVariable("inpdtpoPocopfileId", windowId + "|Dtpo_Pocopfile_ID");


    
    

    
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


  private void refreshParentSession(VariablesSecureApp vars, String strPDtpo_Pocopfile_ID) throws IOException,ServletException {
      
      SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] data = SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|C_Order_ID"), strPDtpo_Pocopfile_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", data[0].dtpoPocopfileId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|Dtpo_Pocopfile_ID", strPDtpo_Pocopfile_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
  
  
  private String getParentID(VariablesSecureApp vars, String strDtpo_Itemcop_ID) throws ServletException {
    String strPDtpo_Pocopfile_ID = COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectParentID(this, strDtpo_Itemcop_ID);
    if (strPDtpo_Pocopfile_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strDtpo_Itemcop_ID);
      throw new ServletException("Parent record not found");
    }
    return strPDtpo_Pocopfile_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_Orderline_ID", data[0].getField("cOrderlineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Dtpo_Itemcop_ID", data[0].getField("dtpoItemcopId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPDtpo_Pocopfile_ID) throws IOException,ServletException {
      COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] data = COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPDtpo_Pocopfile_ID, vars.getStringParameter("inpdtpoItemcopId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPDtpo_Pocopfile_ID, String strDtpo_Itemcop_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamCopamt = vars.getSessionValue(tabId + "|paramCopamt");
String strParamSearchkey = vars.getSessionValue(tabId + "|paramSearchkey");
String strParamCopamt_f = vars.getSessionValue(tabId + "|paramCopamt_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamCopamt) && ("").equals(strParamSearchkey) && ("").equals(strParamCopamt_f)) || !(("").equals(strParamCopamt) || ("%").equals(strParamCopamt))  || !(("").equals(strParamSearchkey) || ("%").equals(strParamSearchkey))  || !(("").equals(strParamCopamt_f) || ("%").equals(strParamCopamt_f)) ;
    String strOffset = vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strDtpo_Itemcop_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strDtpo_Itemcop_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Relation", discard).createXmlDocument();

    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    ToolBar toolbar = new ToolBar(this, true, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61", false, "document.frmMain.inpdtpoItemcopId", "grid", "..", "".equals("Y"), "PurchaseOrder", strReplaceWith, false, false, false, false, !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    
    toolbar.setDeleteable(true && !hasReadOnlyAccess);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPDtpo_Pocopfile_ID);
    xmlDocument.setParameter("parentFieldName", Utility.getFieldName("C586FD11631A49368FCDB98598552E29", vars.getLanguage()));


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
    xmlDocument.setParameter("KeyName", "dtpoItemcopId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Relation.html", "PurchaseOrder", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"));
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectParent(this, strPDtpo_Pocopfile_ID));
    else xmlDocument.setParameter("parent", COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectParentTrl(this, strPDtpo_Pocopfile_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strDtpo_Itemcop_ID, String strPDtpo_Pocopfile_ID, TableSQLData tableSQL)
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
    COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamCopamt = vars.getSessionValue(tabId + "|paramCopamt");
String strParamSearchkey = vars.getSessionValue(tabId + "|paramSearchkey");
String strParamCopamt_f = vars.getSessionValue(tabId + "|paramCopamt_f");

    boolean hasSearchCondition=false;
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamCopamt) && ("").equals(strParamSearchkey) && ("").equals(strParamCopamt_f)) || !(("").equals(strParamCopamt) || ("%").equals(strParamCopamt))  || !(("").equals(strParamSearchkey) || ("%").equals(strParamSearchkey))  || !(("").equals(strParamCopamt_f) || ("%").equals(strParamCopamt_f)) ;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPDtpo_Pocopfile_ID, strDtpo_Itemcop_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strDtpo_Itemcop_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("dtpoItemcopId") == null || dataField.getField("dtpoItemcopId").equals("")) {
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
        refreshSessionNew(vars, strPDtpo_Pocopfile_ID);
        data = COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.set(strPDtpo_Pocopfile_ID, Utility.getDefault(this, vars, "Coppkg_Fwdg", "", "181", "", dataField), Utility.getDefault(this, vars, "Certfdcopamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Copbasic", "", "181", "", dataField), Utility.getDefault(this, vars, "Copinsurance", "", "181", "", dataField), Utility.getDefault(this, vars, "Copothers", "", "181", "", dataField), Utility.getDefault(this, vars, "Attributename", "", "181", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "181", "", dataField), COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectDef34CD32A7866548F2B855C5EA3C2E0193_0(this, Utility.getDefault(this, vars, "Updatedby", "", "181", "", dataField)), Utility.getDefault(this, vars, "Copoctroi_Lbt", "", "181", "", dataField), "Y", Utility.getDefault(this, vars, "Createdby", "", "181", "", dataField), COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.selectDef3822D00B7E564D4C88015453A7351207_1(this, Utility.getDefault(this, vars, "Createdby", "", "181", "", dataField)), Utility.getDefault(this, vars, "Copvat_Cst", "", "181", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "181", "", dataField), Utility.getDefault(this, vars, "Totalquantity", "", "181", "", dataField), Utility.getDefault(this, vars, "Totallineamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Damaged_Returned", "", "181", "", dataField), Utility.getDefault(this, vars, "Copfreight", "", "181", "", dataField), Utility.getDefault(this, vars, "C_Orderline_ID", "", "181", "", dataField), Utility.getDefault(this, vars, "Copsubtotal", "", "181", "", dataField), "", Utility.getDefault(this, vars, "Copexcise", "", "181", "", dataField), Utility.getDefault(this, vars, "Grnquantity", "", "181", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "181", "", dataField), Utility.getDefault(this, vars, "Productqty", "", "181", "", dataField), Utility.getDefault(this, vars, "Coppercentage", "", "181", "", dataField), Utility.getDefault(this, vars, "Approvecop", "", "181", "N", dataField), Utility.getDefault(this, vars, "Copamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Searchkey", "", "181", "", dataField), Utility.getDefault(this, vars, "Balancecopamt", "", "181", "", dataField), Utility.getDefault(this, vars, "Productname", "", "181", "", dataField));
        
      }
     }
      
    String currentPOrg=SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.selectOrg(this, strPDtpo_Pocopfile_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    boolean editableTab = (!hasReadOnlyAccess && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (editableTab)
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Edition",discard).createXmlDocument();
    else
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PurchaseOrder/COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_NonEditable",discard).createXmlDocument();

    xmlDocument.setParameter("tabId", tabId);
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpdtpoItemcopId", "", "..", "".equals("Y"), "PurchaseOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strDtpo_Itemcop_ID), !hasReadOnlyAccess);
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
      // if (!strDtpo_Itemcop_ID.equals("")) xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  // else xmlDocument.setParameter("childTabContainer", tabs.childTabs(true));
	  xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Relation.html", "PurchaseOrder", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"), !concurrentSave);
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Relation.html", strReplaceWith);
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
xmlDocument.setParameter("buttonCopamt", Utility.messageBD(this, "Calc", vars.getLanguage()));
xmlDocument.setParameter("Approvecop_BTNname", Utility.getButtonName(this, vars, "599B69F79B88454A9674F242E3DC7E5E", "Approvecop_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalApprovecop = org.openbravo.erpCommon.utility.Utility.isModalProcess("F35C861132FB4CCE9B7EB55F4C9DCCBF"); 
xmlDocument.setParameter("Approvecop_Modal", modalApprovecop?"true":"false");
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

    private void printPageButtonApprovecopF35C861132FB4CCE9B7EB55F4C9DCCBF(HttpServletResponse response, VariablesSecureApp vars, String strDtpo_Itemcop_ID, String strapprovecop, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F35C861132FB4CCE9B7EB55F4C9DCCBF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ApprovecopF35C861132FB4CCE9B7EB55F4C9DCCBF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strDtpo_Itemcop_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61_Edition.html");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPDtpo_Pocopfile_ID) throws IOException, ServletException {
    COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data data = null;
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
            data = getEditVariables(con, vars, strPDtpo_Pocopfile_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.dtpoItemcopId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.getCurrentDBTimestamp(this, data.dtpoItemcopId).equals(
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
                    data.dtpoItemcopId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Dtpo_Itemcop_ID", data.dtpoItemcopId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}

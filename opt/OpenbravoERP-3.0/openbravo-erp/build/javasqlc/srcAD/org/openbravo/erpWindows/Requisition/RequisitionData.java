//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Requisition;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
WAD Generated class
 */
class RequisitionData implements FieldProvider {
static Logger log4j = Logger.getLogger(RequisitionData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String emDtProjectId;
  public String emDtProjectIdr;
  public String description;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adUserId;
  public String adUserIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String docaction;
  public String docactionBtn;
  public String docstatus;
  public String emPcProjectId;
  public String emPcProjectIdr;
  public String emEpbMainsectionId;
  public String emEpbSubsectionId;
  public String emEpbSubtasksId;
  public String emPcIscheck;
  public String createpo;
  public String adClientId;
  public String processed;
  public String mRequisitionId;
  public String processing;
  public String isactive;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("em_dt_project_id") || fieldName.equals("emDtProjectId"))
      return emDtProjectId;
    else if (fieldName.equalsIgnoreCase("em_dt_project_idr") || fieldName.equals("emDtProjectIdr"))
      return emDtProjectIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("em_pc_project_id") || fieldName.equals("emPcProjectId"))
      return emPcProjectId;
    else if (fieldName.equalsIgnoreCase("em_pc_project_idr") || fieldName.equals("emPcProjectIdr"))
      return emPcProjectIdr;
    else if (fieldName.equalsIgnoreCase("em_epb_mainsection_id") || fieldName.equals("emEpbMainsectionId"))
      return emEpbMainsectionId;
    else if (fieldName.equalsIgnoreCase("em_epb_subsection_id") || fieldName.equals("emEpbSubsectionId"))
      return emEpbSubsectionId;
    else if (fieldName.equalsIgnoreCase("em_epb_subtasks_id") || fieldName.equals("emEpbSubtasksId"))
      return emEpbSubtasksId;
    else if (fieldName.equalsIgnoreCase("em_pc_ischeck") || fieldName.equals("emPcIscheck"))
      return emPcIscheck;
    else if (fieldName.equalsIgnoreCase("createpo"))
      return createpo;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("m_requisition_id") || fieldName.equals("mRequisitionId"))
      return mRequisitionId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static RequisitionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_User_ID, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, AD_User_ID, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RequisitionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String AD_User_ID, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Requisition.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Requisition.CreatedBy) as CreatedByR, " +
      "        to_char(M_Requisition.Updated, ?) as updated, " +
      "        to_char(M_Requisition.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Requisition.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Requisition.UpdatedBy) as UpdatedByR," +
      "        M_Requisition.AD_Org_ID, " +
      "(CASE WHEN M_Requisition.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Requisition.DocumentNo, " +
      "M_Requisition.EM_DT_Project_ID, " +
      "(CASE WHEN M_Requisition.EM_DT_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS EM_DT_Project_IDR, " +
      "M_Requisition.Description, " +
      "M_Requisition.C_BPartner_ID, " +
      "(CASE WHEN M_Requisition.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_Requisition.AD_User_ID, " +
      "(CASE WHEN M_Requisition.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "M_Requisition.M_PriceList_ID, " +
      "(CASE WHEN M_Requisition.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "M_Requisition.C_Currency_ID, " +
      "(CASE WHEN M_Requisition.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "M_Requisition.DocAction, " +
      "list1.name as DocAction_BTN, " +
      "M_Requisition.DocStatus, " +
      "M_Requisition.EM_Pc_Project_ID, " +
      "(CASE WHEN M_Requisition.EM_Pc_Project_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS EM_Pc_Project_IDR, " +
      "M_Requisition.EM_Epb_Mainsection_ID, " +
      "M_Requisition.EM_Epb_Subsection_ID, " +
      "M_Requisition.EM_Epb_Subtasks_ID, " +
      "COALESCE(M_Requisition.EM_Pc_Ischeck, 'N') AS EM_Pc_Ischeck, " +
      "M_Requisition.Createpo, " +
      "M_Requisition.AD_Client_ID, " +
      "COALESCE(M_Requisition.Processed, 'N') AS Processed, " +
      "M_Requisition.M_Requisition_ID, " +
      "COALESCE(M_Requisition.Processing, 'N') AS Processing, " +
      "COALESCE(M_Requisition.IsActive, 'N') AS IsActive, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Requisition left join (select AD_Org_ID, Name from AD_Org) table1 on (M_Requisition.AD_Org_ID = table1.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (M_Requisition.EM_DT_Project_ID = table2.C_Project_ID) left join (select C_BPartner_ID, Name from C_BPartner) table3 on (M_Requisition.C_BPartner_ID = table3.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table4 on (M_Requisition.AD_User_ID = table4.AD_User_ID) left join (select M_PriceList_ID, Name from M_PriceList) table5 on (M_Requisition.M_PriceList_ID = table5.M_PriceList_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table6 on (M_Requisition.C_Currency_ID = table6.C_Currency_ID) left join ad_ref_list_v list1 on (list1.ad_reference_id = '135' and list1.ad_language = ?  AND (CASE M_Requisition.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(M_Requisition.DocAction) END) = list1.value) left join (select C_Project_ID, Name from C_Project) table7 on (M_Requisition.EM_Pc_Project_ID =  table7.C_Project_ID)" +
      "        WHERE 2=2 " +
      " AND M_Requisition.Ad_User_ID = ?" +
      "        AND 1=1 " +
      "        AND M_Requisition.M_Requisition_ID = ? " +
      "        AND M_Requisition.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Requisition.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        RequisitionData objectRequisitionData = new RequisitionData();
        objectRequisitionData.created = UtilSql.getValue(result, "created");
        objectRequisitionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRequisitionData.updated = UtilSql.getValue(result, "updated");
        objectRequisitionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRequisitionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRequisitionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRequisitionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRequisitionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRequisitionData.documentno = UtilSql.getValue(result, "documentno");
        objectRequisitionData.emDtProjectId = UtilSql.getValue(result, "em_dt_project_id");
        objectRequisitionData.emDtProjectIdr = UtilSql.getValue(result, "em_dt_project_idr");
        objectRequisitionData.description = UtilSql.getValue(result, "description");
        objectRequisitionData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRequisitionData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectRequisitionData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectRequisitionData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectRequisitionData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRequisitionData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectRequisitionData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectRequisitionData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectRequisitionData.docaction = UtilSql.getValue(result, "docaction");
        objectRequisitionData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectRequisitionData.docstatus = UtilSql.getValue(result, "docstatus");
        objectRequisitionData.emPcProjectId = UtilSql.getValue(result, "em_pc_project_id");
        objectRequisitionData.emPcProjectIdr = UtilSql.getValue(result, "em_pc_project_idr");
        objectRequisitionData.emEpbMainsectionId = UtilSql.getValue(result, "em_epb_mainsection_id");
        objectRequisitionData.emEpbSubsectionId = UtilSql.getValue(result, "em_epb_subsection_id");
        objectRequisitionData.emEpbSubtasksId = UtilSql.getValue(result, "em_epb_subtasks_id");
        objectRequisitionData.emPcIscheck = UtilSql.getValue(result, "em_pc_ischeck");
        objectRequisitionData.createpo = UtilSql.getValue(result, "createpo");
        objectRequisitionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRequisitionData.processed = UtilSql.getValue(result, "processed");
        objectRequisitionData.mRequisitionId = UtilSql.getValue(result, "m_requisition_id");
        objectRequisitionData.processing = UtilSql.getValue(result, "processing");
        objectRequisitionData.isactive = UtilSql.getValue(result, "isactive");
        objectRequisitionData.language = UtilSql.getValue(result, "language");
        objectRequisitionData.adUserClient = "";
        objectRequisitionData.adOrgClient = "";
        objectRequisitionData.createdby = "";
        objectRequisitionData.trBgcolor = "";
        objectRequisitionData.totalCount = "";
        objectRequisitionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRequisitionData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    RequisitionData objectRequisitionData[] = new RequisitionData[vector.size()];
    vector.copyInto(objectRequisitionData);
    return(objectRequisitionData);
  }

/**
Create a registry
 */
  public static RequisitionData[] set(String createpo, String docstatus, String docaction, String docactionBtn, String processed, String adUserId, String processing, String emEpbMainsectionId, String mRequisitionId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String description, String documentno, String cBpartnerId, String cBpartnerIdr, String mPricelistId, String cCurrencyId, String emDtProjectId, String emDtProjectIdr, String emEpbSubtasksId, String emEpbSubsectionId, String emPcProjectId, String emPcIscheck)    throws ServletException {
    RequisitionData objectRequisitionData[] = new RequisitionData[1];
    objectRequisitionData[0] = new RequisitionData();
    objectRequisitionData[0].created = "";
    objectRequisitionData[0].createdbyr = createdbyr;
    objectRequisitionData[0].updated = "";
    objectRequisitionData[0].updatedTimeStamp = "";
    objectRequisitionData[0].updatedby = updatedby;
    objectRequisitionData[0].updatedbyr = updatedbyr;
    objectRequisitionData[0].adOrgId = adOrgId;
    objectRequisitionData[0].adOrgIdr = "";
    objectRequisitionData[0].documentno = documentno;
    objectRequisitionData[0].emDtProjectId = emDtProjectId;
    objectRequisitionData[0].emDtProjectIdr = emDtProjectIdr;
    objectRequisitionData[0].description = description;
    objectRequisitionData[0].cBpartnerId = cBpartnerId;
    objectRequisitionData[0].cBpartnerIdr = cBpartnerIdr;
    objectRequisitionData[0].adUserId = adUserId;
    objectRequisitionData[0].adUserIdr = "";
    objectRequisitionData[0].mPricelistId = mPricelistId;
    objectRequisitionData[0].mPricelistIdr = "";
    objectRequisitionData[0].cCurrencyId = cCurrencyId;
    objectRequisitionData[0].cCurrencyIdr = "";
    objectRequisitionData[0].docaction = docaction;
    objectRequisitionData[0].docactionBtn = docactionBtn;
    objectRequisitionData[0].docstatus = docstatus;
    objectRequisitionData[0].emPcProjectId = emPcProjectId;
    objectRequisitionData[0].emPcProjectIdr = "";
    objectRequisitionData[0].emEpbMainsectionId = emEpbMainsectionId;
    objectRequisitionData[0].emEpbSubsectionId = emEpbSubsectionId;
    objectRequisitionData[0].emEpbSubtasksId = emEpbSubtasksId;
    objectRequisitionData[0].emPcIscheck = emPcIscheck;
    objectRequisitionData[0].createpo = createpo;
    objectRequisitionData[0].adClientId = adClientId;
    objectRequisitionData[0].processed = processed;
    objectRequisitionData[0].mRequisitionId = mRequisitionId;
    objectRequisitionData[0].processing = processing;
    objectRequisitionData[0].isactive = isactive;
    objectRequisitionData[0].language = "";
    return objectRequisitionData;
  }

/**
Select for auxiliar field
 */
  public static String selectActP1004400000_C_BPartner_ID(ConnectionProvider connectionProvider, String M_Requisition_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Requisition.C_Bpartner_Id FROM M_Requisition, (SELECT count(*) as SameBP FROM M_Requisition inner join M_requisitionLine ON M_Requisition.M_Requisition_id = M_requisitionLine.M_Requisition_id WHERE M_Requisition.c_bpartner_id = M_requisitionLine.c_bpartner_id AND M_Requisition.M_Requisition_id = ?) SameBP,  (SELECT count(*) as QtyLines FROM M_RequisitionLine WHERE M_RequisitionLine.M_Requisition_id=?) QtyLines  WHERE SameBP.SameBP = QtyLines.QtyLines AND M_Requisition.M_Requisition_id =? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectActP1004400000_M_PriceList_ID(ConnectionProvider connectionProvider, String M_Requisition_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Requisition.m_pricelist_id  FROM M_Requisition,       (SELECT count(*) as SamePL        FROM M_Requisition inner join M_requisitionLine ON M_Requisition.M_Requisition_id = M_requisitionLine.M_Requisition_id       WHERE M_Requisition.m_pricelist_id = M_requisitionLine.m_pricelist_id AND M_Requisition.M_Requisition_id = ?) SamePL,        (SELECT count(*) as QtyLines       FROM M_RequisitionLine       WHERE M_RequisitionLine.M_Requisition_id=?) QtyLines   WHERE SamePL.SamePL = QtyLines.QtyLines AND M_Requisition.M_Requisition_id =? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Requisition_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_pricelist_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef803534_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Createdby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef803536_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Updatedby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef803539_2(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as C_BPartner_ID FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table2 on (C_BPartner.C_BPartner_ID = table2.C_BPartner_ID) WHERE C_BPartner.isActive='Y' AND C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef982395F7004F4104A9469C94E6AF4D66_3(ConnectionProvider connectionProvider, String EM_DT_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))), '')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as EM_DT_Project_ID FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table2 on (C_Project.C_Project_ID = table2.C_Project_ID) WHERE C_Project.isActive='Y' AND C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, EM_DT_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "em_dt_project_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String mRequisitionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Requisition" +
      "        SET docaction = ? " +
      "        WHERE M_Requisition.M_Requisition_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for action search
 */
  public static String selectActDefC_BPartner_ID(ConnectionProvider connectionProvider, String C_BPartner_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Name FROM C_BPartner WHERE isActive='Y' AND C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Requisition" +
      "        SET AD_Org_ID = (?) , DocumentNo = (?) , EM_DT_Project_ID = (?) , Description = (?) , C_BPartner_ID = (?) , AD_User_ID = (?) , M_PriceList_ID = (?) , C_Currency_ID = (?) , DocAction = (?) , DocStatus = (?) , EM_Pc_Project_ID = (?) , EM_Epb_Mainsection_ID = (?) , EM_Epb_Subsection_ID = (?) , EM_Epb_Subtasks_ID = (?) , EM_Pc_Ischeck = (?) , Createpo = (?) , AD_Client_ID = (?) , Processed = (?) , M_Requisition_ID = (?) , Processing = (?) , IsActive = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Requisition.M_Requisition_ID = ? " +
      "        AND M_Requisition.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Requisition.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emPcProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbMainsectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbSubsectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbSubtasksId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emPcIscheck);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_Requisition " +
      "        (AD_Org_ID, DocumentNo, EM_DT_Project_ID, Description, C_BPartner_ID, AD_User_ID, M_PriceList_ID, C_Currency_ID, DocAction, DocStatus, EM_Pc_Project_ID, EM_Epb_Mainsection_ID, EM_Epb_Subsection_ID, EM_Epb_Subtasks_ID, EM_Pc_Ischeck, Createpo, AD_Client_ID, Processed, M_Requisition_ID, Processing, IsActive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emPcProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbMainsectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbSubsectionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emEpbSubtasksId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emPcIscheck);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Requisition" +
      "        WHERE M_Requisition.M_Requisition_ID = ? " +
      "        AND M_Requisition.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Requisition.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM M_Requisition" +
      "         WHERE M_Requisition.M_Requisition_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM M_Requisition" +
      "         WHERE M_Requisition.M_Requisition_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}

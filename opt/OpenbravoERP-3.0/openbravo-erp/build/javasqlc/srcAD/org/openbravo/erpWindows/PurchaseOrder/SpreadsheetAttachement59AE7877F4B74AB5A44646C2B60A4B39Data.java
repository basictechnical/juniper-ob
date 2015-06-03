//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PurchaseOrder;

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
class SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String filename;
  public String associateboq;
  public String description;
  public String boqimport;
  public String importfiletype;
  public String orderline;
  public String fileView;
  public String cOrderId;
  public String copno;
  public String copamount;
  public String copstatus;
  public String copapprove;
  public String copreject;
  public String copsentapprove;
  public String filetype;
  public String filetyper;
  public String paymenttype;
  public String paymenttyper;
  public String advancetype;
  public String advancetyper;
  public String createcop;
  public String usdamt;
  public String conversionrate;
  public String emJcmDolsInvoice;
  public String emJcmClaimedInvoiceamt;
  public String emJcmDorbInvoice;
  public String emJcmAdvancetotal;
  public String emJcmNettotal;
  public String emJcmRecoverytotal;
  public String dtpoPocopfileId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("filename"))
      return filename;
    else if (fieldName.equalsIgnoreCase("associateboq"))
      return associateboq;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("boqimport"))
      return boqimport;
    else if (fieldName.equalsIgnoreCase("importfiletype"))
      return importfiletype;
    else if (fieldName.equalsIgnoreCase("orderline"))
      return orderline;
    else if (fieldName.equalsIgnoreCase("file_view") || fieldName.equals("fileView"))
      return fileView;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("copno"))
      return copno;
    else if (fieldName.equalsIgnoreCase("copamount"))
      return copamount;
    else if (fieldName.equalsIgnoreCase("copstatus"))
      return copstatus;
    else if (fieldName.equalsIgnoreCase("copapprove"))
      return copapprove;
    else if (fieldName.equalsIgnoreCase("copreject"))
      return copreject;
    else if (fieldName.equalsIgnoreCase("copsentapprove"))
      return copsentapprove;
    else if (fieldName.equalsIgnoreCase("filetype"))
      return filetype;
    else if (fieldName.equalsIgnoreCase("filetyper"))
      return filetyper;
    else if (fieldName.equalsIgnoreCase("paymenttype"))
      return paymenttype;
    else if (fieldName.equalsIgnoreCase("paymenttyper"))
      return paymenttyper;
    else if (fieldName.equalsIgnoreCase("advancetype"))
      return advancetype;
    else if (fieldName.equalsIgnoreCase("advancetyper"))
      return advancetyper;
    else if (fieldName.equalsIgnoreCase("createcop"))
      return createcop;
    else if (fieldName.equalsIgnoreCase("usdamt"))
      return usdamt;
    else if (fieldName.equalsIgnoreCase("conversionrate"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("em_jcm_dols_invoice") || fieldName.equals("emJcmDolsInvoice"))
      return emJcmDolsInvoice;
    else if (fieldName.equalsIgnoreCase("em_jcm_claimed_invoiceamt") || fieldName.equals("emJcmClaimedInvoiceamt"))
      return emJcmClaimedInvoiceamt;
    else if (fieldName.equalsIgnoreCase("em_jcm_dorb_invoice") || fieldName.equals("emJcmDorbInvoice"))
      return emJcmDorbInvoice;
    else if (fieldName.equalsIgnoreCase("em_jcm_advancetotal") || fieldName.equals("emJcmAdvancetotal"))
      return emJcmAdvancetotal;
    else if (fieldName.equalsIgnoreCase("em_jcm_nettotal") || fieldName.equals("emJcmNettotal"))
      return emJcmNettotal;
    else if (fieldName.equalsIgnoreCase("em_jcm_recoverytotal") || fieldName.equals("emJcmRecoverytotal"))
      return emJcmRecoverytotal;
    else if (fieldName.equalsIgnoreCase("dtpo_pocopfile_id") || fieldName.equals("dtpoPocopfileId"))
      return dtpoPocopfileId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(DTPO_Pocopfile.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = DTPO_Pocopfile.CreatedBy) as CreatedByR, " +
      "        to_char(DTPO_Pocopfile.Updated, ?) as updated, " +
      "        to_char(DTPO_Pocopfile.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        DTPO_Pocopfile.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = DTPO_Pocopfile.UpdatedBy) as UpdatedByR," +
      "        DTPO_Pocopfile.AD_Org_ID, " +
      "(CASE WHEN DTPO_Pocopfile.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(DTPO_Pocopfile.Isactive, 'N') AS Isactive, " +
      "DTPO_Pocopfile.Filename, " +
      "DTPO_Pocopfile.Associateboq, " +
      "DTPO_Pocopfile.Description, " +
      "COALESCE(DTPO_Pocopfile.Boqimport, 'N') AS Boqimport, " +
      "DTPO_Pocopfile.Importfiletype, " +
      "DTPO_Pocopfile.Orderline, " +
      "DTPO_Pocopfile.File_View, " +
      "DTPO_Pocopfile.C_Order_ID, " +
      "DTPO_Pocopfile.Copno, " +
      "DTPO_Pocopfile.Copamount, " +
      "DTPO_Pocopfile.Copstatus, " +
      "DTPO_Pocopfile.Copapprove, " +
      "DTPO_Pocopfile.Copreject, " +
      "DTPO_Pocopfile.Copsentapprove, " +
      "DTPO_Pocopfile.Filetype, " +
      "(CASE WHEN DTPO_Pocopfile.Filetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS FiletypeR, " +
      "DTPO_Pocopfile.Paymenttype, " +
      "(CASE WHEN DTPO_Pocopfile.Paymenttype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS PaymenttypeR, " +
      "DTPO_Pocopfile.Advancetype, " +
      "(CASE WHEN DTPO_Pocopfile.Advancetype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS AdvancetypeR, " +
      "DTPO_Pocopfile.Createcop, " +
      "DTPO_Pocopfile.Usdamt, " +
      "DTPO_Pocopfile.Conversionrate, " +
      "DTPO_Pocopfile.EM_Jcm_Dols_Invoice, " +
      "DTPO_Pocopfile.EM_Jcm_Claimed_Invoiceamt, " +
      "DTPO_Pocopfile.EM_Jcm_Dorb_Invoice, " +
      "DTPO_Pocopfile.EM_Jcm_Advancetotal, " +
      "DTPO_Pocopfile.EM_Jcm_Nettotal, " +
      "DTPO_Pocopfile.EM_Jcm_Recoverytotal, " +
      "DTPO_Pocopfile.Dtpo_Pocopfile_ID, " +
      "DTPO_Pocopfile.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM DTPO_Pocopfile left join (select AD_Org_ID, Name from AD_Org) table1 on (DTPO_Pocopfile.AD_Org_ID = table1.AD_Org_ID) left join ad_ref_list_v list1 on (DTPO_Pocopfile.Filetype = list1.value and list1.ad_reference_id = 'DFD16360C7334C978D1762D663D69983' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (DTPO_Pocopfile.Paymenttype = list2.value and list2.ad_reference_id = '8F67BB07A9514E018722466A10D77451' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (DTPO_Pocopfile.Advancetype = list3.value and list3.ad_reference_id = '916DE3645158498590BAD49ED98F2EE2' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND DTPO_Pocopfile.C_Order_ID = ?  ");
    strSql = strSql + 
      "        AND DTPO_Pocopfile.Dtpo_Pocopfile_ID = ? " +
      "        AND DTPO_Pocopfile.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND DTPO_Pocopfile.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cOrderId != null && !(cOrderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      }
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
        SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data();
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.created = UtilSql.getValue(result, "created");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.updated = UtilSql.getValue(result, "updated");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.isactive = UtilSql.getValue(result, "isactive");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.filename = UtilSql.getValue(result, "filename");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.associateboq = UtilSql.getValue(result, "associateboq");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.description = UtilSql.getValue(result, "description");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.boqimport = UtilSql.getValue(result, "boqimport");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.importfiletype = UtilSql.getValue(result, "importfiletype");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.orderline = UtilSql.getValue(result, "orderline");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.fileView = UtilSql.getValue(result, "file_view");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copno = UtilSql.getValue(result, "copno");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copamount = UtilSql.getValue(result, "copamount");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copstatus = UtilSql.getValue(result, "copstatus");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copapprove = UtilSql.getValue(result, "copapprove");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copreject = UtilSql.getValue(result, "copreject");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.copsentapprove = UtilSql.getValue(result, "copsentapprove");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.filetype = UtilSql.getValue(result, "filetype");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.filetyper = UtilSql.getValue(result, "filetyper");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.paymenttype = UtilSql.getValue(result, "paymenttype");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.paymenttyper = UtilSql.getValue(result, "paymenttyper");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.advancetype = UtilSql.getValue(result, "advancetype");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.advancetyper = UtilSql.getValue(result, "advancetyper");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.createcop = UtilSql.getValue(result, "createcop");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.usdamt = UtilSql.getValue(result, "usdamt");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.conversionrate = UtilSql.getValue(result, "conversionrate");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmDolsInvoice = UtilSql.getDateValue(result, "em_jcm_dols_invoice", "dd-MM-yyyy");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmClaimedInvoiceamt = UtilSql.getValue(result, "em_jcm_claimed_invoiceamt");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmDorbInvoice = UtilSql.getDateValue(result, "em_jcm_dorb_invoice", "dd-MM-yyyy");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmAdvancetotal = UtilSql.getValue(result, "em_jcm_advancetotal");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmNettotal = UtilSql.getValue(result, "em_jcm_nettotal");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.emJcmRecoverytotal = UtilSql.getValue(result, "em_jcm_recoverytotal");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.dtpoPocopfileId = UtilSql.getValue(result, "dtpo_pocopfile_id");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.language = UtilSql.getValue(result, "language");
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.adUserClient = "";
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.adOrgClient = "";
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.createdby = "";
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.trBgcolor = "";
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.totalCount = "";
        objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data);
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
    SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[vector.size()];
    vector.copyInto(objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data);
    return(objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data);
  }

/**
Create a registry
 */
  public static SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] set(String cOrderId, String emJcmNettotal, String copstatus, String copamount, String filename, String fileView, String copreject, String paymenttype, String advancetype, String importfiletype, String createdby, String createdbyr, String emJcmClaimedInvoiceamt, String copno, String createcop, String dtpoPocopfileId, String boqimport, String copapprove, String emJcmDorbInvoice, String associateboq, String adClientId, String emJcmDolsInvoice, String isactive, String updatedby, String updatedbyr, String emJcmRecoverytotal, String description, String orderline, String adOrgId, String emJcmAdvancetotal, String filetype, String usdamt, String conversionrate, String copsentapprove)    throws ServletException {
    SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[] = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[1];
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0] = new SpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data();
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].created = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].createdbyr = createdbyr;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].updated = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].updatedTimeStamp = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].updatedby = updatedby;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].updatedbyr = updatedbyr;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].adOrgId = adOrgId;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].adOrgIdr = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].isactive = isactive;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].filename = filename;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].associateboq = associateboq;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].description = description;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].boqimport = boqimport;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].importfiletype = importfiletype;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].orderline = orderline;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].fileView = fileView;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].cOrderId = cOrderId;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copno = copno;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copamount = copamount;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copstatus = copstatus;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copapprove = copapprove;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copreject = copreject;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].copsentapprove = copsentapprove;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].filetype = filetype;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].filetyper = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].paymenttype = paymenttype;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].paymenttyper = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].advancetype = advancetype;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].advancetyper = "";
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].createcop = createcop;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].usdamt = usdamt;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].conversionrate = conversionrate;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmDolsInvoice = emJcmDolsInvoice;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmClaimedInvoiceamt = emJcmClaimedInvoiceamt;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmDorbInvoice = emJcmDorbInvoice;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmAdvancetotal = emJcmAdvancetotal;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmNettotal = emJcmNettotal;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].emJcmRecoverytotal = emJcmRecoverytotal;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].dtpoPocopfileId = dtpoPocopfileId;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].adClientId = adClientId;
    objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data[0].language = "";
    return objectSpreadsheetAttachement59AE7877F4B74AB5A44646C2B60A4B39Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef426601B5F4A14310ADD8C542B6159675_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA2E2FD14B85643F5B6BDF7F0DEC12E44_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DTPO_Pocopfile.C_Order_ID AS NAME" +
      "        FROM DTPO_Pocopfile" +
      "        WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
      "        UPDATE DTPO_Pocopfile" +
      "        SET AD_Org_ID = (?) , Isactive = (?) , Filename = (?) , Associateboq = (?) , Description = (?) , Boqimport = (?) , Importfiletype = (?) , Orderline = (?) , File_View = (?) , C_Order_ID = (?) , Copno = (?) , Copamount = TO_NUMBER(?) , Copstatus = (?) , Copapprove = (?) , Copreject = (?) , Copsentapprove = (?) , Filetype = (?) , Paymenttype = (?) , Advancetype = (?) , Createcop = (?) , Usdamt = TO_NUMBER(?) , Conversionrate = TO_NUMBER(?) , EM_Jcm_Dols_Invoice = TO_DATE(?) , EM_Jcm_Claimed_Invoiceamt = TO_NUMBER(?) , EM_Jcm_Dorb_Invoice = TO_DATE(?) , EM_Jcm_Advancetotal = TO_NUMBER(?) , EM_Jcm_Nettotal = TO_NUMBER(?) , EM_Jcm_Recoverytotal = TO_NUMBER(?) , Dtpo_Pocopfile_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ? " +
      "                 AND DTPO_Pocopfile.C_Order_ID = ? " +
      "        AND DTPO_Pocopfile.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DTPO_Pocopfile.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, associateboq);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, boqimport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, importfiletype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fileView);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copapprove);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copreject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copsentapprove);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, advancetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createcop);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usdamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmDolsInvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmClaimedInvoiceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmDorbInvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmAdvancetotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmNettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmRecoverytotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "        INSERT INTO DTPO_Pocopfile " +
      "        (AD_Org_ID, Isactive, Filename, Associateboq, Description, Boqimport, Importfiletype, Orderline, File_View, C_Order_ID, Copno, Copamount, Copstatus, Copapprove, Copreject, Copsentapprove, Filetype, Paymenttype, Advancetype, Createcop, Usdamt, Conversionrate, EM_Jcm_Dols_Invoice, EM_Jcm_Claimed_Invoiceamt, EM_Jcm_Dorb_Invoice, EM_Jcm_Advancetotal, EM_Jcm_Nettotal, EM_Jcm_Recoverytotal, Dtpo_Pocopfile_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, associateboq);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, boqimport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, importfiletype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fileView);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copapprove);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copreject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copsentapprove);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, advancetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createcop);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usdamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmDolsInvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmClaimedInvoiceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmDorbInvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmAdvancetotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmNettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emJcmRecoverytotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cOrderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM DTPO_Pocopfile" +
      "        WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ? " +
      "                 AND DTPO_Pocopfile.C_Order_ID = ? " +
      "        AND DTPO_Pocopfile.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DTPO_Pocopfile.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "          FROM DTPO_Pocopfile" +
      "         WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ? ";

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
      "          FROM DTPO_Pocopfile" +
      "         WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ? ";

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

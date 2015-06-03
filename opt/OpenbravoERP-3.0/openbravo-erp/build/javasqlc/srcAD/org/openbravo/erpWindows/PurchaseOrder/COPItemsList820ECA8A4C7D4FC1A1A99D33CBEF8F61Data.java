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
class COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data implements FieldProvider {
static Logger log4j = Logger.getLogger(COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String dtpoPocopfileId;
  public String isactive;
  public String productname;
  public String productqty;
  public String copamt;
  public String damagedReturned;
  public String searchkey;
  public String cOrderlineId;
  public String attributename;
  public String grnquantity;
  public String totalquantity;
  public String certfdcopamt;
  public String totallineamt;
  public String balancecopamt;
  public String coppercentage;
  public String approvecop;
  public String copbasic;
  public String copinsurance;
  public String copfreight;
  public String copothers;
  public String coppkgFwdg;
  public String copexcise;
  public String copsubtotal;
  public String copvatCst;
  public String copoctroiLbt;
  public String adClientId;
  public String dtpoItemcopId;
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
    else if (fieldName.equalsIgnoreCase("dtpo_pocopfile_id") || fieldName.equals("dtpoPocopfileId"))
      return dtpoPocopfileId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("productname"))
      return productname;
    else if (fieldName.equalsIgnoreCase("productqty"))
      return productqty;
    else if (fieldName.equalsIgnoreCase("copamt"))
      return copamt;
    else if (fieldName.equalsIgnoreCase("damaged_returned") || fieldName.equals("damagedReturned"))
      return damagedReturned;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("attributename"))
      return attributename;
    else if (fieldName.equalsIgnoreCase("grnquantity"))
      return grnquantity;
    else if (fieldName.equalsIgnoreCase("totalquantity"))
      return totalquantity;
    else if (fieldName.equalsIgnoreCase("certfdcopamt"))
      return certfdcopamt;
    else if (fieldName.equalsIgnoreCase("totallineamt"))
      return totallineamt;
    else if (fieldName.equalsIgnoreCase("balancecopamt"))
      return balancecopamt;
    else if (fieldName.equalsIgnoreCase("coppercentage"))
      return coppercentage;
    else if (fieldName.equalsIgnoreCase("approvecop"))
      return approvecop;
    else if (fieldName.equalsIgnoreCase("copbasic"))
      return copbasic;
    else if (fieldName.equalsIgnoreCase("copinsurance"))
      return copinsurance;
    else if (fieldName.equalsIgnoreCase("copfreight"))
      return copfreight;
    else if (fieldName.equalsIgnoreCase("copothers"))
      return copothers;
    else if (fieldName.equalsIgnoreCase("coppkg_fwdg") || fieldName.equals("coppkgFwdg"))
      return coppkgFwdg;
    else if (fieldName.equalsIgnoreCase("copexcise"))
      return copexcise;
    else if (fieldName.equalsIgnoreCase("copsubtotal"))
      return copsubtotal;
    else if (fieldName.equalsIgnoreCase("copvat_cst") || fieldName.equals("copvatCst"))
      return copvatCst;
    else if (fieldName.equalsIgnoreCase("copoctroi_lbt") || fieldName.equals("copoctroiLbt"))
      return copoctroiLbt;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dtpo_itemcop_id") || fieldName.equals("dtpoItemcopId"))
      return dtpoItemcopId;
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
  public static COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String dtpoPocopfileId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, dtpoPocopfileId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String dtpoPocopfileId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(DTPO_Itemcop.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = DTPO_Itemcop.CreatedBy) as CreatedByR, " +
      "        to_char(DTPO_Itemcop.Updated, ?) as updated, " +
      "        to_char(DTPO_Itemcop.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        DTPO_Itemcop.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = DTPO_Itemcop.UpdatedBy) as UpdatedByR," +
      "        DTPO_Itemcop.AD_Org_ID, " +
      "(CASE WHEN DTPO_Itemcop.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "DTPO_Itemcop.Dtpo_Pocopfile_ID, " +
      "COALESCE(DTPO_Itemcop.Isactive, 'N') AS Isactive, " +
      "DTPO_Itemcop.Productname, " +
      "DTPO_Itemcop.Productqty, " +
      "DTPO_Itemcop.Copamt, " +
      "DTPO_Itemcop.Damaged_Returned, " +
      "DTPO_Itemcop.Searchkey, " +
      "DTPO_Itemcop.C_Orderline_ID, " +
      "DTPO_Itemcop.Attributename, " +
      "DTPO_Itemcop.Grnquantity, " +
      "DTPO_Itemcop.Totalquantity, " +
      "DTPO_Itemcop.Certfdcopamt, " +
      "DTPO_Itemcop.Totallineamt, " +
      "DTPO_Itemcop.Balancecopamt, " +
      "DTPO_Itemcop.Coppercentage, " +
      "DTPO_Itemcop.Approvecop, " +
      "DTPO_Itemcop.Copbasic, " +
      "DTPO_Itemcop.Copinsurance, " +
      "DTPO_Itemcop.Copfreight, " +
      "DTPO_Itemcop.Copothers, " +
      "DTPO_Itemcop.Coppkg_Fwdg, " +
      "DTPO_Itemcop.Copexcise, " +
      "DTPO_Itemcop.Copsubtotal, " +
      "DTPO_Itemcop.Copvat_Cst, " +
      "DTPO_Itemcop.Copoctroi_Lbt, " +
      "DTPO_Itemcop.AD_Client_ID, " +
      "DTPO_Itemcop.Dtpo_Itemcop_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM DTPO_Itemcop left join (select AD_Org_ID, Name from AD_Org) table1 on (DTPO_Itemcop.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((dtpoPocopfileId==null || dtpoPocopfileId.equals(""))?"":"  AND DTPO_Itemcop.Dtpo_Pocopfile_ID = ?  ");
    strSql = strSql + 
      "        AND DTPO_Itemcop.Dtpo_Itemcop_ID = ? " +
      "        AND DTPO_Itemcop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND DTPO_Itemcop.AD_Org_ID IN (";
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
      if (dtpoPocopfileId != null && !(dtpoPocopfileId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
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
        COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data();
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.created = UtilSql.getValue(result, "created");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.updated = UtilSql.getValue(result, "updated");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.dtpoPocopfileId = UtilSql.getValue(result, "dtpo_pocopfile_id");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.isactive = UtilSql.getValue(result, "isactive");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.productname = UtilSql.getValue(result, "productname");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.productqty = UtilSql.getValue(result, "productqty");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copamt = UtilSql.getValue(result, "copamt");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.damagedReturned = UtilSql.getValue(result, "damaged_returned");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.searchkey = UtilSql.getValue(result, "searchkey");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.attributename = UtilSql.getValue(result, "attributename");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.grnquantity = UtilSql.getValue(result, "grnquantity");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.totalquantity = UtilSql.getValue(result, "totalquantity");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.certfdcopamt = UtilSql.getValue(result, "certfdcopamt");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.totallineamt = UtilSql.getValue(result, "totallineamt");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.balancecopamt = UtilSql.getValue(result, "balancecopamt");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.coppercentage = UtilSql.getValue(result, "coppercentage");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.approvecop = UtilSql.getValue(result, "approvecop");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copbasic = UtilSql.getValue(result, "copbasic");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copinsurance = UtilSql.getValue(result, "copinsurance");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copfreight = UtilSql.getValue(result, "copfreight");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copothers = UtilSql.getValue(result, "copothers");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.coppkgFwdg = UtilSql.getValue(result, "coppkg_fwdg");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copexcise = UtilSql.getValue(result, "copexcise");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copsubtotal = UtilSql.getValue(result, "copsubtotal");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copvatCst = UtilSql.getValue(result, "copvat_cst");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.copoctroiLbt = UtilSql.getValue(result, "copoctroi_lbt");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.dtpoItemcopId = UtilSql.getValue(result, "dtpo_itemcop_id");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.language = UtilSql.getValue(result, "language");
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.adUserClient = "";
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.adOrgClient = "";
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.createdby = "";
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.trBgcolor = "";
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.totalCount = "";
        objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data);
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
    COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[vector.size()];
    vector.copyInto(objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data);
    return(objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data);
  }

/**
Create a registry
 */
  public static COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] set(String dtpoPocopfileId, String coppkgFwdg, String certfdcopamt, String copbasic, String copinsurance, String copothers, String attributename, String updatedby, String updatedbyr, String copoctroiLbt, String isactive, String createdby, String createdbyr, String copvatCst, String adClientId, String totalquantity, String totallineamt, String damagedReturned, String copfreight, String cOrderlineId, String copsubtotal, String dtpoItemcopId, String copexcise, String grnquantity, String adOrgId, String productqty, String coppercentage, String approvecop, String copamt, String searchkey, String balancecopamt, String productname)    throws ServletException {
    COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[] = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[1];
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0] = new COPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data();
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].created = "";
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].createdbyr = createdbyr;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].updated = "";
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].updatedTimeStamp = "";
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].updatedby = updatedby;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].updatedbyr = updatedbyr;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].adOrgId = adOrgId;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].adOrgIdr = "";
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].dtpoPocopfileId = dtpoPocopfileId;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].isactive = isactive;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].productname = productname;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].productqty = productqty;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copamt = copamt;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].damagedReturned = damagedReturned;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].searchkey = searchkey;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].cOrderlineId = cOrderlineId;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].attributename = attributename;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].grnquantity = grnquantity;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].totalquantity = totalquantity;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].certfdcopamt = certfdcopamt;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].totallineamt = totallineamt;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].balancecopamt = balancecopamt;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].coppercentage = coppercentage;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].approvecop = approvecop;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copbasic = copbasic;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copinsurance = copinsurance;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copfreight = copfreight;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copothers = copothers;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].coppkgFwdg = coppkgFwdg;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copexcise = copexcise;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copsubtotal = copsubtotal;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copvatCst = copvatCst;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].copoctroiLbt = copoctroiLbt;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].adClientId = adClientId;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].dtpoItemcopId = dtpoItemcopId;
    objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data[0].language = "";
    return objectCOPItemsList820ECA8A4C7D4FC1A1A99D33CBEF8F61Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef34CD32A7866548F2B855C5EA3C2E0193_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef3822D00B7E564D4C88015453A7351207_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DTPO_Itemcop.Dtpo_Pocopfile_ID AS NAME" +
      "        FROM DTPO_Itemcop" +
      "        WHERE DTPO_Itemcop.Dtpo_Itemcop_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String dtpoPocopfileId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Copno), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Copamount), ''))) AS NAME FROM DTPO_Pocopfile left join (select Dtpo_Pocopfile_ID, Copno, Copamount from Dtpo_Pocopfile) table1 on (DTPO_Pocopfile.Dtpo_Pocopfile_ID = table1.Dtpo_Pocopfile_ID) WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String dtpoPocopfileId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Copno), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Copamount), ''))) AS NAME FROM DTPO_Pocopfile left join (select Dtpo_Pocopfile_ID, Copno, Copamount from Dtpo_Pocopfile) table1 on (DTPO_Pocopfile.Dtpo_Pocopfile_ID = table1.Dtpo_Pocopfile_ID) WHERE DTPO_Pocopfile.Dtpo_Pocopfile_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);

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
      "        UPDATE DTPO_Itemcop" +
      "        SET AD_Org_ID = (?) , Dtpo_Pocopfile_ID = (?) , Isactive = (?) , Productname = (?) , Productqty = TO_NUMBER(?) , Copamt = TO_NUMBER(?) , Damaged_Returned = TO_NUMBER(?) , Searchkey = (?) , C_Orderline_ID = (?) , Attributename = (?) , Grnquantity = TO_NUMBER(?) , Totalquantity = TO_NUMBER(?) , Certfdcopamt = TO_NUMBER(?) , Totallineamt = TO_NUMBER(?) , Balancecopamt = TO_NUMBER(?) , Coppercentage = TO_NUMBER(?) , Approvecop = (?) , Copbasic = TO_NUMBER(?) , Copinsurance = TO_NUMBER(?) , Copfreight = TO_NUMBER(?) , Copothers = TO_NUMBER(?) , Coppkg_Fwdg = TO_NUMBER(?) , Copexcise = TO_NUMBER(?) , Copsubtotal = TO_NUMBER(?) , Copvat_Cst = TO_NUMBER(?) , Copoctroi_Lbt = TO_NUMBER(?) , AD_Client_ID = (?) , Dtpo_Itemcop_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE DTPO_Itemcop.Dtpo_Itemcop_ID = ? " +
      "                 AND DTPO_Itemcop.Dtpo_Pocopfile_ID = ? " +
      "        AND DTPO_Itemcop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DTPO_Itemcop.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, damagedReturned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, searchkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attributename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grnquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, certfdcopamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, balancecopamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coppercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, approvecop);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copbasic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copinsurance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copfreight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copothers);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coppkgFwdg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copexcise);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copsubtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copvatCst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copoctroiLbt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoItemcopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoItemcopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
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
      "        INSERT INTO DTPO_Itemcop " +
      "        (AD_Org_ID, Dtpo_Pocopfile_ID, Isactive, Productname, Productqty, Copamt, Damaged_Returned, Searchkey, C_Orderline_ID, Attributename, Grnquantity, Totalquantity, Certfdcopamt, Totallineamt, Balancecopamt, Coppercentage, Approvecop, Copbasic, Copinsurance, Copfreight, Copothers, Coppkg_Fwdg, Copexcise, Copsubtotal, Copvat_Cst, Copoctroi_Lbt, AD_Client_ID, Dtpo_Itemcop_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, damagedReturned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, searchkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attributename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grnquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, certfdcopamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, balancecopamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coppercentage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, approvecop);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copbasic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copinsurance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copfreight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copothers);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coppkgFwdg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copexcise);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copsubtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copvatCst);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copoctroiLbt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoItemcopId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String dtpoPocopfileId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM DTPO_Itemcop" +
      "        WHERE DTPO_Itemcop.Dtpo_Itemcop_ID = ? " +
      "                 AND DTPO_Itemcop.Dtpo_Pocopfile_ID = ? " +
      "        AND DTPO_Itemcop.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND DTPO_Itemcop.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dtpoPocopfileId);
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
      "          FROM DTPO_Itemcop" +
      "         WHERE DTPO_Itemcop.Dtpo_Itemcop_ID = ? ";

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
      "          FROM DTPO_Itemcop" +
      "         WHERE DTPO_Itemcop.Dtpo_Itemcop_ID = ? ";

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

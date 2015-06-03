//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.MultiphaseProject;

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
class MultiphaseProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(MultiphaseProjectData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String issummary;
  public String setprojecttype;
  public String projectstatus;
  public String cProjecttypeId;
  public String cProjectphaseId;
  public String startdate;
  public String datecontract;
  public String datefinish;
  public String description;
  public String salesrepId;
  public String responsibleId;
  public String iscommitment;
  public String iscommitceiling;
  public String committedamt;
  public String committedqty;
  public String servrevenue;
  public String expexpenses;
  public String servsercost;
  public String servoutcost;
  public String servcost;
  public String expreinvoicing;
  public String servmargin;
  public String expmargin;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String adUserId;
  public String poreference;
  public String finPaymentmethodId;
  public String finPaymentmethodIdr;
  public String cPaymenttermId;
  public String mPricelistId;
  public String cCurrencyId;
  public String mWarehouseId;
  public String changeprojectstatus;
  public String copyfrom;
  public String emDtzkAssociatepb;
  public String emDtzkAssociatecostbudget;
  public String emDtzkFilename;
  public String emDtzkCostbudgetview;
  public String projectkind;
  public String projectbalanceamt;
  public String publicprivate;
  public String billtoId;
  public String accountno;
  public String documentCopies;
  public String paymentrule;
  public String invoiceToproject;
  public String cLocationId;
  public String plannedpoamt;
  public String lastplannedproposaldate;
  public String invoicedqty;
  public String createtemppricelist;
  public String cPhaseId;
  public String invoicedamt;
  public String cCampaignId;
  public String plannedmarginamt;
  public String plannedamt;
  public String note;
  public String mPricelistVersionId;
  public String plannedqty;
  public String processed;
  public String processing;
  public String isactive;
  public String generateto;
  public String generateorder;
  public String adClientId;
  public String projectphase;
  public String cProjectId;
  public String projectcategory;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("setprojecttype"))
      return setprojecttype;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("c_projecttype_id") || fieldName.equals("cProjecttypeId"))
      return cProjecttypeId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("iscommitment"))
      return iscommitment;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("servrevenue"))
      return servrevenue;
    else if (fieldName.equalsIgnoreCase("expexpenses"))
      return expexpenses;
    else if (fieldName.equalsIgnoreCase("servsercost"))
      return servsercost;
    else if (fieldName.equalsIgnoreCase("servoutcost"))
      return servoutcost;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("expreinvoicing"))
      return expreinvoicing;
    else if (fieldName.equalsIgnoreCase("servmargin"))
      return servmargin;
    else if (fieldName.equalsIgnoreCase("expmargin"))
      return expmargin;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_idr") || fieldName.equals("finPaymentmethodIdr"))
      return finPaymentmethodIdr;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("changeprojectstatus"))
      return changeprojectstatus;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("em_dtzk_associatepb") || fieldName.equals("emDtzkAssociatepb"))
      return emDtzkAssociatepb;
    else if (fieldName.equalsIgnoreCase("em_dtzk_associatecostbudget") || fieldName.equals("emDtzkAssociatecostbudget"))
      return emDtzkAssociatecostbudget;
    else if (fieldName.equalsIgnoreCase("em_dtzk_filename") || fieldName.equals("emDtzkFilename"))
      return emDtzkFilename;
    else if (fieldName.equalsIgnoreCase("em_dtzk_costbudgetview") || fieldName.equals("emDtzkCostbudgetview"))
      return emDtzkCostbudgetview;
    else if (fieldName.equalsIgnoreCase("projectkind"))
      return projectkind;
    else if (fieldName.equalsIgnoreCase("projectbalanceamt"))
      return projectbalanceamt;
    else if (fieldName.equalsIgnoreCase("publicprivate"))
      return publicprivate;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("document_copies") || fieldName.equals("documentCopies"))
      return documentCopies;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("invoice_toproject") || fieldName.equals("invoiceToproject"))
      return invoiceToproject;
    else if (fieldName.equalsIgnoreCase("c_location_id") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("plannedpoamt"))
      return plannedpoamt;
    else if (fieldName.equalsIgnoreCase("lastplannedproposaldate"))
      return lastplannedproposaldate;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("createtemppricelist"))
      return createtemppricelist;
    else if (fieldName.equalsIgnoreCase("c_phase_id") || fieldName.equals("cPhaseId"))
      return cPhaseId;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("generateorder"))
      return generateorder;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("projectphase"))
      return projectphase;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
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
  public static MultiphaseProjectData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MultiphaseProjectData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Project.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.CreatedBy) as CreatedByR, " +
      "        to_char(C_Project.Updated, ?) as updated, " +
      "        to_char(C_Project.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Project.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Project.UpdatedBy) as UpdatedByR," +
      "        C_Project.AD_Org_ID, " +
      "(CASE WHEN C_Project.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Project.Value, " +
      "C_Project.Name, " +
      "COALESCE(C_Project.IsSummary, 'N') AS IsSummary, " +
      "C_Project.Setprojecttype, " +
      "C_Project.Projectstatus, " +
      "C_Project.C_ProjectType_ID, " +
      "C_Project.C_ProjectPhase_ID, " +
      "C_Project.Startdate, " +
      "C_Project.DateContract, " +
      "C_Project.DateFinish, " +
      "C_Project.Description, " +
      "C_Project.SalesRep_ID, " +
      "C_Project.Responsible_ID, " +
      "COALESCE(C_Project.IsCommitment, 'N') AS IsCommitment, " +
      "COALESCE(C_Project.IsCommitCeiling, 'N') AS IsCommitCeiling, " +
      "C_Project.CommittedAmt, " +
      "C_Project.CommittedQty, " +
      "C_Project.Servrevenue, " +
      "C_Project.Expexpenses, " +
      "C_Project.Servsercost, " +
      "C_Project.Servoutcost, " +
      "C_Project.Servcost, " +
      "C_Project.Expreinvoicing, " +
      "C_Project.Servmargin, " +
      "C_Project.Expmargin, " +
      "C_Project.C_BPartner_ID, " +
      "C_Project.C_BPartner_Location_ID, " +
      "C_Project.AD_User_ID, " +
      "C_Project.POReference, " +
      "C_Project.FIN_Paymentmethod_ID, " +
      "(CASE WHEN C_Project.FIN_Paymentmethod_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS FIN_Paymentmethod_IDR, " +
      "C_Project.C_PaymentTerm_ID, " +
      "C_Project.M_PriceList_ID, " +
      "C_Project.C_Currency_ID, " +
      "C_Project.M_Warehouse_ID, " +
      "C_Project.ChangeProjectStatus, " +
      "C_Project.CopyFrom, " +
      "C_Project.EM_Dtzk_Associatepb, " +
      "C_Project.EM_Dtzk_Associatecostbudget, " +
      "C_Project.EM_Dtzk_Filename, " +
      "C_Project.EM_Dtzk_Costbudgetview, " +
      "C_Project.Projectkind, " +
      "C_Project.ProjectBalanceAmt, " +
      "C_Project.Publicprivate, " +
      "C_Project.BillTo_ID, " +
      "C_Project.AccountNo, " +
      "C_Project.Document_Copies, " +
      "C_Project.PaymentRule, " +
      "COALESCE(C_Project.Invoice_ToProject, 'N') AS Invoice_ToProject, " +
      "C_Project.C_Location_ID, " +
      "C_Project.PlannedPOAmt, " +
      "C_Project.LastPlannedProposalDate, " +
      "C_Project.InvoicedQty, " +
      "COALESCE(C_Project.Createtemppricelist, 'N') AS Createtemppricelist, " +
      "C_Project.C_Phase_ID, " +
      "C_Project.InvoicedAmt, " +
      "C_Project.C_Campaign_ID, " +
      "C_Project.PlannedMarginAmt, " +
      "C_Project.PlannedAmt, " +
      "C_Project.Note, " +
      "C_Project.M_PriceList_Version_ID, " +
      "C_Project.PlannedQty, " +
      "COALESCE(C_Project.Processed, 'N') AS Processed, " +
      "C_Project.Processing, " +
      "COALESCE(C_Project.IsActive, 'N') AS IsActive, " +
      "C_Project.GenerateTo, " +
      "C_Project.GenerateOrder, " +
      "C_Project.AD_Client_ID, " +
      "C_Project.Projectphase, " +
      "C_Project.C_Project_ID, " +
      "C_Project.ProjectCategory, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Project left join (select AD_Org_ID, Name from AD_Org) table1 on (C_Project.AD_Org_ID = table1.AD_Org_ID) left join (select FIN_Paymentmethod_ID, Name from FIN_Paymentmethod) table2 on (C_Project.FIN_Paymentmethod_ID = table2.FIN_Paymentmethod_ID)" +
      "        WHERE 2=2 " +
      " AND C_Project.ProjectCategory='S'" +
      "        AND 1=1 " +
      "        AND C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Project.AD_Org_ID IN (";
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
        MultiphaseProjectData objectMultiphaseProjectData = new MultiphaseProjectData();
        objectMultiphaseProjectData.created = UtilSql.getValue(result, "created");
        objectMultiphaseProjectData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMultiphaseProjectData.updated = UtilSql.getValue(result, "updated");
        objectMultiphaseProjectData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMultiphaseProjectData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMultiphaseProjectData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMultiphaseProjectData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMultiphaseProjectData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMultiphaseProjectData.value = UtilSql.getValue(result, "value");
        objectMultiphaseProjectData.name = UtilSql.getValue(result, "name");
        objectMultiphaseProjectData.issummary = UtilSql.getValue(result, "issummary");
        objectMultiphaseProjectData.setprojecttype = UtilSql.getValue(result, "setprojecttype");
        objectMultiphaseProjectData.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectMultiphaseProjectData.cProjecttypeId = UtilSql.getValue(result, "c_projecttype_id");
        objectMultiphaseProjectData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectMultiphaseProjectData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectMultiphaseProjectData.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectMultiphaseProjectData.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectMultiphaseProjectData.description = UtilSql.getValue(result, "description");
        objectMultiphaseProjectData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectMultiphaseProjectData.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectMultiphaseProjectData.iscommitment = UtilSql.getValue(result, "iscommitment");
        objectMultiphaseProjectData.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectMultiphaseProjectData.committedamt = UtilSql.getValue(result, "committedamt");
        objectMultiphaseProjectData.committedqty = UtilSql.getValue(result, "committedqty");
        objectMultiphaseProjectData.servrevenue = UtilSql.getValue(result, "servrevenue");
        objectMultiphaseProjectData.expexpenses = UtilSql.getValue(result, "expexpenses");
        objectMultiphaseProjectData.servsercost = UtilSql.getValue(result, "servsercost");
        objectMultiphaseProjectData.servoutcost = UtilSql.getValue(result, "servoutcost");
        objectMultiphaseProjectData.servcost = UtilSql.getValue(result, "servcost");
        objectMultiphaseProjectData.expreinvoicing = UtilSql.getValue(result, "expreinvoicing");
        objectMultiphaseProjectData.servmargin = UtilSql.getValue(result, "servmargin");
        objectMultiphaseProjectData.expmargin = UtilSql.getValue(result, "expmargin");
        objectMultiphaseProjectData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMultiphaseProjectData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMultiphaseProjectData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectMultiphaseProjectData.poreference = UtilSql.getValue(result, "poreference");
        objectMultiphaseProjectData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectMultiphaseProjectData.finPaymentmethodIdr = UtilSql.getValue(result, "fin_paymentmethod_idr");
        objectMultiphaseProjectData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectMultiphaseProjectData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectMultiphaseProjectData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMultiphaseProjectData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMultiphaseProjectData.changeprojectstatus = UtilSql.getValue(result, "changeprojectstatus");
        objectMultiphaseProjectData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectMultiphaseProjectData.emDtzkAssociatepb = UtilSql.getValue(result, "em_dtzk_associatepb");
        objectMultiphaseProjectData.emDtzkAssociatecostbudget = UtilSql.getValue(result, "em_dtzk_associatecostbudget");
        objectMultiphaseProjectData.emDtzkFilename = UtilSql.getValue(result, "em_dtzk_filename");
        objectMultiphaseProjectData.emDtzkCostbudgetview = UtilSql.getValue(result, "em_dtzk_costbudgetview");
        objectMultiphaseProjectData.projectkind = UtilSql.getValue(result, "projectkind");
        objectMultiphaseProjectData.projectbalanceamt = UtilSql.getValue(result, "projectbalanceamt");
        objectMultiphaseProjectData.publicprivate = UtilSql.getValue(result, "publicprivate");
        objectMultiphaseProjectData.billtoId = UtilSql.getValue(result, "billto_id");
        objectMultiphaseProjectData.accountno = UtilSql.getValue(result, "accountno");
        objectMultiphaseProjectData.documentCopies = UtilSql.getValue(result, "document_copies");
        objectMultiphaseProjectData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectMultiphaseProjectData.invoiceToproject = UtilSql.getValue(result, "invoice_toproject");
        objectMultiphaseProjectData.cLocationId = UtilSql.getValue(result, "c_location_id");
        objectMultiphaseProjectData.plannedpoamt = UtilSql.getValue(result, "plannedpoamt");
        objectMultiphaseProjectData.lastplannedproposaldate = UtilSql.getDateValue(result, "lastplannedproposaldate", "dd-MM-yyyy");
        objectMultiphaseProjectData.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectMultiphaseProjectData.createtemppricelist = UtilSql.getValue(result, "createtemppricelist");
        objectMultiphaseProjectData.cPhaseId = UtilSql.getValue(result, "c_phase_id");
        objectMultiphaseProjectData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectMultiphaseProjectData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectMultiphaseProjectData.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectMultiphaseProjectData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectMultiphaseProjectData.note = UtilSql.getValue(result, "note");
        objectMultiphaseProjectData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectMultiphaseProjectData.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectMultiphaseProjectData.processed = UtilSql.getValue(result, "processed");
        objectMultiphaseProjectData.processing = UtilSql.getValue(result, "processing");
        objectMultiphaseProjectData.isactive = UtilSql.getValue(result, "isactive");
        objectMultiphaseProjectData.generateto = UtilSql.getValue(result, "generateto");
        objectMultiphaseProjectData.generateorder = UtilSql.getValue(result, "generateorder");
        objectMultiphaseProjectData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMultiphaseProjectData.projectphase = UtilSql.getValue(result, "projectphase");
        objectMultiphaseProjectData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMultiphaseProjectData.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectMultiphaseProjectData.language = UtilSql.getValue(result, "language");
        objectMultiphaseProjectData.adUserClient = "";
        objectMultiphaseProjectData.adOrgClient = "";
        objectMultiphaseProjectData.createdby = "";
        objectMultiphaseProjectData.trBgcolor = "";
        objectMultiphaseProjectData.totalCount = "";
        objectMultiphaseProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMultiphaseProjectData);
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
    MultiphaseProjectData objectMultiphaseProjectData[] = new MultiphaseProjectData[vector.size()];
    vector.copyInto(objectMultiphaseProjectData);
    return(objectMultiphaseProjectData);
  }

/**
Create a registry
 */
  public static MultiphaseProjectData[] set(String cProjectphaseId, String createtemppricelist, String startdate, String cProjectId, String adOrgId, String adClientId, String isactive, String createdby, String createdbyr, String name, String updatedby, String updatedbyr, String description, String issummary, String value, String emDtzkCostbudgetview, String emDtzkAssociatecostbudget, String servoutcost, String cCurrencyId, String cBpartnerId, String iscommitment, String committedamt, String datecontract, String datefinish, String generateto, String processed, String note, String salesrepId, String mPricelistVersionId, String plannedamt, String plannedqty, String plannedmarginamt, String poreference, String cCampaignId, String cPaymenttermId, String adUserId, String cBpartnerLocationId, String publicprivate, String projectstatus, String projectkind, String billtoId, String projectphase, String generateorder, String changeprojectstatus, String cLocationId, String mPricelistId, String paymentrule, String invoiceToproject, String plannedpoamt, String lastplannedproposaldate, String documentCopies, String accountno, String responsibleId, String servrevenue, String servcost, String servmargin, String expreinvoicing, String expexpenses, String expmargin, String setprojecttype, String finPaymentmethodId, String invoicedamt, String copyfrom, String cPhaseId, String invoicedqty, String cProjecttypeId, String projectbalanceamt, String committedqty, String iscommitceiling, String mWarehouseId, String projectcategory, String processing, String emDtzkAssociatepb, String emDtzkFilename, String servsercost)    throws ServletException {
    MultiphaseProjectData objectMultiphaseProjectData[] = new MultiphaseProjectData[1];
    objectMultiphaseProjectData[0] = new MultiphaseProjectData();
    objectMultiphaseProjectData[0].created = "";
    objectMultiphaseProjectData[0].createdbyr = createdbyr;
    objectMultiphaseProjectData[0].updated = "";
    objectMultiphaseProjectData[0].updatedTimeStamp = "";
    objectMultiphaseProjectData[0].updatedby = updatedby;
    objectMultiphaseProjectData[0].updatedbyr = updatedbyr;
    objectMultiphaseProjectData[0].adOrgId = adOrgId;
    objectMultiphaseProjectData[0].adOrgIdr = "";
    objectMultiphaseProjectData[0].value = value;
    objectMultiphaseProjectData[0].name = name;
    objectMultiphaseProjectData[0].issummary = issummary;
    objectMultiphaseProjectData[0].setprojecttype = setprojecttype;
    objectMultiphaseProjectData[0].projectstatus = projectstatus;
    objectMultiphaseProjectData[0].cProjecttypeId = cProjecttypeId;
    objectMultiphaseProjectData[0].cProjectphaseId = cProjectphaseId;
    objectMultiphaseProjectData[0].startdate = startdate;
    objectMultiphaseProjectData[0].datecontract = datecontract;
    objectMultiphaseProjectData[0].datefinish = datefinish;
    objectMultiphaseProjectData[0].description = description;
    objectMultiphaseProjectData[0].salesrepId = salesrepId;
    objectMultiphaseProjectData[0].responsibleId = responsibleId;
    objectMultiphaseProjectData[0].iscommitment = iscommitment;
    objectMultiphaseProjectData[0].iscommitceiling = iscommitceiling;
    objectMultiphaseProjectData[0].committedamt = committedamt;
    objectMultiphaseProjectData[0].committedqty = committedqty;
    objectMultiphaseProjectData[0].servrevenue = servrevenue;
    objectMultiphaseProjectData[0].expexpenses = expexpenses;
    objectMultiphaseProjectData[0].servsercost = servsercost;
    objectMultiphaseProjectData[0].servoutcost = servoutcost;
    objectMultiphaseProjectData[0].servcost = servcost;
    objectMultiphaseProjectData[0].expreinvoicing = expreinvoicing;
    objectMultiphaseProjectData[0].servmargin = servmargin;
    objectMultiphaseProjectData[0].expmargin = expmargin;
    objectMultiphaseProjectData[0].cBpartnerId = cBpartnerId;
    objectMultiphaseProjectData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectMultiphaseProjectData[0].adUserId = adUserId;
    objectMultiphaseProjectData[0].poreference = poreference;
    objectMultiphaseProjectData[0].finPaymentmethodId = finPaymentmethodId;
    objectMultiphaseProjectData[0].finPaymentmethodIdr = "";
    objectMultiphaseProjectData[0].cPaymenttermId = cPaymenttermId;
    objectMultiphaseProjectData[0].mPricelistId = mPricelistId;
    objectMultiphaseProjectData[0].cCurrencyId = cCurrencyId;
    objectMultiphaseProjectData[0].mWarehouseId = mWarehouseId;
    objectMultiphaseProjectData[0].changeprojectstatus = changeprojectstatus;
    objectMultiphaseProjectData[0].copyfrom = copyfrom;
    objectMultiphaseProjectData[0].emDtzkAssociatepb = emDtzkAssociatepb;
    objectMultiphaseProjectData[0].emDtzkAssociatecostbudget = emDtzkAssociatecostbudget;
    objectMultiphaseProjectData[0].emDtzkFilename = emDtzkFilename;
    objectMultiphaseProjectData[0].emDtzkCostbudgetview = emDtzkCostbudgetview;
    objectMultiphaseProjectData[0].projectkind = projectkind;
    objectMultiphaseProjectData[0].projectbalanceamt = projectbalanceamt;
    objectMultiphaseProjectData[0].publicprivate = publicprivate;
    objectMultiphaseProjectData[0].billtoId = billtoId;
    objectMultiphaseProjectData[0].accountno = accountno;
    objectMultiphaseProjectData[0].documentCopies = documentCopies;
    objectMultiphaseProjectData[0].paymentrule = paymentrule;
    objectMultiphaseProjectData[0].invoiceToproject = invoiceToproject;
    objectMultiphaseProjectData[0].cLocationId = cLocationId;
    objectMultiphaseProjectData[0].plannedpoamt = plannedpoamt;
    objectMultiphaseProjectData[0].lastplannedproposaldate = lastplannedproposaldate;
    objectMultiphaseProjectData[0].invoicedqty = invoicedqty;
    objectMultiphaseProjectData[0].createtemppricelist = createtemppricelist;
    objectMultiphaseProjectData[0].cPhaseId = cPhaseId;
    objectMultiphaseProjectData[0].invoicedamt = invoicedamt;
    objectMultiphaseProjectData[0].cCampaignId = cCampaignId;
    objectMultiphaseProjectData[0].plannedmarginamt = plannedmarginamt;
    objectMultiphaseProjectData[0].plannedamt = plannedamt;
    objectMultiphaseProjectData[0].note = note;
    objectMultiphaseProjectData[0].mPricelistVersionId = mPricelistVersionId;
    objectMultiphaseProjectData[0].plannedqty = plannedqty;
    objectMultiphaseProjectData[0].processed = processed;
    objectMultiphaseProjectData[0].processing = processing;
    objectMultiphaseProjectData[0].isactive = isactive;
    objectMultiphaseProjectData[0].generateto = generateto;
    objectMultiphaseProjectData[0].generateorder = generateorder;
    objectMultiphaseProjectData[0].adClientId = adClientId;
    objectMultiphaseProjectData[0].projectphase = projectphase;
    objectMultiphaseProjectData[0].cProjectId = cProjectId;
    objectMultiphaseProjectData[0].projectcategory = projectcategory;
    objectMultiphaseProjectData[0].language = "";
    return objectMultiphaseProjectData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1354_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as CreatedBy FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDef1357_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as UpdatedBy FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
Select for action search
 */
  public static String selectActDefC_Project_ID(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM C_Project WHERE isActive='Y' AND C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
      "        UPDATE C_Project" +
      "        SET AD_Org_ID = (?) , Value = (?) , Name = (?) , IsSummary = (?) , Setprojecttype = (?) , Projectstatus = (?) , C_ProjectType_ID = (?) , C_ProjectPhase_ID = (?) , Startdate = TO_DATE(?) , DateContract = TO_DATE(?) , DateFinish = TO_DATE(?) , Description = (?) , SalesRep_ID = (?) , Responsible_ID = (?) , IsCommitment = (?) , IsCommitCeiling = (?) , CommittedAmt = TO_NUMBER(?) , CommittedQty = TO_NUMBER(?) , Servrevenue = TO_NUMBER(?) , Expexpenses = TO_NUMBER(?) , Servsercost = TO_NUMBER(?) , Servoutcost = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , Expreinvoicing = TO_NUMBER(?) , Servmargin = TO_NUMBER(?) , Expmargin = TO_NUMBER(?) , C_BPartner_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , POReference = (?) , FIN_Paymentmethod_ID = (?) , C_PaymentTerm_ID = (?) , M_PriceList_ID = (?) , C_Currency_ID = (?) , M_Warehouse_ID = (?) , ChangeProjectStatus = (?) , CopyFrom = (?) , EM_Dtzk_Associatepb = (?) , EM_Dtzk_Associatecostbudget = (?) , EM_Dtzk_Filename = (?) , EM_Dtzk_Costbudgetview = (?) , Projectkind = (?) , ProjectBalanceAmt = TO_NUMBER(?) , Publicprivate = (?) , BillTo_ID = (?) , AccountNo = (?) , Document_Copies = TO_NUMBER(?) , PaymentRule = (?) , Invoice_ToProject = (?) , C_Location_ID = (?) , PlannedPOAmt = TO_NUMBER(?) , LastPlannedProposalDate = TO_DATE(?) , InvoicedQty = TO_NUMBER(?) , Createtemppricelist = (?) , C_Phase_ID = (?) , InvoicedAmt = TO_NUMBER(?) , C_Campaign_ID = (?) , PlannedMarginAmt = TO_NUMBER(?) , PlannedAmt = TO_NUMBER(?) , Note = (?) , M_PriceList_Version_ID = (?) , PlannedQty = TO_NUMBER(?) , Processed = (?) , Processing = (?) , IsActive = (?) , GenerateTo = (?) , GenerateOrder = (?) , AD_Client_ID = (?) , Projectphase = (?) , C_Project_ID = (?) , ProjectCategory = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Project.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servsercost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servoutcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkAssociatepb);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkAssociatecostbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkFilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkCostbudgetview);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO C_Project " +
      "        (AD_Org_ID, Value, Name, IsSummary, Setprojecttype, Projectstatus, C_ProjectType_ID, C_ProjectPhase_ID, Startdate, DateContract, DateFinish, Description, SalesRep_ID, Responsible_ID, IsCommitment, IsCommitCeiling, CommittedAmt, CommittedQty, Servrevenue, Expexpenses, Servsercost, Servoutcost, Servcost, Expreinvoicing, Servmargin, Expmargin, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID, POReference, FIN_Paymentmethod_ID, C_PaymentTerm_ID, M_PriceList_ID, C_Currency_ID, M_Warehouse_ID, ChangeProjectStatus, CopyFrom, EM_Dtzk_Associatepb, EM_Dtzk_Associatecostbudget, EM_Dtzk_Filename, EM_Dtzk_Costbudgetview, Projectkind, ProjectBalanceAmt, Publicprivate, BillTo_ID, AccountNo, Document_Copies, PaymentRule, Invoice_ToProject, C_Location_ID, PlannedPOAmt, LastPlannedProposalDate, InvoicedQty, Createtemppricelist, C_Phase_ID, InvoicedAmt, C_Campaign_ID, PlannedMarginAmt, PlannedAmt, Note, M_PriceList_Version_ID, PlannedQty, Processed, Processing, IsActive, GenerateTo, GenerateOrder, AD_Client_ID, Projectphase, C_Project_ID, ProjectCategory, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setprojecttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servrevenue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expexpenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servsercost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servoutcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expreinvoicing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkAssociatepb);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkAssociatecostbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkFilename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emDtzkCostbudgetview);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectkind);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectbalanceamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, publicprivate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentCopies);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoiceToproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastplannedproposaldate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createtemppricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPhaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectphase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
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
      "        DELETE FROM C_Project" +
      "        WHERE C_Project.C_Project_ID = ? " +
      "        AND C_Project.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Project.AD_Org_ID IN (";
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
      "          FROM C_Project" +
      "         WHERE C_Project.C_Project_ID = ? ";

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
      "          FROM C_Project" +
      "         WHERE C_Project.C_Project_ID = ? ";

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

/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.datatreis.pocustomize.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity DTPO_Pocopfile (stored in table DTPO_Pocopfile).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DTPOPocopfile extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "DTPO_Pocopfile";
    public static final String ENTITY_NAME = "DTPO_Pocopfile";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FILENAME = "filename";
    public static final String PROPERTY_ASSOCIATEBOQ = "associateboq";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BOQIMPORT = "boqimport";
    public static final String PROPERTY_IMPORTFILETYPE = "importfiletype";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_FILEVIEW = "fileView";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_COPNO = "copno";
    public static final String PROPERTY_COPAMOUNT = "copamount";
    public static final String PROPERTY_COPSTATUS = "copstatus";
    public static final String PROPERTY_COPAPPROVE = "copapprove";
    public static final String PROPERTY_COPREJECT = "copreject";
    public static final String PROPERTY_COPSENTAPPROVE = "copsentapprove";
    public static final String PROPERTY_FILETYPE = "filetype";
    public static final String PROPERTY_ISGRNCOMPLETED = "isgrncompleted";
    public static final String PROPERTY_PAYMENTTYPE = "paymenttype";
    public static final String PROPERTY_ADVANCETYPE = "advancetype";
    public static final String PROPERTY_REC1STCOLUMN = "rEC1stcolumn";
    public static final String PROPERTY_REC2NDCOLUMN = "rEC2ndcolumn";
    public static final String PROPERTY_REC3RDCOLUMN = "rEC3rdcolumn";
    public static final String PROPERTY_REC4THCOLUMN = "rEC4thcolumn";
    public static final String PROPERTY_REC5THCOLUMN = "rEC5thcolumn";
    public static final String PROPERTY_REC6THCOLUMN = "rEC6thcolumn";
    public static final String PROPERTY_REC7THCOLUMN = "rEC7thcolumn";
    public static final String PROPERTY_REC8THCOLUMN = "rEC8thcolumn";
    public static final String PROPERTY_REC9THCOLUMN = "rEC9thcolumn";
    public static final String PROPERTY_REC10THCOLUMN = "rEC10thcolumn";
    public static final String PROPERTY_ADV1STCOLUMN = "aDV1stcolumn";
    public static final String PROPERTY_ADV2NDCOLUMN = "aDV2ndcolumn";
    public static final String PROPERTY_ADV3RDCOLUMN = "aDV3rdcolumn";
    public static final String PROPERTY_ADV4THCOLUMN = "aDV4thcolumn";
    public static final String PROPERTY_ADV5THCOLUMN = "aDV5thcolumn";
    public static final String PROPERTY_ADV6THCOLUMN = "aDV6thcolumn";
    public static final String PROPERTY_CREATECOP = "createcop";
    public static final String PROPERTY_USDAMT = "usdamt";
    public static final String PROPERTY_CONVERSIONRATE = "conversionrate";
    public static final String PROPERTY_JCMDOLSINVOICE = "jcmDolsInvoice";
    public static final String PROPERTY_JCMDORBINVOICE = "jcmDorbInvoice";
    public static final String PROPERTY_JCMCLAIMEDINVOICEAMT = "jcmClaimedInvoiceamt";
    public static final String PROPERTY_JCMNETTOTAL = "jcmNettotal";
    public static final String PROPERTY_JCMRECOVERYTOTAL = "jcmRecoverytotal";
    public static final String PROPERTY_JCMADVANCETOTAL = "jcmAdvancetotal";
    public static final String PROPERTY_DTPOCOPPAYMENTSLIST = "dTPOCoppaymentsList";
    public static final String PROPERTY_DTPOITEMCOPLIST = "dTPOItemcopList";

    public DTPOPocopfile() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ASSOCIATEBOQ, false);
        setDefaultValue(PROPERTY_BOQIMPORT, false);
        setDefaultValue(PROPERTY_COPSTATUS, "DR");
        setDefaultValue(PROPERTY_COPAPPROVE, false);
        setDefaultValue(PROPERTY_COPREJECT, false);
        setDefaultValue(PROPERTY_COPSENTAPPROVE, false);
        setDefaultValue(PROPERTY_ISGRNCOMPLETED, false);
        setDefaultValue(PROPERTY_CREATECOP, false);
        setDefaultValue(PROPERTY_DTPOCOPPAYMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DTPOITEMCOPLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getFilename() {
        return (String) get(PROPERTY_FILENAME);
    }

    public void setFilename(String filename) {
        set(PROPERTY_FILENAME, filename);
    }

    public Boolean isAssociateboq() {
        return (Boolean) get(PROPERTY_ASSOCIATEBOQ);
    }

    public void setAssociateboq(Boolean associateboq) {
        set(PROPERTY_ASSOCIATEBOQ, associateboq);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isBoqimport() {
        return (Boolean) get(PROPERTY_BOQIMPORT);
    }

    public void setBoqimport(Boolean boqimport) {
        set(PROPERTY_BOQIMPORT, boqimport);
    }

    public String getImportfiletype() {
        return (String) get(PROPERTY_IMPORTFILETYPE);
    }

    public void setImportfiletype(String importfiletype) {
        set(PROPERTY_IMPORTFILETYPE, importfiletype);
    }

    public String getOrderline() {
        return (String) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(String orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public String getFileView() {
        return (String) get(PROPERTY_FILEVIEW);
    }

    public void setFileView(String fileView) {
        set(PROPERTY_FILEVIEW, fileView);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public String getCopno() {
        return (String) get(PROPERTY_COPNO);
    }

    public void setCopno(String copno) {
        set(PROPERTY_COPNO, copno);
    }

    public BigDecimal getCopamount() {
        return (BigDecimal) get(PROPERTY_COPAMOUNT);
    }

    public void setCopamount(BigDecimal copamount) {
        set(PROPERTY_COPAMOUNT, copamount);
    }

    public String getCopstatus() {
        return (String) get(PROPERTY_COPSTATUS);
    }

    public void setCopstatus(String copstatus) {
        set(PROPERTY_COPSTATUS, copstatus);
    }

    public Boolean isCopapprove() {
        return (Boolean) get(PROPERTY_COPAPPROVE);
    }

    public void setCopapprove(Boolean copapprove) {
        set(PROPERTY_COPAPPROVE, copapprove);
    }

    public Boolean isCopreject() {
        return (Boolean) get(PROPERTY_COPREJECT);
    }

    public void setCopreject(Boolean copreject) {
        set(PROPERTY_COPREJECT, copreject);
    }

    public Boolean isCopsentapprove() {
        return (Boolean) get(PROPERTY_COPSENTAPPROVE);
    }

    public void setCopsentapprove(Boolean copsentapprove) {
        set(PROPERTY_COPSENTAPPROVE, copsentapprove);
    }

    public String getFiletype() {
        return (String) get(PROPERTY_FILETYPE);
    }

    public void setFiletype(String filetype) {
        set(PROPERTY_FILETYPE, filetype);
    }

    public Boolean isGrncompleted() {
        return (Boolean) get(PROPERTY_ISGRNCOMPLETED);
    }

    public void setGrncompleted(Boolean isgrncompleted) {
        set(PROPERTY_ISGRNCOMPLETED, isgrncompleted);
    }

    public String getPaymenttype() {
        return (String) get(PROPERTY_PAYMENTTYPE);
    }

    public void setPaymenttype(String paymenttype) {
        set(PROPERTY_PAYMENTTYPE, paymenttype);
    }

    public String getAdvancetype() {
        return (String) get(PROPERTY_ADVANCETYPE);
    }

    public void setAdvancetype(String advancetype) {
        set(PROPERTY_ADVANCETYPE, advancetype);
    }

    public Long getREC1stcolumn() {
        return (Long) get(PROPERTY_REC1STCOLUMN);
    }

    public void setREC1stcolumn(Long rEC1stcolumn) {
        set(PROPERTY_REC1STCOLUMN, rEC1stcolumn);
    }

    public Long getREC2ndcolumn() {
        return (Long) get(PROPERTY_REC2NDCOLUMN);
    }

    public void setREC2ndcolumn(Long rEC2ndcolumn) {
        set(PROPERTY_REC2NDCOLUMN, rEC2ndcolumn);
    }

    public Long getREC3rdcolumn() {
        return (Long) get(PROPERTY_REC3RDCOLUMN);
    }

    public void setREC3rdcolumn(Long rEC3rdcolumn) {
        set(PROPERTY_REC3RDCOLUMN, rEC3rdcolumn);
    }

    public Long getREC4thcolumn() {
        return (Long) get(PROPERTY_REC4THCOLUMN);
    }

    public void setREC4thcolumn(Long rEC4thcolumn) {
        set(PROPERTY_REC4THCOLUMN, rEC4thcolumn);
    }

    public Long getREC5thcolumn() {
        return (Long) get(PROPERTY_REC5THCOLUMN);
    }

    public void setREC5thcolumn(Long rEC5thcolumn) {
        set(PROPERTY_REC5THCOLUMN, rEC5thcolumn);
    }

    public Long getREC6thcolumn() {
        return (Long) get(PROPERTY_REC6THCOLUMN);
    }

    public void setREC6thcolumn(Long rEC6thcolumn) {
        set(PROPERTY_REC6THCOLUMN, rEC6thcolumn);
    }

    public Long getREC7thcolumn() {
        return (Long) get(PROPERTY_REC7THCOLUMN);
    }

    public void setREC7thcolumn(Long rEC7thcolumn) {
        set(PROPERTY_REC7THCOLUMN, rEC7thcolumn);
    }

    public Long getREC8thcolumn() {
        return (Long) get(PROPERTY_REC8THCOLUMN);
    }

    public void setREC8thcolumn(Long rEC8thcolumn) {
        set(PROPERTY_REC8THCOLUMN, rEC8thcolumn);
    }

    public Long getREC9thcolumn() {
        return (Long) get(PROPERTY_REC9THCOLUMN);
    }

    public void setREC9thcolumn(Long rEC9thcolumn) {
        set(PROPERTY_REC9THCOLUMN, rEC9thcolumn);
    }

    public Long getREC10thcolumn() {
        return (Long) get(PROPERTY_REC10THCOLUMN);
    }

    public void setREC10thcolumn(Long rEC10thcolumn) {
        set(PROPERTY_REC10THCOLUMN, rEC10thcolumn);
    }

    public Long getADV1stcolumn() {
        return (Long) get(PROPERTY_ADV1STCOLUMN);
    }

    public void setADV1stcolumn(Long aDV1stcolumn) {
        set(PROPERTY_ADV1STCOLUMN, aDV1stcolumn);
    }

    public Long getADV2ndcolumn() {
        return (Long) get(PROPERTY_ADV2NDCOLUMN);
    }

    public void setADV2ndcolumn(Long aDV2ndcolumn) {
        set(PROPERTY_ADV2NDCOLUMN, aDV2ndcolumn);
    }

    public Long getADV3rdcolumn() {
        return (Long) get(PROPERTY_ADV3RDCOLUMN);
    }

    public void setADV3rdcolumn(Long aDV3rdcolumn) {
        set(PROPERTY_ADV3RDCOLUMN, aDV3rdcolumn);
    }

    public Long getADV4thcolumn() {
        return (Long) get(PROPERTY_ADV4THCOLUMN);
    }

    public void setADV4thcolumn(Long aDV4thcolumn) {
        set(PROPERTY_ADV4THCOLUMN, aDV4thcolumn);
    }

    public Long getADV5thcolumn() {
        return (Long) get(PROPERTY_ADV5THCOLUMN);
    }

    public void setADV5thcolumn(Long aDV5thcolumn) {
        set(PROPERTY_ADV5THCOLUMN, aDV5thcolumn);
    }

    public Long getADV6thcolumn() {
        return (Long) get(PROPERTY_ADV6THCOLUMN);
    }

    public void setADV6thcolumn(Long aDV6thcolumn) {
        set(PROPERTY_ADV6THCOLUMN, aDV6thcolumn);
    }

    public Boolean isCreatecop() {
        return (Boolean) get(PROPERTY_CREATECOP);
    }

    public void setCreatecop(Boolean createcop) {
        set(PROPERTY_CREATECOP, createcop);
    }

    public Long getUsdamt() {
        return (Long) get(PROPERTY_USDAMT);
    }

    public void setUsdamt(Long usdamt) {
        set(PROPERTY_USDAMT, usdamt);
    }

    public BigDecimal getConversionrate() {
        return (BigDecimal) get(PROPERTY_CONVERSIONRATE);
    }

    public void setConversionrate(BigDecimal conversionrate) {
        set(PROPERTY_CONVERSIONRATE, conversionrate);
    }

    public Date getJcmDolsInvoice() {
        return (Date) get(PROPERTY_JCMDOLSINVOICE);
    }

    public void setJcmDolsInvoice(Date jcmDolsInvoice) {
        set(PROPERTY_JCMDOLSINVOICE, jcmDolsInvoice);
    }

    public Date getJcmDorbInvoice() {
        return (Date) get(PROPERTY_JCMDORBINVOICE);
    }

    public void setJcmDorbInvoice(Date jcmDorbInvoice) {
        set(PROPERTY_JCMDORBINVOICE, jcmDorbInvoice);
    }

    public BigDecimal getJcmClaimedInvoiceamt() {
        return (BigDecimal) get(PROPERTY_JCMCLAIMEDINVOICEAMT);
    }

    public void setJcmClaimedInvoiceamt(BigDecimal jcmClaimedInvoiceamt) {
        set(PROPERTY_JCMCLAIMEDINVOICEAMT, jcmClaimedInvoiceamt);
    }

    public BigDecimal getJcmNettotal() {
        return (BigDecimal) get(PROPERTY_JCMNETTOTAL);
    }

    public void setJcmNettotal(BigDecimal jcmNettotal) {
        set(PROPERTY_JCMNETTOTAL, jcmNettotal);
    }

    public BigDecimal getJcmRecoverytotal() {
        return (BigDecimal) get(PROPERTY_JCMRECOVERYTOTAL);
    }

    public void setJcmRecoverytotal(BigDecimal jcmRecoverytotal) {
        set(PROPERTY_JCMRECOVERYTOTAL, jcmRecoverytotal);
    }

    public BigDecimal getJcmAdvancetotal() {
        return (BigDecimal) get(PROPERTY_JCMADVANCETOTAL);
    }

    public void setJcmAdvancetotal(BigDecimal jcmAdvancetotal) {
        set(PROPERTY_JCMADVANCETOTAL, jcmAdvancetotal);
    }

    @SuppressWarnings("unchecked")
    public List<COPPayments> getDTPOCoppaymentsList() {
      return (List<COPPayments>) get(PROPERTY_DTPOCOPPAYMENTSLIST);
    }

    public void setDTPOCoppaymentsList(List<COPPayments> dTPOCoppaymentsList) {
        set(PROPERTY_DTPOCOPPAYMENTSLIST, dTPOCoppaymentsList);
    }

    @SuppressWarnings("unchecked")
    public List<DTPOItemcop> getDTPOItemcopList() {
      return (List<DTPOItemcop>) get(PROPERTY_DTPOITEMCOPLIST);
    }

    public void setDTPOItemcopList(List<DTPOItemcop> dTPOItemcopList) {
        set(PROPERTY_DTPOITEMCOPLIST, dTPOItemcopList);
    }

}

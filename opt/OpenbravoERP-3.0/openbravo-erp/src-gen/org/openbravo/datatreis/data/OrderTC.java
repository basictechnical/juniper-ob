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
package org.openbravo.datatreis.data;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity DT_Order_TC (stored in table DT_Order_TC).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OrderTC extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "DT_Order_TC";
    public static final String ENTITY_NAME = "DT_Order_TC";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRICEBASIS = "priceBasis";
    public static final String PROPERTY_PKGNGFRWD = "pkgngFrwd";
    public static final String PROPERTY_EXICEDUTY = "exiceDuty";
    public static final String PROPERTY_SALESTAX = "salesTax";
    public static final String PROPERTY_TRANSITINS = "transitIns";
    public static final String PROPERTY_DELIVERY = "delivery";
    public static final String PROPERTY_INSPECTION = "inspection";
    public static final String PROPERTY_QUALITY = "quality";
    public static final String PROPERTY_DISPOSAL = "disposal";
    public static final String PROPERTY_DISPATCH = "dispatch";
    public static final String PROPERTY_PAYTERMS = "pAYTerms";
    public static final String PROPERTY_PAYMTHD = "pAYMthd";
    public static final String PROPERTY_WARRANTY = "warranty";
    public static final String PROPERTY_ASSIGNMNT = "assignmnt";
    public static final String PROPERTY_REJCTION = "rejction";
    public static final String PROPERTY_LIQUIDDMG = "liquidDmg";
    public static final String PROPERTY_ORDERCNCL = "orderCncl";
    public static final String PROPERTY_INCMETAX = "incmeTax";
    public static final String PROPERTY_REGACT = "rEGAct";
    public static final String PROPERTY_CORSPNDC = "corspndc";
    public static final String PROPERTY_ARBT = "arbt";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_CONSIGNDETAIL = "consignDetail";
    public static final String PROPERTY_TAXINVOICE = "tAXInvoice";
    public static final String PROPERTY_ADDINFO = "aDDInfo";

    public OrderTC() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getPriceBasis() {
        return (String) get(PROPERTY_PRICEBASIS);
    }

    public void setPriceBasis(String priceBasis) {
        set(PROPERTY_PRICEBASIS, priceBasis);
    }

    public String getPkgngFrwd() {
        return (String) get(PROPERTY_PKGNGFRWD);
    }

    public void setPkgngFrwd(String pkgngFrwd) {
        set(PROPERTY_PKGNGFRWD, pkgngFrwd);
    }

    public String getExiceDuty() {
        return (String) get(PROPERTY_EXICEDUTY);
    }

    public void setExiceDuty(String exiceDuty) {
        set(PROPERTY_EXICEDUTY, exiceDuty);
    }

    public String getSalesTax() {
        return (String) get(PROPERTY_SALESTAX);
    }

    public void setSalesTax(String salesTax) {
        set(PROPERTY_SALESTAX, salesTax);
    }

    public String getTransitIns() {
        return (String) get(PROPERTY_TRANSITINS);
    }

    public void setTransitIns(String transitIns) {
        set(PROPERTY_TRANSITINS, transitIns);
    }

    public String getDelivery() {
        return (String) get(PROPERTY_DELIVERY);
    }

    public void setDelivery(String delivery) {
        set(PROPERTY_DELIVERY, delivery);
    }

    public String getInspection() {
        return (String) get(PROPERTY_INSPECTION);
    }

    public void setInspection(String inspection) {
        set(PROPERTY_INSPECTION, inspection);
    }

    public String getQuality() {
        return (String) get(PROPERTY_QUALITY);
    }

    public void setQuality(String quality) {
        set(PROPERTY_QUALITY, quality);
    }

    public String getDisposal() {
        return (String) get(PROPERTY_DISPOSAL);
    }

    public void setDisposal(String disposal) {
        set(PROPERTY_DISPOSAL, disposal);
    }

    public String getDispatch() {
        return (String) get(PROPERTY_DISPATCH);
    }

    public void setDispatch(String dispatch) {
        set(PROPERTY_DISPATCH, dispatch);
    }

    public String getPAYTerms() {
        return (String) get(PROPERTY_PAYTERMS);
    }

    public void setPAYTerms(String pAYTerms) {
        set(PROPERTY_PAYTERMS, pAYTerms);
    }

    public String getPAYMthd() {
        return (String) get(PROPERTY_PAYMTHD);
    }

    public void setPAYMthd(String pAYMthd) {
        set(PROPERTY_PAYMTHD, pAYMthd);
    }

    public String getWarranty() {
        return (String) get(PROPERTY_WARRANTY);
    }

    public void setWarranty(String warranty) {
        set(PROPERTY_WARRANTY, warranty);
    }

    public String getAssignmnt() {
        return (String) get(PROPERTY_ASSIGNMNT);
    }

    public void setAssignmnt(String assignmnt) {
        set(PROPERTY_ASSIGNMNT, assignmnt);
    }

    public String getRejction() {
        return (String) get(PROPERTY_REJCTION);
    }

    public void setRejction(String rejction) {
        set(PROPERTY_REJCTION, rejction);
    }

    public String getLiquidDmg() {
        return (String) get(PROPERTY_LIQUIDDMG);
    }

    public void setLiquidDmg(String liquidDmg) {
        set(PROPERTY_LIQUIDDMG, liquidDmg);
    }

    public String getOrderCncl() {
        return (String) get(PROPERTY_ORDERCNCL);
    }

    public void setOrderCncl(String orderCncl) {
        set(PROPERTY_ORDERCNCL, orderCncl);
    }

    public String getIncmeTax() {
        return (String) get(PROPERTY_INCMETAX);
    }

    public void setIncmeTax(String incmeTax) {
        set(PROPERTY_INCMETAX, incmeTax);
    }

    public String getREGAct() {
        return (String) get(PROPERTY_REGACT);
    }

    public void setREGAct(String rEGAct) {
        set(PROPERTY_REGACT, rEGAct);
    }

    public String getCorspndc() {
        return (String) get(PROPERTY_CORSPNDC);
    }

    public void setCorspndc(String corspndc) {
        set(PROPERTY_CORSPNDC, corspndc);
    }

    public String getArbt() {
        return (String) get(PROPERTY_ARBT);
    }

    public void setArbt(String arbt) {
        set(PROPERTY_ARBT, arbt);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getConsignDetail() {
        return (String) get(PROPERTY_CONSIGNDETAIL);
    }

    public void setConsignDetail(String consignDetail) {
        set(PROPERTY_CONSIGNDETAIL, consignDetail);
    }

    public String getTAXInvoice() {
        return (String) get(PROPERTY_TAXINVOICE);
    }

    public void setTAXInvoice(String tAXInvoice) {
        set(PROPERTY_TAXINVOICE, tAXInvoice);
    }

    public String getADDInfo() {
        return (String) get(PROPERTY_ADDINFO);
    }

    public void setADDInfo(String aDDInfo) {
        set(PROPERTY_ADDINFO, aDDInfo);
    }

}

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
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.project.Project;
/**
 * Entity class for entity DTPO_Itemcop (stored in table DTPO_Itemcop).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DTPOItemcop extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "DTPO_Itemcop";
    public static final String ENTITY_NAME = "DTPO_Itemcop";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DTPOPOCOPFILE = "dtpoPocopfile";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCTNAME = "productname";
    public static final String PROPERTY_PRODUCTQTY = "productqty";
    public static final String PROPERTY_COPAMT = "copamt";
    public static final String PROPERTY_DAMAGEDRETURNED = "damagedReturned";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_SEARCHKEY = "searchkey";
    public static final String PROPERTY_ATTRIBUTENAME = "attributename";
    public static final String PROPERTY_GRNQUANTITY = "gRNQuantity";
    public static final String PROPERTY_TOTALQUANTITY = "totalquantity";
    public static final String PROPERTY_BALANCECOPAMT = "balancecopamt";
    public static final String PROPERTY_CERTFDCOPAMT = "certfdcopamt";
    public static final String PROPERTY_TOTALLINEAMT = "totallineamt";
    public static final String PROPERTY_COPPERCENTAGE = "coppercentage";
    public static final String PROPERTY_APPROVECOP = "approvecop";
    public static final String PROPERTY_COPBASIC = "copbasic";
    public static final String PROPERTY_COPINSURANCE = "copinsurance";
    public static final String PROPERTY_COPPKGFWDG = "coppkgFwdg";
    public static final String PROPERTY_COPOTHERS = "copothers";
    public static final String PROPERTY_COPFREIGHT = "copfreight";
    public static final String PROPERTY_COPEXCISE = "copexcise";
    public static final String PROPERTY_COPSUBTOTAL = "copsubtotal";
    public static final String PROPERTY_COPVATCST = "copvatCst";
    public static final String PROPERTY_COPOCTROILBT = "copoctroiLbt";
    public static final String PROPERTY_COPINSTALLATIONBASIC = "copinstallationbasic";
    public static final String PROPERTY_COPINSTALLATIONSERVICE = "copinstallationservice";
    public static final String PROPERTY_COPINSTALLATIONOTHERS = "copinstallationothers";
    public static final String PROPERTY_COPINSTALLATIONTOTAL = "copinstallationtotal";
    public static final String PROPERTY_COPSUPPLYBASIC = "copsupplybasic";
    public static final String PROPERTY_COPSUPPLYTOTAL = "copsupplytotal";
    public static final String PROPERTY_COPCESS = "copcess";
    public static final String PROPERTY_COPIMPORTEDTOTAL = "copimportedtotal";
    public static final String PROPERTY_PROJECT = "project";

    public DTPOItemcop() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_APPROVECOP, false);
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

    public DTPOPocopfile getDtpoPocopfile() {
        return (DTPOPocopfile) get(PROPERTY_DTPOPOCOPFILE);
    }

    public void setDtpoPocopfile(DTPOPocopfile dtpoPocopfile) {
        set(PROPERTY_DTPOPOCOPFILE, dtpoPocopfile);
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

    public String getProductname() {
        return (String) get(PROPERTY_PRODUCTNAME);
    }

    public void setProductname(String productname) {
        set(PROPERTY_PRODUCTNAME, productname);
    }

    public Long getProductqty() {
        return (Long) get(PROPERTY_PRODUCTQTY);
    }

    public void setProductqty(Long productqty) {
        set(PROPERTY_PRODUCTQTY, productqty);
    }

    public BigDecimal getCopamt() {
        return (BigDecimal) get(PROPERTY_COPAMT);
    }

    public void setCopamt(BigDecimal copamt) {
        set(PROPERTY_COPAMT, copamt);
    }

    public Long getDamagedReturned() {
        return (Long) get(PROPERTY_DAMAGEDRETURNED);
    }

    public void setDamagedReturned(Long damagedReturned) {
        set(PROPERTY_DAMAGEDRETURNED, damagedReturned);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public String getSearchkey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchkey(String searchkey) {
        set(PROPERTY_SEARCHKEY, searchkey);
    }

    public String getAttributename() {
        return (String) get(PROPERTY_ATTRIBUTENAME);
    }

    public void setAttributename(String attributename) {
        set(PROPERTY_ATTRIBUTENAME, attributename);
    }

    public Long getGRNQuantity() {
        return (Long) get(PROPERTY_GRNQUANTITY);
    }

    public void setGRNQuantity(Long gRNQuantity) {
        set(PROPERTY_GRNQUANTITY, gRNQuantity);
    }

    public Long getTotalquantity() {
        return (Long) get(PROPERTY_TOTALQUANTITY);
    }

    public void setTotalquantity(Long totalquantity) {
        set(PROPERTY_TOTALQUANTITY, totalquantity);
    }

    public Long getBalancecopamt() {
        return (Long) get(PROPERTY_BALANCECOPAMT);
    }

    public void setBalancecopamt(Long balancecopamt) {
        set(PROPERTY_BALANCECOPAMT, balancecopamt);
    }

    public Long getCertfdcopamt() {
        return (Long) get(PROPERTY_CERTFDCOPAMT);
    }

    public void setCertfdcopamt(Long certfdcopamt) {
        set(PROPERTY_CERTFDCOPAMT, certfdcopamt);
    }

    public Long getTotallineamt() {
        return (Long) get(PROPERTY_TOTALLINEAMT);
    }

    public void setTotallineamt(Long totallineamt) {
        set(PROPERTY_TOTALLINEAMT, totallineamt);
    }

    public Long getCoppercentage() {
        return (Long) get(PROPERTY_COPPERCENTAGE);
    }

    public void setCoppercentage(Long coppercentage) {
        set(PROPERTY_COPPERCENTAGE, coppercentage);
    }

    public Boolean isApprovecop() {
        return (Boolean) get(PROPERTY_APPROVECOP);
    }

    public void setApprovecop(Boolean approvecop) {
        set(PROPERTY_APPROVECOP, approvecop);
    }

    public Long getCopbasic() {
        return (Long) get(PROPERTY_COPBASIC);
    }

    public void setCopbasic(Long copbasic) {
        set(PROPERTY_COPBASIC, copbasic);
    }

    public Long getCopinsurance() {
        return (Long) get(PROPERTY_COPINSURANCE);
    }

    public void setCopinsurance(Long copinsurance) {
        set(PROPERTY_COPINSURANCE, copinsurance);
    }

    public Long getCoppkgFwdg() {
        return (Long) get(PROPERTY_COPPKGFWDG);
    }

    public void setCoppkgFwdg(Long coppkgFwdg) {
        set(PROPERTY_COPPKGFWDG, coppkgFwdg);
    }

    public Long getCopothers() {
        return (Long) get(PROPERTY_COPOTHERS);
    }

    public void setCopothers(Long copothers) {
        set(PROPERTY_COPOTHERS, copothers);
    }

    public Long getCopfreight() {
        return (Long) get(PROPERTY_COPFREIGHT);
    }

    public void setCopfreight(Long copfreight) {
        set(PROPERTY_COPFREIGHT, copfreight);
    }

    public Long getCopexcise() {
        return (Long) get(PROPERTY_COPEXCISE);
    }

    public void setCopexcise(Long copexcise) {
        set(PROPERTY_COPEXCISE, copexcise);
    }

    public Long getCopsubtotal() {
        return (Long) get(PROPERTY_COPSUBTOTAL);
    }

    public void setCopsubtotal(Long copsubtotal) {
        set(PROPERTY_COPSUBTOTAL, copsubtotal);
    }

    public Long getCopvatCst() {
        return (Long) get(PROPERTY_COPVATCST);
    }

    public void setCopvatCst(Long copvatCst) {
        set(PROPERTY_COPVATCST, copvatCst);
    }

    public Long getCopoctroiLbt() {
        return (Long) get(PROPERTY_COPOCTROILBT);
    }

    public void setCopoctroiLbt(Long copoctroiLbt) {
        set(PROPERTY_COPOCTROILBT, copoctroiLbt);
    }

    public Long getCopinstallationbasic() {
        return (Long) get(PROPERTY_COPINSTALLATIONBASIC);
    }

    public void setCopinstallationbasic(Long copinstallationbasic) {
        set(PROPERTY_COPINSTALLATIONBASIC, copinstallationbasic);
    }

    public Long getCopinstallationservice() {
        return (Long) get(PROPERTY_COPINSTALLATIONSERVICE);
    }

    public void setCopinstallationservice(Long copinstallationservice) {
        set(PROPERTY_COPINSTALLATIONSERVICE, copinstallationservice);
    }

    public Long getCopinstallationothers() {
        return (Long) get(PROPERTY_COPINSTALLATIONOTHERS);
    }

    public void setCopinstallationothers(Long copinstallationothers) {
        set(PROPERTY_COPINSTALLATIONOTHERS, copinstallationothers);
    }

    public Long getCopinstallationtotal() {
        return (Long) get(PROPERTY_COPINSTALLATIONTOTAL);
    }

    public void setCopinstallationtotal(Long copinstallationtotal) {
        set(PROPERTY_COPINSTALLATIONTOTAL, copinstallationtotal);
    }

    public Long getCopsupplybasic() {
        return (Long) get(PROPERTY_COPSUPPLYBASIC);
    }

    public void setCopsupplybasic(Long copsupplybasic) {
        set(PROPERTY_COPSUPPLYBASIC, copsupplybasic);
    }

    public Long getCopsupplytotal() {
        return (Long) get(PROPERTY_COPSUPPLYTOTAL);
    }

    public void setCopsupplytotal(Long copsupplytotal) {
        set(PROPERTY_COPSUPPLYTOTAL, copsupplytotal);
    }

    public Long getCopcess() {
        return (Long) get(PROPERTY_COPCESS);
    }

    public void setCopcess(Long copcess) {
        set(PROPERTY_COPCESS, copcess);
    }

    public Long getCopimportedtotal() {
        return (Long) get(PROPERTY_COPIMPORTEDTOTAL);
    }

    public void setCopimportedtotal(Long copimportedtotal) {
        set(PROPERTY_COPIMPORTEDTOTAL, copimportedtotal);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

}

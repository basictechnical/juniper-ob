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

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity DTPO_Coppayments (stored in table DTPO_Coppayments).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class COPPayments extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "DTPO_Coppayments";
    public static final String ENTITY_NAME = "DTPO_Coppayments";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DTPOPOCOPFILE = "dtpoPocopfile";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISSUEDATE = "issuedate";
    public static final String PROPERTY_PAYAMOUNT = "payamount";
    public static final String PROPERTY_ITEMCODE = "itemcode";
    public static final String PROPERTY_CHEQUERTGS = "chequeRtgs";
    public static final String PROPERTY_TDS = "tds";
    public static final String PROPERTY_VATTDS = "vATTds";
    public static final String PROPERTY_REVERSESERVICECHARGE = "reverseservicecharge";

    public COPPayments() {
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

    public Date getIssuedate() {
        return (Date) get(PROPERTY_ISSUEDATE);
    }

    public void setIssuedate(Date issuedate) {
        set(PROPERTY_ISSUEDATE, issuedate);
    }

    public Long getPayamount() {
        return (Long) get(PROPERTY_PAYAMOUNT);
    }

    public void setPayamount(Long payamount) {
        set(PROPERTY_PAYAMOUNT, payamount);
    }

    public String getItemcode() {
        return (String) get(PROPERTY_ITEMCODE);
    }

    public void setItemcode(String itemcode) {
        set(PROPERTY_ITEMCODE, itemcode);
    }

    public String getChequeRtgs() {
        return (String) get(PROPERTY_CHEQUERTGS);
    }

    public void setChequeRtgs(String chequeRtgs) {
        set(PROPERTY_CHEQUERTGS, chequeRtgs);
    }

    public String getTds() {
        return (String) get(PROPERTY_TDS);
    }

    public void setTds(String tds) {
        set(PROPERTY_TDS, tds);
    }

    public String getVATTds() {
        return (String) get(PROPERTY_VATTDS);
    }

    public void setVATTds(String vATTds) {
        set(PROPERTY_VATTDS, vATTds);
    }

    public String getReverseservicecharge() {
        return (String) get(PROPERTY_REVERSESERVICECHARGE);
    }

    public void setReverseservicecharge(String reverseservicecharge) {
        set(PROPERTY_REVERSESERVICECHARGE, reverseservicecharge);
    }

}

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
/**
 * Entity class for entity DTPO_POCOP (stored in table dtpo_pocop).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class dtpopocop extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "dtpo_pocop";
    public static final String ENTITY_NAME = "DTPO_POCOP";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_USERID1 = "userId1";
    public static final String PROPERTY_USERID2 = "userId2";
    public static final String PROPERTY_USERID3 = "userId3";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COPVALUE = "copvalue";
    public static final String PROPERTY_PAYMENTPERCENT = "paymentpercent";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_APPROVE = "approve";
    public static final String PROPERTY_SYNCHRONIZE = "synchronize";
    public static final String PROPERTY_REMARKS1 = "remarks1";
    public static final String PROPERTY_REMARKS2 = "remarks2";
    public static final String PROPERTY_REMARKS3 = "remarks3";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_ISADVANCEAMT = "isadvanceamt";
    public static final String PROPERTY_HIGHERPERCENTAGE = "higherpercentage";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_GRNQUANTITY = "grnquantity";
    public static final String PROPERTY_SENDFORAPPROVE = "sendforapprove";
    public static final String PROPERTY_REJECT = "reject";
    public static final String PROPERTY_WIDGET = "widget";

    public dtpopocop() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_COPVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAYMENTPERCENT, (long) 0);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_APPROVE, false);
        setDefaultValue(PROPERTY_SYNCHRONIZE, false);
        setDefaultValue(PROPERTY_ISADVANCEAMT, false);
        setDefaultValue(PROPERTY_HIGHERPERCENTAGE, false);
        setDefaultValue(PROPERTY_SENDFORAPPROVE, false);
        setDefaultValue(PROPERTY_REJECT, false);
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

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public String getUserId1() {
        return (String) get(PROPERTY_USERID1);
    }

    public void setUserId1(String userId1) {
        set(PROPERTY_USERID1, userId1);
    }

    public String getUserId2() {
        return (String) get(PROPERTY_USERID2);
    }

    public void setUserId2(String userId2) {
        set(PROPERTY_USERID2, userId2);
    }

    public String getUserId3() {
        return (String) get(PROPERTY_USERID3);
    }

    public void setUserId3(String userId3) {
        set(PROPERTY_USERID3, userId3);
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

    public BigDecimal getCopvalue() {
        return (BigDecimal) get(PROPERTY_COPVALUE);
    }

    public void setCopvalue(BigDecimal copvalue) {
        set(PROPERTY_COPVALUE, copvalue);
    }

    public Long getPaymentpercent() {
        return (Long) get(PROPERTY_PAYMENTPERCENT);
    }

    public void setPaymentpercent(Long paymentpercent) {
        set(PROPERTY_PAYMENTPERCENT, paymentpercent);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isApprove() {
        return (Boolean) get(PROPERTY_APPROVE);
    }

    public void setApprove(Boolean approve) {
        set(PROPERTY_APPROVE, approve);
    }

    public Boolean isSynchronize() {
        return (Boolean) get(PROPERTY_SYNCHRONIZE);
    }

    public void setSynchronize(Boolean synchronize) {
        set(PROPERTY_SYNCHRONIZE, synchronize);
    }

    public String getRemarks1() {
        return (String) get(PROPERTY_REMARKS1);
    }

    public void setRemarks1(String remarks1) {
        set(PROPERTY_REMARKS1, remarks1);
    }

    public String getRemarks2() {
        return (String) get(PROPERTY_REMARKS2);
    }

    public void setRemarks2(String remarks2) {
        set(PROPERTY_REMARKS2, remarks2);
    }

    public String getRemarks3() {
        return (String) get(PROPERTY_REMARKS3);
    }

    public void setRemarks3(String remarks3) {
        set(PROPERTY_REMARKS3, remarks3);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public Boolean isAdvanceamt() {
        return (Boolean) get(PROPERTY_ISADVANCEAMT);
    }

    public void setAdvanceamt(Boolean isadvanceamt) {
        set(PROPERTY_ISADVANCEAMT, isadvanceamt);
    }

    public Boolean isHigherpercentage() {
        return (Boolean) get(PROPERTY_HIGHERPERCENTAGE);
    }

    public void setHigherpercentage(Boolean higherpercentage) {
        set(PROPERTY_HIGHERPERCENTAGE, higherpercentage);
    }

    public Long getPercentage() {
        return (Long) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(Long percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public Long getGrnquantity() {
        return (Long) get(PROPERTY_GRNQUANTITY);
    }

    public void setGrnquantity(Long grnquantity) {
        set(PROPERTY_GRNQUANTITY, grnquantity);
    }

    public Boolean isSendforapprove() {
        return (Boolean) get(PROPERTY_SENDFORAPPROVE);
    }

    public void setSendforapprove(Boolean sendforapprove) {
        set(PROPERTY_SENDFORAPPROVE, sendforapprove);
    }

    public Boolean isReject() {
        return (Boolean) get(PROPERTY_REJECT);
    }

    public void setReject(Boolean reject) {
        set(PROPERTY_REJECT, reject);
    }

    public String getWidget() {
        return (String) get(PROPERTY_WIDGET);
    }

    public void setWidget(String widget) {
        set(PROPERTY_WIDGET, widget);
    }

}

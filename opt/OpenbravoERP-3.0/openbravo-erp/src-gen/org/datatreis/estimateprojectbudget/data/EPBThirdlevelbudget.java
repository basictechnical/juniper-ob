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
package org.datatreis.estimateprojectbudget.data;

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
import org.openbravo.model.project.Project;
/**
 * Entity class for entity EPB_Thirdlevelbudget (stored in table EPB_Thirdlevelbudget).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EPBThirdlevelbudget extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "EPB_Thirdlevelbudget";
    public static final String ENTITY_NAME = "EPB_Thirdlevelbudget";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUDGETAMT = "budgetAmt";
    public static final String PROPERTY_EPBSUBTASKS = "ePBSubtasks";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_POTENTIALVARIATION = "potentialvariation";
    public static final String PROPERTY_FORECASTCOMPLETION = "forecastCompletion";
    public static final String PROPERTY_UNCOMMITTEDCOST = "uncommittedcost";
    public static final String PROPERTY_JCMWORKTOBEDONE = "jcmWorktobeDone";
    public static final String PROPERTY_JCMCOSTSQFT = "jCMCostSqft";

    public EPBThirdlevelbudget() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_JCMWORKTOBEDONE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JCMCOSTSQFT, new BigDecimal(0));
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

    public Long getBudgetAmt() {
        return (Long) get(PROPERTY_BUDGETAMT);
    }

    public void setBudgetAmt(Long budgetAmt) {
        set(PROPERTY_BUDGETAMT, budgetAmt);
    }

    public EPBSubtasks getEPBSubtasks() {
        return (EPBSubtasks) get(PROPERTY_EPBSUBTASKS);
    }

    public void setEPBSubtasks(EPBSubtasks ePBSubtasks) {
        set(PROPERTY_EPBSUBTASKS, ePBSubtasks);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Long getPotentialvariation() {
        return (Long) get(PROPERTY_POTENTIALVARIATION);
    }

    public void setPotentialvariation(Long potentialvariation) {
        set(PROPERTY_POTENTIALVARIATION, potentialvariation);
    }

    public Long getForecastCompletion() {
        return (Long) get(PROPERTY_FORECASTCOMPLETION);
    }

    public void setForecastCompletion(Long forecastCompletion) {
        set(PROPERTY_FORECASTCOMPLETION, forecastCompletion);
    }

    public Long getUncommittedcost() {
        return (Long) get(PROPERTY_UNCOMMITTEDCOST);
    }

    public void setUncommittedcost(Long uncommittedcost) {
        set(PROPERTY_UNCOMMITTEDCOST, uncommittedcost);
    }

    public BigDecimal getJcmWorktobeDone() {
        return (BigDecimal) get(PROPERTY_JCMWORKTOBEDONE);
    }

    public void setJcmWorktobeDone(BigDecimal jcmWorktobeDone) {
        set(PROPERTY_JCMWORKTOBEDONE, jcmWorktobeDone);
    }

    public BigDecimal getJCMCostSqft() {
        return (BigDecimal) get(PROPERTY_JCMCOSTSQFT);
    }

    public void setJCMCostSqft(BigDecimal jCMCostSqft) {
        set(PROPERTY_JCMCOSTSQFT, jCMCostSqft);
    }

}

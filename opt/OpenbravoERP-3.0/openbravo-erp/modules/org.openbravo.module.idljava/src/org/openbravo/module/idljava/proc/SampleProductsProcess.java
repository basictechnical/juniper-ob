/*
 ************************************************************************************
 * Copyright (C) 2009-2010 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */

package org.openbravo.module.idljava.proc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.common.plm.Product;

/**
 * 
 * @author adrian
 */
public class SampleProductsProcess extends IdlServiceJava {

  @Override
  public String getEntityName() {
    return "Simple Products";
  }

  @Override
  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("SearchKey", Parameter.STRING),
        new Parameter("Description", Parameter.STRING), new Parameter("UOM", Parameter.STRING),
        new Parameter("ProductType", Parameter.STRING) };
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {

    validator.checkNotNull(validator.checkString(values[0], 40), "SearchKey");
    validator.checkNotNull(validator.checkString(values[1], 100000), "Description");
    validator.checkNotNull(validator.checkString(values[2], 32, "UOM"), "UOM");
    validator.checkNotNull(validator.checkString(values[3], 60, "ProductType"), "ProductType");

    return values;
  }

  @Override
  public BaseOBObject internalProcess(Object... values) throws Exception {

    return createProduct((String) values[0], (String) values[1], (String) values[2],
        (String) values[3]);
  }

  public BaseOBObject createProduct(final String searchkey, final String description,
      final String uom, final String producttype

  ) throws Exception {
    // System.out.println("Organisation start");

    Product productExist = findDALInstance(false, Product.class, new Value("searchKey", searchkey));
    if (productExist != null) {
      throw new OBException(Utility.messageBD(conn, "IDL_PR_EXISTS", vars.getLanguage())
          + searchkey);
    }
    try {
      String url = "jdbc:postgresql://localhost:5432/juniper";
      String username = "postgres";
      String password = "root123";
      Class.forName("org.postgresql.Driver");
      Connection conn = DriverManager.getConnection(url, username, password);
      System.out.println("databaseconectionsuccssfull");
      //
      // Create a CallableStatement to execute the CREATE_USERS procedure
      //
      PreparedStatement stmt = conn
          .prepareStatement("select idljava_productimport (?,?,?,?) from dual ");
      System.out.println("List Of Items Inserted/n" + searchkey + " ");

      // Price purchase
      stmt.setString(1, searchkey);
      stmt.setString(2, description);
      stmt.setString(3, uom);
      stmt.setString(4, producttype);

      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.destroy();
      }
    }

    // End process
    OBDal.getInstance().commitAndClose();

    return null;
  }
}

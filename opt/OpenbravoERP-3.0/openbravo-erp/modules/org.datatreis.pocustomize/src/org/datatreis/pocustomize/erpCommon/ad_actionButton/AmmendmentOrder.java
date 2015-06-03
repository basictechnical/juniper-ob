package org.datatreis.pocustomize.erpCommon.ad_actionButton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Map;



import org.datatreis.pocustomize.data.COPPayments;
import org.datatreis.pocustomize.data.DTPOItemcop;
import org.datatreis.pocustomize.data.DTPOPocopfile;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;

import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.json.DataResolvingMode;
import org.openbravo.service.json.DataToJsonConverter;
import org.openbravo.model.ad.access.User;
import java.util.Date;

public class AmmendmentOrder extends DalBaseProcess{

	  @Override
	  protected void doExecute(ProcessBundle bundle) throws Exception {
		  String strDoc = null;
		  //alter table c_order enable trigger dt_projectdocno_add_trg;
		  try {
		      System.out.println("Default parameters  " + bundle.getParamsDefalated());
		      OBContext.setAdminMode(true); 
		      User currentUser = OBContext.getOBContext().getUser();
		      final String orderID = (String) bundle.getParams().get("C_Order_ID");
		      System.out.println("orderID :"+orderID);
		      final Order poObj= OBDal.getInstance().get(Order.class,orderID);
		      Order objCloneOrder = (Order) DalUtil.copy(poObj, false);
		      objCloneOrder.setProject(poObj.getProject());
		      objCloneOrder.setDtpoOrderscenario(poObj.getDtpoOrderscenario());
		 	  objCloneOrder.setCreatedBy(currentUser);
		 	  objCloneOrder.setUpdatedBy(currentUser);
		 	  objCloneOrder.setCreationDate(new Date());
		 	  objCloneOrder.setUpdated(new Date());
		 	  objCloneOrder.setSalesTransaction(false);
		 	  objCloneOrder.setDocumentStatus("DR");
		 	  objCloneOrder.setDocumentAction("CO");
		 	  objCloneOrder.setProcessed(false);
		 	  objCloneOrder.setOrderDate(new Date());
		 	  objCloneOrder.setAccountingDate(new Date());
		 	  objCloneOrder.setDtPlaindocno(poObj.getDtPlaindocno());
		 	  objCloneOrder.setPosted("N");
		 	  objCloneOrder.setSalesTransaction(poObj.isSalesTransaction());
		 	  objCloneOrder.setScheduledDeliveryDate(new Date());
		 	  double amt = 0.0; 
		 	  BigDecimal grandamt = BigDecimal.valueOf(amt);
		 	  objCloneOrder.setSummedLineAmount(grandamt);
		 	  objCloneOrder.setGrandTotalAmount(grandamt); 
		 	  objCloneOrder.setDtAmmendment(poObj.getDtAmmendment() + 1);
		 	  String documentNo = poObj.getDocumentNo();
		 	  System.out.println("documentNo :"+documentNo);
		 	 /* if(documentNo.contains("/A")){
		 		    String number = documentNo.substring(0, documentNo.length() - 1); 
		 		    strDoc =documentNo.substring(documentNo.length()-1,documentNo.length());
                    int amendNumber = Integer.parseInt(strDoc) + 1;
					String currentNumber = Integer.toString(amendNumber);		
					System.out.println("currentNumber :"+currentNumber);
					objCloneOrder.setDocumentNo(number + currentNumber);
		 	  }else 
		 		 objCloneOrder.setDocumentNo(poObj.getDocumentNo()+"/A1");
		 	*/    
		 	  OBDal.getInstance().save(objCloneOrder);
		 	  poObj.setDtpoInactive(true);
		 	  OBDal.getInstance().save(poObj);
		 	  //OBDal.getInstance().commitAndClose();
		 	  for (DTPOPocopfile spreadsheetLine : poObj.getDTPOPocopfileList()) {
		 		  if(spreadsheetLine.getFiletype().equals("COP")){
		 			 DTPOPocopfile objSpreadsheet = OBDal.getInstance().get(DTPOPocopfile.class, spreadsheetLine.getId());
		 			 DTPOPocopfile objCloneSpreadsheet = (DTPOPocopfile) DalUtil.copy(objSpreadsheet, false);
		 			 System.out.println("if condition");
		 			 System.out.println("id created was "+objCloneOrder.getId());
		 			 objCloneSpreadsheet.setOrder(objCloneOrder);
		 			 OBDal.getInstance().save(objCloneSpreadsheet);
		 			 for (DTPOItemcop itemCopLine : objSpreadsheet.getDTPOItemcopList()) { 
		 				 System.out.println("item cop for loop executed");
		 				DTPOItemcop objItemCop = OBDal.getInstance().get(DTPOItemcop.class, itemCopLine.getId());
		 				DTPOItemcop objCloneItemCop = (DTPOItemcop) DalUtil.copy(objItemCop, false);
		 				objCloneItemCop.setDtpoPocopfile(objCloneSpreadsheet);
		 				OBDal.getInstance().save(objCloneItemCop);
		 			 }
		 			for (COPPayments copPayments : objSpreadsheet.getDTPOCoppaymentsList()) { 
		 				System.out.println("COP Payments for loop executed");
		 				COPPayments objCopPayments = OBDal.getInstance().get(COPPayments.class, copPayments.getId());
		 				COPPayments objCloneCOPPayments = (COPPayments) DalUtil.copy(objCopPayments, false);
		 				objCloneCOPPayments.setDtpoPocopfile(objCloneSpreadsheet);
		 				OBDal.getInstance().save(objCloneCOPPayments);
		 			 }
		 		  
		 	  }
		 	  }
		 	
			  }catch (final Exception e) {
			        e.printStackTrace(System.err);
			    }
		 	
		 	
	  }

}
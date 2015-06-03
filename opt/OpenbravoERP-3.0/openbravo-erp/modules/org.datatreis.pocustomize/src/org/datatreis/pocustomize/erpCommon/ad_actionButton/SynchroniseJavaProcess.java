package org.datatreis.pocustomize.erpCommon.ad_actionButton;

import org.datatreis.pocustomize.data.DTPOPocopfile;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

public class SynchroniseJavaProcess extends DalBaseProcess{

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
		      String bPartnerName = poObj.getBusinessPartner().getName();
		      String documentNo = poObj.getDocumentNo();
		      String projectName = poObj.getProject().getName();
		      String projectID = poObj.getProject().getId();
		      System.out.println("bPartnerName :"+bPartnerName+"documentNo :"+documentNo+"projectName :"+projectName
		    		  +"projectID :"+projectID);
		      
		      for (OrderLine orderLineObj : poObj.getOrderLineList()) {
		     // OrderLine orderLineObj = OBDal.getInstance().get(OrderLine.class,orderID);
		      String productSearchkey = orderLineObj.getProduct().getSearchKey();
		      System.out.println("bPartnerName :"+bPartnerName+"documentNo :"+documentNo+"projectName :"+projectName
		    		  +"projectID :"+projectID+"productSearchkey :"+productSearchkey);
		      
		      final OBError msg = new OBError();
		         msg.setType("Success");
		         msg.setMessage("Process Completed Successfully");
		         msg.setTitle("");
		         bundle.setResult(msg);
		      
		      }
		  }catch (final Exception e) {
		        e.printStackTrace(System.err);
		    }
		  
	  }

}

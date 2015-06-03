package org.datatreis.pocustomize.erpCommon.ad_actionButton;

import org.datatreis.pocustomize.data.DTPOPocopfile;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
public class CreateCOP extends DalBaseProcess {

	  @Override
	  protected void doExecute(ProcessBundle bundle) throws Exception {
	    try {
	      System.out.println("Default parameters  " + bundle.getParamsDefalated());
	      OBContext.setAdminMode(true);
	      //final String evalComments = (String) bundle.getParams().get("comments");
	      final String poCOPFileID = (String) bundle.getParams().get("Dtpo_Pocopfile_ID");
	      System.out.println("poCOPFileID :"+poCOPFileID);
	      final DTPOPocopfile poCOPObj = OBDal.getInstance().get(DTPOPocopfile.class,
	    		  poCOPFileID);
	      
	      String fileName = poCOPObj.getFilename();
	      System.out.println("File Name :" +fileName);
	      String orderID = poCOPObj.getOrder().getId();
	      System.out.println("orderID :"+orderID); 
	      
	         Connection conn = null;
	    	 PreparedStatement prepareStmnt = null;
	         ResultSet rs = null;
	         try{
	         Class.forName("org.postgresql.Driver");
	    	 conn = DriverManager.
	    	 getConnection("jdbc:postgresql://localhost:5932/openbravo","postgres", "SYSTEM");
	    	 System.out.println("Database Connection successful");
	    	 Statement statement = null;
	    	 String sqlStatement = "select filename from dtpo_pocopfile where c_order_id=? and filetype='LIMP'";
	    	 prepareStmnt  = conn.prepareStatement(sqlStatement);
	    	 prepareStmnt.setString(1, orderID);
		     rs = prepareStmnt.executeQuery();
		     while(rs.next()){
	                System.out.println("BOQ File Name :"+rs.getString("filename"));
	                String boqFileName = rs.getString("filename");
	                String filePath = "/var/lib/tomcat6/webapps/POCOP/WEB-INF/books";
	                String sourcePath = filePath+"/"+boqFileName;
	                String destinationPath = filePath+"/"+fileName;
	                File propFile = new File(filePath, boqFileName); 
	                System.out.println("Execute :"+propFile.canExecute()+"Read :"+propFile.canRead()+"write :"+propFile.canWrite());
	                propFile.setExecutable(true);
	                propFile.setReadable(true);
	                propFile.setWritable(true,false);
	                if (propFile.exists()) {  
	                  System.out.println("BOQ File Exist in Directory"+filePath);
	                  copyFileUsingFileStreams(new File(sourcePath), new File( destinationPath));
	                  File newlyCreatedFile = new File(filePath, fileName); 
	                  System.out.println("cop file write :"+newlyCreatedFile.canWrite()+"cop file read "+newlyCreatedFile.canRead()+"cop file execute :"+newlyCreatedFile.canExecute());
	                  newlyCreatedFile.setExecutable(true);
	                  newlyCreatedFile.setReadable(true);
	                  newlyCreatedFile.setWritable(true, false);
	                  //Runtime.getRuntime().exec("chmod -R 766 newlyCreatedFile");
	                } else {  
	                	System.out.println("BOQ File NOT Exist in Directory"+filePath);  
	                	throw new Exception("BOQ File NOT Exist in Directory"+filePath);
	                }  
	            }
	            rs.close();
				//updateQuery.setString(2, bookname);*/
	             final OBError msg = new OBError();
		         msg.setType("Success");
		         msg.setMessage(fileName +" COP FaceSheet Created Successfully Open File On SpreadSheet Import Window");
		         msg.setTitle("");
		         bundle.setResult(msg);
	         }catch (final Exception e) {
	             e.printStackTrace(System.err);
	             final OBError msg = new OBError();
	             msg.setType("Error");
	             msg.setMessage(e.getMessage());
	             msg.setTitle("Error Occurred BOQ File Not There ");
	             bundle.setResult(msg);
	           } finally {
	             OBContext.setAdminMode(false);
	           }
	    }
	    catch (final Exception e) {
	        e.printStackTrace(System.err);
	    }
	  }
private static void copyFileUsingFileStreams(File source, File dest) throws 
BiffException, IOException, WriteException {

  InputStream input = null;

  OutputStream output = null;

  try {
      System.out.println("copy method calling"); 
      input = new FileInputStream(source);
      
      output = new FileOutputStream(dest);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
               
                
      }
      Runtime.getRuntime().exec("chmod 777 output");
      
  } catch(Exception e){
              e.printStackTrace(System.err);
  } finally {
         input.close();
         output.close();
   }

 }

}

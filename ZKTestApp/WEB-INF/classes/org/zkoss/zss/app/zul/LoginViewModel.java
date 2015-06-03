package org.zkoss.zss.app.zul;



import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import sun.misc.BASE64Encoder;
import tutorial.MyProperties;
 
public class LoginViewModel extends SelectorComposer<Component> {
 
    @Wire
    private Component component;
    @Wire
    private Textbox userName;
    @Wire
    private Textbox passWord;
    @Wire
    private Button login;
 
    @Listen("onClick=#login")
    public void doLogin() throws IOException, SQLException, NoSuchAlgorithmException {
        if (validate()) {
            Executions.sendRedirect("/index.zul");
        }
    }
    private boolean validate() throws IOException, SQLException, NoSuchAlgorithmException {
    	
        if (isNull(userName.getValue())) {
            Messagebox.show("Please enter the username");
            userName.setFocus(true);
        } else if (isNull(passWord.getValue())) {
            Messagebox.show("Please enter the password");
            passWord.setFocus(true);
        } else if(!(isNull(userName.getValue())) && !(isNull(passWord.getValue()))){
        	           String zkUser = userName.getValue();
        	           String zkPwd = passWord.getValue();
        	           String generatedPassword = null;
        	           System.out.println("DB Process Started.....");
        	           
        	           MessageDigest md = MessageDigest.getInstance("SHA1");
        	           md.reset();
        	           byte[] buffer = zkPwd.getBytes();
        	           md.update(buffer);
        	           byte[] digest = md.digest();
        	            
        	           String hexStr = "";
        	           for (int i = 0; i < digest.length; i++) {
        	           hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
        	           }
        	           BASE64Encoder encoder = new BASE64Encoder();
        	           
        	          // return encoder.
        	           //return hexStr;
        	           
        	           /*MessageDigest md = MessageDigest.getInstance("MD5");
        	                       //Add password bytes to digest
        	           md.update(zkPwd.getBytes());
        	                       //Get the hash's bytes
        	           byte[] bytes = md.digest();
        	                       //This bytes[] has bytes in decimal format;
        	                       //Convert it to hexadecimal format
        	                       StringBuilder sb = new StringBuilder();
        	                       for(int i=0; i< bytes.length ;i++)
        	                       {
        	                           sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        	                       }
        	                       //Get complete hashed password in hex format
        	                       generatedPassword = sb.toString();*/
        	                   
        	                   System.out.println("hexStr "+hexStr+"\n");
        	                   /*if ((hexStr.length()) % 2 > 0)
        	                       throw new NumberFormatException("Input string was not in a correct format.");
        	                   byte[] buffer1 = new byte[hexStr.length() / 2];
        	                   int i = 2;
        	                   while (i < hexStr.length())
        	                   {
        	                       buffer[i / 2] = (byte)Integer.parseInt(hexStr.substring(i, i + 2),16);
        	                       i += 2;
        	                   }
        	           System.out.println("buffer1 :"+buffer1+"\n");*/
        	   		
        	   		MyProperties prop = new MyProperties();
        	   		String driver = "org.postgresql.Driver";
        	   		System.out.println(driver);
        	   		String url = prop.url;
        	   		System.out.println(url);
        	   		String username = prop.username;
        	   		System.out.println(username);
        	   		String password = prop.password;
        	   		System.out.println(password);
        	   		Connection conn = null;
        	   		ResultSet rst = null;
        	   		PreparedStatement zkUserQuery = null;
        	   		try{
        	   			System.out.println("Try Block Executed......");
        	   		Class.forName(driver);  
        	   			conn = DriverManager.getConnection(url, username, password); 
        	   			System.out.println("zkUser :"+zkUser+"\n"+"zkPwd :"+zkPwd+"\n");
        	   			String query = "select count(*) from jcm_zkuser where username ='"+zkUser+"' and zkpassword = '"+zkPwd+"'";
        	   		    System.out.println("query :"+query+"\n");
        	   			zkUserQuery = conn.prepareStatement("select * from jcm_zkuser where username =? and zkpassword = ? and jcm_budgetimport = ? ");
        	   		zkUserQuery.setString(1, zkUser);
        	   		zkUserQuery.setString(2, zkPwd);
        	   		zkUserQuery.setString(3, "Y");
        	   		System.out.println("zkquery :"+zkUserQuery.toString());
        	   		rst = zkUserQuery.executeQuery();
        	   		//bigDecimal vCount = rst.
        	   		if(rst.next()){
        	   			System.out.println("Resultset if condition success..........");
        	   			return true;
        	   		}else {
        	            Messagebox.show("You Don't Have Priviliges to Access This Screen(or)Username and Password Wrong");
        	            userName.setValue("");
        	            passWord.setValue("");
        	            userName.setFocus(true);
        	        }
        	   		}catch(Exception e){
        	   			System.out.println(e);
        	   		}
        	   		finally {  
        	            if (conn != null) {  
        	                try {  
        	                    conn.close();  
        	                } catch (SQLException e) {  
        	                    e.printStackTrace();  
        	                }  
        	            }  
        	            if (zkUserQuery != null) {  
        	                try {  
        	                	zkUserQuery.close();  
        	                } catch (SQLException e) {  
        	                    e.printStackTrace();  
        	                }  
        	            }  
        	            if (rst != null) {  
        	                try {  
        	                	rst.close();  
        	                } catch (SQLException e) {  
        	                    e.printStackTrace();  
        	                }  
        	            } 
        	   		}    
             } 
        else {
            Messagebox.show("Invalid Username and Password..");
            userName.setValue("");
            passWord.setValue("");
            userName.setFocus(true);
        }
        return false;
    }
    public boolean isNull(String value) {
        boolean result = true;
        if (value != null && value.trim().length() > 0
                && !value.trim().equalsIgnoreCase("null")) {
            result = false;
        }
        return result;
    }
}
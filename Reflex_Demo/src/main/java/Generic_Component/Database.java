package Generic_Component;

	
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;	

public class Database extends Base_class {
	
				
	    	public static void  database() throws ClassNotFoundException, SQLException {
	    													
	    	
					//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	                String dbUrl = "jdbc:mysql://db.qa.cove.kahaapi.com:3306/user";					

					//Database Username		
					String username = "apptest";	
	                
					//Database Password		
					String password = "AppTest123";				

					//Query to Execute		
					String query = "select * from clove_qa_db.user;";	
	                
	         	    //Load mysql jdbc driver		
	           	    Class.forName("com.mysql.jdbc.Driver");			
	           
	           		//Create Connection to DB		
	            	Connection con = DriverManager.getConnection(dbUrl,username,password);
	          
	          		//Create Statement Object		
	        	   Statement stmt = con.createStatement();					
	       
	       			// Execute the SQL Query. Store results in ResultSet		
	         		ResultSet rs= stmt.executeQuery(query);							
	         
	         		// While Loop to iterate through all data and print results		
					while (rs.next()){
				        		String myName = rs.getString(1);								        
	                            String myAge = rs.getString(2);					                               
	                            System. out.println(myName+"  "+myAge);		
	                    }		
	      			 // closing DB Connection		
	      			con.close();			
			}
	}

	
	
	
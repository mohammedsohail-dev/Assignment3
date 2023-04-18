package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.bson.Document;

import mongodb.DAOQuery1;
import mongodb.DAOQuery2;
import mongodb.DAOQuery3;
import mongodb.DAOQuery4;
import mongodb.DAOQuery5;



public class Producer {
	  public static void main(String[] args) throws IOException, TimeoutException {
		  
		  TopicExchange.declareExchange("topic-exchange");
		  String fileName = "src/main/resources/Config.txt"; // Update with the actual file path
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
                
	            
	            while ((line = reader.readLine()) != null) {
	                String[] elements = line.split(","); // Split the line by whitespace
	                
	                if(elements[0].equals("Cost")) {
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4]+"-"+elements[5];
	                	TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	        	         
	                	DAOQuery1 query1 = new DAOQuery1();
	        	         List<Document> queryy1 = query1.getCosts(elements[1], elements[2], elements[3], elements[4], elements[5]);
	        	         String query1message= "{"+ "\"value\":" + queryy1.get(0).get("value").toString()+ "," + "\"year\":" + elements[1] + "," + "\"state\":" +elements[2]+ "," + "\"Type\":" +elements[3]+ "," + "\"Length\":" +elements[4] +"}"; // Do final touch up here
	        	         TopicExchange.publishMessage(query1message,"topic-exchange",Queuename);
	        	         System.out.println("Query 1 was Published");
	                }
	                
	                else if(elements[0].equals("Top5") & elements[1].equals("Expensive")) {
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4];
	                	TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	             	     DAOQuery2 query2 = new DAOQuery2();
	             	     List<Document> queryy2 = query2.getExpensivestates(elements[2], elements[3], elements[4]);
	             	     String query2message= "{"+ "\"state1\":" + queryy2.get(0).get("state_1").toString()+ "," + "\"state2\":" + queryy2.get(0).get("state_2").toString() + "," +  "\"state3\":" + queryy2.get(0).get("state_3").toString() + "," +  "\"state4\":" + queryy2.get(0).get("state_4").toString() + "," +  "\"state5\":" + queryy2.get(0).get("state_5").toString() +  "," + "\"year\":" + elements[2] + "," + "\"Type\":" +elements[3] +","+ "\"Length\":" +elements[4]+ "}"; 
	             	     TopicExchange.publishMessage(query2message,"topic-exchange",Queuename);
	             	    System.out.println("Query 2 was Published");
	                }
//	                
//	                
	                else if(elements[0].equals("Top5") & elements[1].equals("Economic")) {
	                	
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4];
	                	TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename); 
	             	     DAOQuery3 query3 = new DAOQuery3();
	             	     List<Document> queryy3 = query3.getEconomicstates(elements[2], elements[3], elements[4]);
	              	     String query3message= "{"+ "\"state1\":" + queryy3.get(0).get("state_1").toString()+ "," + "\"state2\":" + queryy3.get(0).get("state_2").toString() + "," +  "\"state3\":" + queryy3.get(0).get("state_3").toString() + "," +  "\"state4\":" + queryy3.get(0).get("state_4").toString() + "," +  "\"state5\":" + queryy3.get(0).get("state_5").toString() +  "," + "\"year\":" + elements[2] + "," + "\"Type\":" +elements[3] +","+ "\"Length\":" +elements[4]+ "}"; 
	              	     TopicExchange.publishMessage(query3message,"topic-exchange",Queuename);
	              	     System.out.println("Query 3 was Published"); 
	                }
	                
	                else if(elements[0].equals("Top5") & elements[1].equals("HighestGrow")) {
	                	
	                	
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+ Integer.toString(Math.abs(Integer.parseInt(elements[2])-Integer.parseInt(elements[3])));
	                	TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename); 
	                	DAOQuery4 query4 = new DAOQuery4();
	             	    
	                	List<Document> queryy4 = query4.getgrowthstates(elements[2], elements[3], elements[4],elements[5]);
	                	String query4message= "{"+ "\"state1\":" + queryy4.get(0).get("state_1").toString()+ "," + "\"state2\":" + queryy4.get(0).get("state_2").toString() + "," +  "\"state3\":" + queryy4.get(0).get("state_3").toString() + "," +  "\"state4\":" + queryy4.get(0).get("state_4").toString() + "," +  "\"state5\":" + queryy4.get(0).get("state_5").toString() +  "," + "\"year_low\":" + elements[2] + "," + "\"year_up\":" +elements[3] +","+ "\"Type\":" +elements[4] +","+ "\"Length\":" +elements[5]+ "}"; 
	                	TopicExchange.publishMessage(query4message,"topic-exchange",Queuename);
	             	   System.out.println("Query 4 was Published");
	                }
	                
	                
	                else if(elements[0].equals("AverageExpense")) {
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3];
	                	TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename); 
	            	    DAOQuery5 query5 = new DAOQuery5();
	            	    List<Document> queryy5 = query5.getAveragesstates(elements[1], elements[2], elements[3]);
	            	    String query5message= "{"+ "\"Northeast\":" + queryy5.get(0).get("Northeast")+ "," + "\"Southeast\":" + queryy5.get(0).get("Southeast") + "," +  "\"Midwest\":" + queryy5.get(0).get("Midwest") + "," +  "\"southwest\":" + queryy5.get(0).get("Southwest") + "," +  "\"west\":" + queryy5.get(0).get("West") + "," + "\"year\":" + elements[1] + "," + "\"Type\":" +elements[2] + "\"Length\":" +elements[3] + "}";
	        	        TopicExchange.publishMessage(query5message,"topic-exchange",Queuename);
	        	        System.out.println("Query 5 was Published");
	                	
	                }
	                
	                
	                
	            }} catch (IOException e) {
	                e.printStackTrace();
	            }
   
	  }
}

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

public class Consumer {
	public static void main(String[] args) throws IOException, TimeoutException {
		 TopicExchange.declareExchange("topic-exchange");
		  String fileName = "src/main/resources/Config.txt"; // Update with the actual file path
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
               
	            
	            while ((line = reader.readLine()) != null) {
	                String[] elements = line.split(","); // Split the line by whitespace
	                
	                if(elements[0].equals("Cost")) {
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4]+"-"+elements[5];
	                	TopicExchange.declareExchange("topic-exchange");
	            	    

	            	    TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	            	    Thread subscribe = new Thread(() -> {
	            		      try {

	            		        TopicExchange.subscribeMessage(Queuename);

	            		        
	            		      } catch (IOException | TimeoutException e) {
	            		        e.printStackTrace();
	            		      }
	            		    });
	            		    subscribe.start();
	            	    
	                }
	                
	                else if(elements[0].equals("Top5") & elements[1].equals("Expensive")) {
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4];
                        TopicExchange.declareExchange("topic-exchange");
	            	    

	            	    TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	            	    Thread subscribe = new Thread(() -> {
	            		      try {

	            		        TopicExchange.subscribeMessage(Queuename);

	            		        
	            		      } catch (IOException | TimeoutException e) {
	            		        e.printStackTrace();
	            		      }
	            		    });
	            		    subscribe.start();
	                }
//	                
//	                
	                else if(elements[0].equals("Top5") & elements[1].equals("Economic")) {
	                	
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3]+"-"+elements[4];
                        TopicExchange.declareExchange("topic-exchange");
	            	    

	            	    TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	            	    Thread subscribe = new Thread(() -> {
	            		      try {

	            		        TopicExchange.subscribeMessage(Queuename);

	            		        
	            		      } catch (IOException | TimeoutException e) {
	            		        e.printStackTrace();
	            		      }
	            		    });
	            		    subscribe.start();
	                }
	                
	                else if(elements[0].equals("Top5") & elements[1].equals("HighestGrow")) {
	                	
	                	
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+ Integer.toString(Math.abs(Integer.parseInt(elements[2])-Integer.parseInt(elements[3])));
                        TopicExchange.declareExchange("topic-exchange");
	            	    

	            	    TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	            	    Thread subscribe = new Thread(() -> {
	            		      try {

	            		        TopicExchange.subscribeMessage(Queuename);

	            		        
	            		      } catch (IOException | TimeoutException e) {
	            		        e.printStackTrace();
	            		      }
	            		    });
	            		    subscribe.start();
	                }
	                
	                
	                else if(elements[0].equals("AverageExpense")) {
	                	
	                	String Queuename = elements[0]+"-"+elements[1]+"-"+elements[2]+"-"+elements[3];
                        TopicExchange.declareExchange("topic-exchange");
	            	    

	            	    TopicExchange.declareQueues(Queuename);
	            	    TopicExchange.declareBindings(Queuename,"topic-exchange",Queuename);
	            	    Thread subscribe = new Thread(() -> {
	            		      try {

	            		        TopicExchange.subscribeMessage(Queuename);

	            		        
	            		      } catch (IOException | TimeoutException e) {
	            		        e.printStackTrace();
	            		      }
	            		    });
	            		    subscribe.start();
	                }
	                
	                
	                
	            }} catch (IOException e) {
	                e.printStackTrace();
	    }}}
	



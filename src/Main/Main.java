package Main;
import models.vehicls.*;
import models.spots.*;
import models.tickets.*;
import services.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import exceptions.*;
public class Main {
	public static void main(String []args) throws IOException  {
		Scanner input=new Scanner (System.in);
		SpotManagement sp=new SpotManagement();
        try (BufferedReader br = new BufferedReader(new FileReader("spots.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
        String[] data = line.split(";");
        String type = data[0];
        String id = data[1];
        boolean occupied = Boolean.parseBoolean(data[2]);
        Spots spot = null;
        }
        } catch (Exception e) {
            sp = new SpotManagement();
            System.out.println("No saved data found. Starting fresh.");
        }
        if (sp.getSpots().isEmpty()) {
        sp.addSpot(new RegularSpot("A1"));
        sp.addSpot(new RegularSpot("A2"));
        sp.addSpot(new RegularSpot("A3"));
        sp.addSpot(new RegularSpot("A4"));
        sp.addSpot(new CompactSpot("A10"));
        sp.addSpot(new CompactSpot("A11"));
        sp.addSpot(new CompactSpot("A12"));
        sp.addSpot(new CompactSpot("A13"));
        sp.addSpot(new ElectricSpot("A14"));
        sp.addSpot(new ElectricSpot("A15"));
        sp.addSpot(new ElectricSpot("A16"));
        sp.addSpot(new ElectricSpot("A17"));
        sp.addSpot(new LargeSpot("A18"));
        sp.addSpot(new LargeSpot("A19"));
        sp.addSpot(new LargeSpot("A20"));
        sp.addSpot(new LargeSpot("A21"));
        }
        EntryRegistration entry = new EntryRegistration(sp);

        ExitRegistration exit=new ExitRegistration(entry,sp);
		while (true) {
			int choice = 0;
			double price=0.0;
			 try {
			     System.out.println("====================================");
			     System.out.println("        PARKING MANAGEMENT");
			     System.out.println("====================================");
			     System.out.println("1 - Register Entry");
			     System.out.println("2 - Register Exit");
			     System.out.println("3 - Show Occupancy Rate");
			     System.out.println("4 - Quit");
			     System.out.print("Choose: ");
			      choice = input.nextInt();
	                if (choice>4) {
	                	continue;
	                }
			    }
			   catch(InputMismatchException d) {
		        	System.out.println("wrong! enter a number between 1 and 4");
		            input.nextLine();
		            continue;
		        }
			            // ---------------------------
			            // OPTION 1 : VEHICLE ENTRY
			            // ---------------------------
			     if (choice == 1) {
			                System.out.print("Enter license plate: ");
			                int licensePlate = input.nextInt();
			                System.out.print("Enter brand: ");
			                String brand = input.next();
			                System.out.println("Choose vehicle type: ");
			                System.out.println("1 - Car");
			                System.out.println("2 - Electric Vehicle");
			                System.out.println("3 - Motorcycle");
			                System.out.println("4 - Truck");
			                System.out.print("Choose: ");
			                int type = input.nextInt();
			                if (type>4) {
			                	continue;
			                }
			                System.out.println("Choose ticket type: ");
			                System.out.println("1 - Hourly");
			                System.out.println("2 - Daily");
			                System.out.println("3 - Monthly");
			                System.out.println("the tickets will be a higher type if the customer crosse the limit time");
			                System.out.print("Choose: ");
			                int type1= input.nextInt();
			                if (type1>3) {
			                	continue;
			                }
							Tickets ticket = null;
							switch (type) {
							case 1:
								Car car=new Car(licensePlate,brand);
								switch (type1) {
								case 1:
						            try {
						                  ticket = entry.registerEntry(car, RegularSpot.class,"Hourly");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId());
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }catch(NullPointerException f) {
						                	    continue;
						                }
						        break;
								case 2 :
						            try {
						            	 ticket =entry.registerEntry(car, RegularSpot.class,"daily");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                	       continue;
					                }
						        break;
								case 3 :
							         try {
							            	 ticket =entry.registerEntry(car, RegularSpot.class,"Monthly");
							                System.out.println("Entry registered! Ticket ID: " +ticket.getTicketId()); 
							            } catch (SpotNotAvailableException e) {
							                System.out.println(e.getMessage());
							                }
							             catch(NullPointerException f) {
						                	    continue;
						                }
							    break;
								}
							break;
							case 2:
								electric_vehicle electricvehicle=new electric_vehicle(licensePlate,brand);
								switch (type1) {
								case 1:
						            try {
						                  ticket =  entry.registerEntry(electricvehicle, ElectricSpot.class,"Hourly");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                    	continue;
					                }
						        break;
								case 2 :
						            try {
						            	 ticket =entry.registerEntry(electricvehicle, ElectricSpot.class,"daily");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                   	continue;
					                }
						        break;
								case 3 :
							         try {
							            	 ticket = entry.registerEntry(electricvehicle, ElectricSpot.class,"Monthly");
							                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
							            } catch (SpotNotAvailableException e) {
							                System.out.println(e.getMessage());
							                }
							         catch(NullPointerException f) {
						                	   continue;
						                }
							        break;
								}
							break;
							case 3:
								Motorcycle motor=new Motorcycle(licensePlate,brand);
								switch (type1) {
								case 1:
						            try {
						                  ticket = entry.registerEntry(motor, CompactSpot.class,"Hourly");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                   	continue;
					                }
						        break;
								case 2 :
						            try {
						            	 ticket = entry.registerEntry(motor, CompactSpot.class,"daily");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                	    continue;
					                }
						        break;
								case 3 :
							         try {
							            	 ticket =entry.registerEntry(motor, CompactSpot.class,"Monthly");
							                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
							            } catch (SpotNotAvailableException e) {
							                System.out.println(e.getMessage());
							                }
							         catch(NullPointerException f) {
						                	continue;
						                }
							        break;
								}
							break;
							case 4:
								Truck truck=new Truck(licensePlate,brand);
								switch (type1) {
								case 1:
						            try {
						                  ticket = entry.registerEntry(truck, LargeSpot.class,"Hourly");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                  	continue;
					                }
						        break;
								case 2 :
						            try {
						            	 ticket = entry.registerEntry(truck, LargeSpot.class,"daily");
						                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
						            } catch (SpotNotAvailableException e) {
						                System.out.println(e.getMessage());
						                }
						            catch(NullPointerException f) {
					                  	continue;
					                }
						        break;
								case 3 :
							         try {
							            	ticket = entry.registerEntry(truck, LargeSpot.class,"Monthly");
							                System.out.println("Entry registered! Ticket ID: " + ticket.getTicketId()); 
							            } catch (SpotNotAvailableException e) {
							                System.out.println(e.getMessage());
							                }
							         catch(NullPointerException f) {
						                	continue;
						                }
							        break;
								}
								break;
						    }
			     }else if (choice == 2) {
			    	 int pay;
			    	                try {
				                System.out.print("Enter the ticketid to exit: ");
				                int id=input.nextInt();
				                price = exit.registerExit(id);
				                }catch(TicketNotFoundException e) {
				                	System.out.println(e.getMessage());
				                }
			    	                if (price==0) {
			    	                	System.out.println("THANK YOU");
			    	                }else {
				                System.out.println("====================================");
				                System.out.println("    THE BILL: ");
				                System.out.println("=================================");
				                System.out.println("    THE TOTAL: "+price+"DZ");
				                System.out.println("=================================");
				                try {
				                	System.out.println(" WHICH WAY YOU WANT TO PAY: ");
				                	System.out.println("1-CARD ");
				                	System.out.println("2-CASH ");
				                	System.out.print("Choose: ");
				                	pay=input.nextInt();
				                	if (pay!=1 && pay!=2) {
				                            throw new InvalidPaymentException("Invalid payment option! Choose 1 or 2.");
				                }else {
				                	System.out.println("SUCCESFUL PAYEMENT");
				                }
				                	}
				                catch(InvalidPaymentException d) {
				                	System.out.println(d.getMessage());
				                }
				                }  
		                        }
			                    else if (choice ==3) {
		                        	      System.out.println("THE OCCUPANCY RATE: "+sp.getOccupancyRate());
		                                         }else if (choice==4) {
		                                        	 saveData(sp);
		                                        	 break;
		                                         }
        }
}

	   public static void saveData(SpotManagement sp) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("spots.txt"));
            out.writeObject(sp);
            out.close();
            System.out.println("Data saved.");
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
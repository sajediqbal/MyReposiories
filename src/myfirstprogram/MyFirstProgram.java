/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstprogram;
import java.util.GregorianCalendar;

/**
 *
 * @author Sajid
 */
public class MyFirstProgram {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Utilities.initialize();
    	
    	GregorianCalendar dateOrdered = new GregorianCalendar(2015, 2-1,13);
    	GregorianCalendar dateDispatched = new GregorianCalendar(2015, 2-1,15);
    	GregorianCalendar dateReturned = new GregorianCalendar(2015, 3-1,10);
    	
    	Order myFirstOrder = new Order(184813, 50, 100, 607, dateOrdered);
        
    	
    	
    	System.out.println("Receive Order");
        System.out.println("=============");
    	System.out.println("Order ID:"+myFirstOrder.getOrderID());
         	System.out.println("Order Date: "+Utilities.dateParser(myFirstOrder.getDateOrdered()));
            System.out.println("Order Station:"+myFirstOrder.getOrderStation());
            System.out.println("Station Distance:"+myFirstOrder.getOrderDistance()+"KM");
            System.out.println("Station Tonnage:"+myFirstOrder.getOrderTonnage()+"MT");
    		System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());

    		
    		System.out.println("\nBooking Order");
            System.out.println("=============");            
            myFirstOrder.bookOrder(dateOrdered);
         	
            System.out.println("Booking Date: "+Utilities.dateParser(myFirstOrder.getDateBooked()));
            System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());         	

    		System.out.println("\nBilty Creation");
            System.out.println("=============");            
            myFirstOrder.createBilty(35, "Sajid Iqbal", "42101-1234567-3", "Adeel Cargo Services", "+92300 1234543", "TCU-098");

            System.out.println("Bilty No 	: "+myFirstOrder.getBiltyNo());
            System.out.println("Driver Name 	: "+myFirstOrder.getDriverName());
         	System.out.println("Driver CNIC No.	: "+myFirstOrder.getDriverCNIC());
         	System.out.println("Driver Contact 	: "+myFirstOrder.getDriverContact());
         	System.out.println("Driver Agent 	: "+myFirstOrder.getDriverAgent());
         	System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());         	

    		System.out.println("\nVoucher Creation");
            System.out.println("=============");            
            myFirstOrder.createPaymentVoucher(101, 80000, 100000);

            System.out.println("Voucher No.		: "+myFirstOrder.getVoucherNo());
         	System.out.println("Advance Payment	: "+myFirstOrder.getAdvancePayment());
         	System.out.println("Order Cost		: "+myFirstOrder.getOrderCost());
         	System.out.println("Balance Payment	: "+(myFirstOrder.getOrderCost()-myFirstOrder.getAdvancePayment()));
         	
            System.out.println("\nDispatching Order");
            System.out.println("=================");           	

            myFirstOrder.dispatchOrder(dateDispatched);
            System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());
         	System.out.println("Dispatch Date: "+Utilities.dateParser(myFirstOrder.getDateDispatched()));
            System.out.println("Rate is: PKR."+myFirstOrder.getRate());
            System.out.println("Order Value is: PKR."+myFirstOrder.getOrderValue());
            System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());
         	System.out.println("Order Revenue 	: "+myFirstOrder.getOrderValue());

            System.out.println("\nMake Balance Payment");
            System.out.println("=================");           	

            myFirstOrder.makeBalancePayment(dateReturned, dateReturned, 20000);
            System.out.println("Order Current Status:"+myFirstOrder.getOrderStatus());
         	System.out.println("Date Returned: "+Utilities.dateParser(myFirstOrder.getDateReturned()));
         	System.out.println("Order Gross Profit:"+myFirstOrder.getOrderProfit()); 

    }
}
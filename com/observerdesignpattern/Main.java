package com.observerdesignpattern;

// Main class to demonstrate the Observer Design Pattern 
public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // Create observers
        EmailObserver emailObserver = new EmailObserver("ali@gmail.com");
        SMSObserver smsObserver = new SMSObserver("1234567890");    
        WhatsAppObserver whatsappObserver = new WhatsAppObserver("0987654321");
        
        // Subscribe observers to the order service
        orderService.subscribe(emailObserver);  
        orderService.subscribe(smsObserver);
        orderService.subscribe(whatsappObserver);

        // Place an order
        orderService.placeOrder("Laptop");
        // Unsubscribe SMS observer and place another order
        orderService.unsubscribe(smsObserver);

        orderService.placeOrder("Smartphone"); 
        // Output will show that SMSObserver doesn't receive the second notification
        System.out.println("Notification for SMSObserver is skipped.");
    }
}

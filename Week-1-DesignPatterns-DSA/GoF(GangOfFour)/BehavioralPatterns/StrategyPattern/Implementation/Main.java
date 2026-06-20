public class Main {
    public static void main(String[] args) {
        
        PaymentStrategy paymentStrategy;
        String paymentType = "PAYPAL";
        if(paymentType.equals("PAYPAL")){
            paymentStrategy = new PaypalPayment();
        }else if(paymentType.equals("UPI")){
            paymentStrategy = new UpiPayment();
        }else{
            paymentStrategy = new CardPayment();
        }
        PaymentService service = new PaymentService(paymentStrategy);
        service.makePayment(10000.0);
    }    
}

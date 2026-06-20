public class PaymentService{
    private PaymentStrategy paymentStrategy;
    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public void makePayment(double amount){
        System.out.println("service object: "+this);
        System.out.println("paymentStrategy: "+this.paymentStrategy);
        paymentStrategy.pay(amount);
    }
}

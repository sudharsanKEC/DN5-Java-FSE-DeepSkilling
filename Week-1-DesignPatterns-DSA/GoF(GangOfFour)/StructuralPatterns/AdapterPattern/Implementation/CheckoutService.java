public class CheckoutService {
    private PaymentGateway paymentGateway;
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void checkout(){
        paymentGateway.pay(1000);
    }
}

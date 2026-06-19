public class RazorpayAdapter implements PaymentGateway{
    private Razorpay razorpay;
    public Razorpay getRazorpayObject(){
        return this.razorpay;
    }
    public RazorpayAdapter(Razorpay razorpay){
        this.razorpay = razorpay;
    }

    @Override
    public void pay(double amount){
        razorpay.makePayment(amount);
    }
}

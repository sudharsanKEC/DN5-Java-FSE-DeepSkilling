public class Main {

    public static void main(String[] args) {

        Razorpay razorpay = new Razorpay();

        PaymentGateway gateway =
                new RazorpayAdapter(razorpay);
        System.out.println(((RazorpayAdapter)gateway).getRazorpayObject());

        CheckoutService checkoutService =
                new CheckoutService(gateway);

        checkoutService.checkout();
    }
}

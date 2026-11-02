package payment;
class PaymentProcessor{
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("mobil_pay")) {
            System.out.println("Processing mobile payment : " + amount + " CFA ");
            // Logique specifique aux paymenet mobiles
        } else if(paymentType.equals("credit_card")) {
            System.out.println("Processing credit card payment : " + amount + " CFA ");
            // Logique specifique aux cartes bancaires
        } else if(paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment :" + amount + " CFA ");
            // Logique specifique a PayPal
        } else if(paymentType.equals("crypto")) {
            System.out.println("Processing crypto payement : " + amount + " CFA ");
            //Logique specifique aux crypto-monnaies
        }
    }

}

//UtilisationZ

public class Payment {
    public static void main(String[] args) {
        PaymentProcessor processor =  new PaymentProcessor();
        processor.processPayment("mobil_pay", 1500);
        processor.processPayment("credit_card", 6500);
        processor.processPayment("paypal", 500);
        
    }
}
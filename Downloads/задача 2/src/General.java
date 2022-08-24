public class General {
    public static void main(String[] args) {


        Payment payment1 = new Payment("Макароны", 5.5);
        Payment payment2 = new Payment("Iphone", 5000);
        Payment payment3 = new Payment("Кетчуп", 3);
        Payment.statistic(payment1, payment2, payment3);

    }
}

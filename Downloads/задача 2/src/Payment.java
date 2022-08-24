public class Payment {
    private String name;
    private double cost;

    public Payment(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public static void statistic(Payment... payments) {
        PaymentStatistic statistic = new PaymentStatistic() {

            @Override
            public double totalSum(Payment... payments) {
                double result = 0;
                for (Payment payment : payments) {
                    result+= payment.getCost();
                }
                System.out.println("Общая сумма" + result);
                return result;
            }

            @Override
            public double resultInDollars(double totalSum) {
                return totalSum / PaymentStatistic.CURS;
            }
        };

        double sum = statistic.totalSum(payments);
        statistic.resultInDollars(sum);
        System.out.println(payments.length);
    }
}

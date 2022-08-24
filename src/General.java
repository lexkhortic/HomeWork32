import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class General {
    public static void main(String[] args) {

        Programmer p1 = new Programmer(Lang.JAVA, "Хорт", 2500, false);
        Programmer p2 = new Programmer(Lang.JS, "Соколовская", 3000, true);
        Programmer p3 = new Programmer(Lang.JAVA, "Баран", 2000, true);
        Programmer p4 = new Programmer(Lang.PYTHON, "Чигилейчик", 2200, false);
        Programmer p5 = new Programmer(Lang.C, "Калейчик", 1800, false);
        Programmer p6 = new Programmer(Lang.JS, "Латушко", 3500, true);

        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(p1);
        programmers.add(p2);
        programmers.add(p3);
        programmers.add(p4);
        programmers.add(p5);
        programmers.add(p6);

        System.out.println("1) Максимальная зарплата: " +
                programmers.stream()
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getMax() + "$");

        System.out.println("2) Минимальная зарплата: " +
                programmers.stream()
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getMin() + "$");

        System.out.println("3) Средняя зарплата: " +
                programmers.stream()
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getSum() / programmers.size() + "$");

        System.out.println("4) Кол-во программистов: " +
                programmers.stream()
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getCount());

        System.out.println("5) Программисты работающие удаленно: ");
        programmers.stream()
                .collect(Collectors.partitioningBy(Programmer::isDistant))
                .forEach((key, value) -> {
                    if (key) {
                        value.forEach(p -> System.out.println(p.getFio()));
                    }
                });

        System.out.println("6) Кол-во программистов JAVA: " +
                programmers.stream()
                        .filter(p -> p.getLang() == Lang.JAVA)
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getCount());

        System.out.print("7) Программисты Python работающие удаленно: ");
        programmers.stream()
                .filter(p -> p.getLang() == Lang.PYTHON)
                .collect(Collectors.partitioningBy(Programmer::isDistant))
                .forEach((key, value) -> {
                    if (key) {
                        if (!value.isEmpty()){
                            System.out.println();
                            value.forEach(p -> System.out.println(p.getFio()));
                        } else {
                            System.out.println(0);
                        }
                    }
                });

        System.out.println("8) Максимальная зарплата программиста JS: " +
                programmers.stream()
                        .filter(p -> p.getLang() == Lang.JS)
                        .collect(Collectors.summarizingInt(Programmer::getSalary))
                        .getMax() + "$");

    }
}

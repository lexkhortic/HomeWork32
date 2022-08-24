import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class General {
    public static HashMap<String, List<String>> dict = new HashMap<>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void init() {
        List<String> hello = new ArrayList<>();
        hello.add("привет");
        hello.add("добрый день");
        dict.put("hello", hello);

        List<String> apple = new ArrayList<>();
        apple.add("яблоко");
        dict.put("apple", apple);

        List<String> green = new ArrayList<>();
        green.add("зеленый");
        dict.put("green", green);
    }

    public static void main(String[] args) {
        init();
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\nВыберите операцию:" +
                    "\n1 - поиск по русскому слову" +
                    "\n2 - поиск по англ слову" +
                    "\n3 - удалить слово" +
                    "\n4 - добавить новое слово" +
                    "\n5 - заменить слово" +
                    "\n10 - выход из программы");

            Integer operation = null;
            try {
                operation = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("неверный ввод!!!");
                continue;
            }

            try {

                switch (operation) {
                    case 1:
                        rusToEngl();
                        break;
                    case 2:
                        englToRus();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        add();
                        break;
                    case 5:
                        replaceWord();
                        break;
                    case 10:
                        System.exit(1);
                    default:
                        System.out.println("Неверный ввод");
                }
            } catch (Exception ex) {
                System.out.println("неверный ввод!!!");
                continue;
            }
        }

    }

    private static void replaceWord() throws IOException {
        System.out.println("Введите слово на англ языке для изменения в словаре");
        String word = reader.readLine();
        System.out.println("Введите новое слово на англ языке");
        String wordNew = reader.readLine();

        if (dict.containsKey(word)) {
            dict.put(wordNew, dict.get(word));
            dict.remove(word);
        } else {
            System.out.println("Слово " + word + " не найдено в словаре");
        }
    }

    private static void add() throws IOException {
        System.out.println("Введите слово на англ языке для добавления в словарь");
        String word = reader.readLine();

        List<String> values = new ArrayList<>();
        System.out.println("Введите слова - русский перевод для слова " + word + ". Чтобы закончить ввод," +
                "введите символ точка");

        String value = null;
        while (true) {
            value = reader.readLine();
            if (value.equals(".")) {
                dict.put(word, values);
                return;
            }
            values.add(value);
        }
    }

    private static void delete() throws IOException {
        System.out.println("Введите слово на англ языке для удаления из словаря");
        String word = reader.readLine();
        if (dict.containsKey(word.toLowerCase(Locale.ROOT))) {
            dict.remove(word);
        }

    }

    private static void englToRus() throws IOException {
        System.out.println("Введите слово на англ языке:");
        String word = reader.readLine();
        dict.forEach((k, v) -> {
            if (k.equalsIgnoreCase(word)) {
                v.forEach(w -> System.out.print(w + " "));
            }
        });
    }

    private static void rusToEngl() throws IOException {
        System.out.println("Введите слово на русском языке:");
        String word = reader.readLine();
        dict.forEach((k, v) -> {
            v.forEach(w -> {
                if (w.equalsIgnoreCase(word)) {
                    System.out.println(k);
                }
            });
        });
    }
}

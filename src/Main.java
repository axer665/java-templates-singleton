import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка: ");
            int N = scanner.nextInt();
            System.out.println("Введите верхнюю границу для значений: ");
            int M = scanner.nextInt();

            Random random = new Random();

            if (N == 0 || M == 0) {
                break;
            } else {
                logger.log("Создаём и наполняем список");
                List<Integer> givenList = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    givenList.add(random.nextInt(M));
                }

                System.out.println("Вот случайный список: ");
                for (int number : givenList) {
                    System.out.print(number + " ");
                }

                logger.log("Просим пользователя ввести входные данные для фильтрации");

                System.out.println("Введите порог для фильтра: ");
                int F = scanner.nextInt();

                Filter filter = new Filter(F);
                logger.log("Запускаем фильтрацию");
                List<Integer> filteredNumbers = filter.filterOut(givenList);
                logger.log("Прошло фильтр " + filteredNumbers.size() + " элемента из " + givenList.size());
                logger.log("Выводим результат на экран");
                System.out.print("Отфильтрованный список: ");
                for (int i : filteredNumbers) {
                    System.out.print(i + " ");
                }
                System.out.println();
                logger.log("Завершаем программу");
                break;
            }
        }


    }
}
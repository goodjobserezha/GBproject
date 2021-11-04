public class Homework_2
{
    public static void main(String[] args) {
        System.out.println("Task 1");
        int a = 7;
        int b = 4;
        System.out.println(isSumBetween10and20(a, b));

        System.out.println("Task 2.");
        printSignOf(5);

        System.out.println("Task 3.");
        System.out.println(isNegative(-3));

        System.out.println("Task 4.");
        print("Все получилось!!!", 3);

    }
        // Задание 1.

    public static boolean isSumBetween10and20(int left, int right) {
        int sum = left + right;
        return 10 < sum && sum <= 20;
    }
        // Задание 2.
        public static void printSignOf(int number)
        {
            if (number >= 0)
            {
                System.out.println("Число положительное!");
            }
            else
            {
                System.out.println("Число отрицательное!");
            }
        }
        // Задание 3.
        public static boolean isNegative(int number)
        {
            return number < 0;
        }
        // Задание 4.
        public static void print(String message, int count)
        {
            for (int i = 0; i < count; i++)
            {
                System.out.println(message);
            }
        }

    }



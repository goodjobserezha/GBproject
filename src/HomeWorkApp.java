public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }


    // Задание 2.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }


    // Задание 3.
    public static void checkSumSign() {
        int a = 4;
        int b = 7;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else if (sum < 0){
            System.out.println("Сумма отрицательная");

        }
    }


    // Задание 4.
    public static void printColor(){
        int value = 7;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (0 < value && value <=100) {
            System.out.println("Жёлтый");
        }
        else if (100 < value){
            System.out.println("Зелёный");
        }
        }

        // Задание 5.
        public static void compareNumbers(){
        int a = 2;
        int b = 4;
        if (a >= b){
            System.out.println("a >= b");
        }
        else if (a < b){
            System.out.println("a > b");
        }
    }

    }


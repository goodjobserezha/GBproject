import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
public class Homework_8 {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.initWindow();
    }

    public static class MyWindow extends JFrame {
        public void initWindow() {
            setSize(500, 500);
            setLocation(650, 250);
            int value = WindowConstants.EXIT_ON_CLOSE;
            setDefaultCloseOperation(value);

            GridLayout layout = new GridLayout(1, 2);
            JPanel panel = new JPanel(layout);

            JButton firstButton = new JButton("Выход");
            JButton secondButton = new JButton("Кнопка");
            panel.add(firstButton);
            panel.add(secondButton);

            add(panel, BorderLayout.SOUTH);

            setVisible(true);
        }
    }

    static class Main {
        public static void main(String[] args) {
            guessTheWord();
        }

        public static void guessTheWord() {
            Random random = new Random();

            String[] words =
                    {
                            "apple", "orange", "lemon", "banana", "apricot", "avocado",
                            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
                    };

            int expectedWordIndex = random.nextInt(words.length);
            String expectedWord = words[expectedWordIndex];
            System.out.println("Загадано: " + expectedWord);

            String userWord;
            Scanner scanner = new Scanner(System.in);
            do {
                userWord = scanner.nextLine();

                if (userWord.equals(expectedWord)) {
                    System.out.println("Угадано!");
                } else {
                    doAdvise(userWord, expectedWord);
                }
            }
            while (!(userWord.equals(expectedWord)));
        }

        static void doAdvise(String userWord, String expectedWord) {
            String advise = "";
            for (int i = 0; i < 15; i++) {
                if (i >= userWord.length() || i >= expectedWord.length()) {
                    advise += "#";
                } else if (userWord.charAt(i) == expectedWord.charAt(i)) {
                    advise += userWord.charAt(i);
                } else {
                    advise += "#";
                }
            }

            System.out.println(advise);
        }

    }
}
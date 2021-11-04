import java.util.Random;
import java.util.Scanner;

public class Homework_4 {
    static char[][] map;
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_EMPTY = '.';
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';

    public static void main(String[] args)
    {

        initMap();
        printMap();

        while (true)
        {
            humanTurn();
            printMap();
            if (isWinner(DOT_X))
            {
                System.out.println("User win!");
                break;
            }
            // проверка ничьи
            if (isMapFull())
            {
                System.out.println("Draw");
                break;
            }

            aiTurn();
            printMap();
            if (isWinner(DOT_O))
            {
                System.out.println("II win!");
                break;
            }
            if (isMapFull())
            {
                System.out.println("Ничья");
                break;
            }
        }

    }
    static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++)
        {
            for (int columns = 0; columns < SIZE; columns++)
            {
                map[row][columns] = DOT_EMPTY;
            }
        }
    }

    static void printMap()
    {
        for (int i = 0; i <= SIZE; i++)
        {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int row = 0; row < SIZE; row++)
        {
            System.out.print((row + 1) + " ");
            for (int column = 0; column < SIZE; column++)
            {
                System.out.print(map[row][column] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn()
    {
        Scanner scanner = new Scanner(System.in);

        int x;
        int y;

        do
        {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    static void aiTurn()
    {
        Random random = new Random();

        int x;
        int y;

        do
        {
            System.out.println("Введите координаты в формате X Y");
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));

        map[y][x] = DOT_O;
    }

    static boolean isCellValid(int x, int y)
    {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
        {
            return false;
        }
        if (map[y][x] == DOT_EMPTY)
        {
            return true;
        }
        return false;
    }





    static boolean isWinner(char symb) {
        int endOfOffset = map.length - DOTS_TO_WIN;

        for (int rowOffset = 0; rowOffset <= endOfOffset; rowOffset++)
        {
            for (int columnOffset = 0; columnOffset <= endOfOffset; columnOffset++)
            {
                char[][] subSquare = getSubSquare(rowOffset, columnOffset);
                boolean hasWinner = isLinesFilledWith(symb, subSquare) || isDiagonalsFilledWith(symb, subSquare);
                if (hasWinner) {
                    return true;
                }
            }
        }

        return false;
    }

    static char[][] getSubSquare(int rowOffset, int columnOffset) {
        char[][] subSquare = new char[DOTS_TO_WIN][DOTS_TO_WIN];

        for (int row = 0; row < DOTS_TO_WIN; row++) {
            for (int column = 0; column < DOTS_TO_WIN; column++) {
                subSquare[row][column] = map[row + rowOffset][column + columnOffset];
            }
        }

        return subSquare;
    }

    static boolean isLinesFilledWith(char symb, char[][] subMap) {
        for (int row = 0; row < subMap.length; row++) {
            int horizontalWinCounter = 0;
            int verticalWinCounter = 0;

            for (int column = 0; column < subMap.length; column++) {
                if (subMap[row][column] == symb) {
                    horizontalWinCounter++;
                }

                if (subMap[column][row] == symb) {
                    verticalWinCounter++;
                }
            }

            if (horizontalWinCounter == DOTS_TO_WIN || verticalWinCounter == DOTS_TO_WIN) {
                return true;
            }
        }

        return false;
    }

    static boolean isDiagonalsFilledWith(char symb, char[][] subMap) {
        int mainDiagonalCounter = 0;
        int sideDiagonalCounter = 0;

        for (int row = 0; row < DOTS_TO_WIN; row++)
        {
            if (subMap[row][row] == symb) {
                mainDiagonalCounter++;
            }
            if (subMap[row ][DOTS_TO_WIN - 1 - row] == symb) {
                sideDiagonalCounter++;
            }
        }

        return (mainDiagonalCounter == DOTS_TO_WIN) || (sideDiagonalCounter == DOTS_TO_WIN);
    }

    static boolean isMapFull()
    {
        for (int row = 0; row < SIZE; row++)
        {
            for (int column = 0; column < SIZE; column++)
            {
                if (map[row][column] == DOT_EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

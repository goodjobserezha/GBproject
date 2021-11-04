public class Homework_7 {
    public static class Cat
    {
        private boolean isFull;
        private final int appetite;
        private final String name;

        public Cat(int appetite, String name)
        {
            isFull = false;
            this.appetite = appetite;
            this.name = name;
        }
        public void eat(Plate plate)
        {
            if (plate.hasEnoughFoodFor(appetite) && !isFull)
            {
                System.out.println(name + " ест.");
                plate.decreaseFood(appetite);
                isFull = true;
            }
            else if (!plate.hasEnoughFoodFor(appetite))
            {
                System.out.println(name + " не наелся.");
            }
            else if (isFull)
            {
                System.out.println( name + " наелся.");
            }
        }
    }
    public static class Main
    {
        public static void main(String[] args)
        {
            Cat[] cats = {
                    new Cat(2, "Кот"),
                    new Cat(4, "Кот второй"),
                    new Cat(6, "Кот третий")
            };

            Plate plate = new Plate(10);

            for (Cat cat : cats)
            {
                cat.eat(plate);
            }

            plate.increaseFood(15);

            for (Cat cat : cats)
            {
                cat.eat(plate);
            }
        }
    }
    public static class Plate
    {
        private int food;

        public Plate(int food)
        {
            this.food = food;
        }

        public void decreaseFood(int appetite)
        {
            if (!hasEnoughFoodFor(appetite))
            {
                System.out.println("Хочется ещё.");
            }
            else
            {
                food = food - appetite;
            }
        }

        public boolean hasEnoughFoodFor(int appetite)
        {
            return appetite < food;
        }


        public void increaseFood(int countOfFood)
        {
            food += countOfFood;
        }
    }
}

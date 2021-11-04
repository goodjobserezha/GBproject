public class Homework_6 {
    public static class Animal
    {
        private final float maxRunDistance;
        private final float maxSwimDistance;

        public Animal(float maxRunDistance, float maxSwimDistance)
        {
            this.maxRunDistance = maxRunDistance;
            this.maxSwimDistance = maxSwimDistance;
        }
        public void runOn(float requiredDistance)
        {
            if (requiredDistance > maxRunDistance)
            {
                System.out.println("Не может пробежать " + requiredDistance);
                System.out.println("Максимум возможностей: " + maxRunDistance);
            }
            else
            {
                System.out.println("Расстояние для бега " + requiredDistance + " преодолено.");
            }

            System.out.println();
        }
        public void swimOn(float requiredDistance)
        {
            if (requiredDistance > maxSwimDistance)
            {
                System.out.println("Не может проплыть " + requiredDistance);
                System.out.println("Максимум возможностей: " + maxRunDistance);
            }
            else
            {
                System.out.println("Расстояние для заплыва " + requiredDistance + " преодолено.");
            }

            System.out.println();
        }
    }
    public static class AnimalFactory
    {
        private int animalsCount;
        private int dogsCount;
        private int catsCount;

        public AnimalFactory()
        {
            animalsCount = 0;
            dogsCount = 0;
            catsCount = 0;
        }

        public Cat newCat(int maxRunLimit)
        {
            Cat cat = new Cat(maxRunLimit);

            animalsCount++;
            catsCount++;

            return cat;
        }

        public Dog newDog(int maxRunLimit, int maxSwimLimit)
        {
            Dog dog = new Dog(maxRunLimit, maxSwimLimit);

            animalsCount++;
            dogsCount++;

            return dog;
        }

        public int getAnimalsCount()
        {
            return animalsCount;
        }

        public int getDogsCount()
        {
            return dogsCount;
        }

        public int getCatsCount()
        {
            return catsCount;
        }
    }
    public static class Cat extends Animal
    {
        public Cat(float maxRunDistance)
        {
            super(maxRunDistance, Integer.MIN_VALUE);
        }

        @Override
        public void swimOn(float requiredDistance)
        {
            System.out.println("Кошки плавать не умеют!\n");
        }
    }
    public static class Dog extends Animal
    {
        public Dog(float maxRunDistance, float maxSwimDistance)
        {
            super(maxRunDistance, maxSwimDistance);
        }
    }
    public static class Main
    {
        public static void main(String[] args)
        {
            AnimalFactory factory = new AnimalFactory();

            Cat cat = factory.newCat(200);
            Dog dog = factory.newDog(500, 10);

            cat.runOn(150);
            cat.swimOn(5);

            dog.runOn(550);
            dog.swimOn(9);

            System.out.println("Животных создано всего: " + factory.getAnimalsCount());
            System.out.println("Собак создано всего: " + factory.getDogsCount());
            System.out.println("Кошек создано всего: " + factory.getCatsCount());
        }
    }
}
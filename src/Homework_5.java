public class Homework_5 {
    public static class Employee
    {
        String fullName;
        String position;
        String email;
        String phoneNumber;
        float salary;
        int age;

        Employee(String fullName,
                 String position,
                 String email,
                 String phoneNumber,
                 float salary,
                 int age)
        {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
        }
        void printInfo()
        {
            System.out.println("ФИО: " + fullName);
            System.out.println("Должность: " + position);
            System.out.println("e-mail: " + email);
            System.out.println("Тел.: " + phoneNumber);
            System.out.println("ЗП: " + salary);
            System.out.println("Возраст: " + age);
        }


    }
    public static class Main
    {
        public static void main(String[] args)
        {
            Employee[] employees = {
                    new Employee(
                            "Ivanov Ivan Ivanovich",
                            "Prodict developer",
                            "email1@mail.ru",
                            "+7-800-555-35-35",
                            120000,
                            41),
                    new Employee(
                            "Alexeev Alexey Alexeevich",
                            "Chief IT department",
                            "email2@mail.ru",
                            "+7-900-735-56-08",
                            121000,
                            42),
                    new Employee(
                            "Alexandrova Alexandra Alexandrovna",
                            "Marketing and advertising manager",
                            "email3@mail.ru",
                            "+7-911-276-53-19",
                            122000,
                            21),
                    new Employee(
                            "Pavlov Pavel Pavlovich",
                            "Head of HR department",
                            "email4@mail.ru",
                            "+7-950-047-21-88",
                            123000,
                            22),
                    new Employee(
                            "Romanov Roman Romanovich",
                            "Chief engineer",
                            "email5@mail.ru",
                            "+7-921-976-52-98",
                            124000,
                            33)
            };

            int minAge = 40;
            for (Employee employee : employees)
            {
                if (employee.age > minAge)
                {
                    employee.printInfo();
                    System.out.println();
                }
            }
        }
    }
}

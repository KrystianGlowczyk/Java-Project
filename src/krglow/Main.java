package krglow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jan", "Kowalski", 'M', 4, 5400, 32, 2, true));
        employees.add(new Employee("Antek", "Dabrowski", 'M', 4, 6400, 52, 5, true));
        employees.add(new Employee("Janina", "Nowak", 'K', 2, 8100, 56, 0, false));
        employees.add(new Employee("Albert", "Nowak", 'M', 2, 4150, 22, 0, false));
        employees.add(new Employee("Danuta", "Kowalska", 'K', 3, 4100, 42, 3, true));

        Scanner scanner = new Scanner(System.in);
        firstMenu();
        int choice = scanner.nextInt();
        while (choice != 8) {
            switch (choice) {
                case 1:
                    choiceOne(employees);
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                case 2:
                    employees = choiceTwo(employees);
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Podaj nazwe pliku: ");
                    String name = scanner.nextLine();
                    choiceThree(employees, name);
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                case 4:
                    choiceFour(employees);
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                case 5:
                    choiceFive(employees);
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                case 6:
                    secondMenu();
                    employees = choiceSix(employees);
                    choice = scanner.nextInt();
                    break;
                case 7:
                    choiceSeven();
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
                default:
                    System.out.println("Wpisales zly numer:");
                    System.out.println("\n\n Wybierz opcje (1-8): ");
                    choice = scanner.nextInt();
                    break;
            }
        }

    }

    public static void choiceOne(List<Employee> employees) {
        for (Employee x : employees) {
            x.truncatedDisplay();
        }
    }

    public static List<Employee> choiceTwo(List<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        String nameNew = "";
        char zn;
        for (int h = 0; h < name.length(); h++) {
            zn = name.charAt(h);
            if (h == 0) {
                zn = Character.toUpperCase(zn);
            } else {
                zn = Character.toLowerCase(zn);
            }
            nameNew = nameNew + zn;

        }
        name = nameNew;

        System.out.println("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        String lastNew = "";
        for (int h = 0; h < lastName.length(); h++) {
            zn = lastName.charAt(h);
            if (h == 0) {
                zn = Character.toUpperCase(zn);
            } else {
                zn = Character.toLowerCase(zn);
            }
            lastNew = lastNew + zn;

        }
        lastName = lastNew;

        System.out.println("Podaj plec (kobieta: \"K\", mezczyzna: \"M\"): ");
        String genderr = scanner.nextLine();
        genderr = genderr.toUpperCase();

        System.out.println("Podaj nr dzialu: ");
        int depNr = scanner.nextInt();

        System.out.println("Podaj wynagrodzenie: ");
        float salary = scanner.nextFloat();

        System.out.println("Podaj wiek: ");
        int age = scanner.nextInt();

        System.out.println("Podaj liczbe dzieci: ");
        int nrCh = scanner.nextInt();

        System.out.println("Podaj stan cywilny (\"mezatka/zonaty\" wpisz \"true\" w przeciwnym razie wpisz \"false\": ");
        boolean mS;
        if (scanner.nextBoolean()) mS = true;
        else mS = false;
        char gender = genderr.charAt(0);
        Employee employee = new Employee(name, lastName, gender, depNr, salary, age, nrCh, mS);
        employees.add(employee);
        System.out.println("Pracownik zostal dodany.");

        return employees;
    }

    public static void choiceThree(List<Employee> employees, String name) throws FileNotFoundException {

        PrintWriter file = null;
        try {
            file = new PrintWriter(new File("/Users/krystek/Desktop/" + name + ".txt"));

            for (Employee x : employees) {
                file.print(x.getLastName());
                file.print(" " + x.getName());
                file.print(" " + x.getGender());
                file.print(" " + x.getDepartNr());
                file.format(" %.2f", x.getSalary());
                file.print(" " + x.getAge());
                file.println(" " + x.getChlidrens());

            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
        System.out.println("Dane zostaly wyeksportowane.");
    }

    public static List<Employee> choiceFour(List<Employee> employees) {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for (Employee x : employees) {
            System.out.println(i + ". " + x);
            i++;
        }

        System.out.println("Wpisz nr pracownika do usuniecia");
        int nr = scanner.nextInt();
        nr -= 1;
        employees.remove(nr);
        System.out.println("Pracownik zostal usuniety.");
        return employees;
    }

    public static void choiceFive(List<Employee> employees) {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for (Employee x : employees) {
            System.out.println(i + ". " + x);
            i++;
        }

        System.out.println("Wpisz nr pracownika do edycji:");
        int nr = scanner.nextInt();
        nr -= 1;

        employees.get(nr).specialDisplay();
        System.out.println("Wpisz nazwe pola, ktore chcesz edytowac:");
        scanner.nextLine();
        String field = scanner.nextLine();


        if (field.equalsIgnoreCase("NAZWISKO")) {
            if (employees.get(nr).getGender() == 'K') {
                System.out.println("Wpisz nowe nazwisko:");
                String name = scanner.nextLine();
                employees.get(nr).setLastName(name);
                System.out.println("Nazwisko zostalo zaktualizowane.");
            } else {
                System.out.println("POLE MOZLIWE DO EDYCJI TYLKO DLA KOBIET.");
            }

        } else if (field.equalsIgnoreCase("NR DZIALU")) {
            System.out.println("Wpisz nowy nr dzialu:");
            int nrD = scanner.nextInt();
            employees.get(nr).setDepartNr(nrD);
            System.out.println("Nr dzialu zostal zaktualizowany.");

        } else if (field.equalsIgnoreCase("WYNAGRODZENIE")) {
            System.out.println("Wpisz nowe wynagrodzenie: ");
            float salary = scanner.nextFloat();
            employees.get(nr).setSalary(salary);
            System.out.println("Wynagrodzenie zostalo zaktualizowane.");

        } else if (field.equalsIgnoreCase("WIEK")) {
            System.out.println("Wpisz nowy wiek: ");
            int age = scanner.nextInt();
            employees.get(nr).setAge(age);
            System.out.println("Wiek zostal zaktualizowany.");

        } else if (field.equalsIgnoreCase("LICZBA DZIECI")) {
            System.out.println("Podaj nowa liczbe dzieci: ");
            int childres = scanner.nextInt();
            employees.get(nr).setChlidrens(childres);
            System.out.println("Liczba dzieci zostala zaktualizowana.");

        } else if (field.equalsIgnoreCase("STAN CYWILNY")) {
            System.out.println("Wpisz nowy stan cywilny (true/false):");
            boolean status = scanner.nextBoolean();
            employees.get(nr).setMaritalStatus(status);
            System.out.println("Stan cywilny zostal zaktualizowany.");

        } else {
            System.out.println("BLAD PRZY WPISYWANIU, NIE MA TAKIEGO POLA.");
        }

    }

    public static List<Employee> choiceSix(List<Employee> employees) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String select = scanner.nextLine();
        select = select.toUpperCase();


        switch (select) {
            case "A":
                System.out.println("Podaj pensje: ");
                float tmpS = scanner.nextFloat();
                selectA(employees, tmpS);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "B":
                System.out.println("Podaj dzial: ");
                int tmp = scanner.nextInt();
                selectB(employees, tmp);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "C":
                selectC(employees);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "D":
                selectD(employees);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "E":
                selectE(employees);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "F":
                selectF(employees, 10);
                System.out.println("Pensje zostaly zwiekszone.");
                Thread.sleep(2000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "G":
                System.out.println("Podaj kwote podwyzki: ");
                float amount = scanner.nextFloat();
                float ratio = selectG(employees, amount);
                Thread.sleep(2000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "H":
                System.out.println("Jesli chcesz posortowac wpisz \"true\", nastomiast jesli chcesz posortowac odwrotnie wpisz \"false\".");
                boolean flag2 = scanner.nextBoolean();
                selectH(employees, flag2);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "I":
                System.out.println("Jesli chcesz posortowac malejaca wpisz \"false\", nastomiast jesli roznaco wpisz \"true\".");
                boolean flag = scanner.nextBoolean();
                selectI(employees, flag);
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
                break;

            case "J":
                firstMenu();
                break;

            default:
                System.out.println("Nie ma takiej opcji do wyboru.");
                Thread.sleep(3000);
                System.out.println("\n\n");
                firstMenu();
        }


        return employees;
    }

    public static void choiceSeven() {

        System.out.println("Program wspomagajacy organizacje w firmie.");
        System.out.println("Autor: Krystian Glowczyk");
        System.out.println("Data utworzenia: 15.05.2021");
    }


    public static void selectA(List<Employee> employees, float tmpS) {
        int i = 0;
        for (Employee x : employees) {
            if (x.getSalary() >= tmpS) {
                i++;
            }
        }
        System.out.println("Liczba pracownikow z pensja nie mniejsza od podanej wynosi: " + i);
    }

    public static float selectB(List<Employee> employees, int tmp) {
        int j = 0;
        float average = 0;
        int sum = 0;

        for (Employee x : employees) {
            if (x.getDepartNr() == tmp) {
                sum += x.getSalary();
                j++;
            }
        }
        average = sum / (float) j;
        System.out.format("\nSrednia pensja dla pracownikow dzialu %d wynosi: %.2f\n", tmp, average);

        return average;
    }

    public static void selectC(List<Employee> employees) {
        float maxW = 0;
        float maxM = 0;
        for (Employee x : employees) {

            if (x.getGender() == 'K') {
                if (x.getSalary() > maxW) {
                    maxW = x.getSalary();
                }
            } else if (x.getGender() == 'M') {
                if (x.getSalary() > maxM) {
                    maxM = x.getSalary();
                }
            }
        }

        System.out.println("Najwieksza pensja u kobiet: " + maxW);
        System.out.println("Najwieksza pensja u mezczyzn: " + maxM);
    }

    public static void selectD(List<Employee> employees) {


        for (int i = 0; i < 1000; i++) {
            int countW = 0;
            int countM = 0;
            float average = 0;

            for (Employee x : employees) {
                if (x.getDepartNr() == i) {
                    average = selectB(employees, i);
                    if (x.getGender() == 'K') {
                        countW++;
                    } else {
                        countM++;
                    }
                }
            }
            if (countM > 0 || countW > 0) {
                if (countM > countW) {
                    System.out.format("W dziale %d wiecej jest mezczyzn. \n", i);
                } else if (countW > countM) {
                    System.out.format("W dziale %d wiecej jest kobiet. \n", i);
                } else {
                    System.out.format("W dziale %d jest tyle samo kobiet co mezczyzn. \n", i);
                }
            }
        }
    }

    public static void selectE(List<Employee> employees) {
        float salaryM = 0;
        int countM = 0;
        float salaryW = 0;
        int countW = 0;
        float averageM;
        float averageW;
        for (Employee x : employees) {
            if (x.getGender() == 'K') {
                salaryW += x.getSalary();
                countW++;
            } else if (x.getGender() == 'M') {
                salaryM += x.getSalary();
                countM++;
            }
        }
        averageW = salaryW / countW;
        averageM = salaryM / countM;

        float ratio = averageW / averageM;

        System.out.println("Stosunek sredniej placy kobiet do mezczyzn wynosi: " + ratio);

    }

    public static void selectF(List<Employee> employees, float percent) {
        for (Employee x : employees) {
            x.salaryIncrease(percent);
        }
    }

    public static float selectG(List<Employee> employees, float amount) {
        float sumW = 0, sumM = 0;
        float ratio;

        for (Employee x : employees) {
            float tmpSalary;
            if (x.getGender() == 'K') {
                tmpSalary = x.getSalary() + amount;
                x.setSalary(tmpSalary);
                sumW += amount;
            } else if (x.getGender() == 'M') {
                tmpSalary = x.getSalary() + amount;
                x.setSalary(tmpSalary);
                sumM += amount;
            }
        }
        ratio = sumW / sumM;
        System.out.println("Suma podwyzek dla kobiet wynosi: " + sumW);
        System.out.println("Suma podwyzek dla mezczyzn wynosi: " + sumM);
        System.out.println("Stosunek podwyzki kobiet do mezczyzn wynosi: " + ratio);

        return ratio;
    }

    public static void selectH(List<Employee> employees, boolean flag) throws FileNotFoundException {
        PrintWriter file = null;
        try {
            Collections.sort(employees, new EmployeeLastNameComparator());
            file = new PrintWriter(new File("/Users/krystek/Desktop/SortByLastName.txt"));
            if (flag == true) {
                for (Employee x : employees) {
                    file.print(x.getName());
                    file.print(" " + x.getLastName());
                    file.print(" " + x.getGender());
                    file.print(" " + x.getDepartNr());
                    file.print(" " + x.getSalary());
                    file.print(" " + x.getAge());
                    file.print(" " + x.getChlidrens());
                    file.println(" " + x.isMaritalStatus());
                }
            } else {
                Collections.reverse(employees);
                for (Employee x : employees) {
                    file.print(x.getName());
                    file.print(" " + x.getLastName());
                    file.print(" " + x.getGender());
                    file.print(" " + x.getDepartNr());
                    file.print(" " + x.getSalary());
                    file.print(" " + x.getAge());
                    file.print(" " + x.getChlidrens());
                    file.println(" " + x.isMaritalStatus());
                }
            }


        } finally {
            if (file != null) {
                file.close();
            }
        }

    }

    public static void selectI(List<Employee> employees, boolean flag) throws FileNotFoundException {

        PrintWriter file = null;
        try {
            Collections.sort(employees, new EmployeeSalaryComparator());
            file = new PrintWriter(new File("/Users/krystek/Desktop/SortBySalary.txt"));
            if (flag == true) {
                for (Employee x : employees) {
                    file.print(x.getName());
                    file.print(" " + x.getLastName());
                    file.print(" " + x.getGender());
                    file.print(" " + x.getDepartNr());
                    file.print(" " + x.getSalary());
                    file.print(" " + x.getAge());
                    file.print(" " + x.getChlidrens());
                    file.println(" " + x.isMaritalStatus());
                }
            } else {
                Collections.reverse(employees);
                for (Employee x : employees) {
                    file.print(x.getName());
                    file.print(" " + x.getLastName());
                    file.print(" " + x.getGender());
                    file.print(" " + x.getDepartNr());
                    file.print(" " + x.getSalary());
                    file.print(" " + x.getAge());
                    file.print(" " + x.getChlidrens());
                    file.println(" " + x.isMaritalStatus());
                }
            }


        } finally {
            if (file != null) {
                file.close();
            }
        }

    }

    public static void firstMenu() {
        System.out.println("************************************************************");
        System.out.println("************************** M E N U *************************");
        System.out.println("************************************************************");
        System.out.println("** 1. Wyswietl pracownikow.                               **");
        System.out.println("** 2. Dodaj pracownika.                                   **");
        System.out.println("** 3. Eksport pracownikow do pliku tekstowego.            **");
        System.out.println("** 4. Usun pracownika.                                    **");
        System.out.println("** 5. Edytuj pracownika.                                  **");
        System.out.println("** 6. Dodatkowe funkcje.                                  **");
        System.out.println("** 7. INFO                                                **");
        System.out.println("** 8. Zakoncz program.                                    **");
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("\n\n Wybierz opcje (1-8): ");

    }

    public static void secondMenu() {
        System.out.println("**************************************************************************");
        System.out.println("******************  D O D A T K O W E    F U N K C J E  ******************");
        System.out.println("**************************************************************************");
        System.out.println("** A) Liczba pracownikow z pensja nie mniejsza od podanej.              **");
        System.out.println("** B) Srednia placy w podanym dziale.                                   **");
        System.out.println("** C) Najwiksza pensja u kobiet i mezczyzn.                             **");
        System.out.println("** D) Wyswietlenie aktywnych dzialow oraz informacji.                   **");
        System.out.println("** E) Stosunek sredniej placy kobiet do mezczyzn.                       **");
        System.out.println("** F) Zwiekszenie pensji pracownikom o 10% oraz za specjalne cechy.     **");
        System.out.println("** G) Zwiekszenie pensji pracownikom o podana kwote.                    **");
        System.out.println("** H) Sortowanie pracownikow w pliku wedlug nazwiska.                   **");
        System.out.println("** I) Sortowanie pracownikow w pliku wedlug wynagrodzenia.              **");
        System.out.println("** J) WROC DO GLOWNEGO MENU.                                            **");
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("\n\n Wybierz opcje (A-J): ");

    }
}

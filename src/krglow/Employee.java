package krglow;

public class Employee {

    private String name;
    private String lastName;
    private char gender;
    private int departNr;
    private float salary;
    private int age;
    private int chlidrens;
    private boolean maritalStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDepartNr() {
        return departNr;
    }

    public void setDepartNr(int departNr) {
        this.departNr = departNr;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChlidrens() {
        return chlidrens;
    }

    public void setChlidrens(int chlidrens) {
        this.chlidrens = chlidrens;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "Imie='" + name + '\'' +
                ", Nazwisko='" + lastName + '\'' +
                ", Plec=" + gender +
                ", Nr dzialu=" + departNr +
                ", Wynagrodzenie=" + salary +
                ", Wiek=" + age +
                ", Liczba dzieci=" + chlidrens +
                ", Stan cywilny=" + maritalStatus +
                '}';
    }

    public void truncatedDisplay() {
        System.out.println("Imie: " + name + " Nazwisko: " + lastName + " Wynagrodzenie: " + salary);
    }

    public void specialDisplay() {
        String tmpName = name.toUpperCase();
        String tmpLastName = lastName.toUpperCase();

        System.out.println(tmpName + " " + tmpLastName);
    }

    public boolean checkSalary(int x) {
        if (salary > x) {
            return true;
        } else {
            return false;
        }
    }

    public void salaryIncrease(int percent) {
        percent += (chlidrens * 2);
        if (maritalStatus == true) {
            percent += 3;
        }
        salary = salary * (percent / 100);
    }

    public Employee(String name, String lastName, char gender, int departNr, float salary, int age, int chlidrens, boolean maritalStatus) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.departNr = departNr;
        this.salary = salary;
        this.age = age;
        this.chlidrens = chlidrens;
        this.maritalStatus = maritalStatus;
    }

}

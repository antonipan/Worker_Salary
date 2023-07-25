package model;

import java.util.Random;

/**
 * Класс для создания базового типа работника. Имеет двух наследников.
 */
public abstract class BaseWorker implements Comparable <BaseWorker> {
    private String name;
    private String surname;
    private int age;
    /**
     * ставка по заработной плате; ежемесячная или почасовая.
     */
    private double rate;
    public final Random random = new Random();
    /**
     * заработная плата. Алгоритм её получения релазиован в наследниках данного класса.
     */
    protected double salary;
    /**
     * счётчик работников. Необходим для добавления его в имя по умолчанию.
     */
    private static int count = 0;

    public BaseWorker (String name, String surname, int age, double rate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.rate = rate;
    }
    public BaseWorker () {
        count++;
        this.name = "Worker" + count;
        this.surname = "Workers" + count;
        this.age = random.nextInt(20, 51);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getCount () {
        return count;
    }

    /**
     * Метод реализован в классах наследниках.
     * @return - возращает double - размер заработной платы.
     */
    public abstract double getSalary();

    /**
     * Переопределённый метод для печати объекта данного класса.
     * @return
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }

    /**
     * Переопределённый метод для сравнения двух объектов класса BaseWorker
     * @param o the object to be compared.
     * @return - возращает одно из трёх чисел в зависимости от исхода.
     */
    @Override // TODO: доделать базовую реализацию. Логика сравнения релазиована через интерфейсвы Comparators.
    public int compareTo(BaseWorker o) {
        return 0;
    }
}

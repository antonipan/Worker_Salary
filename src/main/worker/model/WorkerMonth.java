package model;

import model.BaseWorker;

/**
 * Класс работника с помесячной заработной платой.
 */
public class WorkerMonth extends BaseWorker {
    /**
     * Конструктор реализует проверку по размеру заработной платы
     * @param rate - ставка по заработной плате.
     */
    public WorkerMonth (double rate) {
        super();
        if (rate < 1000) {
            throw new RuntimeException("Salary is too small: " + rate);
        }
        setRate(rate);
        salary = getSalary();
    }

    public double getSalary () {
        return this.getRate();
    }
}

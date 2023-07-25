package model;

import model.BaseWorker;

/**
 * Класс работника с почасовой заработной пластой.
 */
public class WorkerHour extends BaseWorker {
    /**
     * Конструктор.
     * @param rate - принимает ставку по заработной плате.
     */
    public WorkerHour (double rate) {
        super();
        setRate(rate);
        salary = getSalary();
    }

    /**
     * Метод переопределён для
     * @return
     */
    @Override
    public double getSalary() {
        return getRate() * 20.8 * 8;
    }
}

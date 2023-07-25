package comparators;

import model.BaseWorker;

import java.util.Comparator;

/**
 * Интерфейс реализует сортировку по размеру заработной платы.
 */
public class SortBySalary implements Comparator <BaseWorker> {
    @Override
    public int compare(BaseWorker worker1, BaseWorker worker2) {
        return Double.compare(worker1.getSalary(), worker2.getSalary());
    }
}

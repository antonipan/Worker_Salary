package comparators;

import model.BaseWorker;

import java.util.Comparator;

/**
 * Интерфейс реализует сравние по имени.
 */
public class SortByName implements Comparator <BaseWorker> {
    @Override
    public int compare(BaseWorker worker1, BaseWorker worker2) {
        return worker1.getName().compareTo(worker2.getName());
    }
}

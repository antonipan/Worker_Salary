package comparators;

import model.BaseWorker;

import java.util.Comparator;

/**
 * Релазиует сортировку по возрасту.
 */
public class SortByAge implements Comparator <BaseWorker> {
    @Override
    public int compare(BaseWorker worker1, BaseWorker worker2) {
        if (worker1.getAge() > worker2.getAge()) {
            return 1;
        } else if (worker1.getAge() < worker2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}

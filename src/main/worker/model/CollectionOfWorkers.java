package model;


import java.util.ArrayList;
import java.util.List;

public class CollectionOfWorkers extends java.awt.List{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * коллекция добавленных работников.
     */
    private List <BaseWorker> listWorker;

    /**
     * конструктор, который по умолчанию создаёт новый лист.
     */
    public CollectionOfWorkers () {
        listWorker = new ArrayList<>();
    }

    /**
     * Геттер коллекции работников.
     * @return - возвращает лист работников.
     */
    public List<BaseWorker> getListWorker() {
        return listWorker;
    }

    /**
     * Метод добавления работников
     * @param worker - принимает объект - работник и его наследников.
     */
    public void addWorker (BaseWorker worker) {
        listWorker.add(worker);
    }

    /**
     * Метод вывода в консоль списка работников.
     */
    public void printWorker () {
        for (BaseWorker worker :  listWorker
             ) {
            System.out.println(ANSI_GREEN + worker.toString() + ANSI_RESET);
        }
    }

    /**
     * метод удаления работника
     * @param name - имя работника, которого нужно удалить.
     */
    public void removeWorker (String name) {
        for (BaseWorker worker :  listWorker
        ) {
            if (worker.getName().equals(name)) {
                listWorker.remove(worker);
                break;
            }
            System.out.printf("A worker with name %s was not found. \n", name);
        }
    }

    /**
     * Вспомогательный метод.
     * @return возращает количество работников.
     */
    private int countWorker () {
        return listWorker.size();
    }

}

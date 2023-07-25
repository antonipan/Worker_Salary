import java.util.Scanner;

/**
 * Класс по отображению меню и взаимодействию с пользователем.
 */
public class View {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static Scanner scanner = new Scanner(System.in);
    public Controller controller = new Controller();
    public static Decorator decorator = new Decorator();

    /**
     * Отображает главное меню.
     */
    public void mainView () {
        while (true) {
            System.out.println(ANSI_BLUE + "Добро пожаловать. Выберите пункт меню. \n" +
                    "1 - Добавить нового работника. \n"
                    + "2 - Показать список работников. \n"
                    + "3 - Сортировать работников. \n"
                    + "4 - Удалить работника. \n"
                    + "5 - Выйти из программы." + ANSI_RESET);
            int level = enterUser(1, 5);

            switch (level) {
                case 1:
                    while (true) {
                        menuAddWorker();
                        int dataWorker = enterUser(1, 3);
                        if (dataWorker == 3 || dataWorker == 1) { // TODO: доделать реализацию для пункта 1
                            decorator.funcAtWork();
                            break;
                        }
                        menuSelectWorker();
                        int selectWorker = enterUser(1, 3);
                        if (selectWorker == 3) {
                            break;
                        }
                        double rate = enterUserRate(selectWorker);
                        controller.getLevel1(dataWorker, selectWorker, rate);
                        System.out.println(ANSI_GREEN + "Работник успешно добавлен... " + ANSI_RESET);
                    }
                    break;
                case 2:
                    controller.getLevel2();
                    break;
                case 3:
                    menuSort();
                    int menuSort = enterUser(1, 3);
                    controller.getLevel3(menuSort);
                    break;
                case 4:
                    menuRemove();
                    String name = scanner.nextLine();
                    controller.getLevel4(name); break;
                case 5: controller.getLevel5(); break;
                default:
                    break;
            }
            if (level == 5) {
                System.out.println("К сожалению, данные работников не сохранены.");
                /*
                 TODO реализовать сохранение работников в файле или в базе данных.
                  */
                System.out.println("До свидания. ");
                break;
            }

        }

    }

    /**
     * Показывает меню по добавлению работника
     */
    private void menuAddWorker () {
        System.out.println(ANSI_WHITE + "Выберите: \n" +
                "1 - Внести данные полностью. \n" +
                "2 - Внести только зарплату. \n" +
                "3 - Вернуться в главное меню. " + ANSI_RESET);
    }

    /**
     * Отображает в консоли меню выбора способа оплаты работника.
     */
    private void menuSelectWorker () {
        System.out.println(ANSI_WHITE + "Выберите: \n" +
                "1 - Работник получает месячную зарплату (зп должна быть больше 1000). \n" +
                "2 - Работник на часовой ставке (зп должна быть больше 10). \n" +
                "3 - Вернуться в главное меню. " + ANSI_RESET);
    }

    /**
     * показывает в консоли меню сортировки.
     */
    private void menuSort () {
        System.out.println(ANSI_WHITE+ "Выберите: \n" +
                "1 - Сортировать по имени. \n" +
                "2 - Сортировать по возрасту. \n" +
                "3 - Сортировать по зарплате. " + ANSI_RESET);
    }

    /**
     *Показывает меню удаления пользователя.
     */
    private void menuRemove () {
        System.out.println(ANSI_CYAN + "Введите имя, чтобы удалить работника. " + ANSI_RESET);
    }

    /**
     * Метод принмает минимальный и максимальный пункты меню и проверяет ввод пользователя. Метод бросает исключение,
     * если пользователь ввёл цифру, которой нет соответствия меню.
     * @param itemMin
     * @param itemMax
     * @return возращает пункт меню, int
     */
    private int enterUser (int itemMin, int itemMax) {
        decorator.enterUserNumber();
        int x = 0;
        while ((x < itemMin || x > itemMax)) {
            try {
                String enterUser = scanner.nextLine();
                x = Integer.parseInt(enterUser);
                if (x < itemMin || x > itemMax ) {
                    System.err.print("Нет такого пункта меню. Попробуйте снова: ");
                }
            } catch (NumberFormatException е) {
                System.err.print("Вы ввели не число. Попробуйте снова: ");
            }
        }
        return x;
    }


    /**
     * метод проверяет ввод зарплаты пользователя.
     * @param selectWorker - пункт меню выбора заработной платы.
     * @return - double значение заработной платы.
     */
    private double enterUserRate (int selectWorker) {
        System.out.print(ANSI_CYAN + "Введите зарплату: " + ANSI_RESET);
        double x;
        do {
            String enterUser = scanner.nextLine();
            try {
                x = Double.parseDouble(enterUser);
                if (selectWorker == 1 && x > 1000.0) {
                    break;
                }
                else if (selectWorker == 2 && x > 10.0) {
                    break;
                } else {
                    System.err.print("Введены некооректные данные. Попробуйте снова: ");
                }
            } catch (NumberFormatException е) {
                System.err.println("Вы ввели не число. ");
            }
        } while (true);
        return x;
    }
}

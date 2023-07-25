public class Decorator {

    public void enterUserNumber () {
        System.out.print(View.ANSI_CYAN + "Введите число: " + View.ANSI_RESET);

    }

    public void funcAtWork () {
        System.out.println(View.ANSI_YELLOW + "Функционал нереализован. " + View.ANSI_RESET);
    }
}

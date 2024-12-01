import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in); // Чтение
        Integer command = 0; // Введеный параметр
        StepTrecker ST = new StepTrecker();

        while (true){
            printMenu();
            command = scanner.nextInt();
            if (command==1){
                System.out.println("Введите: ");
                System.out.println("Месяц: ");
                int month = scanner.nextInt();
                System.out.println("День: ");
                int day = scanner.nextInt();
                System.out.println("Количество шагов: ");
                int steps = scanner.nextInt();
                ST.setSteps(steps,day,month);
            }else if (command==2){
                System.out.println("Введите: ");
                System.out.println("Месяц: ");
                int month = scanner.nextInt();
                ST.printDataonMounth(month);

            }else if (command==3){
                System.out.println("Введие желаемую цель: ");
                int stepsTarget = scanner.nextInt();
                ST.setStepTarget(stepsTarget);
                System.out.println("Цель измененна.");
                System.out.println("Новая цель: "+ST.getStepTarget());

            }else if (command==4){
                System.out.println("4");
                System.out.println("Выход!");
                break;
            }else {
                System.out.println("Комманда не найдна!");
            }
        }
    }
    public static void printMenu(){
        System.out.println("Что хотите?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}
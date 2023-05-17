import java.util.Scanner;

public class App {
    public static void printMenu() {
        System.out.println("       MENU       ");
        System.out.println("1. Register Student");
        System.out.println("2. Show Grades");
        System.out.println("0. Quit");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager(scan);
        Boolean running = true;

        while (running) {
            printMenu();
            System.out.print("[Menu]: ");
            Integer option = scan.nextInt();

            switch(option) {
                case 1:
                    gradeManager.registerStudent();
                    break;
                case 2:
                    gradeManager.showStudents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("\nINVALID OPTION\n");
            }
        }
    }
}

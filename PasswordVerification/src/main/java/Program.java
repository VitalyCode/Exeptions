import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите кол-во символов в пароле:");
            int minLenght = Integer.parseInt(scanner.nextLine()); // Длина
            passwordChecker.setMinLenght(minLenght); // Установка длинны

            System.out.println("Введите мак. допустимое количесвто повторений символа подряд:");
            int maxRepeats = Integer.parseInt(scanner.nextLine());
            passwordChecker.setMaxRepeats(maxRepeats); // Установка повторений

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            while (true) {
                System.out.println("Введите пароль:");
                String password = scanner.nextLine();
                if ("end".equals(password)) {
                    break;
                }
                System.out.println(passwordChecker.vetify(password) ? "Подходит" : "Не подходит");
            }
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

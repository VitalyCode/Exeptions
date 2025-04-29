public class PasswordChecker {
    private int minLenght;
    private int maxRepeats;

    // свойство с проверкой длинны пароля
    public void setMinLenght(int lenght) {
        if (lenght <= 0) {
            throw new IllegalArgumentException("Длина пароля не может быть мельше или равна нулю");
        } else {
            this.minLenght = lenght;
        }
    }

    // Свойство с проверкой количества одинаковых символов
    public void setMaxRepeats(int repeats) {
        if (repeats <= 0) {
            throw new IllegalArgumentException("Количесвто допустимых одинаковых символов не может быть меньше либо равно 0");
        } else {
            this.maxRepeats = repeats;
        }
    }

    public boolean vetify(String password) {
        if (minLenght == -1 || maxRepeats == -1) {
            throw new IllegalArgumentException("Чеккер не настроен");
        }
        // 1 критерий
        if (password.length() != minLenght) {
            return false;
        }
        // 2 критерий
        int counter = 0;
        char prev = password.charAt(0);
        for (char letter : password.toCharArray()) {
            if (letter == prev) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxRepeats) {
                return false;
            }
        }
        return true;
    }
}

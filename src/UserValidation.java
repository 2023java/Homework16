public class UserValidation {
    public static void validate(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Неверный логин: длина логина должна быть не более 20 символов");
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Неверный логин: логин должен содержать только латинские буквы, цифры и символ подчеркивания");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() >= 20) {
            throw new WrongPasswordException("Неверный пароль: длина пароля должна быть меньше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль: пароль и подтверждение пароля должны совпадать");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Неверный пароль: пароль должен содержать только латинские буквы, цифры и символ подчеркивания");
        }
    }

    public static void main(String[] args) {
        validate("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        validate("java_skypro_go_very_long_login", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        validate("java_skypro_go!", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        validate("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9_wrong");
    }
}

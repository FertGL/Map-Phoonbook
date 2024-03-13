import java.util.Scanner;

public class Main {
    private static PhoneBook phoneBook = new PhoneBook();
    private static final String INVALID_PHONE = "Такого номера нет в телефонной книге";
    private static final String INVALID_VAR = "Неправильный ввод";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String phoneInput = input.replaceAll("[^0-9]","");
        String nameInput = input.replaceAll("[^А-Яа-я]","");


        while (true){
            if (input.equals(0)){
                return;
            }
            if (!phoneInput.isEmpty() & phoneInput.length()== 11) {
                phoneBook.getContactByPhone(phoneInput);
                if (phoneBook.getContactByPhone(phoneInput).isEmpty()) {
                    input = scanner.nextLine();
                    System.out.println("Введите имя контакта: ");
                    phoneBook.addContact(phoneInput,input);
                }
            }

            if (!nameInput.isEmpty() & nameInput.length() < 10) {
                phoneBook.getContactByName(nameInput);
                if (phoneBook.getContactByName(nameInput).isEmpty()) {
                    input = scanner.nextLine();
                    System.out.println("Введите номер: ");
                    phoneBook.addContact(input,nameInput);
                }
            }

        }
    }
}
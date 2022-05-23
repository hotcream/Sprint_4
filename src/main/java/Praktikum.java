public class Praktikum {

    public static void main(String[] args) {

        for (String name : args) {
            Account account = new Account(name);
            boolean result = account.checkNameToEmboss();
            System.out.println("Имя " + name + ": " + result);
        }
    }

} 
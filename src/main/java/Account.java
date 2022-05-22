public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        return name != null
                && name.length() >= 3 && name.length() <= 19
                && name.contains(" ") && name.indexOf(" ") == name.lastIndexOf(" ")
                && !name.startsWith(" ") && !name.endsWith(" ");
    }

}
package consts;

public enum Consts {
    ADDRESS("somewhere@nowhere.com"),
    PIN("0000"),
    NAME("John Doe"),
    NOT_ENOUGH_AMOUNT("Not enough money on the account"),
    WRONG_PIN("Wrong PIN");

    private String name;

    Consts(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package implementation;

public enum Consts {
    ADDRESS("somewhere@nowhere.com"),
    PIN("0000");

    private String name;

    Consts(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

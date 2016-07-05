import atm.mainimpl.ATMMain;
import consts.Operation;

public class Main {
    static ATMMain atmMain = new ATMMain();

    public static void main(String[] args) {
        Operation choose = atmMain.chooseOperation();
        atmMain.insertCard();
        if (atmMain.checkPin()){

            switchOperation(choose);
        }else{
            atmMain.wrongPin();
        }
    }

    private static void switchOperation(Operation choose) {
        switch (choose) {
            case WITHDRAW:
                withdraw();
                break;
            case DEPOSIT:
                deposit();
                break;
            case INFO:
                info();
                break;
            default:
                System.out.println("wrong entry");
        }
    }

    private static void info() {
        atmMain.getAccountName();
        atmMain.getBalance();
    }

    private static void deposit() {
        int amount = atmMain.selectAmount();
        atmMain.deposit(amount);
    }

    private static void withdraw() {
        int amount = atmMain.selectAmount();
        if (atmMain.checkSum(amount)) {
            atmMain.withdraw(amount);
        } else {
            atmMain.notEnoughError();
        }


    }
}
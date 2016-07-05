import atm.mainimpl.ATMConsole;
import consts.Operation;

public class Main {
    static ATMConsole atmConsole = new ATMConsole();

    public static void main(String[] args) {
        Operation choose = atmConsole.chooseOperation();
        atmConsole.insertCard();
        if (atmConsole.checkPin()){

            switchOperation(choose);
        }else{
            atmConsole.wrongPin();
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
        atmConsole.getAccountName();
        atmConsole.getBalance();
    }

    private static void deposit() {
        int amount = atmConsole.selectAmount();
        atmConsole.deposit(amount);
    }

    private static void withdraw() {
        int amount = atmConsole.selectAmount();
        if (atmConsole.checkSum(amount)) {
            atmConsole.withdraw(amount);
        } else {
            atmConsole.notEnoughError();
        }


    }
}
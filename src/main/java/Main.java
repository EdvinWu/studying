import atm.mainimpl.ATMMain;
import consts.Operation;

public class Main {
    public static void main(String[] args) {
        ATMMain atmMain = new ATMMain();
        Operation choose = atmMain.chooseOperation();
        int amount;
        switch (choose) {
            case DEPOSIT:
                atmMain.insertCard();
                amount = atmMain.selectAmount();
                if (atmMain.checkPin()) {
                    if (atmMain.checkSum(amount)) {
                        atmMain.withdraw(amount);
                    } else {
                        atmMain.notEnoughError();
                    }
                } else {
                    atmMain.wrongPin();
                }
                break;

            case WITHDRAW:
                atmMain.insertCard();
                amount = atmMain.selectAmount();
                if (atmMain.checkPin()) {
                    atmMain.withdraw(amount);
                } else {
                    atmMain.wrongPin();
                }
                break;
            case INFO:
                atmMain.insertCard();
                atmMain.getAccountName();
                atmMain.getBalance();
                break;
            default:
                System.out.println("wrong entry");
        }
    }
}
import atm.mainimpl.ATMMain;
import consts.Operation;

public class Main {
    public static void main(String[] args) {
        ATMMain atmMain = new ATMMain();
        Operation choose = atmMain.chooseOperation();
        int amount;
        switch (choose) {
            case WITHDRAW:
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

            case DEPOSIT:
                atmMain.insertCard();
                amount = atmMain.selectAmount();
                if (atmMain.checkPin()) {
                    atmMain.deposit(amount);
                } else {
                    atmMain.wrongPin();
                }
                break;
            case INFO:
                atmMain.insertCard();
                if (atmMain.checkPin()){
                    atmMain.getAccountName();
                    atmMain.getBalance();
                }else{
                    atmMain.wrongPin();
                }
                break;
            default:
                System.out.println("wrong entry");
        }
    }
}
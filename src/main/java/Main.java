public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.insertCard();
        if (atm.checkPin()) {
            atm.selectWithdrawal();
            atm.selectAmount();
            if (atm.checkSum()) {
                atm.withdraw();
            } else {
                atm.notEnoughError();
            }
        } else {
            atm.wrongPin();
        }

    }
}

package implementation;

import atm.Account;
import atm.ServerConnector;

public class ServerConnectorImpl implements ServerConnector {
    private Account account = new Account();

    @Override
    public int getBalance(String address) {
        if (address.equals(account.getAddress())) {

            return account.getBalance();
        } else {
            return -1;
        }

    }

    @Override
    public void changeBalance(String address, int diff) {
        if (address.equals(account.getAddress())) {
            account.changeBalance(diff);
        }
    }

    @Override
    public String getName(String address) {
        if (address.equals(account.getAddress())) {

            return account.getAccountHolderName();
        }
        return "wrong address";
    }
}

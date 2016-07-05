package implementation;

import atm.ServerConnector;

public class ServerConnectorImpl implements ServerConnector {
    int balance = 200;

    @Override
    public int getBalance(String address) {
        if (address.equals(Consts.ADDRESS.toString())){

            return balance;
        }else {
            return -1;
        }

    }

    @Override
    public void changeBalance(String address, int diff) {
        if (address.equals(Consts.ADDRESS.toString())){

            balance += diff;
        }
    }
}

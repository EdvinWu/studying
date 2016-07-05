package implementation;

import atm.ServerConnector;

public class ServerConnectorImpl implements ServerConnector {
    int balance = 200;

    @Override
    public int getBalance(String address) {
        return balance;
    }

    @Override
    public void changeBalance(String address, int diff) {
        balance += diff;
    }
}

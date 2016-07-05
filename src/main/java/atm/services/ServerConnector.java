package atm.services;

public interface ServerConnector {
    public int getBalance(String address);
    public void changeBalance(String address, int diff);
    public String getName(String address);
}

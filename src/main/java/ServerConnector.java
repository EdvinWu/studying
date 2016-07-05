public interface ServerConnector {
    public int getBalance(String address);
    public int changeBalance(String address, int diff);
}

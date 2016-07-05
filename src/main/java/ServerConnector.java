public interface ServerConnector {
    public int getBalance(String address);
    public void changeBalance(String address, int diff);
}

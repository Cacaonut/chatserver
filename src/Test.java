public class Test {
    public static void main(String[] args){
        new Thread(() -> {
            new Server(555);
        }).start();

        Client client = new Client();
        client.startConnection("127.0.0.1", 555);
        client.sendMessage("Hi");
    }
}

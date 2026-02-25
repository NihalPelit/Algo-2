public class Main {
    public static void main(String[] args) {
        SeperateChainHt s=new SeperateChainHt();
        s.put("Ankara",2);
        s.put("İstanbul",4);
        s.put("İzmir",6);
        s.put("Siirt",20);
        s.put("Hakkari",3);
        s.put("Muş",7);

        s.displayAll();
        s.delete("İstanbul");
        s.displayAll();
        s.delete("mersin");

    }
}

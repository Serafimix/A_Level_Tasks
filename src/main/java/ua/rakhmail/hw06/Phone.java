package ua.rakhmail.hw06;

public class Phone {
    long number;
    String model;
    int weight;

    public Phone(long number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(long number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void receiveCall(String name) {
        System.out.println("Звонит \"" + name + "\"");
    }

    public long getNumber() {
        return this.number;
    }

    public static void main(String[] args) {
        String whoYouGonnaCall = "Ghostbusters";
        Phone iPhone = new Phone(7427230, "iPhone12", 162);
        Phone nokia = new Phone(80981234567L, "nokiaN73me");
        nokia.weight = 100;
        Phone samsung = new Phone();
        samsung.number = 80959876543L;
        samsung.model = "Galaxy Z";
        samsung.weight = 182;
        System.out.println(iPhone);
        System.out.println(nokia);
        System.out.println(samsung);
        iPhone.receiveCall(whoYouGonnaCall);
        nokia.receiveCall(whoYouGonnaCall);
        samsung.receiveCall(whoYouGonnaCall);
//      Phone.receiveCall(whoYouGonnaCall); это правильнее.

        System.out.println(iPhone.getNumber());
        System.out.println(nokia.getNumber());
        System.out.println(samsung.getNumber());
    }
}

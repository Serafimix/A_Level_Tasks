package ua.rakhmail.hw18;

public class Main {
    public static void main(String[] args) {
        Box boxJson = new Box("src/main/resources/task18/text_for_hw18_task02.json");
        Box boxXml = new Box("src/main/resources/task18/text_for_hw18_task01.xml");
        System.out.println(boxJson);
        System.out.println(boxXml);
        System.out.println(boxJson.equals(boxXml));
        System.out.println(boxJson == boxXml);
    }
}

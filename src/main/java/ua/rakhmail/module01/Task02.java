package ua.rakhmail.module01;

// переписал логику коня, после сдачи модуля, без использования сканера, для решения hw10

public class Task02 {
    public static void main(String[] args) {
        System.out.println(moveHorse("C5", "E4"));
        System.out.println(moveHorse("C5asfd124", "E4asf124"));
        System.out.println(moveHorse("H0", "G2"));
        System.out.println(moveHorse("A1", "H7"));
    }

    public static boolean moveHorse(String current, String target) {
        if ((current.length() == 2) || target.length() == 2) {
            int currentNumerical = current.charAt(1) - 48; //48 in ascII = 0, next 1.
            int targetNumerical = target.charAt(1) - 48;
            int currentLiter = current.toLowerCase().charAt(0) - 96; // 96 in ascII = `, next = a
            int targetLiter = target.toLowerCase().charAt(0) - 96;
            int differentNumerical = Math.abs(currentNumerical - targetNumerical);
            int differentLiter = Math.abs(currentLiter - targetLiter);
            return (differentNumerical == 1 && differentLiter == 2 || differentNumerical == 2 && differentLiter == 1) &&
                    targetNumerical >= 1 && currentNumerical >= 1 && targetLiter >= 1 && currentLiter >= 1 &&
                    targetNumerical <= 8 && currentNumerical <= 8 && targetLiter <= 8 && currentLiter <= 8;
        } else return false;
    }

}
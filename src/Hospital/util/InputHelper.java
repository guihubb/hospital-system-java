package Hospital.util;

import java.util.Scanner;

public class InputHelper {
    static Scanner scan = new Scanner(System.in);

    public static int lerInt(String text){
        System.out.println(text);
        return Integer.parseInt(scan.nextLine());
    }

    public static double lerDouble(String text){
        System.out.println(text);
        return Double.parseDouble(scan.nextLine());
    }

    public static String lerString(String text){
        System.out.println(text);
        return scan.nextLine();
    }
}

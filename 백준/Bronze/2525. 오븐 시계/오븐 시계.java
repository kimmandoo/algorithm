import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int req = sc.nextInt();

        hour = hour + (req / 60);
        min = min + (req % 60);

        if (min > 59) {
            min -= 60;
            hour++;
        }
        if (hour > 23) {
            hour -= 24;
        }
        System.out.println(hour + " " + min);
        sc.close();
    }
}
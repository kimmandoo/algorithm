import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		String y = scanner.nextLine();
		
		if(Integer.parseInt(x)>0&&Integer.parseInt(y)>0) System.out.print("1");
		if(Integer.parseInt(x)<0&&Integer.parseInt(y)>0) System.out.print("2");
		if(Integer.parseInt(x)<0&&Integer.parseInt(y)<0) System.out.print("3");
		if(Integer.parseInt(x)>0&&Integer.parseInt(y)<0) System.out.print("4");

	}
}
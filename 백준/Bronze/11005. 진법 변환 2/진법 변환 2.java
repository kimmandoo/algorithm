import java.io.FileInputStream;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int jinbup = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while(input/jinbup != 0){
            int tmp = input%jinbup;
            if (tmp >=10) {
                sb.insert(0, Character.toChars(tmp+55));
            }else{
                sb.insert(0, tmp);
            }
            input = input/jinbup;
        }
        if (input >=10) {
                sb.insert(0, Character.toChars(input+55));
            }else{
                sb.insert(0, input);
            }
        System.out.println(sb.toString());
        sc.close();
    }
}
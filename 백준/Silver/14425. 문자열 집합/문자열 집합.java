import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Set<String> target = new HashSet<>();

        int ans = 0;
        for(int i=0; i<n; i++){
            target.add(sc.next());
        }

        for(int i=0; i<m; i++){
            String input = sc.next();
            if (target.contains(input)) ans++;
        }


        System.out.println(ans);

        sc.close();
    }
}
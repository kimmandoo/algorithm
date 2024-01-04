import java.io.FileInputStream;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = 20;
        for(int tc = 0; tc<T; tc++){
            int tcNum = sc.nextInt();
            int[] input = new int[n]; 
            int fallBack = 0;
            input[0] = sc.nextInt();
            for(int i=1; i<n;i++){
                input[i] = sc.nextInt();
                for(int j=i; j>0; j--){
                    if(input[j-1]>input[j]){
                        int tmpJ = input[j-1];
                        input[j-1] = input[j];
                        input[j] = tmpJ;
                        fallBack++;
                    }
                }
            }
            System.out.println(tcNum+" "+ fallBack);
        }
        sc.close();
    }
}
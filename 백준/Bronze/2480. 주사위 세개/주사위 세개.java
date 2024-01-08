import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int[] dice = new int[7];
        for(int i=0; i<3; i++){
            int tmp = sc.nextInt();
            dice[tmp]++;
        }
        int score = 0;
        int max = 0;
        for(int i=1; i<=6; i++){
            if(dice[i]==3){
                score = 10000+i*1000;
                break;
            }
            if(dice[i]==2) {
                score = 1000 + i * 100;
                break;
            }
            if(dice[i]==1){
                max = i;
            }
        }
        if(max!=0 && score == 0) score = max*100;

        System.out.println(score);
        sc.close();
    }
}
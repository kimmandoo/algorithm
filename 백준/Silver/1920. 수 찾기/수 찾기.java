import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{

    public static int binarySearch(int[] arr, int target){
        int l=0; int r = arr.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if(arr[m]<target) l = m+1;
            else if(arr[m]>target) r = m-1;
            else return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for(int i=0; i<n;i++){
            arrN[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arrM = new int[m];
        for(int i=0; i<m;i++){
            arrM[i] = sc.nextInt();
        }
        Arrays.sort(arrN);
        for(int X: arrM){
            System.out.println(binarySearch(arrN, X));
        }

        sc.close();
    }
}
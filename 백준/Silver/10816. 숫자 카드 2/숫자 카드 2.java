import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{

    public static int lowerBound(int[] arr, int target){
        int l=0; int r = arr.length;
        while (l<r){
            int m = (l+r)/2;
            if(arr[m]>=target){
                r = m;
            } else{ // 찾았음
                l = m+1;
            }
        }
        return l;
    }

    public static int upperBound(int[] arr, int target){
        int l=0; int r = arr.length;
        while (l<r){
            int m = (l+r)/2;
            if(arr[m]>target){
                r = m;
            } else{ // 찾았음
                l = m+1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        int m = sc.nextInt();
        for(int i=0; i<m;i++){
            int tmp = sc.nextInt();
            sb.append(upperBound(arr,tmp)-lowerBound(arr,tmp)).append(" ");
        }
        System.out.println(sb);

        sc.close();
    }
}
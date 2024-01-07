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
        int[] arr = new int[n];
        int max = -1;
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] set = new int[(n*(n+1))/2];
        int idx = 0;
        for(int i=0; i<n;i++){
            for(int j=i; j<n; j++){
                set[idx++] = arr[i]+arr[j];
            }
        }
        Arrays.sort(set);
        for(int x=0;x<n; x++){
            for(int c=0;c<n; c++){
                int tmp = arr[x]-arr[c];
                int bs = Arrays.binarySearch(set, tmp);
                if(bs >= 0){
                    max = Math.max(max, arr[x]);
                }
            }
        }
        System.out.println(max);

        sc.close();
    }
}
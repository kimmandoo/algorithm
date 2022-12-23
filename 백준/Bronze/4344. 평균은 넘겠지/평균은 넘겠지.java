import java.util.*;

class Main {
  static int n;
  static int m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for(int i=0; i<n; i++){
      m = sc.nextInt();
      int [] arr = new int[m];
      for(int j=0; j<m; j++){
        arr[j] = sc.nextInt();
      }
      System.out.println(Solution(arr)+"%");
    }
  }

  static String Solution(int[] arr){
    int n = arr.length;
    int avg = 0;
    int sum = 0;
    for(int i=0; i<n; i++){
      sum = sum + arr[i];
    }
    
    avg = sum/n;
    double sSize = 0;
    for(int i=0; i<n; i++){
      if(arr[i]>avg){
        sSize++;
      }
    }
    
    
    return String.format("%.3f", (sSize/(double)n)*100);
  }
}

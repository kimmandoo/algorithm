import java.util.*;

class Main {
  static int n;
  static int m;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    
    int[][] arr1 = new int[n][m];
    int[][] arr2 = new int[n][m];
    //m1
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        arr1[i][j] = sc.nextInt();
      }
    }
    //m2
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        arr2[i][j] = sc.nextInt();
      }
    }
    sc.close();
    int[][] result = Solution(arr1, arr2);
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        System.out.print(result[i][j]+" ");
      }
        System.out.print("\n");
    }
  }

  static int[][] Solution(int[][] arr1, int[][] arr2){
    int[][] result = new int[n][m];
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        result[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return result;
  }
}

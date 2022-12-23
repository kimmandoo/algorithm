import java.util.*;

class Main {
  static int n;
  static int m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    n = sc.nextInt();
    m = sc.nextInt();

    ArrayList<String> S = new ArrayList<>(n);
    ArrayList<String> testCase = new ArrayList<>(m);
    
    for(int i=0; i<n; i++){
      S.add(sc.next());
    }
    
    for(int i=0;i<m; i++){
      testCase.add(sc.next());
    }
    System.out.print(Solution(S, testCase));

  }

  static int Solution(ArrayList<String> S, ArrayList<String> testCase){
    int result = 0;
    for(int i=0; i<m; i++){
      if(S.contains(testCase.get(i))) result++;
    }
    return result;
  }
}

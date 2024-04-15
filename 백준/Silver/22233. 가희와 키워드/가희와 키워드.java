import java.util.*;
import java.io.*;

class Main {
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    HashSet<String> arr = new HashSet<String>();
    HashSet<String> check = new HashSet<String>();

    for(int i=0; i<n; i++){
      arr.add(br.readLine());
    }
    
    for(int i=0; i<m; i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine(),",");
      int size = st2.countTokens();
      
      for(int j=0; j<size; j++){
        String value = st2.nextToken();
        if(arr.contains(value)){
          if(check.contains(value)){
            
          }else{
            check.add(value);
            n--;
          }
        } 
      }
      bw.write(n+"\n");
    }
    bw.flush();
    br.close();

    // System.out.print(Solution(n));
  }

}

import java.util.*;
import java.io.*;

class Main {
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashMap<String,String> arr = new HashMap<String,String>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken()); 
    m = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<n; i++){
      StringTokenizer input = new StringTokenizer(br.readLine());
      arr.put(input.nextToken(), input.nextToken());
    }
    for(int i=0; i<m; i++){
      String key = br.readLine();
      if(arr.containsKey(key)){
        bw.write(arr.get(key) + "\n");
      }
    }

    bw.flush();
    br.close();
  }
}
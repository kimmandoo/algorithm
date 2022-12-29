import java.util.*;
import java.io.*;

class Main {
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int mem = 0;
    
    for(int i=0; i<10; i++){
      if(n>=100){ break;}
      else{
        mem = n;
        n += Integer.parseInt(br.readLine());
        if(n>100){
          if(100-mem < n-100){
            n = mem;
            break;
          }
        }
      }
    }
    bw.write(n+"\n");
    bw.flush();
    br.close();
  }
}

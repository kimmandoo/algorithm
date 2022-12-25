import java.util.*;
import java.io.*;

class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.print(Solution(n));
  }

  static int Solution(int n){
    int len = 0;
    for(int i=1; i<=n; i++){
      if(i<10){
        len++;
      }
      if(10 <= i && i <100) len = len+2;
      if(100<= i && i < 1000) len = len+3;
      if(1000 <=i && i < 10000) len = len+4;
      if(10000 <=i && i < 100000) len = len+5;
      if(100000 <=i && i < 1000000) len = len+6;
      if(1000000 <=i && i < 10000000) len = len+7;
      if(10000000 <=i && i < 100000000) len = len+8;
      if(100000000<=i && i < 1000000000) len = len+9;
    }

    return len;
  }
}
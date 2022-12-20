import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> input = new ArrayList<Integer>(5);
    for(int i=0; i<=5; i++){
      input.add(sc.nextInt());
    }
    ArrayList<Integer> result = Solution(input);
    
    sc.close();
    System.out.print(result.get(0)+" ");
    System.out.print(result.get(1)+" ");
    System.out.print(result.get(2)+" ");
    System.out.print(result.get(3)+" ");
    System.out.print(result.get(4)+" ");
    System.out.print(result.get(5));
    

  }

  static ArrayList<Integer> Solution(ArrayList<Integer> input){
    ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(1,1,2,2,2,8));
    for(int i=0; i<=5; i++){
      result.set(i, result.get(i) - input.get(i));
    }
    
    return result;
  }
}
//킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8
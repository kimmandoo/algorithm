import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String rear = "";
        for(int i=0; i<n; i++){
            String input = br.readLine();
            if(input.contains("push")){
                String[] tmp = input.split(" ");
                q.offer(tmp[1]);
                rear = tmp[1]; // back 했을 때 나와야 될 것.
            }else if(input.equals("front")){
                if(!q.isEmpty()){
                    bw.write(q.peek()+"\n");
                }else{
                    bw.write(-1+"\n");
                }
            }else if(input.equals("back")){
                if(!q.isEmpty()){
                    bw.write(rear+"\n");
                }else{
                    bw.write(-1+"\n");
                }
            }else if(input.equals("pop")){
                if(!q.isEmpty()){
                    String pop = q.poll();
                    bw.write(pop+"\n");
                }else{
                    bw.write(-1+"\n");
                }
            }else if(input.equals("size")){
                bw.write(q.size()+"\n");
            }else if(input.equals("empty")){
                if(q.size() > 0){
                    bw.write(0+"\n");
                }else{
                    bw.write(1+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
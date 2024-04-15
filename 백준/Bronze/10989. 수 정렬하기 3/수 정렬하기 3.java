import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] buffer = new int[10001];
        for(int i=0; i<size; i++){
            int tmp = Integer.parseInt(br.readLine());
            buffer[tmp]++;
        }

        StringBuilder sb = new StringBuilder();
        // java 는 구간합으로 계수정렬 해야됨
        for(int j=1; j<=10000; j++){
            while(buffer[j]-- >0){
                sb.append(j).append("\n");
            }
        }
        System.out.println(sb);
    }
}
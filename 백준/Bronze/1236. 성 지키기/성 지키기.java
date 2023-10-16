import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        int[] nmap = new int[N];
        int[] mmap = new int[M];
        int nRes = N;
        int mRes = M;

        for(int i=0; i<N; i++){
            boolean isRowExist = false;
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                if(tmp != null && tmp.charAt(j) == 'X'){
                    if(mmap[j] == 0){
                        mmap[j] = 1;
                        mRes--;
                    }
                    isRowExist = true;
                }
            }
            if(isRowExist == true && nmap[i]==0){
                nmap[i] = 1;
                nRes--;
            }
        }
        //counting
        int res = Math.max(mRes, nRes);
        System.out.println(res);
        br.close();
    }
}
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        int[] tri = new int[50];
        // 대략 1~1000까지의 삼각수 모두 저장
        for(int i=1; i<=50; i++){
            tri[i-1] = (i*(i+1))/2;
        }

        for(int i=0;i<size;i++){
            int target = Integer.parseInt(br.readLine());
            sb.append(check(target, tri)).append("\n");
        }

        System.out.println(sb);
    }
    static int check(int target, int[] tri){
        for(int i=0; i<50;i++){
            for(int j=0;j<50;j++){
                for(int k=0;k<50;k++){
                    if(tri[i]+tri[j]+tri[k] == target) return 1;
                }
            }
        }
        return 0;
    }
}
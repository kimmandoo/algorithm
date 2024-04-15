import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 0; t < tc; t++) {
            int res = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            for (int B = 2; B <= 64; B++) { //64진법까지
                //종료: 회문인 수 찾았는가?
                if(res==1)
                    break;
                int mok = N;
                int len =0;
                int[] resArr = new int[20];
                //1. 진법 변환
                while(true) {
                    if(mok==0)
                        break;
                    resArr[len++] = mok%B;
                    mok = mok / B;
                }

                //2. 회문여부 확인 -> 대칭으로 검사
                for (int i = 0; i <= (len/2); i++) {
                    if(resArr[i]==resArr[len-1-i]) {
                        if(i==len/2)
                            res = 1;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(res);

        }
    }

}
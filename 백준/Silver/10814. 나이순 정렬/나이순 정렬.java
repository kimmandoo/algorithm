import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String[]> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new String[]{Integer.toString(age), name});
        }

        // 나이를 기준으로 정렬, 나이가 같으면 가입한 순으로 정렬
        Collections.sort(members, (m1, m2) -> {
            int age1 = Integer.parseInt(m1[0]);
            int age2 = Integer.parseInt(m2[0]);

            if (age1 == age2) {
                return 0;
            }
            return age1 < age2 ? -1 : 1;
        });

        for (String[] member : members) {
            System.out.println(member[0] + " " + member[1]);
        }
    }
}
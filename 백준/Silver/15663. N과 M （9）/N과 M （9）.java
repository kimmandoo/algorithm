import java.util.*;

public class Main {
    static int N, M;
    static int[] nums, perm;
    static boolean[] visit;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        perm = new int[M];
        visit = new boolean[N];
        ans = new LinkedHashSet<>();
        // TreeSet으로 중복제거를 하면 String기준 오름차순 정렬이라 숫자 기준 정렬이 깨진다 
        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);
        permutation(0);
        ans.forEach(System.out::println);
    }

    static void permutation(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int p : perm)
                sb.append(p).append(' ');
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            perm[cnt] = nums[i];
            permutation(cnt + 1);
            visit[i] = false;
        }
    }
}
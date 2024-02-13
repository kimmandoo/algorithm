import java.util.*;

class Main {
//	static List<Integer>[] garo; // n 자른거 보관
//	static List<Integer>[] sero; // m 자른거 보관

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> garo = new ArrayList();
		List<Integer> sero = new ArrayList();
		garo.add(n);
		sero.add(m);
		int jumson = sc.nextInt();
		for (int i = 0; i < jumson; i++) {
			int type = sc.nextInt();
			int slice = sc.nextInt();
			if (type == 1) { // 세로 컷팅 -> n 나누기 -> slice 기준으로 n 빼고 slice, n-slice 두기.
				int index;
				for (index = 0; slice - garo.get(index) > 0; index++) {// 작은걸 먼저 저장하고 있기 때문에 정렬하지 않아도 get으로 첫 원소부터 가져와서
																		// 해도 됨.
					// 이 조건이 탈출하는 시점은 slice 값 보다 큰 값을 garo에서 찾았을 때다.
					slice -= garo.get(index);
				}
				int temp = garo.remove(index);
				garo.add(index, temp - slice);
				garo.add(index, slice);
			} else { // m 나누기
				int index;
				for (index = 0; slice - sero.get(index) > 0; index++) {
					slice -= sero.get(index);
				}
				int temp = sero.remove(index);
				sero.add(index, temp - slice);
				sero.add(index, slice);
			}
		}
		int max = 0;
		for (int i : garo) {
			for (int j : sero) {
				max = Math.max(i * j, max);
			}
		}
		System.out.println(max);
		sc.close();
	}
}
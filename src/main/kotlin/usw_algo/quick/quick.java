package usw_algo.quick;

import java.util.ArrayList;
import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(90, 2, 7, 1, 50, 40, 21, 19, 3, 11));
        System.out.println("RESULT: " + quick(input, 0, input.size() - 1));

    }

    //r이 마지막 원소로 기준점이 됨
    public static ArrayList<Integer> quick(ArrayList<Integer> input, int p, int r) {
        if (p < r) {
            int q = partition(input, p, r);

            quick(input, p, q - 1);
            quick(input, q + 1, r);
        }

        return input;
    }

    static int partition(ArrayList<Integer> input, int p, int r) {
        // i는 1구역의 끝지점(1구역과 2구역사이) 1구역은 x보다 작고, 2구역은 x보다 크다
        // j는 3구역의 시작지점(미결정된 원소들 훑는 역할)

        // 기준원소를 가져옴 -> 배열 맨끝
        int x = input.get(r);

        int i;
        if (p < 1) {
            // 맨처음일때는 i가 -1
            i = -1;
        } else {
            // p가 1이면 0이 되도록
            i = p - 1;
        }
        //맨 마지막이 기준원소이므로 건드리지 않음
        for (int j = p; j < r; j++) {
            if (input.get(j) <= x) { //3구역 훑으면서 x보다 큰지 작은지 결정하기
                // 작은경우 1구역에 넣어줘야됨. 1구역 하나 밀고 넣기.
                // 작은거만 계속 넣으면 1구역에는 정렬되지않았지만 x보다 작은 원소들만 들어있음.
                swap(input, ++i, j);
            }
        }
        // 1구역에 값 배정이 모두 끝났으면 기준원소 위치와 1구역 끝부분 위치를 바꿔줌. 정확히는 2구역 시작부분이 될것.
        swap(input, ++i, r);

        //1구역과 2구역을 나누는 지점. 분할점(피벗)
        System.out.println(input);
        System.out.println("pivot: " + i);
        return i;
    }

    static void swap(ArrayList<Integer> input, int i, int j) {
        int tmp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, tmp);
    }

}

package usw_algo;

import java.util.ArrayList;
import java.util.Arrays;

public class merge {
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int q = dataList.size() / 2;

        ArrayList<Integer> listL;
        ArrayList<Integer> listR;

        listL = mergeSort(new ArrayList<Integer>(dataList.subList(0, q)));
        listR = mergeSort(new ArrayList<Integer>(dataList.subList(q, dataList.size())));

        System.out.println(merge(listL, listR));

        return merge(listL, listR);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> listL, ArrayList<Integer> listR) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int lp = 0;
        int rp = 0;
        //case 1 -> left right 모두 생존
        while (lp < listL.size() && rp < listR.size()) {
            if (listL.get(lp) <= listR.get(rp)) {
                tempList.add(listL.get(lp++));
            } else {
                tempList.add(listR.get(rp++));
            }
        }
        //case 2 -> right 가 더이상 없을때
        while (lp < listL.size()) {
            tempList.add(listL.get(lp++));
        }

        //case 3 -> left 가 더이상 없을때
        while (rp < listR.size()) {
            tempList.add(listR.get(rp++));
        }

        return tempList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataSet = new ArrayList<Integer>(Arrays.asList(31, 3, 65, 73, 8, 11, 20, 29, 48, 15));
        mergeSort(dataSet);
    }
}

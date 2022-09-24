package usw_algo.merge;

import java.util.ArrayList;

public class mergesortSudoVersion {
    static ArrayList<Integer> testData = new ArrayList<Integer>();
    static ArrayList<Integer> tmpList = new ArrayList<>();

    public static void main(String[] args){

        for(int i=0; i<20; i++){
            testData.add((int)(Math.random()*100));
        }
        mergeSort(testData,0,testData.size());

    }
    public static void mergeSort(ArrayList<Integer> dataList, int p, int r){
        int q = 0;
        if (p < r) q = (p+r)/2;

        mergeSort(dataList, p, q);
        mergeSort(dataList, q+1, r);
        merge(dataList,p,q,r);
        System.out.println(tmpList);
    }

    public static void merge(ArrayList<Integer> dataList, int p, int q, int r){
        int lp = p;
        int rp = q+1;
        //case 1 -> left right 모두 생존
        while(lp <= q && rp <= r){
            if (dataList.get(lp) <= dataList.get(rp)){
                tmpList.add(dataList.get(lp++));
            }else{
                tmpList.add(dataList.get(rp++));
            }
        }
        //case 2 -> right 가 더이상 없을때
        while(lp <= q){
            tmpList.add(dataList.get(lp++));
        }

        //case 3 -> left 가 더이상 없을때
        while(rp <= r){
            tmpList.add(dataList.get(rp++));
        }
    }
}

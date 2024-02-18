import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int j = -1;
        int i = -1;
        List<Integer> f = new ArrayList();
        for(int item: nums) {
        	f.add(item);
        }
        for(i=0; i<len; i++){
            int tmp = target-f.get(i);
            if(f.contains(tmp) && i < f.lastIndexOf(tmp)){
               j = f.lastIndexOf(tmp);
               break;
            }
        }
        return new int[]{i,j};
    }
}
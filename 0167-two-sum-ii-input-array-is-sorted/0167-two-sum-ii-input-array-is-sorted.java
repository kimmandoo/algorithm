class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = -1;
        int j = -1;
        
        for(i=0; i<numbers.length; i++){
            for(j=i+1; j<numbers.length; j++){
                if(numbers[i]+numbers[j] == target) return new int[]{i+1,j+1};
            } 
        }
        
        return new int[]{i+1,j+1};
    }
}
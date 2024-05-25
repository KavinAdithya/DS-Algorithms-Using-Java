package concept.dataStructure;

import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = (List<List<Integer>>) new ArrayList<>();

        int n = nums.length ;
        Arrays.sort(nums);

        for(int k = 0; k < n - 2; k++){
            if(k > 0 && nums[k] == nums[k - 1])
                continue;
            int start = k + 1;
            int end = n - 1;

            while(start < end){
                int sum = nums[k] + nums[start] + nums[end];

                if(sum == 0){
                    list.add(Arrays.asList(nums[k], nums[start], nums[end]));
                    start++;

                    while(start < end && nums[start] == nums[start - 1])
                        start++;
                }
                else if(sum < 0)
                    start++;
                else
                    end--;
            }
        }

        return list;
    }
}

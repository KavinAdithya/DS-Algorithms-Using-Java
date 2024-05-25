package concept.dataStructure;
import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> resultList = (List<List<Integer>>) new ArrayList<>();

        for(int k = 0; k < length - 3; k++){

            if(k > 0 && nums[k] == nums[k - 1])
                continue;

            for(int d = k + 1; d < length - 2; d++){

                if(d > (k+1) && nums[d] == nums[d - 1])
                    continue;

                int i = d + 1;
                int j = length - 1;

                while(i < j){
                    long sum = (long)nums[k] + (long)nums[d] + (long)nums[i] + (long)nums[j];
                    //System.out.println(sum);
                    if(sum == (long)target){
                        resultList.add(Arrays.asList(nums[k], nums[d], nums[i], nums[j]));
                        i++;

                        while(i < j && nums[i] == nums[i - 1])
                            i++;
                    }
                    else if(sum > (long)target)
                        j--;
                    else
                        i++;
                }
            }
        }

        return resultList;
    }


    //Brute Force
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     Set<List<Integer>> resultSet = new HashSet<>();
    //     int length = nums.length;

    //     for(int k = 0; k < length - 3; k++){
    //         for(int d = k + 1; d < length - 2; d++){
    //             for(int i = d + 1; i < length - 1; i++){
    //                 for(int j = i + 1; j < length; j++){
    //                     if(nums[k] + nums[d] + nums[i] + nums[j] == target){
    //                         List<Integer> list = Arrays.asList(nums[k], nums[d], nums[i], nums[j]);
    //                         Collections.sort(list);
    //                         resultSet.add(list);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return new ArrayList<List<Integer>>(resultSet);
    // }
}

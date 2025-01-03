package com.techcrack.DSA.arrayBinarySearch;

public class PeakMountain {
    public int findInMountainArray(int target, MountainArray mountainArray) {

        int peak = givePeak(mountainArray);

        int left = binarySearch(target, 0, peak,mountainArray ,true);

        if(left != -1)
            return left;

        return  binarySearch(target, peak + 1, mountainArray.length() - 1, mountainArray, false);
    }

    private int givePeak(MountainArray mountainArray){
        int start = 0;
        int end = mountainArray.length() - 1;

        while(start < end){
            int mid = (start + end) / 2;
            if(mountainArray.get(mid) < mountainArray.get(mid + 1))
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    private int binarySearch(int target, int start, int end, MountainArray mountainArray, boolean leftSearch){


        while(start <= end){
            int mid = (start + end) / 2;
            int midValue = mountainArray.get(mid);

            if(midValue == target)
                return mid;
            else if(midValue > target){
                if(leftSearch)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                if(leftSearch)
                    start = mid + 1;
                else
                    end = mid - 1;

            }
        }

        return -1;
    }
}


14. 二分查找
给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。

样例
在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。

挑战
如果数组中的整数个数超过了2^32，你的算法是否会出错？



class Solution {
public:
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    int binarySearch(vector<int> &nums, int target) {
        // write your code here
        if(nums.size()<1) return -1;
        return LeftSearch(nums,target,0,nums.size());
        
    }
private:
     
    int LeftSearch(vector<int> &nums,int target,int L,int R)
    {
        if(nums.size()<1 || L>R) return -1;
        while(L<=R)
        {
            int mid=L+((R-L)>>1);
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]<target)
                {
                    return mid;
                }
                R=mid-1;
            }else if(nums[mid]<target)
            {
                L=mid+1;
            }else if(nums[mid]>target)
            {
                R=mid-1;
            }
        }
        return -1;
    }
};


#######################################################

class Solution:
    """
    @param nums: The integer array.
    @param target: Target to find.
    @return: The first position of target. Position starts from 0.
    """
    def binarySearch(self, nums, target):
        # write your code here
        if len(nums)<1:
            return -1
        L=0
        R=len(nums)
        while L<=R:
            mid=L+((R-L)>>1)
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<target:
                    return mid
                R=mid-1
            elif nums[mid]>target:
                R=mid-1
            elif nums[mid]<target:
                L=mid+1
        return -1 
##############################################################


public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums.length<1) return -1;
        int L=0;
        int R=nums.length;
        while(L<=R)
        {
            int mid=L+((R-L)>>1);
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]<target)
                {
                    return mid;
                }
                R=mid-1;
            }else if(nums[mid]>target)
            {
                R=mid-1;
            }else if(nums[mid]<target)
            {
                L=mid+1;
            }
        }
        return -1;
    }
}


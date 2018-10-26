160. 寻找旋转排序数组中的最小值 II

假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。

你需要找到其中最小的元素。

数组中可能存在重复的元素。
样例

给出[4,4,5,6,7,0,1,2]  返回 0
注意事项

The array may contain duplicates.

    public class Solution {
        /**
         * @param nums: a rotated sorted array
         * @return: the minimum number in the array
         */
        public int findMin(int[] nums) {
            // write your code here
            if(nums.length<1) return 0;
            if(nums.length<2) return nums[0];
            int L=0;
            int R=nums.length-1;
            while(L+1<R)
            {
                int mid=L+((R-L)>>1);
                if(nums[mid]==nums[R])
                {
                    R--;
                }else if(nums[mid]<nums[R])
                {
                    R=mid;
                }else
                {
                    L=mid+1;
                }
            }
            if(nums[L]<=nums[R])
            {
                return nums[L];
            }
            return nums[R];
        }
    }
     
    ####################################################
    class Solution:
        """
        @param nums: a rotated sorted array
        @return: the minimum number in the array
        """
        def findMin(self, nums):
            # write your code here
            if len(nums)<1:
                return 0
            if len(nums)<2:
                return nums[0]
            L=0
            R=len(nums)-1
            while L+1<R:
                mid=L+((R-L)>>1)
                if nums[mid]==nums[R]:
                    R-=1 
                elif nums[mid]<nums[R]:
                    R=mid
                else:
                    L=mid+1 
            if nums[L]<=nums[R]:
                return nums[L]
            return nums[R]
--------------------- 
作者：真理的追求者 
来源：CSDN 
原文：https://blog.csdn.net/CSU_GUO_LIANG/article/details/83420549 
版权声明：本文为博主原创文章，转载请附上博文链接！
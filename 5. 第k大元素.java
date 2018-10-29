5. 第k大元素
在数组中找到第k大的元素

样例
给出数组 [9,3,2,4,8]，第三大的元素是 4

给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推

挑战
要求时间复杂度为O(n)，空间复杂度为O(1)

注意事项
你可以交换数组中的元素的位置


class Solution:
    """
    @param n: An integer
    @param nums: An array
    @return: the Kth largest element
    """
    def kthLargestElement(self, n, nums):
        # write your code here
        if n < 1 or nums == None:
            return 0;
        tmp=sorted(nums,reverse=True)
        return tmp[n-1];
        
#############################################
class Solution {
public:
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    int kthLargestElement(int n, vector<int> &nums) {
        // write your code here
        if(nums.size()<n || nums.size()<1 || n<1) return 0;
        priority_queue<int,vector<int>,greater<int> > Q;
        for(int i=0;i<nums.size();i++)
        {
            if(i<n)
            {
                Q.push(nums[i]);
            }else
            {
                if(nums[i]>Q.top())
                {
                    Q.pop();
                    Q.push(nums[i]);
                }
            }
        }
        return Q.top();
    }
};

#############################################

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
         if(nums.size()<k || nums.size()<1 || k<1) return 0;
        int len=nums.size();
        for(int i=1;i<k;i++)
        {
            heapInsert(nums,i);
        }
        for(int i=k;i<len;i++)
        {
            if(nums[0]<nums[i])
            {
                nums[0]=nums[i];
                heapFY(nums,0,k);
               
            }
        }
        
        return nums[0];
    }

private:
    void heapFY(vector<int>& nums,int index,int Size)
    {
        int left=2*index+1;
        while(left<Size)
        {
            int largest=(left+1<Size && nums[left+1]<nums[left])?left+1:left;
            largest=nums[index]<nums[largest]?index:largest;
            if(largest==index)
            {
                break;
            }
            swap(nums[index],nums[largest]);
            index=largest;
            left=2*index+1;
        }
    }
    void heapInsert(vector<int>& nums,int index)
    {
        while(nums[(index-1)/2]>nums[index])
        {
            swap(nums[(index-1)/2],nums[index]);
            index=(index-1)/2;
        }
    }
};



####################################################

public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if(n<1 || nums==null) return 0;
        for(int i=1;i<n;i++)
        {
            heapInsert(nums,i);
        }
        for(int i=n;i<nums.length;i++)
        {
            if(nums[i]>nums[0])
            {
                nums[0]=nums[i];
                heapfy(nums,n,0);
            }
        }
        return nums[0];
    }
    
    public void heapfy(int[] nums,int Size,int index)
    {
        int left=2*index+1;
        while(left<Size)
        {
            int largest=left+1<Size && nums[left+1]<nums[left]?left+1:left;
            largest=nums[largest]<nums[index]?largest:index;
            if(largest==index)
            {
                break;
            }
            swap(nums,index,largest);
            index=largest;
            left=2*index+1;
            
        }
    }
    
    public void heapInsert(int[] nums,int index)
    {
        while(nums[(index-1)/2]>nums[index])
        {
            swap(nums,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    
    public void swap(int[] nums,int index1,int index2)
    {
        int tmp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=tmp;
    }
}









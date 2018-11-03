15. 全排列
给定一个数字列表，返回其所有可能的排列。

样例
给出一个列表[1,2,3]，其全排列为：

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
挑战
使用递归和非递归分别解决。

注意事项
你可以假设没有重复数字。

class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    vector<vector<int>> permute(vector<int> &nums) {
        // write your code here
        vector<vector<int> > res;
        if(nums.size()<1)
        {
            res.push_back(nums);
            return res;
        }
        premute(nums,0,res);
        return res;
    }
    
private:
    void premute(vector<int>& nums,int index,vector<vector<int> >& res)
    {
        if(index>=nums.size())
        {
            res.push_back(nums);
            return ;
        }
        unordered_set<int> S;
        for(int i=index;i<nums.size();i++)
        {
            if(S.find(nums[i])==S.end())
            {
            	S.insert(nums[i]);
                swap(nums[i],nums[index]);
                premute(nums,index+1,res);
                swap(nums[i],nums[index]);
            }
        }
    }
};



###################################################


class Solution:
    """
    @param: nums: A list of integers.
    @return: A list of permutations.
    """
    def permute(self, nums):
        # write your code here
        if len(nums)<1:
            return [[]]
        res=[]
        self.permutes(nums,0,res)
        return res
        
    def permutes(self,nums,index,res):
        if index>=len(nums):
            res.append(list(nums))
            return 
        for i in range(index,len(nums)):
            self.swap(nums,i,index)
            self.permutes(nums,index+1,res)
            self.swap(nums,i,index)
        
    def swap(self,nums,a,b):
        tt=nums[a]
        nums[a]=nums[b]
        nums[b]=tt 





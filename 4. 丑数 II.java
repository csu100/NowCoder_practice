4. 丑数 II
设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

样例
如果n = 9， 返回 10

挑战
要求时间复杂度为O(nlogn)或者O(n)

注意事项
我们可以认为1也是一个丑数


class Solution {
public:
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    int nthUglyNumber(int n) {
        // write your code here
        if(n<1) return 0;
        std::vector<int> dp(n,1);
        int next=1;
        int t2=0;
        int t3=0;
        int t5=0;
        for(int i=1;i<n;i++)
        {
            int tmp=min(min(2*dp[t2],3*dp[t3]),5*dp[t5]);
            dp[next]=tmp;
            while(dp[t2]*2<=tmp) t2++;
            while(dp[t3]*3<=tmp) t3++;
            while(dp[t5]*5<=tmp) t5++;
            next++;
        }
        return dp[n-1];
    }
};

###########################################

class Solution:
    """
    @param n: An integer
    @return: the nth prime number as description.
    """
    def nthUglyNumber(self, n):
        # write your code here
        if n<1:
            return 0
        dp=[1]
        t2,t3,t5=0,0,0
        for i in range(1,n):
            tmp=min(min(dp[t2]*2,dp[t3]*3),dp[t5]*5)
            dp.append(tmp)
            while dp[t2]*2<=tmp:
                t2+=1 
            while dp[t3]*3<=tmp:
                t3+=1 
            while dp[t5]*5<=tmp:
                t5+=1 
        return dp[-1]

############################################


public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        if(n<1) return 0;
        List<Integer> dp=new ArrayList<Integer>();
        dp.add(1);
        int t2=0,t3=0,t5=0;
        for(int i=1;i<n;i++)
        {
            int tmp = Math.min(dp.get(t2)*2,Math.min(dp.get(t3)*3,dp.get(t5)*5));
            dp.add(tmp);
            while(dp.get(t2)*2<=tmp) t2++;
            while(dp.get(t3)*3<=tmp) t3++;
            while(dp.get(t5)*5<=tmp) t5++;
        }
        return dp.get(n-1);
    }
}





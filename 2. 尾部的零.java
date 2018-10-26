2. 尾部的零

设计一个算法，计算出n阶乘中尾部零的个数
样例

11! = 39916800，因此应该返回 2
挑战

O(logN)的时间复杂度

public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        if(n<1) return 0;
        long sum=0;
        while(n>=5)
        {
            n=n/5;
            sum+=n;
        }
        return sum;
    }
}

###################################################

class Solution:
    """
    @param: n: An integer
    @return: An integer, denote the number of trailing zeros in n!
    """
    def trailingZeros(self, n):
        # write your code here, try to do it without arithmetic operators.
        if n<5: return 0
        sum=0
        while n>=5:
            n=n//5
            sum+=n 
        return sum

#########################################################
class Solution {
public:
    /*
     * @param n: A long integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    long long trailingZeros(long long n) {
        // write your code here, try to do it without arithmetic operators.
        if(n<5) return 0;
        long long sum=0;
        while(n>=5)
        {
            n=n/5;
            sum+=n;
        }
        return sum;
    }
};
 


3. 统计数字
计算数字k在0到n中的出现的次数，k可能是0~9的一个值

样例
例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)

public class Solution {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if(n<0) return 0;
        int sum=k==0?1:0;
        for(int i=k;i<=n;i++)
        {
            int number=i;
            while(number>0)
            {
                if(number%10==k)
                {
                    sum++;
                }
                number=number/10;
            }
        }
        return sum;
    }
}

##################################################
class Solution {
public:
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    int digitCounts(int k, int n) {
        // write your code here
        if(n<0) return 0;
        int sum=k==0?1:0;
        for(int i=k;i<=n;i++)
        {
            int number=i;
            while(number>0)
            {
                if(number%10==k)
                {
                    sum++;
                }
                number=number/10;
            }
        }
        return sum;
    }
};

###############################################

class Solution:
    """
    @param k: An integer
    @param n: An integer
    @return: An integer denote the count of digit k in 1..n
    """
    def digitCounts(self, k, n):
        # write your code here
        if n<0: return 0
        sum=0 
        if k==0:
            sum=1 
        for i in range(k,n+1):
            number=i
            while number>0:
                if number%10==k:
                    sum+=1 
                number=number//10
        return sum

9. Fizz Buzz 问题
给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

如果这个数被3整除，打印fizz.
如果这个数被5整除，打印buzz.
如果这个数能同时被3和5整除，打印fizz buzz.
样例
比如 n = 15, 返回一个字符串数组：

[
  "1", "2", "fizz",
  "4", "buzz", "fizz",
  "7", "8", "fizz",
  "buzz", "11", "fizz",
  "13", "14", "fizz buzz"
]
挑战
Can you do it with only one if statement?



class Solution {
public:
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    vector<string> fizzBuzz(int n) {
        // write your code here
        vector<string> res(n,"");
        if(n<1) return res;
        for(int i=1;i<=n;i++)
        {
            if(i%15==0)
            {
                res[i-1]="fizz buzz";
            }else if(i%5==0)
            {
                res[i-1]="buzz";
            }else if(i%3==0)
            {
                res[i-1]="fizz";
            }else
            {
                res[i-1]=to_string(i);
            }
        }
        return res;
    }
};

###################################################

class Solution:
    """
    @param n: An integer
    @return: A list of strings.
    """
    def fizzBuzz(self, n):
        # write your code here
        if n<1:
            return []
        res=[]
        for i in range(1,n+1,1):
            if i%15==0:
                res.append("fizz buzz")
            elif i%5==0:
                res.append("buzz")
            elif i%3==0:
                res.append("fizz")
            else:
                res.append(str(i))
        return res 


###################################################

public class Solution {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> res=new ArrayList();
        if(n<1) return res;
        for(int i=1;i<=n;i++)
        {
            if(i%15==0)
            {
                res.add("fizz buzz");
            }else if(i%5==0)
            {
                res.add("buzz");
            }else if(i%3==0)
            {
                res.add("fizz");
            }else
            {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}










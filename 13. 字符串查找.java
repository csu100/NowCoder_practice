13. 字符串查找
对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。

样例
如果 source = "source" 和 target = "target"，返回 -1。

如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。

挑战
O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）

说明
在面试中我是否需要实现KMP算法？

不需要，当这种问题出现在面试中时，面试官很可能只是想要测试一下你的基础应用能力。当然你需要先跟面试官确认清楚要怎么实现这个题。



class Solution {
public:
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    int strStr(string &source, string &target) {
        // Write your code here
        if(target.size()==0) return 0;
        if(source.size()<1 || source.size()<target.size()) return -1;
        int R=target.size();
        int pos=0;
        for(int i=0;i<source.size();)
        {
            if(source[i]!=target[pos])
            {
                int k=target.size()-1;
                while(k>0 && R<source.size()  && source[R]!=target[k])
                {
                    k--;
                }
                i=R-k;
                pos=0;
                R=i+target.size();
            }else
            {
                if(pos==target.size()-1)
                {
                    return i-pos;
                }
                i++;
                pos++;
            }
        }
        return -1;
    }
};

###############################################################



class Solution:
    """
    @param source: 
    @param target: 
    @return: return the index
    """
    def strStr(self, source, target):
        # Write your code here
        if len(target)==0:
            return 0
        if len(source)<1 or len(source)<len(target):
            return -1
        R=len(target)
        pos=0
        i=0
        while i<len(source):
            if source[i]!=target[pos]:
                k=len(target)-1
                while k>0 and R<len(source) and source[R]!=target[k]:
                    k-=1
                i=R-k
                pos=0
                R=i+len(target)
            else:
                if pos==len(target)-1:
                    return i-pos
                pos+=1 
                i+=1
        return -1 


#############################################################

public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if(target.length()<1) return 0;
        if(source.length()<1 || source.length()<target.length()) return -1;
        int R=target.length();
        int pos=0;
        char[] So=source.toCharArray();
        char[] Ta=target.toCharArray();
        for(int i=0; i<So.length;)
        {
            if(So[i]!=Ta[pos])
            {
                int k=Ta.length-1;
                while(k>0 && R<So.length && So[R]!=Ta[k])
                {
                    k--;
                }
                i=R-k;
                pos=0;
                R=i+Ta.length;
            }else
            {
                if(pos==Ta.length-1)
                {
                    return i-pos;
                }
                pos++;
                i++;
            }
        }
        return -1;
    }
}


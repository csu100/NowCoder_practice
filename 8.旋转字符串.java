8. 旋转字符串
给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)

样例
对于字符串 "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
挑战
在数组上原地旋转，使用O(1)的额外空间



class Solution {
public:
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    void rotateString(string &str, int offset) {
        // write your code here
        int len=str.size();
        if(len<2 || offset<1) return ;
        offset=len-offset%len;
        if(offset==len) return ;
        reverses(str,0,offset-1);
        reverses(str,offset,len-1);
        reverses(str,0,len-1);
    }
    
private:
    void reverses(string& str,int L,int R)
    {
        if(str.size()<2 || L>=R) return ;
        while(L<R)
        {
            swap(str[L++],str[R--]);
        }
    }
};

##################################################

class Solution:
    """
    @param str: An array of char
    @param offset: An integer
    @return: nothing
    """
    def rotateString(self, str, offset):
        # write your code here
        if len(str)<2 or offset<1:
            return 
        n=len(str)
        offset=n-offset%n
        if offset==n:
            return
        self.revers(str,0,offset-1)
        self.revers(str,offset,n-1)
        self.revers(str,0,n-1)
    
    def revers(self,str,L,R):
        if L>=R:
            return 
        while L<R:
            str[L],str[R]=str[R],str[L]
            L+=1 
            R-=1 
            
###############################################################

public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length<2 || offset<1) return ;
        int n=str.length;
        offset=n-offset%n;
        if(offset==n) return ;
        revers(str,0,offset-1);
        revers(str,offset,n-1);
        revers(str,0,n-1);
        
    }
    
    public void revers(char[] str,int L,int R)
    {
        if(str.length<1 || L>=R) return ;
        while(L<R)
        {
            char t=str[L];
            str[L]=str[R];
            str[R]=t;
            L+=1;
            R-=1;
        }
    }
}      

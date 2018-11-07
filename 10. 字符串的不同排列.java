10. 字符串的不同排列
给出一个字符串，找到它的所有排列，注意同一个字符串不要打印两次。

样例
给出 "abb"，返回 ["abb", "bab", "bba"]。

给出 "aabb"，返回 ["aabb", "abab", "baba", "bbaa", "abba", "baab"]。


class Solution {
public:
    /**
     * @param str: A string
     * @return: all permutations
     */
    vector<string> stringPermutation2(string &str) {
        // write your code here
        vector<string> res;
        if(str.size()<1)
        {
            res.push_back("");
            return res;
        }
        stringPermutation(str,0,res);
        return res;
    }
    
private:
    void stringPermutation(string& str,int index,vector<string>& res)
    {
        if(index>=str.size())
        {
            res.push_back(str);
            return;
        }
        unordered_set<char> S;
        for(int i=index;i<str.size();i++)
        {
            if(S.find(str[i])==S.end())
            {
                S.insert(str[i]);
                swap(str[i],str[index]);
                stringPermutation(str,index+1,res);
                swap(str[i],str[index]);
            }
        }
    }
};

////////////////////////////////////////////////////////


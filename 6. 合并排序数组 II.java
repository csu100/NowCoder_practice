6. 合并排序数组 II
合并两个排序的整数数组A和B变成一个新的数组。

样例
给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]

挑战
你能否优化你的算法，如果其中一个数组很大而另一个数组很小？



class Solution {
public:
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    vector<int> mergeSortedArray(vector<int> &A, vector<int> &B) {
        // write your code here
        if(A.size()<1) return B;
        if(B.size()<1) return A;
        int lenA=A.size();
        int lenB=B.size();
        vector<int> res(lenB+lenA,0);
        int ia=0;
        int ib=0;
        int index=0;
        while(ia<lenA && ib<lenB)
        {
            if(A[ia]<B[ib])
            {
                res[index++]=A[ia++];
            }else
            {
                res[index++]=B[ib++];
            }
        }
        while(ia<lenA)
        {
            res[index++]=A[ia++];
        }
        while(ib<lenB)
        {
            res[index++]=B[ib++];
        }
        return res;
    }
};

#########################################

public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if(A==null) return B;
        if(B==null) return A;
        int len=A.length+B.length;
        int[] res=new int[len];
        int index=0;
        int lenA=0,lenB=0;
        while(lenA<A.length && lenB<B.length)
        {
            if(A[lenA]<B[lenB])
            {
                res[index++]=A[lenA++];
            }else
            {
                res[index++]=B[lenB++];
            }
        }
        while(lenA<A.length)
        {
            res[index++]=A[lenA++];
        }
        while(lenB<B.length)
        {
            res[index++]=B[lenB++];
        }
        return res;
    }
}


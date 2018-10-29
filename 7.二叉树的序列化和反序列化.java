7. 二叉树的序列化和反序列化
设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。

如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。

样例
给出一个测试数据样例， 二叉树{3,9,20,#,#,15,7}，表示如下的树结构：

  3
 / \
9  20
  /  \
 15   7
我们的数据是进行BFS遍历得到的。当你测试结果wrong answer时，你可以作为输入调试你的代码。

你可以采用其他的方法进行序列化和反序列化。

注意事项
对二进制树进行反序列化或序列化的方式没有限制，LintCode将您的serialize输出作为deserialize的输入，它不会检查序列化的结果。

/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */


class Solution {
public:
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    string serialize(TreeNode * root) {
        // write your code here
        if(root==NULL) return "#!";
        string res=to_string(root->val)+'!';
        res+=serialize(root->left);
        res+=serialize(root->right);
        return res;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    TreeNode * deserialize(string &data) {
        // write your code here
        if(data.size()<1) return NULL;
        std::queue<string> Q;
        string word="";
        for(int i=0;i<data.size();i++)
        {
            if(data[i]=='!')
            {
                Q.push(word);
                word="";
            }else
            {
                word+=data[i];
            }
        }
        return deserialize(Q);
        
    }
    
private:
    TreeNode* deserialize(queue<string>& Q)
    {
        string tmp=Q.front();
        Q.pop();
        if(tmp=="#" || Q.empty())
        {
            return NULL;
        }
        TreeNode* res=new TreeNode(string_to_int(tmp));
        res->left=deserialize(Q);
        res->right=deserialize(Q);
        return res;
    }
    int string_to_int(string& data)
    {
        int res=0;
        for(int i=0;i<data.size();i++)
        {
            res=res*10+(data[i]-'0');
        }
        return res;
    }
};


############################################################


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root==null) return "#!";
        String res=String.valueOf(root.val)+'!';
        res+=serialize(root.left);
        res+=serialize(root.right);
        return res;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String word="";
        Queue<String> Q=new LinkedList<String>();
        char[] datas=data.toCharArray();
        for(int i=0;i<datas.length;i++)
        {
            if(datas[i]=='!')
            {
                Q.offer(word);
                word="";
            }else
            {
                word+=datas[i];
            }
        }
        return deserialize(Q);
        
    }
    
    public TreeNode deserialize(Queue<String> Q)
    {
        String tmp=Q.poll();
        if(tmp.equals("#"))
        {
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(tmp).intValue());
        root.left=deserialize(Q);
        root.right=deserialize(Q);
        return root;
        
         
    }
}

#################################################################

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

import queue

class Solution:
    """
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm 
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    """
    def serialize(self, root):
        # write your code here
        if root==None:
            return "#"
        res=[]
        res.append(str(root.val))
        res+=self.serialize(root.left)
        res+=self.serialize(root.right)
        return res

    """
    @param data: A string serialized by your serialize method.
    This method will be invoked second, the argument data is what exactly
    you serialized at method "serialize", that means the data is not given by
    system, it's given by your own serialize method. So the format of data is
    designed by yourself, and deserialize it here as you serialize it in 
    "serialize" method.
    """
    def deserialize(self, data):
        # write your code here
        def deseriA():
            tmp=next(data)
            if tmp=='#':
                return None 
            root=TreeNode(int(tmp))
            root.left=deseriA()
            root.right=deseriA()
            return root
        data=iter(data)
        return deseriA()

















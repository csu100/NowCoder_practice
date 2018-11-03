12. 带最小值操作的栈
实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。

你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

样例
如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1

注意事项
如果堆栈中没有数字则不能进行min方法的调用



class MinStack {
public:
    MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    void push(int number) {
        // write your code here
        data.push(number);
        if(minData.empty())
        {
            minData.push(number);
        }else
        {
            if(minData.top()>=number)
            {
                minData.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    int pop() {
        // write your code here
        if(data.empty())
        {
            throw "empty";
        }
        int tmp=data.top();
        data.pop();
        if(tmp==minData.top())
        {
            minData.pop();
        }
        return tmp;
    }

    /*
     * @return: An integer
     */
    int min() {
        // write your code here
        if(minData.empty())
        {
            throw "empty";
        }
        return minData.top();
    }
private:
    stack<int> data;
    stack<int> minData;
};

###################################################

class MinStack:
    
    def __init__(self):
        # do intialization if necessary
        self.__data=[]
        self.__minData=[]

    """
    @param: number: An integer
    @return: nothing
    """
    def push(self, number):
        # write your code here
        self.__data.append(number)
        if len(self.__minData)<1:
            self.__minData.append(number)
        else:
            if self.__minData[-1]>=number:
                self.__minData.append(number)
        

    """
    @return: An integer
    """
    def pop(self):
        # write your code here
        if len(self.__data)<1:
            return []
        tmp=self.__data.pop()
        if tmp==self.__minData[-1]:
            self.__minData.pop()
        return tmp

    """
    @return: An integer
    """
    def min(self):
        # write your code here
        if len(self.__minData)<1:
            return []
        return self.__minData[-1]

####################################################################

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minData;
    
    public MinStack() {
        // do intialization if necessary
        data=new Stack<Integer>();
        minData=new Stack<Integer>();
        
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        data.push(number);
        if(minData.isEmpty())
        {
            minData.push(number);
        }else
        {
            if(minData.peek()>=number)
            {
                minData.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(data.peek().equals(minData.peek()))
        {
            minData.pop();
        }
        return data.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minData.peek();
    }
}



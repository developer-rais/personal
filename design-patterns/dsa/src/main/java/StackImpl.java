import java.util.HashMap;
import java.util.Map;

public class StackImpl {
    public static void main(String[] args) throws Exception {

        MyStack myStack=new MyStack(10);
        myStack.push(1);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);

        myStack.inc(2,10);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();


    }
}

class MyStack implements StackFunctionality {

    Node top;
    int stackSize;
    int size;

    Map<Integer,MapNode>  stackMap;

    public MyStack(int stackSize) {
        this.stackSize = stackSize;
        this.size = 0;
        this.top = null;
        stackMap=new HashMap<>();
    }


    @Override
    public void push(int number) throws Exception {

        if (size == stackSize) {
            throw new Exception("overflow");
        }
        Node node = new Node(number);

        if (top == null) {
            top = node;
        } else {
            node.prev = top;
            top = node;
        }

        size++;
        // map part
        MapNode mapNode=new MapNode(0,node);
        stackMap.put(size,mapNode);


    }

    @Override
    public void pop() throws Exception {

        if(size==0)
        {
            throw  new Exception("underflow");
        }
        MapNode mapNode1=stackMap.get(size);
        stackMap.remove(size);
        System.out.println("value is "+(mapNode1.incrValue+mapNode1.number));


        top=top.prev;
        size--;
        MapNode mapNode2=stackMap.get(size);
        mapNode2.incrValue+=mapNode1.incrValue;
        stackMap.put(size,mapNode2);
    }

    @Override
    public void inc(int k, int val) {

        if(k>size)
        {
            k=size;
        }
        MapNode mapNode=stackMap.get(k);
        mapNode.incrValue+=val;


    }
}

interface StackFunctionality {
    void push(int number) throws Exception;

    void pop() throws Exception;

    void inc(int k, int val);
}

class Node {
    int number;
    Node prev;

    public Node() {

    }

    public Node(Node node) {
        this.number = node.number;
        this.prev = node.prev;
    }

    public Node(int number) {
        this.number = number;
    }
}

class MapNode extends Node {
    int incrValue;

    public MapNode(int incrValue, Node node) {
        super(node);
        this.incrValue = incrValue;
    }

}

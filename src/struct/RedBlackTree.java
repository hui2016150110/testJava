package struct;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        int key;//键
        String value;//值
        Node left,right;//左右子树
        int N = 0;//这个子树的节点总数
        boolean color;//由父节点指向它的链的颜色
        Node(int key,String value,int N,boolean color){
            this.key = key;
            this.color = color;
            this.N = N;
            this.value = value;
        }

    }

    private boolean isRed(Node x){
        if(x == null) return false;
        else return x.color==RED;
    }

    public Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+size(h.right)+size(h.left);
        return x;
    }

    public Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+size(h.right)+size(h.left);
        return x;
    }

    public void flipColors(Node h){
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private int size(Node x){
        if(x==null)
            return 0;
        return x.N;
    }

    public void put(int key,String value){
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node h,int key,String value){
        if(h==null)
            return new Node(key,value,1,RED);
        int cmp = key-h.key;
        if(cmp<0) h.left = put(h.left,key,value);
        else if(cmp>0) h.right = put(h.right,key,value);
        else h.value = value;

        if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left)&&h.left!=null&&isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right)) flipColors(h);

        h.N = size(h.left)+size(h.right)+1;
        return h;
    }
    public static void main(String[] args){
        RedBlackTree redBlackTree = new RedBlackTree();
        for(int i = 0;i<10;i++){
            redBlackTree.put(i,i+"");
        }
        System.out.println(redBlackTree.root.N+" "+redBlackTree.root.key);
        redBlackTree.pre();
    }

    public void pre(){
        pre(root);
    }

    public void pre(Node node){
        if(node.left!=null){
            pre(node.left);
        }
        System.out.println(node.key);
        if(node.right!=null){
            pre(node.right);
        }

    }

}

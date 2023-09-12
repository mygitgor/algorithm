package tree;

public class ReadBlackTree {
    private Node root;
    
    private class Node {
        private int value;
        private Color Color;
        private Node left;
        private Node right;

        @Override
        public String toString(){
            return "Node{" +
                "value=" + value + ", " +
                "Color=" + Color + ", " +  
            "}";
        }
    }

    public boolean add(int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.Color = Color.BLACK;
            return result;
        }else {
            root = new Node();
            root.Color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value){
        if (node.value == value){
            return false;
        }else {
            if (node.value > value){
                if (node.left != null){
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                }else {
                    node.left = new Node();
                    node.left.Color = Color.RED;
                    node.left.value = value;
                    return true;
                }    
            }else {
                if (node.right != null){
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                }else{
                    node.right = new Node();
                    node.right.Color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap(Node node){
        node.right.Color = Color.BLACK;
        node.left.Color = Color.BLACK;
        node.Color = Color.RED;
    }

    private Node leftSwap(Node node){
        Node left = node.left;
        Node betweenChaild = left.right;
        left.right = node;
        node.left = betweenChaild;
        left.Color = node.Color;
        node.Color = Color.RED;
        return left;
    }

    private Node rightSwap(Node node){
        Node right = node.right;
        Node betweenChaild = right.left;
        right.left = node;
        node.right = betweenChaild;
        right.Color = node.Color;
        node.Color = Color.RED;
        return right;
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if (result.right != null && result.right.Color == Color.RED &&
                (result.left == null || result.left.Color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.Color == Color.RED &&
                result.left.left != null && result.left.left.Color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.Color == Color.RED &&
                result.right != null && result.right.Color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }while (needRebalance);
        return result;  
    }

    
    private enum Color {
        RED, BLACK
    }
}

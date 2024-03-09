package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.LinkedList;
import java.util.Map;

public class MethodsTree<T> {
    LinkedList<TreeNode> nodes = new LinkedList<>();

    static TreeNode root = new TreeNode(
            new TreeNode(
                    new TreeNode(null ,1,null),
                    4,
                    null
            ),
            2,
            new TreeNode(
                    new TreeNode(null, 5, null),
                    3,
                    new TreeNode(null, 6, null)
            )
    );

    public static void main(String[] args) {
        MethodsTree MT = new MethodsTree();
        MT.findTrees();
        MT.findTreesD(root);
    }

    public void findTrees(){
        TreeNode current = root;
        TreeNode pop = null;
        while (!nodes.isEmpty() || current != null){
            if(current != null){
                nodes.push(current);
                System.out.println("前："+current.getVal());
                current = current.getLeft();
            } else {
                TreeNode peek = nodes.peek();
                if(peek.getRight() == null){
                    System.out.println("中："+peek.getVal());
                    pop = nodes.pop();
                    System.out.println("后："+pop.getVal());
                } else if (peek.getRight() == pop){
                    pop = nodes.pop();
                    System.out.println("后："+pop.getVal());
                } else {
                    System.out.println("中："+peek.getVal());
                    current = peek.getRight();
                }
            }

        }
    }

    public void findTreesD(TreeNode current){
        if(current == null){
            return;
        }
        findTreesD(current.getLeft());
        System.out.println(current.getVal());
        findTreesD(current.getRight());
    }

    public boolean checkBalance(TreeNode left, TreeNode right){
        if(left == null && right  == null){
            return true;
        }

        if(left == null || right  == null){
            return false;
        }

        if(left.getVal() != right.getVal()){
            return false;
        }
        return checkBalance(left.getLeft(), right.getRight()) && checkBalance(left.getRight(), right.getLeft());
    }

    public int MaxDeep(TreeNode node){
        if(node == null){
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null){
            return 1;
        }
        int dl = MaxDeep(node.getLeft());
        int dr = MaxDeep(node.getRight());
        return Integer.max(dl,dr);
    }

    public void findTreesBack(TreeNode root){
        TreeNode curr = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        while (curr != null || !stack.isEmpty()){
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if(size > max){
                   max = size;
                }
                curr = curr.getLeft();
            } else {
                TreeNode peek = stack.peek();
                if(peek.getRight() == null || peek.getRight() == pop){
                    pop = stack.pop();
                } else {
                    curr = peek.getRight();
                }
            }
        }
    }

    TreeNodeSearch<String> roots;

    public void put(int key, T value){
        TreeNodeSearch node = roots;
        TreeNodeSearch parent = null;
        while(node != null){
            if(key < node.key){
                node = node.left;
            } else if (node.key < key){
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }
        if(parent == null){
            roots = new TreeNodeSearch(key, value);
            return;
        }

        if(key < parent.key){
            parent.left = new TreeNodeSearch(key,value);
        } else if (key > parent.key) {
            parent.right = new TreeNodeSearch(key,value);
        }

    }


    public void dingTing(int[][] ints, Map<String,String> map, String begin, String end){


    }






}

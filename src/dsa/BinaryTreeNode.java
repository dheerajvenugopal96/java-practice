package dsa.src.dsa;

import java.util.*;

public class BinaryTreeNode{

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data,BinaryTreeNode left, BinaryTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        BinaryTreeNode leftChild = new BinaryTreeNode(2,null,null);
        BinaryTreeNode rightChild = new BinaryTreeNode(3,null,null);
        BinaryTreeNode root = new BinaryTreeNode(1,leftChild,rightChild);

        performPreorder(root);
        performInorder(root);
        performPostOrder(root);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(BinaryTreeNode node) {
        List<Integer> list = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp!=null){
                list.add(tmp.data);
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
        }
        System.out.println("Level Order tree is : "+list);
    }

    private static void performPostOrder(BinaryTreeNode node) {

        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode prev = null;
        s.push(node);
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null){
                    s.push(curr.left);
                }else if(curr.right!=null){
                    s.push(curr.right);
                }
            }else if(curr.left == prev){
                if(curr.right!=null){
                    s.push(curr.right);
                }
            }else{
                list.add(curr.data);
                s.pop();
            }
            prev = curr;
        }

        System.out.println("Postorder tree is : "+list);
    }

    private static void performInorder(BinaryTreeNode node) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        boolean done = false;
        while(!done){
            if(node!=null){
                s.push(node);
                node = node.left;
            }else{
                if(s.isEmpty()){
                    done = true;
                }else{
                    BinaryTreeNode tmp = s.pop();
                    list.add(tmp.data);
                    node = tmp.right;
                }
            }
        }
        System.out.println("Inorder tree is : "+list);
    }

    public static void performPreorder(BinaryTreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> s  = new Stack<>();
        s.push(node);
        while(!s.isEmpty()){
            BinaryTreeNode tmp = s.pop();
            list.add(tmp.data);
            if(tmp.right!=null){
                s.push(tmp.right);
            }
            if(tmp.left!=null){
                s.push(tmp.left);
            }
        }

        System.out.println("Preorder tree is : "+list);
    }
}
package com.ddogring;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test002
 * @Author DdogRing
 * @Date 2021/5/10 0010 上午 9:15
 * @Description 难度中等 叶子相似的树    (中序遍历 递归思想， 如果这个节点没有左节点和右节点， 那么它就是一个叶子结点)
 * @Version 1.0.0
 */
public class Test002 {
    public static void main(String[] args) {


    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> integers1 = new ArrayList<>();
        List<Integer> integers2 = new ArrayList<>();

        List<Integer> mid1 = mid(root1, integers1);
        List<Integer> mid2 = mid(root2, integers2);

        return mid1.equals(mid2);
    }

    public static List<Integer> mid(TreeNode treeNode, List<Integer> treeNodes) {

        if (treeNode == null) {
            return treeNodes;
        }
        if (treeNode.left == null && treeNode.right == null) {
            treeNodes.add(treeNode.val);
        }
        mid(treeNode.left, treeNodes);
        mid(treeNode.right, treeNodes);

        return treeNodes;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
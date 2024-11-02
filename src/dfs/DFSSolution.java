package dfs;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DFSSolution {

    List<Integer> rets=new ArrayList<>();


    /*
     * 题目：94 二叉树的中序遍历
     *
     * link：https://leetcode.cn/problems/binary-tree-inorder-traversal/
     * */
    public List<Integer> inorderTraversal(TreeNode root) {

        dfs(root);
        return rets;
    }


    /*
     * 题目：98 验证二叉搜索树
     *
     * link：https://leetcode.cn/problems/validate-binary-search-tree/
     * */
    private void dfs(TreeNode root) {
        if (root==null) {
            return;
        }

        dfs(root.left);
        rets.add(root.val);
        dfs(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isListSorted(rets);
    }
    public static boolean isListSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false; // 如果前一个元素大于后一个元素，则不是升序
            }
        }
        return true; // 如果没有发现逆序，则是升序
    }
}

package bfs;

import entity.TreeNode;

import java.util.*;

public class BFSSolution {

    int[][] prefix = {
            {0,1},
            {0,-1},
            {-1,0},
            {1,0}
    };

    /*
    * 题目：腐烂橘子
    *
    * link：https://leetcode.cn/problems/rotting-oranges/
    * */

    public int orangesRotting(int[][] grid) {

        if (status(grid)==1){
            return -1;
        }

        int ins=0;
        boolean updated=false;
        while (status(grid)!=2){
            boolean[][] visited=new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!visited[i][j]&&grid[i][j]==2) {
                        for (int k = 0; k < 4; k++) {
                            int newi=i+prefix[k][1];
                            int newj=j+prefix[k][0];

                            if (newi < 0 || newi >= grid.length || newj < 0 || newj >= grid[0].length) {
                                continue;
                            }
                            if (!visited[newi][newj]&&grid[newi][newj]==1) {
                                visited[newi][newj]=true;
                                grid[newi][newj]=2;
                                updated=true;
                            }
                        }
                    }
                }
            }
            if (updated) ins++;else return -1;
        }
        return ins;
    }

    private int status(int[][] grid) {
        return (int) Arrays.stream(grid).flatMapToInt(Arrays::stream).distinct().sum();
    }

    /*
     * 题目：100 相同的树
     *
     * link：https://leetcode.cn/problems/symmetric-tree/
     * */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p, q);
    }

    /*
     * 题目：101 对称二叉树
     *
     * link：https://leetcode.cn/problems/symmetric-tree/
     * */
    private static boolean isSameNode(TreeNode p, TreeNode q) {
        if (p ==null&& q ==null) {
            return true;
        }
        if (p ==null|| q ==null) {
            return false;
        }

        return p.val==q.val&&isSameNode(p.left,q.left)&&isSameNode(p.right,q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return isSameNode(root.left,root.right);
    }

    /*
     * 题目：102 二叉树的层序遍历
     *
     * link：https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
     * */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /*
     * 题目：103 二叉树的锯齿形层序遍历
     *
     * link：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root!=null) {
            queue.add(root);
        }
        int deep=0;
        while (!queue.isEmpty()) {
            List<Integer> path=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (deep%2==1) {
                    path.addFirst(node.val);
                }else path.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(path);
            deep++;
        }
        return res;
    }

    /*
     * 题目：104 二叉树的最大深度
     *
     * link：https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     * */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();

        int max=0;
        if (root==null) {
            return max;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left!=null) {
                    queue.add(curr.left);
                }
                if (curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            max++;
        }
        return max;
    }

    /*
     * 题目：107 二叉树的层序遍历2
     *
     * link：https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root!=null) {
            queue.add(root);
        }
        int deep=0;
        while (!queue.isEmpty()) {
            List<Integer> path=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                path.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.addFirst(path);
        }
        return res;
    }

    /*
     * 题目：111 二叉树的最小深度
     *
     * link：https://leetcode.cn/problems/minimum-depth-of-binary-tree/
     * */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null) {
            return 0;
        }
        int deep=0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left==null&&curr.right==null) {
                    return deep+1;
                }
                if (curr.left!=null) {
                    queue.add(curr.left);
                }
                if (curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            deep++;
        }
        return deep;
    }

}

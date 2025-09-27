import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BacktrackingSolution {
    /*
     * 题目：22. Generate Parentheses
     *
     * link：https://leetcode.cn/problems/generate-parentheses/?envType=company&envId=ibm&favoriteSlug=ibm-all
     *
     * 枚举超时
     * */
    List<Character> path=new ArrayList<>();

    List<String> ret=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
        dfs(0, 0, n, path, ans); // 一开始没有填括号
        return ans;
    }

    // 目前填了 left 个左括号，right 个右括号
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if (right == n) { // 填完 2n 个括号
            ans.add(new String(path));
            return;
        }
        if (left < n) { // 可以填左括号
            path[left + right] = '('; // 直接覆盖
            dfs(left + 1, right, n, path, ans);
        }
        if (right < left) { // 可以填右括号
            path[left + right] = ')'; // 直接覆盖
            dfs(left, right + 1, n, path, ans);
        }
    }

}

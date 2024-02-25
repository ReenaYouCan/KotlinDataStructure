package trees.nodes


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var height: Int = 0
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
//    private val memo: MutableMap<Int, List<TreeNode>> = HashMap()
//    fun allPossibleFBT(n: Int): List<TreeNode> {
//        if (n % 2 == 0) {
//            return ArrayList()
//        }
//        if (n == 1) {
//            return Arrays.asList(TreeNode(0))
//        }
//        if (memo.containsKey(n)) {
//            return memo[n]!!
//        }
//        val res: MutableList<TreeNode> = ArrayList()
//        var i = 1
//        while (i < n) {
//            val left = allPossibleFBT(i)
//            val right = allPossibleFBT(n - i - 1)
//            for (l in left) {
//                for (r in right) {
//                    val root = TreeNode(0, l, r)
//                    res.add(root)
//                }
//            }
//            i += 2
//        }
//        memo[n] = res
//        return res
//    }
}
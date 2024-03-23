package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/


private fun sumNumbers(root: TreeNode?): Int {
    root ?: return 0
    return preOrderSum(root, 0)
}

fun preOrderSum(root: TreeNode?, sum: Int): Int {
    root ?: return 0
    val ans = sum * 10 + root.`val`
    return if (root.left == null && root.right == null) {
        ans
    } else {
        // send the multiplier to the next node
        // For eg: if this node is 4 and the next node (left or right) is 8,
        // 8 would get 40 and add it's own 8 i.e. 40 + 8
        preOrderSum(root.left, ans) + preOrderSum(root.right, ans)
    }
}
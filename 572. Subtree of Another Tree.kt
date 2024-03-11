package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/subtree-of-another-tree/description/
private fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null) return false

    return if (isSameTree(root, subRoot)) {
        true
    } else {
        isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    return if (p?.`val` == q?.`val`) {
        isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    } else {
        false
    }
}
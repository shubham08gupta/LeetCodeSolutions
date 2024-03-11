package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/same-tree/description/

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true

    return p?.`val` == q?.`val` &&
            isSameTree(p?.left, q?.left) &&
            isSameTree(p?.right, q?.right)
}
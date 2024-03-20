package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/diameter-of-binary-tree/

// use a variable to store the max diameter
private var max = 0
private fun diameterOfBinaryTree(root: TreeNode?): Int {
    maxDepth(root)
    return max
}

/**
 * returns the depth of a tree
 */
private fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    max = maxOf(max, left + right)
    return maxOf(left, right) + 1
}
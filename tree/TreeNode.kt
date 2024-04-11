package com.example.myapplication.leetcode.tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createSampleTree(): TreeNode {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    return root
}

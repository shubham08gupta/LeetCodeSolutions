package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null
    p ?: return null
    q ?: return null

    return if (root.`val` > p.`val` && root.`val` > q.`val`) {
        // both p and q on left side
        lowestCommonAncestor(root.left, p, q)
    } else if (root.`val` < p.`val` && root.`val` < q.`val`) {
        // both p and q on right side
        lowestCommonAncestor(root.right, p, q)
    } else {
        root
    }
}
package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    return build(preorder, 0, preorder.lastIndex, inorder, 0, inorder.lastIndex)
}

private fun build(
    preorder: IntArray,
    preStart: Int,
    preEnd: Int,
    inorder: IntArray,
    inStart: Int,
    inEnd: Int
): TreeNode? {
    if (preStart > preEnd || inStart > inEnd) return null

    // find preorder item in inorder array
    var rootIndex = 0
    for (index in inStart..inEnd) {
        if (preorder[preStart] == inorder[index]) {
            rootIndex = index
        }
    }
    // create a node for the found value
    val node = TreeNode(inorder[rootIndex])
    // number of elements must be same in both arrays then only tree construction is possible. Consider
    // preorder = [10,20,40,50,30,60]
    // inorder =  [40,20,50,10,60,30]
    // for element 10 -> 40,20,50 (3 elements) must be on the left side of 10. So we must consider
    // 3 elements from the preorder as well
    val numElements = preStart - inStart + rootIndex
    // build the left and right subtree of this node
    node.left = build(preorder, preStart + 1, numElements, inorder, inStart, rootIndex - 1)
    node.right = build(preorder, numElements + 1, preEnd, inorder, rootIndex + 1, inEnd)
    return node
}

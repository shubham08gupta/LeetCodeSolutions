package com.example.myapplication.leetcode.tree

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// T.C. O(n)
// S.C. O(n)

fun levelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    val result = mutableListOf<MutableList<Int>>()

    fun bfs() {
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            val sublist = mutableListOf<Int>()
            repeat(size) {
                val node = queue.removeFirst()
                sublist.add(node.`val`)

                if (node.left != null) {
                    queue.addLast(root.left!!)
                }

                if (node.right != null) {
                    queue.addLast(root.right!!)
                }
            }
            result.add(sublist)
        }
    }

    fun dfs(root: TreeNode?, level: Int) {
        root ?: return

        if (level == result.size) {
            val sub = mutableListOf<Int>()
            sub.add(root.`val`)
            result.add(sub)
        } else {
            result[level].add(root.`val`)
        }

        dfs(root.left, level + 1)
        dfs(root.right, level + 1)
    }

    dfs(root, 0)

    return result
}

fun main() {
    println(levelOrder(createSampleTree()))
}
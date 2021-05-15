package com.ltt.jsp.leecode

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by liutiantian on 2021-03-15 22:43 星期一
 */
class LeeCodeTests {
    // https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
    @Test
    fun test_findMedianSortedArrays() {
        var nums1 = intArrayOf(1, 3)
        var nums2 = intArrayOf(2)
        Assert.assertEquals(2.0, findMedianSortedArrays(nums1, nums2))

        nums1 = intArrayOf(1, 2)
        nums2 = intArrayOf(3, 4)
        Assert.assertEquals(2.5, findMedianSortedArrays(nums1, nums2))

        nums1 = intArrayOf(0, 0)
        nums2 = intArrayOf(0, 0)
        Assert.assertEquals(0.0, findMedianSortedArrays(nums1, nums2))

        nums1 = intArrayOf()
        nums2 = intArrayOf(1)
        Assert.assertEquals(1.0, findMedianSortedArrays(nums1, nums2))

        nums1 = intArrayOf(2)
        nums2 = intArrayOf()
        Assert.assertEquals(2.0, findMedianSortedArrays(nums1, nums2))
    }

    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return 0.0
    }

    // https://leetcode-cn.com/problems/find-majority-element-lcci/
    @Test
    fun majorityElement() {
        var nums = arrayOf(
            intArrayOf(1,2,5,9,5,9,5,5,5)
        )
        Assert.assertEquals(5, majorityElement(nums[0]))
    }

    private fun majorityElement(nums: IntArray): Int {
        val res = mutableListOf<Int>()
        for (element in nums) {
            if (res.size == 0) {
                res.add(element)
                continue
            }
            if (res.last() != element) {
                res.removeAt(res.size - 1)
                continue
            }
            res.add(element)
        }
        if (res.size == 0) {
            return -1
        }
        val num = res.first()
        var count = 0
        for (element in nums) {
            if (num == element) {
                count++
            }
        }
        if (count > nums.size / 2) {
            return num
        }
        return -1
    }

    // https://leetcode-cn.com/problems/smallest-range-i/
    @Test
    fun test_smallestRangeI() {
        var A = intArrayOf(1)
        var K = 0
        Assert.assertEquals(0, smallestRangeI(A, K))

        A = intArrayOf(0, 10)
        K = 2
        Assert.assertEquals(6, smallestRangeI(A, K))

        A = intArrayOf(1, 3, 6)
        K = 3
        Assert.assertEquals(0, smallestRangeI(A, K))
    }

    private fun smallestRangeI(A: IntArray, K: Int): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/smallest-range-ii/
    @Test
    fun test_smallestRangeII() {
        var A = intArrayOf(1)
        var K = 0
        Assert.assertEquals(0, smallestRangeII(A, K))

        A = intArrayOf(0, 10)
        K = 2
        Assert.assertEquals(6, smallestRangeII(A, K))

        A = intArrayOf(1, 3, 6)
        K = 3
        Assert.assertEquals(3, smallestRangeII(A, K))
    }

    private fun smallestRangeII(A: IntArray, K: Int): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/smallest-difference-lcci/
    @Test
    fun test_smallestDifference() {
        var a = intArrayOf(1, 3, 15, 11, 2)
        var b = intArrayOf(23, 127, 235, 19, 8)
        Assert.assertEquals(3, smallestDifference(a, b))

        a = intArrayOf(-2147483648,1)
        b = intArrayOf(2147483647,0)
        Assert.assertEquals(1, smallestDifference(a, b))
    }

    private fun smallestDifference(a: IntArray, b: IntArray): Int {
        var min = Int.MAX_VALUE.toLong()
        for (m in a.indices) {
            for (n in b.indices) {
                val difference = if (a[m] > b[n]) (a[m] - b[n].toLong()) else (b[n] - a[m].toLong())
                if (difference < min) {
                    min = difference
                }
            }
        }
        return min.toInt()
    }

    // https://leetcode-cn.com/problems/next-greater-element-iii/
    @Test
    fun test_nextGreaterElement() {
        var n = 12
        Assert.assertEquals(21, nextGreaterElement(n))

        n = 21
        Assert.assertEquals(-1, nextGreaterElement(n))

        n = 789342
        Assert.assertEquals(789423, nextGreaterElement(n))

        n = 34372
        Assert.assertEquals(34723, nextGreaterElement(n))

        n = 230241
        Assert.assertEquals(230412, nextGreaterElement(n))

        n = 2147483486
        Assert.assertEquals(-1, nextGreaterElement(n))

        n = 2147483476
        Assert.assertEquals(2147483647, nextGreaterElement(n))
    }

    private fun nextGreaterElement(n: Int): Int {
        var _n = n
        val ret = mutableListOf<Int>()
        while (_n > 0) {
            val m = _n % 10
            for (p in ret.indices) {
                if (m < ret[p]) {
                    val tmp = ret[p]
                    ret[p] = m
                    for (j in 1 until ret.size) {
                        val k = ret[j]
                        var i = j - 1
                        while (i >= 0 && ret[i] < k) {
                            ret[i + 1] = ret[i]
                            i--
                        }
                        ret[i + 1] = k
                    }
                    ret.add(tmp)
                    var a: Long = _n / 10L
                    for (x in ret.size downTo 1) {
                        a = a * 10 + ret[x - 1]
                    }
                    return if (a <= Int.MAX_VALUE) {
                        a.toInt()
                    } else {
                        -1
                    }
                }
            }
            ret.add(m)
            _n /= 10
        }
        return -1
    }

    // https://leetcode-cn.com/problems/symmetric-tree/
    @Test
    fun test_isSymmetric() {
        var list = listOf<Int?>(1, 2, 2, 3, 4, 4, 3)
        var node = createTreeNode(list, 0)
        Assert.assertTrue(isSymmetric(node))

        list = listOf(1, 2, 2, null, 3, null, 3)
        node = createTreeNode(list, 0)
        Assert.assertFalse(isSymmetric(node))
    }

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun createTreeNode(list: List<Int?>, index: Int): TreeNode? {
        val value = list.getOrNull(index) ?: return null
        val node = TreeNode(value)
        node.left = createTreeNode(list, index * 2 + 1)
        node.right = createTreeNode(list, index * 2 + 2)
        return node
    }

    private fun isSymmetric(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            if (queue.size == 1) {
                val node = queue.pollFirst()
                queue.addFirst(node?.left)
                queue.addLast(node?.right)
            } else {
                val first = queue.pollFirst()
                val last = queue.pollLast()
                if (first?.value != last?.value) {
                    return false
                }
                if (first != null) {
                    queue.addFirst(first.right)
                    queue.addFirst(first.left)
                    queue.addLast(last?.left)
                    queue.addLast(last?.right)
                }
            }
        }
        return true
    }

    // https://leetcode-cn.com/problems/sum-of-square-numbers/
    @Test
    fun test_judgeSquareSum() {
        var c = 5
        Assert.assertTrue(judgeSquareSum(c))
        c = 3
        Assert.assertFalse(judgeSquareSum(c))
        c = 4
        Assert.assertTrue(judgeSquareSum(c))
        c = 2
        Assert.assertTrue(judgeSquareSum(c))
        c = 1
        Assert.assertTrue(judgeSquareSum(c))
        c = Int.MAX_VALUE
        Assert.assertFalse(judgeSquareSum(c))
    }

    private fun judgeSquareSum(c: Int): Boolean {
        var a = 0
        var a2 = 0
        val list = mutableListOf<Int>()
        while (a2 in 0..c) {
            list.add(a2)
            val ret = c - a2
            var i = 0
            var j = list.size - 1
            while (i + 1 < j) {
                if (list[i] == ret) {
                    return true
                }
                val mid = (i + j) / 2
                if (ret < list[mid]) {
                    j = mid
                } else {
                    i = mid
                }
            }
            if (list[i] == ret) {
                return true
            }
            if (list[j] == ret) {
                return true
            }
            a++
            a2 = a * a
        }
        return false
    }

    // https://leetcode-cn.com/problems/delete-and-earn/
    @Test
    fun test_deleteAndEarn() {
        var nums = intArrayOf(3, 4, 2)
        Assert.assertEquals(6, deleteAndEarn(nums))

        nums = intArrayOf(2, 2, 3, 3, 3, 4)
        Assert.assertEquals(9, deleteAndEarn(nums))
    }

    private fun deleteAndEarn(nums: IntArray): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/minimum-path-sum/
    @Test
    fun test_minPathSum() {
        var grid = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
        )
        Assert.assertEquals(7, minPathSum(grid))

        grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        Assert.assertEquals(12, minPathSum(grid))
    }

    private fun minPathSum(grid: Array<IntArray>): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/combination-sum-ii/
    @Test
    fun test_combinationSum2() {
        var candidates = intArrayOf(10, 1, 2, 7, 6, 1, 5)
        var target = 8
        Assert.assertEquals(
            listOf(
                listOf(1, 7),
                listOf(1, 2, 5),
                listOf(2, 6),
                listOf(1, 1, 6)
            ),
            combinationSum2(candidates, target)
        )

        candidates = intArrayOf(2, 5, 2, 1, 2)
        target = 5
        Assert.assertEquals(
            listOf(
                listOf(1, 2, 2),
                listOf(5)
            ),
            combinationSum2(candidates, target)
        )
    }

    private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        return listOf()
    }

    // https://leetcode-cn.com/problems/add-two-numbers/
    @Test
    fun test_addTwoNumbers() {
        var l1 = createListNode(intArrayOf(2, 4, 3))
        var l2 = createListNode(intArrayOf(5, 6, 4))
        Assert.assertEquals(createListNode(intArrayOf(7, 0, 8)), addTwoNumbers(l1, l2))

        l1 = createListNode(intArrayOf(0))
        l2 = createListNode(intArrayOf(0))
        Assert.assertEquals(createListNode(intArrayOf(0)), addTwoNumbers(l1, l2))

        l1 = createListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
        l2 = createListNode(intArrayOf(9, 9, 9, 9))
        Assert.assertEquals(createListNode(intArrayOf(8, 9, 9, 9, 0, 0, 0, 1)), addTwoNumbers(l1, l2))
    }

    private class ListNode(var value: Int) {
        var next: ListNode? = null

        override fun hashCode(): Int {
            return Objects.hash(value)
        }

        override fun equals(other: Any?): Boolean {
            return super.equals(other) || (value == (other as? ListNode)?.value && next == (other as? ListNode)?.next)
        }
    }

    private fun createListNode(array: IntArray): ListNode? {
        var ret: ListNode? = null
        array.reversedArray().forEach {
            val node = ListNode(it)
            node.next = ret
            ret = node
        }
        return ret as? ListNode
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return null
    }

    // https://leetcode-cn.com/problems/search-a-2d-matrix/
    @Test
    fun test_searchMatrix() {
        var matrix = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60)
        )
        var target = 3
        Assert.assertTrue(searchMatrix(matrix, target))

        matrix = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60)
        )
        target = 13
        Assert.assertFalse(searchMatrix(matrix, target))
    }

    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        var i = 0
        var j = rowCount * columnCount - 1
        while (i + 1 < j) {
            if (matrix[i / columnCount][i % columnCount] == target) {
                return true
            }
            val mid = (i + j) / 2
            if (target < matrix[mid / columnCount][mid % columnCount]) {
                j = mid
            } else {
                i = mid
            }
        }
        if (target == matrix[i / columnCount][i % columnCount]) {
            return true
        } else if (target == matrix[j / columnCount][j % columnCount]) {
            return true
        }
        return false
    }

    // https://leetcode-cn.com/problems/xor-operation-in-an-array/
    @Test
    fun test_xorOperation() {
        Assert.assertEquals(8, xorOperation(5, 0))
        Assert.assertEquals(8, xorOperation(4, 3))
        Assert.assertEquals(7, xorOperation(1, 7))
        Assert.assertEquals(2, xorOperation(10, 5))
    }

    private fun xorOperation(n: Int, start: Int): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
    @Test
    fun test_removeNthFromEnd() {
        Assert.assertEquals(
            createListNode(intArrayOf(1, 2, 3, 5)),
            removeNthFromEnd(
                createListNode(intArrayOf(1, 2, 3, 4, 5)),
                2
            )
        )
        Assert.assertEquals(
            createListNode(intArrayOf()),
            removeNthFromEnd(
                createListNode(intArrayOf(1)),
                1
            )
        )
        Assert.assertEquals(
            createListNode(intArrayOf(1)),
            removeNthFromEnd(
                createListNode(intArrayOf(1, 2)),
                1
            )
        )
        Assert.assertEquals(
            createListNode(intArrayOf(2)),
            removeNthFromEnd(
                createListNode(intArrayOf(1, 2)),
                2
            )
        )
    }

    private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var parent: ListNode? = null
        var node = head
        var position = 1
        while (true) {
            if (position > n) {
                parent = if (parent == null) head else parent.next
            }
            node = node?.next
            if (node == null) {
                break
            }
            position++
        }
        if (parent == null) {
            return head?.next
        }
        parent.next = parent.next?.next
        return head
    }

    // https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
    @Test
    fun test_minDays() {
        Assert.assertEquals(
            3,
            minDays(
                intArrayOf(1, 10, 3, 10, 2),
                3,
                1
            )
        )

        Assert.assertEquals(
            -1,
            minDays(
                intArrayOf(1, 10, 3, 10, 2),
                3,
                2
            )
        )

        Assert.assertEquals(
            3,
            minDays(
                intArrayOf(7, 7, 7, 7, 12, 7, 7),
                2,
                3
            )
        )

        Assert.assertEquals(
            1000000000,
            minDays(
                intArrayOf(1000000000, 1000000000),
                1,
                1
            )
        )

        Assert.assertEquals(
            9,
            minDays(
                intArrayOf(1, 10, 2, 9, 3, 8, 4, 7, 5, 6),
                4,
                2
            )
        )
    }

    private fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        return 0
    }

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    // 简单
    // status: pass
    @Test
    fun test_removeDuplicates() {
        var nums = intArrayOf(1, 1, 2)
        Assert.assertEquals(
            2,
            removeDuplicates(nums)
        )
        Assert.assertArrayEquals(intArrayOf(1, 2), nums.copyOfRange(0, 2))

        nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        Assert.assertEquals(
            5,
            removeDuplicates(nums)
        )
        Assert.assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), nums.copyOfRange(0, 5))
        nums = intArrayOf()
        Assert.assertEquals(
            0,
            removeDuplicates(nums)
        )
        Assert.assertArrayEquals(intArrayOf(), nums.copyOfRange(0, 0))
        nums = intArrayOf(1, 1)
        Assert.assertEquals(
            1,
            removeDuplicates(nums)
        )
        Assert.assertArrayEquals(intArrayOf(1), nums.copyOfRange(0, 1))
    }

    private fun removeDuplicates(nums: IntArray): Int {
        var len = nums.size
        var n = 1
        while (true) {
            if (n >= len) {
                break
            }
            if (nums[n] == nums[n - 1]) {
                for (m in n until len) {
                    nums[m - 1] = nums[m]
                }
                nums[len - 1] = nums[n - 1]
                len--
                continue
            }
            n++
        }
        return len
    }

    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    // 中等
    // status: pass
    @Test
    fun test_levelOrder() {
        Assert.assertEquals(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7)
            ),
            levelOrder(createTreeNode(listOf(3, 9, 20, null, null, 15, 7), 0))
        )
    }

    private fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.addLast(root ?: return listOf())
        while (true) {
            ret.add(queue.map { it.value })
            val size = queue.size
            var n = 0
            while (true) {
                val node = queue.poll()
                if (node != null) {
                    node.left?.let {
                        queue.addLast(it)
                    }
                    node.right?.let {
                        queue.addLast(it)
                    }
                }
                n++
                if (n >= size) {
                    break
                }
            }
            if (queue.isEmpty()) {
                break
            }
        }
        return ret
    }

    // 二叉树的锯齿形层序遍历
    // https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
    // 中等
    // status: pass
    @Test
    fun test_zigzagLevelOrder() {
        Assert.assertEquals(
            listOf(
                listOf(3),
                listOf(20, 9),
                listOf(15, 7)
            ),
            zigzagLevelOrder(createTreeNode(listOf(3, 9, 20, null, null, 15, 7), 0))
        )
        Assert.assertEquals(
            listOf(
                listOf(1),
                listOf(3, 2),
                listOf(4, 5)
            ),
            zigzagLevelOrder(createTreeNode(listOf(1, 2, 3, 4, null, null, 5), 0))
        )
    }

    private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        var forward = true
        queue.addLast(root ?: return listOf())
        while (true) {
            val list = mutableListOf<Int>()
            val size = queue.size
            var n = 0
            while (true) {
                if (n >= size) {
                    break
                }
                if (forward) {
                    val last = queue.pollFirst()
                    last?.let {
                        list.add(it.value)
                    }
                    last?.left?.let {
                        queue.addLast(it)
                    }
                    last?.right?.let {
                        queue.addLast(it)
                    }
                } else {
                    val first = queue.pollLast()
                    first?.let {
                        list.add(it.value)
                    }
                    first?.right?.let {
                        queue.addFirst(it)
                    }
                    first?.left?.let {
                        queue.addFirst(it)
                    }
                }
                n++
            }
            ret.add(list)
            forward = !forward
            if (queue.isEmpty()) {
                break
            }
        }
        return ret
    }

    // 二叉树的层序遍历 II
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
    // 中等
    // status: pass
    @Test
    fun test_levelOrderBottom() {
        Assert.assertEquals(
            listOf(
                listOf(15, 7),
                listOf(9, 20),
                listOf(3),
            ),
            levelOrderBottom(createTreeNode(listOf(3, 9, 20, null, null, 15, 7), 0))
        )
    }

    private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.addLast(root ?: return listOf())
        while (true) {
            ret.add(0, queue.map { it.value })

            val size = queue.size
            var n = 0
            while (true) {
                if (n >= size) {
                    break
                }
                val first = queue.pollFirst()
                first.left?.let { queue.addLast(it) }
                first.right?.let { queue.addLast(it) }
                n++
            }
            if (queue.isEmpty()) {
                break
            }
        }
        return ret
    }

    // 二叉树的最小深度
    // https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
    // 简单
    // status: pass
    @Test
    fun test_minDepth() {
        Assert.assertEquals(
            2,
            minDepth(createTreeNode(listOf(3, 9, 20, null, null, 15, 7), 0))
        )
        Assert.assertEquals(
            5,
            minDepth(createTreeNode(listOf(2, null, 3, null, 4, null, 5, null, 6), 0))
        )
    }

    private fun minDepth(root: TreeNode?): Int {
        var ret = 0
        val queue = LinkedList<TreeNode>()
        queue.addLast(root ?: return 0)
        while (true) {
            ret++
            val size = queue.size
            var n = 0
            while (true) {
                if (n >= size) {
                    break
                }
                val first = queue.pollFirst()
                if (first.left == null && first.right == null) {
                    return ret
                }
                first.left?.let { queue.addLast(it) }
                first.right?.let { queue.addLast(it)}
                n++
            }
            if (queue.isEmpty()) {
                break
            }
        }
        return ret
    }

    // 填充每个节点的下一个右侧节点指针
    // https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
    // 中等
    // status: pass
    @Test
    fun test_connect() {
        Assert.assertEquals(
            createNode(listOf(1, 2, 3, 4, 5, 6, 7), 0, true),
            connect(createNode(listOf(1, 2, 3, 4, 5, 6, 7), 0, false))
        )
    }

    private fun connect(root: Node?): Node? {
        val queue = LinkedList<Node>()
        queue.addFirst(root ?: return null)
        while (true) {
            val size = queue.size
            var n = 0
            while (true) {
                if (n >= size) {
                    break
                }
                val node = queue.pollLast()
                node.right?.let {
                    if (n != 0) {
                        it.next = queue.peekFirst()
                    }
                    queue.addFirst(it)
                }
                node.left?.let {
                    it.next = queue.peekFirst()
                    queue.addFirst(it)
                }
                n++
            }
            if (queue.isEmpty()) {
                break
            }
        }
        return root
    }

    private fun createNode(list: List<Int>, index: Int, connect: Boolean = false): Node? {
        val value = list.getOrNull(index) ?: return null
        val node = Node(value)
        node.left = createNode(list, index * 2 + 1)
        node.right = createNode(list, index * 2 + 2)
        val nodes = list.map {
            Node(it)
        }
        nodes.forEachIndexed { position, item ->
            if ((position and (position - 1)) != 0) {
                item.next = nodes.getOrNull(position + 1)
            }
        }
        return node
    }

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null

        override fun hashCode(): Int {
            return Objects.hash(`val`, left, right, next)
        }

        override fun equals(other: Any?): Boolean {
            return super.equals(other) || (other is Node && `val` == other.`val` && left == other.left && right == other.right && next == other.next)
        }
    }

    // 被围绕的区域
    // https://leetcode-cn.com/problems/surrounded-regions/
    // 中等
    // status: record
    @Test
    fun test_solve() {
        Assert.assertEquals(
            arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'O', 'O', 'X'),
                charArrayOf('X', 'X', 'O', 'X'),
                charArrayOf('X', 'O', 'X', 'X')
            ),
            solve(arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'O', 'X', 'X')
            ))
        )

        Assert.assertEquals(
            arrayOf(
                charArrayOf('X'),
            ),
            solve(arrayOf(
                charArrayOf('X'),
            ))
        )
    }

    private fun solve(board: Array<CharArray>): Unit {

    }

    // 岛屿数量
    // https://leetcode-cn.com/problems/number-of-islands/
    // 中等
    // status: record
    @Test
    fun test_numIslands() {
        Assert.assertEquals(
            1,
            numIslands(arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            ))
        )

        Assert.assertEquals(
            3,
            numIslands(arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            ))
        )
    }

    private fun numIslands(grid: Array<CharArray>): Int {
        return 0
    }

    // 课程表
    // https://leetcode-cn.com/problems/course-schedule/
    // 中等
    // status: record
    @Test
    fun test_canFinish() {
        Assert.assertTrue(
            canFinish(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                )
            )
        )
        Assert.assertFalse(
            canFinish(
                2,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                )
            )
        )
    }

    private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        return false
    }

    // 最小高度树
    // https://leetcode-cn.com/problems/minimum-height-trees/
    // 中等
    // status: record
    @Test
    fun test_findMinHeightTrees() {
        Assert.assertEquals(
            listOf(1),
            findMinHeightTrees(4, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(1, 3)
            ))
        )
        Assert.assertEquals(
            listOf(3, 4),
            findMinHeightTrees(6, arrayOf(
                intArrayOf(3, 0),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 4)
            ))
        )
        Assert.assertEquals(
            listOf(0),
            findMinHeightTrees(1, arrayOf(
                intArrayOf()
            ))
        )
        Assert.assertEquals(
            listOf(0, 1),
            findMinHeightTrees(2, arrayOf(
                intArrayOf(0, 1)
            ))
        )
    }

    private fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        return listOf()
    }
}
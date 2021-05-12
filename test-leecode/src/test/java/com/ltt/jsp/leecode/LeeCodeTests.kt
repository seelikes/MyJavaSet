package com.ltt.jsp.leecode

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.time.ExperimentalTime

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
        var node = createNode(list, 0)
        Assert.assertTrue(isSymmetric(node))

        list = listOf(1, 2, 2, null, 3, null, 3)
        node = createNode(list, 0)
        Assert.assertFalse(isSymmetric(node))
    }

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun createNode(list: List<Int?>, index: Int): TreeNode? {
        val value = list.getOrNull(index) ?: return null
        val node = TreeNode(value)
        node.left = createNode(list, index * 2 + 1)
        node.right = createNode(list, index * 2 + 2)
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
    // status: unit test
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
    }

    private fun removeDuplicates(nums: IntArray): Int {
        var len = nums.size
        var n = 1
        while (true) {
            when {
                nums[n] == nums[n - 1] -> {
                    len--
                    for (m in n until nums.size) {
                        nums[m - 1] = nums[m]
                    }
                    nums[nums.size - 1] = nums[n - 1]
                    continue
                }
                nums[n] < nums[n - 1] -> {
                    break
                }
            }
            n++
            if (n >= nums.size) {
                break
            }
        }
        return len
    }
}
package com.ltt.jsp.leecode

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.time.ExperimentalTime

/**
 * Created by liutiantian on 2021-03-15 22:43 星期一
 */
class LeeCodeTests {
    @Test
    fun medianOfTwoSortedArrays() {

    }

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

    // https://leetcode-cn.com/problems/smallest-range-i/
    private fun smallestRangeI(A: IntArray, K: Int): Int {
        return 0
    }

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

    // https://leetcode-cn.com/problems/smallest-range-ii/
    private fun smallestRangeII(A: IntArray, K: Int): Int {
        return 0
    }

    @Test
    fun test_smallestDifference() {
        var a = intArrayOf(1, 3, 15, 11, 2)
        var b = intArrayOf(23, 127, 235, 19, 8)
        Assert.assertEquals(3, smallestDifference(a, b))

        a = intArrayOf(-2147483648,1)
        b = intArrayOf(2147483647,0)
        Assert.assertEquals(1, smallestDifference(a, b))
    }

    // https://leetcode-cn.com/problems/smallest-difference-lcci/
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
}
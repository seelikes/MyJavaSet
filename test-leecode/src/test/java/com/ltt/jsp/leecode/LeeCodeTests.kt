package com.ltt.jsp.leecode

import org.junit.Assert
import org.junit.Test
import kotlin.math.abs

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
}
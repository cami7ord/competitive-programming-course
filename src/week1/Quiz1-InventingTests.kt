/*

Steps in Solving a Problem:

1. Read the statement.
2. Formalize it.
3. Invent a solution.
4. Test it
5. Implement it
6. Test the implementation
7. Debug it
8. Submit

Quiz 1:

In this quiz, we aren't asking you to solve problems. Instead, you are given some problems and their
incorrect solutions, and your task is to find tests where these solutions actually work incorrectly
— by returning incorrect answer, working for too long, crashing, taking too much memory —
anything that would give a verdict other than "Accepted". Consider that the time limit is 2 seconds,
and the memory limit is 256 megabytes for all of the following problems.

This exercise will help you imagine tests for your own code.

Implement a function called getTest. It should return a list on which the solve function works incorrectly.
Note that the returned list must fit the restrictions in the statement.

1. You are given a non-empty list of integers, and you need to find the maximum value among them.
The length of the list is not greater than 100, and the absolute value of each element is not greater than 1000.

*/

fun solve1(array: IntArray) : Int {
    var max = 0
    array.forEach {
        if (it > max)
            max = it
    }
    return max
}

/*

solve returned 0, while the correct answer is -1
Good job!

 */

fun getTest1(): IntArray {
    //return intArrayOf(1,2,3)
    return intArrayOf(-1)
}

/*

2. You are given a non-empty list of integers. Find the maximum possible value which could be obtained as the sum
of no more than two elements from the list. You can't take the same element twice, but you could take two distinct
elements which are equal by value. The length of the list is not greater than 100, each element is positive and
not greater than 1000.

 */

fun solve2(array: IntArray) : Int {
    var max = 0
    val len = array.size - 1
    for (i in 0..len) {
        for (j in 0..len) {
            if (i != j && array[i] + array[j] > max) {
                max = array[i] + array[j]
            }
        }
    }
    return max
}

/*
solve returned 0, while the correct answer is 1000
Good job!
 */

fun getTest2(): IntArray {
    //return intArrayOf(1,2,3)
    return intArrayOf(1000)
}

/*

3. Given an integer N, find how many pairs of distinct integers from 0 to N - 1 sum up to an even value. (1, 2)
and (2, 1) are the same pair. N is positive, and doesn't exceed 100000.

 */

fun solve3(n: Int) : Int {
    var ans = 0
    for (i in 0..n) {
        for (j in 0..n) {
            if (i < j && (i + j) % 2 == 0) {
                ans += 1
            }
        }
    }
    return ans
}

/*
solve worked for more than 2 seconds
Good job!
 */

fun getTest3(): Int {
    //return 3
    return 100000
}

/*

4. You are given a string of lowercase English letters. First, remove all occurrences of its first letter,
e.g. "abacaba" -> "bcb". Then, return the longest prefix of the remaining string which doesn't contain two
different letters. The initial string is at least 5 and no more than 100000 characters long.

 */

fun solve4(s: String) : String {
    var ss = s
    val toDelete = ss[0]
    var others = ""
    ss.forEach {c ->
        if (c != toDelete) {
            others += c
        }
    }
    ss = others
    //prefix of length 1 surely doesn't contain different letters
    var prefix = ss.substring(0,1)
    for (i in 1..ss.length) {
        // each letter should be the same as the first
        if (ss[i] == prefix[0]) {
            prefix += ss[i]
        } else {
            break
        }
    }
    return prefix
}

/*
solve crashed with a runtime error
Good job!
 */

fun getTest4(): String {
    //return "abcde"
    return "aaaaa"
}

fun main() {
    println(solve4(getTest4()))
}

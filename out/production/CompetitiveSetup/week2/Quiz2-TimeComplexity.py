package week2

n = int(input())
m = int(input())
k = int(input())

correctTriples = 0
for i in range(n):
    for j in range(m):
        for g in range(k):
            if (i + j + g) % 3 == 0:
                correctTriples += 1

print(correctTriples)

# 1. Choose the best possible bound on the running time of the code above

"""
O(n^2mk)
O(n)
O(nm2^k)
O(nmk) [X]
O(nm)

Correct! The code inside the loops clearly does O(1) operations, and each of the nested loops multiplies the
number by its range. Everything else — reading and printing the answer — is done in O(1) time. """

# 2. We could imagine several versions of the problem which the solution above solves — depending on actual bounds
# on the variables and the time limit, this solution may pass or not. Check those versions where the solution from
# the previous question is likely to pass.

"""
n = 2000, m = 20, k = 500, time limit = 10 seconds [X]

Correct
In total, the program does about 2000 x 20 x 500 = 20_000_000 times some small constant operations, and even taking 10^7
operations per second for Python, 10 seconds is sufficiently large time.

n = 2000, m = 1000, k = 1000, time limit = 0.5 seconds

n = 1000000, m = 100, k = 100, time limit = 2 seconds

n = m = k = 100, time limit = 2 seconds [X]

Correct
In total, the program does about 100 x 100 x 100 = 1_000_000 times some small constant operations,
which is surely fine for 2 seconds. """

# 3. Below you see a function, which calculates a certain value from an array. Could you make it faster so it still
# returns the same value? Assume that the array has no more than 100_000 elements.

def calculate(a):
  result = 0

  for x in a:
    sum = 0
    for y in a:
      sum += y
    result += sum * x

  return result

""" Correct """

def calculate(a):
  result = 0
  sum = 0

  for x in a:
    sum += x
  result = sum * sum

  return result


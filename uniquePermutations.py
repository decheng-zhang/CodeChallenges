from collections import defaultdict
class Solution(object):
    def __init__(self):
        self.result = []
        self.d = defaultdict(int)
        

        
    def swap(self, input, ind_a, ind_b):
        temp = input[ind_a]
        input[ind_a] = input[ind_b]
        input[ind_b] = temp

    def permutation(self, input, index):
        if (index >= len(input)):
            res = []
            for i in input:
                res.append(i)
            if (self.d[tuple(res)] == 0):
                self.result.append(res)
                self.d[tuple(res)]=1

        else:
            for i in range(index, len(input)):
                self.swap(input, index, i)
                if (self.d[tuple(input)]==1):
                    self.swap(input, index, i)
                    continue # SMART
                self.permutation(input, index + 1)
                self.swap(input, index, i)

    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.permutation(nums, 0)
        return self.result

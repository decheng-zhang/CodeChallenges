from collections import defaultdict
class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        counter = defaultdict(int)
        for c in s:
            counter[c]=counter[c]+1
        len_str = len(s)
        are_even=0
        for c in counter.keys():
            if (counter[c]%2==0):
                are_even+=1
        if (are_even>=len(counter.keys())-1):
            return True
        else:
            return False
        

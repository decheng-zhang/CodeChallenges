from collections import defaultdict
class Solution(object):
    def __init__(self):
        self.oddBall=None
        self.num=0
    def chosenChars(self, s):
        cas = []
        are_even = 0
        counter = defaultdict(int)
        for c in s:
            counter[c] = counter[c] + 1
        for char in counter.keys():
            if (counter[char] % 2 == 0):
                are_even += 1
                for i in range(0,counter[char]/2):
                    cas.append(char)
            else:
                self.num+=1
                self.oddBall=char
                for i in range(0,counter[char]/2):
                    cas.append(char)
        if (self.num >1):
            return []
        else:
            return cas

    def swap(self,inlist,ind_a,ind_b):
        char = inlist[ind_a]
        inlist[ind_a]=inlist[ind_b]
        inlist[ind_b] = char

    def permutation(self,out_list,in_list,index):
        if (index==len(in_list)-1):
            string=""
            for char in in_list:
                string+=char
            out_list.append(string)
            return
        else:
            for i in range(index,len(in_list)):
                self.swap(in_list,index,i)
                self.permutation(out_list,in_list,index+1)
                self.swap(in_list, index, i)

    def generatePalindromes(self,string):
        """
                :type s: str
                :rtype: List[str]
        """
        if (len(string)==1):
            return [string]
        cas = self.chosenChars(string)
        if (cas==[]):
            []
        out_list = []
        self.permutation(out_list, cas, 0)
        result = []
        for string in out_list:
            temp = string
            temp_rev = string[::-1]
            if self.oddBall == None:
                result.append(temp + temp_rev)
            else:
                result.append(temp +self.oddBall+temp_rev)
        return list(set(result))

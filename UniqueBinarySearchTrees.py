from collections import defaultdict
class Solution(object):
    def __init__(self):
        self.d = defaultdict(int)
        self.calls=0
        self.hits=0
    def utility(self,L):
        self.calls+=1
        if (self.d[tuple(L)]):
            self.hits+=1
            return self.d[tuple(L)]
        if (len(L)==1 or len(L)==0):
            self.d[tuple(L)]=1
            return 1
        else:
            sum=0
            for i in range(0,len(L)):
                sum+=self.utility(L[:i])*self.utility(L[i+1:])
            self.d[tuple(L)]=sum
            return sum
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        L = []
        for i in range(1,n+1):
            L.append(i)
        return self.utility(L)

if __name__=="__main__":
    s = Solution()
    print s.numTrees(19)
    print "method calls->"+str(s.calls)
    print "cache_hits->"+str(s.hits)

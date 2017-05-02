class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        comb=[]
        comb.append(1)
        for i in range(0,amount):
            comb.append(0)
        for coin in coins:
            for value in range(1,amount+1):
                    if (coin<=value):
                        comb[value]+=comb[value-coin]
            #print comb
        return comb[amount]

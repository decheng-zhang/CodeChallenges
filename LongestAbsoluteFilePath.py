class Solution(object):
    def lengthLongestPath(self, input):
        tabcount = 0;
        d = {}
        char_count = 0
        maxval = 0
        d[-1]=0
        isFile = False
        
        for i in input:
        	
        	if (i=='\n'):
        		if (not isFile):
        			d[tabcount] = d[tabcount-1]+char_count
        		if (d[tabcount-1]+char_count+tabcount>maxval and isFile):
        			maxval = d[tabcount-1]+char_count+tabcount
        		tabcount=0
        		char_count = 0
        		isFile=False
        
        	elif (i=='\t'):
        		tabcount+=1
        	elif (i == '.'):
        		isFile=True
        		char_count+=1
        	else:
        		char_count+=1
        if (not isFile):
        	d[tabcount] = d[tabcount-1]+char_count
        if (d[tabcount-1]+char_count+tabcount>maxval and isFile):
        			maxval = d[tabcount-1]+char_count+tabcount
        return maxval
    

public String longestPalindrome(String s)
	{
		int lenString = s.length();
		if (lenString == 1)
			return s;
		int Maxlen = 1;
		int MaxStart = 0;
		int len = 1;
		int startIndex=0;
		for (int i=1;i<lenString;i++)
		{
			int low = i-1;
			int high = i;
			while (low >=0 && high <lenString && s.charAt(low)==s.charAt(high))
			{
				len = high - low +1;
				startIndex = low;
				if (len > Maxlen)
					{
						Maxlen = len;
						MaxStart = startIndex;
					}
				low--;
				high++;
				
			}
		
		
			low = i-1;
			high = i+1;
			while (low >=0 && high < lenString && s.charAt(low)==s.charAt(high))
			{
				len = high - low +1;
				startIndex = low;
				if (len > Maxlen)
					{
						Maxlen = len;
						MaxStart = startIndex;
					}
				low--;
				high++;	
			}
		}
				
		
		return s.substring(MaxStart,MaxStart+Maxlen);
	}

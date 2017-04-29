#! /usr/bin/python
class Solution(object):

	def __init__(self):
		self.list_num=[]
		self.list_str=[]
		
	def decodeString(self,s):
		self.input=s
		str_cmp=""
		num_cmp=""
		for c in self.input:
			if c.isdigit():
				if str_cmp!="":
					self.list_str.append(str_cmp)
					print ("pushed "+str_cmp)
					str_cmp=""
				num_cmp+=c
			elif c == '[':
				self.list_str.append(c)
				print ("pushed "+c)
				if (num_cmp!=""):
					self.list_num.append(int(num_cmp))
					print ("pushed "+num_cmp)
					num_cmp=""
			elif c == ']':
				if (str_cmp!=""):
					self.list_str.append(str_cmp)
					print("pushed "+str_cmp)
					str_cmp=""
				prefix_str=""
				while (len(self.list_str)!=0 and self.list_str[-1]!='['):
					str_ = self.list_str.pop()
					print("popped "+str_)
					prefix_str=str_+prefix_str
				self.list_str.pop() # take out opening bracket
				print ("popped "+"[")

				num=self.list_num.pop()
				print ("popped "+str(num))
				sub_str=""
				for i in range(0,num):
					sub_str+=prefix_str
				
				self.list_str.append(sub_str)
				print ("pushed "+ sub_str)
			else:
				str_cmp+=c
				if (num_cmp!=""):
					self.list_num.append(int(num_cmp))
					print ("pushed "+num_cmp)
					num_cmp=""
		ans = ""
		print (len(self.list_str))
		while (len(self.list_str)!=0):
			ans = self.list_str.pop()+ans
		ans=ans+str_cmp
		print ("here "+ans)
		
		return ans


if __name__ == "__main__":
	s = Solution()
	s.decodeString("sd2[f2[e]g]i")


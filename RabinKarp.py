#! /usr/bin/python



R = 256
prime = 100003

def hash(string_item,len_):
	H = 0
	for i in xrange(0,len_):
		H = (R*H + ord(string_item[i]))%prime
	return H
	


def RM(len_):
	rm = 1
	for i in range(1,len_):
		rm = rm*R
	return rm
	
	

def find_pattern(input_string, pattern):
	m = len(pattern)
	pat_hash = hash(pattern,m)
	curr_hash = hash(input_string,m)
	rm = RM(m)
	if (curr_hash == pat_hash):
		print ("match found")
		return
	for i in range(m,len(input_string)):
		curr_hash = (curr_hash + prime - (rm * ord(input_string[i-m]))%prime)%prime
		curr_hash = (curr_hash*R+ord(input_string[i]))%prime
		if (curr_hash == pat_hash):
			print ("match found")
			return
	print ("match not found")
			


input_string = "my name is saumitra"
pattern = "my"

find_pattern(input_string,pattern)

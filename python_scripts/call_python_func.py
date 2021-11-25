def cpp_call_python(inputs):
    print(inputs)
    return 1

def add(args):
	# print(args)
	sum = 0
	for num in args:
		sum += num
	return sum
import sys


def test_for_sys(year, month, day):
	inputs = "Today is {0}-{1}-{2}".format(year,month,day)
	print(inputs)


if __name__ == '__main__':
    try:
        year, month, day = sys.argv[1:4]
        test_for_sys(year, month, day)
    except Exception as e:
        print(sys.argv)
        print(e)
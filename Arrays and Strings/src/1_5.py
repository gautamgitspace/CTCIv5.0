#runtime for this is O(p + k^2) where p is the size of the original string and k is the number of character sequences.
#where in 'hello', there are 4 character sequences. This approach is slow.
input = raw_input('Enter String: ')
count = 1
resultantStr = str()
length = len(input)
comparator = input[0]
lst = list()
for alphabet in input:
    lst.append(alphabet)
for item in lst[1:length+1]:
    if item == comparator:
        count=count+1
    else:
        resultantStr = resultantStr + comparator + str(count)
        comparator=item
        count=1
print resultantStr+comparator+str(count)

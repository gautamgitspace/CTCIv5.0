input = raw_input('Enter String: ')
count = 1
resultantStr = str()
finalStr = str()
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
finalStr = resultantStr+comparator+str(count)
if len(finalStr) >= length:
    print input
else:
    print finalStr

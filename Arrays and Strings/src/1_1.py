#1 when additional data structure is allowed:
str = raw_input('Enter the string to test: ')
if len(str) == len(set(str)):
    print 'string has unique characters'
else:
    print 'string has repeating characters'

#2 when additional data structure is not allowed:
str = raw_input('Enter the string to test: ')
result = bool()
for alphabet in str:
    if str.count(alphabet) > 1:
        result = False
        break
    else:
        result = True
print result
#3 another approach - using strings
str = raw_input('Enter a string to test: ')
count = 0
result = True
for alphabet in str:
    count = 0
    for alphabet2 in str:
        if alphabet==alphabet2:
            count = count+1
            if count > 1:
                result = False
print result
#4 yet another approach using lists:
str = raw_input('Enter a string to test ')
lst = list()
result = True
for alphabet in str:
    if alphabet in lst:
        result = False
    else:
        lst.append(alphabet)
if result:
    print 'Unique'
else:
    print 'Duplicates'

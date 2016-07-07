# # when additional data structure is allowed:
str = raw_input('Enter the string to test: ')
if len(str) == len(set(str)):
    print 'string has unique characters'
else:
    print 'string has repeating characters'

# when additional data structure is not allowed:
str = raw_input('Enter the string to test: ')
result = bool()
for alphabet in str:
    if str.count(alphabet) > 1:
        result = False
        break
    else:
        result = True
print result

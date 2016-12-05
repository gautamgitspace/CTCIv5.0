def isSubstring(s1, s2):
    if s1.find(s2) > -1:
        return True
def checkRotation(s1, s2):
    if len(s1)!=len(s2):
        return False
    bigString = s1+s1
    return isSubstring(bigString, s2)

s1 = raw_input('Enter parent string: ')
s2 = raw_input('Enter child string: ')
if checkRotation(s1,s2):
    print 'pass'
else:
    print 'failed'

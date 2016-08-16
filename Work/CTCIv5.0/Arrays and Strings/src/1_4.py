input = raw_input('Enter String with spaces: ')
lst = list()
for alphabet in input:
    if alphabet == ' ':
        alphabet = '%20'
    lst.append(alphabet)
print ''.join(lst)

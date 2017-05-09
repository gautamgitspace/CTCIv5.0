def reverse_string_recursive(str1):
    if str1 != "":
        return str1[-1:] + reverse_string_recursive(str1[:-1])
    else:
        return ""

palindrome = "nomon"
nonpalindrome = "noman"

if palindrome == reverse_string_recursive(palindrome):
    print "Test 1 passed"
if nonpalindrome == reverse_string_recursive(nonpalindrome):
    print "Test 2 passed"

//
//  main.cpp
//  CTCI1_3
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
using namespace std;

bool permutation(const string& a, const string& b)
{

    string str_a(a);
    string str_b(b);
    
    /*IF LENGTH NOT SAME RETURN FALSE*/
    if(str_a.length() != str_b.length())
    {
        return false;
    }
    
    sort(str_a.begin(), str_a.end());
    sort(str_b.begin(), str_b.end());
    
    for (int i = 0; i < str_a.length(); i++)
    {
        if(str_a[i] != str_b[i])
        {
            return false;
        }
    }
    
    return true;
}


int main(int argc, const char * argv[])
{
    string str1 = "abcd";
    string str2 = "davc";
    cout<<"IS PERMUTATION?: "<<permutation(str1, str2)<<endl;
    return 0;
}

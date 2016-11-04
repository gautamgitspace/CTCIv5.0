//
//  main.cpp
//  CTCI1_8
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
using namespace std;

bool isRotation(const string& s1, const string& s2)
{
    long len = s1.length();
    
    if(len == s2.length() && len > 0)
    {
        string s1s1 = s1 + s1;
        return s1s1.find(s2) != string::npos;
    }
    
    return false;
}

int main(int argc, const char * argv[])
{
    string str1 = "waterbottle";
    string str2 = "bottlewaterr";
    cout<<"IS ROTATION?: "<<isRotation(str1, str2)<<endl;
    return 0;
}

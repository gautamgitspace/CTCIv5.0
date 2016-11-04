//
//  main.cpp
//  CTCI1_1
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>

using namespace std;

bool uniqueChecker(string str)
{
    bool asci[256] = {false};
    for(int i=0; i<str.length(); i++)
    {
        int val = str[i];
        if(asci[val])
            return false;
        else asci[val] = true;
    }
    return true;
}

int main(int argc, const char * argv[])
{
    string str = "abcdc";
    cout<<"IS UNIQUE?: "<<uniqueChecker(str)<<endl;
    return 0;
}

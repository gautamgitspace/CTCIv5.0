//
//  main.cpp
//  CTCI1_5
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
#include <sstream>

using namespace std;

string intToString(int value)
{
    string temp;
    stringstream convert;
    convert << value;
    temp = convert.str();
    
    return temp;
}


int countCompression(const string& str)
{
    if (str.length() == 0)
    {
        return 0;
    }
    
    char last = str.at(0);
    int size = 0;
    int count = 1;
    /*START FROM 1st and compare with last (AT 0, if match then increment count)*/
    for (int i = 1; i < str.length(); i++)
    {
        if (str.at(i) == last)
        {
            count++;
        }
        else
        {
            /*UPDATE LAST*/
            last = str.at(i);
            /*ADD TO SIZE*/
            size = size + 1 + intToString(count).length();
            /*RESET COUNT*/
            count = 1;
        }
    }
    /*FOR THE LAST CASE*/
    size = size + 1 + intToString(count).length();
    
    return size;
}

string compressBetter(const string& str)
{
    int size = countCompression(str);
    
    if(size >= str.length())
    {
        return str;
    }
    
    string newstr;
    char last = str.at(0);
    int count = 1;
    
    for (int i = 1; i < str.length(); i++)
    {
        if (str.at(i) == last)
        {
            count++;
        }
        else
        {
            /*ADD LAST TO STRING*/
            newstr += last;
            /*APPEND COUNT TO STRING*/
            newstr.append(intToString(count));
            /*UPDATE LAST*/
            last = str.at(i);
            /*RESET COUNT*/
            count = 1;
        }
    }
    /*FOR THE LAST CASE*/
    newstr += last;
    newstr.append(intToString(count));
    
    return newstr;
}

int main(int argc, const char * argv[])
{
    string str = "abde";
    string newstr = compressBetter(str);
    cout << "Original string is " << str << endl;
    cout << "Compressed string is " << newstr << endl;

    return 0;
}

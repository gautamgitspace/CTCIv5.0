//
//  main.cpp
//  CTCI1_4
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
#include <string.h>
#include <stdlib.h>

using namespace std;

void replace(char *a)
{
    int length, i,j;
    char *back;
    for(i=0;;i++)
    {
        if(a[i] == '\0')
            break;
    }
    length = i+1;
    back = (char*)malloc(length*sizeof(char));
    /*COPY EVERYTHING TO BACKUP*/
    for(i=0; i<length; i++)
        back[i] = a[i];

    for(i=0, j=0; j<length-1; i++)
    {
        /*ASCII FOR SPACE = 32*/
        if((int)back[i] != 32)
            a[j] = back[i];
        else
        {
            a[j] = '%';
            a[j+1] = '2';
            a[j+2] = '0';
            j += 2;
        }
        
        j++;
    }
    
    free(back);
}

int main(int argc, const char * argv[])
{
    char snippet[18] = "Mr John Smith    ";
    replace(snippet);
    if(strcmp(snippet, "Mr%20John%20Smith")==0)
        cout<<"PASSED"<<endl;
    else
        cout<<"FAILED"<<endl;
    return 0;
}

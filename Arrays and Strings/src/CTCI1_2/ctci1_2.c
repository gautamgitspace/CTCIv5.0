//  ctci1_2.c
//  CTCI1_2 - Implement a function void reverse(char *str) that reverses a null terminated string
//  Created by Gautam on 7/6/16.
//  Copyright © 2016 Gautam. All rights reserved.

#include "ctci1_2.h"
#include <stdlib.h>
#include <stdio.h>

void reverse(char *str)
{
    
    if(str == NULL)
        return ;
    
    int length, i;
    char * rev;
    
    for(i=0;;i++)
    {
        if(str[i] == '\0')
            break;
    }
    length = i;
    //printf("LENGTH OF THE STRING: %d\n", length);
    
    if(length > 0)
    {
        rev = malloc(length * sizeof(char));
        
        for(i=0; i<length; i++)
        {
            rev[length-1-i] = str[i];
        }
        printf("TESTING IF REVERSE HAPPENED: %s\n", rev);
        
        for(i=0; i<length; i++)
        {
            str[i] = rev[i];
        }
        
        free(rev);
    }
    
}



int main()
{
    char str[20] = "abcdfg";
    char str_backup[20] = "abcdfg";
    char * null = NULL;
    
    printf("Before REVERSING: %s\n", str);
    reverse(str);
    printf ("After REVERSING: %s\n",str);
    
}

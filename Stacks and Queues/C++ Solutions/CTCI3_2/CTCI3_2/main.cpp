//
//  main.cpp
//  CTCI3_2
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// MIN OF STACK IN O(1)

#include <iostream>
#include <stack>

using namespace std;


class stackWithMin
{
private:
    stack<int> s1, s2;
    
public:
    void push(int x)
    {
        /*IRRESPECTIVE OF ANYTHING PUSH in S1*/
        s1.push(x);
        /*COMPARE WITH MIN STACK(S2) IF NEW INT LESS THAN STACK TOP*/
        if(min()>=x)
        {
            s2.push(x);
        }
    }
    void pop()
    {
        /*IF THAT VALUE (s1 TOP) LIES IN MIN STACK (S2) POP IT FROM THERE TOO*/
        if(min()==s1.top())
        {
            s2.pop();
        }
        //*POP EVERYTHING FROM S1 IRRESPECTIVE OF ANYTHING*//
        s1.pop();
    }
    int min()
    {
        if(s2.empty())
        {
            return INT_MAX;
        }
        return s2.top();
    }
    bool empty(){
        return s1.empty();
    }
    int top(){
        return s1.top();
    }
};

int main(){
    stackWithMin myStack;
    int arr[] = {6, 3, 5, 2, 2, 9, 2, 8, 1, 1};
    for(int i=0; i<10; i++)
    {
        myStack.push(arr[i]);
        cout<<arr[i]<<" "<<myStack.min()<<'\n';
    }
    cout<<endl;;
    myStack.pop();
    myStack.pop();
    myStack.pop();
    cout<<"MIN IS: "<<myStack.min()<<'\n';
    return 0;
}

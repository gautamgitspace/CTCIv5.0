//
//  main.cpp
//  CTCI3_6
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//  SORT A STACK in ASC order (BIG ITEMS ON THE TOP) using an additional stack. O(n^2)

#include <iostream>
#include <stack>

using namespace std;

class SortStack
{
private:
    stack<int> alreadySorted;
    
public:
    void sortStack(stack<int> *toBeSorted)
    {
        while(!(*toBeSorted).empty())
        {
            int temp = (*toBeSorted).top();
            (*toBeSorted).pop();
            while(!alreadySorted.empty() && alreadySorted.top() < temp)
            {
                (*toBeSorted).push(alreadySorted.top());
                alreadySorted.pop();
            }
            alreadySorted.push(temp);
        }
        while(!alreadySorted.empty())
        {
            (*toBeSorted).push(alreadySorted.top());
            alreadySorted.pop();
        }
    }
};
int main(int argc, const char * argv[])
{
    SortStack sortstack = *new SortStack();
    stack<int> mystack;
    mystack.push(10);
    mystack.push(2);
    mystack.push(5);
    mystack.push(15);
    mystack.push(20);
    
    sortstack.sortStack(&mystack);
    
    cout<<"TOP PEEK: "<<mystack.top()<<endl;
    mystack.pop();
    cout<<"TOP PEEK NEXT: "<<mystack.top()<<endl;
    mystack.pop();
    cout<<"TOP PEEK NEXT: "<<mystack.top()<<endl;
    return 0;
}

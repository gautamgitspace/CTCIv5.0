//
//  main.cpp
//  CTCI3_5
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// QUEUE USING TWO STACKS

#include <iostream>
#include <stack>

using namespace std;
class MyQueue
{
public:
    stack<int> inbox;
    stack<int> outbox;
public:
    void enqueue(int value)
    {
        inbox.push(value);
    }
    
    int dequeue()
    {
        int served;
        if(outbox.empty())
        {
            while(!inbox.empty())
            {
                outbox.push(inbox.top());
                inbox.pop();
            }
        
            served = outbox.top();
            outbox.pop();
        }
        return served;
    }
};

int main()
{
    MyQueue myqueue = *new MyQueue();
    myqueue.enqueue(10);
    myqueue.enqueue(20);
    myqueue.enqueue(30);
    myqueue.enqueue(40);
    myqueue.enqueue(50);

    
    cout<<"NOW SERVING: "<<myqueue.dequeue()<<endl;
    cout<<"NEXT IN LINE: "<<myqueue.outbox.top()<<endl;
    
    return 0;
}

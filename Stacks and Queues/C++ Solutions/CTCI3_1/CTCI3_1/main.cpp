//
//  main.cpp
//  CTCI3_1
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include<iostream>
using namespace std;


class ArrayStack
{
private:
    int sizeOfStack = 100;
    int buffer[300];
    int stackPointer[3];

public:
    ArrayStack()
    {
        stackPointer[0] = -1;
        stackPointer[1] = -1;
        stackPointer[2] = -1;
    }

/*Takes two args - Stack Number to which to push and the value itself to be pushed*/
void push(int stackNumber, int value)
{
    //TODO check if we have space to push?
    isFull(stackNumber);
    //TODO increment stack pointer and push
    stackPointer[stackNumber]++;
    buffer[whereInBuffer(stackNumber)]=value;
}
int pop(int stackNumber)
{
    //TODO check if stack is empty?
    if(isEmpty(stackNumber))
        cout<<"EMPTY STACK"<<endl;
    //TODO fetch value and return it, reset index and decrement pointer
    int value = buffer[whereInBuffer(stackNumber)];
    buffer[whereInBuffer(stackNumber)]=0;
    stackPointer[stackNumber]--;
    return value;
}
int peek(int stackNumber)
{
    if(isEmpty(stackNumber))
        cout<<"EMPTY STACK"<<endl;
    return buffer[whereInBuffer(stackNumber)];
}
bool isEmpty(int stackNumber)
{
    //TODO check if stack is empty
    return stackPointer[stackNumber] == -1;
}
void isFull(int stackNumber)
{
    if (stackPointer[stackNumber] + 1 > sizeOfStack)
        {
            cout<<"STACK FULL"<<endl;
        }
}
int whereInBuffer(int stackNumber)
{
    return stackNumber * sizeOfStack + stackPointer[stackNumber];
}
};

int main()
{
    ArrayStack arraystack = *new ArrayStack();
    arraystack.push(0, 10);
    arraystack.push(0, 20);
    arraystack.push(1, 10);
    arraystack.push(1, 20);
    arraystack.push(2, 10);
    arraystack.push(2, 20);
    
    cout<<"PEEK STACK 0: "<<arraystack.peek(0)<<endl;
    cout<<"PEEK STACK 1: "<<arraystack.peek(1)<<endl;
    cout<<"PEEK STACK 2: "<<arraystack.peek(2)<<endl;
    
    cout<<"POPPING CHERRY @ STACK 0:"<<endl;
    arraystack.pop(0);
    cout<<"PEEK STACK 0: "<<arraystack.peek(0)<<endl;
}

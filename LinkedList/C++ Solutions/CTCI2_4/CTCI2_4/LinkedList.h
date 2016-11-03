//
//  LinkedList.h
//  CTCI2_4
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#ifndef LinkedList_h
#define LinkedList_h


struct Node
{
    int data;
    Node* next;
    // bool visited;
};

class LinkedList
{
public:
    Node* head;
    LinkedList();
    ~LinkedList();
    void display();
    void insert(int value);
    void createCycle();
    int ktoLast(Node* head, int k);
    Node* partition(Node* head, int val);
private:
    // added this so insertion is O(1) time
    Node* tail;
};


#endif /* LinkedList_h */

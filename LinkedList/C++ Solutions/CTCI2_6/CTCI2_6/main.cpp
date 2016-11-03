//
//  main.cpp
//  CTCI2_6
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// DETECT A LOOP USING SLOW PTR FAST PTR APPROACH
#include <iostream>
#include "LinkedList.h"

using namespace std;

LinkedList::LinkedList()
{
    this->head = nullptr;
}


void LinkedList::insert(int value)
{
    if (head == NULL)
    {
        head = new Node();
        tail = head;
        head->next = nullptr;
        head->data = value;
    }
    else
    {
        tail->next = new Node();
        tail = tail->next;
        tail->data = value;
        tail->next = nullptr;
    }
}


void LinkedList::display()
{
    Node* temp;
    
    if (head == NULL)
    {
        return;
    }
    
    temp = head;
    
    while (temp != NULL)
    {
        std::cout << temp->data << ' ';
        temp = temp->next;
    }
    
    std::cout << std::endl;
}

Node* LinkedList::findCycleBegin(Node* head)
{
    if (head == NULL)
    {
        return nullptr;
    }
    /*SLOW PTR FAST PTR APPROACH*/
    Node* slow = head;
    Node* fast = head;
    
    while (fast != NULL && fast->next != NULL)
    {
        /*MOVE SLOW ONE STEP*/
        slow = slow->next;
        /*MOVE SLOW TWO STEPS*/
        fast = fast->next->next;
        
        /*BREAK IF THEY COLLIDE*/
        if (slow == fast)
        {
            break;
        }
    }
    
    /*CHECK IF LOOP DOES IN FACT EXISTS*/
    if (fast == NULL || fast->next == NULL)
    {
        return nullptr;
    }
    
    /*MOVE SLOW BACK TO HEAD*/
    slow = head;
    while (slow != fast)
    {
        slow = slow->next;
        fast = fast->next;
    }
    
    /*AT THIS POINT SLOW = FAST = BEGINNING OF LOOP. RETURN ANY*/
    return slow;
}

void LinkedList::createCycle()
{
    tail->next = head->next;
}

int main(int argc, const char * argv[])
{
    LinkedList linkedlist = *new LinkedList();
    linkedlist.insert(5);
    linkedlist.insert(10);
    linkedlist.insert(15);
    linkedlist.insert(20);
    linkedlist.insert(25);
    linkedlist.insert(30);
    linkedlist.insert(35);
    linkedlist.insert(40);
    
    linkedlist.display();
    /*FORCE CYCLE*/
    linkedlist.createCycle();
    
    Node* cycleAt = linkedlist.findCycleBegin(linkedlist.head);
    cout<<"CYCLE AT: "<<cycleAt->data<<endl;
    
    return 0;
}

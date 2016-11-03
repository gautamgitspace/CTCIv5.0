//
//  main.cpp
//  CTCI2_4
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
#include "LinkedList.h"

using namespace std;

LinkedList::LinkedList()
{
    this->head = nullptr;
}

LinkedList::~LinkedList()
{
    Node* current = head;
    
    while (current != 0)
    {
        Node* next = current->next;
        delete current;
        current = next;
    }
    
    head = nullptr;
    
    std::cout << "List successfully deleted from memory" << std::endl;
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

Node* LinkedList:: partition(Node* head, int val)
{
    if (head == NULL)
    {
        return nullptr;
    }
    
    LinkedList* upper = new LinkedList();
    LinkedList* lower = new LinkedList();
    Node* current = head;
    
    while (current)
    {
        if (current->data < val)
        {
            lower->insert(current->data);
        }
        else
        {
            upper->insert(current->data);
        }
        
        current = current->next;
    }
    
    // reset current back to the head
    current = lower->head;
    Node* lowNode = lower->head;
    
    // find the end of the lower list and LINK with upper
    while (lowNode->next)
    {
        lowNode = lowNode->next;
    }
    lowNode->next = upper->head;
    
    return current;
}



int main(int argc, const char * argv[])
{
    LinkedList linkedlist = *new LinkedList();
    linkedlist.insert(6);
    linkedlist.insert(3);
    linkedlist.insert(8);
    linkedlist.insert(11);
    linkedlist.insert(7);
    linkedlist.insert(9);
    linkedlist.insert(1);
    
    linkedlist.display();
    Node* newHead = linkedlist.partition(linkedlist.head, 8);
    
    LinkedList* newList = new LinkedList();
    newList->head = newHead;
    cout<<"after partioning"<<endl;
    newList->display();
    
    
    return 0;
}

//
//  main.cpp
//  CTCI2_1
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
#include <unordered_map>
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

void LinkedList::createCycle()
{
    tail->next = head->next;
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
    
    cout << std::endl;
}
void LinkedList:: removeDuplicates(Node* head)
{
    if (head == NULL)
    {
        return;
    }
    
    std::unordered_map<int,bool> map;
    Node* current = head;
    map[current->data] = 1;
    
    while (current->next)
    {
        if (map[current->next->data] == 0)
        {
            map[current->next->data] = 1;
            current = current->next;
        }
        else
        {
            Node* temp = current->next;
            current->next = current->next->next;
            cout << "Duplicate Found: " << temp->data << " removed" << endl;
            delete temp;
        }
    }
}

int main(int argc, const char * argv[])
{
    LinkedList linkedlist = *new LinkedList();
    linkedlist.insert(10);
    linkedlist.insert(12);
    linkedlist.insert(14);
    linkedlist.insert(16);
    linkedlist.insert(18);
    linkedlist.insert(20);
    linkedlist.insert(10);
    
    linkedlist.display();
    linkedlist.removeDuplicates(linkedlist.head);
    linkedlist.display();
    return 0;
}

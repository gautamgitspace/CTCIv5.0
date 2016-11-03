//
//  main.cpp
//  CTCI2_3
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// delete the middle node having access only to the middle node

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



bool LinkedList::removeNode(Node* node)
{
    if (node == NULL || node->next == NULL)
    {
        return false;
    }
    cout<<"TO DELETE: "<<node->data<<endl;
    Node* temp = node->next;
    node->data = temp->data;
    node->next = temp->next;
    delete temp;
    
    return true;
}

int main(int argc, const char * argv[])
{

    LinkedList linkedlist = *new LinkedList();
    linkedlist.insert(15);
    linkedlist.insert(20);
    linkedlist.insert(25);
    linkedlist.insert(30);
    linkedlist.insert(35);
    linkedlist.insert(40);
    linkedlist.insert(45);
    
    linkedlist.display();
    Node* middleNode = linkedlist.head->next->next->next;
    linkedlist.removeNode(middleNode);
    linkedlist.display();
    
    return 0;
}

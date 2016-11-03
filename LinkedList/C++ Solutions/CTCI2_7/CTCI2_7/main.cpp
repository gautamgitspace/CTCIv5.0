//
//  main.cpp
//  CTCI2_7
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//

#include <iostream>
#include <stack>
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

bool LinkedList::isPalindrome(Node* head)
{
    Node *fast = head;
    Node *slow = head;
    
    stack<int> checkerStack;
    
    /*AT THE END SLOW WILL REACH THE MID AND FAST WILL REACH THE END*/
    while (fast != nullptr && fast->next != nullptr)
    {
        /*PUSH SLOW's DATA TO STACK AT EACH STEP*/
        checkerStack.push(slow->data);
        /*MOVE SLOW ONE STEP*/
        slow = slow->next;
        /*MOVE SLOW TWO STEPS*/
        fast = fast->next->next;
    }
    
    
    // When size of list is odd (), skip to the element next to the middle element
    if (fast != nullptr)
    {
        slow = slow->next;
    }
    
    while (slow != nullptr)
    {
        int top = checkerStack.top();
        checkerStack.pop();
        if (top != slow->data)
        {
            return false;
        }
        slow = slow->next;
    }
    return true;
}

int main(int argc, const char * argv[])
{
    LinkedList linkedlist = *new LinkedList();
    linkedlist.insert(10);
    linkedlist.insert(20);
    linkedlist.insert(30);
    linkedlist.insert(20);
    linkedlist.insert(10);
    
    linkedlist.display();
    
    bool result = linkedlist.isPalindrome(linkedlist.head);
    
    cout<<"is Palindrome?: "<<result<<endl;
    
    return 0;
}

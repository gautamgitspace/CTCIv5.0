//
//  main.cpp
//  CTCI4_5
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
// BST VALIDATOR

#include<iostream>

using namespace std;

struct Node{
    int data;
    Node *right, *left;
};

void insert(Node* &head, int value)
{
    if(head == NULL)
    {
        Node *p = new Node;
        p->data = value;
        p->right = NULL;
        p->left = NULL;
        head = p;
        return;
    }
    /*change this condition to less than to alter BST property*/
    if(value < head->data)
    {
        if(head->left == NULL)
        {
            Node *p = new Node;
            p->data = value;
            p->left = NULL;
            p->right = NULL;
            head->left = p;
            return;
        }
        else
        {
            insert(head->left, value);
        }
    }
    else
    {
        if(head->right == NULL)
        {
            Node *p = new Node;
            p->data = value;
            p->left = NULL;
            p->right = NULL;
            head->right = p;
            return;
        }
        else
        {
            insert(head->right, value);
        }
    }
}

bool isBst(Node* root, int lowerBound, int upperBound)
{
    if(root==NULL)
    {
        return true;
    }
    if(root->data <= upperBound && root->data >= lowerBound)
    {
        return (isBst(root->left, lowerBound, root->data-1) && isBst(root->right, root->data+1,upperBound));
    }
    else
        return false;
}

int main()
{
    Node *root = NULL;
    insert(root, 4);
    insert(root, 7);
    insert(root, 2);
    insert(root, 1);
    insert(root, 6);
    insert(root, 8);
    
    
    cout<<"IS BST?: "<<isBst(root, INT_MIN, INT_MAX)<<endl;
}

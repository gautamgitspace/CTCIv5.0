//
//  main.cpp
//  CTCI4_8
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
// IS SUB-TREE

#include <iostream>

using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
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


bool isIdentical(Node* root1, Node* root2)
{
    if(root1 == NULL && root2 == NULL)
        return true;
    if(root1 == NULL || root2 == NULL)
        return false;
    if(root1->data == root2->data && isIdentical(root1->left, root2->left) && isIdentical(root1->right, root2->right))
        return true;
    return false;
}

bool isSubTree(Node* root, Node* subRoot)
{
    if(root == NULL && subRoot == NULL)
        return true;
    if(root == NULL || subRoot == NULL)
        return false;
    return isIdentical(root, subRoot) || isSubTree(root->left, subRoot) || isSubTree(root->right, subRoot);
}


int main(int argc, const char * argv[])
{
    Node* root = NULL;
    insert(root, 5);
    insert(root, 2);
    insert(root, 7);
    insert(root, 1);
    insert(root, 3);
    insert(root, 6);
    insert(root, 4);
    insert(root, 8);
    insert(root, 9);
    
    Node* root2 = NULL;
    insert(root2, 8);
    insert(root2, 9);

    cout<<endl;
    
    cout<<"IS SUB TREE?: "<<isSubTree(root, root2)<<endl;
    return 0;
}

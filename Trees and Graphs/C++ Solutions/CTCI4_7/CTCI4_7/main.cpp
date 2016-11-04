//
//  main.cpp
//  CTCI4_7
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// LOWEST COMMON ANCESTOR

#include <iostream>

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


Node* lca(Node* root, Node* n1, Node* n2)
{
    
    if(root == NULL)
    {
        return NULL;
    }
    
    if(root == n1 || root == n2)
    {
        return root;
    }
    
    Node* left = lca(root->left, n1, n2);
    Node* right = lca(root->right, n1, n2);
    
    if(left != NULL && right != NULL)
    {
        return root;
    }
    return left != NULL ? left : right;
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
    insert(root, 8);
    insert(root, 4);
    insert(root, 9);
    
    std::cout<<"LCA: "<<lca(root, root->left->left, root->left->right->right)->data<<std::endl;
    return 0;
}

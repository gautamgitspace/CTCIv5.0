//
//  main.cpp
//  CTCI4_9
//
//  Created by Gautam on 11/3/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// PATH SUM
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

void print(Node *root, int sum, int *path, int level)
{
    if(root==NULL)
    {
        return;
    }
    path[level] = root->data;
    int s = 0;
    for(int i=level; i>=0; i--)
    {
        s += path[i];
        if(s==sum)
        {
            for(int j=level; j>=i; j--)
                cout<<path[j]<<" ";
            cout<<'\n';
        }
    }
    if(root->left)
        print(root->left, sum, path, level+1);
    if(root->right)
        print(root->right, sum, path, level+1);
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
    int path[100];
    cout<<"Path with sum = 29:"<<endl;
    print(root, 29, path, 0);
    return 0;
}

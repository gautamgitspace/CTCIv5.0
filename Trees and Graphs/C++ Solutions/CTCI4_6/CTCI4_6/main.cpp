//
//  main.cpp
//  CTCI4_6
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// NEXT IN-ORDER SUCCESSOR IN A BST
// The next number will always be on your right (increasing order)
// What if the node has no right sub-tree? -> We traverse upwards to the parent(p) from the child (n).
// if n was to the left of q, next we need to traverse is q. if n was to the right of the queue, then
// we have fully traversed q's sub tree and we need to go upwards from q until we find that node x,
// that hasn't been traversed yet. HOW DO WE KNOW THIS? When we move from a left node(n) to its
// parent(q)

#include <iostream>
#include <stack>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
    Node* parent;
};


void insert(Node* &head, int value)
{
    if(head == NULL)
    {
        Node *p = new Node;
        p->data = value;
        p->right = NULL;
        p->left = NULL;
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

Node* leftMostChild(Node* x)
{
    if(x == NULL)
        return NULL;
    while(x->left!=NULL)
    {
        x=x->left;
    }
    return x;
}

Node* inOrderSuccessor(Node* n)
{
    if(n==NULL)
    {
        return NULL;
    }
    if(n->right!=NULL)
    {
        /*CASE #1: HAS RIGHT SUB-TREE*/
        return leftMostChild(n->right);
    }
    else
    {
        /*CASE #2: NO RIGHT SUB-TREE*/
        /*WE NEED TO TRAVERSE UPWARDS FROM Q UNTIL WE FIND A NODE X THAT WE HAVE NOT FULLY TRAVERSED*/
        
        Node* q = n;
        Node* x = q->parent;
        
        while(x!=NULL && x->left!=q)
        {
            q = x;
            x->parent = x;
        }
        return x;
    }
}

/*USING A STACK*/
Node* inOrderSuccessorUsingStack(Node* root, int k)
{
    stack<Node*> S;
    Node *ptr = root;
    bool searched = false;
    while(true)
    {
        while(ptr)
        {
            S.push(ptr);
            ptr = ptr->left;
        }
        if(S.empty())
            break;
        ptr = S.top();
        S.pop();
        if(searched)
            return ptr;
        if(ptr->data==k)
        {
            searched = true;
        }
        ptr = ptr->right;
    }
    return nullptr;
}



int main(int argc, const char * argv[])
{

}

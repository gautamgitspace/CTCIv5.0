//
//  main.cpp
//  CTCI4_1
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
// 1. If two trees are in same in-order?
// 2. if two trees are same?
// 3. Tree traversals
// 4. if tree is balanced?
// 5. tree height
// 6. search a tree

#include <iostream>
#include <stack>
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

int height(Node* root)
{
    if(root == NULL)
    {
        return 0;
    }
    else
    {
        return max(height(root->right), height(root->left)+1);
    }
}

bool isBalanced(Node* root)
{
    if(root == NULL)
        return true;
    int heightDiff = height(root->right) - height(root->left);
    if(abs(heightDiff)>1)
        return false;
    else
        return (isBalanced(root->left) && isBalanced(root->right));
}

void inOrder(Node* root)
{
    if(root->left!=NULL)
        inOrder(root->left);
    cout<<root->data<<"->";
    if(root->right!=NULL)
        inOrder(root->right);
}

void preOrder(Node* root)
{
    cout<<root->data<<"->";
    if(root->left!=NULL)
        inOrder(root->left);
    if(root->right!=NULL)
        inOrder(root->right);
}

void postOrder(Node* root)
{
    if(root->left!=NULL)
        inOrder(root->left);
    if(root->right!=NULL)
        inOrder(root->right);
    cout<<root->data<<"->";
}

bool search(Node* root, int d)
{
    if(d==root->data)
        return true;
    if(d<root->data)
    {
        return root->left!=NULL ? search(root->left,d) : NULL;
    }
    else if(d>root->data)
    {
        return root->right!=NULL ? search(root->right,d) : NULL;
    }
    return NULL;
}

bool isSameInorder(Node* root1, Node* root2)
{
    stack<Node*> stk1;
    stack<Node*> stk2;
    
    while(root1!=NULL)
    {
        stk1.push(root1);
        root1 = root1->left;
    }
    
    
    while(root2!=NULL)
    {
        stk2.push(root2);
        root2 = root2->left;
    }
    
    while(!stk1.empty() && !stk2.empty())
    {
        
        Node *a = stk1.top();
        stk1.pop();
        Node* b = stk2.top();
        stk2.pop();
        if(a->data != b->data)
        {
            return false;
        }
        a = a->right;
        b = b->right;
        while(a!=NULL)
        {
            stk1.push(a);
            a = a->left;
        }
        
        while(b!=NULL)
        {
            stk2.push(b);
            b = b->left;
        }
    }
    return true;
}

bool isSameTree(Node* p, Node* q)
{
    if(p == NULL && q == NULL)
        return true;
    if(p == NULL || q == NULL)
        return false;
    bool isLeftSame = isSameTree(p->left, q->left);
    bool isRightSame = isSameTree(p->right, q->right);
    
    return p->data == q->data && isLeftSame && isRightSame;
}


int main(int argc, const char * argv[])
{
    Node *root = NULL;
    insert(root, 4);
    insert(root, 7);
    insert(root, 2);
    insert(root, 1);
    insert(root, 6);
    insert(root, 8);
    
    Node *root2 = NULL;
    insert(root2, 4);
    insert(root2, 7);
    insert(root2, 2);
    insert(root2, 1);
    insert(root2, 6);
    insert(root2, 99);
    
    cout<<"isInSameInOrder?:"<<isSameInorder(root, root2)<<endl;
    
    cout<<"isBalanaced?: "<<isBalanced(root)<<endl;
    
    cout<<"isSameTree?: "<<isSameTree(root, root2)<<endl;
    
    cout<<"Tree 1 contains 99?: "<<search(root, 99)<<endl;
    
    cout<<"Height of Tree: "<<height(root)<<endl;
    cout<<"IN-ORDER"<<endl;
    inOrder(root);
    cout<<endl;
    
    cout<<"PRE-ORDER"<<endl;
    preOrder(root);
    cout<<endl;
    
    cout<<"POST-ORDER"<<endl;
    postOrder(root);
    cout<<endl;
    return 0;
}

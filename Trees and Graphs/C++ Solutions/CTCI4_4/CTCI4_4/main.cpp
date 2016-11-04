//
//  main.cpp
//  CTCI4_4
//
//  Created by Gautam on 11/2/16.
//  Copyright © 2016 Gautam. All rights reserved.
//
//  Linkedlist at all levels of a tree

#include<iostream>
#include<vector>
#include<list>
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

void findLevelLinkedLists(vector<list<Node*> > &res, Node* root)
{
    list<Node*> li;
    li.push_back(root);
    res.push_back(li);
    int depth = 0;
    while(!res[depth].empty())
    {
        /*CREATE NEW LIST AT EACH LEVEL*/
        list<Node*> l;
        list<Node*>::iterator iter;
        for(iter = res[depth].begin(); iter!=res[depth].end(); iter++ )
        {
            /*KEEP PUTTING IN LIST*/
            Node *ptr = *iter;
            if(ptr->left)
                l.push_back(ptr->left);
            if(ptr->right)
                l.push_back(ptr->right);
        }
        /*PUT LIST IN VECTOR*/
        res.push_back(l);
        depth++;
    }
}

void printLevelLinkedLists(vector<list<Node*> > res)
{
    /*MAKE AN ITERATOR FOR THE VECTOR*/
    vector<list<Node*> >::iterator iter;
    for(iter = res.begin(); iter!= res.end(); iter++)
    {
        list<Node*> li = *iter;
        list<Node*>::iterator it;
        for(it = li.begin(); it!=li.end(); it++)
        {
            Node* ptr = *it;
            cout<<ptr->data<<" ";
        }
        cout<<'\n';
    }
}

int main()
{
    Node* root;
    root = NULL;
    insert(root, 4);
    insert(root, 7);
    insert(root, 2);
    insert(root, 1);
    insert(root, 6);
    insert(root, 8);
    
    vector<list<Node*> > res;
    findLevelLinkedLists(res, root);
    printLevelLinkedLists(res);
}

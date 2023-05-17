//
//  reverse_linked_list.cpp
//  HelloWorldCPP
//
//  Created by 胡帅帅 on 5/15/23.
//

#include "reverse_linked_list.hpp"
#include <iostream>

struct ListNode{
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr){} //
    ListNode(int x) : val(x), next(nullptr){} //
    ListNode(int x, ListNode* adr) : val(x), next(adr){} //
    
};

class Solution {
public:
    ListNode* reverseList(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* cur = head;
        
        while (cur) { // if the hex address is not null
            ListNode* next = cur->next; // get a field within a struct (not an object)
            cur -> next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
};

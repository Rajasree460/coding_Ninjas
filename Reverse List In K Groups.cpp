Node* reverse(Node* head){
    if(head == NULL || head->next ==NULL){
        return head;
    }
    Node* back =NULL;
    Node* curr =head;
    Node* front =NULL;
    while(curr != NULL){
        front =curr->next;
        curr->next =back;
        back =curr;
        curr =front;
    }
    return back;
}

Node *kReverse(Node *head, int k) {
    Node *temp = head;
    Node* nextNode =NULL;
    Node* prevNode =NULL;
    while(temp != NULL){
        Node *kth = temp;
        for(int i=1;i<k && kth != NULL;i++){
            kth =kth->next;
        }
        if(kth == NULL){
            if(prevNode){
                prevNode->next =temp;
            }
            break;
        }
        nextNode =kth->next;
        kth->next =NULL;
        reverse(temp);
        if(head == temp){
            head =kth;
        }
        else{
            prevNode->next =kth;
        }
        prevNode =temp;
        temp =nextNode;
    }
    return head;
}

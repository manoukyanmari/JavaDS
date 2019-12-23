/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author Elya
 */
public class List {
    private Node head;
    private Node tail;
    private int size = 0;


    // 5. a. Given head, print every next
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public boolean find(int val){
        for(int i=0; i<size; i++){
            int value = iterator(i);
            if(value==val){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void push(int val){
        Node temp = new Node(val);
        if(isEmpty()){
            head = tail = temp;
        }else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }
    
    public void pushFront(int val){
        Node temp = new Node(val);
        if(isEmpty()){
            head = tail = temp;
        }else{
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
        size++;
    }    


    
    public void remove(){
        //last
        tail = tail.prev;
        tail.next = null;
        size--;
        //second
        head.next = head.next.next;
        head.next.next.prev = head;
        size--;
        //first
        head.next.prev = null;
        head = head.next;
        
        size--;
    }
    public int getSize(){
        return size;
    }
    
    public int iterator(int index) throws IndexOutOfBoundsException{
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException("Your index is smaller than zero or bigger than size");
        }
        Node temp = head;
        
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.value;
    }

    public Node iteratorAddr(int index){
        Node temp = head;
        
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
    

    public boolean equals(List params){
        if(size!=params.getSize()){
            return false;
        }else if(isEmpty()){
            return true;
        }else{
            
            for(int i=0; i<size; i++){
                int value = iterator(i);
                int pValue = params.iterator(i);
                if(value != pValue){
                    return false;
                }
            }
            return true;
        }
    }
    
    public void copy(List param){
        if(!param.isEmpty()){
            int pSize = param.getSize();
            for(int i=0; i<pSize; i++){
                param.removeByIndex(i);
            }
        }
        for(int i=0; i<size; i++){
            param.push(iterator(i));
        }
    }
    
    public List copyList(){
        
        List temp = new List();
        for(int i=0; i<size; i++){
            temp.push(iterator(i));
        }
        return temp;
    }
    
    public void finalize(List temp){ //?????
        if(!isEmpty()){
            for(int i=0; i<size; i++){
                temp.removeByIndex(i);
            }
        }
    }
    
    public void removeByIndex(int index){
        if(!isEmpty()){
            if(size==1){
                head = null;
            }else if(size==2){
                if(head==iteratorAddr(index)){
                    head = tail;
                    tail.prev = null;
                }else if(tail==iteratorAddr(index)){
                    tail.prev = null;
                    head.next = null;
                }
            }else{
                Node temp = iteratorAddr(index);
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
    }


}

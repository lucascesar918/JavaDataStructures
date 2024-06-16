package com.mycompany.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;
    
    
    public static void main(String[] args) {
        Queue queue = new Queue();
        
        queue.queue("Mao Zedong");
        queue.queue("Pol Pot");
        
        queue.PrintAll();
        
        queue.dequeue();
        
        queue.PrintAll();
    }
    
    public class Node {
        String value;
        Node next;
        
        public Node(String value) {
            this.value = value;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Queue() {
        this.length = 0;
    }
    
    public Queue(Node newNode) {
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }
    
    public Queue(String value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PrintAll">
    public void PrintAll() {
        Node currentNode = first;
        
        do {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        } while (currentNode != null);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Checks">
    public boolean isEmpty() {
        return length == 0;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Node getFirst() {
        return first;
    }
    
    public Node getLast() {
        return last;
    }
    
    public int getLength() {
        return length;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queue">
    public void queue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            length = 1;
            return;
        }
        
        last.next = newNode;
        last = newNode;
        length ++;
    }
    
    public void queue(String value) {
        Node newNode = new Node(value);
        queue(newNode);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Dequeue">
    public Node dequeue() {
        if (isEmpty())
            return null;
        
        Node dequeued = this.first;
        this.first = this.first.next;
        return dequeued;
    }
    // </editor-fold>
}

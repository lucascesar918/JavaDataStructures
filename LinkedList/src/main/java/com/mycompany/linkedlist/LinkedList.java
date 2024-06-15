package com.mycompany.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;
    
    public static void Sep(){
        System.out.println("----------------------");
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList("Mao Zedong");
        list.PrintAll();
        
        Sep();
        
        list.append("Carlos Marighella");
        list.PrintAll();
        
        Sep();
        
        list.prepend("Karl Marx");
        list.PrintAll();
        
        Sep();
        
        System.out.println(list.get(1).value);
        
        Sep();
        
        list.removeHead();
        list.PrintAll();
        
        Sep();
        
        list.removeTail();
        list.PrintAll();
        
        Sep();
        
        list.delete(95496);
        list.PrintAll();

        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public LinkedList(Node newNode){
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }
    
    public LinkedList(String value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length = 1;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PrintAll">
    public void PrintAll() {
        if (isEmpty())
            return;
        
        Node currentNode = this.head;
        int count = 0;
        
        do {
            System.out.println(count + ". " + currentNode.value);
            currentNode = currentNode.next;
            count ++;
        } while (currentNode != null);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Node getHead() {
        return this.length == 0 ? null : this.head;
    }
    
    public Node getTail() {
        return this.length == 0 ? null : this.tail;
    }
    
    public Node get(int position) {
        if (position < 0 || position > this.length)
            return null;
        
        if (isEmpty())
            return null;
        
        Node currentNode = this.head;
        for(int c=0; c<position; c++) {
            currentNode = currentNode.next;
        }
        
        return currentNode;
    }
    
    public int length() {
        return this.length;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Checks">
    public boolean isEmpty() {
        return this.length == 0;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Remove">
    public Node removeHead() {
        if (isEmpty())
            return null;
        
        Node oldHead = this.head;
        this.head = this.head.next;
        this.length --;
        
        return oldHead;
    }
    
    public Node removeTail() {
        if (isEmpty())
            return null;
        
        if (this.length == 1) {
            Node oldTail = this.tail;
            this.head = this.tail = null;
            this.length = 0;
            return oldTail;
        }
        
        if (this.length == 2) {
            Node oldTail = this.head.next;
            this.head.next = null;
            this.tail = this.head;
            this.length = 1;
            return oldTail;
        }
        
        Node oldTail = this.tail;
        Node secondLast = get(this.length - 2);
        secondLast.next = null;
        
        return oldTail;
    }
    
    public Node delete(int position) {
        if (position < 0 || position > this.length - 1)
            return null;
        
        Node oldNth = get(position);        
        get(position - 1).next = oldNth.next;
        this.length --;
        
        return oldNth;
    }
    
    public void emptyList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Add">
    // <editor-fold defaultstate="collapsed" desc="Append">
    public void append(Node newNode){
        if (!isEmpty())
            this.tail.next = newNode;
        
        this.tail = newNode;
        this.length ++;
    }
    
    public void append(String value){
        if (!isEmpty())
            this.tail.next = new Node(value);
        
        this.tail = this.tail.next;
        this.length ++;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Prepend">
    public void prepend(Node newNode) {
        if (!isEmpty())
            newNode.next = this.head;
        
        this.head = newNode;
        this.length ++;
    }
    
    public void prepend(String value) {
        Node newNode = new Node(value);
        if (!isEmpty())
            newNode.next = this.head;
        
        this.head = newNode;
        this.length ++;
    }
    // </editor-fold>
    // </editor-fold>
    
    public class Node {
        String value;
        Node next;
        
        public Node(String value){
            this.value = value;
        }
    }
}

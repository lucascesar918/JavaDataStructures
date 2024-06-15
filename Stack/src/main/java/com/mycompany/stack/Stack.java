package com.mycompany.stack;

public class Stack {
    private Node top;
    private int height;
    
    static void sep() {
        System.out.println("-----------------------");
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.push("Mao Zedong");
        stack.push("Joseph Stalin");
        stack.PrintAll();
        
        sep();
        
        stack.push("Tovarish Lenin");
        stack.PrintAll();
        
        sep();
        
        stack.pop();
        stack.PrintAll();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Stack(String value) {
        this.top = new Node(value);
        this.height = 1;
    }
    
    public Stack(Node newNode) {
        this.top = newNode;
        this.height = 1;
    }
    
    public Stack() {
        this.height = 0;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Checks">
    public boolean isEmpty() {
        return height == 0;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Push">
    public void push(Node newNode) {
        newNode.previous = this.top;
        this.top = newNode;
        this.height ++;
    }
    
    public void push(String value) {
        Node newNode = new Node(value);
        newNode.previous = this.top;
        this.top = newNode;
        this.height ++;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Pop">
    public Node pop() {
        if (isEmpty()){
            System.err.println("Stack is already empty");
            return null;
        }
        
        Node oldTop = this.top;
        this.top = this.top.previous;
        this.height --;
        
        return oldTop;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Node getTop() {
        return this.top;
    }
    
    public int getHeight() {
        return this.height;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="PrintAll">
    public void PrintAll() {
        if (this.top == null)
            return;
        
        Node currentNode = this.top;
        
        do {
            System.out.println(currentNode.value);
            currentNode = currentNode.previous;
        } while (currentNode != null);
    }
    // </editor-fold>
    
    public class Node {
        public String value;
        public Node previous;
        
        public Node(String value) {
            this.value = value;
        }
    }
}

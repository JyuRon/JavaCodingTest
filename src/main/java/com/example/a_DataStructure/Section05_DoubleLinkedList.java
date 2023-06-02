package com.example.a_DataStructure;

public class Section05_DoubleLinkedList<T> {
    /**
     * - 노드 추가 메소드 작성
     * - 전체 출력 메소드 작성
     * - 노드 중간에 추가하는 메소드 작성
     * - head 부터 특정 노드를 찾는 메서드 추가하기
     * - tail 부터 특정 노드를 찾는 메서드 추가하기
     */

    Node<T> head;
    Node<T> tail;

    class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<>(data);
            tail = head;
            return;
        }

        Node<T> node = head;
        while (node.next != null){
            node = node.next;
        }
        node.next = new Node<>(data);
        node.next.prev = node;
        tail = node.next;
    }

    public void printAll(){
        Node<T> node = head;

        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }

    }

    public Node<T> searchFromHead(T data){
        Node<T> node = head;

        while(node != null){
            if(node.data == data){
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public Node<T> searchFromTail(T data){
        Node<T> node = tail;

        while(node != null){
            if(node.data == data){
                return node;
            }
            node = node.prev;
        }

        return null;
    }

    // 데이터를 임의 노드 앞에 노드를 추가하는 메서드 추가하기
    public boolean insertDataBeforeTarget(T insertData, T targetData){

        // header 에 데이터가 존재하지 않는 경우
        if (this.head == null) {
            this.head = new Node<T>(insertData);
            this.tail = this.head;
            return true;
        }

        // 타겟 데이터가 헤더인 경우
        if (this.head.data == targetData) {
            Node<T> newHead = new Node<T>(insertData);
            newHead.next = this.head;
            this.head = newHead;
            this.head.next.prev = this.head;
            return true;
        }

        Node<T> node = this.head;
        while (node != null) {
            if (node.data == targetData) {
                Node<T> nodePrev = node.prev;
                nodePrev.next = new Node<T>(insertData);
                nodePrev.next.next = node;
                nodePrev.next.prev = nodePrev;
                node.prev = nodePrev.next;
                return true;
            }

            node = node.next;
        }
        return false;

    }

    public static void main(String[] args) {
        Section05_DoubleLinkedList<Integer> MyLinkedList = new Section05_DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertDataBeforeTarget(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertDataBeforeTarget(6, 2);
        MyLinkedList.insertDataBeforeTarget(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();

    }
}

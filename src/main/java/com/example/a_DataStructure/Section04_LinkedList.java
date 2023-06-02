package com.example.a_DataStructure;

public class Section04_LinkedList<T> {
    Node<T> head = null;

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    void addNode(T data){
        if( head == null){
            head = new Node<>(data);
        }else {
            Node<T> node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    void printAll(){
        if(head != null){
            Node<T> node = head;
            while (node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    Node<T> search(T data){
        Node<T> node = head;
        while(node != null){
            if(node.data == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    void addNodeInside(T insertData, T targetData) {
        Node<T> search = search(targetData);

        if(search == null){
            addNode(insertData);
        }else{
            Node<T> nodeNext = search.next;
            search.next = new Node<>(insertData);
            search.next.next = nodeNext;
        }
    }

    public boolean delNode(T targetData){
        Node<T> search = head;

        // 헤드 부분을 삭제하는 경우
        if(search.data == targetData){
            head = search.next;
            return true;
        }

        while (search.next != null){
            if(search.next.data == targetData){
                search.next = search.next.next;
                return true;
            }
            search = search.next;
        }

        return false;
    }
    public static void main(String[] args) {

        Section04_LinkedList<Integer> MyLinkedList = new Section04_LinkedList<>();
        MyLinkedList.addNodeInside(5, 1);

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);


        // 1 데이터 뒤에 5 넣어보기
        MyLinkedList.addNodeInside(6, 3);
        MyLinkedList.addNodeInside(7, 20);


        MyLinkedList.delNode(5);
        MyLinkedList.delNode(7);
        MyLinkedList.delNode(20);


        MyLinkedList.printAll();

    }
}

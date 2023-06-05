package com.example.a_DataStructure;

public class Section09_BinarySearchTree {
    // 데이터가 동일한 경우 오른쪽으로 탐색하도록 한다.

    Node head;

    public class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean insertNode(int data){

        // 처음으로 데이터를 insert 하는 경우
        if(head == null){
            head = new Node(data);
            return true;
        }

        // 데이터가 하나 이상 존재하는 경우
        Node node = head;
        while (true){
            // insert data 가 기준점 보다 작을 경우
            if(data < node.value){
                if(node.left != null){
                    node = node.left;
                }else{
                    node.left = new Node(data);
                    break;
                }
            // insert data 가 기준전보다 같거나 클 경우
            }else{
                if(node.right != null){
                    node = node.right;
                }else{
                    node.right = new Node(data);
                    break;
                }
            }
        }
        return true;
    }

    public Node search(int data){
        Node node = head;

        // tree 에 데이터가 존재하지 않는 경우
        if(node == null){
            return null;
        }

        while (node != null){
            // 찾고자 하는 데이터가 기준점 보다 작을 경우
            if(data < node.value){
                node = node.left;
            // 찾고자 하는 데이터가 기준전보다 클 경우
            }else if(data > node.value){
                node = node.right;
            // 찾고자 하는 데이터가 기준점과 동이한 경우
            }else{
                return node;
            }
        }

        // 노드를 순회 하였지만 찾고자 하는 데이터가 없는 경우우
       return null;
    }

    public boolean delete(int value){

        boolean searched = false;
        // Node 가 하나라도 들어가 있을 때
        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node 가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 코너 케이스2: (Node 가 단지 하나이고, 해당 Node 삭제 시)
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched == false) {
                return false;
            }
        }

        // Case1: 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null; // 해당 객체 삭제를 위해, 강제로 null 로 만들어줌
            } else {
                currParentNode.right = null;
                currNode = null; // 해당 객체 삭제를 위해, 강제로 null 로 만들어줌
            }
            return true;
            // Case2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (왼쪽)
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
            // Case2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우 (오쪽)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
            // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
            // 상위 코드 조건에 부합하지 않는 경우는 결국 (currNode.left != null && currNode.right != null) 이므로
            // 별도로 else if 로 하기 보다, else 로 작
        } else {

            // 삭제할 Node가 Parent Node 왼쪽에 있을 때
            if (value < currParentNode.value) {

                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 가진 Node 가 들어있음

                if (changeNode.right != null) {
                    // Case3-1-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-1-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                // parent Node 의 왼쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.left = changeNode;
                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                // 삭제할 Node 삭제!
                currNode = null;
                // 삭제할 Node가 Parent Node 오른쪽에 있을 때
            } else {
                // 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-2-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-2-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // parent Node 의 오른쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parent Node 왼쪽 Child Node 인 changeNode 의 왼쪽/오른쪽 Child Node 를
                // 모두 삭제할 currNode 의 기존 왼쪽/오른쪽 Node 로 변경

                // 2021.11.09 업데이트 (참고: 코너 케이스)
                // currNode.right 가 changeNode 일 경우, changeNode 가 currNode 자리로 올라가면서,
                // 오른쪽에 다시 자신의 객체를 가리키는 상황이 될 수 있습니다.
                // 이 경우 의도치 않게, 삭제할 객체를 다시 연결하는 상황이 될 수 있습니다.
                // 특별한 코너 케이스이므로, 참고로만 코드를 업데이트를 드리며,
                // 우선은 트리의 핵심 알고리즘 이해에 보다 초점을 맞추시는 것을 추천드립니다.
                if (currNode.right != changeNode) {
                    changeNode.right = currNode.right;
                }
                changeNode.left = currNode.left;
                // 삭제할 Node 삭제!
                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Section09_BinarySearchTree myTree = new Section09_BinarySearchTree();
        // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우

        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }



}

public class LinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    // takes a linked-list Node as its argument and removes the node following the given one
    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return; // Does nothing if the argument is null or the next field of the argument is null
        }
        node.next = node.next.next;
    }

    // creates a new linked list with the same sequence of items, without destroying the original linked list
    public Node copy(Node node) {
        if (node == null) {
            return null;
        }
        Node newHead = new Node(node.data);
        Node current = newHead;
        while (node.next != null) {
            node = node.next;
            current.next = new Node(node.data);
            current = current.next;
        }
        return newHead;
    }

    // removes every node in the list whose item field is equal to key.
    public void removeDuplicate(Node head, int key) {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // finds the maximum item in the linked list
    public int max(Node head) {
        if (head == null) {
            return 0; // if the linked list is empty
        }
        int maxVal = head.data;
        while (head != null) {
            maxVal = Math.max(maxVal, head.data);
            head = head.next;
        }
        return maxVal;
    }

    // to test
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original linked list:");
        printLinkedList(head);

        list.removeAfter(head.next);
        System.out.println("Linked list after removing node after first node:");
        printLinkedList(head);

        Node copyHead = list.copy(head);
        System.out.println("Copied linked list:");
        printLinkedList(copyHead);

        list.removeDuplicate(head, 4);
        System.out.println("Linked list after removing duplicates with value 4:");
        printLinkedList(head);

        int maxValue = list.max(head);
        System.out.println("Maximum value in the linked list: " + maxValue);
    }

    // Helper method
    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
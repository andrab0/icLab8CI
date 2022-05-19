/**
 * Implementarea unei liste circulare
 * Clasa contine diferite functii pentru prelucrarea
 * si verificarea nodurilor din lista.
 * @author Andra B
 */

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Aceasta functie este folosita pentru adaugarea unui
     * nod nou in lista.
     * @param value reprezinta valoarea noului nod ce va fi
     *             adaugat in lista
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Aceasta functie este folosita pentru cautarea unei valori
     * transmise ca parametru in lista noastra.
     * @param searchValue reprezinta valoarea noului nod ce va fi
     *             adaugat in lista
     * @return boolean returneaza true daca valoarea exista in lista
     *                  sau false daca aceasta nu exista.
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Aceasta functie este folosita pentru stergerea unui
     * nod existent in lista.
     * @param valueToDelete reprezinta valoarea noului nodului ce
     *                     va fi sters din lista
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Aceasta functie este folosita pentru gasirea nodului urmator pornind
     * de la un nod transmis ca parametru.
     * @param currentNode reprezinta valoarea noului curent pentru
     *                   care se cere urmatorul nod
     * @return Node returneaza null daca nodul curent nu are un succesor sau
     *              nodul urmator daca acesta exista.
     */
    public Node getNextNode(Node currentNode) {
        Node curr = head;

        while(curr != null) {
            if (curr == currentNode) {
                return  currentNode.nextNode;
            }

            curr = curr.nextNode;
        }

        return null;
    }

}
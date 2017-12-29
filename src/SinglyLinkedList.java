//InsertDeleteSet by Uday Mahajan

//(Singly Linked List)

public class SinglyLinkedList {
	Node head;
	Node tail;
	Node prev;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	public void add(Object newThing) {

		Node newNode = new Node();

		newNode.data = newThing;
		newNode.next = null;

		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode; // old tail
			tail = newNode; // this node becomes new tail
		}
	}

	public void print() {
		Node traverse = head;
		while (traverse != null) {
			System.out.println(traverse.data);
			traverse = traverse.next;
		}
	}

	public Object get(int i) {

		Node traverse = head;
		int count = 0;

		while (traverse != null & i != count) {
			count++;
			traverse = traverse.next;
		}

		if (i > count | traverse == null) {
			return "Out of range";
		} else {
			return traverse.data; // if we are here => we have found i and can
			// return the data from head
		}

	}

	public int size() {
		int count = 0;
		Node traverse = head;
		while (traverse != null) {
			count++;
			traverse = traverse.next;
		}
		return count;

	}

	public Object insert(int i, Object itemToInsert) {
		// Node to contain new item.

		Node newNode = new Node();
		newNode.data = itemToInsert;
		Node traverse = head;
		Node previous = null;
		int count = 0;
		if (i == 0) {
			head = newNode;
			newNode.next = traverse;
			return "Done: Successfully inserted " + newNode.data + " at location " + i;

		} else {

			while (traverse != null & count != i) {
				count++;
				previous = traverse;
				traverse = traverse.next;
			}

			if (i > count | i < 0 | traverse == null) {
				// do nothing
				return "Error: Location is out of range";

			} else {
				previous.next = newNode; // insert new node after previous
				newNode.next = traverse; // set the next of new node to be the
											// item
											// that
											// was in the position now occupied
				// by new node
				return "Done: Successfully inserted " + newNode.data + " at location " + i;
			}
			
		}
	}

	public Object delete(int i) {
		Node traverse = head;
		Node previous = null;
		int count = 0;

		if (i == 0) {
			head = traverse.next;
			return "Done: Successfully deleted " + traverse.data+ " from location "+i;
		} else {

			while ((traverse != null) & count != i) {

				count++;
				previous = traverse;
				traverse = traverse.next;
			}

			if (i > count | i < 0 | traverse == null) {
				// do nothing
				return "Error: Location is out of range";

			} else {
				previous.next = traverse.next;
				return "Done: Successfully deleted " + traverse.data+ " from location "+i;
			}
		}
	}

	public Object set(int i, Object itemToSet) {

		Node traverse = head;
		int count = 0;

		if (i == 0) {
			traverse.data = itemToSet;
			return "Done: Successfully set the item at location "+ i + " to " + itemToSet;
			
		} else {

			while (traverse != null & count != (i)) {
				count++;
				traverse = traverse.next;
			}
			if ((i) > count | i < 0 | traverse == null) {
				// do nothing
				return "Error: Location is out of range";

			} else {
				traverse.data = itemToSet;
				return "Done: Successfully set the item at location "+ i + " to " + itemToSet;
			}
		}

	}
	
	// Traverse method as provided by yourself
	public void traverse() {
		System.out.println("** Starting traverse ***");
		Node tmp = head;
		int i = 0;
		while (tmp != null) {
			System.out.println(i + ": " + tmp.data);
			i++;
			tmp = tmp.next;
		}

		System.out.println("** going back ***");
		
		tmp = tail;
		i = size() - 1;
		
		while (tmp != null) {
			System.out.println(i + ": " + tmp.data);
			i--;
			tmp = tmp.prev;
		}
		System.out.println("** traverse done ***");
		System.out.println();

	}

}

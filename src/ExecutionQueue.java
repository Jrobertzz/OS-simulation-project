public class ExecutionQueue {

	protected class Node {

		private ProcessControlBlock pcb;
		public Node next;

		public Node() {
			pcb = null;
			next = null;
		}

		public Node(ProcessControlBlock pcb) {
			this.pcb = pcb;
		}

		public Node(ProcessControlBlock pcb, Node next) {
			this.pcb = pcb;
			this.next = next;
		}

		public ProcessControlBlock getPCB() {
			return pcb;
		}
	}

	protected Node head;
	protected Node tail;
	private int size;

	public ExecutionQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	protected void setHead(ProcessControlBlock pcb) {
		// If there is no head, make new pcb into the new head
		if (head == null) {
			head = new Node(pcb);
			tail = head;
			tail.next = head;
			size++;
		}
		// Otherwise replace the head with the new pcb
		else {
			head = new Node(pcb, head);
			tail.next = head;
		}
	}

	public void enQueue(ProcessControlBlock pcb) {
		// If head is null, make new pcb the new head
		if (head == null) {
			setHead(pcb);
		}

		// Otherwise set the new pcb to be the tail
		else {
			tail.next = new Node(pcb, head);
			tail = tail.next;
			size++;
		}
	}

	public ProcessControlBlock deQueue() {
		if (tail == null && head == null) {
			return null;
		}

		else {
			Node temp = head;

			// If there is only one pcb, make both head and tail null
			if (head == tail) {
				tail = null;
				head = null;
			}

			// Otherwise remove the head
			else {
				head = head.next;
				tail.next = head;
			}

			size--;

			// Return the removed head
			return temp.getPCB();
		}
	}

	public ProcessControlBlock find(int PID) {
		if (head == null) {
			return null;
		}

		Node node = head;
		if (head == tail) {
			if (head.getPCB().getPID() == PID) {
				return head.getPCB();
			} else {
				return null;
			}
		}

		for (; node != tail; node = node.next) {
			if (node.getPCB().getPID() == PID) {
				return node.getPCB();
			}

			if (tail.getPCB().getPID() == PID) {
				return node.getPCB();
			}
			
		}
		return null;
	}

	public boolean remove(int PID) {
	    // If queue is empty
		if (isEmpty()){
			return false;
		}
		
		// If queue has  one element
		if (head == tail){
			if (head.getPCB().getPID() == PID){
				head = null;
				tail = null;
				size--;
				return true;
			}
			else {
				return false;
			}
		}
		
		// If PID is at head
		if (head.getPCB().getPID() == PID){
			head = head.next;
			tail.next = head;
			size--;
			return true;
		}
		
		else {
			Node current = head;
			Node previous = null;
			boolean found = false;
			
			while (current.getPCB().getPID() != PID && current.next != head){
				previous = current;
				current = current.next;
			}
			
			if (current.getPCB().getPID() == PID){
				if (current == tail){
					previous.next = head;
					tail = previous;
				}
				
				else {
					previous.next = current.next;
				}
				size--;
				return true;
			}
			
			else {
				return false;
			}
		}
		
		
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSize(){
		return size;
	}

	public void printQueue() {
		if (!isEmpty()) {
			StringBuilder str = new StringBuilder();
			Node current = head;
			while (true) {
				str.append(current.getPCB() + "; ");
				current = current.next;
				if (current == head)
					break;
			}
			System.out.println(str.toString());
		}
	}
}
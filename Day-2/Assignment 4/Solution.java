/**
 * @author Bollu Himana
 */
class Solution {
	public static String Josephus(int a, int b) {
		// fill you code Here
		linkedList cLl = new linkedList();
		for (int i = 0; i < a; i++) {
			Node node = new Node(i);

			cLl.add(i);
		}

		cLl.formCircle();
		int pos = 1;
		Node temp = cLl.head;
		int eliminated = 0;
		String toReturn =" ";
		while(eliminated != a) {
			temp = temp.next;
			pos++; 
			if(pos == b) {
				pos = 1;
				toReturn += temp.value + " ";

				Node prevNode = temp.prev;
				Node nextNode = temp.next;

				prevNode.next = nextNode;
				nextNode.prev = prevNode;

				eliminated++;
				temp = temp.next;
			}
		}
		toReturn = toReturn.trim();
		return toReturn;
	}
}
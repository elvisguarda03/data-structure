package br.com.guacom.data.structure.model;

//A remoção em uma lista ligada simples (igual a que vimos) leva tempo linear. 
//Afinal, precisamos navegar na lista até achar o elemento antes e o depois do elemento a ser removido.

public class LinkedList<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3370718357849371837L;
	private Node<T> first;
	private Node<T> last;
	private Node<T> actual;
	private int size;

	public LinkedList() {}
	
	public void addFirst(T element) {
		if (element == null)
			throw new NullPointerException("Objeto nulo!");
		Node<T> newNode = new Node<T>(element, first);
		first = newNode;
		if (size == 0)
			last = first;
		size++;
	}

	public void addLast(T element) {
		if (size == 0)
			addFirst(element);
		else {
			if (element == null)
				throw new NullPointerException("Objeto nulo!");
			Node<T> newNode = new Node<T>(element, last.getNext());
			last.setNext(newNode);
			last = newNode;
			size++;
		}
	}

	public void add(int index, T element) {
		if (isEmpty())
			addFirst(element);
		else if (index == size)
			addLast(element);
		else {
			rangeCheck(index);
			if(element == null)
				throw new NullPointerException("Objeto nulo!");
			Node<T> previous = getNode(index - 1);
			Node<T> newNode = new Node<T>(element, previous.getNext());
			previous.setNext(newNode);
			size++;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private Node<T> getNode(int index) {
		rangeCheck(index);
		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	public void rangeCheck(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Fora do limite do indice!");
	}

	public T get(int index) {
		return this.getNode(index).getElement();
	}

	public void removeFirst() {
		rangeCheck(size - 1);
		first = first.getNext();
		if (--size == 0)
			last = first;
	}

	public void removeLast() {
		if (size == 1)
			removeFirst();
		Node<T> previous = getNode(size - 2);
		previous.setNext(last.getNext());
		last = previous;
		--size;
	}

	public void remove(int index) {
		if (index == 0 || size == 1)
			removeFirst();
		else if (index == size - 1)
			removeLast();
		else {
			Node<T> current = getNode(index);
			Node<T> previous = getNode(index - 1);
			previous.setNext(current.getNext());
			current.setNext(last.getNext());
			current = last.getNext();
			--size;
		}
	}

	public void remove(T element) {
		remove(indexOf(element));
	}

	public boolean contains(T element) {
		return indexOf(element) >= 0;
	}

	public T get() {
		return actual.getElement();
	}

	public int size() {
		return size;
	}
	
	@SuppressWarnings("unused")
	public void clear() {
		if(!isEmpty()) {
			Node<T> aux = null;
			Node<T> current = aux = first;
			for(int i = 1; i < size; i++) {
				current = current.getNext();
				aux = null;
				aux = current;
			}
			first = last = null;
			size = 0;
		}
	}
	
	public int indexOf(T element) {
		Node<T> current = first;
		if (element == null)
			throw new NullPointerException("Objeto nulo!");
		if (element.equals(first.getElement()))
			return 0;
		else if (element.equals(last.getElement()))
			return size - 1;
		for (int i = 0; i < size; i++) {
			if (element.equals(current.getElement()))
				return i;
			current = current.getNext();
		}
		return -1;
	}

	public int lastIndexOf(T element) {
		if(element == null)
			throw new NullPointerException("Objeto nulo!");
		Node<T> current = last;
		if(element.equals(last.getElement()))
			return size - 1;
		for(int i = size - 2; i >= 0; i--) {
			current = getNode(i);
			if(element.equals(current.getElement()))
				return i;
		}
		return -1;
	}

	public boolean hasNext() {
		if (first == null)
			return false;
		else if (actual == null) {
			actual = first;
			return true;
		} else {
			boolean hasNext = actual.getNext() != null;
			actual = actual.getNext();
			return hasNext;
		}
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		while (this.hasNext()) {
			builder.append(this.get());
			builder.append(", ");
		}
		return removeDelimiter(builder);
	}

	private String removeDelimiter(CharSequence string) {
		String configure = string.subSequence(0, string.length() - 2).toString();
		configure += "]";
		return configure;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T element;
		private Node<T> next;

		private Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}

		private Node(T element) {
			this.element = element;
		}

		private Node<T> getNext() {
			return next;
		}

		private void setNext(Node<T> next) {
			this.next = next;
		}

		private T getElement() {
			return element;
		}
	}
}
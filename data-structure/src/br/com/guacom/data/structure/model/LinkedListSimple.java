package br.com.guacom.data.structure.model;

import java.util.Locale;

//A remoção em uma lista ligada simples leva tempo linear se não for no início ou fim. 
//Afinal, precisamos navegar na lista até achar o elemento antes e o depois do elemento a ser removido.

public class LinkedListSimple<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3370718357849371837L;
	private Node<T> first;
	private Node<T> last;
	private Node<T> nextItem;
	private int size;

	public LinkedListSimple() {}
	
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
		if (isEmpty())
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
		return this.getNode(index).getItem();
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
			Node<T> previous = getNode(index - 1);
			Node<T> delete = previous.getNext();
			previous.setNext(delete.getNext());
			delete.setNext(last.getNext());
			delete = last.getNext();
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
		return nextItem.getItem();
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
		if (element.equals(first.getItem()))
			return 0;
		else if (element.equals(last.getItem()))
			return size - 1;
		for (int i = 0; i < size; i++) {
			if (element.equals(current.getItem()))
				return i;
			current = current.getNext();
		}
		return -1;
	}

	public int lastIndexOf(T element) {
		if(element == null)
			throw new NullPointerException("Objeto nulo!");
		Node<T> current = last;
		if(element.equals(last.getItem()))
			return size - 1;
		for(int i = size - 2; i >= 0; i--) {
			current = getNode(i);
			if(element.equals(current.getItem()))
				return i;
		}
		return -1;
	}

	public boolean hasNext() {
		if (first == null)
			return false;
		else if (nextItem == null) {
			nextItem = first;
			return true;
		} else {
			boolean hasNext = nextItem.getNext() != null;
			nextItem = nextItem.getNext();
			return hasNext;
		}
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		while (hasNext()) {
			builder.append(this.get());
			builder.append(", ");
		}
		return removeDelimiter(builder);
	}

	private String removeDelimiter(CharSequence string) {
		String configure = string.subSequence(0, string.length() - 2).toString();
		return String.format(new Locale("pt", "BR"), "%s]", configure);
	}

	private static class Node<T> {
		T item;
		Node<T> next;

		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}

		@SuppressWarnings("unused")
		public Node(T item) {
			this.item = item;
		}

		private Node<T> getNext() {
			return next;
		}

		private void setNext(Node<T> next) {
			this.next = next;
		}

		private T getItem() {
			return item;
		}
	}
}
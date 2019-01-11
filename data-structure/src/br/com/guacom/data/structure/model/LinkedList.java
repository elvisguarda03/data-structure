package br.com.guacom.data.structure.model;

import java.util.Locale;
import java.util.NoSuchElementException;

//Lista duplamente ligada

//	Qual a diferença entre uma lista ligada simples e uma lista duplamente ligada?
//Na lista ligada simples a célula só aponta para a próxima célula da lista. 
//Já na lista duplamente ligada, a célula tem referências para a anterior e para a próxima. 
//A grande vantagem é que muitas operações necessitam também da célular anterior, e tudo fica mais fácil 
//com a referência armazenada em cada célula.

//	Tempo de remoção

//A remoção em uma lista ligada pode ser ou linear ou constante.
//Se você tiver a referência em mãos da célula que será deletada, então o tempo é constante. 
//Afinal, já que você tem anterior e proximo nas mãos, basta acertar as referências.
//Se você precisar procurar pelo elemento primeiro, então o tempo será linear, afinal passará por todas as células no pior caso.


//	Como funciona uma inserção de um elemento no meio de uma lista duplamente ligada?

//A célula X para entrar no meio de uma lista duplamente ligada precisa:
//
//Pegar a célula anterior e marcar o proximo dela como X
//Pegar a antiga célula proximo da anterior, e marcar a anterior dela como X
//Marcar anterior de X como a antiga anterior
//Marcar proxima de X como sendo a antiga proxima

//	Tempo de execução de inserção no inicio e no fim de uma lista.
//Em ambos o tempo é constante. Assim como na lista ligada simples, basta acertar as referências, 
//já que a estrutura armazena o primeiro e ultimo nós.

public class LinkedList<T> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8634364631500184993L;
	private Node<T> first;
	private Node<T> nextItem;
	private Node<T> last;
	private int size;

	public LinkedList() {
	}

	public boolean addFirst(T item) {
		if (item == null)
			throw new NullPointerException("Objeto inválido!");
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(item);
			last = first = newNode;
		} else {
			Node<T> newNode = new Node<T>(item, first);
			first.setPrev(newNode);
			first = newNode;
		}
		size++;
		return true;
	}

	public boolean addLast(T item) {
		if (isEmpty())
			return addFirst(item);
		else {
			if (item == null)
				throw new NullPointerException("Objeto inválido!");
			Node<T> newNode = new Node<T>(item, last.getNext());
			newNode.setPrev(last);
			last.setNext(newNode);
			last = newNode;
		}
		size++;
		return true;
	}

	private Node<T> getNode(int index) {
		checkElementIndex(index);
		Node<T> node = first;
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node;
	}

	public boolean add(int index, T item) {
		if ((isEmpty() || index == 0))
			return addFirst(item);
		else if (index == size)
			return addLast(item);
		else {
			if (item == null)
				throw new NullPointerException("Objeto inválido!");
			Node<T> previous = getNode(index - 1);
			Node<T> newNode = new Node<T>(item, previous.getNext(), previous);
			Node<T> next = newNode.getNext();
			next.setPrev(newNode);
			previous.setNext(newNode);
			size++;
		}
		return true;
	}
	
	public void removeFirst() {
		if (!isEmpty()) {
			Node<T> prox = first.getNext();
			if (size > 1)
				prox.setPrev(null);
			first = prox;
			if (--size == 0)
				last = first;
		}
	}

	// Consumo constante "O(1)"
	public void removeLast() {
		checkElementIndex(size - 1);
		if (size == 1)
			removeFirst();
		else {
			Node<T> prev = last.getPrev();
			prev.setNext(null);
			last = prev;
			--size;
		}
	}
	

	public void remove(int index) {
		if (index == 0)
			removeFirst();
		else if (index == size - 1)
			removeLast();
		else {
			Node<T> prev = getNode(index - 1);
			Node<T> delete = prev.getNext();
			Node<T> next = delete.getNext();
			prev.setNext(next);
			next.setPrev(prev);
			delete.item = null;
			delete.next = null;
			delete.prev = null;
			--size;
		}
	}

	public void remove(T item) {
		remove(indexOf(item));
	}

	public boolean contains(T item) {
		return indexOf(item) >= 0;
	}
	
	public void clear() {
		if(!isEmpty()) {
			for(Node<T> x = first; x != null; ){
				Node<T> next = x.next;
				x.item = null;
				x.next = null;
				x.prev = null;
				x = next;
			}
			first = last = null;
			size = 0;
		}
	}

	public int indexOf(T item) {
		if (item == null)
			throw new NullPointerException("Objeto inválido!");
		if (item.equals(first.getItem()))
			return 0;
		else if (item.equals(last.getItem()))
			return size - 1;
		else if (item.equals(last.getPrev().getItem()))
			return size - 2;
		else {
			Node<T> next = first.getNext();
			for (int i = 1; i < size; i++) {
				if (next.getItem().equals(item))
					return i;
				next = next.getNext();
			}
		}
		return -1;
	}

	public int lastIndexOf(T item) {
		if (item == null)
			throw new NullPointerException("Objeto inválido!");
		else if (item.equals(last.getItem()))
			return size - 1;
		else {
			Node<T> prev = last.getPrev();
			for (int i = size - 2; i >= 0; i--) {
				if (item.equals(prev.getItem()))
					return i;
				prev = prev.getPrev();
			}
		}
		return -1;
	}

	public T get(int index) {
		return this.getNode(index).item;
	}

	public T getFirst() {
		final Node<T> f = first;
		if(f == null)
			throw new NoSuchElementException();
		return f.item;
	}
	
	public T getLast() {
		final Node<T> l = last;
		if(l == null)
			throw new NoSuchElementException();
		return l.item;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";

		StringBuilder builder = new StringBuilder("[");

		for (Node<T> x = first; x != null; x = x.next) {
			builder.append(x.getItem());
			builder.append(", ");
		}
		return removeDelimiter(builder);
	}

	public T getNextItem() {
		return nextItem.getItem();
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

	private String removeDelimiter(CharSequence string) {
		return String.format(new Locale("pt", "BR"), "%s]", string.subSequence(0, string.length() - 2));
	}

	public int size() {
		return size;
	}

	private static class Node<T> {

		T item;
		Node<T> next;
		Node<T> prev;

		public Node(T item, Node<T> next, Node<T> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}

		public Node(T item) {
			this.item = item;
		}

		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}

		private Node<T> getNext() {
			return next;
		}

		private void setNext(Node<T> next) {
			this.next = next;
		}

		private Node<T> getPrev() {
			return prev;
		}

		private void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		private T getItem() {
			return item;
		}
	}
}
package br.com.guacom.data.structure.model;

import java.util.Arrays;

public class ArrayList<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3128594360605376378L;
	private T[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Tamanho inválido!");
		elementData = (T[]) new Object[initialCapacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public boolean add(T element) {
		ensureCapacity();
		if (element == null)
			throw new NullPointerException("Objeto está nulo!");
		elementData[size] = element;
		size++;
		return true;
	}

	public boolean add(int index, T element) {
		if (index == size)
			return add(element);
		if (element == null)
			throw new NullPointerException("Objeto está nulo!");
		rangeCheckForAdd(index);
		ensureCapacity();
		push(index);
		elementData[index] = element;
		size++;
		return true;
	}

	private void push(int index) {
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
	}

	public T get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	private void rangeCheck(int index) {
		rangeCheckForAdd(index);
	}

	private void rangeCheckForAdd(int index) {
		if (!(index >= 0 || index < size))
			throw new IllegalArgumentException("Posição inválida!");
	}

	private void rangeCheckForRemove(int index) {
		rangeCheckForAdd(index);
	}

	private void ensureCapacity() {
		if (elementData.length == size)
			elementData = Arrays.copyOf(elementData, size * 2);
	}

	public void remove(int index) {
		rangeCheckForRemove(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[--size] = null;
	}

	public void remove(T element) {
		remove(indexOf(element));
	}

	public boolean contains(T element) {
		return indexOf(element) >= 0;
	}

	public int indexOf(T o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i].equals(o))
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elementData[i].equals(o))
					return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(T o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elementData[i].equals(o))
					return i;
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (elementData[i].equals(o))
					return i;
			}
		}
		return -1;
	}

	public void clear() {
		if (!isEmpty()) {
			for(int i = 0; i < size; i++) {
				elementData[i] = null;
			}
			size = 0;
		}
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < size - 1; i++) {
			builder.append(elementData[i]);
			builder.append(", ");
		}
		if (!isEmpty())
			builder.append(elementData[size - 1]);
		builder.append("]");
		return builder.toString();
	}

	private boolean isEmpty() {
		return size == 0;
	}
}
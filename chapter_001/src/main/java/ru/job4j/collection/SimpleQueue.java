package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Возвращает элемент из очереди по FIFO.
     * @return первое значение.
     */
    public T poll() {
        if (out.getSize() == 0) {
            int index = in.getSize();
            for (int i = 0; i < index; i++) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Помещает значение в начало стека in.
     * @param value значение.
     */
    public void push(T value) {
        in.push(value);
    }
}

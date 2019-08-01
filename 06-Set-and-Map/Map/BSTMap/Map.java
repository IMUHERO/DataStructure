package IMUHERO;

public interface Map<K,V> {
    void add(K key ,V value);
    V get(K key);
    void set(K key, V newvalue);
    V remove(K key);
    boolean isEmpty();
    int getSize();
    boolean contains(K key);

}

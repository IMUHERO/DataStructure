package IMUHERO;
import com.sun.org.apache.xml.internal.security.Init;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.TreeMap;
public class HashTable<K,V> {
    private TreeMap<K,V> []hashTable;
    private int size;
    private int capacity;

    private final static int[] CapacityNum={53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private final static int Uppertol=10;
    private final static int Lowertol=2;
    private  int capacityIndex=0;

    public HashTable(){
        this.capacity=capacityIndex;
        hashTable=new TreeMap[capacity];
        size=0;
        for (int i=0;i<capacity;i++)
            hashTable[i]=new TreeMap<>();

    }

    private int hash(K key){
        return (key.hashCode()&0x7fffffff)%capacity;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(K key,V value){
        TreeMap<K,V> map=hashTable[hash(key)];
        if (!map.containsKey(key)){
            map.put(key,value);
        }
        else
            map.put(key,value);
            size++;
            if (size>Uppertol*capacity&&capacityIndex+1<CapacityNum.length){
                capacityIndex++;
                resize(CapacityNum[capacityIndex]);
            }
        }


    public V remove(K key){
        V ret=null;
        TreeMap<K, V> map=hashTable[hash(key)];
        if (!map.containsKey(key))throw new IllegalArgumentException("Don't contains"+key);
        if (map.containsKey(key)){
            ret=map.remove(key);
            size--;
            if (size<capacity*Lowertol&&capacityIndex-1>=0){
                capacityIndex--;
                resize(CapacityNum[capacityIndex]);
            }
        }
        return ret;
    }

    public V get(K key){
        V ret=null;
        TreeMap<K,V> map=hashTable[hash(key)];
        if (!map.containsKey(key))throw new IllegalArgumentException("Don't contains"+key);
        if (map.containsKey(key)){
            ret=map.get(key);
        }
        return ret;
    }

    public void set(K key,V value){
        TreeMap<K,V> map=hashTable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");
        map.put(key,value);

    }

    public boolean contains(K key){
        return hashTable[hash(key)].containsKey(key);
    }

    private void resize(int newCapacity){
        TreeMap<K,V>[]newHashmap=new TreeMap[newCapacity];
        int oldCapacity=capacity;
        this.capacity=newCapacity;
        for (int i=0;i<newCapacity;i++){
            newHashmap[i]=new TreeMap<>();
        }
        for (int i=0;i<newCapacity;i++){
            TreeMap<K,V> map=hashTable[i];
            for (K key:map.keySet()){
                newHashmap[hash(key)].put(key,map.get(key));

            }
            this.hashTable=newHashmap;

        }
    }



}

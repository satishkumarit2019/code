package practice;

import java.time.LocalDateTime;
import java.util.*;

/**
 * LRU Cache Implementation
 * Problem: Implement an LRU (Least Recently Used) Cache with the following operations:
 *
 * get(key): Retrieve the value of the key if the key exists.
 * put(key, value): Insert or update the value of the key. If the cache reaches capacity, evict the least recently used item.
 * Use Java's LinkedHashMap or implement with a doubly linked list + hashmap.
 */
public class Test234456754535 {
    public static void main(String[] args) {
        Cache<String,Integer> cache=new LruCache<String,Integer>(4);
        cache.put("1", 100000000);
        cache.put("2", 200000000);
        cache.put("3", 300000000);
        cache.put("4", 400000000);
        System.out.println("---------> "+cache.get("1"));
        System.out.println("---------> "+cache.get("2"));
        cache.put("5", 500000000);
        cache.put("6", 600000000);
        System.out.println("---------> "+cache.get("2"));
        cache.put("7", 700000000);
        System.out.println("---------> "+cache.get("1"));
        System.out.println("---------> "+cache.get("2"));
        System.out.println("---------> "+cache.size());
        cache.reset();
        System.out.println("---------> "+cache.size());
        int capacity=10;
    }
}

interface Cache<K,V>  {
    public void put(K key, V value);
    public V get(K key);
    public int size();
    public void reset();

}

abstract class BaseCache<K,V>  implements  Cache<K,V>{
    public final int capacity;
    BaseCache(int capacity){
        this.capacity=capacity;

    }

    protected static class Item<K,V> {
        V value;
        K key;
        LocalDateTime time;
        Item(K key, V value){
            this.value = value;
            this.key = key;
            time=LocalDateTime.now();
        }
        public LocalDateTime getTime(){
            return time;
        }
        public V getValue(){
            return this.value;
        }
        public K getKey(){
            return this.key;
        }

        public void updateAccessTime(){
            this.time=LocalDateTime.now();
        }

        @Override
        public String toString() {
            return "Item{" +
                    " key=" + key +
                    ", value=" + value +
                    ", time=" + time +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item<?, ?> item = (Item<?, ?>) o;
            return Objects.equals(value, item.value) && Objects.equals(key, item.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, key, time);
        }
    };
}

class LruCache<K extends String,V>  extends BaseCache<K,V>   {

    private Map<K,V> itemList= null;

    LruCache(int capacity){
        super(capacity);
        itemList=new LinkedHashMap<K,V>(capacity, 0.75F,true){
            @Override
            public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return this.size()>capacity;
            }

        };
    }

    public void put(K key, V value){
        itemList.put(key,value);
    }

    @Override
    public V get(K key){
        return itemList.get(key);
    }

    @Override
    public int size() {
        return itemList.size();
    }

    @Override
    public void reset() {
        itemList.clear();
    }

}
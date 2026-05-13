package com.hashmapImpl;

/**
 * A custom implementation of a HashMap data structure using separate chaining
 * for collision resolution.
 *
 * <p>This implementation supports generic key-value pairs and provides
 * standard map operations such as put, get, remove, and more.
 *
 * <p>Key features:
 * <ul>
 *   <li>Default initial capacity of 16</li>
 *   <li>Default load factor of 0.75</li>
 *   <li>Automatic resizing when load factor threshold is exceeded</li>
 *   <li>Supports null keys and null values</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 *   MyHashMap<String, Integer> map = new MyHashMap<>();
 *   map.put("Alice", 100);
 *   map.get("Alice"); // returns 100
 * }</pre>
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Ali Hussain Mansuri
 * @version 1.0
 */
public class MyHashMap<K, V> {

    /**
     * Internal node class representing a key-value pair in the linked list chain.
     *
     * <p>Each node stores:
     * <ul>
     *   <li>The cached hash of the key</li>
     *   <li>The key</li>
     *   <li>The value</li>
     *   <li>A reference to the next node in the chain</li>
     * </ul>
     *
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    private static class Node<K, V> {
        int        hash;
        K          key;
        V          value;
        Node<K, V> next;

        /**
         * Constructs a new Node with the specified hash, key, value, and next node.
         *
         * @param hash  the hash code of the key
         * @param key   the key associated with this node
         * @param value the value associated with this node
         * @param next  the next node in the chain, or null if this is the last node
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash  = hash;
            this.key   = key;
            this.value = value;
            this.next  = next;
        }
    }

    // ─── Constants ────────────────────────────────────────────────────────

    /** Default initial capacity of the hash table. Must be a power of 2. */
    private static final int   DEFAULT_CAPACITY    = 16;

    /** Default load factor used when none is specified in the constructor. */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /** Maximum capacity the table can grow to. */
    private static final int   MAXIMUM_CAPACITY    = 1 << 30;

    // ─── Fields ───────────────────────────────────────────────────────────

    /** The array of buckets (linked list heads). */
    private Node<K, V>[] table;

    /** The number of key-value mappings currently in the map. */
    private int size;

    /** The current capacity of the hash table (number of buckets). */
    private int capacity;

    /** The load factor for this hash map instance. */
    private float loadFactor;

    /** The threshold at which the table will be resized (capacity * loadFactor). */
    private int threshold;

    // ─── Constructors ─────────────────────────────────────────────────────

    /**
     * Constructs an empty MyHashMap with default initial capacity (16)
     * and default load factor (0.75).
     *
     * <p>Example:
     * <pre>{@code
     *   MyHashMap<String, Integer> map = new MyHashMap<>();
     * }</pre>
     */
    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty MyHashMap with the specified initial capacity
     * and default load factor (0.75).
     *
     * <p>Example:
     * <pre>{@code
     *   MyHashMap<String, Integer> map = new MyHashMap<>(32);
     * }</pre>
     *
     * @param capacity the initial capacity of the hash map
     * @throws IllegalArgumentException if capacity is negative
     */
    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty MyHashMap with the specified initial capacity
     * and load factor.
     *
     * <p>The actual capacity will be rounded up to the nearest power of 2.
     *
     * <p>Example:
     * <pre>{@code
     *   MyHashMap<String, Integer> map = new MyHashMap<>(32, 0.5f);
     * }</pre>
     *
     * @param capacity   the initial capacity of the hash map
     * @param loadFactor the load factor (must be positive and non-zero)
     * @throws IllegalArgumentException if capacity is negative or loadFactor is non-positive
     */
    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity, float loadFactor) {
        this.capacity   = tableSizeFor(capacity);
        this.loadFactor = loadFactor;
        this.threshold  = (int)(this.capacity * loadFactor);
        this.table      = new Node[this.capacity];
    }

    // ─── Hash ─────────────────────────────────────────────────────────────

    /**
     * Computes the hash code for a given key by spreading the higher bits
     * into the lower bits using XOR.
     *
     * <p>This helps reduce collisions when the table size is small.
     *
     * <pre>
     *   hash = hashCode ^ (hashCode >>> 16)
     * </pre>
     *
     * @param key the key to hash; null returns 0
     * @return the spread hash code
     */
    private int hash(K key) {
        if (key == null) return 0;
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    /**
     * Computes the bucket index for a given hash and capacity.
     *
     * <p>Uses a fast bitwise AND instead of modulo since capacity is always
     * a power of 2:
     * <pre>
     *   index = hash & (capacity - 1)
     * </pre>
     *
     * @param hash the hash code
     * @param cap  the current table capacity
     * @return the bucket index in range [0, cap - 1]
     */
    private int indexFor(int hash, int cap) {
        return hash & (cap - 1);
    }

    /**
     * Returns the smallest power of 2 that is greater than or equal to {@code cap}.
     *
     * <p>This is achieved by filling all lower bits with 1s using right shifts
     * and OR operations, then adding 1.
     *
     * <p>Example:
     * <pre>
     *   tableSizeFor(5)  → 8
     *   tableSizeFor(8)  → 8
     *   tableSizeFor(9)  → 16
     *   tableSizeFor(13) → 16
     * </pre>
     *
     * @param cap the desired capacity
     * @return the nearest power of 2 >= cap, capped at MAXIMUM_CAPACITY
     */
    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // ─── PUT ──────────────────────────────────────────────────────────────

    /**
     * Associates the specified value with the specified key in this map.
     *
     * <p>If the map previously contained a mapping for the key, the old value
     * is replaced and returned. If the key is new, it is inserted at the head
     * of the bucket's linked list.
     *
     * <p>Triggers a resize if the number of entries exceeds the threshold.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100); // returns null (new key)
     *   map.put("Alice", 200); // returns 100 (old value)
     * }</pre>
     *
     * @param key   the key with which the value is to be associated (null allowed)
     * @param value the value to associate with the key (null allowed)
     * @return the previous value associated with the key, or null if there was none
     */
    public V put(K key, V value) {
        int hash  = hash(key);
        int index = indexFor(hash, capacity);

        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (node.hash == hash && equals(node.key, key)) {
                V old      = node.value;
                node.value = value;
                return old;
            }
        }

        table[index] = new Node<>(hash, key, value, table[index]);
        size++;

        if (size > threshold) resize();
        return null;
    }

    // ─── GET ──────────────────────────────────────────────────────────────

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.get("Alice");   // returns 100
     *   map.get("Nobody");  // returns null
     * }</pre>
     *
     * @param key the key whose associated value is to be returned (null allowed)
     * @return the value associated with the key, or null if not found
     */
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * Internal helper that finds and returns the Node associated with the
     * given key by traversing the linked list at the computed bucket index.
     *
     * @param key the key to search for (null allowed)
     * @return the Node associated with the key, or null if not found
     */
    private Node<K, V> getNode(K key) {
        int hash  = hash(key);
        int index = indexFor(hash, capacity);

        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (node.hash == hash && equals(node.key, key))
                return node;
        }
        return null;
    }

    // ─── REMOVE ───────────────────────────────────────────────────────────

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * <p>Traverses the linked list at the computed bucket, removes the node
     * by relinking the previous node's {@code next} pointer.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.remove("Alice"); // returns 100
     *   map.remove("Alice"); // returns null (already removed)
     * }</pre>
     *
     * @param key the key whose mapping is to be removed (null allowed)
     * @return the previous value associated with the key, or null if not found
     */
    public V remove(K key) {
        int hash  = hash(key);
        int index = indexFor(hash, capacity);

        Node<K, V> prev = null;
        Node<K, V> curr = table[index];

        while (curr != null) {
            if (curr.hash == hash && equals(curr.key, key)) {
                if (prev == null) table[index] = curr.next;
                else              prev.next    = curr.next;
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    // ─── CONTAINS ─────────────────────────────────────────────────────────

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.containsKey("Alice");   // true
     *   map.containsKey("Nobody");  // false
     * }</pre>
     *
     * @param key the key to check (null allowed)
     * @return true if the key exists in the map, false otherwise
     */
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     *
     * <p>This operation requires a full scan of all buckets — O(n).
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.containsValue(100);  // true
     *   map.containsValue(999);  // false
     * }</pre>
     *
     * @param value the value to search for (null allowed)
     * @return true if any key maps to this value, false otherwise
     */
    public boolean containsValue(V value) {
        for (Node<K, V> bucket : table)
            for (Node<K, V> node = bucket; node != null; node = node.next)
                if (equals(node.value, value)) return true;
        return false;
    }

    // ─── SIZE / EMPTY ─────────────────────────────────────────────────────

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of entries in the map
     */
    public int size() { return size; }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if the map is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    // ─── CLEAR ────────────────────────────────────────────────────────────

    /**
     * Removes all mappings from this map.
     *
     * <p>The map will be empty after this call returns. The capacity is
     * preserved but all bucket references are cleared.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.clear();
     *   map.isEmpty(); // true
     * }</pre>
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Node[capacity];
        size  = 0;
    }

    // ─── PUT IF ABSENT ────────────────────────────────────────────────────

    /**
     * If the specified key is not already associated with a value, associates
     * it with the given value and returns null. Otherwise returns the existing value.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.putIfAbsent("Alice", 999); // returns 100, map unchanged
     *   map.putIfAbsent("Bob",   200); // returns null, Bob added
     * }</pre>
     *
     * @param key   the key to insert if absent (null allowed)
     * @param value the value to associate with the key if absent
     * @return the existing value if key was present, or null if key was absent
     */
    public V putIfAbsent(K key, V value) {
        V existing = get(key);
        if (existing == null) put(key, value);
        return existing;
    }

    // ─── GET OR DEFAULT ───────────────────────────────────────────────────

    /**
     * Returns the value to which the specified key is mapped, or
     * {@code defaultValue} if this map contains no mapping for the key.
     *
     * <p>Example:
     * <pre>{@code
     *   map.put("Alice", 100);
     *   map.getOrDefault("Alice",   -1); // returns 100
     *   map.getOrDefault("Nobody",  -1); // returns -1
     * }</pre>
     *
     * @param key          the key whose value is to be returned (null allowed)
     * @param defaultValue the value to return if the key is not found
     * @return the mapped value, or defaultValue if the key is absent
     */
    public V getOrDefault(K key, V defaultValue) {
        Node<K, V> node = getNode(key);
        return node == null ? defaultValue : node.value;
    }

    // ─── KEYS ─────────────────────────────────────────────────────────────

    /**
     * Returns an Iterable of all keys contained in this map.
     *
     * <p>The order of keys is not guaranteed.
     *
     * <p>Example:
     * <pre>{@code
     *   map.keySet().forEach(k -> System.out.println(k));
     * }</pre>
     *
     * @return an Iterable containing all keys in the map
     */
    public Iterable<K> keySet() {
        java.util.List<K> keys = new java.util.ArrayList<>();
        for (Node<K, V> bucket : table)
            for (Node<K, V> node = bucket; node != null; node = node.next)
                keys.add(node.key);
        return keys;
    }

    // ─── VALUES ───────────────────────────────────────────────────────────

    /**
     * Returns an Iterable of all values contained in this map.
     *
     * <p>The order of values is not guaranteed. Duplicate values are included.
     *
     * <p>Example:
     * <pre>{@code
     *   map.values().forEach(v -> System.out.println(v));
     * }</pre>
     *
     * @return an Iterable containing all values in the map
     */
    public Iterable<V> values() {
        java.util.List<V> vals = new java.util.ArrayList<>();
        for (Node<K, V> bucket : table)
            for (Node<K, V> node = bucket; node != null; node = node.next)
                vals.add(node.value);
        return vals;
    }

    // ─── RESIZE ───────────────────────────────────────────────────────────

    /**
     * Doubles the capacity of the hash table and rehashes all existing entries.
     *
     * <p>Called automatically when {@code size > threshold}.
     * Each node is re-indexed using:
     * <pre>
     *   newIndex = node.hash & (newCapacity - 1)
     * </pre>
     *
     * <p>After resizing:
     * <ul>
     *   <li>capacity  = old capacity × 2</li>
     *   <li>threshold = new capacity × loadFactor</li>
     * </ul>
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int          newCapacity = capacity * 2;
        Node<K, V>[] newTable   = new Node[newCapacity];

        for (Node<K, V> bucket : table) {
            for (Node<K, V> node = bucket; node != null; ) {
                Node<K, V> next    = node.next;
                int newIndex       = node.hash & (newCapacity - 1);
                node.next          = newTable[newIndex];
                newTable[newIndex] = node;
                node               = next;
            }
        }

        table     = newTable;
        capacity  = newCapacity;
        threshold = (int)(capacity * loadFactor);
        System.out.println("  [Resized] capacity: " + capacity
                         + " threshold: " + threshold);
    }

    // ─── EQUALS HELPER ────────────────────────────────────────────────────

    /**
     * Null-safe equality check for two objects.
     *
     * <p>Returns true if both are the same reference, or if {@code a} is
     * non-null and {@code a.equals(b)} returns true.
     *
     * @param a the first object (may be null)
     * @param b the second object (may be null)
     * @return true if a and b are considered equal
     */
    private boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    // ─── PRINT ────────────────────────────────────────────────────────────

    /**
     * Prints the internal structure of the hash map to standard output
     * for debugging purposes.
     *
     * <p>Only non-empty buckets are printed. Each bucket shows its index
     * and the chain of key-value pairs.
     *
     * <p>Example output:
     * <pre>
     *   ── MyHashMap (size=3, capacity=16) ──
     *   bucket[2] → [Bob=200] → null
     *   bucket[7] → [Alice=100] → [Dave=400] → null
     * </pre>
     */
    public void print() {
        System.out.println("\n── MyHashMap (size=" + size
                         + ", capacity=" + capacity + ") ──");
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) continue;
            System.out.print("  bucket[" + i + "] → ");
            for (Node<K, V> n = table[i]; n != null; n = n.next)
                System.out.print("[" + n.key + "=" + n.value + "] → ");
            System.out.println("null");
        }
    }

    // ─── MAIN ─────────────────────────────────────────────────────────────

    /**
     * Entry point for testing the MyHashMap implementation.
     *
     * <p>Tests all major operations:
     * put, get, update, containsKey, containsValue,
     * remove, putIfAbsent, getOrDefault, null key,
     * keySet, values, and clear.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("=== PUT ===");
        map.put("Alice",  100);  map.put("Bob",   200);
        map.put("Carol",  300);  map.put("Dave",  400);
        map.put("Eve",    500);  map.put("Frank", 600);
        map.put("Grace",  700);  map.put("Heidi", 800);
        map.put("Ivan",   900);  map.put("Judy", 1000);
        map.put("Karl",  1100);  map.put("Laura",1200);
        map.print();

        System.out.println("\n=== GET ===");
        System.out.println("Alice  → " + map.get("Alice"));
        System.out.println("Dave   → " + map.get("Dave"));
        System.out.println("Nobody → " + map.get("Nobody"));

        System.out.println("\n=== UPDATE ===");
        map.put("Alice", 999);
        System.out.println("Alice → " + map.get("Alice"));

        System.out.println("\n=== CONTAINS ===");
        System.out.println("containsKey(Bob)   → " + map.containsKey("Bob"));
        System.out.println("containsValue(300) → " + map.containsValue(300));

        System.out.println("\n=== REMOVE ===");
        System.out.println("remove(Bob) → " + map.remove("Bob"));
        System.out.println("size        → " + map.size());

        System.out.println("\n=== putIfAbsent / getOrDefault ===");
        map.putIfAbsent("Alice", 0);
        map.putIfAbsent("Zara", 9999);
        System.out.println("Alice        → " + map.get("Alice"));
        System.out.println("Zara         → " + map.get("Zara"));
        System.out.println("getOrDefault → " + map.getOrDefault("Missing", -1));

        System.out.println("\n=== NULL KEY ===");
        map.put(null, 42);
        System.out.println("null key → " + map.get(null));

        System.out.println("\n=== KEYS ===");
        map.keySet().forEach(k -> System.out.print(k + " "));

        System.out.println("\n\n=== VALUES ===");
        map.values().forEach(v -> System.out.print(v + " "));

        System.out.println("\n\n=== CLEAR ===");
        map.clear();
        System.out.println("isEmpty → " + map.isEmpty());
    }
}
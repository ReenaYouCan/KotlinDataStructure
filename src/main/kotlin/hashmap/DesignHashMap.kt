package hashmap

import java.util.*


class DesignHashMap {
}

internal class Pair<U, V>(var first: U, var second: V)


internal class Bucket {
    private val bucket: MutableList<Pair<Int, Int>>

    init {
        bucket = LinkedList()
    }

    operator fun get(key: Int): Int {
        for (pair in bucket) {
            if (pair.first == key) return pair.second
        }
        return -1
    }

    fun update(key: Int, value: Int) {
        var found = false
        for (pair in bucket) {
            if (pair.first == key) {
                pair.second = value
                found = true
            }
        }
        if (!found) bucket.add(Pair(key, value))
    }

    fun remove(key: Int) {
        for (pair in bucket) {
            if (pair.first == key) {
                bucket.remove(pair)
                break
            }
        }
    }
}

internal class MyHashMap {
    private val key_space = 2069
    private val hash_table: MutableList<Bucket>

    /** Initialize your data structure here.  */
    init {
        hash_table = ArrayList()
        for (i in 0 until key_space) {
            hash_table.add(Bucket())
        }
    }

    /** value will always be non-negative.  */
    fun put(key: Int, value: Int) {
        val hash_key = key % key_space
        hash_table[hash_key].update(key, value)
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    operator fun get(key: Int): Int {
        val hash_key = key % key_space
        return hash_table[hash_key][key]
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key  */
    fun remove(key: Int) {
        val hash_key = key % key_space
        hash_table[hash_key].remove(key)
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
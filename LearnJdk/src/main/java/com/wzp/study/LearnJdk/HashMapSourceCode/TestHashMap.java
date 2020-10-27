package com.wzp.study.LearnJdk.HashMapSourceCode;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap(10, 0.75f);

        map.put("wzp", "shuai");
        map.put("zyp", "chou");

        //源码过程
        //1.hashmap的构造方法
        /*
        public HashMap( int initialCapacity, float loadFactor){
         　　//此处对传入的初始容量进行校验，最大不能超过MAXIMUM_CAPACITY = 1<<30(2^30)
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal initial capacity: " +
                        initialCapacity);
            if (initialCapacity > MAXIMUM_CAPACITY)
                initialCapacity = MAXIMUM_CAPACITY;
            if (loadFactor <= 0 || Float.isNaN(loadFactor))
                throw new IllegalArgumentException("Illegal load factor: " +
                        loadFactor);

            this.loadFactor = loadFactor;
            threshold = initialCapacity;

            init();//init方法在HashMap中没有实际实现，不过在其子类如 linkedHashMap中就会有对应实现
        }
        */

        //put 源码
/*        public V put(K key, V value) {
            //如果table数组为空数组{}，进行数组填充（为table分配实际内存空间），入参为threshold，此时threshold为initialCapacity 默认是1<<4(2^4=16)
            if (table == EMPTY_TABLE) {
                //put 1
                inflateTable(threshold);
            }
            //如果key为null，存储位置为table[0]或table[0]的冲突链上
            if (key == null)
                return putForNullKey(value);
            //put 2
            int hash = hash(key);//对key的hashcode进一步计算，确保散列均匀
            //put 3
            int i = indexFor(hash, table.length);//获取在table中的实际位置
            for (Entry<K,V> e = table[i]; e != null; e = e.next) {
                //如果该对应数据已存在，执行覆盖操作。用新value替换旧value，并返回旧value
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    e.recordAccess(this);
                    return oldValue;
                }
            }
            modCount++;//保证并发访问时，若HashMap内部结构发生变化，快速响应失败
            //put 4
            addEntry(hash, key, value, i);//新增一个entry
            return null;
        }*/

        //put 1
/*        private void inflateTable(int toSize) {
            //put 1.1
            int capacity = roundUpToPowerOf2(toSize);//capacity一定是2的次幂
            threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);//此处为threshold赋值，取capacity*loadFactor和MAXIMUM_CAPACITY+1的最小值，capaticy一定不会超过MAXIMUM_CAPACITY，除非loadFactor大于1
            table = new Entry[capacity];
            initHashSeedAsNeeded(capacity);
        }*/

        //put 1.1
//        private static int roundUpToPowerOf2(int number) {
//            // assert number >= 0 : "number must be non-negative";
//            return number >= MAXIMUM_CAPACITY
//                    ? MAXIMUM_CAPACITY
//                    : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
//        }


        //put 2
        //这是一个神奇的函数，用了很多的异或，移位等运算，对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀
/*        final int hash(Object k) {
            int h = hashSeed;
            if (0 != h && k instanceof String) {
                return sun.misc.Hashing.stringHash32((String) k);
            }

            h ^= k.hashCode();

            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }*/

        //put 3
/*        static int indexFor(int h, int length) {
            return h & (length-1);
        }*/

        //put 4
//        void addEntry(int hash, K key, V value, int bucketIndex) {
//            if ((size >= threshold) && (null != table[bucketIndex])) {
//                resize(2 * table.length);//当size超过临界阈值threshold，并且即将发生哈希冲突时进行扩容
//                hash = (null != key) ? hash(key) : 0;
//                bucketIndex = indexFor(hash, table.length);
//            }
//            头插法
//            createEntry(hash, key, value, bucketIndex);
//        }

    }
}

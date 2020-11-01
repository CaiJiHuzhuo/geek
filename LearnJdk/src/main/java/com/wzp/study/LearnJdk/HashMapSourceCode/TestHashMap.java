package com.wzp.study.LearnJdk.HashMapSourceCode;

import java.util.ConcurrentModificationException;
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
            //put 4
            modCount++;//保证并发访问时，若HashMap内部结构发生变化，快速响应失败
            //put 5
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
        //扰动函数，这是一个神奇的函数，用了很多的异或，移位等运算，对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀
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
        //从这里可以看出为什么hashmap的容量为2的幂次方，因为length-1之后的二进制都为1 例如：16：0001 0000 16-1 ：0000 1111，这样&h值之后，index的值就正好散列在0-15的范围内。
/*        static int indexFor(int h, int length) {
            return h & (length-1);
        }*/

        //put 4
//        快速失败机制，当循环中使用hashmap.remove()删除元素时，会报异常
//        比如在并发情况下，一个线程在循环遍历，一个线程循环添加，会导致线程安全问题，
//        每次修改会导致modCount++
//        所以hashmap在遍历时底层迭代器首先会expectedModCount = modCount;
//        然后在每次next时会比较
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();

        //put 5
//        void addEntry(int hash, K key, V value, int bucketIndex) {
              //resize1 两个条件
//            if ((size >= threshold) && (null != table[bucketIndex])) {
                  //resize2
//                resize(2 * table.length);//当size超过临界阈值threshold，并且即将发生哈希冲突时进行扩容
//                hash = (null != key) ? hash(key) : 0;
//                bucketIndex = indexFor(hash, table.length);
//            }
//            头插法
              //put 5.1
//            createEntry(hash, key, value, bucketIndex);
//        }

          //put 5.1
        //先取出index位置上的元素，然后新建一个链表的头元素，next为原先的元素，再把新元素放到数组的位置
//        void createEntry(int hash, K key, V value, int bucketIndex) {
//            Entry<K,V> e = table[bucketIndex];
//            table[bucketIndex] = new Entry<>(hash, key, value, e);
//            size++;
//        }

        //resize2
//        void resize(int newCapacity) {
//            Entry[] oldTable = table;//老的数据
//            int oldCapacity = oldTable.length;//获取老的容量值
//            if (oldCapacity == MAXIMUM_CAPACITY) {//老的容量值已经到了最大容量值
//                threshold = Integer.MAX_VALUE;//修改扩容阀值
//                return;
//            }
//            //新的结构
//            Entry[] newTable = new Entry[newCapacity];
            //resize 2.1
            //initHashSeedAsNeeded(newCapacity) 是否需要重新计算hash值
//            transfer(newTable, initHashSeedAsNeeded(newCapacity));//将老的表中的数据拷贝到新的结构中
//            table = newTable;//修改HashMap的底层数组
//            threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);//修改阀值
//        }


//        void transfer(Entry[] newTable, boolean rehash) {
//            int newCapacity = newTable.length;//容量
//            for (Entry<K,V> e : table) { //遍历所有桶
//                while(null != e) {  //遍历桶中所有元素（是一个链表）
//                    Entry<K,V> next = e.next;
//                    if (rehash) {//如果是重新Hash，则需要重新计算hash值
//                        e.hash = null == e.key ? 0 : hash(e.key);
//                    }
//                    int i = indexFor(e.hash, newCapacity);//定位Hash桶
//                    e.next = newTable[i];//元素连接到桶中,这里相当于单链表的插入，总是插入在最前面
//                    newTable[i] = e;//newTable[i]的值总是最新插入的值
//                    e = next;//继续下一个元素
//                }
//            }
//        }


//        hashmap的链表死循环问题
//          1.hashmap并发插入,导致hashmap扩容，由于hashmap采用的是头插法，当一个线程扩容完之后，链表的顺序发生了颠倒，此时另一个线程再去扩容，就会发现此时的next元素变成了他的上一个元素，导致链表死循环。




    }
}

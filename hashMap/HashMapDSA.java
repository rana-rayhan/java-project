import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapDSA {
    public HashMapDSA() {

    }

    public static class HashMapClass<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        int nodeList;
        int bucketLength = 4;
        LinkedList<Node>[] buckets;

        public HashMapClass() {
            this.buckets = new LinkedList[this.bucketLength];

            for (int i = 0; i < this.buckets.length; ++i) {
                this.buckets[i] = new LinkedList<>();
            }

        }

        private int bucketIndex(K key) {
            return Math.abs(key.hashCode()) % this.bucketLength;
        }

        private int searchNodeIdx(K key, int bIdx) {
            LinkedList<Node> ll = this.buckets[bIdx];

            for (int i = 0; i < ll.size(); ++i) {
                if (ll.get(i).key.equals(key)) { // Compare keys using equals() method
                    return i;
                }
            }

            return -1;
        }

        private void reHash() {
            LinkedList<Node>[] oldBucket = this.buckets;
            this.nodeList = 0;
            this.bucketLength *= 2;
            this.buckets = new LinkedList[this.bucketLength];

            for (int i = 0; i < this.bucketLength; ++i) {
                this.buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> ll : oldBucket) {
                for (Node node : ll) {
                    this.put(node.key, node.value);
                }
            }
        }

        public void put(K key, V val) {
            int bIdx = this.bucketIndex(key);
            int nIdx = this.searchNodeIdx(key, bIdx);
            Node node = new Node(key, val);
            if (nIdx == -1) {
                this.buckets[bIdx].add(node);
                ++this.nodeList;
            } else {
                node.value = val;
            }

            double lambda = (double) this.nodeList / (double) this.bucketLength;
            if (lambda > 2.0) {
                this.reHash();
            }
        }

        public V get(K key) {
            int bIdx = this.bucketIndex(key);
            int nIdx = this.searchNodeIdx(key, bIdx);
            return nIdx == -1 ? null : this.buckets[bIdx].get(nIdx).value;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : this.buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean containsKey(K key) {
            int bIdx = this.bucketIndex(key);
            int nIdx = this.searchNodeIdx(key, bIdx);
            return nIdx != -1;
        }

        public boolean isEmpty() {
            return this.nodeList == 0;
        }

        public V remove(K key) {
            int bIdx = this.bucketIndex(key);
            int nIdx = this.searchNodeIdx(key, bIdx);
            if (nIdx == -1) {
                return null;
            } else {
                Node node = this.buckets[bIdx].remove(nIdx);
                --this.nodeList;
                return node.value;
            }
        }

    }

    public static void main(String[] args) {
        HashMapClass<String, Integer> map = new HashMapClass<>();
        map.put("Bangladesh", 20);
        map.put("India", 30);
        map.put("Finland", 40);
        ArrayList<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String k = iterator.next();
            System.out.println(k + ": " + map.remove(k));
        }

        System.out.println(map.nodeList);
    }
}

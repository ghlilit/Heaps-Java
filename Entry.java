public class Entry<V> {
        private int k;
        private V v;

        public Entry(int k, V v){
            this.k = k;
            this.v = v;
        }
        public int getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public void setK(int k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }
}

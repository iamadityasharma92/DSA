class MyHashSet {
        boolean mset[] = new boolean[1000001];
    public MyHashSet() {
        Arrays.fill(mset,false);
    }
    
    public void add(int key) {
        mset[key]=true;
    }
    
    public void remove(int key) {
        mset[key]=false;
    }
    
    public boolean contains(int key) {
        return mset[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
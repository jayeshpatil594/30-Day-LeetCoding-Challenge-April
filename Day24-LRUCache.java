class LRUCache {

    class doublyLinkedListNode{
        int key;
        int value;
        doublyLinkedListNode prev;
        doublyLinkedListNode next;
        
    public doublyLinkedListNode(int key , int value){
        this.key = key;
        this.value = value;
    }
    }
    
    private HashMap<Integer, doublyLinkedListNode> cache;
    private int capacity,count;
    private doublyLinkedListNode head, tail;
    
    public void deleteNode(doublyLinkedListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(doublyLinkedListNode node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new doublyLinkedListNode(0,0);
        tail = new doublyLinkedListNode(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    
    public int get(int key) {
        if(cache.get(key) != null){
            doublyLinkedListNode node = cache.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.get(key) != null){
            doublyLinkedListNode node = cache.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else{
            doublyLinkedListNode node = new doublyLinkedListNode(key, value);
            cache.put(key, node);
            if(count < capacity){
                count++;
                addToHead(node);
            }
            else{
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
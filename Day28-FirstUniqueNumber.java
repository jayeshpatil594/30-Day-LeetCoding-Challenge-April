class FirstUnique {
    
    class DLL{
        int val;
        DLL prev;
        DLL next;
        public DLL(int val){
            this.val = val;
        }
    }
    Map<Integer, DLL> cache;
    DLL head;
    DLL tail;
    public FirstUnique(int[] nums){
        head = new DLL(-1);
        tail = new DLL(-1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        for(int num : nums){
            if(cache.containsKey(num)){
                DLL node =cache.get(num); 
                deleteNode(node);
            }
            else{
                DLL new_node = new DLL(num);
                cache.put(num, new_node);
                insertAtTail(new_node);
            }
        }
    }
    
    public int showFirstUnique(){
        return head.next==tail? -1 : head.next.val;
    }
    public void add(int value){
        if(cache.containsKey(value)){
            DLL node = cache.get(value);
            deleteNode(node);
        }
        else{
            DLL new_node = new DLL(value);
            cache.put(value, new_node);
            insertAtTail(new_node);
        }
    }
     public void deleteNode(DLL node){
        DLL nextNode = node.next;
        DLL prevNode = node.prev;
        if(prevNode != null && nextNode != null){
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node.next = null;
            node.prev = null;
        }
    }
    public void insertAtTail(DLL new_node){
        DLL prev = tail.prev;
        prev.next = new_node;
        new_node.prev = prev;
        new_node.next = tail;
        tail.prev = new_node;
    }
   
}
    
/*
    Set<Integer> set;
    Set<Integer> all;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(!all.contains(nums[i]))
            {
                all.add(nums[i]);
                set.add(nums[i]);
            }
            else
            {
                if(set.contains(nums[i]))
                    set.remove(nums[i]);
            }
        }
    }
    
    public int showFirstUnique() {
        if(set.size()==0)
            return -1;
        return set.iterator().next();
    }
    
    public void add(int value) {
        if(!all.contains(value))
        {
            all.add(value);
            set.add(value);
        }
        else
        {
            if(set.contains(value))
                set.remove(value);
        }
    }*/


/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
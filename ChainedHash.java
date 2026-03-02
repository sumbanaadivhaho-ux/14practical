class ChainedHash{
    int m; 
    Node[] table;

    public ChainedHash(int m) {
        this.m = m;
        table = new Node[ m + 1];
    }

    int hash(String key) {
        int h = 0;
        for (int i = 0; i<key.length(); i++) {
            h = (h + key.charAt(i)) % m;
        }
        return h;
    }

    void insert(String key, String value) {
        int i =  hash (key);
        Node head = table[i];
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[i] = newNode;
    }

    String lookup(String key) {
        int i = hash(key);
        Node current = table[i];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }
    String remove(String key) {
            int i = hash(key);
            Node current = table[i];
            Node prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) table[i] = current.next;
                    else prev.next = current.next;
                    return current.value;
                }
                prev = current;
                current = current.next;
            }
            return null;
        }   
  
}
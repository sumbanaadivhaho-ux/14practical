class openHash {
    int m; 
    String[] keys;
    String[] values;
    boolean[] filled;

    public OpenHash(int m) {
        this.m = m;
        keys = new String[m + 1];
        values = new String[m + 1];
        filled = new boolean[m + 1];
    }

    int hash(String key) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (h + key.charAt(i) % m);
        }
        return h;
    }

    void insert(String key, String value) {
        int i = hash(key);
        int p = 1;
        while(filled[i] && !keys[i].equals(key)) {
            i = (i + p) % m;
        }
        keys[i] = key;
        values[i] = value;
        filled[i] = true;

    }

    String lookup(String key) {
        int i = hash(key);
        int p = 1;
        while (filled[i] && !keys[i].equals(key)) {
            i = (i + p) % m;
        }
        return filled[i] ? values[i] : null;
    }

    String remove(String key) {
        int i = hash(key);
        int p = 1;
        while (filled[i] && !keys[i].equals(key)) {
            i = (i + p) % m;
        }
        if (filled[i]) {
            String val = Values[i];
            filled[i] = false;
            return val; 
        }
    }
}
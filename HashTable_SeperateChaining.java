package DataStructures;

import java.util.ArrayList;

public class HashTable_SeperateChaining <keyType, valueType> {
    ArrayList < Field<keyType, valueType> > hashTable;

    int capacity;
    final int DEFAULT_CAPACITY = 12;
    int size;

    static class Field <keyType, valueType> {
        keyType key;
        valueType value;
        int hash;
        Field<keyType, valueType> next;

        Field(keyType key, valueType value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
            this.next = null;
        }
        public boolean isEqual(Field<keyType, valueType> field2) {
            return (this.hash != field2.hash) && this.key.equals(field2.key);
        }
    }

    HashTable_SeperateChaining() {
        this.capacity = DEFAULT_CAPACITY;
        hashTable = new ArrayList<>();

        for(int i = 0; i < capacity; i++) {
            hashTable.add(null);
        }
    }

    public int assertIndex(int hash) {
        return (hash & 0x7FFFFFFF) % this.capacity;
    }

    public valueType get(keyType key) {
        int reqIndex = assertIndex(key.hashCode());

        for (Field<keyType, valueType> list = hashTable.get(reqIndex); list != null; list = list.next)
            if(list.key.equals(key))
                return list.value;
        return null;
    }

    public void add(keyType key, valueType value) {
        Field<keyType, valueType> newField = new Field<>(key, value);
        int allocatedIndex = assertIndex(newField.hash);
        Field<keyType, valueType> list = hashTable.get(allocatedIndex);
        for ( ; list != null; list = list.next) {
            if (list.key.equals(newField.key)) {
                list.value = newField.value;
                return;
            }
        }

        list = hashTable.get(allocatedIndex);
        newField.next = list;
        hashTable.set(allocatedIndex, newField);
        size++;
        growTableIfNeeded();
    }

    public void remove(keyType key) {
        int reqIndex = assertIndex(key.hashCode());

        Field<keyType, valueType> prev = null;
        Field<keyType, valueType> list = hashTable.get(reqIndex);

        while(list != null) {
            if(list.key.equals(key)) {
                if(prev != null) prev.next = list.next;
                else hashTable.set(reqIndex, list.next);

                size--;
            }
            prev = list;
            list = list.next;
        }
    }

    public void growTableIfNeeded() {
        if ((float)size/capacity >= 0.7) {
            capacity *= 2;
            ArrayList<Field<keyType, valueType>> tempHT = hashTable;
            hashTable = new ArrayList<>();
            for(int i = 0; i < capacity; i++) {
                hashTable.add(null);
            }

            for(Field<keyType, valueType> field : tempHT) {
                while(field != null) {
                    add(field.key, field.value);
                    field = field.next;
                }
            }
        }
    }

    public ArrayList<keyType> keys() {
        ArrayList<keyType>  keys = new ArrayList<>(size);
        for(Field<keyType, valueType> list : hashTable)
            if(list != null)
                for(Field<keyType, valueType> temp = list; temp != null; temp = temp.next)
                    keys.add(temp.key);

        return keys;
    }

    public ArrayList<valueType> values() {
        ArrayList<valueType>  values = new ArrayList<>(size);
        for(Field<keyType, valueType> list : hashTable)
            if(list != null)
                for(Field<keyType, valueType> temp = list; temp != null; temp = temp.next)
                    values.add(temp.value);

        return values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (int i = 0; i < capacity; i++) {
            for (Field<keyType, valueType> list = hashTable.get(i); list != null; list = list.next) {
                sb.append("key : ").append(list.key).append(", ").append("value : ").append(list.value).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}

class HashTableSCMain {
    public static void main(String[]args) {
        HashTable_SeperateChaining<String, Integer> HT = new HashTable_SeperateChaining<>();
        // Your test code goes here......
    }
}
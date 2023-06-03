package com.example.a_DataStructure;

public class Section07_HashChaining {

    public Slot[] hashTable;

    public Section07_HashChaining(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{

        String key;
        String value;
        Slot next;

        public Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        int address = this.hashFunc(key);

        Slot findSlot = this.hashTable[address];
        Slot prevSlot = findSlot;

        // 최초 저장
        if(findSlot == null){
            this.hashTable[address] = new Slot(key, value);
            return true;
        }

        while(findSlot != null){
            if(findSlot.key.equals(key)){
                findSlot.value = value;
                return true;
            }

            prevSlot = findSlot;
            findSlot = findSlot.next;
        }

        prevSlot.next = new Slot(key, value);
        return true;
    }

    public String getData(String key){
        int address = this.hashFunc(key);

        Slot slot = this.hashTable[address];

        while (slot != null){
            if(slot.key == key){
                return slot.value;
            }
            slot = slot.next;
        }

        return "not found exception";
    }

    public static void main(String[] args) {
        Section07_HashChaining mainObject = new Section07_HashChaining(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("fun-coding", "1234");
        mainObject.saveData("fun-cod", "01033111111");
        System.out.println(mainObject.getData("fun-cod"));;
        System.out.println(mainObject.getData("fun-coding"));;

    }
}

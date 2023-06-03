package com.example.a_DataStructure;

public class Section06_Hash {

    public Slot[] hashTable;

    public Section06_Hash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String value;

        public Slot(String value){
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        int address = this.hashFunc(key);

        if(this.hashTable[address] != null){
            this.hashTable[address].value = value;
            return true;
        }

        this.hashTable[address] = new Slot(value);
        return true;
    }

    public String getData(String key){
        int address = this.hashFunc(key);

        if(this.hashTable[address] == null){
            return "not found exception";
        }

        return this.hashTable[address].value;
    }

    public static void main(String[] args) {
        Section06_Hash mainObject = new Section06_Hash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        System.out.println(mainObject.getData("fun-coding"));;

    }
}

package com.example.a_DataStructure;

public class Section08_HashLinearProbing {

    public Slot[] hashTable;

    public Section08_HashLinearProbing(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;

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
        Slot slot = hashTable[address];

        while (slot != null){

            // 이미 존재하는 키값인 경우
            if(slot.key.equals(key)){
                slot.value = value;
                return true;
            }

            if(++address >= hashTable.length){
                return false;
            }
            slot = hashTable[address];
        }

        this.hashTable[address] = new Slot(key, value);
        return true;
    }

    public String getData(String key){
        int address = this.hashFunc(key);
        Slot slot = hashTable[address];

        while (slot != null){
            if(slot.key.equals(key)){
                return slot.value;
            }

            if(++address >= hashTable.length){
                return "not found exception";
            }
            slot = hashTable[address];
        }

        return "not found exception";
    }

    public static void main(String[] args) {
        Section08_HashLinearProbing mainObject = new Section08_HashLinearProbing(10);
        mainObject.saveData("fun-coding1", "1");
        mainObject.saveData("fun-coding2", "2");
        mainObject.saveData("fun-coding3", "3");
        mainObject.saveData("fun-coding4", "4");
        mainObject.saveData("fun-coding5", "5");
        mainObject.saveData("fun-coding6", "6");
        mainObject.saveData("fun-coding7", "7");

        mainObject.saveData("DaveLee1", "8");
        mainObject.saveData("DaveLee2", "9");
        mainObject.saveData("DaveLee3", "10");
        mainObject.saveData("DaveLee4", "11");
        mainObject.saveData("DaveLee5", "12");

        System.out.println(mainObject.getData("fun-coding4"));;
        System.out.println(mainObject.getData("dummy"));;

    }
}

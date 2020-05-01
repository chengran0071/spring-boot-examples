package com.wxblockchain.com.learning.pattrn.factory.jdkFactory;

import java.util.*;

/**
 * jdk中的工厂方法
 */
public class JdkFactoryLearning {

    private static boolean isAvailable;

    public static boolean isIsAvailable() {
        return isAvailable;
    }

    public static void setIsAvailable(boolean isAvailable) {
        JdkFactoryLearning.isAvailable = isAvailable;
    }

    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("array-1","array-2","array-3");

        List<String> vector = new Vector<String>();
        vector.add("vector-1");
        vector.add("vector-2");
        vector.add("vector-3");


        Set<String> hashSet = new HashSet<String>();
        hashSet.add("11");
        hashSet.add("22");

        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("name","chengran");
        hashMap.put("age","2333");

        Iterator<String> arrayListIterator = arrayList.iterator();
        while (arrayListIterator.hasNext()){
            System.out.println(arrayListIterator.next());
        }

        Iterator<String> vectorIterator = vector.iterator();
        while (vectorIterator.hasNext()){
            System.out.println(vectorIterator.next());
        }

        Iterator<String> hashSetIterator = hashSet.iterator();
        while (hashSetIterator.hasNext()){
            hashSetIterator.remove();
            System.out.println(hashSetIterator.next());
        }

        Iterator<String> hashMapIterator = hashMap.keySet().iterator();
        while (hashMapIterator.hasNext()){
            System.out.println(hashMapIterator.next());
        }


    }
}

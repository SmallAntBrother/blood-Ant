package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedCollection {
	
	Map<Integer,List<Integer>> map = null;
	List<Integer> list ;
	Random random ;
	
	public static void main(String[] args) {
		RandomizedCollection ran = new RandomizedCollection();
		System.out.println(ran.insert(-1));
		System.out.println(ran.remove(-2));
		System.out.println(ran.insert(-2));
		System.out.println(ran.getRandom());
		System.out.println(ran.remove(-1));
		System.out.println(ran.insert(-2));
		System.out.println(ran.getRandom());

//		System.out.println(ran.insert(1));
//		System.out.println(ran.remove(1));
//		System.out.println(ran.insert(1));
	
//		System.out.println(ran.insert(1));
//		System.out.println(ran.insert(1));
//		System.out.println(ran.insert(2));
//		System.out.println(ran.getRandom());
//		System.out.println(ran.remove(1));
//		System.out.println(ran.getRandom());	
	}

	 /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	list.add(val);
    	if(!map.containsKey(val)) {
    		map.put(val, new ArrayList<>());
    	}
    	
    	map.get(val).add(list.size() - 1);
	    return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	 if(!map.containsKey(val)){
             return false ;
         }
    	 int size = map.get(val).size();
    	list.remove(map.get(val).get(size - 1));
    	if(size == 1) {
    		map.remove(val);
    	}else {
    		map.get(val).remove(size - 1);
    	}
    	
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
       return list.get(random.nextInt(list.size()));
    }
    
    
}

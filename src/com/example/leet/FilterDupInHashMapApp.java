package com.example.leet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * input unsorted array, output array with unique elements
 * @author bzhou
 * @since 2013-02-02
 */
class FilterDupInHashMapApp{

    public static int check(int[] a){
        return 0;
    }
    
    public static void main (String args[]){
        int a[] = {1, 1, 2, 2, 1, 4, 5, 3, 3, 1};//set the array
        
        System.out.println("Before sorting: array length = " + a.length);
        for (int j=0; j<a.length; j++)
            System.out.print("("+ j + ")->" + a[j]+ ", ");  

        // using hash map
        String aKey = "";
        HashMap hm = new HashMap();
        
        for (int i=0; i<a.length; i++)
        {
            aKey =  Integer.valueOf(a[i]).toString().trim();
            
            if (hm.containsKey(aKey))
            {
                int aVal = ((Integer)hm.get(aKey)).intValue();
                hm.put(aKey, new Integer(aVal + 1));
            }   
            else 
                hm.put(aKey, new Integer(1));
        }
        
        System.out.println("\rAfter processing(Hash Map): ");
        //Get a set of the entries
        Set set1 = hm.entrySet();
        Iterator i1 = set1.iterator();
        while(i1.hasNext()){
            Map.Entry me = (Map.Entry)i1.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }   
        System.out.println();       

        // using tree map
        TreeMap tm = new TreeMap();
        for (int i=0; i<a.length; i++)
        {
            aKey =  Integer.valueOf(a[i]).toString().trim();
            
            if (tm.containsKey(aKey))
            {
                int aVal = ((Integer)tm.get(aKey)).intValue();
                tm.put(aKey, new Integer(aVal + 1));
            }   
            else 
                tm.put(aKey, new Integer(1));
        }
        
        System.out.println("After processing(Tree Map): ");

        //Get a set of the entries
        Set set2 = tm.entrySet();
        Iterator i2 = set2.iterator();
        while(i2.hasNext()){
            Map.Entry me = (Map.Entry)i2.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }   
        System.out.println();       
    }   
}
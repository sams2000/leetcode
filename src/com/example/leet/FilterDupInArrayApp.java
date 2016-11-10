package com.example.leet;


/**
 * input unsorted array, output array with unique elements
 * using two indexes i and j in same array to filter all duplicates
 * @author bzhou
 * @since 2013-02-02
 */
import java.util.Arrays;

class FilterDupInArrayApp{
    public static void main (String args[]){
        //init the array
        int arr[] = {1, 1, 2, 2, 1, 4, 5, 3, 3, 1};

        System.out.println("\rBefore sorting: array length = " + arr.length);
        for (int j=0; j<arr.length; j++)
            System.out.print("("+ j + ")->" + arr[j]+ ", ");

        //sort array
        Arrays.sort(arr); 
        System.out.println("\rBefore processing: ");
        for (int j=0; j<arr.length; j++)
            System.out.print("("+ j + ")->" + arr[j]+ ", ");          

        //removing duplicates
        if (arr.length >1){   
            int i = 0; //i point to array as result 

            for (int j = 1; j<arr.length; j++){
                if (arr[j] != arr[j-1]){
                    i++;
                    arr[i] = arr[j];
                }
            }

            i++;
            while(i<arr.length){
                arr[i] = 0;
                i++;
            }
        }

        //print out after removing duplicates
        System.out.println("\rAfter processing: ");
        for (int j=0; j<arr.length; j++)
            System.out.print("("+ j + ")->" + arr[j]+ ", ");
    }   
}
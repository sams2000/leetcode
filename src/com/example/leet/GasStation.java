package com.example.leet;

/**
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return true if it’s possible you can travel around the circuit, otherwise
 * return -1.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Example Given 4 gas stations with gas[i]=[1,1,3,1], and the
 * cost[i]=[2,2,1,1]. The starting gas station's index is 2.
 * 
 * Note The solution is guaranteed to be unique.
 * 
 * Challenge O(n) time and O(1) extra space
 * 
 * @author bzhou3
 * @since 2016-01-20
 */
public class GasStation {
    public static void main(String[] args) {
        
        int[] gas={1,1,3,1};
        int[] cost={2,2,1,1};
                
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = -1;

        for(int i = 0; i<gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
    }
}

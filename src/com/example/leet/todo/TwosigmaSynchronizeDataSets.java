package com.example.leet.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
     A data recover simulator when data is damaged in multiple data centers.
     Fortunately, all missing data for each center can be found from one or more 
     of other data centers, a.k.a the combination data set of all data centers (after 
     removing duplicates) is the data set each data center should have after it's recovered.
     
     Here is a solution to make the recover happen and provides detail move steps:
     e.g input 
     3
     2 3
     1 
     1
    One Possible Output: 
    2 1 2 - move data 2 from data center 1 to data center 2
    2 1 3 - move data 2 from data center 1 to data center 3
    1 2 1 - move data 1 from data center 2 to data center 1
    3 1 2 - move data 3 from data center 1 to data center 2
    3 1 3 - move data 3 from data center 1 to data center 3
    
    After these moves, each of three data centers will have data 1, 2, 3 and it's complete.
    
    further testing case can be : 
    5
    1 2
    2
    3
    4
    5

 * @author bzhou
 * @since 3/19/2013
 *
 */
public class TwosigmaSynchronizeDataSets
{

    /**
     * class including dataset id and the existance in all data centers
     * @author bzhou
     *
     */
    public static class DataSetNode{
       
        int datasetID;
        //data centers in which some or full list of datasetID are stored
        Set<Integer> dataCenters = new HashSet<Integer>();
        
        public int hashCode(){
            return datasetID;
        };

        public String toString(){
            String dataCentersSum = "";
            for(Integer datacenter : dataCenters){
                dataCentersSum = dataCentersSum+" "+datacenter;
            }
            return "Data Set ID: " + datasetID + " exists in dataCenters: " + dataCentersSum;
        }
       
    }

    public static void main(String[] args) throws IOException {
        //getting the input for testing cases
        System.out.println("Here is a sample input : ");
        System.out.println("3   - total there are 3 data centers");
        System.out.println("2 3 - data center (1) has data object 2 and data object 3");
        System.out.println("1   - data center (2) has data object 1");
        System.out.println("1   - data center (3) has data object 1");
        System.out.print("Enter the input array in format of number of data centers followed by dataset ids for each center.");
        System.out.println(" Note: no leading whitespace for each input line: ");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String curLine = in.readLine();
        //first input parameter would be the number of data centers
        int numberOfLine = Integer.parseInt(curLine); 
        
        //map data set id to its class node 
        Map<Integer,DataSetNode> dataSetsSource = new HashMap<Integer,DataSetNode>();
        //to store all available data centers
        HashSet<Integer> dataCentersList = new HashSet<Integer>();

        //populate data set and ids
        for(int i = 1;i<numberOfLine+1;i++){
            curLine = in.readLine();
            String[] dataSetIDs = curLine.split(" ");
            
            for(int k=0;k<dataSetIDs.length;k++){
                int dataSetID = Integer.parseInt(dataSetIDs[k]);
                DataSetNode node = dataSetsSource.get(dataSetID);
                if(node == null){
                    node = new DataSetNode();
                    node.datasetID = dataSetID;
                    dataSetsSource.put(dataSetID,node);
                }
                node.dataCenters.add(i);
                
            }
            //add it as part of center complete list
            dataCentersList.add(i);
        }

        StringBuilder stepSolution = new StringBuilder("One Possible Output: \r\n");
        //Iterating over all nodes and add moves to add to missing data center
        for(DataSetNode toBeCopiedDataSetNode : dataSetsSource.values()){
            HashSet<Integer> tmpSubSet = ((HashSet)dataCentersList.clone());
            tmpSubSet.removeAll(toBeCopiedDataSetNode.dataCenters);
            for(Integer toBeFilledCenter: tmpSubSet ){
                stepSolution.append(toBeCopiedDataSetNode.datasetID+" "+toBeCopiedDataSetNode.dataCenters.toArray()[0]+" "+toBeFilledCenter+"\n");
            };
        };

        //output move steps
        System.out.println(stepSolution);
        System.out.println("done!");
    }
}

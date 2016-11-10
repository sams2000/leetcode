package com.example.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a simulated chess board, find the route from starting point [1,1] to end point [3, 3]
 * @author bin zhou
 * @since 2016-01-30
 */
public class Chess3x3 {
    public static void main(String[] args) throws Exception {
        //Create instance of Chess
        Chess3x3 chess3x3 = new Chess3x3();
        
        //explore the route with start point [1, 1]
        //chess3x3.explore(1, 1); 
        
        //explore the route with start point [1, 1]
        List<List<String>> result = chess3x3.explore1(1, 1); 
        System.out.println(result);
    }
    
	 /**
     *  start point of KNIGHT
     */
    private int sx, sy;
    
    private final static int MAX = 3;
    
    /**
     *  chess board, 1 indicates the KNIGHT ever passes the square, 0 indicates NOT
     */
    private int[][] chess = new int[MAX][MAX];

    /**
     *  the constructor
     */ 
    public Chess3x3(){
    }
    
    /**
     * recursive to find all possible solutions
     * @param x
     * @param y
     * @return
     */
    public List<List<String>> explore1(int x, int y){
        List<List<String>> result = new ArrayList<List<String>>();
        
        List<String> sol = new ArrayList<String>();
        sol.add("[" + (x) + "," + (y) + "]");
        
        helper(x-1, y-1, sol, result);
        
        return result;
    }
    
    private void helper(int x, int y, List<String> sol, List<List<String>> result){
        if (x == MAX-1 && y == MAX-1){
            result.add(sol);
        } 
        
        List<String> aSol;
        for (int i=0; i<8; i++){
            switch(i){
            case 0: //1 o'clock
                aSol = new ArrayList<String>(sol);
                if (x-2>=0 && y+1<MAX && chess[x-2][y+1] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x-2) + "," + (y+1) + "]");//store index
                    aSol.add("[" + (x-1) + "," + (y+2) + "]");//store abs value from 1 to 3
                    helper(x-2, y+1, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;
                
            case 1: //2 o'clock
                aSol = new ArrayList<String>(sol);
                if (x-1>=0 && y+2<MAX && chess[x-1][y+2] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x-1) + "," + (y+2) + "]");
                    aSol.add("[" + (x) + "," + (y+3) + "]");
                    helper(x-1, y+2, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;
            case 2: //4 o'clock
                aSol = new ArrayList<String>(sol);
                if (x+1<MAX && y+2<MAX && chess[x+1][y+2] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x+1) + "," + (y+2) + "]");
                    aSol.add("[" + (x+2) + "," + (y+3) + "]");
                    helper(x+1, y+2, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            case 3: //5 o'clock
                aSol = new ArrayList<String>(sol);
                if (x+2<MAX && y+1<MAX && chess[x+2][y+1] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x+2) + "," + (y+1) + "]");
                    aSol.add("[" + (x+3) + "," + (y+2) + "]");
                    helper(x+2, y+1, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            case 4: //7 o'clock
                aSol = new ArrayList<String>(sol);
                if (x+2<MAX && y-1>=0 && chess[x+2][y-1] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x+2) + "," + (y-1) + "]");
                    aSol.add("[" + (x+3) + "," + (y) + "]");
                    helper(x+2, y-1, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            case 5: //8 o'clock
                aSol = new ArrayList<String>(sol);
                if (x+1<MAX && y-2>=0 && chess[x+1][y-2] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x+1) + "," + (y-2) + "]");
                    aSol.add("[" + (x+2) + "," + (y-1) + "]");
                    helper(x+1, y-2, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            case 6: //10 o'clock
                aSol = new ArrayList<String>(sol);
                if (x-1>=0 && y-2>=0 && chess[x-1][y-2] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x-1) + "," + (y-2) + "]");
                    aSol.add("[" + (x) + "," + (y-1) + "]");
                    helper(x-1, y-2, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            case 7: //11 o'clock
                aSol = new ArrayList<String>(sol);
                if (x-2>=0 && y-1>=0 && chess[x-2][y-1] == 0){
                    chess[x][y] = 1;
                    //aSol.add("[" + (x-2) + "," + (y-1) + "]");
                    aSol.add("[" + (x-1) + "," + (y) + "]");
                    helper(x-2, y-1, aSol, result);
                    chess[x][y] = 0;
                }
                
                break;  
            default:
                 break;
            }
        }
    }
    
    /**
     *  KNIGHT starts from [x,y], and tries his best to reach the destination reversely
     */
    public void explore(int x, int y) throws Exception {
        sx = x-1;
        sy = y-1;
        //initialize chess board, no needed as default value is 0 for each element
        for ( int i=0; i<MAX; i++)
            for ( int j=0; j<MAX; j++)
                chess[i][j] = 0;
        
        //(2, 2) as the destination of KNIGHT 
        if ( !dfs(MAX-1, MAX-1) )
            throw new Exception("["+x+","+y+"] can't reach the specified target ["+ MAX + "," + MAX + "]");
    }

    /**
     *  recursive function to explore all the possibilities
     *  at every position, he may has 8 directions to go: 1, 2, 4, 5, 7, 8, 10, 11 o'clock in clock
     *
     */
    public boolean dfs(int x, int y){

        //destination reached    
        if ( sx==x && sy==y ){
            System.out.print("["+(sx+1)+","+(sy+1)+"]");
            return true;
        }
        //no any way to go, so report failure
        if ( chess[x][y]==1 )
            return false;

        for ( int i=0; i<8; i++ ){
            switch ( i ){
            case 0://1 o'clock
                if ( x-2<0 || y+1>(MAX-1) || chess[x-2][y+1]==1 )
                    break;
                
                chess[x][y] = 1;
                if ( dfs(x-2, y+1) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 1://2 o'clock
                if ( x-1<0 || y+2>(MAX-1) || chess[x-1][y+2]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x-1, y+2) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 2://4 o'clock
                if ( x+1>(MAX-1) || y+2>(MAX-1) || chess[x+1][y+2]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x+1, y+2) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 3://5 o'clock
                if ( x+2>(MAX-1) || y+1>(MAX-1) || chess[x+2][y+1]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x+2, y+1) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 4://7 o'clock
                if ( x+2>(MAX-1) || y-1<0 || chess[x+2][y-1]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x+2, y-1) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 5://8 o'clock
                if ( x+1>(MAX-1) || y-2<0 || chess[x+1][y-2]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x+1, y-2) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 6://10 o'clock
                if ( x-1<0 || y-2<0 || chess[x-1][y-2]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x-1, y-2) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            case 7://11 o'clock
                if ( x-2<0 || y-1<0 || chess[x-2][y-1]==1 )
                    break;

                chess[x][y] = 1;
                if ( dfs(x-2, y-1) ){
                    System.out.print(" --> ["+(x+1)+","+(y+1)+"]");
                    return true;
                }
                chess[x][y] = 0;
                break;
            default://others
                break;
            }
        }
        return false;
    }
}

package MovieViewCounter;

/**
 * 某个电影每一秒会有好几次view。实现AddViewEvent()，which is to be called by the client.
 * 实现getLastMinCounts(); getLast10Counts(); getLast60Counts()
 * 返回过去一分钟/10分钟/60分钟内的view数。
 * 
 * @author bin zhou Created on Feb 17, 2016
 *
 */
public class MovieViewCounterApp {

    public static void main(String[] args) throws InterruptedException {
        
        MovieStatsCounter counter = new MovieStatsCounter();

        counter.update();
        counter.update();
        counter.update();
        counter.update();
        counter.update();

        System.out.println(counter);

        Thread.sleep(5000);
        counter.update();
        counter.update();
        counter.update();

        System.out.println(counter);        
        
    }



}

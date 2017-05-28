package leetcode;

import java.util.*;

/**
 * Created by lukCy on 2017/4/24.
 * 思路：首先要考虑如何根据飞机票的信息构建这些航程的关联。
 * 1、hashmap储存每个机场出发的信息，并建立出发地key对于目的地value的映射(可能是一对多，所以value的采用priorityqueue来存储，
 *    它会自动按照字典序来存储)
 * 2、从JFK机场开始dfs，递归条件为机场在map的key里，并且对应的value不为空。
 */
public class _332ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets){
        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.length == 0)
            return res;

        Map<String,PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets){
            if (!map.containsKey(ticket[0])){
                map.put(ticket[0],new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs(map,res,"JFK");
        return res;

    }
    public void dfs(Map<String,PriorityQueue<String>> map,List<String> res,String airport){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            dfs(map,res,map.get(airport).poll());
        }
        res.add(0,airport);
    }


    public static void display(String[][] tickets){
        int h = tickets.length;int l = tickets[0].length;
        System.out.print("the orgin tickets list is: ");
        for (int i=0;i<h-1;i++){
            for (int j=0;j<l-1;j++){
                System.out.print(tickets[i][j]+",");
            }
            System.out.print(tickets[i][l-1]+"-->");
        }
        for (int j=0;j<l-1;j++){
            System.out.print(tickets[h-1][j]+",");
        }
        System.out.println(tickets[h-1][l-1]);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"},{"SFO","ATL"},{"ATL","JFK"},{"JFK","ATL"},{"ATL","SFO"}};
        display(tickets);
        List<String> res = new _332ReconstructItinerary().findItinerary(tickets);
        System.out.print("the itinerary is :");
        for (int i=0;i<res.size()-1;i++){
            System.out.print(res.get(i)+"-->");
        }
        System.out.println(res.get(res.size()-1));
    }
}

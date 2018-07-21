import java.util.*;

public class N332_ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
         List<String> res = new LinkedList<>();
         Map<String, List<String>> map = new HashMap<>();
         for (String[] t : tickets) {
             if (!map.containsKey(t[0])) {
                 map.put(t[0], new ArrayList<String>());
             }
             map.get(t[0]).add(t[1]);
         }
         for (Map.Entry<String, List<String>> e : map.entrySet()) {
             Collections.sort(e.getValue());
         }
         dfs("JFK", map, res, tickets.length);
         res.add(0,"JFK");
         return res;
     }

     public boolean dfs(String start, Map<String, List<String>> map, List<String> res, int numOfTickets) {
         if (res.size() == numOfTickets) {
             return true;
         }
         if (map.get(start) == null) {
             return false;
         }
         List<String> list = map.get(start);
         for (int i = 0; i < list.size(); i++) {
             String dest = list.get(i);
             res.add(dest);
             list.remove(i);
             if (dfs(dest, map, res, numOfTickets)) {
                 return true;
             }
             res.remove(res.size()-1);
             list.add(i, dest);
         }
         return false;
     }

    public List<String> findItinerary_2(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new PriorityQueue<String>());
            }
            map.get(t[0]).offer(t[1]);
        }
        dfs_hierholzer("JFK", map, res);
        return res;
    }

    public void dfs_hierholzer(String key, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> queue = map.get(key);
        while (queue != null && !queue.isEmpty()) {
            dfs_hierholzer(queue.poll(), map, res);
        }
        res.addFirst(key);
    }
}

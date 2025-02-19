import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Time Complexity functions: O(V+E)
//Space Complexity : O(V+E)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
Create a indegree array of size of number of courses. indegree of each node represent the value at each index of array.
While iterating over given 2d array, also create a map of adjacent nodes (adjacency list). All the index having indegree as 0, 
add them to the queue. Using BFS logic and map, find the neighbours of the ements in queue and reduce their indegree by 1. If
indegree becomes 0, add it to the queue. Same time also count the visits when we remove the node from queue. If the visits!=num of courses,
then return false. 
*/
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0){
            return true;
        }
        int[] indegree=new int[numCourses];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] edge:prerequisites){
            int inde=edge[1];
            int depe=edge[0];
            indegree[depe]++;
            if(!map.containsKey(inde)){
                map.put(inde,new ArrayList<>());
            }
            map.get(inde).add(depe);
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        if(count==0){
            return false;
        }
        int visit=0;
        while(!q.isEmpty()){
            int i=q.remove();
            visit++;
            if(map.get(i)==null) continue;
            for(int nei:map.get(i)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(visit<numCourses){
            return false;
        }
        return true;
    }
}

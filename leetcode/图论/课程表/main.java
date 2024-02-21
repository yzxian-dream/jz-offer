package 图论.课程表;

//广度优先遍历
class Solution {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //为每一个课程创建一个list，用来存储它的出度课程
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            //想学info[0]，必须先学info[1],那么info[1]的list里就得加入info[0]作为出度
            edges.get(info[1]).add(info[0]);
            //info[0]的入度加1
            ++indeg[info[0]];
        }
        //定义一个q，q里存的一定是可以学习的课程，也就是当前的课程入度为0的课程
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0; //学过的课的数量
        while (!queue.isEmpty()) {
            //表示当前课程已经学过
            ++visited;
            //u一定是无入度的
            int u = queue.poll();
            //查找u的出度，也就是学完了u,可以学习哪些课程了
            for (int v: edges.get(u)) {
                //u学完了，少个入度，--掉
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}

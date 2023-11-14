// A frog is crossing a river. The river is divided into some number of units, 
// and at each unit, there may or may not exist a stone. The frog can jump on a stone, 
// but it must not jump into the water.

// Given a list of stones positions (in units) in sorted ascending order, 
// determine if the frog can cross the river by landing on the last stone. 
// Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

// If the frog's last jump was k units, its next jump must be either k - 1, k, 
// or k + 1 units. The frog can only jump in the forward direction.

// Example 1:

// Input: stones = [0,1,3,5,6,8,12,17]
// Output: true
// Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, 
// then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 
// 4 units to the 7th stone, and 5 units to the 8th stone.

// 0, 1, 5, 6
// 0  step 1
// 1  step: 0, 1, 2 
// 1 step  
// -1


// 0,1,3,5,6,8,12,17
// 0 step 1
// 1 step 0, 1, 2 ->2
// 3 step 1, 2, 3
    // step 2 -> 5,   
        // 5,  step 1, 2, 3
            //6 step 1,2
                // 8 step 2, 3
                // failure
            // 8  step 2, 3, 4
                // 12, step 3, 4, 5
                // end
    // step 3 -> 6 

//

// [0,1,2,3,4,5,6,7,8,9,10]
// 2-> 1, 2
// 3 -> 2, 3, 4
// 4 -> 3 4, 5

// 

// public boolean frogJump(int[] stones) {
//     // hashmap key: index value: previous nums of step 
//     // 1: set{1}
//     // 3: set(2)
//     HashMap<Integer, Set<Integer>> indexToPreStep = new HashMap<>();

//     for (int i = 0; i < stones.length; i++) {
//         indexToPreStep.get(i) = new HashSet<>();
//     }

//     indexToPreStep.get(0).add(0); // {0: {0}}
//     for (int i = 0; i < stones.length; i++) { // i=0 1 2. 
//         Set<Integer> Jumps = indexToPreStep.get(stone[i]); // 0 {1} {2}
//         for (int curJump: Jumps) { 
//             for (int step = curJump - 1; step  < curJump + 1; step ++) { // 0, 1/ 1, 2/  1,2, 3
//                 if (step > 0) {
//                     if (indexToPreStep.containsKey(stones[i] + curJump)) { // true
//                         indexToPreStep.get(stones[i] + curJump).add(step); // {0: {0}, 1: {1}, 3: {2}}
//                     }
//                 }
//             }
            
//         }
//     }
//     if (indexToPreStep.get(stones.length - 1).size() > 0) {
//         return true;
//     }
//     return false;

// }


// 0,1,3,5,6,8,12,17

// You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). 
// You can move up, down, left, or right from and to an empty cell in one step.

// Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right 
// corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to
// find such walk return -1.

// Input: grid = [[0,0,0],
                //  [1,1,0],
                // [0,0,0],
                // [0,1,1],
                // [0,0,0]], k = 1
// Output: 6
// Explanation: 
// The shortest path without eliminating any obstacle is 10.
// The shortest path with one obstacle elimination at position (3,2) is 6. 
// Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).


// visited[i][j][k]
import java.util.*;

public int shortestPath(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();
    int[][][] visited = int{};
    int[][] dirs = int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    queue.add(int[]{0, 0, 0});
    visited[0][0][0] = true;
    int step = 0;

    for (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) 
            curPos = queue.poll();
            curX = curPos[0];
            curY = curPos[1];
            curK = curPos[2];
            for(int dir : dirs) {
                newX = curX + dir[0];
                newY = curY + dir[1];
                if (newX < 0 || newX > m || newY < 0 || newY > n) continue;
                if (newX == m - 1 && newY == n - 1) {
                    return step + 1;
                }

                if (grid[newX][newY] == 1) {
                    if (curK >= k) continue;
                    if (visited[newX][newY][curK + 1]) continue;
                    queue.add(int[newX][newY][curK + 1]);
                    visited[newX][newY][curK + 1] = true;

                } else {
                    if (visited[newX][newY][curK]) continue;
                    queue.add(int[newX][newY][curK]);
                    visited[newX][newY][curK] = true;
                }

            }
            step++;
        }

    }

    return -1;

}

public static void main(String[] args) {
    

}


int main(void)
{
  Testcase obj = {akjelqj,asjdkjasl,jasdlkjawl,lasjdlkaw}
  print("test result = ", shortestPath(obj));
}

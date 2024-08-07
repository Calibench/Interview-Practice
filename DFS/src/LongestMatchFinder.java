import java.util.*;

public class LongestMatchFinder {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int maxCount = 0;
    static List<Integer[]> maxPath = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        char[][] grid = {
                {'C', 'D', 'E', 'C', 'E', 'E'},
                {'A', 'B', 'D', 'E', 'C', 'B'},
                {'B', 'B', 'D', 'A', 'D', 'B'},
                {'D', 'D', 'A', 'D', 'E', 'A'},
                {'E', 'A', 'E', 'E', 'D', 'A'},
                {'E', 'D', 'D', 'A', 'E', 'A'},
                {'E', 'A', 'B', 'B', 'B', 'D'}
        };

        LongestMatchFinder finder = new LongestMatchFinder();
        List<Integer[]> longestMatch = finder.findLongestMatch(grid);

        // Print the longest path's coordinates
        for (Integer[] coordinate : longestMatch) {
            System.out.println("(" + (coordinate[0] + 1) + ", " + (coordinate[1] + 1) + ")");
        }
    }

    public List<Integer[]> findLongestMatch(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    List<Integer[]> currentPath = new ArrayList<>();
                    dfs(grid, i, j, grid[i][j], currentPath);
                }
            }
        }

        return maxPath;
    }

    public void dfs(char[][] grid, int x, int y, char value, List<Integer[]> currentPath) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] != value) {
            return;
        }

        visited[x][y] = true;
        currentPath.add(new Integer[]{x, y});

        if (currentPath.size() > maxCount) {
            maxCount = currentPath.size();
            maxPath = new ArrayList<>(currentPath);
        }

        for (int i = 0; i < 8; i++) { // Modified to 8 to include diagonal movements
            dfs(grid, x + dx[i], y + dy[i], value, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
        visited[x][y] = false;
    }
}
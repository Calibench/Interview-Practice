import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ScreenCapture {
    private static final int ROWS = 7;
    private static final int COLS = 6;
    private static final int CELL_WIDTH = 137;
    private static final int CELL_HEIGHT = 137;
    private static final Map<Character, Color> ELEMENTS = Map.of(
            'A', new Color(133, 244, 202), // Blue burger
            'B', new Color(209, 104, 59),  // Four Squares
            'C', new Color(254, 247, 115), // Golden Candy
            'D', new Color(255, 141, 229), // Ice Cream
            'E', new Color(249, 221, 184)  // Cupcake
    );
    
    private static boolean[][] visited;
    private static List<Point> longestChain;
    private static int longestChainLength;
    
    public static void main(String[] args) {
        try {
            BufferedImage gridImage = takeScreenshot(91, 95, COLS * CELL_WIDTH, ROWS * CELL_HEIGHT);
            ImageIO.write(gridImage, "png", new File("grid.png")); // Save screenshot for debugging
            
            char[][] grid = new char[ROWS][COLS];
            visited = new boolean[ROWS][COLS];
            longestChain = new ArrayList<>();
            longestChainLength = 0;
            
            // Process the image and fill the grid with corresponding values
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    int x = j * CELL_WIDTH + CELL_WIDTH / 2;
                    int y = i * CELL_HEIGHT + CELL_HEIGHT / 2;
                    Color color = new Color(gridImage.getRGB(x, y));
                    grid[i][j] = classifyColor(color);
                }
            }

            // Perform DFS to find the longest chain
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    visited = new boolean[ROWS][COLS]; // Reset visited for each new start point
                    findLongestChainDFS(grid, i, j, grid[i][j], new ArrayList<>());
                }
            }
            
            // Print out the longest chain
            for (Point p : longestChain) {
                System.out.println("(" + p.x + ", " + p.y + "): " + grid[p.x][p.y]);
            }
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
    
    private static BufferedImage takeScreenshot(int x, int y, int width, int height) throws AWTException {
        Robot robot = new Robot();
        Rectangle captureRect = new Rectangle(x, y, width, height);
        return robot.createScreenCapture(captureRect);
    }

    private static char classifyColor(Color color) {
        char classification = ' ';
        double minDistance = Double.MAX_VALUE;
        
        for (Map.Entry<Character, Color> entry : ELEMENTS.entrySet()) {
            double distance = colorDistance(color, entry.getValue());
            if (distance < minDistance) {
                minDistance = distance;
                classification = entry.getKey();
            }
        }

        return classification;
    }

    private static double colorDistance(Color c1, Color c2) {
        int redDiff = c1.getRed() - c2.getRed();
        int greenDiff = c1.getGreen() - c2.getGreen();
        int blueDiff = c1.getBlue() - c2.getBlue();
        return Math.sqrt(redDiff * redDiff + greenDiff * greenDiff + blueDiff * blueDiff);
    }

    private static void findLongestChainDFS(char[][] grid, int x, int y, char target, List<Point> chain) {
        if (x < 0 || x >= ROWS || y < 0 || y >= COLS || visited[x][y] || grid[x][y] != target) {
            return;
        }

        visited[x][y] = true;
        chain.add(new Point(x, y));

        if (chain.size() > longestChainLength) {
            longestChainLength = chain.size();
            longestChain = new ArrayList<>(chain); // Copy current chain as longest
        }

        int[] directions = {-1, 0, 1}; // To iterate over all 8 directions
        for (int dx : directions) {
            for (int dy : directions) {
                if (dx != 0 || dy != 0) { // Avoid standing still
                    findLongestChainDFS(grid, x + dx, y + dy, target, chain);
                }
            }
        }

        chain.remove(chain.size() - 1);
        visited[x][y] = false;
    }
}

package week4io.io;

import stdlib.StdDraw;
import stdlib.StdIn;

/**
 * This program reads geographic boundary information from standard input and
 * plots the regions (countries, states, provinces, etc.) to standard drawing.
 * Each region is described by a polygon with vertices specified by x and y
 * coordinates.
 * 
 * Input Format:
 * - First line: width height (canvas dimensions)
 * - For each region:
 * - Region name (no spaces)
 * - Number of vertices in the polygon
 * - List of x,y coordinates for each vertex
 * 
 * Output:
 * - Draws the polygons to standard drawing using the specified dimensions
 * - Each region is drawn as a polygon with the given vertices
 * 
 * @author Bryan Williamson
 */
public class WorldMap {

    /**
     * Main method that reads geographic data and draws the world map.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Read canvas dimensions from first line
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        // Set up the drawing canvas with the specified dimensions
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Skip the newline after dimensions and the blank line
        StdIn.readLine(); // consume the newline after dimensions
        StdIn.readLine(); // consume the blank line

        // Process each region until end of input
        while (!StdIn.isEmpty()) {
            // Read region name
            String regionName = StdIn.readLine();

            // Read number of vertices for this region's polygon
            int numVertices = StdIn.readInt();

            // Arrays to store x and y coordinates of polygon vertices
            double[] xCoords = new double[numVertices];
            double[] yCoords = new double[numVertices];

            // Read coordinates for each vertex
            for (int i = 0; i < numVertices; i++) {
                xCoords[i] = StdIn.readDouble();
                yCoords[i] = StdIn.readDouble();
            }

            // Draw the polygon for this region
            StdDraw.polygon(xCoords, yCoords);

            // Skip the newline after coordinates and the blank line
            StdIn.readLine(); // consume the newline after coordinates
            StdIn.readLine(); // consume the blank line
        }
    }
}

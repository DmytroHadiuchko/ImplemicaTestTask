package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        // Create a Scanner to read the input from the user
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int testCases = sc.nextInt();

        // Loop through each test case
        while (testCases-- > 0) {
            // Read the number of cities
            int n = sc.nextInt();
            sc.nextLine(); // consume the newline character

            // A map to associate city names with their index in the graph
            Map<String, Integer> cityIndex = new HashMap<>();
            // A list to represent the graph where each city has a list of neighboring cities and their respective costs
            List<List<int[]>> graph = new ArrayList<>();

            // Loop through each city and its connections
            for (int i = 0; i < n; i++) {
                // Read the city name and store its index in the cityIndex map
                String cityName = sc.nextLine();
                cityIndex.put(cityName, i);
                graph.add(new ArrayList<>());

                // Read the number of neighbors for the current city
                int neighbors = sc.nextInt();
                // Loop through the neighbors of the city and add them to the graph
                for (int j = 0; j < neighbors; j++) {
                    int neighbor = sc.nextInt() - 1; // Convert 1-based index to 0-based
                    int cost = sc.nextInt(); // Read the cost of the connection to the neighbor
                    graph.get(i).add(new int[]{neighbor, cost});
                }
                // If there's another line after this one, consume it
                if (sc.hasNextLine()) sc.nextLine();
            }

            // Read the number of queries (paths to find)
            int r = sc.nextInt();
            sc.nextLine(); // consume the newline character

            // Process each query to find the minimum cost path between two cities
            for (int i = 0; i < r; i++) {
                // Read the source and destination city names
                String source = sc.next();
                String destination = sc.next();
                sc.nextLine(); // consume the newline character

                // Find the minimum cost path using Dijkstra's algorithm and print the result
                int result = dijkstra(graph, cityIndex.get(source), cityIndex.get(destination), n);
                System.out.println(result);
            }

            // If there are more test cases, consume the empty line between them
            if (testCases > 0) sc.nextLine();
        }

        // Close the scanner to avoid resource leaks
        sc.close();
    }

    // Dijkstra's algorithm to find the minimum cost path between two cities
    private static int dijkstra(List<List<int[]>> graph, int start, int end, int n) {
        // A priority queue to store nodes based on the cost (min-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // Array to store the shortest distance (cost) to each city, initialized to a large value
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Set the starting city's distance to 0
        dist[start] = 0;
        // Add the starting city to the priority queue
        pq.offer(new int[]{start, 0});

        // Process nodes in the priority queue until it's empty
        while (!pq.isEmpty()) {
            // Get the city with the minimum cost from the priority queue
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            // If we've reached the destination city, return the current cost
            if (currentNode == end) {
                return currentCost;
            }

            // Explore the neighbors of the current city
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int edgeCost = neighbor[1];
                // Calculate the new cost to reach the neighbor
                int newCost = currentCost + edgeCost;

                // If the new cost is better (lower) than the previously found cost, update the cost and add the neighbor to the queue
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[]{nextNode, newCost});
                }
            }
        }

        // If no path exists from start to end, return -1
        return -1;
    }
}

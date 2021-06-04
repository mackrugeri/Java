import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Proj2 {

    private Map<Integer, Axis> nodes = new LinkedHashMap<Integer, Axis>();
    Map<Integer, Boolean> discovered = new HashMap<Integer, Boolean>();
    Map<Integer, Boolean> explored = new HashMap<Integer, Boolean>();
    Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
    static Map<Integer, Integer> connectedNodes = new HashMap<Integer, Integer>();
    Stack<Integer> s = new Stack<Integer>();
    static boolean feasability;
    static boolean connected;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the width:");
        double width = scan.nextDouble();

        System.out.println("Enter the length:");
        double height = scan.nextDouble();

        System.out.println("Enter the number of nodes:");
        int numberOfNodes = scan.nextInt();

        System.out.println("Enter the Transmission range in meters:");
        int transmissionRange = scan.nextInt();

        System.out.println("Enter the number of data nodes:");
        int p = scan.nextInt();

        System.out.println("Enter the number of data packets each data node has: ");
        int q = scan.nextInt();

        System.out.println("Enter the storage capacity of each node: ");
        int m = scan.nextInt();

        Proj2 sensor = new Proj2();
        sensor.populateNodes(numberOfNodes, width, height);

        //System.out.println("\nNode List:");
        for(int key :sensor.nodes.keySet()) {
            Axis ax = sensor.nodes.get(key);
            //System.out.println("Node:" + key + ", xAxis:" + ax.getxAxis() + ", yAxis:" + ax.getyAxis());
        }

        Map<Integer, Set<Integer>> adjacencyList1 = new LinkedHashMap<Integer, Set<Integer>> ();

        sensor.populateAdjacencyList(numberOfNodes, transmissionRange, adjacencyList1);
        System.out.println("\nAdjacency List: ");

        for(int i: adjacencyList1.keySet()) {
            System.out.print(i);
            if(!adjacencyList1.isEmpty()){
                for(int j: adjacencyList1.get(i)) {
                    System.out.print("->" + j);
                }
            }
        }
        sensor.executeDepthFirstSearchAlg(width, height, p, q, numberOfNodes, m, adjacencyList1);

        System.out.println();

        List<Integer> nodeList = new ArrayList<>(numberOfNodes);
        for (int i = 1; i <= numberOfNodes; i++) {
            nodeList.add(i);
        }
        Collections.shuffle(nodeList);
        List<Integer> dnIDs = new ArrayList<>(p);
        List<Integer> snIDs = new ArrayList<>(numberOfNodes - p);
        for (int i = 0; i < p; i++) {
            //if (i < p) {
            dnIDs.add(nodeList.get(i));

        }
        for (int i = p; i < numberOfNodes; i++) {
            snIDs.add(nodeList.get(i));

        }
        for (int i = 0; i < dnIDs.size(); i++) {
            System.out.println("DN ID " + (i + 1) + " = " + dnIDs.get(i));
        }
        for (int i = 0; i < snIDs.size(); i++) {
            System.out.println("SN ID " + (i + 1) + " = " + snIDs.get(i));
        }

        System.out.println("Please input the ID of a DN: ");
        int dn1 = scan.nextInt();
        System.out.println("Please input the ID of a SN: ");
        int sn1 = scan.nextInt();

        Integer dnvalue = dnIDs.get(dn1 - 1);
        Integer snvalue = snIDs.get(sn1 - 1);

    }

    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the width:");
        double width = scan.nextDouble();

        System.out.println("Enter the length:");
        double height = scan.nextDouble();

        System.out.println("Enter the number of nodes:");
        int numberOfNodes = scan.nextInt();

        System.out.println("Enter the Transmission range in meters:");
        int transmissionRange = scan.nextInt();

        System.out.println("Enter the number of data nodes:");
        int p = scan.nextInt();

        System.out.println("Enter the number of data packets each data node has: ");
        int q = scan.nextInt();

        System.out.println("Enter the storage capacity of each node: ");
        int m = scan.nextInt();

        Proj2 sensor = new Proj2();
        sensor.populateNodes(numberOfNodes, width, height);

        //System.out.println("\nNode List:");
        for(int key :sensor.nodes.keySet()) {
            Axis ax = sensor.nodes.get(key);
            //System.out.println("Node:" + key + ", xAxis:" + ax.getxAxis() + ", yAxis:" + ax.getyAxis());
        }

        Map<Integer, Set<Integer>> adjacencyList1 = new LinkedHashMap<Integer, Set<Integer>> ();

        sensor.populateAdjacencyList(numberOfNodes, transmissionRange, adjacencyList1);
        System.out.println("\nAdjacency List: ");
        List<List<Node>> adj = new ArrayList<>();
        for(int i: adjacencyList1.keySet()) {
            System.out.print(i);
            if(!adjacencyList1.isEmpty()){
                for(int j: adjacencyList1.get(i)) {
                    System.out.print("->" + j);
                }
                System.out.println();
            }
            //System.out.println();
        }
        sensor.executeDepthFirstSearchAlg(width, height, p, q, numberOfNodes, m, adjacencyList1);
        System.out.println("Welcome to the menu ");
        System.out.println("Press 0 to Dijkstra’s shortest path algorithm ");
        System.out.println("Press 1 to Bellman-Ford dynamic programming algorithm");
        System.out.println("Press 2 to finding a shortest path between them with k edges");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your choice:");
        // Numerical input
        int a = myObj.nextInt();
        if (a == 0)
        {
//            Part A
            DPQ dpq = new DPQ(m);
            dpq.main( m, adj);
        }else if (a==1)
        {
            //        Part B
            Graph graph = new Graph(q, m);
            System.out.println("Enter the value:");
            int b = myObj.nextInt();
            graph.BellmanFord(graph, b);

        }else if (a ==2)
        {
            //  Part C
            DPQ dpq = new DPQ(m);
            dpq.main( m, adj);
        }
        else{
            System.out.println("Worng input sorry ");
        }
//



    }



    void executeDepthFirstSearchAlg(double width, double height, int p, int q, int nodenumber, int m, Map<Integer, Set<Integer>> adjList) {
        System.out.println("\nExecuting DFS Algorithm");
        List<Set<Integer>> connectedNodes = new ArrayList<Set<Integer>>();
        for(int node: adjList.keySet()) {
            Set<Integer> connectedNode = new LinkedHashSet<Integer>();
            recursiveDFS(node, connectedNode, adjList);

            if(!connectedNode.isEmpty()) {
                connectedNodes.add(connectedNode);
            }
        }

        if(connectedNodes.size() == 1) {
            System.out.println("Graph is fully connected with one connected component.");
            if (p * q <= (nodenumber - p) * m) {
                feasability = true;
            }
            else {
                feasability = false;
                System.out.println("There is not enough storage in the network. Please input again: ");
                input();
            }
        } else {
            System.out.println("Graph is not fully connected");
            input();
        }

		/*System.out.println("There are " + connectedNodes.size() + " connected components");
		for(Set<Integer> list: connectedNodes) {
			System.out.println(list);
		}*/


		/*//Draw sensor network graph
		SensorNetworkGraph graph = new SensorNetworkGraph();
		graph.setGraphWidth(width);
		graph.setGraphHeight(height);
		graph.setNodes(nodes);
		graph.setAdjList(adjList);
		graph.setPreferredSize(new Dimension(960, 800));
		Thread graphThread = new Thread(graph);
		graphThread.start();*/
    }

    void recursiveDFS(int u, Set<Integer> connectedNode, Map<Integer, Set<Integer>> adjList) {

        if(!s.contains(u) && !explored.containsKey(u)) {
            s.add(u);
            discovered.put(u, true);
        }

        while(!s.isEmpty()) {
            if(!explored.containsKey(u)) {
                List<Integer> list = new ArrayList<Integer>(adjList.get(u));
                for(int v: list) {

                    if(!discovered.containsKey(v)) {
                        s.add(v);
                        discovered.put(v, true);

                        if(parent.get(v) == null) {
                            parent.put(v, u);
                        }
                        recursiveDFS(v, connectedNode, adjList);
                    } else if(list.get(list.size()-1) == v) {
                        if( parent.containsKey(u)) {
                            explored.put(u, true);
                            s.removeElement(u);

                            connectedNode.add(u);
                            recursiveDFS(parent.get(u), connectedNode, adjList);
                        }
                    }
                }
                if(!explored.containsKey(u))
                    explored.put(u, true);
                s.removeElement(u);
                connectedNode.add(u);
            }
        }

    }


    void populateNodes(int nodeCount, double width, double height) {
        Random random = new Random();

        for(int i = 1; i <= nodeCount; i++) {
            Axis axis = new Axis();
            int scale = (int) Math.pow(10, 1);
            double xAxis =(0 + random.nextDouble() * (width - 0));
            double yAxis = 0 + random.nextDouble() * (height - 0);

            xAxis = (double)Math.floor(xAxis * scale) / scale;
            yAxis = (double)Math.floor(yAxis * scale) / scale;

            axis.setxAxis(xAxis);
            axis.setyAxis(yAxis);

            nodes.put(i, axis);
        }
    }

    void populateAdjacencyList(int nodeCount, int tr, Map<Integer, Set<Integer>> adjList) {
        for(int i=1; i<= nodeCount; i++) {
            adjList.put(i, new HashSet<Integer>());
        }

        for(int node1: nodes.keySet()) {
            Axis axis1 = nodes.get(node1);
            for(int node2: nodes.keySet()) {
                Axis axis2 = nodes.get(node2);

                if(node1 == node2) {
                    continue;
                }
                double xAxis1 = axis1.getxAxis();
                double yAxis1 = axis1.getyAxis();

                double xAxis2 = axis2.getxAxis();
                double yAxis2 = axis2.getyAxis();

                double distance =  Math.sqrt(((xAxis1-xAxis2)*(xAxis1-xAxis2)) + ((yAxis1-yAxis2)*(yAxis1-yAxis2)));

                if(distance <= tr) {
                    Set<Integer> tempList = adjList.get(node1);
                    tempList.add(node2);
                    adjList.put(node1, tempList);

                    tempList = adjList.get(node2);
                    tempList.add(node1);
                    adjList.put(node2, tempList);
                }
            }
        }
    }
}

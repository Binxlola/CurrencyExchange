import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BestConversionFinder {

    private final Map<String, Integer> currenciesToIndex;
    private Map<Integer, String> indexToCurrencies;
    private final double[][] connectivityTable;
    private ArrayList<Edge> edges;
    private final Map<Integer, Edge[]> shortestPaths;
    private final int n;

    public BestConversionFinder(Map<String, Integer> currencies, double[][] connectivityTable) {


        this.currenciesToIndex = currencies;
        this.connectivityTable = connectivityTable;
        this.n = connectivityTable.length;
        this.shortestPaths = new HashMap<>();

        // Convert rate to edge weights
        this.convertRatesToWeights();
        this.createIndexToCurrencies();
    }

    /**
     * Takes a connectivity table of rates set on instantiation and converts all the direct exchange rates to weights
     */
    private void convertRatesToWeights() {

        this.edges = new ArrayList<>();

        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < connectivityTable[i].length; j++) {

                // If there is an edge add the edge to the array of edges for the current vertex
                double weight = Math.log(1/connectivityTable[i][j]);
                if(weight != 0 && weight != Double.POSITIVE_INFINITY) {
                    edges.add(new Edge(i,j, weight));
                }
            }
        }

    }

    private void createIndexToCurrencies() {
        this.indexToCurrencies = new HashMap<Integer, String>();
        for(Map.Entry<String, Integer> pair : this.currenciesToIndex.entrySet()) {
            indexToCurrencies.put(pair.getValue(), pair.getKey());
        }

    }

    public void run(String fromCurrency, String toCurrency) {
        int fromIdx = currenciesToIndex.get(fromCurrency);
        int toIdx = currenciesToIndex.get(toCurrency);

        // Find shortest paths going both ways
        this.findShortestPaths(fromIdx, toIdx);
        this.findShortestPaths(toIdx, fromIdx);
    }

    public void findShortestPaths(int fromCurrency, int toCurrency) {

        // Calculate shortest paths if not done previously
        if(!shortestPaths.containsKey(fromCurrency)) {
            double[] paths = new double[n];
            Edge[] leastEdge = new Edge[n];

            for(int i = 0; i < n; i++) {
                paths[i] = Double.POSITIVE_INFINITY;
            }
            paths[fromCurrency] = 0.0;

            // Iterate graph n-1 times
            for(int u = 1; u < n; u++) {
                    // Iterate over each edge for the current vertex
                for(Edge edge : this.edges) {
                    int start = edge.getStart();
                    int end = edge.getEnd();
                    if(paths[start] + edge.getWeight() < paths[end]) {
                        paths[end] = paths[start] + edge.getWeight();
                        leastEdge[end] = edge;
                    }
                }
            }

                // Iterate over each edge for the current vertex
                for(Edge edge : this.edges) {
                    int start = edge.getStart();
                    int end = edge.getEnd();
                    if(paths[start] + edge.getWeight() < paths[end] ) {
                        System.out.println("has negative");
                    }
                }

            // Store calculated paths for later use
            shortestPaths.put(fromCurrency, leastEdge);
        }

        this.buildOutputString(fromCurrency, toCurrency);
    }

    private void buildOutputString(int fromCurrency, int toCurrency) {
        StringBuilder temp = new StringBuilder();
        String exchange = String.format("==From %s to %s==",
                indexToCurrencies.get(fromCurrency), indexToCurrencies.get(toCurrency));

        // Back track to find shortest path
        Edge[] shortestPaths = this.shortestPaths.get(fromCurrency);
        int vertex = toCurrency;
        int previousEnd = vertex;

        for(int i = 0; i < n; i ++) {
            if(vertex == fromCurrency || shortestPaths[vertex].getStart() == previousEnd) {
                temp.insert(0,indexToCurrencies.get(fromCurrency) + " -> " + indexToCurrencies.get(vertex));
                break;
            } else {
                temp.insert(0," -> " + indexToCurrencies.get(shortestPaths[vertex].getEnd()));
                previousEnd = vertex;
                vertex = shortestPaths[vertex].getStart();
            }
        }
        System.out.println(exchange);
        System.out.println(temp + "\n");
    }
}

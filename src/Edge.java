public class Edge {
    private final int start, end;
    private double weight;

    public Edge(int edgeStart, int edgeEnd, double edgeWeight) {
        this.start = edgeStart;
        this.end = edgeEnd;
        this.weight = edgeWeight;
    }

    public int getStart() {return this.start;}
    public int getEnd() {return this.end;}
    public double getWeight() {return this.weight;}
    public void setWeight(double weight) {this.weight = weight;}
}


public class BestConversionFinder {

    private String[] currencies;
    private double[][] connectivityTable;

    public BestConversionFinder(String[] currencies, double[][] connectivityTable) {
        this.currencies = currencies;
        this.connectivityTable = connectivityTable;

        // Convert rate to edge weights
        this.convertRatesToWeights();
    }

    /**
     * Takes a connectivity table of rates set on instantiation and converts all the direct exchange rates to weights
     */
    private void convertRatesToWeights() {

        for(int i = 0; i < connectivityTable.length; i++) {
            for(int j = 0; j < connectivityTable[i].length; j++) {
                double rate = connectivityTable[i][j];

                // If there is a direct conversion rate we change the rate to a weight;
                if(rate != 0) {
                    double weight = Math.log(1/rate);
                    connectivityTable[i][j] = weight;
                }
            }
        }

    }

    public void run(String fromCurrency, String toCurrency) {

    }
}

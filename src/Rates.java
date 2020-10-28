import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Angelo
 */
public class Rates {

    private ArrayList<double[][]> rateTables;
    private ArrayList<Map<String, Integer>> rateIndexes;

    public Rates() {
        this.rateTables = new ArrayList<>();
        this.rateIndexes = new ArrayList<>();

        this.createRateIndexes();
        this.createRatesTable();;
    }

    public double[][] getRates(int index) {return this.rateTables.get(index);}
    public Map<String, Integer> getIndex(int index) {return this.rateIndexes.get(index);}

    /**
     * @return Rate index to match the rates table provided by getRates()
     */
    private void createRateIndexes() {
        Map<String, Integer> currencies = new HashMap<>();
        currencies.put("AUD", 0);
        currencies.put("EURO", 1);
        currencies.put("MXN", 2);
        currencies.put("NZD", 3);
        currencies.put("USD", 4);
        currencies.put("CNY", 5);
        currencies.put("BDT", 6);
        currencies.put("NPR", 7);
        currencies.put("PEN", 8);
        currencies.put("RUB", 9);
        currencies.put("EGP", 10);

        this.rateIndexes.add(currencies);
        currencies = new HashMap<>();

        currencies.put("AUD", 0);
        currencies.put("EURO", 1);
        currencies.put("MXN", 2);
        currencies.put("NZD", 3);
        currencies.put("USD", 4);

        this.rateIndexes.add(currencies);
    }

    private void createRatesTable() {
        double[][] rates = new double[11][11];

        //conversions added row -> col
        rates[0][0] = 1.0; //AUD - AUD
        rates[0][1] = 0.6056; // AUD - EURO
        rates[0][3] = 1.0733; // AUD - NZD;
        rates[0][4] = 0.7097;// AUD - USD;
        rates[0][5] = 4.7765;// AUD - CNY

        rates[1][0] = 1.6508; //EUR - AUD;
        rates[1][1] = 1.0; //EUR - EURO;
        rates[1][3] = 1.7719; //EUR - NZD
        rates[1][4] = 1.1718; //EUR - USD
        rates[1][5] = 7.8864; //EUR - CNY
        rates[1][9] = 91.4132; //EUR - RUB
        rates[1][10] = 11.7174; //EUR - EGP

        rates[2][2] = 1.0; //MXN - MXN
        rates[2][4] = 0.0467; //MXN - USD
        rates[2][8] = 0.1685; // MXN - PEN

        rates[3][0] = 0.9314; //NZD - AUD
        rates[3][1] = 0.5641; //NZD - EUR
        rates[3][3] = 1.0; //NZD - NZD
        rates[3][4] = 0.6611; // NZD - USD
        rates[3][5] = 4.4496; // NZD - CNY

        rates[4][0] = 1.4086; //USD - AUD
        rates[4][1] = 0.8532; //USD - EUR
        rates[4][2] = 21.3704; //USD - MXN
        rates[4][3] = 1.5120; //USD - NZD
        rates[4][4] = 1.0; //USD - USD;
        rates[4][5] = 6.7297; //USD - CNY
        rates[4][8] = 3.6022; //USD - PEN
        rates[4][9] = 78.006; //USD - RUB

        rates[5][0] = 0.2091; //CNY - AUD
        rates[5][1] = 0.1266; //CNY - EUR
        rates[5][3] = 0.2245; //CNY - NZD
        rates[5][4] = 0.1484; //CNY - USD
        rates[5][5] = 1.0; //CNY - CNY
        rates[5][6] = 12.3629; //CNY - BDT
        rates[5][7] = 17.2090; //CNY - NPR
        rates[5][9] = 11.5818; //CNY - RUB

        rates[6][5] = 0.0779; //BDT - CNY
        rates[6][6] = 1.0; //BDT - BDT
        rates[6][7] = 1.3425; //BDT - NPR

        rates[7][5] = 0.0566; //NPR - CNY
        rates[7][6] = 0.7009; //NPR - BDT
        rates[7][7] = 1.0; //NPR - NPR

        rates[8][2] = 5.9867; //PEN - MXN
        rates[8][4] = 0.2801; // PEN - USD
        rates[8][8] = 1.0;//PEN - PEN

        rates[9][1] = 0.0109;//RUB - EUR
        rates[9][4] = 0.0128;//RUB - USD
        rates[9][5] = 0.0862;//RUB - CNY
        rates[9][9] = 1.0;//RUB - RUB

        rates[10][1] = 0.1383;// EGP - EUR

        this.rateTables.add(rates);
        rates = new double[5][5];

        rates[0][0] = 1.0;
        rates[0][1] = 0.61;
        rates[0][2] = 0.0;
        rates[0][3] = 1.08;
        rates[0][4] = 0.72;

        rates[1][0] = 1.64;
        rates[1][1] = 1.0;
        rates[1][2] = 0.0;
        rates[1][3] = 1.77;
        rates[1][4] = 1.18;

        rates[2][0] = 0.0;
        rates[2][1] = 0.0;
        rates[2][2] = 1.0;
        rates[2][3] = 0.0;
        rates[2][4] = 0.047;

        rates[3][0] = 0.92;
        rates[3][1] = 0.56;
        rates[3][2] = 0.0;
        rates[3][3] = 1.0;
        rates[3][4] = 0.67;

        rates[4][0] = 1.39;
        rates[4][1] = 0.85;
        rates[4][2] = 21.19;
        rates[4][3] = 1.5;
        rates[4][4] = 1.0;

        this.rateTables.add(rates);

    }

    public static double[][] getLectureRates() {
        double[][] rates = new double[6][6];

//        ----sample graph used on Bellman lecture notes
        rates[0][0] = 1.0;
        rates[0][1] = 2.0;
        rates[0][2] = 15.0;
        rates[0][3] = 0;
        rates[0][4] = 0;
        rates[0][5] = 0;

        rates[1][0] = 0;
        rates[1][1] = 1.0;
        rates[1][2] = 9.0;
        rates[1][3] = 11.0;
        rates[1][4] = 5.0;
        rates[1][5] = 0;

        rates[2][0] = 0;
        rates[2][1] = -1.0;
        rates[2][2] = 1.0;
        rates[2][3] = 3.0;
        rates[2][4] = 6.0;
        rates[2][5] = 0;

        rates[3][0] = 0;
        rates[3][1] = 0;
        rates[3][2] = 0;
        rates[3][3] = 1.0;
        rates[3][4] = 5.0;
        rates[3][5] = 2.0;

        rates[4][0] = 0;
        rates[4][1] = 0;
        rates[4][2] = -2.0;
        rates[4][3] = 0;
        rates[4][4] = 1.0;
        rates[4][5] = 7.0;

        rates[5][0] = 0;
        rates[5][1] = 0;
        rates[5][2] = 0;
        rates[5][3] = 1.0;
        rates[5][4] = 0;
        rates[5][5] = 1.0;

        return rates;
    }
}
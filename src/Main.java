public class Main {
    String[] index = Rates.getRatesIndex();
    double[][] rates = Rates.getRates();

    BestConversionFinder BCF = new BestConversionFinder(index, rates);
}

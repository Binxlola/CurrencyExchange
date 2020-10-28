public class Main {

    public static void main(String[] args) {
        Rates rates = new Rates();

        BestConversionFinder BCF = new BestConversionFinder(rates.getIndex(1), rates.getRates(1));
        BCF.run("EURO", "AUD");
        BCF.run("USD", "AUD");
    }
}

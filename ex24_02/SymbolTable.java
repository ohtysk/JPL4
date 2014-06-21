import java.util.Currency;
import java.util.Locale;


public class SymbolTable {
	Locale[] locales = {
			Locale.JAPAN,
			Locale.US,
			Locale.CHINA,
			Locale.FRANCE,
			Locale.GERMANY,
			Locale.ITALY,
	};
	
	Currency[] currencies = new Currency[locales.length];
	{
		for (int i = 0; i < locales.length; i++) {
			currencies[i] = Currency.getInstance(locales[i]); 
		}
	}
	
	public void show() {
		System.out.print("\t");
		for (Currency currency : currencies) {
			String symbol = currency.getCurrencyCode();
			System.out.printf(symbol + "\t");
		}
		System.out.println();
		
		for (Locale locale : locales) {
			System.out.print(locale.getCountry() + "\t");
			for (Currency currency : currencies) {
				String symbol = currency.getSymbol(locale);
				System.out.printf(symbol + "\t");
			}
			System.out.println();
		}
	}
}

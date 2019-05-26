import com.basumatarau.rate.ExchangeRate;
import com.basumatarau.rate.api.Quote;
import com.basumatarau.rate.spi.ExchangeRateProvider;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class ExchangeRateProviderTest {

    @Test
    public void test(){

        final List<ExchangeRateProvider> providers = ExchangeRate.providers();
        Assert.assertTrue("no ExchangeRate interface implementation has been retrieved",
                providers.size() > 0);

        providers.forEach(provider -> {
            System.out.println("Retreiving USD quotes from provider :" + provider);
            List<Quote> quotes = provider.create().getQuotes("USD", LocalDate.now());
            System.out.println(String.format("%14s%12s|%12s", "","Ask", "Bid"));
            System.out.println("----------------------------------------");
            quotes.forEach(quote -> {
                System.out.println("USD --> " + quote.getCurrency() + " : " + String.format("%12f|%12f", quote.getAsk(), quote.getBid()));
            });
        });
    }


}

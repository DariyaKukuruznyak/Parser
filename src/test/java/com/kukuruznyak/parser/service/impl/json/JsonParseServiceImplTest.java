package com.kukuruznyak.parser.service.impl.json;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import com.kukuruznyak.parser.service.impl.json.JsonParseServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class JsonParseServiceImplTest {
    private ParseService parseService = new JsonParseServiceImpl();

    @Test
    public void parse() throws IOException {
        List<Currency> currencyList = parseService
                .parse("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        for (Currency currency : currencyList) {
            System.out.println(currency);
        }
    }
}

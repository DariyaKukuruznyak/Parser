package com.kukuruznyak.parser.service.impl.xml;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class XmlParseServiceImplTest {
    private ParseService parseService = new XmlParseServiceImpl();

    @Test
   public void parse() throws IOException {
        List<Currency> currencyList = parseService
                .parse("http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange");
        for (Currency currency : currencyList) {
            System.out.println(currency);
        }
    }
}
package com.kukuruznyak.parser.service.impl.html;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import com.kukuruznyak.parser.service.impl.json.JsonParseServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HtmlParseServiceImplTest {
    private ParseService parseService = new HtmlParseServiceImpl();
    @Test
    public void parse() throws Exception {
        List<Currency> currencyList = parseService
                .parse("https://minfin.com.ua/currency/");
        for (Currency currency : currencyList) {
            System.out.println(currency);
        }

    }

}
package com.kukuruznyak.parser.service.impl.xml;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XmlParseServiceImpl implements ParseService {
    private static final String CURRENCY_NODE = "currency";
    private static final String ID_NODE = "r030";
    private static final String NAME_NODE = "txt";
    private static final String SHORT_NAME_NODE = "cc";
    private static final String RATE_NODE = "rate";
    private static final String EXCHANGE_DATE_NODE = "exchangedate";
    private Map<String, Boolean> map;

    public XmlParseServiceImpl() {
        this.map = new HashMap<>();
        map.put(CURRENCY_NODE, false);
        map.put(ID_NODE, false);
        map.put(NAME_NODE, false);
        map.put(SHORT_NAME_NODE, false);
        map.put(RATE_NODE, false);
        map.put(EXCHANGE_DATE_NODE, false);
    }

    public List<Currency> parse(final String url) {
        List<Currency> currencyList = new LinkedList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                Currency currentCurrency = new Currency();

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    for (String node : map.keySet()) {
                        if (qName.equalsIgnoreCase(node)) {
                            map.put(node, true);
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase(CURRENCY_NODE)) {
                        currencyList.add(currentCurrency);
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    for (String node : map.keySet()) {
                        if (map.get(node)) {
                            currentCurrency = fillCurrency(currentCurrency, node, new String(ch, start, length));
                            map.put(node, false);
                        }
                    }
                }
            };
            saxParser.parse(url, handler);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return currencyList;
    }

    private Currency fillCurrency(Currency currency, String field, String value) {
        switch (field) {
            case ID_NODE:
                currency.setId(new Long(value));
                break;
            case NAME_NODE:
                currency.setName(value);
                break;
            case SHORT_NAME_NODE:
                currency.setShortName(value);
                break;
            case RATE_NODE:
                currency.setRate(new BigDecimal(value));
                break;
            case EXCHANGE_DATE_NODE:
                currency.setExchangeDate(value);
                break;
            case CURRENCY_NODE:
                currency = new Currency();
                break;
            default:
                break;
        }
        return currency;
    }
}

package com.kukuruznyak.parser.service.impl.html;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class HtmlParseServiceImpl implements ParseService {
    public List<Currency> parse(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Currency> currencyList = new LinkedList<>();
        List<Element> elementList = doc.select("table.table-response.mfm-table.mfcur-table-lg.mfcur-table-lg-currency.has-no-tfoot tbody tr");
        for (Element element : elementList) {
            Currency currency = new Currency();
            currency.setId((long) currencyList.size() + 1);
            currency.setName(element.getElementsByClass("mfcur-table-cur").text());
            currency.setShortName(element.getElementsByTag("a")
                    .get(0).attr("href")
                    .split("/")[2]);
            currency.setRate(new BigDecimal(element.getElementsByClass("mfcur-nbu-full-wrap")
                    .text()
                    .split(" ")[0]));
            currencyList.add(currency);
        }
        return currencyList;
    }


}

package com.kukuruznyak.parser.service.impl.xml;

import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class XmlParseServiceImpl implements ParseService {
    public List<Currency> parse(String url) {
        List<Currency> currencyList = new LinkedList<Currency>();





        return currencyList;
    }


}

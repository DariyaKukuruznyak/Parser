package com.kukuruznyak.parser.service;

import com.kukuruznyak.parser.domain.Currency;

import java.io.IOException;
import java.util.List;

public interface ParseService {
    List<Currency> parse(String url) throws IOException;
}

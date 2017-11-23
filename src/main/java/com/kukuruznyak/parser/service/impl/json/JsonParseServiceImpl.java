package com.kukuruznyak.parser.service.impl.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.kukuruznyak.parser.domain.Currency;
import com.kukuruznyak.parser.service.ParseService;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JsonParseServiceImpl implements ParseService {

    public List<Currency> parse(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule(
                CurrencyDeserializer.class.getSimpleName(),
                new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Currency.class, new CurrencyDeserializer());
        objectMapper.registerModule(module);
        return objectMapper.readValue(new URL(url),
                new TypeReference<List<Currency>>() {
                });
    }
}

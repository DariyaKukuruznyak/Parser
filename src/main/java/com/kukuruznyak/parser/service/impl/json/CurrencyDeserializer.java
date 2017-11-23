package com.kukuruznyak.parser.service.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.kukuruznyak.parser.domain.Currency;

import java.io.IOException;
import java.math.BigDecimal;

public class CurrencyDeserializer extends StdDeserializer<Currency> {
    private static final String ID_NODE = "r030";
    private static final String NAME_NODE = "txt";
    private static final String SHORT_NAME_NODE = "cc";
    private static final String RATE_NODE = "rate";
    private static final String EXCHANGE_DATE_NODE = "exchangedate";

    public CurrencyDeserializer() {
        this(null);
    }

    public CurrencyDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Currency deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        Currency currency = new Currency();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        JsonNode idNode = node.get(ID_NODE);
        currency.setId(idNode.asLong());
        JsonNode nameNode = node.get(NAME_NODE);
        currency.setName(nameNode.asText());
        JsonNode shortNameNode = node.get(SHORT_NAME_NODE);
        currency.setShortName(shortNameNode.asText());
        JsonNode rateNode = node.get(RATE_NODE);
        currency.setRate(new BigDecimal(rateNode.asText()));
        JsonNode exchangeDateNode = node.get(EXCHANGE_DATE_NODE);
        currency.setExchangeDate(exchangeDateNode.asText());
        return currency;
    }
}

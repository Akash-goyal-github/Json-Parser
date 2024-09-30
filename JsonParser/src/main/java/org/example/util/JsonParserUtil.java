package org.example.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.example.exception.JsonParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonParserUtil {

    // Configure ObjectMapper for arbitrary precision
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)  // For BigInteger
            .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);  // For BigDecimal

    /**
     * Parses a valid JSON string into a corresponding Java object.
     * Can handle JSON objects, arrays, and primitive types.
     *
     * @param jsonString The input JSON string
     * @return A parsed Object (Map, List, or primitive types)
     * @throws JsonParseException If the JSON string is invalid or an error occurs during parsing
     */
    public static Object parseJson(String jsonString) throws JsonParseException {
        try {
            JsonParser jsonParser = objectMapper.createParser(jsonString);
            jsonParser.nextToken(); // Move to the first token to determine the type

            switch (jsonParser.currentToken()) {
                case START_OBJECT:
                    // JSON Object -> Map
                    return objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});
                case START_ARRAY:
                    // JSON Array -> List
                    return objectMapper.readValue(jsonString, new TypeReference<List<Object>>() {});
                default:
                    // Scalar value (numbers, strings, booleans, etc.)
                    return objectMapper.readValue(jsonString, Object.class);
            }
        } catch (IOException e) {
            throw new JsonParseException("Failed to parse JSON string", e);
        }
    }
}

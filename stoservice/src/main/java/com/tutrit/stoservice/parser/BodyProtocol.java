package com.tutrit.stoservice.parser;

import java.util.Map;

public interface BodyProtocol {

    Map<String, String> parseBodyToObjectValues(String input);
}

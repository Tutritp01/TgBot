package com.tutrit.stoservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoServiceApplicationTest {

    private ByteArrayOutputStream sink;
    private PrintStream controlledOut;
    private ByteArrayInputStream controlledIn;
    private PrintStream defaultOut;
    private InputStream defaultIn;

    @ParameterizedTest
    @MethodSource("testCases")
    void test(final String input, final String expected) {
        setControlledStreamsWithInput(input);
        try {
            StoServiceApplication.main(new String[]{});
            controlledOut.flush();
            assertEquals(expected, sink.toString().trim(), "Error on input " + input);
        } finally {
            setStandardStreams();
        }
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1", "/*ьлтплв*/"),
                Arguments.of("0", "/*ьлтплв*/"));
    }

    private void setControlledStreamsWithInput(final String input) {

        sink = new ByteArrayOutputStream();
        controlledOut = new PrintStream(sink);
        controlledIn = new ByteArrayInputStream(input.getBytes());

        defaultOut = System.out;
        defaultIn = System.in;

        System.setOut(controlledOut);
        System.setIn(controlledIn);
    }

    private void setStandardStreams() {
        System.setOut(defaultOut);
        System.setIn(defaultIn);
    }
}

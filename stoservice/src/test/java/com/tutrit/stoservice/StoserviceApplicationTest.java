package com.tutrit.stoservice;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoserviceApplicationTest {

    private ByteArrayOutputStream sink;
    private PrintStream controlledOut;
    private ByteArrayInputStream controlledIn;
    private PrintStream defaultOut;
    private InputStream defaultIn;


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

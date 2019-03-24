package Test;

import PrintPrimeone.PrintPrime;

import static org.junit.Assert.*;



import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.io.PipedInputStream;

import java.io.PipedOutputStream;

import java.io.PrintStream;

import java.util.Scanner;

 

import org.hamcrest.core.AllOf;

import org.junit.Before;

import org.junit.Test;

public class TestPrime {

	
    PrintPrime p;
    ByteArrayOutputStream str;
     
    @Before
    public void setup() throws Exception{
        p = new PrintPrime();
        str = new ByteArrayOutputStream();
        System.setOut(new PrintStream(str));
    }
     
    @Test
    public void test() {
        String output = new String("Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n");
        p.printPrimes(5);
        assertEquals(output, str.toString());
    }




	
}

package com.softserve.homework04;
/**
 * 1st tests number of brackets in a string line- test data is driven from a .csv file
 * 2nd tests RuntimeException
 */

import com.softserve.homework03.brackets.Brackets03;
import com.softserve.homework03.symbols.ISymbols;
import com.softserve.homework03.symbols.Symbols;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;

public class App04Test {

    @BeforeSuite
    public void setUp() {
        System.out.println("Started running tests.");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Finished running tests.");
    }

    @DataProvider(name = "testBrackets")
    public String[][] ReadfromCSV() throws InterruptedException {

        String[] data= null;
        String [][] returnObj = null;

        //System.out.println(System.getProperty("user.dir"));
        String csvFile = System.getProperty("user.dir")+ "/src/test/resources/testData_hw04.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> content = new ArrayList<>();

        try {
            //this loop is pseudo code
            br = new BufferedReader(new FileReader(csvFile));
            int datalength = 0;
            int listsize =0;

            while ((line = br.readLine()) != null) {
                // use comma as separator
                content.add(line);
            }
            System.out.println(content);

            listsize = content.size();
            datalength = content.get(0).split(cvsSplitBy).length;
            returnObj = new String[listsize][datalength];

            for (int i = 0; i<listsize; i++) {

                data = content.get(i).split(cvsSplitBy);
                for (int j=0; j< datalength ; j++) {
                    returnObj[i][j] = data[j];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Test data is prepared");
        return returnObj;
    }

    @Test(dataProvider = "testBrackets")
    public void numberBracketsTest (String symbs, String count) {
        ISymbols symbolsTest = PowerMockito.mock(ISymbols.class);
        PowerMockito.when(symbolsTest.verifyBrackets(Mockito.anyString())).thenReturn(true);
        Brackets03 productService = new Brackets03(symbolsTest);
        //
        int actual;
        int expected;
        //
        expected = Integer.parseInt(count);
        actual = productService.numberBrackets(symbs);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void bracketsRuntimeException () {
        ISymbols symbols = new Symbols();
        Brackets03 bracketsToTest = new Brackets03(symbols);

        Assert.assertThrows(RuntimeException.class, () -> bracketsToTest.numberBrackets("()("));
    }
}
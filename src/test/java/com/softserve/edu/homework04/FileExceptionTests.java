package com.softserve.edu.homework04;

/*
  4.1) Доповнити систему тестів на метод numberBrackets().
  Додати тест, який отримує дані з файлу та тест, який очікує появу RuntimeException.
*/

import com.softserve.edu.homework01.BracketsAppImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileExceptionTests {
    private BracketsAppImp bracketsAppSpy;

    @BeforeClass
    public void prepareMocks() {
        this.bracketsAppSpy = Mockito.spy(BracketsAppImp.class);
    }

    @AfterTest
    public void resetMock() {
        Mockito.reset(this.bracketsAppSpy);
    }

    @DataProvider(name = "txtFile")
    public Object[][] getDataFromFile() throws IOException {
        int rowNumber = 50;
        int numberElements = 2;
        String separator = ",";
        String filePath = "src/test/java/com/softserve/edu/homework04/testData.txt";

        Object[][] returnObj = new String[rowNumber][numberElements];

        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        for (int i = 0; i < rowNumber; i++) {
            String currentLine = br.readLine();
            String[] elements = currentLine.split(separator);
            returnObj[i] = elements;
        }

        br.close();

        return returnObj;
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void throwRuntimeException() {
        Mockito.doReturn(false).when(this.bracketsAppSpy).verifyBrackets("(");
        this.bracketsAppSpy.numberBrackets("(");
        //Assert.assertThrows(RuntimeException.class, () -> this.bracketsAppSpy.numberBrackets("("));
    }

    @Test(dataProvider = "txtFile")
    public void calculateBracketsCountSpyBefore(String bracketsString, String bracketsCount) {
        Mockito.doReturn(true).when(this.bracketsAppSpy).verifyBrackets(bracketsString);
        Assert.assertEquals(this.bracketsAppSpy.numberBrackets(bracketsString), Integer.parseInt(bracketsCount));
    }
}

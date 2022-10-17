package models;

import java.util.Date;

public class TestModel {
    private String testString = "Test";
    private Integer testInt = 10;
    private Character testChar = 'a';
    private Date testDate = new Date();

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public Integer getTestInt() {
        return testInt;
    }

    public void setTestInt(Integer testInt) {
        this.testInt = testInt;
    }

    public Character getTestChar() {
        return testChar;
    }

    public void setTestChar(Character testChar) {
        this.testChar = testChar;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}

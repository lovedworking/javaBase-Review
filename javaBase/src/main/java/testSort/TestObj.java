package testSort;

import java.util.Arrays;

public class TestObj {
    private String code;

    public TestObj(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static void main(String[] args) {
        TestObj[] objArr=new TestObj[3];
        for (int i = 0; i < objArr.length; i++) {
            TestObj testObj = new TestObj("" + i);
            objArr[i]=testObj;
        }


    }
}


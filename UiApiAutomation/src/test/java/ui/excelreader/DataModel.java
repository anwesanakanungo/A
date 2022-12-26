package ui.excelreader;

import com.creditdatamw.zerocell.annotation.Column;
import lombok.Getter;

@Getter
public class DataModel {
    @Column(index = 0, name = "TC")
    private String testCase ;
    @Column(index = 1 ,name = "URL")
    private  String URL;
    @Column(index = 2 ,name = "username")
    private String username ;
    @Column(index = 3 ,name = "password")
    private String password ;
    @Column(index = 4 ,name = "pinCode")
    private int pinCode ;
    @Column(index = 5 ,name = "firstname")
    private String firstname ;
    @Column(index = 6 ,name = "lastname")
    private String lastname ;

    @Override
    public String toString() {
        return "TestDataModel{" +
                "testCase='" + testCase + '\'' +
                ", browser='" + URL + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pinCode=" + pinCode +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

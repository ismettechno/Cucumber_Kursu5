package StepDefinitions;

import Utilities.DBUtility;
import io.cucumber.java.en.Then;

import java.util.ArrayList;

public class _11_JDBCSteps {
    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {
        // DB den gerekli bilgileri alalım
        ArrayList< ArrayList<String> > dbList= DBUtility.getListData(sorgu);

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(1).trim());
        }



    }
}

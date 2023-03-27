package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _05_DataTableOrnek {
    @When("Write username {string}")
    public void writeUsername(String userName) {
        System.out.println("userName = " + userName);
    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String userName, String password) {
        System.out.println("userName and pass = " + userName+" "+password);
    }


    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable elemanlar) {
       List<String> listElemanlar=elemanlar.asList(String.class);

       for(String u: listElemanlar)
           System.out.println("u = " + u);
    }

    @And("Write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable elemanlar) {
      List< List<String> > listElemanlar= elemanlar.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++) {
            System.out.println("listElemanlar = " +
                    listElemanlar.get(i).get(0)+" "+ //username
                    listElemanlar.get(i).get(1) );   // password
            //listElemanlar.get(i).get(2)
        }

    }


}

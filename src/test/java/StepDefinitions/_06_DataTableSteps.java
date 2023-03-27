package StepDefinitions;

import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _06_DataTableSteps {
    LeftNav ln=new LeftNav();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable items) {
       List<String> strButtons=items.asList(String.class);

       for (String strButton: strButtons) {
           WebElement element=ln.getWebElement(strButton);
           ln.clickFunction(element);
       }

    }
}

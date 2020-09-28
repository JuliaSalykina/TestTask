import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

        public WebDriver driver;
        public  Search (WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        @FindBy(css = "[for='7893318_152722']")
        private WebElement Pc1;

        @FindBy(css = "[for='7893318_152981']")
        private WebElement Pc2;

//        @FindBy(css = "[data-tid='ce80a508']")
//        private WebElement valuePc;

        @FindBy(xpath = "//a[@class = '_27nuSZ19h7 wwZc93J2Ao cia-cs']")
        private WebElement valuePc;

        public void choose () {
            try {
                Pc1.click();
            }
            catch (Exception e) {
                System.out.println("Element not clicked");
            }
        }

        public void choose1 () {
            try {
                Pc2.click();
            }
            catch (Exception e) {
                System.out.println("Element not clicked");
            }
        }

        public String name () {
            String value = valuePc.getText();
            return (value);
        }

}

package Orange_Dashboard;

import org.apache.hc.client5.http.entity.BrotliDecompressingEntity;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.ThreeDLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PunchIn_Punch_out extends BrowserLaunch {
    @Test
    public void LoginandLogout() throws InterruptedException {
        WebElement Text = driver.findElement(By.cssSelector("p[class='oxd-text oxd-text--p orangehrm-attendance-card-state']"));
        String  alpha = Text.getText();
        Assert.assertEquals(alpha,"Punched Out", "validation failed");
        System.out.println("User is in punched out");

        WebElement PunchIN = driver.findElement(By.xpath("//button[@type='button']/descendant::i[@class='oxd-icon bi-chevron-left']"));
        PunchIN.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.cssSelector("textarea[placeholder='Type here']")).sendKeys("I logging today");
        Thread.sleep(4000);

//       if (alpha.equals("Punched Out"))
//       {
//           System.out.println("valid");
//       }
//       else  {
//           System.out.println("invalid");
//       }



    }
}

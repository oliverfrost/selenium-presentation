package controls;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContextMenu extends Control {

    public ContextMenu(WebElement element) {
        super(element);
    }

    public void remove(){
        element.findElement(By.className("trash")).click();
    }

}
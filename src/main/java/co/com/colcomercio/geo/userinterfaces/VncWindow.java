package co.com.colcomercio.geo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VncWindow extends PageObject {
    public static final Target HOST = net.serenitybdd.screenplay.targets.Target.the("").located(By.name("RealVNC Viewer"));
    public static final Target EDIT_BAR = net.serenitybdd.screenplay.targets.Target.the("Field to enter the host of the cash register").locatedBy("//ComboBox/Edit");
    public static final Target PASSWORD = Target.the("Field to enter the password").locatedBy("//Edit");
    public static final Target AUTOSCALE = Target.the("autoescala").locatedBy("/Window/CheckBox[2]");
    public static final Target CONECT = Target.the("conectar").locatedBy("/Window/Button[2]");
}

package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.models.productList.ProductList;
import co.com.colcomercio.geo.tasks.ValidateTextOnScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.awt.event.KeyEvent;

import static co.com.colcomercio.geo.utils.WaitingTime.LOW_TIME;

public class AddProduct implements Interaction {
    private final ProductList dataProduct;

    public AddProduct(ProductList dataProduct) {
        this.dataProduct = dataProduct;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidateTextOnScreen.contains("articulo"),
                EnterEan.enterTheEanIntoCash(dataProduct),
                PresionarTecla.conCodigo(KeyEvent.VK_ENTER),
                PerformWait.wait(2),
                //ValidateTextOnScreen.contains("Registrados 4"),
                PresionarTecla.conCodigo(KeyEvent.VK_F9),
                PerformWait.wait(LOW_TIME)
        );
    }
    public static AddProduct agregate(ProductList dataProduct){
        return Tasks.instrumented(AddProduct.class, dataProduct);
    }
}

package co.com.colcomercio.geo.interactions;

import co.com.colcomercio.geo.models.productList.ProductList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.awt.event.KeyEvent;
import java.util.stream.IntStream;

public class EnterEan implements Task {
    private final ProductList dataProductList;

    public EnterEan(ProductList dataProductList) {
        this.dataProductList = dataProductList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        IntStream.range(0, dataProductList.getDataProductList().getProductId().size()).forEach(
                product -> {actor.attemptsTo(
                            EscribirTextoConTeclado.elTexto(dataProductList.getDataProductList().getProductId().get(product)),
                            PresionarTecla.conCodigo(KeyEvent.VK_ENTER)
                    );
                    }
        );

    }
    public static EnterEan enterTheEanIntoCash(ProductList dataProductList){
        return Tasks.instrumented(EnterEan.class,dataProductList);
    }
}

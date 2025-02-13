package co.com.colcomercio.geo.stepdefinitions;

import co.com.colcomercio.geo.interactions.AddProduct;
import co.com.colcomercio.geo.models.productList.ProductList;
import co.com.colcomercio.geo.utils.GetDataModel;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;

public class AddProducts {
    private final Actor actorWindows = Actor.named("Actor windows") ;
    @Dado("agrega {string} productos de tipo {string}")
    public void agregaProductosDeTipo(String n,String producto) {

        ProductList dataProducts = GetDataModel.productList(producto);

            actorWindows.wasAbleTo(
                    AddProduct.agregate(dataProducts)
            );
    }
}

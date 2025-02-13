package co.com.colcomercio.geo.utils;


import co.com.colcomercio.geo.models.newUsers.NewUsers;
import co.com.colcomercio.geo.models.productList.ProductList;
import co.com.colcomercio.geo.models.users.Users;
import co.com.colcomercio.geo.models.vnc.Vnc;

import java.util.List;
import java.util.NoSuchElementException;

public class GetDataModel {
    private GetDataModel() {
    }

    public static Vnc vnc(String key) {
        List<Vnc> data = MyReader.ofInformationWith("src/test/resources/data/vnc.json")
                .andModel(Vnc.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().orElseThrow(() -> new NoSuchElementException("DONT_SEARCH"));
    }

    public static ProductList productList(String key) {
        List<ProductList> data = MyReader.ofInformationWith("src/test/resources/data/productList.json")
                .andModel(ProductList.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().orElseThrow(() -> new NoSuchElementException("no se encontraron productos"));
    }

    public static Users users(String key) {
        List<Users> data = MyReader.ofInformationWith("src/test/resources/data/users.json")
                .andModel(Users.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().orElseThrow(() -> new NoSuchElementException("no se encontaron usuarios"));
    }

    public static NewUsers Newusers(String key) {
        List<NewUsers> data = MyReader.ofInformationWith("src/test/resources/data/newUsers.json")
                .andModel(NewUsers.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().orElseThrow(() -> new NoSuchElementException("DONT_SEARCH"));
    }
}

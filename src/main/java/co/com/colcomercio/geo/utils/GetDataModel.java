package co.com.colcomercio.geo.utils;


import co.com.colcomercio.geo.models.vnc.Vnc;

import java.util.List;

public class GetDataModel {
    private GetDataModel() {
    }

    public static Vnc vnc(String key) {
        List<Vnc> data = MyReader.ofInformationWith("src/test/resources/data/vnc.json")
                .andModel(Vnc.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().get();
    }

}

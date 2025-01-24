package co.com.colcomercio.geo.utils;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class MyReader {
    private final String path;
    public MyReader(String path) {
        this.path = path;
    }

    public static MyReader ofInformationWith(String path){
        return new MyReader(path);
    }

    public <T> List<T> andModel(Class<T> clase) {
        Type objectType = new TypeToken<List<T>>(){}.where(new TypeParameter<T>() {}, clase).getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader localFile = new FileReader(path)) {
            return gson.fromJson(localFile, objectType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}

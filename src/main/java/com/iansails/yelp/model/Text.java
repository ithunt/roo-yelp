package com.iansails.yelp.model;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Text {

    /**
     */
    private String text;




    public String toJson() {
        return "\"" + text + "\"" ;
    }

    public String toJson(String[] fields) {
        return toJson();
    }

    public static Text fromJsonToText(String json) {
        return new JSONDeserializer<Text>().use(null, Text.class).deserialize(json);
    }

    public static String toJsonArray(Collection<Text> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

    public static String toJsonArray(Collection<Text> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }

    public static Collection<Text> fromJsonArrayToTexts(String json) {
        return new JSONDeserializer<List<Text>>().use(null, ArrayList.class).use("values", Text.class).deserialize(json);
    }

}

// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.iansails.yelp.model.yelp;

import com.iansails.yelp.model.yelp.YelpSearchResult;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect YelpSearchResult_Roo_Json {
    
    public String YelpSearchResult.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String YelpSearchResult.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static YelpSearchResult YelpSearchResult.fromJsonToYelpSearchResult(String json) {
        return new JSONDeserializer<YelpSearchResult>().use(null, YelpSearchResult.class).deserialize(json);
    }
    
    public static String YelpSearchResult.toJsonArray(Collection<YelpSearchResult> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String YelpSearchResult.toJsonArray(Collection<YelpSearchResult> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<YelpSearchResult> YelpSearchResult.fromJsonArrayToYelpSearchResults(String json) {
        return new JSONDeserializer<List<YelpSearchResult>>().use(null, ArrayList.class).use("values", YelpSearchResult.class).deserialize(json);
    }
    
}
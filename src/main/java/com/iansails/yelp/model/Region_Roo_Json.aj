// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.iansails.yelp.model;

import com.iansails.yelp.model.Region;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Region_Roo_Json {
    
    public String Region.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Region.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Region Region.fromJsonToRegion(String json) {
        return new JSONDeserializer<Region>().use(null, Region.class).deserialize(json);
    }
    
    public static String Region.toJsonArray(Collection<Region> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Region.toJsonArray(Collection<Region> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Region> Region.fromJsonArrayToRegions(String json) {
        return new JSONDeserializer<List<Region>>().use(null, ArrayList.class).use("values", Region.class).deserialize(json);
    }
    
}

package com.iansails.yelp.model.yelp;
import com.google.gson.*;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import com.iansails.yelp.model.Region;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import com.iansails.yelp.model.StringList;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class YelpSearchResult implements JsonDeserializer<YelpSearchResult> {

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Region region;

    /**
     */
    private int total;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Business> businesses = new ArrayList<Business>();

    /**
     */
    @ElementCollection
    private List<String> categories = new ArrayList<String>();


    @Override
    public YelpSearchResult deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        YelpSearchResult yelpSearchResult = new YelpSearchResult();
        Gson gson = new GsonBuilder().registerTypeAdapter(Business.class, new Business()).create();



        JsonObject jsonObject = json.getAsJsonObject();
        yelpSearchResult.total = !jsonObject.has("total") ? 0 : jsonObject.get("total").getAsInt();

        JsonArray business = jsonObject.getAsJsonArray("businesses");

        yelpSearchResult.businesses = new ArrayList<Business>();
        Iterator<JsonElement> businesses = business.iterator();

        while (businesses.hasNext())
            yelpSearchResult.businesses.add(gson.fromJson(businesses.next(), Business.class));


        yelpSearchResult.region = gson.fromJson(jsonObject.get("region"), Region.class);

        if(jsonObject.has("categories")) {
            JsonArray categories = jsonObject.getAsJsonArray("categories");
            yelpSearchResult.categories = new ArrayList<String>();
            try {
                Iterator<JsonElement> iter = categories.iterator();
                while (iter.hasNext()) {
                    Iterator<JsonElement> iter2 = iter.next().getAsJsonArray().iterator();
                    while(iter2.hasNext())
                        this.categories.add(iter2.next().getAsString());
                }
            } catch (Exception ex) {}
        }

        return yelpSearchResult;
    }
}

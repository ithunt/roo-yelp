package com.iansails.yelp.model.yelp;
import com.google.gson.*;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;
import com.iansails.yelp.model.Coordinate;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.iansails.yelp.model.StringList;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Location implements JsonDeserializer<Location>{

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Coordinate coordinate;

    /**
     */
    private String city;

    /**
     */
    private String stateCode;

    /**
     */
    private String postalCode;

    /**
     */
    private String countryCode;

    /**
     */
    private String crossStreets;

    /**
     */
    private String neighborhoods;

    /**
     */
    private int geoAccuracy;

    /**
     */
    @ElementCollection()
    private List<String> displayAddress;

    /**
     */
    @ElementCollection()
    private List<String> address;

    @Override
    public Location deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Location location = new Location();

        JsonObject jsonObject = json.getAsJsonObject();
        location.city = jsonObject.get("city").getAsString();
        location.stateCode = !jsonObject.has("state_code") ? "" : jsonObject.get("state_code").getAsString();
        location.postalCode = !jsonObject.has("postal_code") ? "" : jsonObject.get("postal_code").getAsString();
        location.countryCode = !jsonObject.has("country_code") ? "" : jsonObject.get("country_code").getAsString();
        location.crossStreets = !jsonObject.has("cross_streets") ? "" : jsonObject.get("cross_streets").getAsString();
        location.geoAccuracy = !jsonObject.has("geo_accuracy") ? 0 : jsonObject.get("geo_accuracy").getAsInt();

        Gson gson = new Gson();
        location.coordinate = gson.fromJson(jsonObject.get("location"), Coordinate.class);

        Iterator<JsonElement> iter = jsonObject.get("display_address").getAsJsonArray().iterator();
        location.displayAddress = new ArrayList<String>();
        while(iter.hasNext())
            location.displayAddress.add(iter.next().getAsString());

        iter = jsonObject.get("address").getAsJsonArray().iterator();
        location.address = new ArrayList<String>();
        while(iter.hasNext())
            location.address.add(iter.next().getAsString());


        return location;
    }
}

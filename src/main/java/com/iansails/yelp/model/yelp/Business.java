package com.iansails.yelp.model.yelp;
import com.google.gson.*;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Business implements JsonDeserializer<Business> {

    /**
     */
    private String name;

    /**
     */
    private String imageUrl;

    /**
     */
    private String url;

    /**
     */
    private String mobileUrl;

    /**
     */
    private String phone;

    /**
     */
    private String displayPhone;

    /**
     */
    private String ratingImgUrl;

    /**
     */
    private String ratingImgUrlSmall;

    /**
     */
    private String snippetText;

    /**
     */
    private String snippetImgUrl;

    /**
     */
    private int reviewCount;

    /**
     */
    private double distance;

    /**
     */
    @ElementCollection()
    private List<String> categories = new ArrayList<String>();

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    /**
     */
    private String id;


    @Override
    public Business deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        Business business = new Business();

        JsonObject jsonObject = json.getAsJsonObject();
        business.name = jsonObject.get("name").getAsString();
        business.imageUrl = !jsonObject.has("image_url") ? "" : jsonObject.get("image_url").getAsString();
        business.url = !jsonObject.has("url") ? "" :jsonObject.get("url").getAsString();
        business.mobileUrl = !jsonObject.has("mobile_url") ? "" : jsonObject.get("mobile_url").getAsString();
        business.phone = !jsonObject.has("phone") ? "" : jsonObject.get("phone").getAsString();
        business.displayPhone = !jsonObject.has("display_phone") ? "" : jsonObject.get("display_phone").getAsString();
        business.ratingImgUrl = jsonObject.get("rating_img_url").getAsString();
        business.ratingImgUrlSmall = jsonObject.get("rating_img_url_small").getAsString();
        business.snippetText = jsonObject.get("snippet_text").getAsString();
        business.snippetImgUrl = !jsonObject.has("snippet_img_url") ? "" : jsonObject.get("snippet_img_url").getAsString() ;
        business.reviewCount = !jsonObject.has("review_count") ? 0 : jsonObject.get("review_count").getAsInt();
        business.distance = jsonObject.get("distance").getAsDouble();

        business.id = !jsonObject.has("id") ? "" : jsonObject.get("id").getAsString();

        JsonArray categories = jsonObject.getAsJsonArray("categories");
        business.categories = new ArrayList<String>();
        Iterator<JsonElement> iter = categories.iterator();
        while (iter.hasNext()) {
            Iterator<JsonElement> iter2 = iter.next().getAsJsonArray().iterator();
            while(iter2.hasNext())
                this.categories.add(iter2.next().getAsString());
        }

        business.location = (new Location()).deserialize(jsonObject.get("location"), Location.class, context);

        return business;



    }

    }

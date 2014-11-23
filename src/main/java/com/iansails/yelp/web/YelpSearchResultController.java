package com.iansails.yelp.web;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.iansails.yelp.Responses;
import com.iansails.yelp.YelpV2API;
import com.iansails.yelp.model.StringList;
import com.iansails.yelp.model.yelp.YelpSearchResult;
import com.iansails.yelp.service.YelpSearchResultService;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/yelpsearch")
@Controller
@RooWebScaffold(path = "yelpsearchresults", formBackingObject = YelpSearchResult.class)
public class YelpSearchResultController {

   @Autowired
    YelpSearchResultService yelpSearchResultService;



    @RequestMapping("go")
    @ResponseBody
    public org.springframework.http.ResponseEntity<String> get() {


        // Define your keys, tokens and secrets.  These are available from the Yelp website.
        String CONSUMER_KEY = "wGAW7V7cfx9kZSPMgXngZw";
        String CONSUMER_SECRET = "aHRH--9D0WxAadeOq9QCsv4hlS8";
        String TOKEN = "q6kuCNTmvhYQDgMUDvCDi3uBBbLgeAeN";
        String TOKEN_SECRET = "c2aZMBufx2CuM26vCDnIeRWx0xM";

        // Some example values to pass into the Yelp search service.
        String lat = "44.476103";
        String lng = "-73.211756";
        String category = "bars,restaurants";

        // Execute a signed call to the Yelp service.
        OAuthService service = new ServiceBuilder().provider(YelpV2API.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).build();
        Token accessToken = new Token(TOKEN, TOKEN_SECRET);
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        request.addQuerystringParameter("ll", lat + "," + lng);
        request.addQuerystringParameter("category_filter", category);
        service.signRequest(accessToken, request);
        Response response = request.send();
        String rawData = response.getBody();

        Gson gson = new GsonBuilder().registerTypeAdapter(YelpSearchResult.class, new YelpSearchResult()).create();
        YelpSearchResult ysr = gson.fromJson(rawData, YelpSearchResult.class);

        yelpSearchResultService.saveYelpSearchResult(ysr);

        return Responses.jsonOk(rawData);



//        // Sample of how to turn that text into Java objects.
//        try {
//            YelpSearchResult places = new Gson().fromJson(rawData, YelpSearchResult.class);
//
//            System.out.println("Your search found " + places.getTotal() + " results.");
//            System.out.println("Yelp returned " + places.getBusinesses().size() + " businesses in this request.");
//            System.out.println();
//
//            for(Business biz : places.getBusinesses()) {
//                System.out.println(biz.getName());
//                for(String address : biz.getLocation().getAddress()) {
//                    System.out.println("  " + address);
//                }
//                System.out.print("  " + biz.getLocation().getCity());
//                System.out.println(biz.getUrl());
//                System.out.println();
//            }
//
//
//        } catch(Exception e) {
//            System.out.println("Error, could not parse returned data!");
//            System.out.println(rawData);
//        }
    }

}

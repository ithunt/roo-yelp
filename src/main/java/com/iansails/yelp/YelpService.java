package com.iansails.yelp;


import com.google.gson.Gson;
import com.iansails.yelp.model.yelp.Business;
import com.iansails.yelp.model.yelp.YelpSearchResult;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * yelp
 *
 * @author : ian
 * @date : 1/11/14
 */
@RequestMapping("/yelp")
public class YelpService {


    @RequestMapping("/")
    public org.springframework.http.ResponseEntity<String> get() {



        // Define your keys, tokens and secrets.  These are available from the Yelp website.
        String CONSUMER_KEY = "wGAW7V7cfx9kZSPMgXngZw";
        String CONSUMER_SECRET = "aHRH--9D0WxAadeOq9QCsv4hlS8";
        String TOKEN = "q6kuCNTmvhYQDgMUDvCDi3uBBbLgeAeN";
        String TOKEN_SECRET = "c2aZMBufx2CuM26vCDnIeRWx0xM";

        // Some example values to pass into the Yelp search service.
        String lat = "30.361471";
        String lng = "-87.164326";
        String category = "restaurants";

        // Execute a signed call to the Yelp service.
        OAuthService service = new ServiceBuilder().provider(YelpV2API.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET).build();
        Token accessToken = new Token(TOKEN, TOKEN_SECRET);
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        request.addQuerystringParameter("ll", lat + "," + lng);
        request.addQuerystringParameter("category", category);
        service.signRequest(accessToken, request);
        Response response = request.send();
        String rawData = response.getBody();

        return Responses.jsonOk(rawData);


    }







}

// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.iansails.yelp.model.yelp;

import com.iansails.yelp.model.Region;
import com.iansails.yelp.model.yelp.Business;
import com.iansails.yelp.model.yelp.YelpSearchResult;
import java.util.List;

privileged aspect YelpSearchResult_Roo_JavaBean {
    
    public Region YelpSearchResult.getRegion() {
        return this.region;
    }
    
    public void YelpSearchResult.setRegion(Region region) {
        this.region = region;
    }
    
    public int YelpSearchResult.getTotal() {
        return this.total;
    }
    
    public void YelpSearchResult.setTotal(int total) {
        this.total = total;
    }
    
    public List<Business> YelpSearchResult.getBusinesses() {
        return this.businesses;
    }
    
    public void YelpSearchResult.setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
    
    public List<String> YelpSearchResult.getCategories() {
        return this.categories;
    }
    
    public void YelpSearchResult.setCategories(List<String> categories) {
        this.categories = categories;
    }
    
}
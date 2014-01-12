// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.iansails.yelp.service;

import com.iansails.yelp.model.Region;
import com.iansails.yelp.service.RegionService;
import java.util.List;

privileged aspect RegionService_Roo_Service {
    
    public abstract long RegionService.countAllRegions();    
    public abstract void RegionService.deleteRegion(Region region);    
    public abstract Region RegionService.findRegion(Long id);    
    public abstract List<Region> RegionService.findAllRegions();    
    public abstract List<Region> RegionService.findRegionEntries(int firstResult, int maxResults);    
    public abstract void RegionService.saveRegion(Region region);    
    public abstract Region RegionService.updateRegion(Region region);    
}
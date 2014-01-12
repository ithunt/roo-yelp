package com.iansails.yelp.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Region {

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Span span;

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Coordinate center;
}

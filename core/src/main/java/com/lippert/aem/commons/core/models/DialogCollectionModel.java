package com.lippert.aem.commons.core.models;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

@Model(adaptables = Resource.class)
public class DialogCollectionModel {

    @Inject
    @Optional
    @Default(values = "Please replace this text")
    private String text;


    @Inject
    @Optional
    private String headline;

    @Inject
    @Optional
    private String textarea;

    @Inject
    @Optional
    private String color;

    @Inject
    @Optional
    @Default(booleanValues = false)
    private Boolean showButton;

    @Inject
    @Optional
    @Default(booleanValues = false)
    private Boolean showHeadline;

    @Inject
    @Optional
    @Default(booleanValues = false)
    private Boolean showText;

    @Inject
    @Optional
    private String altimagetext;

    @Inject
    @Optional
    private String user;

    @Inject
    @Optional
    private String hyperlink;

    @Inject
    @Optional
    private String option;

    @Inject
    @Optional
    private Date date;

    /*@TODO
    Implement Image Model
     */

    public String getTextarea() {
        return textarea;
    }

    public String getColor() {
        return color;
    }

    public Boolean getShowButton() {
        return showButton;
    }

    public Boolean getShowHeadline() {
        return showHeadline;
    }

    public Boolean getShowText() {
        return showText;
    }

    public String getAltimagetext() {
        return altimagetext;
    }

    public String getUser() {
        return user;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public String getOption() {
        return option;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getHeadline() {
        return headline;
    }
}

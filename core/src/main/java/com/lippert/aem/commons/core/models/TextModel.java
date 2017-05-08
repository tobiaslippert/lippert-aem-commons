package com.lippert.aem.commons.core.models;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;


import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class TextModel {

    public String getText() {
        return text;
    }

    public String getHeadline() {
        return headline;
    }

    @Inject
    @Optional
    @Default(values = "Please replace this text")
    private String text;


    @Inject
    @Optional
    private String headline;

}

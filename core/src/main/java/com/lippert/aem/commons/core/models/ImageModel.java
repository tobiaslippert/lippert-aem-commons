package com.lippert.aem.commons.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;


@Model(adaptables = Resource.class)
public class ImageModel {

    private Resource resource;

    @Inject
    @Optional
    private String fileReference;

    @Inject
    @Optional
    private String title;

    @Inject
    @Optional
    private String altImageText;

    public ImageModel(Resource resource){
        this.resource = resource;
    }

    public Resource getResource(){
        return this.resource;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getAltImageText() {
        return altImageText;
    }

    public String getTitle() {
        return title;
    }
}

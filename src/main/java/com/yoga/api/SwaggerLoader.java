package com.yoga.api;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class SwaggerLoader extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();

        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        return resources;
    }
}

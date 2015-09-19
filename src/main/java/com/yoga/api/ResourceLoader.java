package com.yoga.api;

import com.yoga.api.resources.PracticeResource;
import com.yoga.api.resources.PracticeSearchResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ResourceLoader extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(PracticeResource.class);
        classes.add(PracticeSearchResource.class);

        return classes;
    }
}

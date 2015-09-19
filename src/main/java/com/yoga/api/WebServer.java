package com.yoga.api;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class WebServer {
    private static final String ROOT_PATH = "/api";

    public static void main(String[] args) throws Exception {

        Tomcat embeddedTomcat = new Tomcat();
        embeddedTomcat.setPort(8080);

        //http://stackoverflow.com/questions/23775620/best-practice-to-save-temp-files-on-tomcat
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = embeddedTomcat.addContext(ROOT_PATH, base.getAbsolutePath());

        // register Jersey REST resources
        Tomcat.addServlet(rootCtx, "jersey-container-servlet", resourceConfig());
        rootCtx.addServletMapping("/*", "jersey-container-servlet");

        // register Swagger
        Tomcat.addServlet(rootCtx, "JerseyJaxrsConfig", aplicationConfig());
        rootCtx.addServletMapping("/*", "JerseyJaxrsConfig");
        rootCtx.addApplicationListener(SwaggerInitialiser.class.getCanonicalName());


        embeddedTomcat.start();

        // serve until proper shutdown request received
        embeddedTomcat.getServer().await();
    }

    private static ServletContainer resourceConfig() {
        return new ServletContainer(new ResourceConfig(
                new ResourceLoader().getClasses()));
    }

    private static ServletContainer aplicationConfig() {
        return new ServletContainer(new ResourceConfig(
                new SwaggerLoader().getClasses()));
    }

}

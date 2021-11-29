package ua.rakhmail.hw34;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        String dir = "Web_tasks/src/main/webapp";
        Tomcat tomcat = new Tomcat();
        String port = System.getenv("PORT");
        if(port == null || port.isEmpty()) {
            port = "8080";
        }

        tomcat.setPort(Integer.parseInt(port));
        StandardContext standardContext = (StandardContext) tomcat.addWebapp("/", new File(dir).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File(dir).getAbsolutePath());

        File additionWebInfClasses = new File("Web_tasks/target/classes");

        WebResourceRoot webResourceRoot = new StandardRoot(standardContext);
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        standardContext.setResources(webResourceRoot);

        tomcat.start();
        tomcat.getServer().await();
    }
}

package de.sfrick.udp;

import lombok.SneakyThrows;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.net.SocketException;

public class Application {



   @SneakyThrows
   public static void main(String[] args) throws SocketException {
//      Tomcat tomcat = new Tomcat();
//      tomcat.setPort(8080);
//      tomcat.setHostname("localhost");
//      String appBase = ".";
//      tomcat.getHost().setAppBase(appBase);
//
//      File docBase = new File(System.getProperty("java.io.tmpdir"));
//      Context context = tomcat.addContext("", docBase.getAbsolutePath());
//
//      Class servletClass = EchoServer.class;
//      Tomcat.addServlet(context, servletClass.getSimpleName(), servletClass.getName());
//      context.addServletMappingDecoded("/*", servletClass.getSimpleName());
//
//
//      tomcat.start();
//      tomcat.getServer().await();
//      new EchoServer(8080).start();
   }
}

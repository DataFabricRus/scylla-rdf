FROM tomcat:9.0.21-jdk11-openjdk

RUN rm -r $CATALINA_HOME/webapps/*

COPY web/target/workbench.war $CATALINA_HOME/webapps/ROOT.war
COPY web/target/server.war $CATALINA_HOME/webapps/server.war
COPY server.xml tomcat-users.xml web.xml $CATALINA_HOME/conf/

ENV CATALINA_OPTS="$CATALINA_OPTS -Dlogback.configurationFile=/org/eclipse/rdf4j/common/app/config/defaults/logback.xml"

CMD catalina.sh run


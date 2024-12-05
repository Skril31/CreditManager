FROM tomcat:10.1

# Копируем ваше приложение в веб-приложения Tomcat
COPY ./target/CreditApp.war /usr/local/tomcat/webapps/ROOT.war

# Устанавливаем права на доступ
RUN chmod -R 755 /usr/local/tomcat/webapps/ROOT.war
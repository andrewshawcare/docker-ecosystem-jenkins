FROM jenkins:2.19.4

USER root

COPY ./install-docker.sh .
RUN ./install-docker.sh

COPY ./install-docker-compose.sh .
RUN ./install-docker-compose.sh

COPY ./plugins.txt /usr/share/jenkins/plugins.txt
RUN cat /usr/share/jenkins/plugins.txt | xargs /usr/local/bin/install-plugins.sh

COPY ./init.groovy.d/add-credentials.groovy /var/jenkins_home/init.groovy.d/add-credentials.groovy
COPY ./init.groovy.d/add-projects.groovy /var/jenkins_home/init.groovy.d/add-projects.groovy

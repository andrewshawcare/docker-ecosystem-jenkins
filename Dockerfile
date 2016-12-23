FROM jenkins:2.19.4

USER root

COPY ./install-docker.sh .
RUN ./install-docker.sh

COPY ./install-docker-compose.sh .
RUN ./install-docker-compose.sh

COPY ./plugins.txt /usr/share/jenkins/plugins.txt
RUN cat /usr/share/jenkins/plugins.txt | xargs /usr/local/bin/install-plugins.sh

COPY ./init.groovy.d/1-add-credentials.groovy /var/jenkins_home/init.groovy.d/1-add-credentials.groovy
COPY ./init.groovy.d/2-add-projects.groovy /var/jenkins_home/init.groovy.d/2-add-projects.groovy
COPY ./init.groovy.d/3-schedule-initial-build.groovy /var/jenkins_home/init.groovy.d/3-schedule-initial-build.groovy

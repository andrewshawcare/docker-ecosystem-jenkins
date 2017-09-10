FROM jenkins/jenkins

USER root

COPY ./plugins.txt /usr/share/jenkins/plugins.txt
RUN cat /usr/share/jenkins/plugins.txt | xargs /usr/local/bin/install-plugins.sh

USER jenkins

COPY ./init.groovy.d/ /var/jenkins_home/init.groovy.d/

FROM jenkins:2.46.1

USER root

COPY ./plugins.txt /usr/share/jenkins/plugins.txt
RUN cat /usr/share/jenkins/plugins.txt | xargs /usr/local/bin/install-plugins.sh

USER jenkins

COPY ./init.groovy.d/1-remove-executors-from-master-node.groovy /var/jenkins_home/init.groovy.d/1-remove-executors-from-master-node.groovy
COPY ./init.groovy.d/2-add-credentials.groovy /var/jenkins_home/init.groovy.d/2-add-credentials.groovy
COPY ./init.groovy.d/3-add-projects.groovy /var/jenkins_home/init.groovy.d/3-add-projects.groovy
COPY ./init.groovy.d/4-schedule-initial-build.groovy /var/jenkins_home/init.groovy.d/4-schedule-initial-build.groovy

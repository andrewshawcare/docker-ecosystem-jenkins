FROM jenkins/jenkins

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY ./plugins.txt /usr/share/jenkins/plugins.txt
RUN cat /usr/share/jenkins/plugins.txt | xargs /usr/local/bin/install-plugins.sh

COPY --chown=jenkins:jenkins ./init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/

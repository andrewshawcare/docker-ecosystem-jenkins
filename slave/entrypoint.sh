#!/bin/sh
JENKINS_MASTER_HOST=master
JENKINS_MASTER_PORT=8080
NAME="$(hostname)"

export NAME
envsubst < node.xml.template > node.xml

./wait-for-it.sh "${JENKINS_MASTER_HOST}:${JENKINS_MASTER_PORT}"

while sleep 10
do
  curl \
    "http://${JENKINS_MASTER_HOST}:${JENKINS_MASTER_PORT}/jnlpJars/jenkins-cli.jar" \
    --output jenkins-cli.jar

  cat node.xml | \
  java \
    -jar jenkins-cli.jar \
    -s "http://${JENKINS_MASTER_HOST}:${JENKINS_MASTER_PORT}" \
    create-node "${NAME}"

  curl \
    "http://${JENKINS_MASTER_HOST}:${JENKINS_MASTER_PORT}/jnlpJars/slave.jar" \
    --output slave.jar

  java \
    -jar slave.jar \
    -jnlpUrl "http://${JENKINS_MASTER_HOST}:${JENKINS_MASTER_PORT}/computer/${NAME}/slave-agent.jnlp"
done

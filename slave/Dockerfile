FROM debian:buster

COPY ./install-docker-compose.sh .
COPY ./install-docker.sh .
COPY ./install-envsubst.sh .
COPY ./install-java.sh .

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update -y && \
  apt-get install -y apt-utils && \
  ./install-docker.sh && \
  ./install-docker-compose.sh && \
  ./install-envsubst.sh && \
  ./install-java.sh && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/*

COPY ./node.xml.template .
COPY ./wait-for-it.sh .
COPY ./entrypoint.sh .

ENTRYPOINT ["./entrypoint.sh"]

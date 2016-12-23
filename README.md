# docker-ecosystem-jenkins
A Jenkins deployment with docker-compose-enabled nodes and some sample projects

## Deployment

### Prerequisites

This project is deployed with Docker. The easiest way to setup a Docker environment is by installing the [Docker Toolbox](https://www.docker.com/docker-toolbox).

### Docker Compose

```bash
docker-compose up
```

## Jenkins Dashboard

1. Go to `http://$(docker-machine ip):8080` in your browser.

# docker-ecosystem-jenkins
A Jenkins deployment with docker-compose-enabled nodes and some sample projects

## Deployment

### Prerequisites

The following environment variables need to be set in `docker-compose.yml` before running this project:

* `GIT_CREDENTIALS_ID`: An arbitrary identifier for the Jenkins git credentials
* `GIT_CREDENTIALS_DESCRIPTION`: (Optional) A human-readable description for the Jenkins git credentials
* `GIT_CREDENTIALS_USERNAME`: The username used to authenticate with GitHub
* `GIT_CREDENTIALS_PASSWORD`: Either the git password or git token used to authenticate with GitHub

This project is deployed with Docker. The easiest way to setup a Docker environment is by installing the [Docker Toolbox](https://www.docker.com/docker-toolbox).

### Docker Compose

```bash
docker-compose up
```

## Jenkins Dashboard

1. Go to `http://$(docker-machine ip):8080` in your browser.

# docker-ecosystem-jenkins
A Jenkins deployment with docker-compose-enabled nodes and some sample projects

## Deployment

### Setup

The `export-secrets.sh` script will use files in the .gitignored `environment` folder to export environment variables. By convention, file names will be the environment variable keys and file contents will be the environment variable values.

As an example, a file named, FOO with file contents:

bar

Will export the following environment variable:

FOO=bar

The following environment variables are required for this project:

GIT_CREDENTIALS_USERNAME: Your GitHub username
GIT_CREDENTIALS_PASSWORD: Your GitHub password

This project is deployed with Docker. The easiest way to setup a Docker environment is by installing the [Docker Toolbox](https://www.docker.com/docker-toolbox).

### Running

```bash
source ./export-environment-variables.sh && docker-compose up
```

## Jenkins Dashboard

1. Go to `http://$(docker-machine ip):8080` in your browser.

# docker-ecosystem-jenkins
A Jenkins deployment with docker-compose-enabled nodes and some sample projects

## Deployment

### Setup

#### Environment variables

The following environment variables are required for this project:

* GIT_CREDENTIALS_USERNAME: Your GitHub username
* GIT_CREDENTIALS_PASSWORD: Your GitHub password (or personal token)
* JENKINS_ADMINISTRATOR_USERNAME: The Jenkins administrator username
* JENKINS_ADMINISTRATOR_PASSWORD: The Jenkins administrator password

For convenience, `export-environment-variables.sh` will create and export
environment variables using files in the `environment` folder. This folder is
excluded from the repository using `.gitignore`, so you can add sensitive
environment variables here.

For example, a file named `FOO` with file contents:

```
bar
```

Will result in the following environment variable:

`FOO=bar`

#### Docker

This project is deployed with Docker. The easiest way to setup a Docker environment is by installing the [Docker Toolbox](https://www.docker.com/docker-toolbox).

### Running

```bash
source ./export-environment-variables.sh && docker-compose up
```

## Jenkins Dashboard

1. Go to `http://localhost:8080` in your browser.

#!/bin/bash
apt-get install -y curl jq
VERSION="$(curl https://api.github.com/repos/docker/compose/releases/latest | jq --raw-output .name)"
KERNEL="$(uname -s)"
MACHINE="$(uname -m)"
curl \
  -L "https://github.com/docker/compose/releases/download/${VERSION}/docker-compose-${KERNEL}-${MACHINE}" \
  -o /usr/local/bin/docker-compose && \
  chmod +x /usr/local/bin/docker-compose

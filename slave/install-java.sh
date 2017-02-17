#!/bin/sh
echo 'deb http://ftp.debian.org/debian jessie-backports main' > /etc/apt/sources.list.d/backports.list
apt-get update -y
apt-get install -t jessie-backports -y openjdk-8-jdk-headless

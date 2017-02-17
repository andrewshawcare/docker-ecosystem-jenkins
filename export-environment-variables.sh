#!/bin/sh
for filename in ./environment/*; do
  key="$(basename $filename)"
  value="$(cat $filename)"
  export "$key"="$value"
done

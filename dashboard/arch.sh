#!/bin/bash
#check machine hardware name
case $(uname -m) in
       x86_64) architecture="amd64" ;;
       s390x) architecture="s390x";;
esac
if [ $architecture == "amd64" ]; then \
        DOCKERFILE="Dockerfile"; \
elif [ $architecture == "s390x" ]; then \
        DOCKERFILE="s390x.Dockerfile"; \
fi
echo $DOCKERFILE

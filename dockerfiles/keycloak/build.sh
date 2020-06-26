#!/bin/bash
#
# Copyright (c) 2018 Red Hat, Inc.
# This program and the accompanying materials are made
# available under the terms of the Eclipse Public License 2.0
# which is available at https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#

base_dir=$(cd "$(dirname "$0")"; pwd)
. "${base_dir}"/../build.include

init --name:keycloak "$@"

ARCH="$(uname -m)"
if [ "${ARCH}" == "s390x" ]; then
    git clone https://github.com/keycloak/keycloak-containers.git
    cd keycloak-containers && git checkout tags/6.0.1
    docker build -t jboss/keycloak:6.0.1 -f server/Dockerfile .
fi

build

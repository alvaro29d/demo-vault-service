#!/usr/bin/env bash

token=12345
host=localhost
port=8200
address="http://${host}:${port}"

docker run --cap-add=IPC_LOCK -d \
    -e "VAULT_DEV_ROOT_TOKEN_ID=${token}" \
    -e "VAULT_ADDR=${address}" \
    -p ${port}:8200 --name=vault vault

sleep 5s

export VAULT_ADDR=$address
export VAULT_TOKEN=$token

# This is the private service backend
vault secrets enable -path=services kv

# This is the public backend shared between all services
vault secrets enable -path=shared kv


### Default profile
vault kv put services/demo-vault props.name=nameFromVault
vault kv put shared/endpoints eureka.host=eurekaHost eureka.port=8761

### Prod profile
vault kv put services/demo-vault/prod props.name=prodNameFromVault
vault kv put shared/endpoints/prod eureka.host=prodEurekaHost eureka.port=8761


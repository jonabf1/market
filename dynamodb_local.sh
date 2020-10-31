#!/bin/bash

cd dynamodb
echo "DynamoDB in http://localhost:8001..."
java -Djava.library.path=./dynamodb/DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb -port 8001

# pensioner-detail-microservice

* port = 9001

# AWS ECS SERVICE CONFIGURATION

* path = /api/pensioner-detail-service/*
* health =/api/pensioner-detail-service/manage/health

# Container Config Environment Variable

* AUTHORIZATION_SERVICE_URI

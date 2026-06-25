# class02

Serviço **Spring Boot 3 + Java 21** mínimo, focado em **health check** — o lab base do treinamento AWS (trilha Java → AWS). Expõe um endpoint de saúde simples e os health checks do Actuator (liveness/readiness), do tipo consumido por **ALB Target Group / ECS / Kubernetes**.

## Stack

- Java 21
- Spring Boot 3.5 (`web` + `actuator`)
- Maven

## Endpoints

| Método | Rota | Resposta |
|--------|------|----------|
| `GET` | `/health` | `{"status":"UP","service":"class02","timestamp":"..."}` |
| `GET` | `/actuator/health` | `{"status":"UP",...}` com detalhes + probes `liveness`/`readiness` |

## Como rodar

```bash
mvn clean package -DskipTests
mvn spring-boot:run
# ou: java -jar target/class02-0.0.1-SNAPSHOT.jar
```

A aplicação sobe em `http://localhost:8080`.

```bash
curl http://localhost:8080/health
curl http://localhost:8080/actuator/health
```

## Configuração (`application.properties`)

- `server.port=8080`
- Actuator expõe `health` e `info`
- `management.endpoint.health.show-details=always`
- Probes habilitadas (`management.endpoint.health.probes.enabled=true`) → `liveness` e `readiness`

## Contexto

Primeiro lab da trilha: um serviço enxuto cujo objetivo é o **health check** usado por balanceadores e orquestradores na AWS (ALB, ECS, EKS). O passo seguinte — lab de Amazon S3 — está em [`aws-class3-s3-lab`](https://github.com/davijaf/aws-class3-s3-lab).

---

Lab de estudo — pós-graduação Java Elite + treinamento AWS.

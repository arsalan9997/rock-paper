# 🎮 Rock Paper Scissors — DevOps CI/CD Project

A complete beginner-friendly Java game used to demonstrate Git, GitHub, Maven, Jenkins, Docker and AWS EC2 deployment.

## Stack
Java 17 | Spring Boot | Maven | Git | GitHub | Jenkins | Docker | AWS EC2

## Run locally
```bash
mvn clean test
mvn clean package
java -jar target/rock-paper-scissors.jar
```
Open `http://localhost:8080`

## Docker
Build the JAR first:
```bash
mvn clean package
docker build -t rock-paper-scissors:1.0 .
docker run -d --name rock-paper-scissors -p 8080:8080 rock-paper-scissors:1.0
```

Or:
```bash
mvn clean package
docker compose up -d --build
```

## Jenkins
Configure JDK tool name `JDK17` and Maven tool name `Maven3`, then create a Pipeline job using:
`Pipeline script from SCM → Git → your GitHub repository → Branch */main → Jenkinsfile`

Pipeline:
GitHub → Checkout → Maven Compile → Test → Package → Archive JAR

## AWS EC2
Install Docker on Ubuntu EC2, copy/build the image there, and allow TCP port 8080 in the EC2 Security Group.
Then access:
`http://EC2_PUBLIC_IP:8080`

For a real CI/CD deployment, the Jenkinsfile can be extended to build/push the Docker image to Docker Hub or Amazon ECR and SSH into EC2 to pull/restart the container.

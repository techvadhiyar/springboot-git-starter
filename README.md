# springboot-git-starter
A quick GIT starter project
This project is to showcase a Git Hub Actions build process driven by a Git Hub Runner running on an AWS EC2 Linux instance. 
The Git Hub Actions Runner when triggered from EC2 will connect to Git Hub, look for code changes in the REPO, build the REPO and install the source
code and the JAR file on the AWS EC2 instance.
It will then execute the Spring Boot JAR in the background.
To view this "Self Hosted" runner, go to Settings (i.e the Project Settings above)->Actions->Runner

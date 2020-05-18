pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat instead of sh for windows
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {

                sh "docker build -t='sergiubahrim/selenium-docker'."
            }
        }
//       stage('Push Image') {
//           steps {
//			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {
//
//			        sh "docker login --username=${user} --password=${pass}"
//			        sh "docker push sergiubahrim/selenium-docker:latest"
//			    }
//           }
//        }
//        stage("Pull latest image from DockerHub)") {
//            steps {
//                    sh "docker pull sergiubahrim/selenium-docker"
//            }
//        }
        stage("Raise the grid (hub + nodes)") {
             steps {
                    sh "docker-compose up -d hub chrome firefox --no-color"
                }
        }
        stage("Run the tests") {
             steps {
                    sh "docker-compose up search-module-chrome coface-test-module-firefox --no-color"
             }
        }
    }

    post{
            always{
                //create logs folder for Jenkins
                archiveArtifacts artifacts: 'output/**'
                //shut down the selenium grid
                sh "docker-compose down"
                //remove the docker image from local machine
                sh "docker rmi sergiubahrim/selenium-docker:latest"
            }
        }
}
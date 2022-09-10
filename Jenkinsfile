pipeline {
    agent any
    environment {
        NEW_VERSION = '1.1.0'
    }
    tools {
        maven 'maven'
    }

    stages {
        stage("build") {
            steps {
                echo 'building the application .....'
                echo " build version ${NEW_VERSION}"
                echo " Branch Name:: ${BRANCH_NAME}"
                sh "mvn install"
            }
        }
        stage(" Build docker image"){
            steps {
                script{
                    sh 'docker build -t producer .'
                }
            }
        }
        stage("test") {
                when{
                    expression {
                        BRANCH_NAME == 'main'
                    }
                }
                    steps {
                        echo 'testing the application .....'
                        sh "mvn test"
                    }
                }

        stage("publish") {
                    steps {
                        echo 'publishing the application .....'
                        sh "mvn package"
                    }
                }


    }
}
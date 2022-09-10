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
                    }
                }

        stage("deploy") {
                    steps {
                        echo 'deploying the application .....'
                    }
                }


    }
}
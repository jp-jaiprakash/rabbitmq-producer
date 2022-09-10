
// CODE_CHANGES = getGitChanges()

pipeline {
    agent any
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('') // This is the one which binds to jenkins credentials
        // two plugins => credentials and credentials binding
    }
    tools{
    maven 'maven'
    }
    stages {
        stage("build") {
            steps {
                echo 'building the application .....'
                echo "build version ${NEW_VERSION}"
                echo "build version ${BRANCH_NAME}"
            }
        }
        stage("test") {
//                 when {
//                     expression {
//                         BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
//                     }
//                 }
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


node {
    properties([parameters([choice(choices: ['us-east-1', 'us-west-1', 'us-west-2'], description: 'please select a region', name: 'ami_region')])])
    stage ("Pull Repo"){
        git 'https://github.com/enver0173/packer.git'
    }
    stage ("Build Image"){
        sh "packer version"
        sh "packer build -var region=${AMI_REGION} tools/jenkins_example.json"
    }
    stage ("Send Notification to Slack"){
        echo "Hello"
    }
    stage ("Send Email"){
        echo "Hellp"
    }
}

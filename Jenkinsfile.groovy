node {
	properties(
		[parameters(
			[choice(choices: 
			[
				'jenkins', 
			], 
		description: 'What would you like to build? ', 
		name: 'TOOL'), 
			choice(choices: 
			[
			'us-east-1', 
			'us-east-2', 
			'us-west-1', 
			'us-west-2', 
			'eu-west-1', 
			'eu-west-2', 
			'eu-central-1'], 
		description: 'Where would you like to build? ', 
		name: 'REGION')])])


    stage ("Pull Repo"){
        git 'https://github.com/alisahp/jenkins_pipelines.git'
    }
    stage ("Build Image"){
        sh "packer version"
        //sh "packer build -var region=${AMI_REGION} tools/${TOOL_TO_PROVISION}.json"
    }
    stage ("Send Notification to Slack"){
        slackSend channel: 'nagios_alerts', message: "${TOOL_TO_PROVISION} has been built"
    }
    stage ("Send Email"){
        mail bcc: '', 
        body: "Hello Ali,Your AMI is ready in ${AMI_REGION} Thanks", 
        cc: '', 
        from: '', 
        replyTo: '', 
        subject: "${TOOL_TO_PROVISION} has been built", 
        to: "${EMAIL_TO_SEND}"
    }
}

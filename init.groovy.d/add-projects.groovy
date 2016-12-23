import jenkins.model.*

def generateReverseBuildTriggerXml = { final List<String> upstreamProjectNameList=[] ->
  if (upstreamProjectNameList) {
    return """<jenkins.triggers.ReverseBuildTrigger>
      <spec></spec>
      <upstreamProjects>${upstreamProjectNameList.join(',')}</upstreamProjects>
      <threshold>
        <name>SUCCESS</name>
        <ordinal>0</ordinal>
        <color>BLUE</color>
        <completeBuild>true</completeBuild>
      </threshold>
    </jenkins.triggers.ReverseBuildTrigger>"""
  } else {
    return ''
  }
}

def generateProjectXml = { final Map<String, Object> project ->
  final String projectXml = """<?xml version='1.0' encoding='UTF-8'?>
  <flow-definition plugin="workflow-job@2.9">
    <description></description>
    <keepDependencies>false</keepDependencies>
    <properties>
      <org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
        <triggers>
          ${generateReverseBuildTriggerXml(project.upstreamProjectNameList)}
          <com.cloudbees.jenkins.GitHubPushTrigger plugin="github@1.25.0">
            <spec></spec>
          </com.cloudbees.jenkins.GitHubPushTrigger>
        </triggers>
      </org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
    </properties>
    <definition class="org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition" plugin="workflow-cps@2.23">
      <scm class="hudson.plugins.git.GitSCM" plugin="git@3.0.1">
        <configVersion>2</configVersion>
        <userRemoteConfigs>
          <hudson.plugins.git.UserRemoteConfig>
            <url>${project.gitRepositoryUrl}</url>
            <credentialsId>${System.getenv('GIT_CREDENTIALS_ID')}</credentialsId>
          </hudson.plugins.git.UserRemoteConfig>
        </userRemoteConfigs>
        <branches>
          <hudson.plugins.git.BranchSpec>
            <name>*/master</name>
          </hudson.plugins.git.BranchSpec>
        </branches>
        <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
        <submoduleCfg class="list"/>
        <extensions/>
      </scm>
      <scriptPath>Jenkinsfile</scriptPath>
    </definition>
    <triggers/>
  </flow-definition>"""
  return new ByteArrayInputStream(projectXml.getBytes())
}

final Map<String, ByteArrayInputStream> projects = [
  'docker-ecosystem-migration': generateProjectXml(
    gitRepositoryUrl: 'https://github.com/andrewshawcare/docker-ecosystem-migration.git'
  ),
  'docker-ecosystem-node-service': generateProjectXml(
    gitRepositoryUrl: 'https://github.com/andrewshawcare/docker-ecosystem-node-service.git',
    upstreamProjectNameList: ['docker-ecosystem-migration']
  ),
  'docker-ecosystem-java-service': generateProjectXml(
    gitRepositoryUrl: 'https://github.com/andrewshawcare/docker-ecosystem-java-service.git',
    upstreamProjectNameList: ['docker-ecosystem-migration']
  ),
  'docker-ecosystem-client': generateProjectXml(
    gitRepositoryUrl: 'https://github.com/andrewshawcare/docker-ecosystem-client.git',
    upstreamProjectNameList: ['docker-ecosystem-node-service', 'docker-ecosystem-java-service']
  )
]

projects.each { final String name, final ByteArrayInputStream xml -> Jenkins.instance.createProjectFromXML(name, xml) }

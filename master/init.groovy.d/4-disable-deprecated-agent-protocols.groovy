import jenkins.model.Jenkins
import jenkins.AgentProtocol
import hudson.ExtensionList

final ExtensionList<AgentProtocol> agentProtocolList = jenkins.AgentProtocol.all()
agentProtocolList.each { agentProtocol ->
  if (agentProtocol.isDeprecated()) {
    agentProtocolList.remove(agentProtocol)
  }
}

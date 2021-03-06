import jenkins.model.Jenkins
import hudson.security.*
import hudson.security.csrf.DefaultCrumbIssuer

final boolean allowsSignup = false
final HudsonPrivateSecurityRealm securityRealm = new HudsonPrivateSecurityRealm(allowsSignup)

final String userName = System.getenv('JENKINS_ADMINISTRATOR_USERNAME')
final String password = System.getenv('JENKINS_ADMINISTRATOR_PASSWORD')
securityRealm.createAccount(userName, password)
Jenkins.instance.setSecurityRealm((SecurityRealm) securityRealm)

Jenkins.instance.setCrumbIssuer(new DefaultCrumbIssuer(true))

Jenkins.instance.save()

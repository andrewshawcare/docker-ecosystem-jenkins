import jenkins.model.Jenkins
import hudson.security.*

final boolean allowsSignup = false
final HudsonPrivateSecurityRealm securityRealm = new HudsonPrivateSecurityRealm(allowsSignup)

Jenkins.instance.setSecurityRealm(securityRealm)

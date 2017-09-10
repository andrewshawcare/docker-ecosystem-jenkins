import jenkins.model.Jenkins
import hudson.model.Cause
import hudson.model.Job

final Cause cause = new Cause.UserIdCause()
final Job job = Jenkins.instance.getJob('docker-ecosystem-migration')
job.scheduleBuild(cause)

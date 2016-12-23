import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

Credentials credentials = (Credentials) new UsernamePasswordCredentialsImpl(
  CredentialsScope.GLOBAL,
  System.getenv('GIT_CREDENTIALS_ID'),
  System.getenv('GIT_CREDENTIALS_DESCRIPTION'),
  System.getenv('GIT_CREDENTIALS_USERNAME'),
  System.getenv('GIT_CREDENTIALS_PASSWORD')
)

SystemCredentialsProvider
    .getInstance()
    .getStore()
    .addCredentials(Domain.global(), credentials)

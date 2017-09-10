import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

final String id = 'git'
final String description = ''
final String username = System.getenv('GIT_CREDENTIALS_USERNAME')
final String password = System.getenv('GIT_CREDENTIALS_PASSWORD')
final Credentials credentials = (Credentials) new UsernamePasswordCredentialsImpl(
    CredentialsScope.GLOBAL, id, description, username, password
)

SystemCredentialsProvider
    .getInstance()
    .getStore()
    .addCredentials(Domain.global(), credentials)

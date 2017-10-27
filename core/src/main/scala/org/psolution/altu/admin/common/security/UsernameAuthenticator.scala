package org.psolution.altu.admin.common.security

import java.net.{Authenticator, PasswordAuthentication}

class UsernameAuthenticator(implicit creds: PasswordAuthentication) extends Authenticator {
  override def getPasswordAuthentication = creds
}

package org.psolution.altu.admin.api.swagger

import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info
import io.swagger.models.ExternalDocs
import io.swagger.models.auth.BasicAuthDefinition

object SwaggerDocService extends SwaggerHttpService {
  override def apiClasses = SwaggerApiRegistry.getRegistredInstances
  override val basePath = "/";
  override val apiDocsPath = "api-docs" //where you want the swagger-json endpoint exposed
  override val info = Info(version = "1.0")
  override val host = "localhost:8080"
  override val externalDocs = Some(new ExternalDocs("Core Docs", "http://acme.com/docs"))
  override val securitySchemeDefinitions = Map("basicAuth" -> new BasicAuthDefinition())
}


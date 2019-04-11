job('XRay Demo - TMODocuments') {
    properties {
        githubProjectUrl('file:///opt/XRayDemo/TMODocuments')
    }
    scm {
        git('file:///opt/XRayDemo/TMODocuments')
    }
    wrappers {
    	     credentialsBinding {
		usernamePassword('TEMP_DEPLOY_ACCOUNT_USER', 'TEMP_DEPLOY_ACCOUNT_PASSWORD','9638e69f-2433-4b3e-8b6b-0115a3a33864')
	}								     }
    artifactoryGenericConfigurator {
      details {
        artifactoryName('-57208187@1460389455914')
        artifactoryUrl('http://repo.example.org')
        deployReleaseRepository {
          keyFromText('testing')
          keyFromSelect(null)
          dynamicMode(true)
        }
        deploySnapshotRepository(null)
        resolveReleaseRepository(null)
        resolveSnapshotRepository(null)
        userPluginKey(null)
        userPluginParams(null)
      }
      useSpecs(true)
      uploadSpec{
        spec('{"files": [{"pattern": "target/*.ear","target": "txmutual-libs-dev-local"}]}')
        filePath(null)
      }
      downloadSpec(null)
      deployerDetails(null)
      resolverDetails(null)
      deployerCredentialsConfig(null)
      resolverCredentialsConfig(null)
      deployPattern('')
      resolvePattern('')
      matrixParams('')
      deployBuildInfo(true)
      includeEnvVars(false)
      envVarsPatterns {
        includePatterns('**.zip')
        excludePatterns('foo.zip')
      }
      discardOldBuilds(true)
      discardBuildArtifacts(true)
      multiConfProject(false)
      artifactoryCombinationFilter('')
      deploymentProperties(null)
      asyncBuildRetention(false) 
      customBuildName('')
      overrideBuildName(false)
    }
  }
}
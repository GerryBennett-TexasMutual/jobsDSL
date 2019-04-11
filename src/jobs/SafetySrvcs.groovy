job('XRay Demo - SafetySrvcs') {

  	  properties {
        githubProjectUrl('file:///opt/XRayDemo/SafetySrvcs')
    }
  
    scm {
    	git {
          remote {
	  	       url('file:///opt/XRayDemo/SafetySrvcs')
          }
          branch('**/master')
          extensions {
                    wipeOutWorkspace()
          }
        }
    }
  
  wrappers {
          wrappers {
        // colorizeOutput()
              
   	      /**
     * Adds timestamps to the console log.
     */
        timestamps()
    }
	credentialsBinding {
				usernamePassword('TEMP_DEPLOY_ACCOUNT_USER', 'TEMP_DEPLOY_ACCOUNT_PASSWORD','9638e69f-2433-4b3e-8b6b-0115a3a33864')
  									     }
    artifactoryGenericConfigurator {
      details {
        artifactoryName(null)
        artifactoryUrl(null)
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
      includeEnvVars(true)
      envVarsPatterns {
        includePatterns(null)
        excludePatterns('*password*,*secret*,*key*') 
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
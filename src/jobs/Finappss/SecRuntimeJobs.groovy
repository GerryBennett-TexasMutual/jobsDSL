multiJob('xray_demo/xray_demo_Finappss') {
		    displayName('XRay Demo Finappss')
		    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}

job('xray_demo/xray_demo_Finappss/XRay Demo - SecRuntime') {

  	  properties {
        githubProjectUrl('file:///opt/XRayDemo/Finappss/SecRuntime')
    }
  
    scm {
    	git {
          remote {
	  	       url('file:///opt/XRayDemo/Finappss/SecRuntime')
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
        spec('{"files": [{"pattern": "target/*.war","target": "txmutual-libs-dev-local"}]}')
        filePath(null)
      }
      downloadSpec(null)
      deployerDetails(null)
      resolverDetails(null)
      deployerCredentialsConfig {
      				username(null)
				password(null)
				credentialsId('JenkinsArtifactoryCredential')
				overridingCredentials(false)
      }
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
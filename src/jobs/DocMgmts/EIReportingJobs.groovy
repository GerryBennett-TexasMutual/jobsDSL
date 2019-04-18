folder('xray_demo/xray_demo_DocMgmts') {
		    displayName('XRay Demo DocMgmts')
		    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}

job('xray_demo/xray_demo_DocMgmts/XRay Demo - EIReporting') {

  	  properties {
        githubProjectUrl('file:///opt/XRayDemo/DocMgmts/EIReporting')
    }
  
    scm {
    	git {
          remote {
	  	       url('file:///opt/XRayDemo/DocMgmts/EIReporting')
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
        artifactoryName("ArtifactoryServer-01")
        artifactoryUrl("http://artifacts-server:8081/artifactory")
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
				overridingCredentials(true)
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
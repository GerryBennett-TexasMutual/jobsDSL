folder('nexus_iq_demo') {
     displayName('Nexus IQ')
     description('Folder for Nexus IQ Demo Analysis of current txmutual artifacts')
}
folder('nexus_iq_demo/nexus_iq_demo_DocMgmts') {
                    displayName('XRay Demo DocMgmts')
                    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}
job('nexus_iq_demo/nexus_iq_demo_DocMgmts/XRay Demo - DocAssembly')
{
    scm {
        git {
        remote {
                    url('file:///opt/XRayDemo/DocMgmts/DocAssembly')
        }
        branch('**/master')
            extensions {
                        wipeOutWorkspace()
            }
        }
    }
    steps {
        iqPolicyEvaluatorBuildStep {
          iqStage('build')
          iqApplication {
            manualApplication {
              applicationId('DocAssembly2')
            }
          }
          failBuildOnNetworkError(false)
          jobCredentialsId(null)
        }
    }
}

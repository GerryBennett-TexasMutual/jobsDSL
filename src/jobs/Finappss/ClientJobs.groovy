folder('nexus_iq_demo') {
     displayName('Nexus IQ')
     description('Folder for Nexus IQ Demo Analysis of current txmutual artifacts')
}
folder('nexus_iq_demo/nexus_iq_demo_Finappss') {
                    displayName('XRay Demo Finappss')
                    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}
job('nexus_iq_demo/nexus_iq_demo_Finappss/XRay Demo - Client')
{
    scm {
        git {
        remote {
                    url('file:///opt/XRayDemo/Finappss/Client')
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
              applicationId('Client2')
            }
          }
          failBuildOnNetworkError(false)
          jobCredentialsId(null)
        }
    }
}

folder('nexus_iq_demo') {
     displayName('Nexus IQ')
     description('Folder for Nexus IQ Demo Analysis of current txmutual artifacts')
}
folder('nexus_iq_demo/nexus_iq_demo_tmoApps') {
                    displayName('XRay Demo tmoApps')
                    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}
job('nexus_iq_demo/nexus_iq_demo_tmoApps/XRay Demo - LossRun')
{
    scm {
        git {
        remote {
                    url('file:///opt/XRayDemo/tmoApps/LossRun')
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
              applicationId('LossRun2')
            }
          }
          failBuildOnNetworkError(false)
          jobCredentialsId(null)
        }
    }
}

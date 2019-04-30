folder('nexus_iq_demo') {
     displayName('Nexus IQ')
     description('Folder for Nexus IQ Demo Analysis of current txmutual artifacts')
}
folder('nexus_iq_demo/nexus_iq_demo__TMI_IWCS_AvayaOD_Application') {
                    displayName('XRay Demo _TMI_IWCS_AvayaOD_Application')
                    description('Folder for XRAY Demo Analysis of current txmutual artifacts')
}
job('nexus_iq_demo/nexus_iq_demo__TMI_IWCS_AvayaOD_Application/XRay Demo - SF_TMI_IWCS_AvayaOD_Application')
{
    scm {
        git {
        remote {
                    url('file:///opt/XRayDemo/_TMI_IWCS_AvayaOD_Application/SF_TMI_IWCS_AvayaOD_Application')
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
              applicationId('SF_TMI_IWCS_AvayaOD_Application2')
            }
          }
          failBuildOnNetworkError(false)
          jobCredentialsId(null)
        }
    }
}

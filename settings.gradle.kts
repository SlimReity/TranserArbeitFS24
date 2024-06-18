pluginManagement {
    repositories {

        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/swisspost")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/libs-release")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/libs-snapshot")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/plugins-release")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/plugins-snapshot")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {

        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/swisspost")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/libs-release")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/libs-snapshot")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/plugins-release")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
        maven {
            url = uri("https://artifactory.tools.pnet.ch/artifactory/plugins-snapshot")
            credentials {
                username = providers.gradleProperty("artifactory.user").orElse(System.getenv("ARTIFACTORY_USER")).get()
                password = providers.gradleProperty("artifactory.password").orElse(System.getenv("ARTIFACTORY_PASSWORD")).get()
            }
        }
    }
}

rootProject.name = "MyProject"
include(":app")

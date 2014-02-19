grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.repos.default = "bertramlabsSnap"
grails.release.scm.enabled = false
grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.ivy.authentication.credentials.realm=System.getProperty('project.ivy.authentication.credentials.realm')
grails.project.ivy.authentication.credentials.host=System.getProperty('project.ivy.authentication.credentials.host')
grails.project.ivy.authentication.credentials.username=System.getProperty('project.ivy.authentication.credentials.username')
grails.project.ivy.authentication.credentials.password=System.getProperty('project.ivy.authentication.credentials.password')

grails.project.repos.bertramlabsSnap.url = "http://nexus.bertramlabs.com/content/repositories/snapshots"

grails.project.repos.bertramlabsRel.url = "http://nexus.bertramlabs.com/content/repositories/releases"



grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        grailsPlugins()
        mavenLocal()
        mavenCentral()
        mavenRepo name:'BertramLabs', root:'http://nexus.bertramlabs.com/content/repositories/snapshots'
        mavenRepo name:'BertramLabsRelease', root:'http://nexus.bertramlabs.com/content/repositories/releases'
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        // runtime 'mysql:mysql-connector-java:5.1.24'
    }

    plugins {
        runtime ":jquery:1.11.0.1"
        runtime ":asset-pipeline:1.5.7"
        runtime ":retina-tag:1.0.0"
        runtime ":coffee-asset-pipeline:1.5.0"
        runtime ":security-bridge:0.1.0"
        runtime ":sitemaps:0.2.0"
        
        build ":tomcat:7.0.50"
        build(":release:3.0.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}

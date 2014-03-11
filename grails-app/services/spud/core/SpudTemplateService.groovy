package spud.core
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.codehaus.groovy.grails.web.pages.FastStringWriter

class SpudTemplateService {
  static transactional = false
	def grailsApplication
  def groovyPagesTemplateEngine

  def render(name, content, options=[:]) {
    def start = new Date().time
    if(!content) { 
      return content
    }
    def contentToModify = new String(content)

    contentToModify = contentToModify.replaceAll(/\{\{#(.*)\}\}/) { fullMatch, tag ->
      def newTag = tag.trim()
      newTag = "<sp:${newTag} >"
      return newTag
    }

    contentToModify = contentToModify.replaceAll(/\{\{\/(.*)\}\}/) { fullMatch, tag ->
      def newTag = tag.trim()
      newTag = "</sp:${newTag}>"
      return newTag
    }
    
    contentToModify = contentToModify.replaceAll(/\{\{(.*)\}\}/) { fullMatch, tag ->
      def newTag = tag.trim()
      newTag = "<sp:${newTag} />"
      return newTag
    }
    

    def fsw = new FastStringWriter()
    groovyPagesTemplateEngine.createTemplate(contentToModify, name).make(options.model).writeTo(fsw)

    log.debug "Evaluated Template Syntax ${name} - ${new Date().time - start}ms"
    return fsw.toString()

    
  }


  def layoutServiceForSite(siteId=0) {
    return layoutServiceByName('system')
  }

  def activeLayoutService(name = 'system') {
    if(name) {
      return layouterviceByName(name)
    }

    return layoutServiceByName('system')
  }

  private layoutServiceByName(key) {
    def engineName = grailsApplication.config.spud.layoutEngines[key]
    if(engineName) {
      return grailsApplication.mainContext[engineName]
    } else {
      return null
    }
  }
}

<!DOCTYPE html>
<html>
<head>
  <title>Spud Admin</title>
  <script>
    window.tinyMCEPreInit = {base: '${assetPath(src:'tiny_mce')}', suffix:''};

  </script>
  <asset:javascript src="spud/admin/application.js"/>
  <asset:stylesheet href="spud/admin/application.css"/>

  <g:layoutHead/>
</head>
<body>
<div id="header" style="<%=header_style%>">

  <h1>Spud Admin</h1>


	<div id="user_meta">
		<span class="greeting">Hello <spAdmin:currentUserDisplayName/></span>&nbsp;<g:if test="${spAdmin.settingsLink()}">|&nbsp;<spAdmin:settingsLink>Settings</spAdmin:settingsLink>&nbsp;</g:if>|&nbsp;<spAdmin:logoutLink>Logout</spAdmin:logoutLink>
	</div>

</div>
<div id="breadcrumbs">
  <spAdmin:breadcrumbs breadCrumbs="${breadCrumbs}"/>
</div>
<div id="content" class="container">
  <g:if test="${flash.notice}">
    <div class="alert alert-success">
      <a class="close" data-dismiss="alert">×</a>
      ${flash.notice}
    </div>
  </g:if>
  <g:if test="${flash.warning}">
    <div class="alert alert-warning">
      <a class="close" data-dismiss="alert">×</a>
      ${flash.warning}
    </div>
  </g:if>
  <g:if test="${flash.error}">
    <div class="alert alert-error">
        <a class="close" data-dismiss="alert">×</a>
    	  ${flash.error}
    </div>
  </g:if>
  <g:layoutBody/>
</div>




<div id="modal_window" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 class="modal-title"></h3>
  </div>
  <div class="modal-body">

  </div>
  <div class="modal-footer modal-footer-default">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary form-submit">Save changes</button>
  </div>
</div>

</body>
</html>

<%@include file="common/resource_header.jsp" %>
<div class="container" style="background-attachment: fixed; background-image: url(dist/img/bg.jpg)" >
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form action="<c:url value="/auth/login"/>" method="POST">
                        <fieldset style="display:block;">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input class="form-control" placeholder="E-mail" id="email" value="master@apps.com" name="email" type="email" autofocus required>
                            </div>
                            <div class="form-group">
                                <label for="password" >Password</label>
                                <input class="form-control" placeholder="Password" id="password"  name="password" type="password" value="maste4321" required>
                            </div>
                            <div class="checkbox">
                                <label class="pull-right">
                                    <input id="keepme" name="keepme" type="checkbox" value="true" >Keep me logged in
                                </label>
                            </div>
                            
                             <c:if test="${!empty app}">
                                 <input id="app_id" name="app_key"  type="hidden" readonly="true"  value="${app.publicKey}"  >
                            </c:if>
                            
                            
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" class="btn btn-lg btn-success btn-block pull-left" style="margin-top: 10px;"> Submit </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${!empty app}">
        <div class="col-md-4 col-md-offset-4 thumbnail">
            <img class="img-responsive" src="${app.logoUrl}" alt="">
            <div class="caption">
                <h3 class="caption-label"> ${app.name} </h3>
                <p><a href="${app.aboutUrl}" >About</a> 
                    <a href="${app.termsUrl}"   class="pull-right">Terms</a></p>
            </div>
        </div>
    </c:if>
</div>
<%@include file="common/resource_footer.jsp" %>
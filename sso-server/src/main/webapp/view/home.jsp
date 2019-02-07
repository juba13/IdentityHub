<%@include file="common/resource_header.jsp" %>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <%@include file="common/app_header.jsp" %>        
</nav>
<div class="container-fluid">
    <c:forEach items="${apps}" var="app">
        <div class="thumbnail col-lg-2  col-md-4 col-sm-6 margin-top-lg margin-left-md margin-right-md">
            <img class="img-responsive" src="${app.logoUrl}" alt="">
            <div class="caption">
                <a href="${app.appUrl}" ><h3 class="caption-label"> ${app.name} </h3></a>
                 <p>${app.note}</p>
                <p><a href="${app.aboutUrl}" >About</a> 
                    <a href="${app.termsUrl}"   class="pull-right">Terms</a></p>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="common/resource_footer.jsp" %>
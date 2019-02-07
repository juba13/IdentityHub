<%@include file="common/resource_header.jsp" %>

<div id="wrapper">

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
     <%@include file="common/app_header.jsp" %>    
     <%@include file="common/app_menu.jsp" %>    
    </nav>
    <div id="page-wrapper">
        <%@include file="common/error_message.jsp" %>






        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Add new application
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form   action="<c:url value="/setup/app/save"/>"   id="app" method="post" class="col-lg-12" >

                            <div class="col-md-6">

                                <c:if test="${app.newApp}">
                                    <input name="newApp"  class="form-control" type="hidden" readonly="true"  value="${app.newApp}"  />
                                </c:if>  

                                <div class="form-group"><label> Application Id </label> <input type="text" name="id" readonly="true" value="${app.id}" class="form-control"></div>    
                                <div class="form-group"><label> Application Name </label> <input type="text" name="name" value="${app.name}" class="form-control"></div>
                                <div class="form-group"><label> Expire on </label> <input id="expireOn" type="date" name="expireOn" value="${app.expireOn}" class="form-control"></div>
                                <div class="form-group"><label> Application Category </label><select name="category.id"  class="form-control"  value="${app.category.id}" >
                                        <option value="">Select</option>
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.id}" <c:if test="${category.id==app.category.id}">selected</c:if>  >${category.name}</option>
                                        </c:forEach>
                                    </select> </div>
                                <div class="form-group "><label>Sort Order</label> <input id="sl" name="sl"  value="${app.sl}" type="number" class="form-control" ></div>
                                <div class="form-group "><label> Application Server IP Address </label> <input type="text" name="serverIp" value="${app.serverIp}" class="form-control"></div>

                            </div>
                            <div class="col-md-6">

                                <div class="form-group"><label> App URL </label> <input type="text" name="appUrl" value="${app.appUrl}" class="form-control"></div>
                                <div class="form-group"><label> Logout URL </label> <input type="text" name="logoutUrl" value="${app.logoutUrl}" class="form-control"></div>
                                <div class="form-group"><label> About URL </label> <input type="text" name="aboutUrl" value="${app.aboutUrl}" class="form-control"></div>
                                <div class="form-group"><label> Privacy URL </label> <input type="text" name="privacyUrl" value="${app.privacyUrl}" class="form-control"></div>
                                <div class="form-group"><label> Terms URL </label> <input type="text" name="termsUrl" value="${app.termsUrl}" class="form-control"></div>
                                <div class="form-group"><label> Logo URL </label> <input type="text" name="logoUrl" value="${app.logoUrl}" class="form-control"></div>

                            </div>
                            <div class="col-md-6">
                                <div class="form-group"><label> Public Key </label> <textarea rows = "5" name="publicKey"  readonly="true" class="form-control">${app.publicKey}</textarea></div>

                            </div>
                            <div class="col-md-6">
                                <div class="form-group"><label> Private Key </label> <textarea rows = "5" name="privateKey"  readonly="true" class="form-control">${app.privateKey}</textarea></div>

                            </div>
                                
                            <div class="col-md-6">
                                <div class="form-group"><label> Description </label> <textarea rows = "5" name="note"   class="form-control">${app.note}</textarea></div>

                            </div>    

                                <c:if test="${app.newApp}">
                                   <button type="submit" class="btn btn-default ">Save</button>
                                </c:if>
                                <c:if test="${!app.newApp}">
                                <button type="submit" class="btn btn-default">Update</button>
                                </c:if>
                            <a href="<c:url value="/setup/app/list"/>" class="btn btn-default " >Close</a>
                        </form>


                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->


</div>
<%@include file="common/resource_footer.jsp" %>
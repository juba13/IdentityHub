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
                    <h1 class="page-header">New User:</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Add new user
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                               <form id="user" action="<c:url value="/setup/user/save"/>" method="POST">
                                        <div class="row">

                                            <c:if test="${!empty user.id}">
                                                <input id="id" name="id"  class="form-control" type="hidden" readonly="true" value="${user.id}" >
                                            </c:if>

                                            <div class="form-group col-md-6">
                                                <label>User code</label>
                                                <input id="code" name="code"  type="text" class="form-control" value="${user.code}" required>
                                                <p class="help-block">Enter application user code here like "015"</p>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>User Name</label>
                                                <input id="name" name="name"  type="text" class="form-control" value="${user.name}" required>
                                                <p class="help-block">Enter application user name here like "Sarker"</p>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Email</label>
                                                <input id="email" name="email"  value="${user.email}" type="text" class="form-control" >
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label>Password</label>
                                                <input id="password" name="password" value="${user.password}"  type="text" class="form-control" >
                                            </div>
                                        </div>

                                        <c:if test="${!empty user.id}">
                                            <button type="submit" class="btn btn-default">Update</button>
                                        </c:if>
                                        <c:if test="${empty user.id}">
                                            <button type="submit" class="btn btn-default">Save</button>
                                        </c:if>
                                              <a href="<c:url value="/setup/user/list"/>" class="btn btn-default" >Close</a>

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
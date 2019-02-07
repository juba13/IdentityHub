<%@include file="common/resource_header.jsp" %>
<div id="wrapper">

  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
     <%@include file="common/app_header.jsp" %>    
     <%@include file="common/app_menu.jsp" %>    
    </nav>

    <div id="page-wrapper">
        <div class="row" >
            <div class="col-lg-12" style="margin-top: 5px;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="panel-heading" style="font-size: 20px;" >
                         User List
                        <div class="pull-right " ><a  class="btn btn-primary" href='<c:url value="/setup/user/add"/>' >Add New</a></div>
                    </div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>User Name</th>
                                    <th>Email</th>
                                    <th>Active Status</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${list}" var="user">
                                    <tr class="odd gradeX">
                                        <td>${user.name}</td>
                                        <td>${user.email}</td>
                                        <td>${user.active}</td>
                                        <td>

                                            <a href="<c:url value='edit/${user.id}' />"  class="btn btn-primary btn-circle"><i class="fa fa-edit"></i></a>

                                            <c:if test="${user.active}">
                                                <a href="<c:url value='change-state/${user.id}/${!user.active}' />" class="btn btn-warning btn-circle" ><i class="fa fa-times"></i></a>
                                                </c:if>    
                                                <c:if test="${!user.active}">
                                                <a href="<c:url value='change-state/${user.id}/${!user.active}' />" class="btn btn-info btn-circle" ><i class="fa fa-check"></i></a>
                                                </c:if>

                                        </td>
                                    </tr>
                                </c:forEach>




                            </tbody>
                        </table>
                        <!-- /.table-responsive -->

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<%@include file="common/resource_footer.jsp" %>
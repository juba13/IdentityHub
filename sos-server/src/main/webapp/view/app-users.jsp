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
                        <div class="panel-heading" style="font-size: 20px;" >${app.name}- User List 
                        </div>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">




                        <form id="frm-app-users" action="<c:url value="/setup/app/users/save"/>" id="app" method="post" >
                            <input id="app_id" name="app_id"  class="form-control" type="hidden" readonly="true" value="${app.id}" >

                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-multi">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>User Code</th>
                                        <th>User Name</th>
                                        <th>email</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${users}" var="user">
                                        <tr class="odd gradeX active">
                                            <td>${user.id}</td>
                                            <td>${user.code}</td>
                                            <td>${user.name}</td>
                                            <td>${user.email}</td>
                                        </tr>
                                    </c:forEach>




                                </tbody>
                            </table>   


                            <p><button>Submit</button></p>

                        </form>
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
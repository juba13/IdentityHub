<%@include file="common/resource_header.jsp" %>
<div id="wrapper">

   <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
     <%@include file="common/app_header.jsp" %>    
     <%@include file="common/app_menu.jsp" %>    
    </nav>

    <div id="page-wrapper">
        <%@include file="common/error_message.jsp" %>
        <div class="row "  >
            <div class="col-lg-12" style="margin-top:  10px;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>New Category</h4>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">


                        <form id="category" action="<c:url value="/setup/category/save"/>" method="POST">

                            <div class="row"> 

                                 <input id="active" name="active"  class="form-control" type="hidden" readonly="true" value="${category.active}"  >
                                <c:if test="${!empty category.id}">
                                    <input id="id" name="id"  class="form-control" type="hidden" readonly="true" value="${category.id}"  >
                                </c:if>
                                    
                                <div class="form-group col-md-6">
                                    <label>Category Name</label>
                                    <input id="name" name="name"  type="text" class="form-control" value="${category.name}" required>
                                    <p class="help-block">Enter application category name here like "Health"</p>
                                </div>
                                <div class="form-group col-md-3">
                                    <label>Sort Order</label>
                                    <input id="sl" name="sl"  value="${category.sl}" type="number" class="form-control" >
                                </div>
                            </div>


                            <c:if test="${!empty category.id}">
                                <button type="submit" class="btn btn-default">Update</button>
                                <a href="<c:url value="/setup/category/list"/>" class="btn btn-default" >Close</a>
                            </c:if>
                            <c:if test="${empty category.id}">
                                <button type="submit" class="btn btn-default">Save</button>

                                <button type="reset" class="btn btn-default">Reset Button</button>
                            </c:if>


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
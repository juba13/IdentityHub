<div class="navbar-header">
               <a class="navbar-brand" href='<c:url value="/home"/>' >IdentityHub</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a   href='<c:url value="/auth/logout"/>' ><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                        
                         <c:if test="${USER.master}">
                                    <li><a   href='<c:url value="/setup/app/list"/>' ><i class="fa fa-gears fa-fw"></i> Setup</a></li>
                         </c:if>
                           <c:if test="${!USER.master}">
                                  <li><a   href="login.html"><i class="fa fa-key fa-fw"></i> Change Password</a></li>
                         </c:if> 
                    </ul>
    </li>
</ul>
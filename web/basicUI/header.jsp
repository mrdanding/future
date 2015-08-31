<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">首页</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" id="myTab">
                <li><a href="/task/myPublishedTask.jsp">我的任务</a></li>
                <li><a href="/task/publishTask.jsp">发布任务</a></li>
                <li><a href="#contact">关于我们</a></li>
            </ul>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"--%>
                       <%--aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li class="dropdown-header">Nav header</li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                        <%--<li><a href="#">One more separated link</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <div class="navbar-form navbar-right">
                <a class="btn btn-primary" href="/account/login.jsp">登陆</a>
                <a class="btn btn-default" href="http://bbs.byws.org/?/account/register/">注册</a>
            </div>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>


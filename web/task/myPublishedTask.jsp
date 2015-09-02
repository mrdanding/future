<%@ page import="com.future.entity.TaskEntity" %>
<%@ page import="com.future.action.GetPublishedTaskAction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>我的任务</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/basicUI/header.jsp" %>
<div style="margin:10px 100px;">
    <s:if test="taskEntityList != null">
        <table class="table">
            <thead>
            <tr>
                <th>
                    任务名称
                </th>
                <th>
                    关键词
                </th>
                <th>
                    宝贝地址
                </th>
                <th>
                    状态
                </th>
                <th>
                    发布时间
                </th>
                <th>
                    目标浏览数量
                </th>
                <th>
                    已完成浏览数量
                </th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="taskEntityList" id="task">
                <tr>
                    <td>
                        <s:property value="#task.taskName"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.keyword"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.taskUrl"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.status"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.taskPublishTime"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.taskTotalCount"></s:property>
                    </td>
                    <td>
                        <s:property value="#task.taskFinishCount"></s:property>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:if>
    <s:else>
        没有发布任务!
    </s:else>
</div>

</div>
</body>
</html>

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
<%@ include file="/basicUI/header.jsp"%>

<div style="margin:10px 100px;">
    <table class="table" >
        <thead>
        <tr>
            <th>
                编号
            </th>
            <th>
                产品
            </th>
            <th>
                交付时间
            </th>
            <th>
                状态
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                1
            </td>
            <td>
                TB - Monthly
            </td>
            <td>
                01/04/2012
            </td>
            <td>
                Default
            </td>
        </tr>
        <tr class="success">
            <td>
                1
            </td>
            <td>
                TB - Monthly
            </td>
            <td>
                01/04/2012
            </td>
            <td>
                Approved
            </td>
        </tr>
        <tr class="error">
            <td>
                2
            </td>
            <td>
                TB - Monthly
            </td>
            <td>
                02/04/2012
            </td>
            <td>
                Declined
            </td>
        </tr>
        <tr class="warning">
            <td>
                3
            </td>
            <td>
                TB - Monthly
            </td>
            <td>
                03/04/2012
            </td>
            <td>
                Pending
            </td>
        </tr>
        <tr class="info">
            <td>
                4
            </td>
            <td>
                TB - Monthly
            </td>
            <td>
                04/04/2012
            </td>
            <td>
                Call in to confirm
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>发布任务</title>
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
    <form method="post" action="/publishTask">
        <table class="publish-detail-table">
            <tbody>
            <tr>
                <td class="first-td">您的宝贝链接：</td>
                <td class="second-td" colspan="3">
                    <input name="url" type="text" style="width: 300px;"/>
                    <span>&nbsp;*</span>
                </td>
            </tr>

            <tr class="multi-word-tr">
                <td class="first-td" style="width: 25%;">搜索关键词：</td>
                <td class="second-td" style="width: 30%;">
                    <input name="keyword" type="text" class="search-key-input basic-input2"/>
                    <span class="red">&nbsp;*</span></td>

                <td style="width: 15%;">目标访问量：</td>
                <td class="second-td">
                    <input name="totalCount" type="text" class="except-num-input basic-input3"/>
                    <span class="red">&nbsp;*</span></td>
            </tr>

            <tr class="search-type-row">
                <td class="first-td">宝贝浏览时间：</td>
                <td class="second-td" colspan="2">
                    <select name="" class="view-time-input base-input" style="height: 26px;">
                        <option value="0">请选择宝贝浏览时间</option>
                        <option value="2" selected="selected">2分钟</option>
                        <option value="4">4分钟</option>
                    </select>
                    <span class="red">&nbsp;*</span>
                </td>
                <td class="third-td"></td>
            </tr>

            <tr class="advance-real-tr" style=";">
                <td class="first-td">搜索价格区间：</td>
                <td class="second-td" colspan="2">
                    <input name="priceMin" type="text" class="start-search-price-input basic-input" style="width: 80px;"/>
                    -
                    <input name="priceMax" type="text" class="end-search-price-input basic-input" style="width: 80px;"/>
                    元
                </td>
                <td class="third-td"></td>
            </tr>

            <tr class="advance-real-tr" style=";">
                <td class="first-td">搜索卡地区：</td>
                <td class="second-td" colspan="2">
                    <input name="shipSource" type="text" class="basic-input filter-area-input" style=""/>
                </td>
                <td class="third-td"></td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="发布任务"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>

</div>
</body>
</html>

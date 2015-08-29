<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <table class="publish-detail-table">
        <tbody>
        <tr>
            <td class="first-td" style="">您的店铺旺旺：</td>
            <td class="second-td" colspan="3" style="">
                <input type="text" style="width: 300px;" class="seller-wangwang basic-input"/><span
                    class="red">&nbsp;*</span>
            </td>
        </tr>
        <tr>
            <td class="first-td">您的宝贝链接：</td>
            <td class="second-td" colspan="3">
                <input type="text" style="width: 300px;" class="item-link-input basic-input"/><span
                    class="red">&nbsp;*</span>
            </td>
        </tr>

        <tr class="multi-word-tr">
            <td class="first-td" style="width: 25%;">搜索关键词：</td>
            <td class="second-td" style="width: 30%;"><input type="text" class="search-key-input basic-input2"/><span
                    class="red">&nbsp;*</span></td>

            <td style="width: 15%;">目标访问量：</td>
            <td class="second-td"><input type="text" class="except-num-input basic-input3"/><span
                    class="red">&nbsp;*</span></td>
        </tr>

        <tr class="search-type-row">
            <td class="first-td">宝贝浏览时间：</td>
            <td class="second-td" colspan="2">
                <select class="view-time-input base-input" style="height: 26px;">
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
                <input type="text" class="start-search-price-input basic-input" style="width: 80px;"/>
                -
                <input type="text" class="end-search-price-input basic-input" style="width: 80px;"/>
                元
            </td>
            <td class="third-td"></td>
        </tr>

        <tr class="advance-real-tr" style=";">
            <td class="first-td">搜索卡地区：</td>
            <td class="second-td" colspan="2">
                <input type="text" class="basic-input filter-area-input" style=""/>
            </td>
            <td class="third-td"></td>
        </tr>
        </tbody>
    </table>

    <button>发布任务</button>
</div>
</body>
</html>

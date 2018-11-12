<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div>
    <table>
    <tr>
        <td>
            <img src="${pageContext.request.contextPath}/${param.zthumbnail}" style="width:150px;height: 150px">
            <p>专辑名称:${param.title}</p>
            <p>专辑集数:${param.set_count}</p>
            <p>上传日期:${param.create_date}</p>
            <p>专辑分数:${param.score}</p>
            <p>专辑作者:${param.author}</p>
            <p>专辑播音:${param.broadcast}</p>
            <p>专辑内容:${param.brief}</p>

        </td>
    </tr>
    </table>
</div>
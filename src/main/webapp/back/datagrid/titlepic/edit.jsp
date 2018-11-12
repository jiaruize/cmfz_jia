<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        console.log("${param.id}");
        $("#editlunInputForm").form('load','${pageContext.request.contextPath}/titlepic/queryOne?id=${param.id}');
    })
</script>
<div style="text-align: center;">
    <form id="editlunInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            图片路径: <input id="thumbnail" type="text" name="img" class="easyui-filebox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            图片描述: <input type="text" name="desc"  class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            图片状态:<select class="easyui-combobox" name="status" style="width:200px;">
            <option value="正常">正常</option>
            <option value="不正常">不正常</option>
        </select>
        </div>

    </form>
</div>
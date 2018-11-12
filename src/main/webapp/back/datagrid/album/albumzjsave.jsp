<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div style="text-align: center">
    <form id="savealbumInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
    <div style="margin-top: 70px">
        专辑封面:<input id="zthumbnail" type="text" name="img" class="easyui-filebox" data-options="required:true">
    </div>

    <div style="margin-top: 20px">
        专辑名称:<input type="text" name="title" class="easyui-textbox" data-options="required:true">
    </div>
   <%-- <div style="margin-top: 20px">
        专辑集数:<input type="text" name="set_count" class="easyui-textbox" data-options="required:true">
    </div>--%>
    <div style="margin-top: 20px">
        日期:<input type="text" name="create_date" class="easyui-datebox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        分数:<input type="text" name="score" class="easyui-textbox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        作者:<input type="text" name="author" class="easyui-textbox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        播音:<input type="text" name="broadcast" class="easyui-textbox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        内容:<input type="text" name="brief" class="easyui-textbox" data-options="required:true">
    </div>
    </form>

</div>
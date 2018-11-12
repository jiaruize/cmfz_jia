<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div style="text-align: center">
    <form id="saveGuruInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
    <div style="margin-top: 70px">
        头像路径:<input id="sheadpic" type="text" name="img" class="easyui-filebox" data-options="required:true">
    </div>

    <div style="margin-top: 20px">
        上师名字:<input type="text" name="sname" class="easyui-textbox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        上师状态:<select class="easyui-combobox" name="status" style="width:200px;">
                          <option value="正常">正常</option>
                          <option value="不正常">不正常</option>
                </select>
    </div>
    </form>

</div>
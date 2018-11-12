<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div style="text-align: center">
    <form id="saveUserInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
    <div style="margin-top: 70px">
        图片路径:<input id="thumbnail" type="text" name="img" class="easyui-filebox" data-options="required:true">
    </div>

    <div style="margin-top: 20px">
        图片描述:<input type="text" name="desc" class="easyui-textbox" data-options="required:true">
    </div>
    <div style="margin-top: 20px">
        图片状态:<select class="easyui-combobox" name="status" style="width:200px;">
                          <option value="正常">正常</option>
                          <option value="不正常">不正常</option>
                </select>
    </div>
    </form>

</div>
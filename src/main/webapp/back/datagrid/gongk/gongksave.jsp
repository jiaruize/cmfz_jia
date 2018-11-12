<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div style="text-align: center">
    <form id="saveUserInputForm" class="easyui-form" method="post" enctype="multipart/form-data">

    <div style="margin-top: 20px">
        功课名称:<input type="text" name="name" class="easyui-textbox" data-options="required:true">
    </div>
        <div style="margin-top: 20px">
            功课权限:<select class="easyui-combobox" name="score" style="width:200px;">
            <option value="必修">必修</option>
            <option value="选修">选修</option>
        </select>
        </div>
    <div style="margin-top: 20px">
        图片状态:<select class="easyui-combobox" name="status" style="width:200px;">
                          <option value="正常">正常</option>
                          <option value="不正常">不正常</option>
                </select>
    </div>
    </form>

</div>
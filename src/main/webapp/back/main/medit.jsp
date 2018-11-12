<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            原始密码: <input type="text" name="ypassword" class="easyui-passwordbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            新密码: <input type="text" name="password"  class="easyui-passwordbox" data-options="required:true">
        </div>
    </form>
</div>
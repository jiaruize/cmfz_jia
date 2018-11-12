 <%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>



    <script>
        $(function () {
            $('#gongkdg').datagrid({
                url:'${pageContext.request.contextPath}/gongk/findAll',//用来请求远程数据
                pagination:true,//显示分页工具栏
                pageNumber:1,//当前页
                pageSize:5,//每页显示记录数
                pageList:[2,5,10,15,30,500],
                striped:true,//斑马线效果
                rownumbers:true,//显示行号
                singleSelect:false,//定义可以选择多行
                ctrlSelect:true,//允许使用ctrl键
                fitColumns:true,//让列自适应整个容器
                height:600,

                columns:[[
                    {title:'cx',field:'cx',checkbox:true},
                    {title:'id',field:'id',width:120,},
                    {title:'name',field:'name',width:120,},
                    {title:'status',field:'status',width:120,},
                    {title:'score',field:'score',width:120,},
                    {title:'options',field:'options',width:200,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"
                        }
                    }

                ]],

               onLoadSuccess:function (){
                    $('.options').linkbutton();
               },
                toolbar:'#gongktb',
            });

        });


        //删除一行的事件
        function delRow(id){
            //获取当前点击id发送ajax请求删除id这个人的信息
            $.post("${pageContext.request.contextPath}/gongk/delete",{"id":id},function (result) {//响应成功之后回调
                //刷新datagrid数据
                $("#gongkdg").datagrid('reload');//刷新当前datagrid
            });
        }
        //打开保存用户对话框函数
        function openSavegongkDialog() {
            $("#savegongkDialog").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    plain:true,
                    handler:function(){
                       //保存用户信息
                        $("#saveUserInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/gongk/insert',
                            success:function(result){//响应的一定是json格式字符串   使用应该先转为js对象
                                var resultObj = $.parseJSON(result);
                                if(resultObj.success){
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"用户添加成功!!!"});
                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:"用户添加失败"});
                                }
                                //关闭对话框
                                $("#savegongkDialog").dialog('close');
                                //刷新datagrid
                                $("#gongkdg").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    plain:true,
                    handler:function(){
                        $("#savegongkDialog").dialog('close');
                    }
                }]
            });
        }




    </script>



<%--datagrid数据表格--%>
 <table id="gongkdg" ></table>

<%--datagrid工具栏--%>
<div id="gongktb">
    <a href="#" class="easyui-linkbutton" onclick="openSavegongkDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>
<%--保存用户对话框--%>
<div id="savegongkDialog" data-options="href:'${pageContext.request.contextPath}/back/datagrid/gongk/gongksave.jsp',draggable:false,iconCls:'icon-save',width:600,height:500,title:'保存用户信息'"></div>


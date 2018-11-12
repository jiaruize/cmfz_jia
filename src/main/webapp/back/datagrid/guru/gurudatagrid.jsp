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
            $('#du').datagrid({
                url:'${pageContext.request.contextPath}/guru/findAll',//用来请求远程数据
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
                    {title:'sheadpic',field:'sheadpic',width:120,},
                    /*{title:'pic',field:'pic',width:200,
                        formatter:function(value,row,index){
                            var img='<img src=${pageContext.request.contextPath}/'+row.thumbnail+' width="100px">';
                            return img;
                        }
                    },*/

                    {title:'sname',field:'sname',width:120,},
                    {title:'status',field:'status',width:120,},
                    {title:'options',field:'options',width:200,
                        formatter:function(value,row,index){
                            return "<a href='javascript:;' class='options' onclick=\"delGuru('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>";
                        }
                    }

                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    console.log(rowIndex);
                    console.log(rowData);
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.sheadpic + '" style="width:100px;height:75px;"></td>' +
                        '<td style="border:0">' +
                        '<p>sheadpic: ' + rowData.sheadpic + '</p>' +
                        '<p>sname: ' + rowData.sname + '</p>' +
                        '<p>status: ' + rowData.status + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
               onLoadSuccess:function (){
                    $('.options').linkbutton();
               },
                toolbar:'#tg',
            });

        });


        //删除一行的事件
        function delGuru(id){
            //获取当前点击id发送ajax请求删除id这个人的信息
            $.post("${pageContext.request.contextPath}/guru/delete",{"id":id},function (result) {//响应成功之后回调
                //刷新datagrid数据
                $("#du").datagrid('reload');//刷新当前datagrid
            });
        }
        //打开保存用户对话框函数
        function openSaveGuruDialog() {
            $("#saveGuruDialog").dialog({
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    plain:true,
                    handler:function(){
                       //保存用户信息
                        var sheadpic=$("#sheadpic").textbox('getText');

                        $("#saveGuruInputForm").form('submit',{
                           queryParams:{
                               sheadpic:sheadpic,
                            },
                            url:'${pageContext.request.contextPath}/guru/insert',
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
                                $("#saveGuruDialog").dialog('close');
                                //刷新datagrid
                                $("#du").datagrid('reload');
                            }
                        });
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    plain:true,
                    handler:function(){
                        $("#saveGuruDialog").dialog('close');
                    }
                }]
            });
        }
        //批量删除多行
        function delBatchGurus(){
            var rows = $("#du").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:"至少选中一行!!!"});
            }else{
                var ids = [];
                for (var i = 0; i < rows.length ; i++) {

                    ids.push(rows[i].id);
                }

                //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
                //                        如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
                $.ajax({
                    url:"${pageContext.request.contextPath}/guru/deleteAll",
                    type:"POST",
                    traditional:true,//传递数据类型的数据时必须设置这个属性为true
                    data:{byid:ids},
                    success:function(result){
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功!!!"});
                        //刷新datagrid
                        $("#du").datagrid('reload');
                    },
                    error:function(){
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败!!!"});
                        //刷新datagrid
                        $("#du").datagrid('reload');
                    }
                })
            }
        }



    </script>



<%--datagrid数据表格--%>
 <table id="du" ></table>

<%--datagrid工具栏--%>
<div id="tg">
    <a href="#" class="easyui-linkbutton" onclick="openSaveGuruDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="delBatchGurus();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>
<%--保存上师对话框--%>
<div id="saveGuruDialog" data-options="href:'${pageContext.request.contextPath}/back/datagrid/guru/gurusave.jsp',draggable:false,iconCls:'icon-save',width:600,height:500,title:'保存用户信息'"></div>



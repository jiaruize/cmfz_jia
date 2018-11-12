<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

    $(function () {
        $("#albumDg").treegrid({
           url:'${pageContext.request.contextPath}/album/findAll',
            method:'post',
            idField:'id',
            treeField:'title',
            pagination: true,
            pageNumber: 1,
            pageSize: 5,
            pageList: [2,5,10,15,30,500],
            animate:true,
            fitColumns:true,//让列自适应整个容器
            columns:[[
                {title:'cx',field:'cx',checkbox:true},
                {field: 'title' , title: '名字' , width: 120},
                {field: 'download_url' , title: '下载路径' , width: 120},
                {field: 'size' , title: '音频大小' , width: 120},
                {field: 'duration' , title: '音频时长' , width: 120},
           ]],
            toolbar: "#albumTb"
       });
    });
    //打开保存专辑对话框函数
    function albumaddFile() {
        $("#albumSavezjDialog").dialog({
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                plain:true,
                handler:function(){
                    //保存用户信息
                    var zthumbnail=$("#zthumbnail").textbox('getText');

                    $("#savealbumInputForm").form('submit',{
                        queryParams:{
                            zthumbnail:zthumbnail,
                        },
                        url:'${pageContext.request.contextPath}/album/insert',
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
                            $("#albumSavezjDialog").dialog('close');
                            //刷新treegrid
                            $("#albumDg").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                plain:true,
                handler:function(){
                    $("#albumSavezjDialog").dialog('close');
                }
            }]
        });
    }
    //打开保存章节对话框函数
    function albumseve() {
        var rows = $("#albumDg").treegrid('getSelected');
        console.log(rows.album_id);
        if(rows.album_id!=null && rows.size!=null){
            $.messager.show({title:'提示',msg:"至少选中一行!!!"});
        }else{
             var ids = rows.id;

            $("#albumSavezhangDialog").dialog({
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                plain:true,
                handler:function(){
                    //保存章节信息
                    var download_url=$("#download_url").textbox('getText');
                    $("#savechapterInputForm").form('submit',{
                        queryParams:{
                            download_url:download_url,
                            album_id:ids,
                        },
                        url:'${pageContext.request.contextPath}/chapter/insert',
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
                            $("#albumSavezhangDialog").dialog('close');
                            //刷新treegrid
                            $("#albumDg").treegrid('reload');
                        }
                    });
                }
            },{
                iconCls:'icon-cancel',
                text:'关闭',
                plain:true,
                handler:function(){
                    $("#albumSavezhangDialog").dialog('close');
                }
            }]
        });
        }
    }

    //打开展示专辑对话框函数
    function albumOpenzDialog() {
        var rows = $("#albumDg").treegrid('getSelected');
        console.log(rows.id);
        if(rows!=null && rows.children==null){
            $.messager.show({title:'提示',msg:"至少选中一行!!!"});
        }else {
            var ids=rows.id;

            //发送ajax请求传递数组  注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
            //                        如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
            $.ajax({
            url:"${pageContext.request.contextPath}/album/findOne",
            type:"POST",
            traditional:true,//传递数据类型的数据时必须设置这个属性为true
            data:{byid:ids},
            success:function(result){
            $("#albumzhanDialog").dialog({
            href:'${pageContext.request.contextPath}/back/datagrid/album/albumZhan.jsp?id='+result['id']+'&zthumbnail='+result['zthumbnail']+'&title='+result['title']+'&set_count='+result['set_count']+'&create_date='+result['create_date']+'&score='+result['score']+'&author='+result['author']+'&broadcast='+result['broadcast']+'&brief='+result['brief'],
            buttons:[{
            iconCls:'icon-cancel',
            text:'关闭',
            plain:true,
            handler:function(){
            $("#albumzhanDialog").dialog('close');
            }
            }]
            });
            }
            })}}
        //下载
    function albumxia() {
        var select = $("#albumDg").treegrid('getSelected');
        console.log(select);
        if (select != null && select.children == null){
            location.href='${pageContext.request.contextPath}/album/download?fileName='+select.download_url+'&openStyle=attachment';
        }else {
            $.messager.alert("警告",'请选择你要下载的音频','info');
        }
    }


</script>
<table id="albumDg"></table>
<%--datagrid工具栏--%>
<div id="albumTb">
    <a href="#" class="easyui-linkbutton" onclick="albumOpenzDialog();" data-options="plain:true">专辑详情</a>
    <a href="#" class="easyui-linkbutton" onclick="albumaddFile();" data-options="iconCls:'icon-add',plain:true">添加专辑</a>
    <a href="#" class="easyui-linkbutton" onclick="albumseve();" data-options="iconCls:'icon-add',plain:true">添加章节</a>
    <a href="#" class="easyui-linkbutton" onclick="albumxia();" data-options="iconCls:'icon-add',plain:true">下载音频</a>
</div>
<%--添加专辑对话框--%>
<div id="albumSavezjDialog" data-options="href:'${pageContext.request.contextPath}/back/datagrid/album/albumzjsave.jsp',draggable:false,iconCls:'icon-save',width:600,height:500,title:'保存专辑信息'" ></div>
<%--添加章节对话框--%>
<div id="albumSavezhangDialog" data-options="href:'${pageContext.request.contextPath}/back/datagrid/album/chaptersave.jsp',draggable:false,iconCls:'icon-edit',width:600,height:400,title:'保存章节对话框'"></div>
<%--展示专辑对话框--%>
<div id="albumzhanDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:500,title:'展示专辑对话框'"></div>

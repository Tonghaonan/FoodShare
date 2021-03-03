$(function () {
    //隐藏错误提示框
    $('.add-error-info').css("display", "none");//请求后台 JSON 数据的 URL
    $('.edit-error-info').css("display", "none");//后台返回的数据格式

    $("#jqGrid").jqGrid({
        url: '/getAllUser',
        datatype: "json",
        //列表信息，包括表头、宽度、是否显示、渲染参数等属性
        //label当jqGrid的colNames选项数组为空时，为各列指定题头
        //name为Grid中的每个列设置唯一的名称 对应数据中属性名
        //index设置排序时所使用的索引名称
        //sortable：设置该列是否可以排序，默认为true。
        colNames:['id','用户名','创建时间','性别','生日'],
        colModel: [
            //某些字段不要排序功能的话 只要在字段中加入 sortable：false；
            {label: 'id', name: 'uid', index: 'uid', hidden:true,width: 50, key: true},
            {label: '用户名', name: 'username', index: 'username', sortable: false, width: 50},
            {label: '创建时间', name: 'createTime', index: 'createTime', sortable: false, width: 50},
            {label: '性别', name: 'sex', index: 'sex', sortable: false, width: 30},
            {label: '生日', name: 'birthday', index: 'birthday', sortable: false, width: 80}
        ],
        //表格高度，可自行调节
        height: 485,
        //默认一页显示多少条数据，可自行调节
        rowNum: 10,
        //翻页控制条中，每页显示记录数可选集合
        rowList: [10, 30, 50],
        //主题，这里选用的是 Bootstrap 主题
        styleUI: 'Bootstrap',
        //数据加载时显示的提示信息
        loadtext: '信息读取中...',
        //是否显示行号，默认值是 false，不显示
        rownumbers: true,
        //行号列的宽度
        rownumWidth: 35,
        //宽度是否自适应
        autowidth: true,
        //是否可以多选
        multiselect: true,
        sortable:true,
        //分页信息 DOM
        pager: "#jqGridPager",           //这个参数指定了jqGrid页脚显示位置。
        sortname:'id',                   //这个参数指定了jqGrid默认的排序列，可以是列名也可以是数字。
        sortorder:"desc",                //这个参数指定了jqGrid默认排序列的默认排序方式。
        jsonReader: {
            root: "list",           //json中代表实际模型数据的入口
            page: "currPage",       //数据页码
            total: "totalPage",     //数据总页码
            records: "totalCount"   //数据总记录数
        },
        // 向后台请求的参数
        prmNames: {
            page: "page",
            rows: "limit",
        },
        // 数据加载完成并且 DOM 创建完毕之后的回调函数
        gridComplete: function () {
            //隐藏 Grid 底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

function userAdd() {
    //点击添加按钮后执行操作
    var modal = new Custombox.modal({
        content: {
            effect: 'fadein',
            target: '#modalAdd'
        }
    });
    modal.open();
}

function userEdit() {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }

    $('#userId').val(id);

    //点击编辑按钮后执行操作
    var modal = new Custombox.modal({
        content: {
            effect: 'fadein',
            target: '#modalEdit'
        }
    });
    modal.open();
}

//绑定modal上的保存按钮
$('#saveButton').click(function () {
    //验证数据
    if (validObjectForAdd()) {
        //一切正常后发送网络请求
        //ajax
        var userName = $("#userName").val();
        var password = $("#password").val();
        var data = {"userName": userName, "password": password};
        $.ajax({
            type: 'POST',//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: 'users/save',//url
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            beforeSend: function (request) {
                //设置header值
                request.setRequestHeader("token", getCookie("token"));
            },
            success: function (result) {
                console.log(result);//打印服务端返回的数据
                checkResultCode(result.resultCode);
                if (result.resultCode == 200) {
                    closeModal();
                    swal("保存成功", {
                        icon: "success",
                    });
                    //reload
                    reload();
                }
                else {
                    closeModal();
                    swal("保存失败", {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                reset();
                swal("操作失败", {
                    icon: "error",
                });
            }
        });

    }
});

//绑定modal上的编辑按钮
$('#editButton').click(function () {
    //验证数据
    if (validObjectForEdit()) {
        //一切正常后发送网络请求
        var password = $("#passwordEdit").val();
        var id = $("#userId").val();
        var data = {"id": id, "password": password};
        $.ajax({
            type: 'POST',//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: 'users/updatePassword',//url
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            beforeSend: function (request) {
                //设置header值
                request.setRequestHeader("token", getCookie("token"));
            },
            success: function (result) {
                checkResultCode(result.resultCode);
                console.log(result);//打印服务端返回的数据
                if (result.resultCode == 200) {
                    closeModal();
                    swal("修改成功", {
                        icon: "success",
                    });
                    //reload
                    reload();
                }
                else {
                    closeModal();
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                reset();
                swal(result.message, {
                    icon: "error",
                });
            }
        });

    }
});

//绑定modal上的编辑按钮
$('#importV2Button').click(function () {
    var fileUrl = $("#fileUrl").val();
    $.ajax({
        type: 'POST',
        dataType: "json",
        url: 'users/importV2?fileUrl=' + fileUrl,
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            checkResultCode(result.resultCode);
            console.log(result);
            if (result.resultCode == 200) {
                closeModal();
                reload();
                swal("成功导入" + result.data + "条记录！", {
                    icon: "success",
                });
            }
            else {
                closeModal();
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            reset();
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

/**
 * 用户删除
 */
function userDel() {
    var ids = getSelectedRows();
    if (ids == null) {
        return;
    }
    swal({
        title: "确认弹框",
        text: "确认要删除数据吗?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
        if (flag) {
            $.ajax({
                type: "POST",
                url: "users/delete",
                contentType: "application/json",
                beforeSend: function (request) {
                    //设置header值
                    request.setRequestHeader("token", getCookie("token"));
                },
                data: JSON.stringify(ids),
                success: function (r) {
                    checkResultCode(r.resultCode);
                    if (r.resultCode == 200) {
                        swal("删除成功", {
                            icon: "success",
                        });
                        $("#jqGrid").trigger("reloadGrid");
                    } else {
                        swal(r.message, {
                            icon: "error",
                        });
                    }
                }
            });
        }
    });
}


//添加Modal关闭
$('#cancelAdd').click(function () {
    closeModal();
})

//编辑Modal关闭
$('#cancelEdit').click(function () {
    closeModal();
})

//导入Modal关闭
$('#cancelImportV2').click(function () {
    closeModal();
})

/**
 * 数据验证
 */
function validObjectForAdd() {
    var userName = $('#userName').val();
    if (isNull(userName)) {
        showErrorInfo("用户名不能为空!");
        return false;
    }
    if (!validUserName(userName)) {
        showErrorInfo("请输入符合规范的用户名!");
        return false;
    }
    var password = $('#password').val();
    if (isNull(password)) {
        showErrorInfo("密码不能为空!");
        return false;
    }
    if (!validPassword(password)) {
        showErrorInfo("请输入符合规范的密码!");
        return false;
    }
    return true;
}

/**
 * 数据验证
 */
function validObjectForEdit() {
    var userId = $('#userId').val();
    if (isNull(userId) || userId < 1) {
        showErrorInfo("数据错误！");
        return false;
    }
    var password = $('#passwordEdit').val();
    if (isNull(password)) {
        showErrorInfo("密码不能为空!");
        return false;
    }
    if (!validPassword(password)) {
        showErrorInfo("请输入符合规范的密码!");
        return false;
    }
    return true;
}

/**
 * 关闭modal
 */
function closeModal() {
    //关闭前清空输入框数据
    reset();
    Custombox.modal.closeAll();
}

/**
 * 重置
 */
function reset() {
    //隐藏错误提示框
    $('.add-error-info').css("display", "none");
    $('.edit-error-info').css("display", "none");
    //清空数据
    $('#password').val('');
    $('#passwordEdit').val('');
    $('#userName').val('');
}

/**
 * jqGrid重新加载
 */
function reload() {
    reset();
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}
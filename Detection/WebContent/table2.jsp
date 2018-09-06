<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>风格定制-Bootstrap样例1</title>
    <!-- Bootstrap css -->
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
    <!-- 当前项目样式文件 -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/sb-bk-theme.css" rel="stylesheet">
    <!--蓝鲸平台APP 公用的样式文件 -->

    <link href="https://magicbox.bk.tencent.com/static_api/v3/bk/css/bk.css" rel="stylesheet">
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/html5shiv.min.js"></script>
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div id="wrapper">
        <%@include file="frame.jsp" %>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row page-header-box">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            用户管理
                        </h1>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        用户列表
                    </div>
                    <div>
                        <div class="king-wrapper">
                            <form class="form-inline king-search-form king-no-bg mt15 mb15 pull-left">
                                <div class="form-group">
                                    <label>用户账号：</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="请输入用户账号">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-time fa fa-calendar-o"></i></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>用户名：</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="请输入用户账号">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-time fa fa-calendar-o"></i></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>状态：</label>
                                    <div class="input-group">
                                        <select class="form-control">
                                            <option value="1">待审核</option>
                                            <option value="2">全部</option>
                                        </select>
                                    </div>
                                </div>

                                <button type="submit" class="king-btn king-info">搜索</button>
                            </form>
                            <a type="button" id="transferID" class="king-btn king-success pull-right mt15 ml15">
                                <i class="fa fa-gavel mr5"></i>审核
                            </a>
                            <a href="user_add.html" class="king-btn king-info pull-right mt15 ml15"> 
                                <i class="fa fa-user-plus mr5"></i>新增用户
                            </a>
                        </div>

                        <table class="table table-out-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width: 10px">
                                        <input type="checkbox" class="del-all-cb">
                                    </th>
                                    <th style="width:50px;">序号</th>
                                    <th>用户账号</th>
                                    <th>角色</th>
                                    <th>用户名</th>
                                    <th>性别</th>
                                    <th>邮箱</th>
                                    <th>手机号</th>
                                    <th>地区</th>
                                    <th>注册时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-warning fb">待审核</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-success fb">审核通过</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-warning fb">待审核</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-success fb">审核通过</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-success fb">审核通过</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-success fb">审核通过</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" name="del-cb">
                                    </td>
                                    <td>1</td>
                                    <td>admin</td>
                                    <td>系统管理员</td>
                                    <td>admin</td>
                                    <td>男</td>
                                    <td>123344@gamil.com</td>
                                    <td>13502569874</td>
                                    <td>广东省-广州市</td>
                                    <td>2015-06-07 21:45</td>
                                    <td><span class="text-warning fb">待审核</span></td>
                                    <td>
                                        <a href="#" class="mr15">编辑</a>
                                        <a href="#">已审核</a>
                                    </td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="12">
                                        <div class="pagination-info pull-left">共4条记录，当前第1/1页，每页20条记录</div>
                                        <div class="pull-right king-page-box">

                                            <ul class="pagination pagination-small pull-right">
                                                <li page-index="1" class="disabled"><a>«</a></li>
                                                <li page-index="1" class="active"><a>1</a></li>
                                                <li page-index="1"><a href="javascript:;">2</a></li>
                                                <li page-index="1"><a href="javascript:;">3</a></li>
                                                <li page-index="1"><a href="javascript:;">4</a></li>
                                                <li page-index="1"><a href="javascript:;">»</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>

                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/jquery-1.10.2.min.js"></script>
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/js/bootstrap.min.js"></script>

</body>

</html>
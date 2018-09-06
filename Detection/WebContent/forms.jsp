<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>风格定制-Bootstrap样例1</title>
    <!-- Bootstrap css -->
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
    <!-- 当前项目样式文件 -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/sb-bk-theme.css" rel="stylesheet">
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/jquery-1.10.2.min.js"></script>
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
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

                <div class="main-wrap">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            新增用户
                        </div>
                        <div class="panel-body">
                            <div class="col-sm-8">
                                <form enctype="multipart/form-data" method="post" class="form-horizontal mt15" id="user_form" action="#">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">上传文件：</label>
                                        <div class="col-sm-10">
                                            <input type="file"  style="font-size:18px;" name="upload">
                                            <p class="help-block">请上传小于150MB的apk文件</p>
                                        </div>
                                    </div>
                                    
                                   	<br/>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"></label>
                                        <div class="col-sm-10">
                                            <button class="king-btn king-success mr10" title="上传" type="submit">
                                                <i class="fa fa-upload btn-icon"></i>上传
                                            </button>
                                             <input type="reset" class="king-btn king-default fa fa-mail-reply-all" value="取消" />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
        

    </div>
    <!-- /#wrapper -->


</body>

</html>
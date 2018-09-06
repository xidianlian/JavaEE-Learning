<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>风格定制-Bootstrap样例1</title>
     <!--公用的样式文件 -->
     <link href="https://magicbox.bk.tencent.com/static_api/v3/bk/css/bk.css" rel="stylesheet">
    <!-- Bootstrap css -->
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://magicbox.bk.tencent.com/static_api/v3/assets/fontawesome/css/font-awesome.css" rel="stylesheet">
	<!-- 下拉框 -->
	<link href="https://magicbox.bk.tencent.com/static_api/v3/assets/select2-3.5.2/select2.css" rel="stylesheet">
	<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/jquery-1.10.2.min.js"></script>
	<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/select2-3.5.2/select2.js"></script>
    <!-- 当前项目样式文件 -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link href="css/sb-bk-theme.css" rel="stylesheet">
    <!-- 日期和时间 -->
	<link href="https://magicbox.bk.tencent.com/static_api/v3/assets/daterangepicker-2.0.5/daterangepicker.css" rel="stylesheet">
	<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/daterangepicker-2.0.5/moment.min.js"></script>
	<script src="https://magicbox.bk.tencent.com/static_api/v3/assets/daterangepicker-2.0.5/daterangepicker.js"></script>
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/html5shiv.min.js"></script>
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<script type="text/javascript">
$(function () {
    //daterangepicker_demo4_js_start
    // 单个日期和日期范围选择
    var optionSet1 = {
        startDate: moment(),
        endDate: moment(),
        minDate: '01/01/2012',
        maxDate: '12/31/2020',
        showDropdowns: true,
        showWeekNumbers: true,
        timePicker: false,
        timePickerIncrement: 1,
        timePicker12Hour: true,
        ranges: {
            '今日': [moment(), moment()],
            '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            '最近一个星期': [moment().subtract(6, 'days'), moment()],
            '最近一个月': [moment().subtract(29, 'days'), moment()],
            '这个月': [moment().startOf('month'), moment().endOf('month')],
            '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        opens: 'right',
        buttonClasses: ['btn btn-default'],
        applyClass: 'btn-sm btn-primary',
        cancelClass: 'btn-sm',
        format: 'MM/DD/YYYY',
        separator: ' to ',
        locale: {
            applyLabel: '提交',
            cancelLabel: '取消',
            fromLabel: '从',
            toLabel: '到',
            weekLabel: '周',
            customRangeLabel: '自定义范围',
            daysOfWeek: ['日', '一', '二', '三', '四', '五','六'],
            monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            firstDay: 1
        }
    };
    $('#daterangepicker_demo4').daterangepicker(optionSet1, function(start, end, label){
        $('#daterangepicker_demo4 span').html(start.format('YYYY-MM-DD') + ' 至 ' + end.format('YYYY-MM-DD'));
    });
    //daterangepicker_demo4_js_end  
});
</script>

<body>
<div id="wrapper">
	<%@include file="frame.jsp"%>
	<div id="page-wrapper">
    	<div class="container-fluid">
             <div class="row page-header-box">
                 <div class="col-lg-12">
                     <h1 class="page-header">
                        		 检测记录
                     </h1>
                 </div>
             </div>
             <!-- Page Heading -->
             <div class="panel panel-default">
                 <div class="panel-heading">
                  		   查询条件
                 </div>
                 <div class='panel-body'>
                     <div class="row">
                         <form role="form">
						<div class="col-sm-6 col-md-6 col-lg-4">
                                 <div class="form-group">
                                     <div class="input-group">
                                         <div class="input-group-addon">状态</div>
									<select id="e1" class="form-control">
									    <option value="所有记录" selected="selected">所有记录</option>
									    <option value="检测中">检测中</option>
									    <option value="检测完成">检测完成</option>
									    <option value="检测失败">检测失败</option>
									</select>
                                     </div>
                                 </div>
                             </div>
                             <div class="col-sm-6 col-md-6 col-lg-4">
                                 <div class="form-group">
                                     <div class="input-group">
                                         <div class="input-group-addon">程序名称</div>
                                         <input type="text" class="form-control">
                                     </div>
                                 </div>

                             </div>
                             <div class="col-sm-6 col-md-6 col-lg-4">
                                 <div class="form-group">
                                     <div class="input-group">
                                         <div class="input-group-addon">创建日期</div>
                                         <div class="king-block-content plugin16_demo" id="plugin16_demo1">
  										 <input type="text" class="form-control daterangepicker_demo" id="daterangepicker_demo4" placeholder="选择日期...">
											</div>
                                     </div>
                                 </div>
                             </div>
                             
                             <div class="col-lg-12">
                                 <hr class="mt5 mb15">
                                 <button type="submit" class="king-btn king-info">查询</button>
                                 <button type="submit" class="king-btn king-success">重置</button>
                             </div>

                         </form>
                     </div>
                 </div>
             </div>
             <!---->
             <div class="panel panel-default">
                 <div class="panel-heading">
                     	检测列表
                 </div>
                 <div class='panel-body'>
                     <div class="table-responsive">
                         <table class="table table-bordered table-hover table-striped">
                             <thead>
                                 <tr>
                                     <th width="10%">状态</th>
                                     <th width="10%">程序名称</th>
                                     <th width="20%">别名</th>
                                     <th width="10%">大小</th>
                                     <th width="10%">创建时间</th>
                                     <th width="25%">操作</th>
                                 </tr>
                             </thead>
                             <tbody>
                                 <tr>
                                     <td>检测完成</td>
                                     <td>xxx.apk...</td>
                                     <td>0001C1F2A6FEF20001C1F2A6FEF2...</td>
                                     <td>2.76 MB</td>
                                     <td>2018-08-12 15:28</td>
                                     <td>
	                            <a class="king-btn king-success" title="检测详情">
	                                <i class="fa fa-bar-chart btn-icon"></i>检测详情
	                            </a>
	                            <a class="king-btn king-info " title="下载报告">
	                                <i class="fa fa-download btn-icon"></i>下载报告
	                            </a>
	                            <a class="king-btn king-danger" title="删除">
	                                <i class="fa fa-close btn-icon"></i>删除
	                            </a>
                     				</td>
                                 </tr>
                                 <tr>
                                      <td>检测完成</td>
                                     <td>xxx.apk...</td>
                                     <td>0001C1F2A6FEF20001C1F2A6FEF2...</td>
                                     <td>2.76 MB</td>
                                     <td>2018-08-12 15:28</td>
                                        <td>
	                            <a class="king-btn king-success" title="检测详情">
	                                <i class="fa fa-bar-chart btn-icon"></i>检测详情
	                            </a>
	                            <a class="king-btn king-info " title="下载报告">
	                                <i class="fa fa-download btn-icon"></i>下载报告
	                            </a>
	                            <a class="king-btn king-danger" title="删除">
	                                <i class="fa fa-close btn-icon"></i>删除
	                            </a>
                     				</td>
                                 </tr>
                                 <tr>
                                     <td>检测完成</td>
                                     <td>xxx.apk...</td>
                                     <td>0001C1F2A6FEF20001C1F2A6FEF2...</td>
                                     <td>2.76 MB</td>
                                     <td>2018-08-12 15:28</td>
                                        <td>
	                            <a class="king-btn king-success" title="检测详情">
	                                <i class="fa fa-bar-chart btn-icon"></i>检测详情
	                            </a>
	                            <a class="king-btn king-info " title="下载报告">
	                                <i class="fa fa-download btn-icon"></i>下载报告
	                            </a>
	                            <a class="king-btn king-danger" title="删除">
	                                <i class="fa fa-close btn-icon"></i>删除
	                            </a>
                     				</td>
                                 </tr>
                                 <tr>
                                     <td>检测完成</td>
                                     <td>xxx.apk...</td>
                                     <td>0001C1F2A6FEF20001C1F2A6FEF2...</td>
                                     <td>2.76 MB</td>
                                     <td>2018-08-12 15:28</td>
                                        <td>
	                            <a class="king-btn king-success" title="检测详情">
	                                <i class="fa fa-bar-chart btn-icon"></i>检测详情
	                            </a>
	                            <a class="king-btn king-info " title="下载报告">
	                                <i class="fa fa-download btn-icon"></i>下载报告
	                            </a>
	                            <a class="king-btn king-danger" title="删除">
	                                <i class="fa fa-close btn-icon"></i>删除
	                            </a>
                     				</td>
                                 </tr>
                                
                                 <tr>
                                     <td>检测完成</td>
                                     <td>xxx.apk...</td>
                                     <td>0001C1F2A6FEF20001C1F2A6FEF2...</td>
                                     <td>2.76 MB</td>
                                     <td>2018-08-12 15:28</td>
                                        <td>
	                            <a class="king-btn king-success" title="检测详情">
	                                <i class="fa fa-bar-chart btn-icon"></i>检测详情
	                            </a>
	                            <a class="king-btn king-info " title="下载报告">
	                                <i class="fa fa-download btn-icon"></i>下载报告
	                            </a>
	                            <a class="king-btn king-danger" title="删除">
	                                <i class="fa fa-close btn-icon"></i>删除
	                            </a>
                     				</td>
                                 </tr>
                                 
                                 <tfoot>
                                     <tr>
                                         <td colspan="6">
                                             <div class="pagination-info pull-left">共有100条，每页显示：50条</div>
                                             <div class="pull-right king-page-box">
                                                 <ul class="pagination pagination-small pull-right">
                                                     <li class="disabled"><a>«</a></li>
                                                     <li class="active"><a>1</a></li>
                                                     <li><a href="javascript:void(0);">2</a></li>
                                                     <li><a href="javascript:void(0);">3</a></li>
                                                     <li><a href="javascript:void(0);">4</a></li>
                                                     <li><a href="javascript:void(0);">»</a></li>
                                                 </ul>
                                             </div>
                                         </td>
                                     </tr>
                                 </tfoot>
                             </tbody>
                         </table>
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
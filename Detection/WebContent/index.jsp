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
         <%@include file="frame.jsp"%>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row page-header-box">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            概述
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row data-panel">
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">260</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-image"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">300</span>
                                        <span class="king-counter-icon ml10 white">
                                            <i class="fa fa-music"></i>
                                        </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">110</span>
                                        <span class="king-counter-icon ml10 white">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="king-widget2">
                            <div class="king-widget-content p20 bg-info">
                                <div class="king-counter king-counter-lg">
                                    <div class="king-counter-label text-uppercase f16">we have</div>
                                    <div class="king-counter-number-group">
                                        <span class="king-counter-number white">50</span>
                                        <span class="king-counter-number-related white">+</span>
                                    </div>
                                    <div class="king-counter-label text-uppercase f16">followers</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row charts">
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartA"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartC"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartB"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="king-block king-block-bordered mb30">
                            <div class="king-block-header">
                                <h3 class="king-block-title">数据</h3>
                            </div>
                            <div class="king-block-content">
                                <div class="chart" id="chartD"></div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.row -->

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

    <!-- 包括所有kendoui的js插件或者可以根据需要使用的js插件调用　-->
    <script src="https://magicbox.bk.tencent.com/static_api/v3/assets/kendoui-2015.2.624/js/kendo.all.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#chartA').kendoChart({
                seriesDefaults: {
                    type: 'line'
                },
                legend: {
                    position: "bottom"
                },
                theme: 'bootstrap',
                tooltip: {
                    visible: true,
                    template: "#= series.name # #= value #"
                },
                categoryAxis: {
                    categories: ['07-20', '07-21', '07-22', '07-23', '07-24', '07-25', '07-26'],
                    majorGridLines: {
                        visible: false
                    }
                },
                series: [{
                    name: "测试数据1",
                    data: [0, 2, 4, 5, 0, 1, 0]
                }, {
                    name: "测试数据2",
                    data: [0, 1, 0, 0, 2, 0, 0]
                }, {
                    name: "测试数据3",
                    data: [4, 0, 2, 1, 5, 0, 1]
                }]
            });

            $('#chartB').kendoChart({
                legend: {
                    position: "bottom"
                },
                theme: 'bootstrap',
                seriesDefaults: {
                    type: 'area',
                    area: {
                        line: {
                            style: "smooth"
                        }
                    }
                },
                categoryAxis: {
                    categories: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
                    majorGridLines: {
                        visible: false
                    }
                },
                series: [{
                        name: '项目一',
                        data: [10, 12, 21, 54, 260, 830, 710]
                    },
                    {
                        name: '项目二',
                        data: [30, 182, 434, 791, 390, 30, 10]
                    },
                    {
                        name: '项目三',
                        data: [1320, 1132, 601, 234, 120, 90, 20]
                    }
                ]
            });

            $('#chartC').kendoChart({
                legend: {
                    position: "bottom"
                },
                theme: 'bootstrap',
                seriesDefaults: {
                    labels: {
                        template: "#= category # - #= kendo.format('{0:P}', percentage)#",
                        position: "outsideEnd",
                        visible: true,
                        background: "transparent"
                    }
                },
                series: [{
                    name: '访问来源',
                    type: 'pie',
                    data: [{
                            category: '直接访问',
                            value: 335
                        },
                        {
                            value: 310,
                            category: '测试数据1'
                        },
                        {
                            value: 234,
                            category: '测试数据2'
                        },
                        {
                            value: 135,
                            category: '测试数据3'
                        },
                        {
                            value: 1548,
                            category: '测试数据4'
                        }
                    ]
                }]
            });

            $('#chartD').kendoChart({
                seriesDefaults: {
                    type: 'column'
                },
                legend: {
                    position: "bottom"
                },
                theme: 'bootstrap',
                tooltip: {
                    visible: true,
                },
                categoryAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                    majorGridLines: {
                        visible: false
                    }
                },
                series: [{
                    name: '测试数据1',
                    data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
                }, {
                    name: '测试数据2',
                    data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
                }, {
                    name: '测试数据4',
                    data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
                }, {
                    name: '测试数据5',
                    data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]
                }]
            });
        });

        //重新绘制
        $(window).on('resize', function() {
            var chartA = $("#chartA").data("kendoChart");
            var chartB = $("#chartB").data("kendoChart");
            var chartC = $("#chartC").data("kendoChart");
            var chartD = $("#chartD").data("kendoChart");

            chartA.redraw();
            chartB.redraw();
            chartC.redraw();
            chartD.redraw();
        });
    </script>

</body>

</html>
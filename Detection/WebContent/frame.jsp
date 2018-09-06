<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">
                    <i class="fa fa-leaf f20 mr5"></i>
                    Android恶意软件测试系统
                </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="javascript:;">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="img/50x50.png" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>qcloud</strong>
                                        </h5>
                                        <p class="small text-muted">Yesterday at 4:32 PM</p>
                                        <p>当前有一条未读的短消息...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="javascript:;">查看所有消息</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="javascript:;"><span class="label label-default">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-primary">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-success">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-info">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-warning">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li>
                            <a href="javascript:;"><span class="label label-danger">&nbsp;&nbsp;提醒内容&nbsp;&nbsp;</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:;" class='text-center'>查看所有提醒</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> admin <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-user"></i> 用户</a>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-envelope"></i> 消息盒</a>
                        </li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-gear"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:;"><i class="fa fa-fw fa-power-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <c:set var="uri" value="${pageContext.request.requestURI }"></c:set>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	
                	<li class="${uri=='/Detection/index.jsp'?'active':''}">
                        <a href="index.jsp"  ><i class="fa fa-fw fa-dashboard"></i> 首页</a>
                    </li>
                	<li class="${uri=='/Detection/detection_list.jsp'?'active':''}">
                        <a href="detection_list.jsp" ><i class="fa fa-fw fa-table"></i> 检测记录</a>
                    </li>
                    <li class="${uri=='/Detection/forms.jsp'?'active':''}">
                        <a href="forms.jsp" ><i class="fa fa-fw fa-cloud-upload"></i> 上传检测</a>
                    </li>
                    <li  class="${uri=='/Detection/table2.jsp'?'active':''}">
                        <a href="table2.jsp"><i class="fa fa-fw fa-desktop"></i> 表格2</a>
                    </li>
<!--                     <li> -->
<!--                         <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap 布局</a> -->
<!--                     </li> -->
<%--                     <li class="${uri=='/Detection/forms.jsp'?'active':''}"> --%>
<!--                         <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> 下拉菜单 <i class="fa fa-fw fa-caret-down"></i></a> -->
<!--                         <ul id="demo" class="collapse"> -->
<!--                             <li> -->
<!--                                 <a href="javascript:;">子菜单1 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="javascript:;">子菜单2</a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </li> -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
        
       
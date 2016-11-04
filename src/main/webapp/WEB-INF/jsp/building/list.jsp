<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Building | Home</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootsTrapCss"/>
    <spring:url value="/resources/css/plugins/toastr/toastr.min.css" var="toastrCss" />
    <spring:url value="/resources/font-awesome/css/font-awesome.css" var="awesomeFontCss" />
    <spring:url value="/resources/css/animate.css" var="animateCss" />
    <spring:url value="/resources/css/style.css" var="styleCss" />
    <spring:url value="/resources/js/plugins/gritter/jquery.gritter.css" var="gritterCss" />

    <link href="${bootsTrapCss}" rel="stylesheet" type="text/css"/>
    <link href="${toastrCss}" rel="stylesheet" type="text/css"/>
    <link href="${awesomeFontCss}" rel="stylesheet" type="text/css"/>
    <link href="${animateCss}" rel="stylesheet" type="text/css"/>
    <link href="${styleCss}" rel="stylesheet" type="text/css"/>
    <link href="${gritterCss}" rel="stylesheet" type="text/css"/>

</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xlp1/v/t1.0-1/c70.0.160.160/p160x160/14657399_1503786549647820_9137950906811511318_n.jpg?oh=3a5e308f69e3bf1573b91e19be260b0e&oe=58CD0D70&__gda__=1490129102_bd1551a21cb90318a193a38ea80f481c" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${aui.fullName}</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Thông Tin Cá Nhân</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        B
                    </div>
                </li>
                <li class="active">
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Tin nội bộ </br> (News)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Phản hồi đánh giá </br> (Complaint)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Yêu cầu </br> (Request/Booking)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Tòa nhà </br> (Building)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Tài sản chung </br> (Asset)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Lịch sử căn hộ </br> (History)</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Member</span> <span class="fa arrow"></span></a>
                </li>
                <li>
                    <a href="index-2.html"><i class="fa fa-th-large"></i> <span class="nav-label">Phí dịch vụ </br> (Service)</span> <span class="fa arrow"></span></a>
                </li>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="http://webapplayers.com/inspinia_admin-v2.5/search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">Chào mừng ${aui.fullName}.</span>
                    </li>
                    <li>
                        <a class="right-sidebar-toggle">
                            <i class="fa fa-tasks"></i>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">

                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="grid_options.html">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>See All Alerts</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <!--Content main -->

    </div>
</div>

<!-- Mainly scripts -->
<spring:url value="/resources/js/jquery-2.1.1.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

<spring:url value="/resources/js/plugins/metisMenu/jquery.metisMenu.js" var="metisMenuJs" />
<spring:url value="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js" var="slimscrollJs" />
<script src="${metisMenuJs}"></script>
<script src="${slimscrollJs}"></script>
<!-- Flot -->
<spring:url value="/resources/js/plugins/flot/jquery.flot.js" var="flotJs" />
<spring:url value="/resources/js/plugins/flot/jquery.flot.tooltip.min.js" var="tooltipJs" />
<spring:url value="/resources/js/plugins/flot/jquery.flot.spline.js" var="splineJs" />
<spring:url value="/resources/js/plugins/flot/jquery.flot.resize.js" var="resizeJs" />
<spring:url value="/resources/js/plugins/flot/jquery.flot.pie.js" var="pieJs" />
<script src="${flotJs}"></script>
<script src="${tooltipJs}"></script>
<script src="${splineJs}"></script>
<script src="${resizeJs}"></script>
<script src="${pieJs}"></script>
<!-- Peity -->
<spring:url value="/resources/js/plugins/peity/jquery.peity.min.js" var="peityJs" />
<spring:url value="/resources/js/demo/peity-demo.js" var="peityDemoJs" />
<script src="${peityJs}"></script>
<script src="${peityDemoJs}"></script>

<!-- Custom and plugin javascript -->
<spring:url value="/resources/js/inspinia.js" var="inspiniaJs" />
<spring:url value="/resources/js/plugins/pace/pace.min.js" var="paceJs" />
<script src="${inspiniaJs}"></script>
<script src="${paceJs}"></script>

<!-- jQuery UI -->
<spring:url value="/resources/js/plugins/jquery-ui/jquery-ui.min.js" var="uiMinJs" />
<script src="${uiMinJs}"></script>

<!-- GITTER -->
<spring:url value="/resources/js/plugins/gritter/jquery.gritter.min.js" var="gritterJs" />
<script src="${gritterJs}"></script>

<!-- Sparkline -->
<spring:url value="/resources/js/plugins/sparkline/jquery.sparkline.min.js" var="sparklineMinJs" />
<script src="${sparklineMinJs}"></script>

<!-- Sparkline demo data  -->
<spring:url value="/resources/js/demo/sparkline-demo.js" var="sparklineJs" />
<script src="${sparklineJs}"></script>

<!-- ChartJS-->
<spring:url value="/resources/js/plugins/chartJs/Chart.min.js" var="chartJs" />
<script src="${chartJs}"></script>

<!-- Toastr -->
<spring:url value="/resources/js/plugins/toastr/toastr.min.js" var="toastrJs" />
<script src="${toastrJs}"></script>

<%--<script>
    $(document).ready(function() {
        setTimeout(function() {
            toastr.options = {
                closeButton: true,
                progressBar: true,
                showMethod: 'slideDown',
                timeOut: 4000
            };
            toastr.success('Responsive Admin Theme', 'Welcome to INSPINIA');

        }, 1300);


        var data1 = [
            [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,30],[11,10],[12,13],[13,4],[14,3],[15,3],[16,6]
        ];
        var data2 = [
            [0,1],[1,0],[2,2],[3,0],[4,1],[5,3],[6,1],[7,5],[8,2],[9,3],[10,2],[11,1],[12,0],[13,2],[14,8],[15,0],[16,0]
        ];
        $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [
                    data1, data2
                ],
                {
                    series: {
                        lines: {
                            show: false,
                            fill: true
                        },
                        splines: {
                            show: true,
                            tension: 0.4,
                            lineWidth: 1,
                            fill: 0.4
                        },
                        points: {
                            radius: 0,
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#d5d5d5",
                        borderWidth: 1,
                        color: '#d5d5d5'
                    },
                    colors: ["#1ab394", "#1C84C6"],
                    xaxis:{
                    },
                    yaxis: {
                        ticks: 4
                    },
                    tooltip: false
                }
        );

        var doughnutData = [
            {
                value: 300,
                color: "#a3e1d4",
                highlight: "#1ab394",
                label: "App"
            },
            {
                value: 50,
                color: "#dedede",
                highlight: "#1ab394",
                label: "Software"
            },
            {
                value: 100,
                color: "#A4CEE8",
                highlight: "#1ab394",
                label: "Laptop"
            }
        ];

        var doughnutOptions = {
            segmentShowStroke: true,
            segmentStrokeColor: "#fff",
            segmentStrokeWidth: 2,
            percentageInnerCutout: 45, // This is 0 for Pie charts
            animationSteps: 100,
            animationEasing: "easeOutBounce",
            animateRotate: true,
            animateScale: false
        };

        var ctx = document.getElementById("doughnutChart").getContext("2d");
        var DoughnutChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);

        var polarData = [
            {
                value: 300,
                color: "#a3e1d4",
                highlight: "#1ab394",
                label: "App"
            },
            {
                value: 140,
                color: "#dedede",
                highlight: "#1ab394",
                label: "Software"
            },
            {
                value: 200,
                color: "#A4CEE8",
                highlight: "#1ab394",
                label: "Laptop"
            }
        ];

        var polarOptions = {
            scaleShowLabelBackdrop: true,
            scaleBackdropColor: "rgba(255,255,255,0.75)",
            scaleBeginAtZero: true,
            scaleBackdropPaddingY: 1,
            scaleBackdropPaddingX: 1,
            scaleShowLine: true,
            segmentShowStroke: true,
            segmentStrokeColor: "#fff",
            segmentStrokeWidth: 2,
            animationSteps: 100,
            animationEasing: "easeOutBounce",
            animateRotate: true,
            animateScale: false
        };
        var ctx = document.getElementById("polarChart").getContext("2d");
        var Polarchart = new Chart(ctx).PolarArea(polarData, polarOptions);

    });
</script>--%>
<%--<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','../../www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-4625583-2', 'webapplayers.com');
    ga('send', 'pageview');

</script>--%>
</body>
</html>

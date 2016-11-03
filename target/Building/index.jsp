<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Building | Login</title>
<spring:url value="/resources/css/bootstrap.min.css" var="bootsTrapCss"/>
<spring:url value="/resources/font-awesome/css/font-awesome.css" var="awesomeFontCss" />
<spring:url value="/resources/css/animate.css" var="animateCss" />
<spring:url value="/resources/css/style.css" var="styleCss" />

<link href="${bootsTrapCss}" rel="stylesheet" />
<link href="${awesomeFontCss}" rel="stylesheet" />
<link href="${animateCss}" rel="stylesheet" />
<link href="${styleCss}" rel="stylesheet" />

<body class="gray-bg">
<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">B</h1>
        </div>
        <h3>Welcome to Manager Building </h3>

        <p>Đăng Nhập</p>
        <form class="m-t" role="form" action="http://webapplayers.com/inspinia_admin-v2.5/index.html">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Username" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Đăng Nhập</button>

            <a href="#"><small>Quên Mật Khẩu?</small></a>
            <%--<p class="text-muted text-center"><small>Do not have an account?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>--%>
        </form>
        <p class="m-t"> <small>chuchuot12a15tnp@gmail.com</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<spring:url value="/resources/js/jquery-2.1.1.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>

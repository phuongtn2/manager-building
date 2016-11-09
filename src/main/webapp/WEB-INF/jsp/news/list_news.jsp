<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row animated fadeInRight">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Thong tin noi bo</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <c:forEach items="${newsDtoList}" var="news">
                <div class="ibox-content inspinia-timeline">
                    <div class="timeline-item">
                        <div class="row">
                            <div class="col-xs-4 date">
                                <i class="fa fa-users"></i>
                                ${news.created}
                                <br/>
                                <small class="text-navy">2 hour ago</small>
                            </div>
                            <div class="col-xs-8 content no-top-border">
                                <p class="m-b-xs"><strong>${news.newsId}</strong></p>
                                <p>${news.memo}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
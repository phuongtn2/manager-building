<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="ibox-content inspinia-timeline" onclick="edit(${news.newsId})">
                    <div class="timeline-item">
                        <div class="row">
                            <div class="col-xs-3 date">
                                <i class="fa fa-users"></i>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${news.created}" />
                                <br/>
                                <small class="text-navy">2 hour ago</small>
                            </div>
                            <div class="col-xs-9 content no-top-border">
                                <div class="row">
                                    <div class="col-lg-9">
                                        <p class="m-b-xs"><strong>${news.title}</strong></p>
                                        <p>${news.memo}</p>
                                    </div>
                                    <div class="col-lg-3">
                                        <a class="btn btn-success btn-rounded" href="/news/edit/${news.newsId}" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</a>

                                        <a class="btn btn-danger btn-rounded" href="/news/delete/${news.newsId}">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
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
                <div>
                    <h5>${newsDto.newType}</h5>
                    <h5>${newsDto.newHeader}</h5>
                    <h5>${newsDto.newShorter}</h5>
                </div>
            </div>
            <div class="ibox-content" var="news>
                <input type="text" class="form-control input-sm m-b-xs" id="filter"
                       placeholder="Search in table">
                <c:forEach items="${newsDetailDtoList}" var="news_detail">
                    <div class="ibox-content inspinia-timeline" onclick="edit(${newsDto.newCode})">
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-users"></i>
                                    <fmt:formatDate pattern="yyyy-MM-dd" value="${newsDto.created}" />
                                    <br/>
                                    <small class="text-navy">$ {newsDto.created}</small>
                                </div>
                                <div class="col-xs-9 content no-top-border">
                                    <div class="row">
                                        <div class="col-lg-9">
                                            <p class="m-b-xs" style="word-break: break-all"><strong>${news_detail.refNewCode}</strong></p>
                                            <p style="word-break: break-all">${news_detail.newContent}</p>
                                        </div>
                                        <div class="col-lg-3">
                                            <div class="btn-group">
                                                <a class="btn btn-success btn btn-xs" href="/news" >&nbsp;&nbsp;Back&nbsp;&nbsp;</a>
                                                <a class="btn btn-success btn btn-xs" href="/newsdetail/edit/${news_detail.newContent}" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</a>
                                                <a class="btn btn-danger btn btn-xs" href="/newsdetail/delete/${news_detail.newContent}">&nbsp;&nbsp;Delete&nbsp;&nbsp;</a>
                                            </div>
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
</div>

<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Danh Sách Tài Sản Chung</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>

            <div class="ibox-content forum-container">
                <c:forEach items="${assetDtoList}" var="asset">
                    <div class="forum-item active">
                        <div class="row">
                            <div class="col-md-9">
                                <div class="forum-icon">
                                    <i class="fa fa-unlink"></i>
                                </div>
                                <a href="/asset/view/${asset.assetId}" class="forum-item-title">${asset.assetName}</a>
                                <%--<div class="forum-sub-title">Talk about sports, entertainment, music, movies, your favorite color, talk about enything.</div>--%>
                            </div>
                            <div class="col-md-1 forum-info">
                                        <span class="views-number">
                                            10
                                        </span>
                                <div>
                                    <small>Comment/Reply</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

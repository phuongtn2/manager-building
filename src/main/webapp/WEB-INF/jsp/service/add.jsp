<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Quản Lý Tòa Nhà</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form:form class="form-horizontal" modelAttribute="newsDto" method="post">
                    <p>Thông Tin Tòa Nhà</p>
                    <div class="form-group"><label class="col-lg-2 control-label">Title</label>
                        <input name="newsId" type="hidden" placeholder="Title" class="form-control" value="<c:if test="${newsDto.newsId!= null}">${newsDto.newsId}</c:if>">
                        <div class="col-lg-8"><input name="title" type="text" placeholder="Title" class="form-control" required=true value="<c:if test="${newsDto.title!= null}">${newsDto.title}</c:if>">
                        </div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Thông Tin Chi Tiết</label>
                        <div class="col-lg-8"><textarea  name="memo" placeholder="Tin Tức" class="form-control" rows="4" required=true ><c:if test="${newsDto.memo!= null}">${newsDto.memo}</c:if></textarea></div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button name="add" class="btn btn-primary " type="submit"><i class="fa fa-check"></i>&nbsp;Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
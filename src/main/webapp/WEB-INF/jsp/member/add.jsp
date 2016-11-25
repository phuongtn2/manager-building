<%--
  Created by IntelliJ IDEA.
  User: Giang.DaoTu
  Date: 11/11/2016
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Thông Tin Thành viên</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content m-b-sm border-bottom">
            <form:form  modelAttribute="MemberDto" method="post">

                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="fullName">Họ Tên</label>
                                <input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">
                                <input type="text" id="fullName" name="fullName" value="<c:if test="${memberDto.fullName!= null}">${memberDto.fullName}</c:if>" placeholder="Họ Tên" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="tel">Điện thoại</label>
                                <input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="address">Địa chỉ</label>
                                <input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="sex">Giới tính</label>
                                <div class="form-group">
                                    <input id ="sexM" type="radio" name="sex" value="1" <c:if test="${memberDto.sex == 1}">checked="checked"</c:if>> &nbsp;Nam&nbsp;
                                    <input id ="sexF" type="radio" name="sex" value="2" <c:if test="${memberDto.sex == 2}">checked="checked"</c:if>> &nbsp;Nữ&nbsp;
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="birthday">Ngày sinh</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="birthday" name="birthday" type="text" class="form-control" value="<c:if test="${memberDto.birthday!= null}">${memberDto.birthday}</c:if>">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="idCard">Chứng minh nhân dân</label>
                                <input type="text" id="idCard" name="idCard" value="<c:if test="${memberDto.idCard!= 0}">${memberDto.idCard}</c:if>" placeholder="Chứng minh nhân dân" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="idCard">Email</label>
                                <input type="text" id="email" name="email" value="<c:if test="${memberDto.email!= null}">${memberDto.email}</c:if>" placeholder="Email" class="form-control">
                            </div>
                        </div>
                    </div>
                <div class="row">
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button name="add" class="btn btn-primary" type="submit"><i class="fa fa-check"></i>&nbsp;Submit</button>
                            <input name="reset" class="btn btn-primary" type="reset">
                        </div>
                    </div>
                </div>
            </form:form>
            </div>
        </div>
    </div>
</div>






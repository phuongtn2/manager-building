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
            <form:form  modelAttribute="userDto" method="post">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="fullName">Họ Tên</label>
                            <input name="userId" type="hidden" class="form-control" value="<c:if test="${userDto.userId!= null}">${userDto.userId}</c:if>">
                            <input type="text" id="fullName" name="fullName" value="<c:if test="${userDto.fullName!= null}">${userDto.fullName}</c:if>" placeholder="Họ Tên" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="birthday">Ngày sinh</label>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="birthday" name="birthday" placeholder="Ngày sinh" class="form-control" value="<c:if test="${userDto.birthday!= null}"><fmt:formatDate pattern="MM-dd-yyyy" value="${userDto.birthday}" /></c:if>">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="idCard">idCard</label>
                            <input type="text" id="idCard" name="idCard" value="<c:if test="${userDto.idCard!= 0}">${userDto.idCard}</c:if>" placeholder="Chứng minh thư" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label class="control-label" for="gender">Giới tính</label>
                                    <div>
                                        <input id ="gender" type="radio" name="gender" value="1" <c:if test="${userDto.gender == 1}">checked="checked"</c:if> >&nbsp;&nbsp;Nam&nbsp;&nbsp;&nbsp;
                                        <input id ="gender" type="radio" name="gender" value="2" <c:if test="${userDto.gender == 2}">checked="checked"</c:if> >&nbsp;&nbsp;Nữ&nbsp;&nbsp;&nbsp;
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label class="control-label" for="tel">Điện thoại</label>
                                    <input type="text" id="tel" name="tel" value="<c:if test="${userDto.tel!= null}">${userDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label class="control-label" for="address">Địa chỉ</label>
                            <input type="text" id="adress" name="address" value="<c:if test="${userDto.address!= null}">${userDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" name="userStatus">Trạng thái</label>
                            <select name="userStatus" class="form-control m-b">
                                <option <c:if test="${userDto.userStatus==1}" >selected</c:if> value="1">Active</option>
                                <option <c:if test="${userDto.userStatus==2}" >selected</c:if> value="2">Deactive</option>
                                <option <c:if test="${userDto.userStatus==3}" >selected</c:if> value="3">Pending</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="adId">adId</label>
                            <input type="text" id="adId" name="adId" value="<c:if test="${userDto.adId!= null}">${userDto.adId}</c:if>" placeholder="adId" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="mail">Mail</label>
                            <input type="text" id="mail" name="mail" value="<c:if test="${userDto.mail!= null}">${userDto.mail}</c:if>" placeholder="Mail" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="startDay">Bắt đầu</label>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="startDay" name="startDay" type="text" class="form-control" value="<c:if test="${userDto.startDay!= null}"><fmt:formatDate pattern="MM-dd-yyyy" value="${userDto.startDay}" /></c:if>">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="endDay">Kết thúc</label>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="endDay" name="endDay" type="text" class="form-control" var="endDay" value="<c:if test="${userDto.endDay!= null}"><fmt:formatDate pattern="MM-dd-yyyy" value="${userDto.endDay}" /></c:if>">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="form-group">
                            <label class="control-label" for="">Role</label>
                            <select class="form-control m-b">
                                <option value="1">Admin</option>
                                <option value="2">Member</option>
                            </select>

                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="form-group">
                            <label class="control-label" for="">Room</label>
                            <select  class="form-control m-b" >
                                <option value="1">Room 1</option>
                                <option value="2">Room 2</option>
                                <option value="3">Room 3</option>
                                <option value="4">Room 4</option>
                            </select>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label class="control-label" for="memo">Ghi chú</label>
                            <textarea type="text" rows="4" id="memo" name="memo" value="" placeholder="Ghi chú" class="form-control"></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <div class="text-center">
                            <button name="add" class="btn btn-primary" type="submit"><i class="fa fa-check"></i>&nbsp;Submit</button>
                            <input name="reset" class="btn btn-danger" placeholder="Nhập lại" type="reset">
                        </div>
                    </div>
                </div>
            </form:form>
            </div>
        </div>
    </div>
</div>






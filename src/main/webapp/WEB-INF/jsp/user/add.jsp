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
            <form:form  modelAttribute="UserDto" method="post">

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="fullName">Họ Tên</label>
                                <%--<input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">--%>
                                <%--<input type="text" id="fullName" name="fullName" value="<c:if test="${memberDto.fullName!= null}">${memberDto.fullName}</c:if>" placeholder="Họ Tên" class="form-control">--%>
                                    <input type="text" id="fullName" name="fullName" value="" placeholder="Họ Tên" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="tel">Điện thoại</label>
                                <%--<input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">--%>
                                <input type="text" id="tel" name="tel" value="" placeholder="Điện thoại" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="address">Địa chỉ</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                                <input type="text" id="adress" name="adress" value="" placeholder="Địa chỉ" class="form-control">
                            </div>
                        </div>
                    </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="fullName">Giới tính</label>
                                <%--<input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">--%>
                                <%--<input type="text" id="fullName" name="fullName" value="<c:if test="${memberDto.fullName!= null}">${memberDto.fullName}</c:if>" placeholder="Họ Tên" class="form-control">--%>
                            <div>
                                <input id ="sex" type="radio" name="sex" value="1" > &nbsp;&nbsp;&nbsp;&nbsp;Nam&nbsp;&nbsp;&nbsp;&nbsp;
                                <input id ="sex" type="radio" name="sex" value="2" > &nbsp;&nbsp;&nbsp;&nbsp;Nữ&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="birthday">Ngày sinh</label>
                                <%--<input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">--%>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="birthday" name="birthday" type="text" class="form-control" value="03/06/2014">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="address">idCard</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                            <input type="text" id="adress" name="adress" value="" placeholder="Địa chỉ" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="fullName">Trạng thái</label>
                                <%--<input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">--%>
                                <%--<input type="text" id="fullName" name="fullName" value="<c:if test="${memberDto.fullName!= null}">${memberDto.fullName}</c:if>" placeholder="Họ Tên" class="form-control">--%>
                            <input type="text" id="fullName" name="fullName" value="" placeholder="Trạng thái" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="tel">adId</label>
                                <%--<input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">--%>
                            <input type="text" id="tel" name="tel" value="" placeholder="adId" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="control-label" for="address">Mail</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                            <input type="text" id="adress" name="adress" value="" placeholder="Mail" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label" for="startDay">Bắt đầu</label>
                                <%--<input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">--%>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="startDay" name="startDay" type="text" class="form-control" value="03/06/2014">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label" for="endDay">Kết thúc</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="endDay" name="endDay" type="text" class="form-control" value="03/06/2014">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label" for="address">Role</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                            <select class="form-control m-b" name="account">
                                <option>Admin</option>
                                <option>Member</option>
                            </select>

                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label class="control-label" for="address">Building</label>
                                <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                            <select class="form-control m-b" name="account">
                                <option>Building 1</option>
                                <option>Building 2</option>
                                <option>Building 3</option>
                                <option>Building 4</option>
                            </select>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label class="control-label" for="fullName">Ghi chú</label>
                            <textarea type="text" rows="4" id="memo" name="memo" value="" placeholder="Ghi chú" class="form-control"></textarea>
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






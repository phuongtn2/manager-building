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
                <h5>Quản Lý Tòa Nhà</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form:form class="form-horizontal" modelAttribute="MemberDto" method="post">
                    <p>Thông Tin Thành viên</p>
                    <div class="form-group"><label class="col-lg-2 control-label">Họ và tên</label>
                        <input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">
                        <div class="col-lg-8"><input name="fullName"  placeholder="Họ Tên" class="form-control" required=true value="<c:if test="${memberDto.fullName!= null}">${memberDto.fullName}</c:if>"></div>
                        <%--<div class="col-lg-8"><input name="fullName" placeholder="Họ Tên" class="form-control" required=true value="12" ></div>--%>
                    </div>
                    <%--<div class="form-group"><label class="col-lg-2 control-label">Họ Tên</label>--%>
                         <%--<input name="memberId" type="hidden" placeholder="Họ Tên" class="form-control" value="<c:if test="${memberDto.memberId!= null}">${memberDto.memberId}</c:if>">--%>
                            <%--&lt;%&ndash;<div class="col-lg-8"><textarea  name="tel" placeholder="Điện thoại" class="form-control" required=true ><c:if test="${memberDto.tel!= null}">${memberDto.tel}</c:if></textarea></div>&ndash;%&gt;--%>
                        <%--<div class="col-lg-8"><input name="fullName" placeholder="Họ Tên" class="form-control" required=true ></div>--%>
                    <%--</div>--%>
                    <div class="form-group"><label class="col-lg-2 control-label">Điện thoại</label>
                        <%--<div class="col-lg-8"><textarea row="1" name="tel" placeholder="Điện thoại" class="form-control" required=true ><c:if test="${memberDto.tel!= null}">${memberDto.tel}</c:if></textarea></div>--%>
                        <div class="col-lg-8"><input name="tel" placeholder="Điện thoại" class="form-control" required=true value="<c:if test="${memberDto.memberId!= null}">${memberDto.tel}</c:if>" ></div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Địa chỉ</label>
                        <div class="col-lg-8"><input name="address" placeholder="Địa chỉ" class="form-control" required=true value="<c:if test="${memberDto.memberId!= null}">${memberDto.address}</c:if>"></div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Giới tính</label>
                        <%--<div class="col-lg-8"><textarea  name="sex" placeholder="Giới tính" class="form-control" required=true ><c:if test="${memberDto.sex!= null}">${memberDto.sex}</c:if></textarea></div>--%>
                        <div class="col-lg-8">
                            <%--<input  name="sex" placeholder="Giới tính" class="form-control" required=true >--%>
                            <%--<select>--%>
                                <%--<option name="sex" value="1">Nam</option>--%>
                                <%--<option name="sex" value="2">Nữ</option>--%>
                            <%--</select>--%>
                            <input type="radio" name="sex" value="1">&nbsp;Nam&nbsp;
                            <input type="radio" name="sex" value="2">&nbsp;Nữ&nbsp;
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Ngày Sinh</label>
                        <div class="col-lg-8"><input name="birthday" placeholder="Ngày Sinh" class="form-control" required=true type="date" value=" <c:if test="${memberDto.memberId!= null}">${memberDto.birthday}</c:if>"></div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-8"><input name="email" placeholder="Email" class="form-control" type="email" required=true value ="<c:if test="${memberDto.memberId!= null}">${memberDto.email}</c:if> "> </div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Chứng minh nhân dân</label>
                        <%--<div class="col-lg-8"><textarea  name="idCard" placeholder="Chứng minh nhân dân" class="form-control" required=true ><c:if test="${memberDto.idCard!= null}">${memberDto.idCard}</c:if></textarea></div>--%>
                        <div class="col-lg-8"><input name="idCard" placeholder="Chứng minh nhân dân" class="form-control" required=true value="<c:if test="${memberDto.memberId!= null}">${memberDto.idCard}</c:if>"></div>
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


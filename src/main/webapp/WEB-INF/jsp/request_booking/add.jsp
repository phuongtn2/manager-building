<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Quản lý dịch vụ</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form:form modelAttribute="bookServiceDto" method="post">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label">Tên dịch vụ</label>
                                <input type="hidden" id="t_bookServiceCode" name="t_bookServiceCode" value="<c:if test="${bookServiceDto.t_bookServiceCode!= null}">${bookServiceDto.t_bookServiceCode}</c:if>"  class="form-control">
                                <select name="serviceCode" class="form-control m-b">
                                    <option <c:if test="${bookServiceDto.serviceCode==1}" >selected</c:if> value="1">serviceCode 1</option>
                                    <option <c:if test="${bookServiceDto.serviceCode==2}" >selected</c:if> value="2">serviceCode 2</option>
                                    <option <c:if test="${bookServiceDto.serviceCode==3}" >selected</c:if> value="3">serviceCode 3</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label">assetCode</label>
                                <select name="assetCode" class="form-control m-b">
                                    <option <c:if test="${bookServiceDto.assetCode==1}" >selected</c:if> value="1">assetCode 1</option>
                                    <option <c:if test="${bookServiceDto.assetCode==2}" >selected</c:if> value="2">assetCode 2</option>
                                    <option <c:if test="${bookServiceDto.assetCode==3}" >selected</c:if> value="3">assetCode 3</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="control-label" for="servicePrice">Giá dịch vụ</label>
                                <input  type="text" id="servicePrice" name="servicePrice" value="<c:if test="${bookServiceDto.servicePrice!= null}">${bookServiceDto.servicePrice}</c:if>" placeholder="Giá dịch vụ" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="control-label">Trạng thái dịch vụ</label>
                                <select name="status" class="form-control m-b">
                                    <option <c:if test="${bookServiceDto.status==1}" >selected</c:if> value="1">status 1</option>
                                    <option <c:if test="${bookServiceDto.status==2}" >selected</c:if> value="2">status 2</option>
                                    <option <c:if test="${bookServiceDto.status==3}" >selected</c:if> value="3">status 3</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="control-label" for="bookFrom">Bắt đầu</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="bookFrom" name="bookFrom" type="text" class="form-control" value="<c:if test="${bookServiceDto.bookFrom!= null}"><fmt:formatDate pattern="MM/dd/yyyy" value="${bookServiceDto.bookFrom}" /></c:if>">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="control-label" for="bookTo">Kết thúc</label>
                                <div class="input-group ">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="bookTo" name="bookTo" type="text" class="form-control"  value="<c:if test="${bookServiceDto.bookTo!= null}"><fmt:formatDate pattern="MM/dd/yyyy" value="${bookServiceDto.bookTo}" /></c:if>">
                                </div>
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
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <form:form modelAttribute="buildingDto" method="post">
                    <p>Thông Tin Tòa Nhà</p>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="fullName">Tên tòa nhà</label>
                                <input type="text" id="buildingName" name="buildingName" value="<c:if test="${userDto.buildingName!= null}">${userDto.buildingName}</c:if>" placeholder="Tên tòa nhà" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="tel">Tổng số tầng</label>
                                    <%--<input type="text" id="tel" name="tel" value="<c:if test="${memberDto.tel!= 0}">${memberDto.tel}</c:if>" placeholder="Điện thoại" class="form-control">--%>
                                <input type="text" id="totalFloor" name="totalFloor" value="<c:if test="${userDto.totalFloor!= 0}">${userDto.totalFloor}</c:if>" placeholder="Tổng số tầng" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="address">Tổng số phòng</label>
                                    <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                                <input type="text" id="totalRoom" name="totalRoom" value="<c:if test="${userDto.address!= 0}">${userDto.address}</c:if>" placeholder="Tổng số phòng" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="control-label" for="description">Mô tả</label>
                                <textarea type="text" rows="4" id="description" name="description" value="<c:if test="${userDto.description!= null}">${userDto.description}</c:if>" placeholder="Mô tả" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="text-center">
                            <button name="add" class="btn btn-primary " type="submit"><i class="fa fa-check"></i>&nbsp;Xác nhận</button>
                            <button name="reset" class="btn btn-danger " type="button"><i class="fa fa-refresh"></i>&nbsp;Nhập lại</button>
                            <br>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
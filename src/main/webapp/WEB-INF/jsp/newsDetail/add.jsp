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
                <form:form modelAttribute="newsDetailDto" method="post">
                    <p>Tin tức</p>
                    <div class="row">
                        <div class="form-group">
                            <%--<input name="newCode" type="hidden" placeholder="Tiêu đề" class="form-control" value="">--%>
                            <div class="col-sm-4">
                                <label class="control-label">Tiêu đề</label>
                                <input name="newHeader" type="text" placeholder="Tiêu đề" class="form-control" value="">
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">NewsShorter</label>
                                <input name="newsShorter" type="text" placeholder="NewsShorter" class="form-control" value="">
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">refNewCode</label>
                                <input name="newCode" type="hidden" placeholder="newCode" class="form-control" value="2" >
                                <input name="refNewCode" type="text" placeholder="refNewCode" class="form-control" value="<c:if test="${newsDetailDto.refNewCode!= null}">${newsDetailDto.refNewCode}</c:if>">
                            </div>
                            <div class="col-sm-2">
                                <label class="control-label" for="newType">newsType</label>
                                    <%--<input type="text" id="address" name="address" value="<c:if test="${memberDto.address!= null}">${memberDto.address}</c:if>" placeholder="Địa chỉ" class="form-control">--%>
                                <select class="form-control m-b" name="newType" >
                                    <option value="1">newsType 1 </option>
                                    <option value="2">newsType 2</option>
                                    <option value="3">newsType 3</option>
                                    <option value="4">newsType 4</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <label class=" control-label">Nội dung</label>
                                <textarea  name="newContent" placeholder="Nội dung" class="form-control" rows="4" required=true ><c:if test="${newsDetailDto.newContent!= null}">${newsDetailDto.newContent}</c:if></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="text-center">
                            <br>
                            <button name="add" class="btn btn-primary" type="submit"><i class="fa fa-check"></i>&nbsp;Submit</button>
                            <input name="reset" class="btn btn-danger" placeholder="Nhập lại" type="reset" ></input>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
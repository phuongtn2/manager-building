<%--
  Created by IntelliJ IDEA.
  User: Giang.DaoTu
  Date: 11/11/2016
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Danh sách người dùng</h5>

                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <input type="text" class="form-control input-sm m-b-xs" id="filter"
                       placeholder="Search in table">

                <table class="footable emp-sales table table-stripped table-bordered table-hover dataTables-example" data-page-size="8" data-filter=#filter>
                    <thead>
                    <tr>
                        <th>Building</th>
                        <th data-hide="phone,tablet">Floor</th>
                        <th data-hide="phone,tablet">Room</th>
                        <th data-hide="phone,tablet">Bắt đầu</th>
                        <th data-hide="phone,tablet">Kết thúc</th>
                        <th data-hide="phone,tablet" class="text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userRomDtoDetailsList}" var="userRomDtoDetails">
                        <tr class="gradeC" >
                            <td>${userRomDtoDetails.buildingCode}</td>
                            <td data-hide="phone,tablet">${userRomDtoDetails.floorCode}</td>
                            <td data-hide="phone,tablet">${userRomDtoDetails.roomCode}</td>
                            <td data-hide="phone,tablet"><fmt:formatDate pattern="MM/dd/yyyy" value="12/10/2016"/></td>
                            <td data-hide="phone,tablet"><fmt:formatDate pattern="MM/dd/yyyy" value="12/10/2016"/></td>
                            <td class="text-center">
                                <div class="btn-group">
                                    <a class="btn-success btn btn-xs" href="/user/edit/${userRomDtoDetails.userId}">Edit</a>
                                    <a type="button" data-toggle="modal" data-target="#deleteButton" class="btn-danger btn btn-xs" onclick="setUrl('/user/delete/${userRomDtoDetails.userId}')">Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="13">
                            <ul class="pagination pull-right"></ul>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>

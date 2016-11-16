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
                        <th>Họ Tên</th>
                        <th data-hide="phone,tablet">adId</th>
                        <th data-hide="phone,tablet">Giới tính</th>
                        <th data-hide="phone,tablet">birthday</th>
                        <th data-hide="phone,tablet">idCard</th>
                        <th data-hide="phone,tablet">Mail</th>
                        <th data-hide="phone,tablet">Điện Thoại</th>
                        <th data-hide="phone,tablet">Địa chỉ</th>
                        <th data-hide="phone,tablet">Trạng thái</th>
                        <th data-hide="phone,tablet">startDay</th>
                        <th data-hide="phone,tablet">endDay</th>
                        <th data-hide="phone,tablet">memo</th>
                        <th  data-hide="phone,tablet" class="text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userDtoList}" var="user">
                        <tr class="gradeC" >
                            <td>${user.fullName}</td>
                            <td data-hide="phone,tablet">${user.adId}</td>
                            <td data-hide="phone,tablet">${user.gender}</td>
                            <td fmt:formatDate pattern="yyyy-MM-dd" data-hide="phone,tablet">${user.birthday}</td>
                            <td data-hide="phone,tablet">${user.idCard}</td>
                            <td data-hide="phone,tablet">${user.mail}</td>
                            <td data-hide="phone,tablet">${user.tel}</td>
                            <td data-hide="phone,tablet">${user.address}</td>
                            <td data-hide="phone,tablet">
                                <c:if test="${user.userStatus}==1" > <span class="label label-success">Active</span></td> </c:if>
                                <c:if test="${user.userStatus}==2" > <span class="label label-danger">Deactive</span></td> </c:if>
                                <c:if test="${user.userStatus}==3" > <span class="label label-primary">Pending</span></td> </c:if>
                            </td>
                            <td fmt:formatDate pattern="yyyy-MM-dd" data-hide="phone,tablet">${user.startDay}</td>
                            <td fmt:formatDate pattern="yyyy-MM-dd" data-hide="phone,tablet">${user.endDay}</td>
                            <td data-hide="phone,tablet">${user.memo}</td>
                            <td class="text-center">
                                <div class="btn-group">
                                    <a class="btn-success btn btn-xs">Edit</a>
                                    <a class="btn-danger btn btn-xs">Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr class="gradeC" >
                        <td>Phuong</td>
                        <td data-hide="phone,tablet">PhuongTN</td>
                        <td data-hide="phone,tablet"><span class="label label-success">Active</span></td>
                        <td data-hide="phone,tablet">1@2</td>
                        <td data-hide="phone,tablet">0987253</td>
                        <td data-hide="phone,tablet">03/04/2016</td>
                        <td data-hide="phone,tablet">06/12/2017</td>
                        <td data-hide="phone,tablet">Nam</td>
                        <td data-hide="phone,tablet">02/03/1979</td>
                        <td data-hide="phone,tablet">9849374398</td>
                        <td data-hide="phone,tablet">Gò Dầu</td>
                        <td data-hide="phone,tablet">memo</td>
                        <td class="text-center">
                            <div class="btn-group">
                                <a class="btn-success btn btn-xs">Edit</a>
                                <a class="btn-danger btn btn-xs">Delete</a>
                            </div>
                        </td>
                    </tr>
                    <tr class="gradeC" >
                        <td>adc</td>
                        <td data-hide="phone,tablet">abc_id</td>
                        <td data-hide="phone,tablet"><span class="label label-danger">Deactive</span></td>
                        <td data-hide="phone,tablet">1@2</td>
                        <td data-hide="phone,tablet">0987253</td>
                        <td data-hide="phone,tablet">03/04/2016</td>
                        <td data-hide="phone,tablet">06/12/2017</td>
                        <td data-hide="phone,tablet">Nam</td>
                        <td data-hide="phone,tablet">02/03/1979</td>
                        <td data-hide="phone,tablet">9849374398</td>
                        <td data-hide="phone,tablet">Gò Dầu</td>
                        <td data-hide="phone,tablet">${user.memo}</td>
                        <td class="text-center">
                            <div class="btn-group">
                                <button class="btn-success btn btn-xs">Edit</button>
                                <button class="btn-danger btn btn-xs">Delete</button>
                            </div>
                        </td>
                    </tr>
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


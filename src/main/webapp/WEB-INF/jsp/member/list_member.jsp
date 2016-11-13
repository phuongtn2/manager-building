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
                <h5>Simple FooTable with pagination, sorting and filter</h5>

                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <input type="text" class="form-control input-sm m-b-xs" id="filter"
                       placeholder="Search in table">

                <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                    <thead>
                    <tr>
                        <th>Họ Tên</th>
                        <th>Điện thoại</th>
                        <th data-hide="phone,tablet">Địa chỉ</th>
                        <th data-hide="phone,tablet">Giới tính</th>
                        <th data-hide="phone,tablet">Ngày Sinh</th>
                        <th data-hide="phone,tablet">Email</th>
                        <th data-hide="phone,tablet">Chứng minh nhân dân</th>
                        <th data-hide="phone,tablet">Edit</th>
                        <th data-hide="phone,tablet">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%int count = 0;%>
                    <c:forEach items="${memberDtoList}" var="member">
                        <tr <c:if test = "${count%2 == 0}"><% count ++;%>class="gradeX"</c:if><c:if test = "${count%2 != 0}"><% count ++;%>class="gradeC"</c:if>   >
                            <td>${member.fullName}</td>
                            <td>${member.tel}</td>
                            <td data-hide="phone,tablet">${member.address}</td>
                            <td data-hide="phone,tablet">${member.sex}</td>
                            <td data-hide="phone,tablet"><fmt:formatDate pattern="yyyy-MM-dd" value="${member.birthday}" /></td>
                            <td data-hide="phone,tablet">${member.email}</td>
                            <td data-hide="phone,tablet">${member.idCard}</td>
                            <td data-hide="phone,tablet"><a class="btn btn-success btn-rounded" href="/member/edit/${member.memberId}" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</a></td>
                            <td data-hide="phone,tablet"><a class="btn btn-success btn-rounded" href="/member/delete/${member.memberId}" >&nbsp;&nbsp;Delete&nbsp;&nbsp;</a></td>
                        </tr>
                    </c:forEach>
                    <%--<tr>--%>
                        <%--<td>Họ Tên</td>--%>
                        <%--<td>Điện thoại</td>--%>
                        <%--<td data-hide="phone,tablet">Địa chỉ</td>--%>
                        <%--<td data-hide="phone,tablet">Giới tính</td>--%>
                        <%--<td data-hide="phone,tablet">Ngày Sinh</td>--%>
                        <%--<td data-hide="phone,tablet">Email</td>--%>
                        <%--<td data-hide="phone,tablet">Chứng minh nhân dân</td>--%>
                        <%--<td data-hide="phone,tablet">Edit</td>--%>
                        <%--<td data-hide="phone,tablet">Delete</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td>Họ Tên</td>--%>
                        <%--<td>Điện thoại</td>--%>
                        <%--<td data-hide="phone,tablet">Địa chỉ</td>--%>
                        <%--<td data-hide="phone,tablet">Giới tính</td>--%>
                        <%--<td data-hide="phone,tablet">Ngày Sinh</td>--%>
                        <%--<td data-hide="phone,tablet">Email</td>--%>
                        <%--<td data-hide="phone,tablet">Chứng minh nhân dân</td>--%>
                        <%--<td data-hide="phone,tablet">Edit</td>--%>
                        <%--<td data-hide="phone,tablet">Delete</td>--%>
                    <%--</tr>--%>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="9">
                            <ul class="pagination pull-right"></ul>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>


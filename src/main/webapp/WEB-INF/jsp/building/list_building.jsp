<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Danh sách tòa nhà</h5>
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

                    <div class="table-responsive">
                        <table class="footable emp-sales table table-striped table-bordered table-hover dataTables-example" data-page-size="10">
                            <thead>
                            <tr>
                                <th class="text-center">Tên tòa nhà </th>
                                <th data-hide="phone,tablet" class="text-center">Tổng số tầng</th>
                                <th data-hide="phone,tablet" class="text-center">Tổng số phòng</th>
                                <th data-hide="phone,tablet" class="text-center">Mô tả</th>
                                <th data-hide="phone,tablet" class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <div class="row m-b-sm">
                            <%int count = 0;%>
                            <c:forEach items="${buildingDtoList}" var="building">
                                    <tr <c:if test = "${count%2 == 0}"><% count ++;%>class="gradeX"</c:if><c:if test = "${count%2 != 0}"><% count ++;%>class="gradeC"</c:if>   >
                                        <td class="col-sm-2">${building.buildingName}</td>
                                        <td data-hide="phone,tablet" class="col-sm-2">${building.totalFloor}</td>
                                        <td data-hide="phone,tablet" class="col-sm-2">${building.totalRoom}</td>
                                        <td data-hide="phone,tablet" class="col-sm-4">${building.description}</td>
                                        <td data-hide="phone,tablet" class="col-sm-2 text-center">
                                            <div class="btn-group">
                                                <a class="btn btn-success btn btn-xs" href="/building/edit/${building.buildingCode}" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</a>
                                                <a class="btn btn-danger btn btn-xs" href="/building/delete/${building.buildingCode}">&nbsp;&nbsp;Delete&nbsp;&nbsp;</a>
                                            </div>
                                        </td>
                                    </tr>
                            </c:forEach>
                            </div>
                            </tbody>
                            <%--<tfoot>--%>
                            <%--<tr>--%>
                                <%--<th class="text-center">Tên tòa nhà </th>--%>
                                <%--<th data-hide="phone,tablet" class="text-center">Tổng số tầng</th>--%>
                                <%--<th data-hide="phone,tablet" class="text-center">Tổng số phòng</th>--%>
                                <%--<th data-hide="phone,tablet" class="text-center">Mô tả</th>--%>
                                <%--<th data-hide="phone,tablet" class="text-center">Action</th>--%>
                            <%--</tr>--%>
                            <%--</tfoot>--%>
                        </table>

                </div>
            </div>
        </div>
    </div>
</div>

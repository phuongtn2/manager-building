<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Basic Data Tables example with responsive plugin</h5>
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
                           <table class="emp-sales table table-striped table-bordered table-hover dataTables-example" >
                            <thead>
                            <tr>
                                <th>Tên tòa nhà </th>
                                <th>Mô tả</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%int count = 0;%>
                            <c:forEach items="${buildingDtoList}" var="building">
                                    <tr <c:if test = "${count%2 == 0}"><% count ++;%>class="gradeX"</c:if><c:if test = "${count%2 != 0}"><% count ++;%>class="gradeC"</c:if>   >
                                        <td class="col-lg-4">${building.buildingName}</td>
                                        <td class="col-lg-4">${building.memo}</td>
                                        <td class="col-lg-2"><a class="btn btn-success btn-rounded" href="/building/edit/${building.buildingId}" >&nbsp;&nbsp;Edit&nbsp;&nbsp;</a></td>
                                        <td class="col-lg-2"><a class="btn btn-danger btn-rounded" href="/building/delete/${building.buildingId}">&nbsp;&nbsp;Delete&nbsp;&nbsp;</a></td>
                                    </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Tên tòa nhà </th>
                                <th>Mô tả</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </tfoot>
                        </table>

                </div>
            </div>
        </div>
    </div>
</div>

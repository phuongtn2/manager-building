<%--
  Created by IntelliJ IDEA.
  User: Giang.DaoTu
  Date: 11/11/2016
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>

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
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th data-hide="phone,tablet">Platform(s)</th>
                        <th data-hide="phone,tablet">Engine version</th>
                        <th data-hide="phone,tablet">CSS grade</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%int count = 0;%>
                    <c:forEach items="${buildingDtoList}" var="building">
                        <tr <c:if test = "${count%2 == 0}"><% count ++;%>class="gradeX"</c:if><c:if test = "${count%2 != 0}"><% count ++;%>class="gradeC"</c:if>   >
                            <td>Trident</td>
                            <td>Internet Explorer 4.0
                            </td>
                            <td>Win 95+</td>
                            <td class="center">4</td>
                            <td class="center">X</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="5">
                            <ul class="pagination pull-right"></ul>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>


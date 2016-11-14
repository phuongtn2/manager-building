<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Tài Sản Chung</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form:form class="form-horizontal" modelAttribute="buildingDto" method="post">
                    <p>Thông Tin Tài Sản Chung</p>
                    <div class="form-group"><label class="col-lg-2 control-label">Tên Tài Sản</label>
                        <input name="assetId" type="hidden" class="form-control" value="<c:if test="${assetDto.assetId!= null}">${assetDto.assetId}</c:if>">
                        <div class="col-lg-8"><input name="assetName" type="text" placeholder="Tên Tài Sản" class="form-control" required=true value="<c:if test="${assetDto.assetName!= null}">${assetDto.assetName}</c:if>">
                        </div>
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
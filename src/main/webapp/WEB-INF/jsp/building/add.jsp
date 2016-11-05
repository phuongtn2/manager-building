<%@page language="java" contentType="text/html;charset=UTF-8"%>
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
                <form:form class="form-horizontal" action="/building/add" method="post">
                    <p>Thông Tin Tòa Nhà</p>
                    <div class="form-group"><label class="col-lg-2 control-label">Tên Tòa Nhà</label>
                        <div class="col-lg-8"><input name="buildingName" type="text" placeholder="Tên Tòa Nhà" class="form-control">
                        </div>
                    </div>
                    <div class="form-group"><label class="col-lg-2 control-label">Thông Tin Chi Tiết</label>

                        <div class="col-lg-8"><textarea name="memo" placeholder="Thông Tin Chi Tiết Tòa Nhà" class="form-control" rows="4"></textarea></div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button class="btn btn-sm btn-white" type="submit">Tạo Mới</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
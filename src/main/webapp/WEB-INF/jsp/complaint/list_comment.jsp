<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/resources/img/building.jpg" var="building"/>
<div class="row animated fadeInRight">
    <div class="col-lg-12">
        <!--complaint-->
        <c:forEach items="${tmComplaintList}" var="tmComplaint">
            <div class="social-feed-box">
                <div class="social-avatar">
                    <a href="#" class="pull-left">
                        <img alt="image" src="${building}">
                    </a>
                    <div class="media-body">
                        <a href="#">
                            ${tmComplaint.mComplaint.userName}
                        </a>
                        <small class="text-muted"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${tmComplaint.mComplaint.created}" /></small>
                    </div>
                </div>
                    <div class="social-body">
                    <p>${tmComplaint.mComplaint.title}</p>
                    <div class="btn-group">
                        <form:form modelAttribute="complaintDto" method="post">
                            <input name="followStatus" type="hidden" class="form-control" value="${tmComplaint.mComplaint.followStatus}">
                            <input name="complaintCode" type="hidden" class="form-control" value="${tmComplaint.mComplaint.complaintCode}">
                            <button name="follow" type="submit" id="follow_${tmComplaint.mComplaint.complaintCode}" class="btn btn-white btn-xs" <%--onclick="changeStyle('follow_${tmComplaint.mComplaint.complaintCode}', ${tmComplaint.mComplaint.followStatus}, 'nameButton_${tmComplaint.mComplaint.complaintCode}')"--%>>
                                <i id="nameButton_${tmComplaint.mComplaint.complaintCode}" class="fa fa-thumbs-up"></i> <c:if test="${tmComplaint.mComplaint.followStatus == 0}">Follow</c:if> <c:if test="${tmComplaint.mComplaint.followStatus == 1}">UnFollow</c:if></button>
                            <button class="btn btn-white btn-xs"><i class="fa fa-comments"></i> Comment</button>
                        </form:form>
                    </div>
                </div>
                    <!--comment -->
                <div class="social-footer">
                    <c:if test = "${tmComplaint.tComplaintList.size() > 0}">
                        <c:forEach items="${tmComplaint.tComplaintList}" var="tComplaint">
                            <%--<c:if test="${tComplaint.complaintCode == tmComplaint.complaintCode && tComplaint.tranSeq == 1} ">--%>
                                <div class="social-comment">
                                    <a href="#" class="pull-left">
                                        <img alt="image" src="${building}">
                                    </a>
                                    <div class="media-body">
                                        <a href="#">
                                            ${tComplaint.userName}
                                        </a>
                                            ${tComplaint.message}
                                        <br/>
                                        <a href="#" class="small"><i class="fa"></i> Comment</a>
                                        <!--reply-->
                                        <c:forEach items="${tComplaint.tReplyDtoList}" var="tReply">
                                            <%--<c:if test="${tComplaint.parentComplaintCode == tReply.parentComplaintCode && tComplaint.tranSeq == 2} ">--%>
                                                <div class="social-comment">
                                                    <a href="#" class="pull-left">
                                                        <img alt="image" src="${building}">
                                                    </a>
                                                    <div class="media-body">
                                                        <a href="#">
                                                            ${tReply.userName}
                                                        </a>
                                                        ${tReply.message}
                                                        <br/>
                                                        <a href="#" class="small"><i class="fa"></i> Reply</a>
                                                    </div>
                                                </div>

                                                <div id="reply" class="social-comment">
                                                    <a href="#" class="pull-left">
                                                        <img alt="image" src="${building}">
                                                    </a>
                                                    <div class="media-body">
                                                        <textarea class="form-control" placeholder="Write reply..."></textarea>
                                                    </div>
                                                </div>
                                            <%--</c:if>--%>
                                        </c:forEach>
                                    </div>
                                </div>
                            <%--</c:if>--%>
                        </c:forEach>
                    </c:if>
                    <div id="comment" class="social-comment">
                        <a href="#" class="pull-left">
                            <img alt="image" src="${building}">
                        </a>
                        <div class="media-body">
                            <textarea class="form-control" placeholder="Write comment..."></textarea>
                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%--
<script>
    function changeStyle(id, status, name){
        if(status === 1){
            $( '#'+ id ).css( "color", "blue" );
            $( '#'+ name).text('Follow');
        }else{
            $( '#'+ name).text( 'UnFollow');
        }

    }
</script>--%>

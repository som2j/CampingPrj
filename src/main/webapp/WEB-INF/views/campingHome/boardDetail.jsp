<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!-- head 설정 -->
<body class="campingHome">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <%@ include file="/WEB-INF/views/include/header.jsp" %>

            <!-- Content -->
            <section>
                <header class="main">
                    <h1>캠핑의 집</h1>
                </header>



                    <div class="row">
                        <div class="col-6 col-12-large">
                            <img src="/resources/images/campingHome01.png" width="400px" height="300px" alt="캠핑의집" >
                        </div>
                        <div class="col-6 col-12-large" border="1px solid black">

                            <div>
                                <p>해시태그 작성란입니다.
                                    #캠핑 #차박 #캠핑장비
                                </p>
                            </div>

                            <div> 캠핑의집 디테일 페이지 게시글 작성 테스트 중입니다
                                111111111111111111111111111111111111111111
                                22222222222222222222222222222222222
                                3333333333333333333333333333333333
                                44444444444444444444444444444444444
                            </div>
                        </div>

                        <div>
                            <h3>댓글</h3>
                            <ul>
                                <li><a href="/campingHome/userPage">userId 1</a></li>
                                <li>댓글 1 댓글을 작성해 주세요</li>
                                <br>
                                <li><a href="/campingHome/userPage">userId 2</a></li>
                                <li>댓글 2 댓글을 작성해 주세요</li>
                                <br>
                                <li><a href="/campingHome/userPage">userId 3</a></li>
                                <li>댓글 3 댓글을 작성해 주세요</li>
                                <br>
                                <li><a href="/campingHome/userPage">userId 4</a></li>
                                <li>댓글 4 댓글을 작성해 주세요</li>
                                <br>
                            </ul>

                        </div>


                    </div>




            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/include/sidebar.jsp" %>

</div>

<!-- Scripts -->
<%@ include file="/WEB-INF/views/include/commonScripts.jsp" %>

</body>
</html>

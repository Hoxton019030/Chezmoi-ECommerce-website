<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>忘記密碼</title>

                <link href="${contextRoot}/css/register.css" rel="stylesheet">
            </head>

            <body>
                <div id="login-box" class="bg-secondary">
                    <form:form action="${contextRoot}/member/editPassword" method="get" modelAttribute="editPassword">

                        <h1 class="text-dark">忘記密碼</h1>
                        <form method="post" action="login.js">
                            <p>請輸入email及手機號碼，以重置密碼。</p>
                            <div>
                                <input type="email" class="text-field-Register" name="email" id="email"
                                    placeholder="電子郵件" inputmode="email" autocorrect="off"
                                    pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="required"
                                    oninput="setCustomValidity('');"
                                    oninvalid="setCustomValidity('請輸入正確的email 例：abc@gmail.com')">
                            </div>

                            <div>
                                <input type="tel" class="text-field-Register" name="phone" id="phone" placeholder="手機號碼"
                                    inputmode="tel" autocorrect="off" required="required" maxlength="10"
                                    pattern="09\d{2}\d{6}" oninput="setCustomValidity('');"
                                    oninvalid="setCustomValidity('請輸入正確的手機號碼格式：09xxxxxxxx');">
                            </div>

                            <div>
                                <input type="submit" class="btn-primary text-dark" id="btn-login" value="提交">
                                <!-- onclick="myFunction()">提交</a> -->
                                <!--                  <script> -->
                                <!-- //                     function myFunction() { -->

                                <!-- //                         alert("已向您發送一封電子郵件，點擊其中的鏈接以便更新您的密碼。"); -->
                                <!-- //                         location.href = "login.html" -->
                                <!-- //                     } -->
                                <!--                  </script> -->
                            </div>
                            <p class="text-center">
                                <a href="${contextRoot}/member/login" id="customer_register_link"
                                    class="text-primary">取消</a>
                            </p>

                        </form>
                    </form:form>
                </div>
            </body>

            </html>
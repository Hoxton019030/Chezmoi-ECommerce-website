<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Login</title>
                <!-- <link href="${contextRoot}/css/register.css" rel="stylesheet"> -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                crossorigin="anonymous">
                <link href="${pageContext.request.contextPath}/datePick/css/charliecss.css" rel="stylesheet">
                <!-- onclick="location.href='要前往的網頁連結'" -->
            </head>

            <body>
                <div id="login-box" class=" container">


                    <div class="container" id="login-inside">
                        <h1 class="text-dark">Login</h1>
                        <form:form action="loginsubmit" method="post" modelAttribute="loginsubmit">
                            <h5 class="Msg">${param.Msg}</h5>
                            <form method="post" action="login.js">
                                <div class="row">
                                    <div class="col">
                                        <div>
                                            <input type="text" name="email" class="text-field" placeholder="e-mail" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-bottom: 0.5rem;">
                                    <div class="col">
                                        <div>
                                            <input type="password" name="password" class="text-field"
                                                placeholder="password" />
                                        </div>
                                    </div>
                                </div>

                                <div class="row my-0">
                                    <div class="col d-flex" style="justify-content:start;">
                                        
                                            <a href="${contextRoot}/member/forgotpassword" id="forget-pwd"
                                                class="text-primary">忘記密碼？</a>
                                        
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col d-flex" style="justify-content:center ;">
                                        
                                            <input type="submit" id="btn-login" class="btn-primary text-dark"
                                                value="登入">
                                        
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col" style="text-align:center ;">
                                            <a href="${contextRoot}/member/register" id="customer_register_link"
                                                class="text-primary">註冊帳號</a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col" style="text-align:center ;">
                                        <p>
                                            <a href="${contextRoot}/" class="text-primary">返回首頁</a>
                                        </p>

                                    </div>
                                </div>


                            </form>
                        </form:form>
                    </div>
                </div>
            </body>

            </html>
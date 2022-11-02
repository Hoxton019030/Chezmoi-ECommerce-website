<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <!-- <script src="https://code.jquery.com/jquery-3.6.1.js"
                integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
            <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script> -->

            <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
            <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
                rel="stylesheet" />

            <title>註冊</title>
            <link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet">

        </head>

        <body>

            <div id="login-box" style="width:40vw" class="bg-secondary">

                <form:form action="${pageContext.request.contextPath}/member/register" method="post"
                    modelAttribute="registersubmit">

                    <div>
                        <h1 class="text-dark" style="width: 100%;font-family: none;font-weight: bold;">Register</h1>
                        <h5 class="Msg">${param.Msg}</h5>
                        <form method="post" action="login.js">
                            <div>
                                <input type="text" class="text-field-Register" name="memberName" path="memberName"
                                    id="name" placeholder="中文姓名" minlength="2" required="required" autofocus
                                    oninput="setCustomValidity('');" oninvalid="setCustomValidity('請輸入正確的姓名');">
                            </div>

                            <div class="input-group date" id='birthday' style="width:80%;margin: auto;">
                                <input type="text" class="form-control  " placeholder="出生日期" name="birthday"
                                    id="birthday" path="birthday" required="required" inputmode="none"
                                    style="height: 20px; text-align:left;padding:0;color:rgb(51,51,51);margin-bottom:0.25rem;" />
                                <div class="input-group-addon" style="padding: 0px 4px;">
                                    <i class="glyphicon glyphicon-calendar"></i>
                                </div>
                            </div>

                            <div>
                                <input type="tel" class="text-field-Register" name="phone" path="phone" id="phone"
                                    placeholder="手機號碼" inputmode="tel" autocorrect="off" required="required"
                                    maxlength="10" pattern="09\d{2}\d{6}" oninput="setCustomValidity('');"
                                    oninvalid="setCustomValidity('請輸入正確的手機號碼格式：09xxxxxxxx');">
                            </div>


                            <div>
                                <input type="email" class="text-field-Register" name="email" path="email" id="email"
                                    placeholder="電子郵件" inputmode="email" autocorrect="off"
                                    pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="required"
                                    oninput="setCustomValidity('');"
                                    oninvalid="setCustomValidity('請輸入正確的email 例：abc@gmail.com')">
                            </div>

                            <div>
                                <input type="password" class="text-field-Register" name="password" path="password"
                                    id="password" placeholder="密碼" pattern="^(?=.*[a-zA-Z])(?=.*[0-9]).{6,}$"
                                    required="required" oninput="setCustomValidity('');"
                                    oninvalid="setCustomValidity('請輸入正確的密碼格式：需含英數至少六個字元')" required="required"
                                    autocomplete>
                            </div>
                            <p>
                            <div>
                                <input type="submit" id="btn_create_acc" class="btn-primary text-dark" value="註冊">
                            </div>
                            <p class="text-center">
                                <a href="${pageContext.request.contextPath}/member/login" id="customer_register_link"
                                    class="text-primary">登入帳號</a>
                            </p>
                            <p>
                                <a href="${pageContext.request.contextPath}/" class="text-primary">返回首頁</a>
                            </p>
                        </form>
                    </div>
                </form:form>
            </div>
            <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
            <script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
            <script
                src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

            <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
        </body>

        </html>
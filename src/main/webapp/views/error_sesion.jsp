<%@ page import="org.openqa.selenium.WebDriver" %>
<%@ page import="org.openqa.selenium.support.events.WebDriverEventListener" %>

<%
    WebDriver driver = (WebDriver) session.getAttribute("driver");

    driver.onPageLoad(new Runnable() {

        @Override
        public void run() {

            driver.clearHistory();

        }
        
    });

    driver.onPageLoad(new Runnable() {

        @Override
        public void run() {

            driver.deleteAllCookies();

        }

    });

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>error</title>
</head>
<body>

    <h1>DEBES INICIAR SESION TRAMPOSILL@</h1>

    <h1>¿QUIERES VOLVER AL LOGIN?</h1>

    <button><a href="/sapphire_inventory">DA CLICK AQUI</a></button> 
    
</body>
</html>
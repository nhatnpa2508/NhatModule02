<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 6/15/2019
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand:</td>
                <td><input name="firstNumber" type="text" placeholder="Số đầu tiên"></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td><select name="operator">
                        <option value="+">Addition(+)</option>
                        <option value="-">Subtraction(-)</option>
                        <option value="*">Multiplication(*)</option>
                        <option value="/">Division(/)</option>
                    </select></td>
            </tr>
            <tr>
                <td>Second operand:</td>
                <td><input name="secondNumber" type="text" placeholder="Số thứ hai"></td>
            </tr>
            <tr><td></td><td><input type="submit" value="Calculate"></td></tr>
        </table>
    </fieldset>
</form>
</body>
</html>

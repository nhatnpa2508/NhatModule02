<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhat
  Date: 7/9/2019
  Time: 5:21 PM
  Email: nhatnpa2508@gmail.com 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- jQuery library -->
    <script>
        function changeBase64() {
            var filesSelected = document.getElementById("image").files;
            if (filesSelected.length > 0) {
                var fileToLoad = filesSelected[0];
                var fileReader = new FileReader();
                fileReader.onload = function (fileLoadedEvent) {
                    var base64value = fileLoadedEvent.target.result;
                    document.getElementById("response").value = base64value;
                };
                fileReader.readAsDataURL(fileToLoad);
            }
        }
    </script>
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<form method="post">
    <fieldset>
        <legend><h2>CREATE Image</h2></legend>
        <table>
            <tr>
                <th>Image</th>
                <td>
                    <input type="file" id="image" name="image" placeholder="photo" accept="image/*;capture=camera"
                           single onchange="changeBase64()"/>
                </td>
            </tr>
            <tr>
                <th>Link</th>
                <td>
                    <input type="text" id="response" name="response" placeholder="Base-64 value"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create Image">
                </td>
                <td>
                    <a href="/images">Back to Image</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
    /*    Convert Image to Base64 - cách 2
        $(document).ready(function () {
            $("#image").change(function () {
                var filesSelected = document.getElementById("image").files;

                if (filesSelected.length > 0) {
                    var fileToLoad = filesSelected[0];
                    var fileReader = new FileReader();

                    fileReader.onload = function (fileLoadedEvent) {
                        var base64value = fileLoadedEvent.target.result;
                        //console.log(fileLoadedEvent.target.result);
                        //console.log(base64value);
                        $("#response").val(base64value);
                    };

                    fileReader.readAsDataURL(fileToLoad);
                }
            });
        });*/
</script>
</body>
</html>

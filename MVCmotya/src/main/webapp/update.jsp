<html>
<body>
<form action="/user" method="post">
    <h2>Write id and name:</h2>
    <label>Id:</label>
    <input type="number" name="userId" placeholder="Write id...">
    <label>Name:</label>
    <input type="text" name="userName" placeholder="Write name...">
    <label>Age:</label>
    <input type="number" name="userAge" placeholder="Write age...">
    <label>Email:</label>
    <input type="text" name="userEmail" placeholder="Write email...">
    </p>
    <p>
        <label><input type="checkbox" name="userNameCheckbox"> Update name</label>
        <label><input type="checkbox" name="userAgeCheckbox"> Update age</label>
        <label><input type="checkbox" name="userEmailCheckbox"> Update email</label>
    </p>
    <p>
        <button type="submit" name="updateButton">Update user</button>
        <button type="submit" name="home">Home</button>
    </p>
    <label>
        <td><b>${text}</b></td><br>
        <td><b>${textname}</b></td><br>
        <td><b>${textage}</b></td><br>
        <td><b>${textemail}</b></td>
    </label>
</form>
</body>
</html>

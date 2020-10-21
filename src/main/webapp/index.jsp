<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello, World!</title>
</head>
<body>
    <h1>Add Todo</h1>
    <form action="/" method="post">
        <label for="ftodo">Name:</label><br>
        <input type="text" id="ftodo" name="title" placeholder="Title" required><br><br>
        <label for="lcategory">Category</label><br>
        <input type="text" id="lcategory" name="category" placeholder="Category"><br><br>
        <label for="ldate">Due Date</label><br>
        <input type="date" id="ldate" name="date"><br><br>
        <input type="submit" value="Add Todo">
    </form>
    <h1>Todos</h1>
    ${todos}
</body>
</html>

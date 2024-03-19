<%--
  Created by IntelliJ IDEA.
  User: Abhishek
  Date: 03-03-2024
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Batch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="display-3 mb-2">Create Batch</h2>
    <hr class="mb-4">
    <form action="/createNewBatch" method="POST">
        <label class="form-label">Batch name</label>
        <input name="id" type="hidden" value="0">
        <input name="name" placeholder="Enter name" class="form-control w-25 mb-3" type="text" required>
        <label class="form-label">Start Date</label>
        <input name="startDate" type="date" class="form-control w-25 mb-3" required>
        <label class="form-label">End Date</label>
        <input name="endDate" type="date" class="form-control w-25 mb-3" required>
        <button class="btn btn-info col-1" type="submit">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-floppy-fill" viewBox="0 0 16 16">
                <path d="M0 1.5A1.5 1.5 0 0 1 1.5 0H3v5.5A1.5 1.5 0 0 0 4.5 7h7A1.5 1.5 0 0 0 13 5.5V0h.086a1.5 1.5 0 0 1 1.06.44l1.415 1.414A1.5 1.5 0 0 1 16 2.914V14.5a1.5 1.5 0 0 1-1.5 1.5H14v-5.5A1.5 1.5 0 0 0 12.5 9h-9A1.5 1.5 0 0 0 2 10.5V16h-.5A1.5 1.5 0 0 1 0 14.5z"/>
                <path d="M3 16h10v-5.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5zm9-16H4v5.5a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5zM9 1h2v4H9z"/>
            </svg>
            Save</button>
    </form>
</div>
</body>
</html>

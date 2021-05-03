<html>
<head>
    <title>Create</title>
</head>

<body>

<jsp:include page="_header.jsp"/>


<form action="/film/create" method="post">
    <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input type="text" name="title" class="form-control" id="title" aria-describedby="nameHelp">
    </div>
    <div class="mb-3">
        <label for="genre" class="form-label">Genre</label>
        <input type="text" name="genre" class="form-control" id="genre" aria-describedby="nameHelp">
    </div>
    <div class="mb-3">
        <label for="year" class="form-label">Year</label>
        <input type="number" name="year" min="1900" max="2021" class="form-control" id="year" aria-describedby="nameHelp">
    </div>
    <button type="submit" class="btn btn-primary">Create film</button>
</form>

</body>
</html>

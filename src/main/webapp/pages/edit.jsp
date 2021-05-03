<html>
<head>
    <title>Edit</title>
</head>

<body>

<jsp:include page="_header.jsp"/>



<form action="/film/edit" method="post">
    <input type="hidden" name="id" class="form-control" id="id" aria-describedby="nameHelp" value="${film.id}">
    <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input type="text" name="title" class="form-control" id="title" aria-describedby="nameHelp" value="${film.title}">
    </div>
    <div class="mb-3">
        <label for="genre" class="form-label">Genre</label>
        <input type="text" name="genre" class="form-control" id="genre" aria-describedby="nameHelp" value="${film.genre}">
    </div>
    <div class="mb-3">
        <label for="year" class="form-label">Title</label>
        <input type="number" name="year" min="1900" max="2021" class="form-control" id="year" aria-describedby="nameHelp" value="${film.year}">
    </div>
    <button type="submit" class="btn btn-primary">Edit film</button>
</form>

</body>
</html>

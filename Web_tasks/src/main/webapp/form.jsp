<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Form</title>
  </head>
  <body>
    <center>
      <h1>add new visit</h1>
      <form method="post" action="/visits">
        <p align="center">name</p>
        <input name="name">
        <p align="center">date</p>
        <input name="date">
        <p align="center">city</p>
        <input name="city">
        <br>
        <br>
        <button type="submit">submit</button>
      </form>
      <h1>
        <br>
        <a href=\visits>Back to list of visits</a>
      </h1>
    </center>
  </body>
</html>
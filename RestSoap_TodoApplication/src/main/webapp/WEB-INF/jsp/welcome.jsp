<script src="//ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<html>
    <head>
        <title>My first webapp</title>
    </head>
    <body>
        <p>Welcome ${name}!</p>
        <a href="/list-todos">Click here to get the list of todos.</a>
        <button onclick="processStrings()">Click here to process strings</button>
    </body>
    <script>
        function processStrings(){
            var titles = [];
            titles.push("title1");
            titles.push("title2");
            titles.push("title3");
            fetch('/test',{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(titles)
            })
                .then(response => response.json())
                .then(data => console.log(data))
                .catch(error => console.log("Error: " + error));
        }
    </script>
</html>

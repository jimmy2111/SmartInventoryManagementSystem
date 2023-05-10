<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <style type="text/css">
/* Reset default styles */
body, h1, h2, h3, p, ul, li {
    margin: 0;
    padding: 0;
}

/* Page layout */
body {
    font-family: Arial, sans-serif;
  
    background-color: #f2f2f2;
    
}

header {
    background-color: #333;
    color: #fff;
    padding: 20px;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

nav li {
    float: left;
}

nav li a {
    display: block;
    color: #fff;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

nav li a:hover {
    background-color: #111;
}

section {
    margin: 20px;
}

h1 {
    color: #333;
    font-size: 36px;
    margin-bottom: 20px;
    text-align: center;
}

h2 {
    color: #333;
    font-size: 24px;
    margin-bottom: 10px;
}

p {
    margin-bottom: 20px;
}

ul {
    list-style-type: none;
    margin-bottom: 20px;
}

li {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
}

li img {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    margin-right: 10px;
}

li h3 {
    font-size: 18px;
    color: #333;
}

li p {
    font-size: 14px;
    color: #666;
}

footer {
    background-color: #333;
    color: #fff;
    padding: 10px;
    text-align: center;
}

    </style>
    
</head>
<body>
    <header>
        <h1>About Us</h1>
    </header>
    <nav>
        <ul>
            <li><a href="Home">home</a></li>
            <li><a href="login">login</a></li>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
    </nav>
    <section>
        <h2>Our Story</h2>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas turpis non est vehicula, a cursus
            neque ullamcorper. Etiam sed consequat nisi. Sed et elit ut neque vestibulum vulputate vel eget turpis.
            Etiam ut enim vitae magna consectetur rutrum. Nullam congue, nisl id laoreet ullamcorper, nunc libero
            bibendum mi, a vestibulum massa libero vel purus. Proin bibendum laoreet velit, non tempus ligula.
            Vestibulum lacinia enim sit amet elit rutrum, a tristique nulla ullamcorper. Nullam convallis tortor
            nec auctor ullamcorper. Vestibulum volutpat urna vel turpis vestibulum, a scelerisque dolor feugiat.
        </p>
        <h2>Our Team</h2>
        <ul>
            <li>
                <img src="team_member1.jpg" alt="Team Member 1">
                <h3>John Doe</h3>
                <p>CEO</p>
            </li>
            <li>
                <img src="team_member2.jpg" alt="Team Member 2">
                <h3>Jane Smith</h3>
                <p>CFO</p>
            </li>
            <li>
                <img src="team_member3.jpg" alt="Team Member 3">
                <h3>Mike Johnson</h3>
                <p>CTO</p>
            </li>
        </ul>
    </section>
    <footer>
        <p>&copy; 2023 My Company. All rights reserved.</p>
    </footer>
</body>
</html>
